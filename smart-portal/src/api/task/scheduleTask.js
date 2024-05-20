import request from '@/utils/request'

const basePath = '/v1/task'

export function fetchTasks(pageSize, currentPage, task) {
  return request({
    url: basePath + '/list?pageSize=' + pageSize + '&currentPage=' + currentPage,
    params: task,
    method: 'get'
  })
}
