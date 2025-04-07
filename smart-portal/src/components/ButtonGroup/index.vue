<template>
  <div>
    <el-button v-if="applicationShown" type="danger" size="small" @click="handleClick(applicationHandle)">应用</el-button>
    <el-button v-if="editShown" type="success" size="small" @click="handleClick(editHandle)">编辑</el-button>
    <el-button v-if="queryShown" type="primary" size="small" @click="handleClick(queryHandle)">查询</el-button>
    <el-button v-if="cancelShown" type="info" size="small" @click="handleClick(cancelHandle)">取消</el-button>
    <el-button v-if="resetShown" type="info" size="small" @click="handleClick(resetHandle)">重置</el-button>
  </div>
</template>

<script>

export default {
  name: 'ButtonGroup',
  props: {
    applicationHandle: {
      type: Function,
      required: false,
      default: () => {}
    },
    editHandle: {
      type: Function,
      required: false,
      default: () => {}
    },
    queryHandle: {
      type: Function,
      required: false,
      default: () => {}
    },
    cancelHandle: {
      type: Function,
      required: false,
      default: () => {}
    },
    resetHandle: {
      type: Function,
      required: false,
      default: () => {}
    },
    applicationShown: {
      type: Boolean,
      required: false,
      default: false
    },
    editShown: {
      type: Boolean,
      required: false,
      default: false
    },
    queryShown: {
      type: Boolean,
      required: false,
      default: false
    },
    cancelShown: {
      type: Boolean,
      required: false,
      default: false
    },
    resetShown: {
      type: Boolean,
      required: false,
      default: false
    }
  },
  methods: {
    handleClick(handle) {
      if (typeof handle === 'function') {
        handle()
      }
    }
  }
}
</script>

<style>
/* 你可以在这里添加自定义样式 */
</style>
