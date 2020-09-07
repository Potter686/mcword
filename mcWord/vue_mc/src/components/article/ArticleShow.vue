<template>
  <div>
    <mavon-editor
      class="md"
      :value ="articleBody"
      :subfield="false"
      :defaultOpen="'preview'"
      :toolbarsFlag="false"
      :editable="false"
      :scrollStyle="true"
      :ishljs="true"
    ></mavon-editor>
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
</style>