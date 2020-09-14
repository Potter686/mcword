<template>
  <div>
    <div style="width:70% ; margin: 0px auto 0 auto ;">
      <el-menu
        :default-active="$route.path"
        class="el-menu-demo"
        mode="horizontal"
        @select="handleSelect"
        router
        active-text-color="#0099CC"
      >
        <!-- <a  style="cursor:pointer; position: absolute;padding-top: 1vh;right: 49%;font-size: 30px;font-weight: bold" @click="back()">乎知</a> -->
        <a
          style="color:fffff;cursor:pointer;  position: absolute;padding-top: 1vh;right: 49%;font-size: 30px;font-weight: bold" @click="back()"
        >乎知</a>
        <el-menu-item index="/ArticleView">首页</el-menu-item>
        <el-menu-item index="/ArticleEditor">写文章</el-menu-item>

        <el-menu-item v-show="false" index="/UserInfo">个人中心</el-menu-item>

        <el-submenu index="3" style="float: right; cursor:pointer;">
          <template slot="title">
            <div class="demo-basic--circle">
              <div class="block">
                <el-avatar shape="square" :size="40" :src="squareUrl"></el-avatar>
              </div>
            </div>
          </template>

          <el-menu-item @click="userInfo()">个人中心</el-menu-item>
          <el-menu-item @click="toArticleEditor()" >写博客</el-menu-item>
          
          <el-submenu index="2-4">
            <template slot="title">选项4</template>
            <el-menu-item index="2-4-1">选项1</el-menu-item>
            <el-menu-item index="2-4-2">选项2</el-menu-item>
            <el-menu-item index="2-4-3">选项3</el-menu-item>
          </el-submenu>
          <el-menu-item  divided >退出登录</el-menu-item>
        </el-submenu>

        <!-- <el-menu-item index="3" disabled>消息中心</el-menu-item> -->
        <!-- <el-menu-item index="4"><a href="https://www.ele.me" target="_blank">订单管理</a></el-menu-item> -->
      </el-menu>
    </div>
  </div>
</template>
<script>
export default {
  name: "NavMenu",
  data() {
    return {
      activeIndex: "1",
      activeIndex2: "1",
      squareUrl:
        "https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png",
    };
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    },
    back() {
      const _this = this;
      _this.$router.push("/ArticleView");
    },
    userInfo(){
      const _this = this;
      _this.$router.push("/UserInfo");
    },
    toArticleEditor(){
      const _this = this;
      _this.$router.push("/ArticleEditor");
    }
  },
};
</script>