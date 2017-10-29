package cn.edu.cqupt.campussocialmotion.model;

public class RedrockApiWrapper<T> {

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
