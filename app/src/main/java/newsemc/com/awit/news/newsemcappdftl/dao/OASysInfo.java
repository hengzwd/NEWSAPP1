package newsemc.com.awit.news.newsemcappdftl.dao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table OASYS_INFO.
 */
public class OASysInfo {

    private String fileid;
    private String handleid;
    private String detail;
    private String title;
    private String enddate;

    public OASysInfo() {
    }

    public OASysInfo(String fileid) {
        this.fileid = fileid;
    }

    public OASysInfo(String fileid, String handleid, String detail, String title, String enddate) {
        this.fileid = fileid;
        this.handleid = handleid;
        this.detail = detail;
        this.title = title;
        this.enddate = enddate;
    }

    public String getFileid() {
        return fileid;
    }

    public void setFileid(String fileid) {
        this.fileid = fileid;
    }

    public String getHandleid() {
        return handleid;
    }

    public void setHandleid(String handleid) {
        this.handleid = handleid;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

}
