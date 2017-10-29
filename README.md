## 校园运动社交APP

###### 2017.10.30
运行环境gradle4.1  Android Studio 3.0

1.接入重邮学生接口
2.初步完成登录和主页面底部栏的设计

登录接口https://wx.idsbllp.cn/api/verify
以Post方式提交stuNum,idNum表单
``` java
@FormUrlEncoded
@POST(Const.VERIFY)
Observable<User.UserWrapper> verify(@Field("stuNum") String stuNum, @Field("idNum") String idNum);
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
```

