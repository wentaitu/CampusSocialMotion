package cn.edu.cqupt.campussocialmotion.model;

import java.io.Serializable;

public class User implements Serializable{
    public User() {
    }

    public String id = "";
    public String stuNum = "";
    public String idNum = "";
    public String name = "";
    public String gender = "";
    public String classNum = "";
    public String major = "";
    public String college = "";
    public String grade = "";
    public String stu = "";
    public String photo_thumbnail_src = "";
    public String photo_src = "";
    public String nickname = "";
    public String qq = "";
    public String phone = "";
    public String introduction = "";

    @Override
    public String toString() {
        return "User{" +
                "classNum='" + classNum + '\'' +
                ", stuNum='" + stuNum + '\'' +
                ", idNum='" + idNum + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", major='" + major + '\'' +
                ", college='" + college + '\'' +
                ", grade='" + grade + '\'' +
                ", stu='" + stu + '\'' +
                ", photo_thumbnail_src='" + photo_thumbnail_src + '\'' +
                ", photo_src='" + photo_src + '\'' +
                ", nickname='" + nickname + '\'' +
                ", qq='" + qq + '\'' +
                ", phone='" + phone + '\'' +
                ", introduction='" + introduction + '\'' +
                ",id=" + id + "\'" +
                '}';
    }

    public static class UserWrapper extends RedrockApiWrapper<User> {
    }

}
