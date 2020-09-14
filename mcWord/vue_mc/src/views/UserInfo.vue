<template>

  <div style="background-color: #f6f6f6; height :100% ;">
     
    <div style="width:80% ; margin: 0px auto 0 auto">
       
      <el-container
        style="background-color: #f6f6f6;  height: 100%;min-height:92vh; width:100% "
        direction="vertical"
        
      >
      
        <el-container style=";margin: 1vh">
          <el-aside width="200px">
            <el-row class="demo-avatar demo-basic">
          
    
            </el-row>
          </el-aside>
        
    
          <el-container  >
            
            <el-main class="el-main-article_show" style="height 100% ;">
              </el-main>
              
              
          <el-footer style="height:40px ;">
            <el-button size="mini" icon="el-icon-star-off" circle></el-button>
            <el-button size="mini" icon="el-icon-chat-round" circle></el-button>

          </el-footer>
          
          
        </el-container>
        
      </el-container>
      </el-container>
    </div>
    
  </div>
  
</template>

<script>
export default {
  data() {
    return {
 
    };
  },
};
</script>

<style>

html,body {
  height: 100%;
}
.el-main-article_show {
  /* background-color: #ffffff; */
  background-color: rgb(251, 251, 251);

  text-align: left;
  height: 85vh;
  padding-bottom: 0px;
  padding: 0px !important;

  /* overflow-y:hidden !important; */
  


  width: 100%;
}
.el-button-article-show {
  text-align: right;
}
.el-container-article-show {
  background-color: #f6f6f6;
}
.el-footer {
  background-color: #FFFFFF;

  color: #333;
  text-align: left;
  line-height: 40px;
  /* position: relative; */
  /* position: fixed; */
}

.el-aside {
  background-color: #d3dce6;
  color: #333;
  text-align: center;
  line-height: 200px;
}

.md{
  
  box-shadow: rgba(0, 0, 0, 0) 0px 2px 12px 0px !important;
  
}

body > .el-container {
  margin-bottom: 40px;
}
</style>