<template>

    <div id="userManager">

        <div>
            <el-dialog :visible.sync="dialogTableVisible" >
                <el-form  :model="ruleForm"  :rules="rules" ref="ruleForm" >

                    <el-form-item label="编号" prop="id">
                        <el-input v-model="ruleForm.id" readOnly></el-input>
                    </el-form-item>

                    <el-form-item  label="账号" prop="userName">
                        <el-input v-model="ruleForm.userName"></el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="submitForm('ruleForm')">修改</el-button>
                        <el-button @click="dialogTableVisible = false" >取消</el-button>

                    </el-form-item>
                </el-form>
            </el-dialog>
        </div>

        <el-table
                :data="tableData"
                border
                :header-cell-style="{background:'#fffaf0',color:'#292421'}"
                >
            <el-table-column
                    fixed
                    prop="id"
                    label="编号">
            </el-table-column>
            <el-table-column
                    prop="userName"
                    label="账号">
            </el-table-column>

            <el-table-column label="操作">

                <template slot-scope="scope">
                    <el-button size="mini" @click="edit( scope.row)">修改</el-button>
                    <el-button size="mini" type="danger"  @click="userDelete(scope.row)" >删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination
                background
                layout="prev, pager, next"
                :page-size= page_size
                :total= total
                @current-change="page">
        </el-pagination>

    </div>




</template>



<!--//router route 跳转 带r 拿参数 用 route-->


<script>
    export default {

        inject:['reload'],
        methods: {

            submitForm(formName) {

                const _this = this;
                this.$refs[formName].validate((valid) => {
                    if (valid) {

                        this.$axios.put('http://127.0.0.1:8181/user/update',_this.ruleForm).then(function (resp) {
                            if (resp.data == 'success'){
                                // alert("添加成功")

                                _this.$message({
                                    showClose: true,
                                    message: ''+_this.ruleForm.userName+'\'的信息修改成功',
                                    type: 'success'
                                });
                                _this.reload()
                            }
                        })
                    } else {
                        _this.$message({
                            showClose: true,
                            message: '修改失败',
                            type: 'error'
                        });
                    }
                });
            },

            userDelete(row) {
                this.$confirm('确定删除该账号吗？', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    const _this = this;

                    this.$axios.delete('http://127.0.0.1:8181/user/deleteById/' + row.id).then(function () {
                        _this.$message({
                            showClose: true,
                            message: '' + row.userName + '\'删除成功',
                            type: 'success'
                        });
                        _this.reload()
                    });
                })
            },


            edit(row) {
                // this.$router.push("/UserUpdate")
                const  _this = this;
                // alert(row.id);

                this.$axios.get('http://127.0.0.1:8181/user/findById/'+row.id+'').then(function (resp) {

                    _this.ruleForm = resp.data;
                    _this.dialogTableVisible = true;
                })

            },

            page(currentPage) {
                const _this = this;
                const page_size = _this.page_size;
                this.$axios.get('http://127.0.0.1:8181/user/findAll/' + currentPage + '/' + page_size).then(function (resp) {
                    console.log(resp);
                    _this.tableData = resp.data.content;
                    _this.total = resp.data.totalElements
                })

            }
        },



        // 页面打开就加载下面的数据
        created() {
            const _this = this;
            const page_size = _this.page_size;
            this.$axios.get('http://127.0.0.1:8181/user/findAll/1/' + page_size + '').then(function (resp) {
                console.log(resp);
                _this.tableData = resp.data.content;
                _this.total = resp.data.totalElements
            })
        },

        data() {
            return {
                page_size: 5,
                total: null,
                tableData: null,
                ruleForm: {
                    id: null,
                    userName: null,

                },
                dialogTableVisible: false,

                rules: {
                    userName: [
                        { required: true, message: '请输入信息', trigger: 'change' },
                        { min: 6, max: 16, message: '长度在 6 到 16 个字符', trigger: 'blur' }
                    ]

                }


            };
        },


    }
</script>

<style>

</style>