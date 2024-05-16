<template>
  <div class="app-container">
    <el-form :model="resource" :inline="true">
      <el-form-item label="资源分类ID">
        <el-input v-model="resource.categoryId" />
      </el-form-item>
      <el-form-item label="资源名称">
        <el-input v-model="resource.name" />
      </el-form-item>
      <el-form-item label="资源URL">
        <el-input v-model="resource.url" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSearch">查询</el-button>
        <el-button @click="resetFields()">重置</el-button>
      </el-form-item>
    </el-form>
    <el-table v-loading="listLoading" :data="resources">
      <el-table-column label="资源名称" align="center" prop="name" />
      <el-table-column label="资源URL" align="center" prop="url" />
      <el-table-column label="描述" align="center" prop="description" />
      <el-table-column label="资源分类ID" align="center" prop="categoryId" />
      <el-table-column label="创建时间" align="center" prop="createTime" />
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
import { fetchResources } from '@/api/resource/resource'

export default {
  data() {
    return {
      listLoading: true,
      resources: null,
      resource: {
        id: null,
        name: null,
        url: null,
        categoryId: -1
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
    this.getResources()
  },
  methods: {
    getResources() {
      fetchResources(this.pagination.pageSize, this.pagination.currentPage, this.resource).then((response) => {
        this.resources = response.records
        this.pagination.pageSize = response.size
        this.pagination.currentPage = response.current
        this.pagination.total = response.total
        this.listLoading = false
      })
    },
    resetFields() {
      this.resource.id = ''
      this.resource.create_time = ''
      this.resource.name = ''
      this.resource.url = ''
      this.resource.description = ''
      this.resource.category_id = -1
    },
    handleSizeChange(pageSize) {
      this.pagination.pageSize = pageSize
      this.getResources()
    },
    handleCurrentChange(currentPage) {
      this.pagination.currentPage = currentPage
      this.getResources()
    },
    onSearch() {
    }
  }
}

</script>

<style>

</style>
