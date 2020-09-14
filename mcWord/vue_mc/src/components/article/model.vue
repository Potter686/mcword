<template>
  <div>
    <!--布局容器-->
    <el-container style="height: 100%;min-height:100vh;" direction="vertical">
      <!--顶部栏-->
      <el-header>Header</el-header>
      <el-container>
        <el-aside width="200px">Aside</el-aside>
        <el-container>
          <el-main>Main</el-main>
          <el-footer>Footer</el-footer>
        </el-container>
      </el-container>
    </el-container>
  </div>
</template>
<script type="text/ecmascript-6">
export default {
  data() {
    return {
      message: "你好世界",
    };
  },
  methods: {},
};
</script>
<style>
</style>
