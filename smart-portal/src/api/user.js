import request from '@/utils/request'

const basePath = '/v1/smart/user'
export function login(data) {
  return request({
    url: basePath + '/login',
    method: 'post',
    data
  })
}

export function getInfo(token) {
  return request({
    url: basePath + '/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: basePath + '/logout',
    method: 'post'
  })
}

export function fetchUsers(pageSize, currentPage, user) {
  return request({
    url: basePath + '/list?pageSize=' + pageSize + '&currentPage=' + currentPage,
    params: user,
    method: 'get'
  })
}
