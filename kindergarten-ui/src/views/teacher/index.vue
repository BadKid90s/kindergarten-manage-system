<template>
  <div class="app-container">
    <el-row>
      <el-form :inline="true" :model="searchParams" class="demo-form-inline">
        <el-form-item label="姓名">
          <el-input v-model="searchParams.name" placeholder="姓名" />
        </el-form-item>
        <el-form-item label="性别">
          <el-select v-model="searchParams.gender" placeholder="性别">
            <el-option label="全部" value="" />
            <el-option label="男" :value="1" />
            <el-option label="女" :value="2" />
          </el-select>
        </el-form-item>
        <el-form-item label="爱好">
          <el-input v-model="searchParams.hobbyTag" placeholder="爱好" />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">查询</el-button>
        </el-form-item>
        <el-form-item style="float: right; ">
          <el-button type="success" @click="handleSave">新增</el-button>
        </el-form-item>
      </el-form>
    </el-row>
    <el-table
      v-loading="listLoading"
      :data="list"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row
    >
      <el-table-column
        prop="name"
        label="姓名"
        width="180"
        align="center"
      />
      <el-table-column
        prop="gender"
        label="性别"
        width="180"
        align="center"
      >
        <template slot-scope="scope">
          {{ scope.row.gender === 1 ? '男' : '女' }}
        </template>
      </el-table-column>
      <el-table-column
        prop="age"
        label="年龄"
        width="180"
        align="center"
      />
      <el-table-column
        prop="hobbyTag"
        label="爱好"
        align="left"
      />
      <el-table-column
        prop="biography"
        label="个人简介"
        align="left"
      />
      <el-table-column class-name="status-col" label="Status" width="180" align="center">
        <template slot-scope="scope">
          <el-button size="small" type="warning" @click="handleUpdate(scope.row)">修改</el-button>
          <el-button size="small" type="danger" style="margin-left: 20px" @click="handleDelete(scope.row.id)">删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      :current-page="pageInfo.pageNum"
      :page-size="pageInfo.pageSize"
      :total="pageInfo.total"
      layout="total,sizes, jumper, -> ,prev, pager, next"
      @current-change="val=>pageInfo.pageSize=val"
      @size-change="val=>pageInfo.pageNum=val"
    />

    <el-dialog
      title="提示"
      :visible.sync="dialogVisible"
      width="50%"
      :before-close="handleClose"
    >
      <el-form ref="teacherForm" :model="teacherForm" label-width="80px">
        <el-form-item label="姓名">
          <el-input v-model="teacherForm.name" />
        </el-form-item>
        <el-form-item label="年龄">
          <el-input v-model="teacherForm.age" />
        </el-form-item>
        <el-form-item label="性别">
          <el-select v-model="teacherForm.gender" placeholder="性别" style="width: 100%">
            <el-option label="男" :value="1" />
            <el-option label="女" :value="2" />
          </el-select>
        </el-form-item>
        <el-form-item label="爱好">
          <el-input v-model="teacherForm.hobbyTag" />
        </el-form-item>
        <el-form-item label="个人简介">
          <el-input v-model="teacherForm.biography" type="textarea" />
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="handleCancel">取 消</el-button>
        <el-button type="primary" @click="handleSubmit">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { getList, modify, remove, save } from '@/api/teacher'
import { Message } from 'element-ui'

export default {
  components: {},
  data() {
    return {
      list: null,
      listLoading: true,
      searchParams: {
        name: null,
        gender: null,
        hobbyTag: null
      },
      pageInfo: {
        pageNum: 1,
        pageSize: 20,
        total: 1
      },
      formInline: {
        user: '',
        region: ''
      },
      teacherForm: {
        name: null,
        age: null,
        gender: 1,
        hobbyTag: null,
        biography: null
      },
      dialogVisible: false,
      isUpdate: false
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.listLoading = true
      const { pageNum, pageSize } = this.pageInfo
      if (this.searchParams.gender === '') {
        this.searchParams.gender = null
      }
      getList({ ...this.searchParams, pageNum, pageSize }).then(response => {
        this.list = response.data.list
        this.listLoading = false
      })
    },
    onSubmit() {
      this.fetchData()
    },
    handleSave() {
      this.dialogVisible = true
    },
    handleUpdate(val) {
      this.isUpdate = true
      this.teacherForm = Object.assign(this.teacherForm, val)
      this.dialogVisible = true
    },
    handleDelete(id) {
      remove({ ids: [id] }).then(response => {
        Message.success('操作成功！')
      })
      this.fetchData()
    },
    handleClose(done) {
      done()
      this.isUpdate = false
      this.dialogVisible = false
    },
    handleCancel() {
      this.isUpdate = false
      this.dialogVisible = false
    },
    handleSubmit() {
      if (this.isUpdate) {
        this.isUpdate = false
        modify(this.teacherForm).then(() => {
          Message.success('操作成功！')
        })
      } else {
        save(this.teacherForm).then(() => {
          Message.success('操作成功！')
        })
      }
      this.dialogVisible = false
      this.teacherForm = {
        name: null,
        age: null,
        gender: null,
        hobbyTag: null,
        biography: null
      }
      this.fetchData()
    }
  }
}
</script>
