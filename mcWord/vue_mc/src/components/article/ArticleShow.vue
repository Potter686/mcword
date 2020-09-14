<template>

  <div style="background-color: #f6f6f6; height :100% ;">
     
    <div style="width:70% ; margin: 0px auto 0 auto">
       
      <el-container
        style="background-color: #f6f6f6;  height: 100%;min-height:92vh; width:100% "
        direction="vertical"
        
      >
      
      <!-- <el-footer style="height:40px ;position:fixed;left:10%; right:0;bottom:0">test</el-footer> -->
        <el-container style=";margin: 1vh">
          <el-aside width="200px">
            <el-row class="demo-avatar demo-basic">
          
              <el-col :span="12">
                <div class="sub-title">square</div>
                <div class="demo-basic--circle">
                  <div class="block">
                    <el-avatar shape="square" :size="50" :src="squareUrl"></el-avatar>
                  </div>
                </div>
              </el-col>
            </el-row>
          </el-aside>
        
    
          <el-container  >
            
            <el-main class="el-main-article_show" style="height 100% ;">
             <el-backtop target=".el-main-article_show" right="10" bottom="10"></el-backtop > 
            <mavon-editor
                class="md"
                :value="'# '+articleTitle + '\n'+'>'+ ' '+ articleDate  + '\n\n\n' + articleBody"
                :subfield="false"
                :defaultOpen="'preview'"
                :toolbarsFlag="false"
                :editable="false"
                :scrollStyle="true"
                :ishljs="true"
                style=" text-align: left;width: 100%; "
              />
              
              
              
              </el-main>
              
              
          <el-footer style="height:40px ;">
            <el-button size="mini" icon="el-icon-star-off" circle></el-button>
            <el-button size="mini" icon="el-icon-chat-round" circle></el-button>

          </el-footer>
          
          <!-- <el-footer style="height:40px ;position:fixed;left:10%; right:0;bottom:0">test</el-footer> -->
        </el-container>
        <!-- <el-footer style="height:40px ;position:fixed;left:10%; right:0;bottom:0">test</el-footer> -->
      </el-container>
      </el-container>
    </div>
    
  </div>
  
</template>

<script>
export default {
  data() {
    return {
      circleUrl:
        "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",
      squareUrl:
        "https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png",
      sizeList: ["large", "medium", "small"],
      articleTitle: "",
      articleBody: "",
      articleDate: "",
      articleAuth: "",
      // headerInfos:"#"+this.articleTitle+"\n",
      // tipInfos :"+'<el-link href="+"https://element.eleme.io"+"target="+"blank"+">默认链接</el-link>",
    };
  },
  created() {
    const _this = this;
    const id = _this.$route.query.articleId;
    const serverUrl = this.$serverUrl.serverUrl;

    this.$axios.get(serverUrl + "article/findById/" + id).then(function (resp) {
      console.log(resp.data);
      _this.articleBody = resp.data.articleBody;
      _this.articleTitle = resp.data.articleTitle;
      _this.articleDate = resp.data.articleDate;
      _this.articleAuth = resp.data.userId;
    });
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