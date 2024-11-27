import Layout from '@/layout'
import i18n from '../../../i18n/i18n'
const userRouter = {
  path: '/users',
  component: Layout,
  redirect: 'noRedirect',
  name: 'users',
  meta: {
    title: i18n.t('common.user'),
    icon: 'el-icon-user'
  },
  children: [
    {
      path: '/register',
      component: () => import('@/views/login/user-list'),
      name: 'user',
      meta: { title: i18n.t('user.register') }
    },
    {
      path: '/list',
      component: () => import('@/views/user/index'),
      name: 'list',
      meta: {
        title: i18n.t('user.list')
      }
    }
  ]
}
export default userRouter
