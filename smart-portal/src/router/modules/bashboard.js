import Layout from '@/layout'
import i18n from '../../../i18n/i18n'

const dashboardRouter = {
  path: '/home',
  component: Layout,
  redirect: '/home/index',
  name: 'Home',
  meta: {
    title: 'dashboard',
    icon: 'el-icon-monitor',
    affix: false
  },
  children: [
    {
      path: 'index',
      component: () => import('@/views/dashboard/index'),
      name: 'Dashboard',
      meta: { title: i18n.t('common.dashboard'), noCache: true }
    }
  ]
}
export default dashboardRouter
