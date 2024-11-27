import Layout from '@/layout'
import i18n from '../../../i18n/i18n'

const taskRouter = {
  path: '/task',
  component: Layout,
  redirect: 'noRedirect',
  name: 'task',
  meta: {
    title: i18n.t('common.task'),
    icon: 'el-icon-tickets'
  },
  children: [
    {
      path: '/task',
      component: () => import('@/views/task/index'),
      name: 'task',
      meta: {
        title: i18n.t('task.tasks')
      }
    }
  ]
}
export default taskRouter
