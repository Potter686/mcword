<template>

<div class = "v-show-content scroll-style scroll-style-border-radius" style="background-color: rgb(251, 251, 251);">
 <el-col>
          <el-card
            style="cursor:pointer; border: 1px solid #f5f7fa; text-align: left; width: 80%;margin: 30px auto 0 auto"
          >
          

    <span style="font-size: 30px">
                <strong>{{articleTitle}}</strong>
    </span>
    <!-- <el-divider content-position="left">{{articleDate}}</el-divider> -->
       </el-card> 
  </el-col>



    <mavon-editor
      class="md"
      :value ="articleBody"
      :subfield="false"
      :defaultOpen="'preview'"
      :toolbarsFlag="false"
      :editable="false"
      :scrollStyle="true"
      :ishljs="true"
      style=" text-align: left;width: 80%;  margin: 30px auto 0 auto "
    >
  
    </mavon-editor>
    
</div>

</template>

<script>
export default {
  data() {
    return {
      articleTitle: "",
      articleBody: "",
      articleDate: "",
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
    });
  },
};
</script>

<style>

#show {
        margin: auto;
        width: 90%;
        height: 85vh;
    }
    .el-footer-article {
        background-color: #fffaf0;
        color: #333;
        /*background-image: url("../../assets/back.jpg");*/
        text-align: right;
        line-height: 60px;
    }
    .el-main-article {
        background-color: #fffaf0;

        /*background-image: url("../../assets/back.jpg");*/
        color: #333;
        text-align: center;
        line-height: 10vh;
        height: 85vh;
    }


  

</style>