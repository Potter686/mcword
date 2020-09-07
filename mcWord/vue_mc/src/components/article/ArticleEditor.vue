<template>
<div>
    <el-form :model="articleInput">
    <el-container>
        <el-main class="el-main-article">


                <div id="editor">
                    <el-input placeholder="请输入标题" v-model="articleInput.articleTitle" > </el-input>

                    <mavon-editor style="height: 100%" v-model="articleInput.articleBody"></mavon-editor>

                </div>

        </el-main>
        <el-footer class="el-footer-article">
            <el-button type="primary" @click="article_sub('loginForm')"   style="width: 8% ;background: #292421;border: none" >保存</el-button>
            <el-button type="primary" @click="article_sub('loginForm')"   style="width: 8% ;background: #292421;border: none" >提交</el-button>

        </el-footer>
    </el-container>
    </el-form>
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

    #editor {
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
