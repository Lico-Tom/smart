<template>
  <div class="app-container">
    <el-form :model="resource" :inline="true" size="small">
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
    <el-table :data="resources">
      <el-table-column label="资源名称" prop="name" />
      <el-table-column label="资源URL" prop="url" />
      <el-table-column label="描述" prop="description" />
      <el-table-column label="资源分类ID" prop="categoryId" />
      <el-table-column label="创建时间" prop="createTime" />
      <el-table-column label="操作" fixed="right" prop="id">
        <template slot-scope="scope">
          <el-button type="text" @click="handleQueryClick(scope.row)">查看</el-button>
          <el-button type="text" @click="handleEditClick(scope.row)">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-dialog
      title="提示"
      :visible.sync="dialogVisible"
      width="30%"
      :before-close="handleClose">
      <span>这是一段信息</span>
      <span slot="footer" class="dialog-footer">
         <el-button @click="dialogVisible = false">取 消</el-button>
         <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
      </span>
    </el-dialog>
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
      dialogVisible: false,
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
    handleQueryClick(row) {
      this.dialogVisible = true
      console.log(row)
    },
    handleEditClick(row) {
      this.dialogVisible = true
      console.log(row)
    },
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
