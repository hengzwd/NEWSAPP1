package newsemc.com.awit.news.newsemcappdftl.dao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table PROJECT_INFO.
 */
public class ProjectInfo {

    private String id;
    private String pname;
    private String code;
    private String nameabbr;
    private String constructiondepId;
    private String bname;
    private String designCompanyName;
    private String examineCompanyName;
    private String startdate;
    private String rundate;
    private String updatedate;
    private String description;

    public ProjectInfo() {
    }

    public ProjectInfo(String id) {
        this.id = id;
    }

    public ProjectInfo(String id, String pname, String code, String nameabbr, String constructiondepId, String bname, String designCompanyName, String examineCompanyName, String startdate, String rundate, String updatedate, String description) {
        this.id = id;
        this.pname = pname;
        this.code = code;
        this.nameabbr = nameabbr;
        this.constructiondepId = constructiondepId;
        this.bname = bname;
        this.designCompanyName = designCompanyName;
        this.examineCompanyName = examineCompanyName;
        this.startdate = startdate;
        this.rundate = rundate;
        this.updatedate = updatedate;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNameabbr() {
        return nameabbr;
    }

    public void setNameabbr(String nameabbr) {
        this.nameabbr = nameabbr;
    }

    public String getConstructiondepId() {
        return constructiondepId;
    }

    public void setConstructiondepId(String constructiondepId) {
        this.constructiondepId = constructiondepId;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getDesignCompanyName() {
        return designCompanyName;
    }

    public void setDesignCompanyName(String designCompanyName) {
        this.designCompanyName = designCompanyName;
    }

    public String getExamineCompanyName() {
        return examineCompanyName;
    }

    public void setExamineCompanyName(String examineCompanyName) {
        this.examineCompanyName = examineCompanyName;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getRundate() {
        return rundate;
    }

    public void setRundate(String rundate) {
        this.rundate = rundate;
    }

    public String getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
