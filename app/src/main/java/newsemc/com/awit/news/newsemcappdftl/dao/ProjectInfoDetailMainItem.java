package newsemc.com.awit.news.newsemcappdftl.dao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table PROJECT_INFO_DETAIL_MAIN_ITEM.
 */
public class ProjectInfoDetailMainItem {

    private String id;
    private String projectInfoId;
    private String kongzhiSection;

    public ProjectInfoDetailMainItem() {
    }

    public ProjectInfoDetailMainItem(String id) {
        this.id = id;
    }

    public ProjectInfoDetailMainItem(String id, String projectInfoId, String kongzhiSection) {
        this.id = id;
        this.projectInfoId = projectInfoId;
        this.kongzhiSection = kongzhiSection;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectInfoId() {
        return projectInfoId;
    }

    public void setProjectInfoId(String projectInfoId) {
        this.projectInfoId = projectInfoId;
    }

    public String getKongzhiSection() {
        return kongzhiSection;
    }

    public void setKongzhiSection(String kongzhiSection) {
        this.kongzhiSection = kongzhiSection;
    }

}