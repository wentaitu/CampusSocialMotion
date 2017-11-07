package cn.edu.cqupt.campussocialmotion.model;

import java.io.Serializable;

public class RedrockApiWrapper<T> implements Serializable{

    public int status;
    public String info;
    public String version;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
