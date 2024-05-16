import request from '@/utils/request'

const basePath = '/v1/mqtt-pub'

export function fetchMqttPub(pageSize, currentPage, mqttPub) {
  return request({
    url: basePath + '/list?pageSize=' + pageSize + '&currentPage=' + currentPage,
    params: mqttPub,
    method: 'get'
  })
}
