## 校园运动社交APP

1.接入重邮学生接口
2.初步完成登录和主页面底部栏的设计
###### 2017.10.30

登录接口https://wx.idsbllp.cn/api/verify
以Post方式提交stuNum,idNum表单
``` java
@FormUrlEncoded
@POST(Const.VERIFY)
Observable<User.UserWrapper> verify(@Field("stuNum") String stuNum, @Field("idNum") String idNum);
```
