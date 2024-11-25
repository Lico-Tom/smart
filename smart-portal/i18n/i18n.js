// i18n.js
import Vue from 'vue'
import VueI18n from 'vue-i18n'
import en from './en' // 你的英文语言文件
import zh from './zh' // 你的中文语言文件

Vue.use(VueI18n)

const messages = {
  en: {
    ...en
  },
  zh: {
    ...zh
  }
}

const i18n = new VueI18n({
  locale: localStorage.getItem('language') || 'zh', // 设置默认语言
  messages
})

export default i18n
