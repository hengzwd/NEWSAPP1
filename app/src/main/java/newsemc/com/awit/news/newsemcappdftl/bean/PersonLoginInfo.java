package newsemc.com.awit.news.newsemcappdftl.bean;

import java.util.List;

import newsemc.com.awit.news.newsemcappdftl.dao.DeptsInfo;
import newsemc.com.awit.news.newsemcappdftl.dao.SsidInfo;


/**
 * Created by Administrator on 2015/7/3.
 */
public class PersonLoginInfo {
    private SsidInfo ssidInfobj;
    private List<DeptsInfo> deptsInfoList;

    public SsidInfo getSsidInfobj() {
        return ssidInfobj;
    }

    public void setSsidInfobj(SsidInfo ssidInfobj) {
        this.ssidInfobj = ssidInfobj;
    }

    public List<DeptsInfo> getDeptsInfoList() {
        return deptsInfoList;
    }

    public void setDeptsInfoList(List<DeptsInfo> deptsInfoList) {
        this.deptsInfoList = deptsInfoList;
    }
}
