import request from '@/utils/request'

const basePath = '/v1/smart/resource-category'

export function fetchResourcesCategory(pageSize, currentPage, resourceCategory) {
  return request({
    url: basePath + '/list?pageSize=' + pageSize + '&currentPage=' + currentPage,
    params: resourceCategory,
    method: 'get'
  })
}
