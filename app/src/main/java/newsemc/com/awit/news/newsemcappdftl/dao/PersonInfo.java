package newsemc.com.awit.news.newsemcappdftl.dao;

import java.util.List;

import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 

/**
 * Entity mapped to table PERSON_INFO.
 */
public class PersonInfo {

    private String userId;
    private String ssid;
    private String name;
    private String contact;
    private String sex;
    private String account;
    private String relateAccount;
    private String compname;
    private String idNo;
    private String compid;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient PersonInfoDao myDao;

    private List<DepartmentInfo> departmentInfoList;

    public PersonInfo() {
    }

    public PersonInfo(String userId) {
        this.userId = userId;
    }

    public PersonInfo(String userId, String ssid, String name, String contact, String sex, String account, String relateAccount, String compname, String idNo,String compid) {
        this.userId = userId;
        this.ssid = ssid;
        this.name = name;
        this.contact = contact;
        this.sex = sex;
        this.account = account;
        this.relateAccount = relateAccount;
        this.compname = compname;
        this.idNo = idNo;
        this.compid = compid;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getPersonInfoDao() : null;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRelateAccount() {
        return relateAccount;
    }

    public void setRelateAccount(String relateAccount) {
        this.relateAccount = relateAccount;
    }

    public String getCompname() {
        return compname;
    }

    public void setCompname(String compname) {
        this.compname = compname;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getCompid() {
        return compid;
    }

    public void setCompid(String compid) {
        this.compid = compid;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<DepartmentInfo> getDepartmentInfoList() {
        if (departmentInfoList == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            DepartmentInfoDao targetDao = daoSession.getDepartmentInfoDao();
            List<DepartmentInfo> departmentInfoListNew = targetDao._queryPersonInfo_DepartmentInfoList(userId);
            synchronized (this) {
                if(departmentInfoList == null) {
                    departmentInfoList = departmentInfoListNew;
                }
            }
        }
        return departmentInfoList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetDepartmentInfoList() {
        departmentInfoList = null;
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}
