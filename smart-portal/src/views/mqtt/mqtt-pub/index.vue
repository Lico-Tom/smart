<template>
  <div class="app-container">
    <el-form :model="mqttPub" :inline="true" size="small">
      <el-form-item label="mqtt的id">
        <el-input v-model="mqttPub.mqttId" />
      </el-form-item>
      <el-form-item label="发布主题名">
        <el-input v-model="mqttPub.mqttTopic" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSearch">查询</el-button>
        <el-button @click="resetFields()">重置</el-button>
      </el-form-item>
    </el-form>
    <el-table v-loading="listLoading" :data="mqttPubs" size="small">
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="mqtt的id" align="center" prop="mqttId" />
      <el-table-column label="发布主题名" align="center" prop="mqttTopic" />
      <el-table-column label="订阅模式" align="center" prop="mqttQos" />
      <el-table-column label="是否有效发布主题" align="center" prop="isValid" />
      <el-table-column label="控制等级" align="center" prop="level" />
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
import { fetchMqttPub } from '@/api/mqtt/mqttPub'

export default {
  data() {
    return {
      listLoading: true,
      mqttPubs: null,
      mqttPub: {
        id: null,
        mqttId: null,
        mqttTopic: null,
        mqttQos: null,
        isValid: null,
        level: null,
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
    this.getMqttPubs()
  },
  methods: {
    getMqttPubs() {
      fetchMqttPub(this.pagination.pageSize, this.pagination.currentPage, this.mqttPub).then((response) => {
        this.mqttPubs = response.records
        this.pagination.pageSize = response.size
        this.pagination.currentPage = response.current
        this.pagination.total = response.total
        this.listLoading = false
      })
    },
    resetFields() {
      this.mqttPub.mqttId = null
      this.mqttPub.mqttTopic = null
    },
    handleSizeChange(pageSize) {
      this.pagination.pageSize = pageSize
      this.getMqttPubs()
    },
    handleCurrentChange(currentPage) {
      this.pagination.currentPage = currentPage
      this.getMqttPubs()
    },
    onSearch() {
      this.getMqttPubs()
    }
  }
}

</script>

<style>

</style>
