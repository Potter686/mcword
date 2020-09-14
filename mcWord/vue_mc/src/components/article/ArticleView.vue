<template>
  <div  style="height :92vh;"  >
    <el-scrollbar style="height:100% ;">
    <div v-for="(article,index) in articles" :key="index" style="background-color: #f6f6f6;" > 
      <div v-for="(article_data,index1) in article" :key="index1">
        <el-col style="background-color: #f6f6f6">
          <el-card
            shadow="hover"
            style="cursor:pointer; text-align: left;width: 60%;margin: 30px auto 0 auto"
          >
            <div
              style="text-align: left; height: 150px"
              @click="articleShow(article_data.articleId)"
            >
              <span style="font-size: 30px">
                <strong>{{article_data.articleTitle}}</strong>
              </span>

              <el-divider content-position="left">{{article_data.articleDate}}</el-divider>

              <span
                v-if="article_data.articleBody.length<200"
                content-position="left"
              >{{article_data.articleBody.slice(0,100)}}</span>

              <!-- <span v-if="article_data.articleBody.length>=200" content-position="left" style="font-size: 15px" >{{article_data.articleBody.slice(0,100)}}... -->
            </div>
          </el-card>
        </el-col>
      </div>
    </div>

    <div id="el-alert_test" style="background-color: #f6f6f6">
      <div v-if="noMore" style="text-align: center">
        <p style="color:#ff8c00">我也是有底线的~</p>
      </div>

      <p v-if="loading" v-loading="loading">
        <span></span>
      </p>
    </div>
    </el-scrollbar>
  </div>
</template>

<script>
export default {
  name: "ArticleView",
  data() {
    return {
      isShow: true,
      page: 1,
      loading: false,
      noMore: false,
      totalPages: null,
      busy: false,
      page_size: 10,
      txt: "显示全部",
      articles: [],
    };
  },
  methods: {
    articleShow(id) {
      const _this = this;

      _this.$router.push({ path: "/ArticleShow", query: { articleId: id } });
    },

    showMore() {
      console.log("1", this.isShow);
      this.isShow = !this.isShow;
      console.log("2", this.isShow);
      this.txt = this.isShow ? "显示全部" : "收起";
    },

    scroll() {
      const _this = this;
      window.onscroll = () => {
        let bottomOfWindow =
          document.documentElement.scrollTop + window.innerHeight >
          document.documentElement.offsetHeight - 0.5;
        if (bottomOfWindow) {
          if (_this.page > _this.totalPages) {
            _this.loading = false;
            _this.noMore = true;
          } else {
            _this.noMore = false;
            _this.loading = true;

            if (!_this.busy) {
              _this.getArticles();
            }
          }
        }
      };
    },
    getArticles() {
      const _this = this;
      _this.busy = true;
      const serverUrl = this.$serverUrl.serverUrl;
      this.$axios
        .get(
          serverUrl +
            "article/findAll/" +
            parseInt(_this.page) +
            "/" +
            _this.page_size
        )
        .then(function (resp) {
          _this.page += 1;
          _this.articles.push(resp.data.content);
          const pages = resp.data.totalElements / _this.page_size;
          // alert(pages);
          if (pages % 1 === 0) {
            _this.totalPages = pages;
          } else _this.totalPages = parseInt(pages) + 1;
          _this.busy = false;
        });
    },
  },

  created() {
    this.getArticles();
  },
  mounted() {
    this.scroll();
  },
};
</script>

<style  scoped>
#el-alert_test {
  margin: auto;
  background-color: #ffffff;
}
.el-header,
.el-footer {
  background-color: #b3c0d1;
  color: #333;
  text-align: center;
  line-height: 60px;
}

.el-aside {
  background-color: #d3dce6;
  color: #333;
  text-align: center;
  line-height: 200px;
}

.el-main {
  background-color: #e9eef3;
  color: #333;
  text-align: center;
  line-height: 160px;
}

body > .el-container {
  margin-bottom: 40px;
}

.el-container:nth-child(5) .el-aside,
.el-container:nth-child(6) .el-aside {
  line-height: 260px;
}

.el-container:nth-child(7) .el-aside {
  line-height: 320px;
}



/* .el-scrollbar__wrap
{
  overflow-x: hidden;
} */
</style>

