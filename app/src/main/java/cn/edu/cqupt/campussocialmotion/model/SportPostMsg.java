package cn.edu.cqupt.campussocialmotion.model;

/**
 * Created by wentai on 17-11-11.
 */

public class SportPostMsg {
    /**
     * code : 200
     * message : OK#成功返回
     * body : {"activityId":105,"activityName":"第14次测试","initiator":"2015210105","content":"能否传图片","remarks":"这是备注","initTime":1610771865254,"startTime":1510762874151,"endTime":1610771865254,"location":"中心食堂","peopleNeeds":22,"peopleHave":0,"activityPic":"1511059726816a.jpg","activityOrRace":"activity","clickNumber":0}
     */

    private int code;
    private String message;
    private BodyBean body;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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
         * activityId : 105
         * activityName : 第14次测试
         * initiator : 2015210105
         * content : 能否传图片
         * remarks : 这是备注
         * initTime : 1610771865254
         * startTime : 1510762874151
         * endTime : 1610771865254
         * location : 中心食堂
         * peopleNeeds : 22
         * peopleHave : 0
         * activityPic : 1511059726816a.jpg
         * activityOrRace : activity
         * clickNumber : 0
         */

        private int activityId;
        private String activityName;
        private String initiator;
        private String content;
        private String remarks;
        private long initTime;
        private long startTime;
        private long endTime;
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

        public long getStartTime() {
            return startTime;
        }

        public void setStartTime(long startTime) {
            this.startTime = startTime;
        }

        public long getEndTime() {
            return endTime;
        }

        public void setEndTime(long endTime) {
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
