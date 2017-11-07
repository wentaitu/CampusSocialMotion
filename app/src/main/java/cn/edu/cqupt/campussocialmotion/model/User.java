package cn.edu.cqupt.campussocialmotion.model;

import java.io.Serializable;

public class User implements Serializable {
    private static final long suid = 444444444;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getStu() {
        return stu;
    }

    public void setStu(String stu) {
        this.stu = stu;
    }

    public String getPhoto_thumbnail_src() {
        return photo_thumbnail_src;
    }

    public void setPhoto_thumbnail_src(String photo_thumbnail_src) {
        this.photo_thumbnail_src = photo_thumbnail_src;
    }

    public String getPhoto_src() {
        return photo_src;
    }

    public void setPhoto_src(String photo_src) {
        this.photo_src = photo_src;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

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
