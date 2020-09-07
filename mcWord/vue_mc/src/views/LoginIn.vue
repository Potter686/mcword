<template>
    <body id="paper">
    <el-form :model="loginForm" :rules="rules"  ref="ruleForm"  class="login-container" label-position="left"
             label-width="0px" v-loading="loading">
        <h3 class="login_title">系统登录</h3>
        <el-form-item prop="userName">
            <el-input type="text" v-model="loginForm.userName"
                      auto-complete="off" placeholder="账号"></el-input>
        </el-form-item>
        <el-form-item prop="password">
            <el-input type="password" v-model="loginForm.password"
                      auto-complete="off" placeholder="密码"></el-input>
        </el-form-item>
        <el-checkbox class="login_remember" v-model="checked"
                     label-position="left"><span style="color: #505458">记住密码</span></el-checkbox>
        <el-form-item style="width: 100%">
            <el-button type="primary" @click="userLogin('loginForm')"   style="width: 40%;background: #505458;border: none" >登录</el-button>

            <router-link to="register"><el-button type="primary" style="width: 40%;float: right;  background: #505458;border: none">注册</el-button></router-link>
        </el-form-item>
    </el-form>
    </body>
</template>

<script>
    export default {
        name: "LoginIn",
        methods: {
            userLogin(){
                const _this = this;
                const serverUrl = this.$serverUrl.serverUrl;
                console.log(_this.loginForm);
                if(_this.loginForm.userName.length == 0 && _this.loginForm.password.length == 0  ){
                    this.$message({
                        showClose: true,
                        message: '请输入账号密码',
                        type: 'error'
                    });
                }
                else if(_this.loginForm.userName.length == 0  ){
                    this.$message({
                        showClose: true,
                        message: '请输入账号',
                        type: 'error'
                    });
                }
                else if (_this.loginForm.password.length == 0) {
                    this.$message({
                        showClose: true,
                        message: '请输入密码',
                        type: 'error'
                    });
                }
                else {
                    this.$axios.post(serverUrl + "user/loginDetection", _this.loginForm).then(function (resp) {
                        // console.log(resp.data);
                        if (resp.data) {
                            _this.$router.push("/UserManager")
                        } else {
                            _this.$message({
                                showClose: true,
                                message: '账号密码错误',
                                type: 'error'
                            });
                        }
                    })
                }

            },
        },

        data() {
            return {
                loginForm: {
                    userName: "",
                    password: ""
                },
                checked: true,
                loading:false,
                rules: {
                    userName: [
                        {required: true, message: '请输入信息', trigger: 'change'},
                        {min: 6, max: 16, message: '长度在 6 到 16 个字符', trigger: 'blur'}
                    ],
                    password: [
                        {required: true, message: '请输入信息', trigger: 'change'},
                        {min: 6, max: 16, message: '长度在 6 到 16 个字符', trigger: 'blur'}
                    ]
                }
            }
        }
    }
</script>

<style>
    #paper {
        background:url("../assets/img/bg/eva1.jpg") no-repeat;
        background-position: center;
        height: 100%;
        width: 100%;
        background-size: cover;
        position: fixed;
    }
    body{
        margin: 0;
    }
    .login-container {
        border-radius: 15px;
        background-clip: padding-box;
        margin: 90px auto;
        width: 350px;
        padding: 35px 35px 15px 35px;
        background: #fff;
        border: 1px solid #eaeaea;
        box-shadow: 0 0 25px #cac6c6;
    }
    .login_title {
        margin: 0px auto 40px auto;
        text-align: center;
        color: #505458;
    }
    .login_remember {
        margin: 0px 0px 35px 0px;
        text-align: left;
    }
</style>