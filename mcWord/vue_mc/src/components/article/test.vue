<template>
  <div style="background-color: #f6f6f6; height :100% ;">
    <div style="width:70% ; margin: 0px auto 0 auto">
      <el-container
        style="background-color: #f6f6f6;  height: 100%;min-height:92vh; width:100% "
        direction="vertical"
      >
        <el-container style=";margin: 1vh">
          <el-aside width="200px">
            <el-row class="tac">
              <el-col :span="12" style="width:100%">
                <el-menu
                  default-active="2"
                  class="el-menu-vertical-demo"
                  @open="handleOpen"
                  @close="handleClose"
                  router
                >
                  <!-- <el-submenu index="1">
                    <template slot="title">
                      <span>个人资料</span>
                    </template> -->
                   
                    <!-- <el-menu-item-group>
                      <template slot="title">分组一</template>
                      <el-menu-item index="1-1">选项1</el-menu-item>
                      <el-menu-item index="1-2">选项2</el-menu-item>
                    </el-menu-item-group>-->
                  <!-- </el-submenu> -->
                   <el-menu-item index="/PersonalInfo">
                      <span slot="title">个人资料</span>
                    </el-menu-item>
                </el-menu>
              </el-col>
            </el-row>
          </el-aside>

          <el-container>
            <el-main class="el-main-article_info" style="height 100% ;">
                <router-view></router-view>
            </el-main>
          </el-container>
        </el-container>
      </el-container>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
  },
};
</script>

<style  scoped>

.el-main-article_info {
  /* background-color: #ffffff; */
  background-color: rgb(251, 251, 251);

  text-align: left;
  height: 90.3vh;
  padding-bottom: 0px;
  padding: 0px !important;

  /* overflow-y:hidden !important; */
  


  width: 100%;
}
</style>