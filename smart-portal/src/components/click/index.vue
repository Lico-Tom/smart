<template>
  <div>
    <h1>父组件</h1>
    <ButtonGroup :buttons="buttonList" />
  </div>
</template>

<script>
import ButtonGroup from '@/components/ButtonGroup/index.vue'

export default {
  name: 'ParentComponent',
  components: {
    ButtonGroup
  },
  data() {
    return {
      buttonList: [
        { text: '按钮一', type: 'primary', handler: this.buttonOneHandler },
        { text: '按钮二', type: 'primary', handler: this.buttonTwoHandler },
        { text: '按钮三', type: 'primary', handler: this.buttonThreeHandler }
      ]
    }
  },
  methods: {
    buttonOneHandler() {
      console.log('按钮一被点击')
    },
    buttonTwoHandler() {
      console.log('按钮二被点击')
    },
    buttonThreeHandler() {
      console.log('按钮三被点击')
    }
  }
}
</script>

<style>
/* 你可以在这里添加自定义样式 */
</style>
