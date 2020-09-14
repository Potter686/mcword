<template>

<div id="app" >
  <router-view v-if="isRouterAlive"></router-view>
</div>
</template>

<script>
  export default {
    provide(){
      return{
        reload:this.reload
      }
    },
    data(){
      return {
        isRouterAlive:true
      }
    },
    methods:{
      reload(){
        this.isRouterAlive=false;
        this.$nextTick(()=>this.isRouterAlive=true)
      }
    },

  };
</script>

<style>
body{
  margin: 0px;
}
  .el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
  }

  .el-aside {
    color: #333;
  }
</style>
