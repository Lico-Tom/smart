import Layout from '@/layout'
const userRouter = {
  path: '/users',
  component: Layout,
  redirect: 'noRedirect',
  name: 'users',
  meta: {
    title: 'user',
    icon: 'user'
  },
  children: [
    {
      path: '/register',
      component: () => import('@/views/login/user-list'),
      name: 'user',
      meta: { title: 'register' }
    },
    {
      path: '/list',
      component: () => import('@/views/user/index'),
      name: 'list',
      meta: {
        title: 'list'
      }
    }
  ]
}
export default userRouter
