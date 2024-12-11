<template>
  <div class="app-container">
    <el-form :model="mqtt" :inline="true" size="small">
      <el-form-item label="id">
        <el-input v-model="mqtt.id" />
      </el-form-item>
      <el-form-item label="mqtt地址">
        <el-input v-model="mqtt.mqttAddr" />
      </el-form-item>
      <el-form-item label="账号">
        <el-input v-model="mqtt.mqttUsername" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSearch">查询</el-button>
        <el-button @click="resetFields()">重置</el-button>
      </el-form-item>
    </el-form>
    <el-table v-loading="listLoading" :data="mqtts" size="small">
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="mqtt地址" align="center" prop="mqttAddr" />
      <el-table-column label="账号" align="center" prop="mqttUsername" />
      <el-table-column label="加密密码" align="center" prop="mqttPasswd" />
      <el-table-column label="连接超时时间" align="center" prop="connectTimeout" />
      <el-table-column label="存活时间" align="center" prop="keepaliveInterval" />
      <el-table-column label="自动尝试连接" align="center" prop="automaticReconnect" />
      <el-table-column label="重连是是否记住状态" align="center" prop="cleanSession" />
      <el-table-column label="描述" align="center" prop="mqttDescribe" />
      <el-table-column label="是否有效地址" align="center" prop="isValid" />
      <el-table-column label="创建时间" align="center" prop="detectionTime" />
      <el-table-column label="操作" fixed="right" prop="id">
        <template property="resource">
          <el-button type="text" size="small">查看</el-button>
          <el-button type="text" size="small">编辑</el-button>
        </template>
      </el-table-column>
      <!--      <Popup :visible="popupVisible" :content="resource.id" @close="closePopup" />-->
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
import { fetchMqtt } from '@/api/mqtt/mqtt'

export default {
  data() {
    return {
      listLoading: true,
      mqtts: null,
      mqtt: {
        id: null,
        mqttAddr: null,
        mqttUsername: null,
        mqttPasswd: null,
        connectTimeout: null,
        keepaliveInterval: null,
        automaticReconnect: null,
        cleanSession: null,
        mqttDescribe: null,
        isValid: null,
        detectionTime: null
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
    this.getMqtts()
  },
  methods: {
    getMqtts() {
      fetchMqtt(this.pagination.pageSize, this.pagination.currentPage, this.mqtt).then((response) => {
        this.mqtts = response.records
        this.pagination.pageSize = response.size
        this.pagination.currentPage = response.current
        this.pagination.total = response.total
        this.listLoading = false
      })
    },
    resetFields() {
      this.mqtt.id = null
      this.mqtt.mqttAddr = null
      this.mqtt.mqttUsername = null
    },
    handleSizeChange(pageSize) {
      this.pagination.pageSize = pageSize
      this.getMqtts()
    },
    handleCurrentChange(currentPage) {
      this.pagination.currentPage = currentPage
      this.getMqtts()
    },
    onSearch() {
      this.getMqtts()
    }
  }
}

</script>

<style>

</style>
