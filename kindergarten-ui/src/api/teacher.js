import request from '@/utils/request'

export function getList(params) {
  return request({
    url: '/teacher/list',
    method: 'get',
    params: params
  })
}

export function save(params) {
  return request({
    url: '/teacher/save',
    method: 'post',
    data: params
  })
}

export function modify(params) {
  return request({
    url: '/teacher/modify',
    method: 'put',
    data: params
  })
}

export function remove(params) {
  return request({
    url: '/teacher/remove',
    method: 'delete',
    data: params
  })
}
