package newsemc.com.awit.news.newsemcappdftl.dao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table BHZ_INFO.
 */
public class BhzInfo {

    private String sectionname;
    private String bhjtotal;
    private String bhjusenum;
    private String volume;
    private String pannum;
    private String mixwarnnum;
    private String mixratio;
    private String matlwarnnum;
    private String matlratio;
    private String maltdisratio;

    public BhzInfo() {
    }

    public BhzInfo(String sectionname) {
        this.sectionname = sectionname;
    }

    public BhzInfo(String sectionname, String bhjtotal, String bhjusenum, String volume, String pannum, String mixwarnnum, String mixratio, String matlwarnnum, String matlratio, String maltdisratio) {
        this.sectionname = sectionname;
        this.bhjtotal = bhjtotal;
        this.bhjusenum = bhjusenum;
        this.volume = volume;
        this.pannum = pannum;
        this.mixwarnnum = mixwarnnum;
        this.mixratio = mixratio;
        this.matlwarnnum = matlwarnnum;
        this.matlratio = matlratio;
        this.maltdisratio = maltdisratio;
    }

    public String getSectionname() {
        return sectionname;
    }

    public void setSectionname(String sectionname) {
        this.sectionname = sectionname;
    }

    public String getBhjtotal() {
        return bhjtotal;
    }

    public void setBhjtotal(String bhjtotal) {
        this.bhjtotal = bhjtotal;
    }

    public String getBhjusenum() {
        return bhjusenum;
    }

    public void setBhjusenum(String bhjusenum) {
        this.bhjusenum = bhjusenum;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getPannum() {
        return pannum;
    }

    public void setPannum(String pannum) {
        this.pannum = pannum;
    }

    public String getMixwarnnum() {
        return mixwarnnum;
    }

    public void setMixwarnnum(String mixwarnnum) {
        this.mixwarnnum = mixwarnnum;
    }

    public String getMixratio() {
        return mixratio;
    }

    public void setMixratio(String mixratio) {
        this.mixratio = mixratio;
    }

    public String getMatlwarnnum() {
        return matlwarnnum;
    }

    public void setMatlwarnnum(String matlwarnnum) {
        this.matlwarnnum = matlwarnnum;
    }

    public String getMatlratio() {
        return matlratio;
    }

    public void setMatlratio(String matlratio) {
        this.matlratio = matlratio;
    }

    public String getMaltdisratio() {
        return maltdisratio;
    }

    public void setMaltdisratio(String maltdisratio) {
        this.maltdisratio = maltdisratio;
    }

}
