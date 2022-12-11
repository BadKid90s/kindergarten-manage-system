const Mock = require('mockjs')

const data = Mock.mock({
  'items|5': [{
    id: '@id',
    name: 'name',
    'gender|1': ['男', '女'],
    age: '@integer(300, 5000)',
    biography: '@sentence(10, 20)'
  }]
})

module.exports = [
  {
    url: '/teacher/list',
    type: 'get',
    response: config => {
      const items = data.items
      return {
        code: 20000,
        data: {
          total: items.length,
          items: items
        }
      }
    }
  }
]
