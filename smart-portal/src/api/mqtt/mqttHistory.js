import request from '@/utils/request'

const basePath = '/v1/mqtt-history'

export function fetchMqttHistory(pageSize, currentPage, mqttHistory) {
  return request({
    url: basePath + '/list?pageSize=' + pageSize + '&currentPage=' + currentPage,
    params: mqttHistory,
    method: 'get'
  })
}
