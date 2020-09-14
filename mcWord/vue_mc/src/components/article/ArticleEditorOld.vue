<template>
<div>
<el-container style="height: 100%;min-height:100vh;" direction="vertical">
  
    <el-main class="el-main-article_editor">
      <div style="width: 65%;margin: 1% auto 0 auto" :model="articleInput">
        <el-input placeholder="请输入标题" v-model="articleInput.articleTitle"></el-input>

        <div id="vditor" style="height:80vh"></div>
        <div class="el-button-article-editor">
          <el-button
            type="primary"
            @click="article_sub()"
            style="width: 10% ;background: #292421;border: none"
          >发布</el-button>
        </div>
      </div>
    </el-main>
 </div>
</el-container>
</template>

<script>
import Vditor from "vditor/dist/index.min";
import "vditor/dist/index.css";

export default {
  data() {
    return {
      contentEditor: "",
      articleInput: {
        articleId: "",
        articleTitle: "",
        articleBody: "",
        articleDate: "",
        vditor: "",
      },
    };
  },
  mounted: function () {
    const _this = this;
    _this.start_editing();
  },
  methods: {
    article_sub() {
      const _this = this;
      _this.articleInput.articleBody = _this.contentEditor.getValue();
      const serverUrl = this.$serverUrl.serverUrl;
      // alert(_this.articleInput.article_title);
      this.$axios
        .post(serverUrl + "/article/save", _this.articleInput)
        .then(function (resp) {
          alert(resp.data);
        });
    },
    start_editing() {
      const _this = this;

      _this.contentEditor = new Vditor("vditor", {
        toolbarConfig: {
          pin: true,
        },
        counter: {
          enable: 102400, // 计数，提示角标问题
        },

        resize: {
          enable: false,
        },
        toolbar: [
          "emoji",
          "headings",
          "bold",
          "italic",
          "strike",
          "link",
          "|",
          "list",
          "ordered-list",
          "check",
          "outdent",
          "indent",
          "|",
          "quote",
          "line",
          "code",
          "inline-code",
          "|",
          "upload",
          "record",
          "table",
          "|",
          "undo",
          "redo",
          "|",
          "outline",
          "preview" 
        ],
         

        cache: {
          enable: false,
        },
        mode: "ir",
        placeholder: "请输入",
        
      });
    },
  },
};
</script>

<style>
.el-footer-article_editor {
  background-color: #ffffff;
  color: #333;

  text-align: right;
  line-height: 60px;
}
.el-main-article_editor {
  background-color: #f6f6f6;
  /* background-image: url("../../assets/back.jpg"); */
  color: #333;
  text-align: left;
  line-height: 10vh;
  height: auto;
}
.el-button-article-editor {
  text-align: right;
}
body > .el-container {
  margin-bottom: 40px;
}
</style>