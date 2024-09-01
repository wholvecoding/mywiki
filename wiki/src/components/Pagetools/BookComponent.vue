<template>
  <div class="book-component">
    <div class="postTitle">{{ modifiedTitle(mybook.title, mybook.author) }}</div>
    <hr class="divider"/>
    <div class="content-row">
      <div class="postImage">
        <img :src="getFullPath(mybook.bookCover)" alt="Book Cover"/>
      </div>
      <div class="postDescription">
        <span v-if="isCollapsed">{{ truncatedOutline }}</span>
        <span v-else>{{ fullOutline }}</span>
          <router-link :to="`/book/${mybook.id}`" class="toggle">
  {{ isCollapsed ? '展开' : '收起' }}
</router-link>


      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    mybook: {
      type: Object,
      required: true
    }
  },
  data() {
    return {
      isCollapsed: true, // 初始状态为折叠
      truncateLength: 200, // 显示的字符数
    };
  },
  computed: {
    fullOutline() {
      return `内容简介: ${this.mybook.bookOutline}`;
    },
    truncatedOutline() {
      return `${this.fullOutline.slice(0, this.truncateLength)}...`;
    }
  },
  methods: {
    getFullPath(coverpath) {
      return `/bookcover/${coverpath}`;
    },
    modifiedTitle(title, author) {
      return `《${title}》 ${author}`;
    },
    toggleCollapse() {
      this.isCollapsed = !this.isCollapsed;
    }
  }
}
</script>

<style scoped>
.book-component {
  margin-bottom: 20px;
  padding: 20px;
  background-color: #f9f9f9;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.postTitle {
  font-size: 1.5em;
  font-weight: bold;
  margin-bottom: 10px;
  color: #333;
  text-align: left;
}

.divider {
  width: 100%;
  height: 2px;
  background-color: #ddd;
  margin: 10px 0;
  border: none;
}

.content-row {
  display: flex;
  align-items: flex-start;
  height: 300px;
}

.postImage {
  flex-shrink: 0;
  width: 250px;
  height: 300px;
  margin-right: 20px;
  background-color: #f0f0f0;
  overflow: hidden;
  border-radius: 4px;
}

.postImage img {
  width: 100%;
  height: 100%;
  object-fit: cover;
  border-radius: 4px;
}

.postDescription {
  font-size: 1.2em;
  line-height: 1.6;
  color: #333;
  flex-grow: 1;
  display: inline;
}

.toggle {
  color: #007BFF;
  cursor: pointer;
  font-size: 1em;
  margin-left: 5px; /* 增加一点间距以便更易点击 */
}
</style>
