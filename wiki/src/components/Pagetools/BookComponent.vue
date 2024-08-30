<template>
  <div class="book-component">
    <div class="postTitle">{{ mybook.name }}</div>
    <div class="postImage">
    <img :src="getFullPath(mybook.cover)"/>
    </div>
    <div class="postDescription">{{ mybook.description }}</div>
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
  methods :{
    getFullPath(coverpath){
      return `/bookcover/${coverpath}`;
    }
  }
}
</script>

<style scoped>
.book-component {
  margin-bottom: 20px;
}
.postTitle {
  font-size: 1.5em;
  font-weight: bold;
}
.postImage {
  margin-top: 10px;
  height: 200px;
  width: 200px;
  background-color: #f0f0f0; /* 图片的占位符背景色 */
}
.postDescription {
  margin-top: 10px;
  font-size: 1em;
}
</style>
