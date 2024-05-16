import request from '@/utils/request'

const basePath = '/v1/mqtt-sub'

export function fetchMqttSub(pageSize, currentPage, mqttSub) {
  return request({
    url: basePath + '/list?pageSize=' + pageSize + '&currentPage=' + currentPage,
    params: mqttSub,
    method: 'get'
  })
}
