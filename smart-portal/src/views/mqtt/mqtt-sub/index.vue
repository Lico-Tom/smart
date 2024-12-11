<template>
  <div class="app-container">
    <el-form :model="mqttSub" :inline="true" size="small">
      <el-form-item label="mqtt的id">
        <el-input v-model="mqttSub.mqttId" />
      </el-form-item>
      <el-form-item label="发布主题名">
        <el-input v-model="mqttSub.mqttTopic" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSearch">查询</el-button>
        <el-button @click="resetFields()">重置</el-button>
      </el-form-item>
    </el-form>
    <el-table v-loading="listLoading" :data="mqttSubs" size="small">
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="mqtt的id" align="center" prop="mqttId" />
      <el-table-column label="发布主题名" align="center" prop="mqttTopic" />
      <el-table-column label="订阅模式" align="center" prop="mqttQos" />
      <el-table-column label="是否有效发布主题" align="center" prop="isValid" />
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
import { fetchMqttSub } from '@/api/mqtt/mqttSub'

export default {
  data() {
    return {
      listLoading: true,
      mqttSubs: null,
      mqttSub: {
        id: null,
        mqttId: null,
        mqttTopic: null,
        mqttQos: null,
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
    this.getmqttSubs()
  },
  methods: {
    getmqttSubs() {
      fetchMqttSub(this.pagination.pageSize, this.pagination.currentPage, this.mqttSub).then((response) => {
        this.mqttSubs = response.records
        this.pagination.pageSize = response.size
        this.pagination.currentPage = response.current
        this.pagination.total = response.total
        this.listLoading = false
      })
    },
    resetFields() {
      this.mqttSub.mqttId = null
      this.mqttSub.mqttTopic = null
    },
    handleSizeChange(pageSize) {
      this.pagination.pageSize = pageSize
      this.getmqttSubs()
    },
    handleCurrentChange(currentPage) {
      this.pagination.currentPage = currentPage
      this.getmqttSubs()
    },
    onSearch() {
      this.getmqttSubs()
    }
  }
}

</script>

<style>

</style>
