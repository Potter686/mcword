import Vue from 'vue'
import VueRouter from 'vue-router'
import UserManager from "../views/UserManager";
import App from "../App";
import AddUser from "../views/AddUser";
// import UserUpdate from "../views/UserUpdate";
import PageFour from "../views/PageFour";
import Index from "../views/Index";
import LoginIn from "../views/LoginIn";
import NavMenu from '../components/common/NavMenu'
import Home from "../components/Home";
import HomePage from "../components/HomePage";
import BookIndex from "../components/Book/BookIndex";
import ArticleEditor from "../components/article/ArticleEditor";
import ArticleView from "../components/article/ArticleView";
import ArticleShow from "../components/article/ArticleShow";


Vue.use(VueRouter);

  const routes = [
    {
      path: "/Home",
      show:true,
      name: "用户管理",
      component: Index,
      //重定向 吧 / 目录重定向到下面目录
      redirect:"/LoginIn",
      children:[
        {
          path: "/UserManager",
          name: "查询",
          component: UserManager
        },
        {
          path: "/AddUser",
          name: "添加",
          component: AddUser
        },
        {
          path: "/PageFour",
          name: "test",
          component: PageFour
        },


      ]
    },
    // {
    //   path: "/UserUpdate",
    //   show: false,
    //   component: UserUpdate
    // }




    {
      path: "/LoginIn",
      show: false,
      component: LoginIn
    },
    {
      path:"/",
      name:"Home" ,
      component: Home,
      redirect:"/ArticleView",
      children:[
        {
          path: "/HomePage",
          name: "HomePage",
          component: HomePage
        },
        {
          path: "/BookIndex",
          name: "BookIndex",
          component: BookIndex
        },
        {
          path: "/ArticleEditor",
          name: "ArticleEditor",
          component: ArticleEditor
        },
        {
          path: "/ArticleView",
          name: "ArticleView",
          component: ArticleView
        },
        {
            path:"/ArticleShow",
            name:"ArticleShow",
            component:ArticleShow
        }


        // {
        //   path:"/NavMenu",
        //   show:false,
        //   component:NavMenu,
        //   name :"NavMenu",
        //   //meta 标签用于设置HTML的元数据，该数据不会显示在页面在中，主要用于浏览器
        //   meta: {
        //     requireAuth: true
        //   }
        // },
      ]
    },





];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
});

export default router
