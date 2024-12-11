<template>
  <div class="app-container">
    <el-form :model="task" :inline="true" size="small">
      <el-form-item label="id">
        <el-input v-model="task.id" />
      </el-form-item>
      <el-form-item label="任务名称">
        <el-input v-model="task.taskName" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSearch">查询</el-button>
        <el-button @click="resetFields()">重置</el-button>
      </el-form-item>
    </el-form>
    <el-table v-loading="listLoading" :data="tasks" size="small">
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="任务名称" align="center" prop="taskName" />
      <el-table-column label="定时任务表达式" align="center" prop="cronExpression" />
      <el-table-column label="详情" align="center" prop="details" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
      <el-table-column label="更新时间" align="center" prop="modifyTime" />
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
import { fetchTasks } from '@/api/task/scheduleTask'

export default {
  data() {
    return {
      listLoading: true,
      tasks: null,
      task: {
        id: null,
        taskName: null,
        cronExpression: null,
        details: null,
        createTime: null,
        modifyTime: null
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
    this.getFetchTasks()
  },
  methods: {
    getFetchTasks() {
      fetchTasks(this.pagination.pageSize, this.pagination.currentPage, this.task).then((response) => {
        this.tasks = response.records
        this.pagination.pageSize = response.size
        this.pagination.currentPage = response.current
        this.pagination.total = response.total
        this.listLoading = false
      })
    },
    resetFields() {
      this.task.id = null
      this.task.taskName = null
    },
    handleSizeChange(pageSize) {
      this.pagination.pageSize = pageSize
      this.getFetchTasks()
    },
    handleCurrentChange(currentPage) {
      this.pagination.currentPage = currentPage
      this.getFetchTasks()
    },
    onSearch() {
      this.getFetchTasks()
    }
  }
}

</script>

<style>

</style>
