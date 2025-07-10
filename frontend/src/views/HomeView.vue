<script setup lang="ts">
import { ref, computed, onMounted } from 'vue'

// 模拟统计数据
const stats = ref({
  total: 0,
  finished: 0,
  ongoing: 0
})

// 模拟表格数据
const tableData = ref<any[]>([])
const search = ref('')

const filteredTableData = computed(() => {
  if (!search.value) return tableData.value
  // 支持手游ID模糊匹配
  return tableData.value.filter(row => row.gameId.includes(search.value))
})

onMounted(() => {
  // 模拟异步获取数据
  setTimeout(() => {
    stats.value = { total: 128, finished: 86, ongoing: 42 }
    tableData.value = [
      { index: 1, date: '2023-07-04', gameName: '银河战神', gameId: '66889900', loginAccount: '13812345678', wechatName: '踢球的小黑', days: '15/15天', status: '已完成' },
      { index: 2, date: '2023-07-05', gameName: '足球小将', gameId: '88776655', loginAccount: 'football@qq.com', wechatName: '快乐玩足球', days: '14/15天', status: '进行中' },
      { index: 3, date: '2023-07-06', gameName: '绿茵精灵', gameId: '12348765', loginAccount: '15998765432', wechatName: '爱踢球的虎子', days: '13/15天', status: '进行中' },
      { index: 4, date: '2023-07-06', gameName: '足球达人', gameId: '45678912', loginAccount: 'soccer@163.com', wechatName: '球场新秀', days: '13/15天', status: '进行中' },
      { index: 5, date: '2023-07-07', gameName: '传奇射手', gameId: '98765432', loginAccount: '17856789012', wechatName: '足球小子', days: '12/15天', status: '进行中' }
    ]
  }, 500)
})
</script>

<template>
  <div class="container">
    <!-- 顶部导航栏 -->
    <el-header class="header">
      <div class="header-title">
        <el-icon><i class="el-icon-s-promotion" /></el-icon>
        实况联动助手
      </div>
      <el-button type="primary" plain class="contact-btn">联系我们</el-button>
    </el-header>

    <!-- 公告栏 -->
    <el-card class="notice-card">
      <div class="notice-title">
        <el-icon><i class="el-icon-bell" /></el-icon>
        最新公告
      </div>
      <div class="notice-content">
        <span class="notice-important">【最新】端游联动活动开启，连续登录15天可获得手游250抽奖励！</span>
        <div>活动时间：2023年7月4日 - 2023年8月4日</div>
      </div>
      <el-button type="primary" link class="more-btn">查看更多</el-button>
    </el-card>

    <!-- 统计卡片 -->
    <div class="stats-row">
      <el-card class="stat-card">
        <div class="stat-label">当前服务总人数</div>
        <div class="stat-value">{{ stats.total }}</div>
      </el-card>
      <el-card class="stat-card">
        <div class="stat-label">已完成任务人数</div>
        <div class="stat-value">{{ stats.finished }}</div>
      </el-card>
      <el-card class="stat-card">
        <div class="stat-label">进行中任务人数</div>
        <div class="stat-value">{{ stats.ongoing }}</div>
      </el-card>
    </div>

    <!-- 用户任务进度表格 -->
    <el-card class="table-card">
      <div class="table-title">用户任务进度</div>
      <el-input v-model="search" placeholder="输入手游ID查询" class="search-input" clearable />
      <el-table :data="filteredTableData" style="width: 100%" :border="false" class="user-table" size="small">
        <el-table-column prop="index" label="序号" width="60" align="center" />
        <el-table-column prop="date" label="联系日期" width="110" align="center" />
        <el-table-column prop="gameName" label="手游昵称" width="110" align="center" />
        <el-table-column prop="gameId" label="手游ID" width="110" align="center" />
        <el-table-column prop="loginAccount" label="登录账号" width="150" align="center" />
        <el-table-column prop="wechatName" label="微信昵称" width="120" align="center" />
        <el-table-column prop="days" label="已登录天数" width="100" align="center">
          <template #default="scope">
            <span :style="{ color: scope.row.days === '15/15天' ? '#67C23A' : '#409EFF' }">{{ scope.row.days }}</span>
          </template>
        </el-table-column>
        <el-table-column prop="status" label="状态" width="90" align="center">
          <template #default="scope">
            <el-tag :type="scope.row.status === '已完成' ? 'success' : 'warning'" disable-transitions>
              {{ scope.row.status }}
            </el-tag>
          </template>
        </el-table-column>
      </el-table>
    </el-card>
  </div>
</template>

<style scoped>
.container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 24px 8px 32px 8px;
}
.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background: #fff;
  border-radius: 8px;
  margin-bottom: 18px;
  padding: 0 24px;
  height: 56px;
  box-shadow: 0 2px 8px #f0f1f2;
}
.header-title {
  font-size: 20px;
  font-weight: bold;
  display: flex;
  align-items: center;
  gap: 8px;
}
.contact-btn {
  min-width: 90px;
}
.notice-card {
  margin-bottom: 18px;
  position: relative;
}
.notice-title {
  font-size: 16px;
  font-weight: bold;
  margin-bottom: 6px;
  display: flex;
  align-items: center;
  gap: 6px;
}
.notice-content {
  margin-bottom: 8px;
}
.notice-important {
  color: #f56c6c;
  font-weight: 500;
  margin-right: 12px;
}
.more-btn {
  position: absolute;
  top: 18px;
  right: 18px;
}
.stats-row {
  display: flex;
  gap: 18px;
  margin-bottom: 18px;
}
.stat-card {
  flex: 1;
  text-align: center;
  padding: 18px 0;
}
.stat-label {
  color: #888;
  font-size: 15px;
  margin-bottom: 6px;
}
.stat-value {
  font-size: 28px;
  font-weight: bold;
  color: #409EFF;
}
.table-card {
  margin-top: 12px;
}
.table-title {
  font-size: 16px;
  font-weight: bold;
  margin-bottom: 12px;
}
.search-input {
  width: 220px;
  margin-bottom: 12px;
}
.user-table {
  font-size: 14px;
}
@media (max-width: 900px) {
  .container {
    padding: 8px 2px 16px 2px;
  }
  .header {
    padding: 0 8px;
    height: 48px;
    font-size: 16px;
  }
  .stats-row {
    flex-direction: column;
    gap: 10px;
  }
  .stat-card {
    padding: 10px 0;
  }
  .table-title {
    font-size: 15px;
  }
  .search-input {
    width: 100%;
    margin-bottom: 10px;
  }
}
</style>
