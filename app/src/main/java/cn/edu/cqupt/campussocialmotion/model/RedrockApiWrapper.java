package cn.edu.cqupt.campussocialmotion.model;

import java.io.Serializable;

public class RedrockApiWrapper<T> implements Serializable{

    public int status;
    public String info;
    public String version;
    public T data;
    public long id;

    @Override
    public String toString() {
        return "RedrockApiWrapper{" +
                "status=" + status +
                ", info='" + info + '\'' +
                ", version='" + version + '\'' +
                ", data=" + data +
                ", id=" + id +
                '}';
    }
}
