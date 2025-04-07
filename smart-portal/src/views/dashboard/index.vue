<template>
  <el-dialog :visible="true" fullscreen custom-class="fullscreen-dialog">
    <el-container class="body-image">
      <el-header class="header-image">大数据可视化系统数据分析通用模版</el-header>
      <el-aside width="30%">
        <el-card>
          <EchartComponent />
        </el-card>
      </el-aside>
      <el-main>Main</el-main>
      <el-main>Main</el-main>
      <el-main>Main</el-main>
    </el-container>
  </el-dialog>
</template>

<script>
import EchartComponent from './EchartComponent.vue'
export default {
  components: {
    EchartComponent
  }
}
</script>

<style scoped>
/* 使用深度选择器调整 el-dialog 的样式 */
::v-deep .fullscreen-dialog {
  background: #f0f0f0; /* 设置背景颜色 */
  padding: 0; /* 移除内边距 */
}

::v-deep .fullscreen-dialog .el-dialog__header {
  display: none; /* 隐藏对话框头部 */
}

::v-deep .fullscreen-dialog .el-dialog__body {
  padding: 0; /* 移除内边距 */
  height: 100%; /* 确保主体占满整个高度 */
}

::v-deep .fullscreen-dialog .el-dialog__footer {
  display: none; /* 隐藏对话框底部 */
}
.body-image {
  background-image: url('../../assets/images/bg.jpg');
  height: 100%;
  width: 100%;
}
.header-image {
  background-image: url('../../assets/images/head_bg.png');
  height: 100%;
  width: 100%;
  font-size: 30px;
  color: white;
  margin-top: 10px;
  text-align: center;
}
</style>
