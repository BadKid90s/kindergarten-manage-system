import request from '@/utils/request'

export function getStatistic() {
  return request({
    url: '/vue-admin-template/index/statistic',
    method: 'get'
  })
}
export function getClocking() {
  return request({
    url: '/vue-admin-template/index/clocking',
    method: 'get'
  })
}
export function getRecipe() {
  return request({
    url: '/vue-admin-template/index/recipe',
    method: 'get'
  })
}
