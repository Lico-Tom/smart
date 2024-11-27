import Layout from '@/layout'
import i18n from '../../../i18n/i18n'

const mqttRouter = {
  path: '/mqtt',
  component: Layout,
  redirect: 'noRedirect',
  name: 'mqtt',
  meta: {
    title: i18n.t('common.mqtt'),
    icon: 'el-icon-cloudy'
  },
  children: [
    {
      path: '/mqtt',
      component: () => import('@/views/mqtt/index'),
      name: 'mqtt',
      meta: {
        title: i18n.t('mqtt.mqtts')
      }
    },
    {
      path: '/mqtt/pub',
      component: () => import('@/views/mqtt/mqtt-pub/index'),
      name: 'pub',
      meta: {
        title: i18n.t('mqtt.pub')
      }
    },
    {
      path: '/mqtt/sub',
      component: () => import('@/views/mqtt/mqtt-sub/index'),
      name: 'sub',
      meta: {
        title: i18n.t('mqtt.sub')
      }
    },
    {
      path: '/mqtt/history',
      component: () => import('@/views/mqtt/mqtt-history/index'),
      name: 'history',
      meta: {
        title: i18n.t('mqtt.history')
      }
    }
  ]
}
export default mqttRouter
