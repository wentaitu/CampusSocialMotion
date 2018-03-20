package cn.edu.cqupt.campussocialmotion.model;

/**
 * Created by wentai on 18-3-8.
 */

public class PlaygroundModel {

    private int playgroundImgId;
    private String name;

    public PlaygroundModel(int playgroundImgId, String name) {
        this.playgroundImgId = playgroundImgId;
        this.name = name;
    }

    public int getPlaygroundImgId() {
        return playgroundImgId;
    }

    public void setPlaygroundImgId(int playgroundImgId) {
        this.playgroundImgId = playgroundImgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
