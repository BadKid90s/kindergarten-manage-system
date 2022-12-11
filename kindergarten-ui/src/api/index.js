import request from '@/utils/request'

export function getStatistic() {
  return request({
    url: '/index/statistic',
    method: 'get'
  })
}
export function getClocking() {
  return request({
    url: '/index/clocking',
    method: 'get'
  })
}
export function getRecipe() {
  return request({
    url: '/index/recipe',
    method: 'get'
  })
}
