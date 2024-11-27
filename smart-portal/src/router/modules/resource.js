import Layout from '@/layout'
import i18n from '../../../i18n/i18n'

const resourceRouter = {
  path: '/resource',
  component: Layout,
  redirect: 'noRedirect',
  name: 'resource',
  meta: {
    title: i18n.t('common.resource'),
    icon: 'el-icon-suitcase'
  },
  children: [
    {
      path: '/resources',
      component: () => import('@/views/resource/index'),
      name: 'resources',
      meta: {
        title: i18n.t('resource.resources')
      }
    },
    {
      path: '/resource-category',
      component: () => import('@/views/resource/resource_category/index'),
      name: 'resource-category',
      meta: {
        title: i18n.t('resource.resourceCategory')
      }
    }
  ]
}
export default resourceRouter
