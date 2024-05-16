import Layout from '@/layout'

const taskRouter = {
  path: '/task',
  component: Layout,
  redirect: 'noRedirect',
  name: 'task',
  meta: {
    title: 'task',
    icon: 'nested'
  },
  children: [
    {
      path: '/task',
      component: () => import('@/views/task/index'),
      name: 'task',
      meta: {
        title: 'task'
      }
    }
  ]
}
export default taskRouter
