<template>
    <div class="filter-bar">
      <input 
        type="text" 
        v-model="searchText" 
        placeholder="搜索..."
        class="search-input"
      />
      <div class="filters">
        <select v-model="selectedCategory" class="filter">
          <option value="">选择分类</option>
          <option value="category1">分类 1</option>
          <option value="category2">分类 2</option>
          <option value="category3">分类 3</option>
        </select>
        <select v-model="selectedStatus" class="filter">
          <option value="">选择状态</option>
          <option value="active">活动</option>
          <option value="inactive">非活动</option>
        </select>
        <select v-model="selectedDate" class="filter">
          <option value="">选择日期</option>
          <option value="last_week">最近一周</option>
          <option value="last_month">最近一月</option>
          <option value="last_year">最近一年</option>
        </select>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        searchText: '',
        selectedCategory: '',
        selectedStatus: '',
        selectedDate: ''
      };
    }
  };
  </script>
  
  <style scoped>
  .filter-bar {
    height: 100px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    padding: 10px;
    border: 1px solid #ccc;
    background-color: #f9f9f9;
  }
  
  .search-input {
    height: 30px;
    margin-bottom: 10px;
    padding: 5px;
    border: 1px solid #ddd;
    border-radius: 4px;
  }
  
  .filters {
    display: flex;
    gap: 10px;
  }
  
  .filter {
    height: 30px;
    padding: 5px;
    border: 1px solid #ddd;
    border-radius: 4px;
  }
  </style>
  