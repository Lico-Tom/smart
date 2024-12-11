<template>
  <div>
    <el-button v-if="buttons.applicationButton.isShow" type="danger" size="small" :disabled="buttons.applicationButton.disabled" @click="handleClick(buttons.applicationButton.handle)">应用</el-button>
    <el-button v-if="buttons.editButton.isShow" type="success" size="small" :disabled="buttons.editButton.disabled" @click="handleClick(buttons.editButton.handle)">编辑</el-button>
    <el-button v-if="buttons.queryButton.isShow" type="primary" size="small" :disabled="buttons.queryButton.disabled" @click="handleClick(buttons.queryButton.handle)">查询</el-button>
    <el-button v-if="buttons.cancelButton.isShow" size="small" :disabled="buttons.cancelButton.disabled" @click="handleClick(buttons.cancelButton.handle)">取消</el-button>
    <el-button v-if="buttons.resetButton.isShow" type="primary" size="small" :disabled="buttons.resetButton.disabled" @click="handleClick(buttons.resetButton.handle)">重置</el-button>
  </div>
</template>

<script>

export default {
  name: 'ButtonGroup',
  props: {
    buttons: {
      type: Object,
      required: true,
      default: () => ({
        applicationButton: {
          handle: Function,
          disabled: false,
          isShow: true
        },
        editButton: {
          handle: Function,
          disabled: false,
          isShow: true
        },
        queryButton: {
          handle: Function,
          disabled: false,
          isShow: true
        },
        cancelButton: {
          handle: Function,
          disabled: false,
          isShow: true
        },
        resetButton: {
          handle: Function,
          disabled: false,
          isShow: true
        }
      }),
      validator: value => {
        return ['applicationButton', 'editButton', 'queryButton', 'cancelButton', 'resetButton'].every(key => {
          return typeof value[key].handle === 'function' &&
            typeof value[key].disabled === 'boolean' &&
            typeof value[key].isShow === 'boolean'
        })
      }
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
