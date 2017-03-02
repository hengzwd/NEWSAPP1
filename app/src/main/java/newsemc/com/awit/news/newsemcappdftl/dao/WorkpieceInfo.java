package newsemc.com.awit.news.newsemcappdftl.dao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table WORKPIECE_INFO.
 */
public class WorkpieceInfo {

    private String id;
    private String name;
    private String shidanwei;
    private String type;
    private String ctime;
    private String content;

    public WorkpieceInfo() {
    }

    public WorkpieceInfo(String id) {
        this.id = id;
    }

    public WorkpieceInfo(String id, String name, String shidanwei, String type, String ctime, String content) {
        this.id = id;
        this.name = name;
        this.shidanwei = shidanwei;
        this.type = type;
        this.ctime = ctime;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShidanwei() {
        return shidanwei;
    }

    public void setShidanwei(String shidanwei) {
        this.shidanwei = shidanwei;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}