package cn.edu.cqupt.campussocialmotion.model;

import java.util.List;

/**
 * Created by wentai on 17-11-5.
 */

public class SportMsg {


    /**
     * code : 200
     * message : OK#成功返回
     * body : [{"activeId":2,"activeName":"运动名2","sportsGroups":0,"activeIntroduction":"第二个活动","startTime":null,"endTime":null,"location":"风华","peopleNeeds":200,"peopleHave":2,"activePic":"/pic/12.jpg","activeOrRace":"race","clickNumber":2},{"activeId":1,"activeName":"运动名","sportsGroups":0,"activeIntroduction":"你好，但是AAABBB存储是哦安佛i问佛","startTime":1508993634000,"endTime":1512190739000,"location":"老操","peopleNeeds":10,"peopleHave":1,"activePic":"/pic/123.jpg","activeOrRace":"active","clickNumber":0}]
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
        /**
         * activeId : 2
         * activeName : 运动名2
         * sportsGroups : 0
         * activeIntroduction : 第二个活动
         * startTime : null
         * endTime : null
         * location : 风华
         * peopleNeeds : 200
         * peopleHave : 2
         * activePic : /pic/12.jpg
         * activeOrRace : race
         * clickNumber : 2
         */

        private int activeId;
        private String activeName;
        private int sportsGroups;
        private String activeIntroduction;
        private Object startTime;
        private Object endTime;
        private String location;
        private int peopleNeeds;
        private int peopleHave;
        private String activePic;
        private String activeOrRace;
        private int clickNumber;

        public int getActiveId() {
            return activeId;
        }

        public void setActiveId(int activeId) {
            this.activeId = activeId;
        }

        public String getActiveName() {
            return activeName;
        }

        public void setActiveName(String activeName) {
            this.activeName = activeName;
        }

        public int getSportsGroups() {
            return sportsGroups;
        }

        public void setSportsGroups(int sportsGroups) {
            this.sportsGroups = sportsGroups;
        }

        public String getActiveIntroduction() {
            return activeIntroduction;
        }

        public void setActiveIntroduction(String activeIntroduction) {
            this.activeIntroduction = activeIntroduction;
        }

        public Object getStartTime() {
            return startTime;
        }

        public void setStartTime(Object startTime) {
            this.startTime = startTime;
        }

        public Object getEndTime() {
            return endTime;
        }

        public void setEndTime(Object endTime) {
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

        public String getActivePic() {
            return activePic;
        }

        public void setActivePic(String activePic) {
            this.activePic = activePic;
        }

        public String getActiveOrRace() {
            return activeOrRace;
        }

        public void setActiveOrRace(String activeOrRace) {
            this.activeOrRace = activeOrRace;
        }

        public int getClickNumber() {
            return clickNumber;
        }

        public void setClickNumber(int clickNumber) {
            this.clickNumber = clickNumber;
        }
    }
}
