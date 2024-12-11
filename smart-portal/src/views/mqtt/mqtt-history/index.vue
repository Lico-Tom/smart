<template>
  <div class="app-container">
    <el-form :model="fetchMqttHistory" :inline="true" size="small">
      <el-form-item label="订阅者的ip">
        <el-input v-model="fetchMqttHistory.subIp" />
      </el-form-item>
      <el-form-item label="消费者的ip">
        <el-input v-model="fetchMqttHistory.pubIp" />
      </el-form-item>
      <el-form-item label="发布主题名">
        <el-input v-model="fetchMqttHistory.mqttTopic" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSearch">查询</el-button>
        <el-button @click="resetFields()">重置</el-button>
      </el-form-item>
    </el-form>
    <el-table v-loading="listLoading" :data="fetchMqttHistories" size="small">
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="订阅者的ip" align="center" prop="subIp" />
      <el-table-column label="消费者的ip" align="center" prop="pubIp" />
      <el-table-column label="发布主题名" align="center" prop="mqttTopic" />
      <el-table-column label="订阅模式" align="center" prop="mqttQos" />
      <el-table-column label="是否发送或接收成功" align="center" prop="isSuccess" />
      <el-table-column label="发送或接收的消息" align="center" prop="mqttMsg" />
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
import { fetchMqttHistory } from '@/api/mqtt/mqttHistory'

export default {
  data() {
    return {
      listLoading: true,
      fetchMqttHistories: null,
      fetchMqttHistory: {
        id: null,
        subIp: null,
        pubIp: null,
        mqttTopic: null,
        mqttQos: null,
        isSuccess: null,
        mqttMsg: null,
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
    this.getfetchMqttHistory()
  },
  methods: {
    getfetchMqttHistory() {
      fetchMqttHistory(this.pagination.pageSize, this.pagination.currentPage, this.fetchMqttHistory).then((response) => {
        this.fetchMqttHistories = response.records
        this.pagination.pageSize = response.size
        this.pagination.currentPage = response.current
        this.pagination.total = response.total
        this.listLoading = false
      })
    },
    resetFields() {
      this.fetchMqttHistory.subIp = null
      this.fetchMqttHistory.pubIp = null
      this.fetchMqttHistory.mqttTopic = null
    },
    handleSizeChange(pageSize) {
      this.pagination.pageSize = pageSize
      this.getfetchMqttHistory()
    },
    handleCurrentChange(currentPage) {
      this.pagination.currentPage = currentPage
      this.getfetchMqttHistory()
    },
    onSearch() {
      this.getfetchMqttHistory()
    }
  }
}

</script>

<style>

</style>
