<template>
  <div class="app-container">
    <el-form :model="user" :inline="true">
      <el-form-item label="id">
        <el-input v-model="user.id" />
      </el-form-item>
      <el-form-item label="用户名">
        <el-input v-model="user.username" />
      </el-form-item>
      <el-form-item label="邮件">
        <el-input v-model="user.email" />
      </el-form-item>
      <el-form-item label="昵称">
        <el-input v-model="user.nickName" />
      </el-form-item>
      <el-form-item label="note">
        <el-input v-model="user.note" />
      </el-form-item>
      <el-form-item label="用户状态">
        <el-select v-model="user.status" value="正常" placeholder="用户状态">
          <el-option label="全部" :value="-1" />
          <el-option label="注销" :value="0" />
          <el-option label="正常" :value="1" />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSearch">查询</el-button>
        <el-button @click="resetFields()">重置</el-button>
      </el-form-item>
    </el-form>
  </div></template>

<script>
export default {
  name: 'PigState',
  data() {
    return {
      pigState: {
        id: '',
        parent: '',
        startWeight: -1,
        endWeight: -1,
        price: -1,
        purchaser: '',
        phoneNumber: -1,
        spend: -1,
        pigstyNumber: -1,
        birthday: '',
        sellDate: '',
        bills: ''
      }
    }
  }
}
</script>

<style scoped>

</style>
