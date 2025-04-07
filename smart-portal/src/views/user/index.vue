<template>
  <div class="app-container">
    <el-form :model="user" :inline="true" size="small">
      <el-form-item label="用户名">
        <el-input v-model="user.username" />
      </el-form-item>
      <el-form-item label="邮件">
        <el-input v-model="user.email" />
      </el-form-item>
      <el-form-item label="昵称">
        <el-input v-model="user.nickName" />
      </el-form-item>
      <el-form-item label="用户状态">
        <el-select v-model="user.status" value="正常" placeholder="用户状态">
          <el-option label="全部" :value="-1" />
          <el-option label="注销" :value="0" />
          <el-option label="正常" :value="1" />
        </el-select>
      </el-form-item>
      <el-form-item>
        <ButtonGroup
          :query-handle="handleQuery()"
          :query-shown="true"
          :reset-handle="resetFields"
          :reset-shown="true"
        />
      </el-form-item>

    </el-form>
    <el-table v-loading="listLoading" :data="users" size="small">
      <el-table-column label="用户名" align="center" prop="username" />
      <el-table-column label="头像" align="center" prop="icon" />
      <el-table-column label="邮件" align="center" prop="email" />
      <el-table-column label="昵称" align="center" prop="nickName" />
      <el-table-column label="note" align="center" prop="note" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="修改时间" align="center" prop="loginTime" />
      <el-table-column label="用户状态" align="center" prop="status" :formatter="statusFormatter" />
      <el-table-column label="操作" fixed="right" prop="id">
        <template property="user">
          <el-button type="text" size="small" @click="showPopup()">查看</el-button>
          <el-button type="text" size="small">编辑</el-button>
        </template>
      </el-table-column>
      <Popup :visible="popupVisible" :content="user.id" @close="closePopup" />
    </el-table>

    <div class="block">
      <el-pagination
        :current-page="pagination.currentPage"
        :page-sizes="[5, 20, 50, 38]"
        :page-size="pagination.pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="pagination.total"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
      />
    </div>
  </div>
</template>

<script>
import { fetchUsers } from '@/api/user'
import Popup from '@/views/user/UserDialog'
import ButtonGroup from '@/components/ButtonGroup/index'
export default {
  components: {
    Popup,
    ButtonGroup
  },
  data() {
    return {
      users: null,
      listLoading: true,
      buttonConfig: {
        applicationButton: {
          handle: this.handleApplication,
          disabled: true,
          isShow: false
        },
        editButton: {
          handle: this.handleEdit,
          disabled: false,
          isShow: false
        },
        queryButton: {
          handle: this.handleQuery,
          disabled: false,
          isShow: true
        },
        cancelButton: {
          handle: this.handleCancel,
          disabled: false,
          isShow: false
        },
        resetButton: {
          handle: this.handleReset,
          disabled: false,
          isShow: true
        }
      },
      user_status: {
        1: '在线',
        2: 'aa'
      },
      user: {
        id: '',
        username: '',
        email: '',
        nickName: '',
        note: '',
        status: -1
      },
      pagination: {
        currentPage: 1,
        pageSize: 5
      },
      popupVisible: false,
      popupContent: '这是一个弹窗'
    }
  },
  created() {
    this.getUsers()
  },
  methods: {
    getUsers() {
      fetchUsers(this.pagination.pageSize, this.pagination.currentPage, this.user).then((response) => {
        this.users = response.records
        this.pagination.pageSize = response.size
        this.pagination.currentPage = response.current
        this.pagination.total = response.total
        this.listLoading = false
      })
    },
    handleSizeChange(pageSize) {
      this.pagination.pageSize = pageSize
      this.getUsers()
    },
    handleCurrentChange(currentPage) {
      this.pagination.currentPage = currentPage
      this.getUsers()
    },
    onSearch() {
      this.getUsers()
    },
    handleApplication() {
    },
    handleEdit() {
    },
    handleQuery() {
    },
    handleCancel() {
    },
    handleReset() {
    },
    resetFields() {
      this.user.id = ''
      this.user.username = ''
      this.user.email = ''
      this.user.nickName = ''
      this.user.note = ''
      this.user.statu = -1
    },
    statusFormatter(row, column, cellValue) {
      const statusMap = {
        1: '启用',
        0: '禁用'
      }
      return statusMap[cellValue] || '未知'
    },
    showPopup() {
      this.popupVisible = true
    },
    closePopup() {
      this.popupVisible = false
    }
  }
}

</script>

<style>

</style>
