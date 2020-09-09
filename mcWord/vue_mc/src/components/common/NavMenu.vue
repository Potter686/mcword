<template>
  <div>
      <div>
    <el-menu
      :default-active="'/ArticleView'"
      router
      mode="horizontal"
      background-color="white"
      text-color="#222"
      active-text-color="red"
      style="min-width: 1300px"
    >
      <el-menu-item v-for="(item,i) in navList" :key="i" :index="item.name" @click="loding()">{{ item.navItem }}</el-menu-item>
      <a href="#nowhere" style="color: #222;float: right;padding: 20px;">更多功能</a>
      <i class="el-icon-menu" style="float:right;font-size: 45px;color: #222;padding-top: 8px"></i>
      <span
        style="position: absolute;padding-top: 1vh;right: 49%;font-size: 30px;font-weight: bold"
      >乎知</span>
    </el-menu>
    <p v-if="loading" v-loading="loading"></p>
      </div>
  </div>
</template>

<script>



export default {
  name: "NavMenu",
  data() {
    return {
      loading: false,      
      navList: [
        { name: "/ArticleView", navItem: "首页" },
        { name: "/ArticleEditor", navItem: "写文章" },
        { name: "/BookIndex", navItem: "图书馆" },
        { name: "/admin", navItem: "个人中心" },
      ],
    };
  },
  methods:{
    loding(){
      const _this = this;
      _this.loading = true;
    }
  }
 
};
</script>

<style scoped>
a {
  text-decoration: none;
}

span {
  pointer-events: none;
}
</style>

