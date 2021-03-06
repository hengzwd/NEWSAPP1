package newsemc.com.awit.news.newsemcappdftl.dao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table SPECIAL_ACCOUNT_INFO.
 */
public class SpecialAccountInfo {

    private String companyid;
    private String companyname;
    private String account;
    private String password;
    private String imei;

    public SpecialAccountInfo() {
    }

    public SpecialAccountInfo(String companyid) {
        this.companyid = companyid;
    }

    public SpecialAccountInfo(String companyid, String companyname, String account, String password, String imei) {
        this.companyid = companyid;
        this.companyname = companyname;
        this.account = account;
        this.password = password;
        this.imei = imei;
    }

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

}
