package newsemc.com.awit.news.newsemcappdftl.dao;

import java.util.List;

import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 

/**
 * Entity mapped to table LOGIN_INFO.
 */
public class LoginInfo {

    private String userId;
    private String account;
    private String name;
    private String contact;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient LoginInfoDao myDao;

    private List<DepartsInfo> departsInfoList;

    public LoginInfo() {
    }

    public LoginInfo(String userId) {
        this.userId = userId;
    }

    public LoginInfo(String userId, String account, String name, String contact) {
        this.userId = userId;
        this.account = account;
        this.name = name;
        this.contact = contact;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getLoginInfoDao() : null;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<DepartsInfo> getDepartsInfoList() {
        if (departsInfoList == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            DepartsInfoDao targetDao = daoSession.getDepartsInfoDao();
            List<DepartsInfo> departsInfoListNew = targetDao._queryLoginInfo_DepartsInfoList(userId);
            synchronized (this) {
                if(departsInfoList == null) {
                    departsInfoList = departsInfoListNew;
                }
            }
        }
        return departsInfoList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetDepartsInfoList() {
        departsInfoList = null;
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
