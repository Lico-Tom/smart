import request from '@/utils/request'

const basePath = '/v1/smart/resource'

export function fetchResources(pageSize, currentPage, resource) {
  return request({
    url: basePath + '/list?pageSize=' + pageSize + '&currentPage=' + currentPage,
    params: resource,
    method: 'get'
  })
}
