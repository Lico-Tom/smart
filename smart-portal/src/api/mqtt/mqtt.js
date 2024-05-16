import request from '@/utils/request'

const basePath = '/v1/mqtt'

export function fetchMqtt(pageSize, currentPage, mqtt) {
  return request({
    url: basePath + '/list?pageSize=' + pageSize + '&currentPage=' + currentPage,
    params: mqtt,
    method: 'get'
  })
}
