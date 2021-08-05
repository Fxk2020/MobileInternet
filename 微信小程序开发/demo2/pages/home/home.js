// home.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    name:'World',
    age:'18',
    students:[
      {id:201801,name:'fxk',age:18},
      {id:201802,name:'nyh',age:17},
      {id:201803,name:'myr',age:17},
      {id:201804,name:'gfj',age:17}
    ],
    counter:0
  },

  //监听+的函数；
  handleBtnClick(){
    // console.log('按钮发生了点击');
   // this.data.counter++;界面并不会刷新

   this.setData({
     counter:++this.data.counter
   })
  },

  //监听-的函数；
  handleBtnClick2(){
   this.setData({
     counter:--this.data.counter
   })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})