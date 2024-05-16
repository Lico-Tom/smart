import Layout from '@/layout'

const mqttRouter = {
  path: '/mqtt',
  component: Layout,
  redirect: 'noRedirect',
  name: 'mqtt',
  meta: {
    title: 'mqtt',
    icon: 'nested'
  },
  children: [
    {
      path: '/mqtt',
      component: () => import('@/views/mqtt/index'),
      name: 'mqtt',
      meta: {
        title: 'mqtt'
      }
    },
    {
      path: '/mqtt/pub',
      component: () => import('@/views/mqtt/mqtt-pub/index'),
      name: 'pub',
      meta: {
        title: 'pub'
      }
    },
    {
      path: '/mqtt/sub',
      component: () => import('@/views/mqtt/mqtt-sub/index'),
      name: 'sub',
      meta: {
        title: 'sub'
      }
    },
    {
      path: '/mqtt/history',
      component: () => import('@/views/mqtt/mqtt-history/index'),
      name: 'history',
      meta: {
        title: 'history'
      }
    }
  ]
}
export default mqttRouter
