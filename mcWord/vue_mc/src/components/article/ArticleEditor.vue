<template>
    <div>
      <div id="vditor"></div>
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
        height: 360,
        toolbarConfig: {
          pin: true,
        },
        cache: {
          enable: false,
        },
      });
    },
  },
};
</script>

<style>
</style>