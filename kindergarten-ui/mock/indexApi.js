const Mock = require('mockjs')

const statisticData = Mock.mock(
  {
    teacherNum: '@integer(10, 30)',
    studentNum: '@integer(300, 500)',
    classNum: '@integer(1, 5)',
    subjectsNum: '@integer(10, 20)'
  })
const recipeData = Mock.mock({
  'items|5': [{
    id: '@id',
    breakfast: '@sentence(10, 20)',
    lunch: '@sentence(10, 20)',
    dinner: '@sentence(10, 20)',
    name: 'week',
    sort: '@integer(0, 5)'
  }]
})
const clockingData = Mock.mock({
  'currentWeekData|5': ['@integer(20, 600)'],
  'lastWeekData|5': ['@integer(10, 500)']
})
module.exports = [
  {
    url: '/vue-admin-template/index/statistic',
    type: 'get',
    response: config => {
      return {
        code: 20000,
        data: statisticData
      }
    }
  },
  {
    url: '/vue-admin-template/index/recipe',
    type: 'get',
    response: config => {
      return {
        code: 20000,
        data: recipeData.items
      }
    }
  },
  {
    url: '/vue-admin-template/index/clocking',
    type: 'get',
    response: config => {
      return {
        code: 20000,
        data: clockingData
      }
    }
  }
]
