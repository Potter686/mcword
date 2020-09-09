<template>

    <div style="cursor:pointer; text-align: left; height:100vh  ;width: 80%;margin: 30px auto 0 auto" >
      <el-input placeholder="请输入标题" > </el-input>
      <div id="vditor" ></div>
    </div>
</template>

<script>
import Vditor from "vditor";
import "vditor/dist/index.css";

export default {
  data() {
    return {
      contentEditor: "",
    };
  },
  comments: {},
  mounted: function () {
    const _this = this;
    _this.start_editing();
  },
  methods: {
    start_editing() {
      const _this = this;
      _this.contentEditor = new Vditor("vditor", {

        height : "900px",
        
        toolbarConfig: {
          pin: true,
        },
        cache: {
          enable: false,
        },
        "mode": "wysiwyg",
      });
    },
  },
};
</script>

<style>



</style>