### 学习小程序第一节课
#### 上节课回顾：Tag的使用
Tag相当于一个快照，记录某个项目的历史快照。

#### 初体验
##### 1.数据绑定和列表展示数据
Mustache语法：引用变量 数据绑定{{value}}
```javascript
<view>Hello {{name}}!</view>
```
wx:for语句(双大括号)
```javascript
<view wx:for="{{students}}">{{item.name}}:{{item.id}}</view>
```
##### 2.事件监听器
bindtap绑定一个监听函数；
```javascript
<button size="mini" bindtap="handleBtnClick">+</button>
  //监听+的函数；
  handleBtnClick(){
    // console.log('按钮发生了点击');
   // this.data.counter++;界面并不会刷新

   this.setData({
     counter:++this.data.counter
   })
  },
```
### MVVM架构
M:Model
V:view
VM:ViewModel

编程范式：命令式编程；声明式编程。
### 小程序的架构和配置
##### 小程序的配置文件：
* project.config.json：项目配置。
![J026UJ.png](https://s1.ax1x.com/2020/04/24/J026UJ.png)
* sitemap.json：做微信检索的
微信现已开放小程序内搜索，开发者可以通过 sitemap.json 配置，或者管理后台页面收录开关来配置其小程序页面是否允许微信索引。当开发者允许微信索引时，微信会通过爬虫的形式，为小程序的页面内容建立索引。当用户的搜索词条触发该索引时，小程序的页面将可能展示在搜索结果中。
* app.json:小程序的入口；配置全局
  * page：
  * window：导航栏
   ```javascript
   "window": {
    "navigationBarBackgroundColor": "#FFC0CB",
    "navigationBarTextStyle": "black",
    "navigationBarTitleText": "小程序学习",
    "backgroundColor": "#eeeeee",
    "backgroundTextStyle": "light",
    "enablePullDownRefresh": true
   }
   ```
  * tabBar
  ```javascript
  "tabBar": {
    "selectedColor": "#FFC0CB",//字体选中的颜色
    "list": [{
      "pagePath": "pages/home/home",
      "text": "首页",
      "iconPath": "assets/tabbar/home.png",
      "selectedIconPath": "assets/tabbar/home_active.png"
    },{
      "pagePath": "pages/about/about",
      "text": "分类",
      "iconPath": "assets/tabbar/category.png",
      "selectedIconPath": "assets/tabbar/category_active.png"
    }]
  },
  ```
 
* page.json：页面配置
```javascript
{
  "usingComponents": {},
  "navigationBarBackgroundColor": "#f50102",
  "navigationBarTitleText": "商品分类"
}
```

### 小程序的双线程模型
#### 1.小程序的宿主环境--微信客户端
![JsGtcd.png](https://s1.ax1x.com/2020/04/25/JsGtcd.png)
WXML模块和WXSS样式运行于渲染层，WebView
JS脚本运行于逻辑层，JsCore。
两类线程都会经由客户端交互。

wxml和dom树：
可以将wxml转换成js对象。

#### 2.小程序的启动流程
* app.js中的小程序的生命周期函数和定义全局变量
```javascript
App({

  /**
   * 当小程序初始化完成时，会触发 onLaunch（全局只触发一次）
   */
  onLaunch: function () {
    console.log('小程序初始化！');

    //用户信息
    wx.getUserInfo({
      complete: (res) => {console.log(res)},
    })

  },

  /**
   * 当小程序启动，或从后台进入前台显示，会触发 onShow
   */
  onShow: function (options) {
    console.log('页面显示出来！')
  },

  /**
   * 当小程序从前台进入后台，会触发 onHide
   */
  onHide: function () {
    console.log('程序进入后台')
  },

  /**
   * 当小程序发生脚本错误，或者 api 调用失败时，会触发 onError 并带上错误信息
   */
  onError: function (msg) {
    console.log('小程序发生错误！');
  },
   globalData:{
    name:'sunshine',
    age:21
  }
})
```
  * page.js
  页面的生命周期：
  监听页面事件：
  函数和全局变量：

