package cn.edu.cqupt.campussocialmotion.model;

/**
 * Created by wentai on 18-3-4.
 */

public class LoginFormAppServer {

    /**
     * statusCode : 200
     * message : OK#成功返回
     * body : {"id":2016214073,"userName":"涂文泰","gender":"男","password":"128670","nickName":"涂文泰","qqNum":null,"telephoneNum":null,"profilePic":null,"ability":1,"classNum":null,"control":null,"college":"软件工程学院"}
     */

    private int statusCode;
    private String message;
    private BodyBean body;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public static class BodyBean {
        /**
         * id : 2016214073
         * userName : 涂文泰
         * gender : 男
         * password : 128670
         * nickName : 涂文泰
         * qqNum : null
         * telephoneNum : null
         * profilePic : null
         * ability : 1
         * classNum : null
         * control : null
         * college : 软件工程学院
         */

        private int id;
        private String userName;
        private String gender;
        private String password;
        private String nickName;
        private Object qqNum;
        private Object telephoneNum;
        private Object profilePic;
        private int ability;
        private Object classNum;
        private Object control;
        private String college;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public Object getQqNum() {
            return qqNum;
        }

        public void setQqNum(Object qqNum) {
            this.qqNum = qqNum;
        }

        public Object getTelephoneNum() {
            return telephoneNum;
        }

        public void setTelephoneNum(Object telephoneNum) {
            this.telephoneNum = telephoneNum;
        }

        public Object getProfilePic() {
            return profilePic;
        }

        public void setProfilePic(Object profilePic) {
            this.profilePic = profilePic;
        }

        public int getAbility() {
            return ability;
        }

        public void setAbility(int ability) {
            this.ability = ability;
        }

        public Object getClassNum() {
            return classNum;
        }

        public void setClassNum(Object classNum) {
            this.classNum = classNum;
        }

        public Object getControl() {
            return control;
        }

        public void setControl(Object control) {
            this.control = control;
        }

        public String getCollege() {
            return college;
        }

        public void setCollege(String college) {
            this.college = college;
        }
    }

    @Override
    public String toString() {
        return "LoginFormAppServer{" +
                "statusCode=" + statusCode +
                ", message='" + message + '\'' +
                ", body=" + body +
                '}';
    }
}
