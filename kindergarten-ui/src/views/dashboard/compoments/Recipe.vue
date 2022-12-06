<template>
  <el-row v-loading="isLoading" :gutter="40" class="group">
    <el-carousel indicator-position="outside" height="550px">
      <el-carousel-item v-for="(item,index) in dataList" :key="index">
        <p style="text-align: center">{{ item.name + '食谱' }}</p>
        <div class="block">
          <el-timeline>
            <el-timeline-item timestamp="08:00-09:00" placement="top">
              <el-card>
                <h4>早餐</h4>
                <p>{{ item.breakfast }}</p>
              </el-card>
            </el-timeline-item>
            <el-timeline-item timestamp="12:00-13:00" placement="top">
              <el-card>
                <h4>午餐</h4>
                <p>{{ item.lunch }}</p>
              </el-card>
            </el-timeline-item>
            <el-timeline-item timestamp="16:00-17:00" placement="top">
              <el-card>
                <h4>晚餐</h4>
                <p>{{ item.dinner }}</p>
              </el-card>
            </el-timeline-item>
          </el-timeline>
        </div>
      </el-carousel-item>
    </el-carousel>
  </el-row>
</template>

<script>
import { getRecipe } from '@/api/index'

export default {
  name: 'Recipe',
  data() {
    return {
      isLoading: true,
      dataList: [
        {
          breakfast: '小笼包、油条、豆浆、面包',
          lunch: '小炒肉',
          dinner: '臊子面',
          sort: 1,
          name: '星期一'
        },
        {
          breakfast: '小笼包、油条、豆浆、面包',
          lunch: '小炒肉',
          dinner: '臊子面',
          sort: 1,
          name: '星期二'
        }
      ]
    }
  },
  created() {
    this.handleInitData()
  },
  methods: {
    handleInitData() {
      getRecipe().then(response => {
        this.dataList = response.data.sort(item => item.sort)
        this.isLoading = false
      })
    }
  }
}
</script>

<style lang="scss" scoped>
</style>
