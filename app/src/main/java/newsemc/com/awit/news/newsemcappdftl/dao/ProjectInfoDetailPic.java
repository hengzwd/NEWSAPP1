package newsemc.com.awit.news.newsemcappdftl.dao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table PROJECT_INFO_DETAIL_PIC.
 */
public class ProjectInfoDetailPic {

    private String projectPicName;
    private String projectPicUrl;
    private String projectPicId;

    public ProjectInfoDetailPic() {
    }

    public ProjectInfoDetailPic(String projectPicName) {
        this.projectPicName = projectPicName;
    }

    public ProjectInfoDetailPic(String projectPicName, String projectPicUrl, String projectPicId) {
        this.projectPicName = projectPicName;
        this.projectPicUrl = projectPicUrl;
        this.projectPicId = projectPicId;
    }

    public String getProjectPicName() {
        return projectPicName;
    }

    public void setProjectPicName(String projectPicName) {
        this.projectPicName = projectPicName;
    }

    public String getProjectPicUrl() {
        return projectPicUrl;
    }

    public void setProjectPicUrl(String projectPicUrl) {
        this.projectPicUrl = projectPicUrl;
    }

    public String getProjectPicId() {
        return projectPicId;
    }

    public void setProjectPicId(String projectPicId) {
        this.projectPicId = projectPicId;
    }

}
