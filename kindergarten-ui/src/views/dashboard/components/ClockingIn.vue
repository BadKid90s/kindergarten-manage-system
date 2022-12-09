<template>
  <div :class="className" :style="{height:height,width:width}"/>
</template>

<script>
import { getClocking } from '@/api/index'
import * as echarts from 'echarts'
import resize from './mixins/resize'

require('echarts/theme/macarons') // echarts theme
export default {
  mixins: [resize],
  props: {
    className: {
      type: String,
      default: 'chart'
    },
    width: {
      type: String,
      default: '100%'
    },
    height: {
      type: String,
      default: '300px'
    },
    autoResize: {
      type: Boolean,
      default: true
    }
  },
  data() {
    return {
      chart: null,
      chartData: {
        currentWeekData: [100, 120, 161, 134, 105, 160, 165],
        lastWeekData: [120, 82, 91, 154, 162, 140, 145]
      }
    }
  },
  watch: {
    chartData: {
      deep: true,
      handler(val) {
        this.setOptions(val)
      }
    }
  },
  mounted() {
    this.initData()
    this.$nextTick(() => {
      this.initChart()
    })
  },
  beforeDestroy() {
    if (!this.chart) {
      return
    }
    this.chart.dispose()
    this.chart = null
  },
  methods: {
    initData() {
      getClocking().then(response => {
        this.chartData = response.data
      })
    },
    initChart() {
      this.chart = echarts.init(this.$el, 'macarons')
      this.setOptions(this.chartData)
    },
    setOptions({ currentWeekData, lastWeekData } = {}) {
      this.chart.setOption({
        title: {
          top: -5,
          text: '学生考勤表'
        },
        xAxis: {
          data: ['周一', '周二', '周三', '周四', '周五'],
          boundaryGap: false,
          axisTick: {
            show: false
          }
        },
        grid: {
          left: 10,
          right: 10,
          bottom: 20,
          top: 30,
          containLabel: true
        },
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'cross'
          },
          padding: [25, 10]
        },
        yAxis: {
          axisTick: {
            show: false
          }
        },
        legend: {
          data: ['本周', '上周']
        },
        series: [{
          name: '本周',
          smooth: true,
          type: 'line',
          itemStyle: {
            normal: {
              label: { show: true },
              color: '#FF005A',
              lineStyle: {
                color: '#FF005A',
                width: 2
              }
            }
          },
          data: currentWeekData,
          animationDuration: 2800,
          animationEasing: 'cubicInOut'
        },
          {
            name: '上周',
            smooth: true,
            type: 'line',
            itemStyle: {
              normal: {
                label: { show: true },
                color: '#3888fa',
                lineStyle: {
                  color: '#3888fa',
                  width: 1
                },
                areaStyle: {
                  color: '#f3f8ff'
                }
              }
            },
            data: lastWeekData,
            animationDuration: 2800,
            animationEasing: 'quadraticOut'
          }]
      })
    }
  }
}
</script>
