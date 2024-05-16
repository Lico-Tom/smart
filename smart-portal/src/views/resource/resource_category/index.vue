<template>
  <div class="app-container">
    <el-form :model="resourceCategory" :inline="true">
      <el-form-item label="资源分类ID">
        <el-input v-model="resourceCategory.name" />
      </el-form-item>
      <el-form-item label="资源名称">
        <el-input v-model="resourceCategory.sort" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSearch">查询</el-button>
        <el-button @click="resetFields()">重置</el-button>
      </el-form-item>
    </el-form>
    <el-table v-loading="listLoading" :data="resourceCategorys">
      <el-table-column label="资源名称" align="center" prop="name" />
      <el-table-column label="资源URL" align="center" prop="sort" />
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
import { fetchResourcesCategory } from '@/api/resource/resourceCategory'

export default {
  data() {
    return {
      listLoading: true,
      resourceCategorys: null,
      resourceCategory: {
        id: null,
        name: null,
        sort: null,
        createTime: null
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
    this.getResourceCategorys()
  },
  methods: {
    getResourceCategorys() {
      fetchResourcesCategory(this.pagination.pageSize, this.pagination.currentPage, this.resourceCategory).then((response) => {
        this.resourceCategorys = response.records
        this.pagination.pageSize = response.size
        this.pagination.currentPage = response.current
        this.pagination.total = response.total
        this.listLoading = false
      })
    },
    resetFields() {
      this.resourceCategory.id = null
      this.resourceCategory.name = null
      this.resourceCategory.sort = null
      this.resourceCategory.createTime = null
    },
    handleSizeChange(pageSize) {
      this.pagination.pageSize = pageSize
      this.getResourceCategorys()
    },
    handleCurrentChange(currentPage) {
      this.pagination.currentPage = currentPage
      this.getResourceCategorys()
    },
    onSearch() {
    }
  }
}

</script>

<style>

</style>
