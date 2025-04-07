<template>
  <div>
    <el-button v-if="editShown" type="text" size="small" @click="handleClick(editHandle)">编辑</el-button>
    <el-button v-if="queryShown" type="text" size="small" @click="handleClick(queryHandle)">查询</el-button>
    <el-button v-if="deleteShown" type="text" size="small" @click="handleClick(deleteHandle)">删除</el-button>
  </div>
</template>

<script>

export default {
  name: 'NoBorderButtonGroup',
  props: {
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
    deleteHandle: {
      type: Function,
      required: false,
      default: () => {}
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
    deleteShown: {
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
