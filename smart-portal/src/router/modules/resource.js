import Layout from '@/layout'

const resourceRouter = {
  path: '/resource',
  component: Layout,
  redirect: 'noRedirect',
  name: 'resource',
  meta: {
    title: 'resource',
    icon: 'nested'
  },
  children: [
    {
      path: '/resources',
      component: () => import('@/views/resource/index'),
      name: 'resources',
      meta: {
        title: 'resources'
      }
    },
    {
      path: '/resource-category',
      component: () => import('@/views/resource/resource_category/index'),
      name: 'resource-category',
      meta: {
        title: 'resource category'
      }
    }
  ]
}
export default resourceRouter
