<template>
  <div class="dashboard-container">
    <PanelGroup />
    <el-row style="background:#fff;padding:16px 16px 0;margin-bottom:32px;">
      <Recipe />
    </el-row>
    <el-row style="background:#fff;padding:16px 16px 0;margin-bottom:32px;">
      <ClockingIn />
    </el-row>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import PanelGroup from './compoments/PanelGroup.vue'
import ClockingIn from './compoments/ClockingIn.vue'
import Recipe from './compoments/Recipe.vue'
export default {
  name: 'Dashboard',
  components: {
    PanelGroup,
    ClockingIn,
    Recipe
  },
  computed: {
    ...mapGetters([
      'name'
    ])
  }
}
</script>

<style lang="scss" scoped>
.dashboard {
  &-container {
    margin: 30px;
  }
  &-text {
    font-size: 30px;
    line-height: 46px;
  }
}
</style>
