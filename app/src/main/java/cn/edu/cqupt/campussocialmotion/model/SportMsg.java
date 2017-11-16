package cn.edu.cqupt.campussocialmotion.model;

import java.util.List;

/**
 * Created by wentai on 17-11-5.
 */

public class SportMsg {


    /**
     * code : 200
     * message : OK#成功返回
     * body : [{"activityId":1,"activityName":"大扫除","initiator":"2015210098","content":"要大扫除啦","remarks":"暂无","initTime":0,"startTime":20150203121212,"endTime":20161111111111,"location":"老操场","peopleNeeds":12,"peopleHave":2,"activityPic":"/pic/23.jpg","activityOrRace":"active","clickNumber":0},{"activityId":42,"activityName":"测试","initiator":"2015210105","content":"你好","remarks":"暂无","initTime":989787223,"startTime":998672836,"endTime":1520888888888,"location":"中心食堂","peopleNeeds":20,"peopleHave":0,"activityPic":null,"activityOrRace":"active","clickNumber":0}]
     */

    private int code;
    private String message;
    private List<BodyBean> body;

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

    public List<BodyBean> getBody() {
        return body;
    }

    public void setBody(List<BodyBean> body) {
        this.body = body;
    }

    public static class BodyBean {

        @Override
        public String toString() {
            return "BodyBean{" +
                    "activityId=" + activityId +
                    ", activityName='" + activityName + '\'' +
                    ", initiator='" + initiator + '\'' +
                    ", content='" + content + '\'' +
                    ", remarks='" + remarks + '\'' +
                    ", initTime=" + initTime +
                    ", startTime=" + startTime +
                    ", endTime=" + endTime +
                    ", location='" + location + '\'' +
                    ", peopleNeeds=" + peopleNeeds +
                    ", peopleHave=" + peopleHave +
                    ", activityPic='" + activityPic + '\'' +
                    ", activityOrRace='" + activityOrRace + '\'' +
                    ", clickNumber=" + clickNumber +
                    '}';
        }

        /**
         * activityId : 1
         * activityName : 大扫除
         * initiator : 2015210098
         * content : 要大扫除啦
         * remarks : 暂无
         * initTime : 0
         * startTime : 20150203121212
         * endTime : 20161111111111
         * location : 老操场
         * peopleNeeds : 12
         * peopleHave : 2
         * activityPic : /pic/23.jpg
         * activityOrRace : active
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

        public void setInitTime(int initTime) {
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
}
