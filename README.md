# 校园运动社交APP
开发中~~~

运行环境gradle4.1  Android Studio 3.0.1

### 开发日志
#### 2018.3.20
活动信息上传Server接入完毕
pro:活动人数:填写包括自己在内的所有人
get获取数据会显示包括自己在内的所有人(是否设置提示)
功能(待添加):人员未满,活动开始时间到,发布者可选择开始活动或者取消活动

#### 2018.3.5
1.数据库重新设计
2.接口更新
3.核心功能:预约和发布活动,在线约运动
  核心需求:人员不足,
4.软件设计文档更新
5.关闭初始登录方案:同一台手机首次登录即使用SharedPreferences将用户信息存入本地,故无预存储数据则用户为首次登录,有则直接使用此信息登录,无需再次输入
未添加退出登录按钮,点击退出登录则跳至登录界面,若为新帐号登录,此时本地数据如何处理(根据输入更新本地缓存)? 未登录直接退出App,下次点开会出现登录界面(退出登录应该删除用户记录)?
![](/pic/new_interface.gif)

#### 2017.11.25
1.重新合并代码，更新主活动fragment布局;
2.个人中心布局名变更 setting_layout->fragment_setting;
3.圈子布局名变更 activity_trend->fragment_trend;
4.Java类更名 原activity文件夹下TrendActivity 更名为 TrendFragment并放入fragment文件夹下.

***
#### 2017.10.30
1.接入重邮学生数据接口
2.初步完成登录和主页面底部栏的设计

登录接口https://wx.idsbllp***/api/*****

以Post方式提交stuNum,idNum表单
``` java
@FormUrlEncoded
@POST(Const.VERIFY)
Observable<User.UserWrapper> verify(@Field("stuNum") String stuNum, @Field("idNum") String idNum);
```
登录成功
```
{
  "status": 200,
  "info": "success",
  "data": {
    "stuNum": "2016000000",
    "name": "运动",
    "college": "**学院",
    "class": "111111",
    "classNum": "222222",
    "gender": "男",
    "major": "0404",
    "grade": "2016",
    "idNum": "333333"
  }
}
```
登录失败
```
{
  "status": 801,
  "info": "invalid parameter"
}
```
![](/pic/json.PNG)
![](/pic/first.gif)
```
android {
    compileSdkVersion 26
    defaultConfig {
        applicationId "cn.edu.cqupt.campussocialmotion"
        minSdkVersion 21
        targetSdkVersion 26
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation 'com.android.support:appcompat-v7:26.1.0'
...
...
```

