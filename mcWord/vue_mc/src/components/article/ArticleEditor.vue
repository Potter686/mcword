<template>
<div style="background-color: #f6f6f6; height:92vh">
  <el-scrollbar style="height:100% ; width:100% ;">
  <el-container class="el-container-article-editor">
    <el-main class="el-main-article_editor">  
      <div style="width: 80%;margin: 1% auto 0 auto" :model="articleInput">
        <el-input placeholder="请输入标题" v-model="articleInput.articleTitle"></el-input>

        <mavon-editor style="height: 80vh" v-model="articleInput.articleBody"></mavon-editor>
        <div class="el-button-article-editor">
          <el-button
            type="primary"
            @click="article_sub()"
            style="width: 10% ;background: #292421;border: none"
          >发布</el-button>
        </div>
      </div>
    </el-main>
  </el-container>
  </el-scrollbar>
  </div>
</template>

<script>
    var mavonEditor = require('mavon-editor');
    import 'mavon-editor/dist/css/index.css'
    
    export default {
        name: 'editor',
        components: {
            'mavon-editor': mavonEditor.mavonEditor
        },
        methods: {
            article_sub(){
                const _this = this;
                const serverUrl = this.$serverUrl.serverUrl;
                // alert(_this.articleInput.article_title);
                this.$axios.post(serverUrl+"/article/save",_this.articleInput).then(function (resp) {
                    alert(resp.data)

                })


            }
        },
        data() {
            return{
                articleInput:{
                    articleId:'',
                    articleTitle:'',
                    articleBody:'',
                    articleDate:''
                },

            }
        }
    }
</script>



<style>
/* .el-footer-article_editor {
  background-color: #ffffff;
  color: #333;

  text-align: right;
  line-height: 60px;
} */
.el-main-article_editor {
  /* background-color: #f6f6f6; */
  /* background-image: url("../../assets/back.jpg"); */
  color: #333;
  text-align: left;
  line-height: 10vh;
  height: 100%;
  width: 100%;
}
.el-button-article-editor {
  text-align: right;
}
.el-container-article-editor{
    background-color: #f6f6f6;
    width: 100%;
    height: 100%;
    
    direction:vertical;
}

</style>
