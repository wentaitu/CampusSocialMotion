package cn.edu.cqupt.campussocialmotion.model;

/**
 * Created by wentai on 17-11-11.
 */

public class SportPostMsg {
    /**
     * statusCode : 200
     * message : OK#成功返回
     * body : {"activityId":140,"activityName":"乒乓球组队","initiator":"2016214073","content":"风雨操场乒乓球","remarks":"来人来人","initTime":1520515027000,"startTime":"2018-02-05 14:30","endTime":"2018-02-05 15:30","location":"风雨操场","peopleNeeds":1,"peopleHave":1,"activityPic":"2018-03-08_0.8850654977441016.JPG,2018-03-08_0.6010329986981587.JPG","activityOrRace":"activity","clickNumber":0}
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
         * activityId : 140
         * activityName : 乒乓球组队
         * initiator : 2016214073
         * content : 风雨操场乒乓球
         * remarks : 来人来人
         * initTime : 1520515027000
         * startTime : 2018-02-05 14:30
         * endTime : 2018-02-05 15:30
         * location : 风雨操场
         * peopleNeeds : 1
         * peopleHave : 1
         * activityPic : 2018-03-08_0.8850654977441016.JPG,2018-03-08_0.6010329986981587.JPG
         * activityOrRace : activity
         * clickNumber : 0
         */

        private int activityId;
        private String activityName;
        private String initiator;
        private String content;
        private String remarks;
        private long initTime;
        private String startTime;
        private String endTime;
        private String location;
        private int peopleNeeds;
        private int peopleHave;
        private String activityPic;
        private String activityOrRace;
        private int clickNumber;

        public int getActivityId() {
            return activityId;
        }

        public void setActivityId(int activityId) {
            this.activityId = activityId;
        }

        public String getActivityName() {
            return activityName;
        }

        public void setActivityName(String activityName) {
            this.activityName = activityName;
        }

        public String getInitiator() {
            return initiator;
        }

        public void setInitiator(String initiator) {
            this.initiator = initiator;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public long getInitTime() {
            return initTime;
        }

        public void setInitTime(long initTime) {
            this.initTime = initTime;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public int getPeopleNeeds() {
            return peopleNeeds;
        }

        public void setPeopleNeeds(int peopleNeeds) {
            this.peopleNeeds = peopleNeeds;
        }

        public int getPeopleHave() {
            return peopleHave;
        }

        public void setPeopleHave(int peopleHave) {
            this.peopleHave = peopleHave;
        }

        public String getActivityPic() {
            return activityPic;
        }

        public void setActivityPic(String activityPic) {
            this.activityPic = activityPic;
        }

        public String getActivityOrRace() {
            return activityOrRace;
        }

        public void setActivityOrRace(String activityOrRace) {
            this.activityOrRace = activityOrRace;
        }

        public int getClickNumber() {
            return clickNumber;
        }

        public void setClickNumber(int clickNumber) {
            this.clickNumber = clickNumber;
        }
    }


//    /**
//     * code : 200
//     * message : OK#成功返回
//     * body : {"activityId":105,"activityName":"第14次测试","initiator":"2015210105","content":"能否传图片","remarks":"这是备注","initTime":1610771865254,"startTime":1510762874151,"endTime":1610771865254,"location":"中心食堂","peopleNeeds":22,"peopleHave":0,"activityPic":"1511059726816a.jpg","activityOrRace":"activity","clickNumber":0}
//     */
//
//    private int code;
//    private String message;
//    private BodyBean body;
//
//    public int getCode() {
//        return code;
//    }
//
//    public void setCode(int code) {
//        this.code = code;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public BodyBean getBody() {
//        return body;
//    }
//
//    public void setBody(BodyBean body) {
//        this.body = body;
//    }
//
//    public static class BodyBean {
//        /**
//         * activityId : 105
//         * activityName : 第14次测试
//         * initiator : 2015210105
//         * content : 能否传图片
//         * remarks : 这是备注
//         * initTime : 1610771865254
//         * startTime : 1510762874151
//         * endTime : 1610771865254
//         * location : 中心食堂
//         * peopleNeeds : 22
//         * peopleHave : 0
//         * activityPic : 1511059726816a.jpg
//         * activityOrRace : activity
//         * clickNumber : 0
//         */
//
//        private int activityId;
//        private String activityName;
//        private String initiator;
//        private String content;
//        private String remarks;
//        private long initTime;
//        private long startTime;
//        private long endTime;
//        private String location;
//        private int peopleNeeds;
//        private int peopleHave;
//        private String activityPic;
//        private String activityOrRace;
//        private int clickNumber;
//
//        public int getActivityId() {
//            return activityId;
//        }
//
//        public void setActivityId(int activityId) {
//            this.activityId = activityId;
//        }
//
//        public String getActivityName() {
//            return activityName;
//        }
//
//        public void setActivityName(String activityName) {
//            this.activityName = activityName;
//        }
//
//        public String getInitiator() {
//            return initiator;
//        }
//
//        public void setInitiator(String initiator) {
//            this.initiator = initiator;
//        }
//
//        public String getContent() {
//            return content;
//        }
//
//        public void setContent(String content) {
//            this.content = content;
//        }
//
//        public String getRemarks() {
//            return remarks;
//        }
//
//        public void setRemarks(String remarks) {
//            this.remarks = remarks;
//        }
//
//        public long getInitTime() {
//            return initTime;
//        }
//
//        public void setInitTime(long initTime) {
//            this.initTime = initTime;
//        }
//
//        public long getStartTime() {
//            return startTime;
//        }
//
//        public void setStartTime(long startTime) {
//            this.startTime = startTime;
//        }
//
//        public long getEndTime() {
//            return endTime;
//        }
//
//        public void setEndTime(long endTime) {
//            this.endTime = endTime;
//        }
//
//        public String getLocation() {
//            return location;
//        }
//
//        public void setLocation(String location) {
//            this.location = location;
//        }
//
//        public int getPeopleNeeds() {
//            return peopleNeeds;
//        }
//
//        public void setPeopleNeeds(int peopleNeeds) {
//            this.peopleNeeds = peopleNeeds;
//        }
//
//        public int getPeopleHave() {
//            return peopleHave;
//        }
//
//        public void setPeopleHave(int peopleHave) {
//            this.peopleHave = peopleHave;
//        }
//
//        public String getActivityPic() {
//            return activityPic;
//        }
//
//        public void setActivityPic(String activityPic) {
//            this.activityPic = activityPic;
//        }
//
//        public String getActivityOrRace() {
//            return activityOrRace;
//        }
//
//        public void setActivityOrRace(String activityOrRace) {
//            this.activityOrRace = activityOrRace;
//        }
//
//        public int getClickNumber() {
//            return clickNumber;
//        }
//
//        public void setClickNumber(int clickNumber) {
//            this.clickNumber = clickNumber;
//        }
//    }

}
