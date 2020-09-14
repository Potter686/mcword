<template>
  <div>
    <div style="width :80% ; margin: 0px auto 0 auto ; ">
      <el-menu
        :default-active="'/ArticleView'"
        router
        mode="horizontal"
        background-color="white"
        text-color="#222"
        active-text-color="red"
        style="height:6vh"
      >
        <el-menu-item
          v-for="(item,i) in navList"
          :key="i"
          :index="item.name"
          style="height:6vh ;margin: 0px auto 0 auto ;"

        >{{ item.navItem }}</el-menu-item>

        <el-row class="demo-avatar demo-basic" style="float: right;padding: 10px; cursor:pointer; ">
          <el-col :span="12">
            <el-dropdown trigger="click">
              <div class="demo-basic--circle">
                <div class="block">
                  <el-avatar shape="square" :size="40" :src="squareUrl"></el-avatar>
                </div>
              </div>

              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item>黄金糕</el-dropdown-item>
                <el-dropdown-item>狮子头</el-dropdown-item>
                <el-dropdown-item>螺蛳粉</el-dropdown-item>
                <el-dropdown-item disabled>双皮奶</el-dropdown-item>
                <el-dropdown-item divided>蚵仔煎</el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
          </el-col>
        </el-row>
        <!-- <a href="#nowhere" style="color: #222;float: right;padding: 20px;"> -->

        <!-- <i class="el-icon-menu" style="float:right;font-size: 45px;color: #222;padding-top: 8px"></i> -->
        <span
          style="position: absolute;padding-top: 1vh;right: 49%;font-size: 30px;font-weight: bold"
        >乎知</span>
      </el-menu>
    </div>
  </div>
</template>

<script>
export default {
  name: "NavMenu",
  data() {
    return {
      isShow: false,
      loading: false,
      squareUrl:
        "https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png",
      navList: [
        { name: "/ArticleView", navItem: "首页" },
        { name: "/ArticleEditor", navItem: "写文章" },
        { name: "/BookIndex", navItem: "图书馆" },
        { name: "/admin", navItem: "个人中心" },
      ],
    };
  },
  methods: {
    loding() {
      const _this = this;
      _this.loading = true;
    },
  },
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

