import request from '@/utils/request'

export function getList(params) {
  return request({
    url: '/student/list',
    method: 'get',
    params: params
  })
}

export function save(params) {
  return request({
    url: '/student/save',
    method: 'post',
    data: params
  })
}

export function modify(params) {
  return request({
    url: '/student/modify',
    method: 'put',
    data: params
  })
}

export function remove(params) {
  return request({
    url: '/student/remove',
    method: 'delete',
    data: params
  })
}
