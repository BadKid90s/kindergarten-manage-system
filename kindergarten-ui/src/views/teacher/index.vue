<template>
  <div class="app-container">
    <el-row>
      <el-form :inline="true" :model="searchParams" class="demo-form-inline">
        <el-form-item label="姓名">
          <el-input v-model="searchParams.name" placeholder="姓名"></el-input>
        </el-form-item>
        <el-form-item label="性别">
          <el-select v-model="searchParams.gender" placeholder="性别">
            <el-option label="男" value="1"></el-option>
            <el-option label="女" value="2"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="爱好">
          <el-input v-model="searchParams.hobbyTag" placeholder="爱好"></el-input>
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
      >
      </el-table-column>
      <el-table-column
        prop="gender"
        label="性别"
        width="180"
        align="center"
      >
      </el-table-column>
      <el-table-column
        prop="age"
        label="年龄"
        width="180"
        align="center"
      >
      </el-table-column>
      <el-table-column
        prop="hobbyTag"
        label="爱好"
        align="left"
      >
      </el-table-column>
      <el-table-column
        prop="biography"
        label="个人简介"
        align="left"
      >
      </el-table-column>
      <el-table-column class-name="status-col" label="Status" width="180" align="center">
        <template slot-scope="scope">
          <el-button size="small" type="warning" @click="handleUpdate(scope)">修改</el-button>
          <el-button size="small" type="danger" @click="handleDelete(scope.id)" style="margin-left: 20px">删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="val=>pageInfo.pageNum=val"
      @current-change="val=>pageInfo.pageSize=val"
      :current-page="pageInfo.pageNum"
      :page-size="pageInfo.pageSize"
      layout="total,sizes, jumper, -> ,prev, pager, next"
      :total="pageInfo.total"
    >
    </el-pagination>

    <el-dialog
      title="提示"
      :visible.sync="dialogVisible"
      width="50%"
      :before-close="handleClose"
    >
      <el-form ref="teacherForm" :model="teacherForm" label-width="80px">
        <el-form-item label="姓名">
          <el-input v-model="teacherForm.name"></el-input>
        </el-form-item>
        <el-form-item label="年龄">
          <el-input v-model="teacherForm.age"></el-input>
        </el-form-item>
        <el-form-item label="性别">
          <el-select v-model="teacherForm.gender" placeholder="性别" style="width: 100%">
            <el-option label="男" value="1"></el-option>
            <el-option label="女" value="2"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="爱好">
          <el-input v-model="teacherForm.hobbyTag"></el-input>
        </el-form-item>
        <el-form-item label="个人简介">
          <el-input type="textarea" v-model="teacherForm.biography"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="handleCancel">取 消</el-button>
        <el-button type="primary" @click="handleSubmit = false">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { getList, remove, save, modify } from '@/api/teacher'
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
        pageNum: 100,
        pageSize: 20,
        total: 1000
      },
      formInline: {
        user: '',
        region: ''
      },
      teacherForm: {
        name: null,
        age: null,
        gender: null,
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
      getList({ ...this.searchParams, pageNum, pageSize }).then(response => {
        this.list = response.data.items
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
      remove({ id }).then(response => {
        Message.error('操作成功！')
      })
    },
    handleClose(done) {
      if (this.isUpdate) {
        this.isUpdate = false
      }
      done()
      this.dialogVisible = false
    },
    handleCancel() {
      if (this.isUpdate) {
        this.isUpdate = false
      }
      this.dialogVisible = false
    },
    handleSubmit() {
      if (this.isUpdate) {
        this.isUpdate = false
        modify(this.teacherForm).then(() => {
          Message.error('操作成功！')
        })
      } else {
        save(this.teacherForm).then(() => {
          Message.error('操作成功！')
        })
      }
      this.teacherForm = {
        name: null,
        age: null,
        gender: null,
        hobbyTag: null,
        biography: null
      }
    }
  }
}
</script>
