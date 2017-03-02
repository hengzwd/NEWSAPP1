package newsemc.com.awit.news.newsemcappdftl.dao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table PROBLEM_INFO.
 */
public class ProblemInfo {

    private String projectnam;
    private String detail;
    private String advice;
    private String createat;

    public ProblemInfo() {
    }

    public ProblemInfo(String projectnam) {
        this.projectnam = projectnam;
    }

    public ProblemInfo(String projectnam, String detail, String advice, String createat) {
        this.projectnam = projectnam;
        this.detail = detail;
        this.advice = advice;
        this.createat = createat;
    }

    public String getProjectnam() {
        return projectnam;
    }

    public void setProjectnam(String projectnam) {
        this.projectnam = projectnam;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public String getCreateat() {
        return createat;
    }

    public void setCreateat(String createat) {
        this.createat = createat;
    }

}
