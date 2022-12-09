import request from '@/utils/request'

export function getList(params) {
  return request({
    url: '/vue-admin-template/teacher/list',
    method: 'get',
    params: params
  })
}

export function save(params) {
  return request({
    url: '/vue-admin-template/teacher/save',
    method: 'post',
    data: params
  })
}

export function modify(params) {
  return request({
    url: '/vue-admin-template/teacher/modify',
    method: 'put',
    data: params
  })
}

export function remove(params) {
  return request({
    url: '/vue-admin-template/teacher/remove',
    method: 'delete',
    data: params
  })
}
