package newsemc.com.awit.news.newsemcappdftl.dao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table SECOND_MENU_INFO.
 */
public class SecondMenuInfo {

    private String id;
    private Integer level;
    private String name;
    private String pid;
    private String code;
    private Integer type;

    public SecondMenuInfo() {
    }

    public SecondMenuInfo(String id) {
        this.id = id;
    }

    public SecondMenuInfo(String id, Integer level, String name, String pid, String code, Integer type) {
        this.id = id;
        this.level = level;
        this.name = name;
        this.pid = pid;
        this.code = code;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}
