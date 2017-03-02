package newsemc.com.awit.news.newsemcappdftl.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table PERSON_INFO.
*/
public class PersonInfoDao extends AbstractDao<PersonInfo, String> {

    public static final String TABLENAME = "PERSON_INFO";

    /**
     * Properties of entity PersonInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property UserId = new Property(0, String.class, "userId", true, "USER_ID");
        public final static Property Ssid = new Property(1, String.class, "ssid", false, "SSID");
        public final static Property Name = new Property(2, String.class, "name", false, "NAME");
        public final static Property Contact = new Property(3, String.class, "contact", false, "CONTACT");
        public final static Property Sex = new Property(4, String.class, "sex", false, "SEX");
        public final static Property Account = new Property(5, String.class, "account", false, "ACCOUNT");
        public final static Property RelateAccount = new Property(6, String.class, "relateAccount", false, "RELATE_ACCOUNT");
        public final static Property Compname = new Property(7, String.class, "compname", false, "COMPNAME");
        public final static Property IdNo = new Property(8, String.class, "idNo", false, "ID_NO");
        public final static Property Compid = new Property(9, String.class, "compid", false, "COMPID");
    };

    private DaoSession daoSession;


    public PersonInfoDao(DaoConfig config) {
        super(config);
    }
    
    public PersonInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'PERSON_INFO' (" + //
                "'USER_ID' TEXT PRIMARY KEY NOT NULL ," + // 0: userId
                "'SSID' TEXT," + // 1: ssid
                "'NAME' TEXT," + // 2: name
                "'CONTACT' TEXT," + // 3: contact
                "'SEX' TEXT," + // 4: sex
                "'ACCOUNT' TEXT," + // 5: account
                "'RELATE_ACCOUNT' TEXT," + // 6: relateAccount
                "'COMPNAME' TEXT," + // 7: compname
                "'ID_NO' TEXT," + // 8: idNo
                "'COMPID' TEXT);"); // 9: compid
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'PERSON_INFO'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, PersonInfo entity) {
        stmt.clearBindings();
 
        String userId = entity.getUserId();
        if (userId != null) {
            stmt.bindString(1, userId);
        }
 
        String ssid = entity.getSsid();
        if (ssid != null) {
            stmt.bindString(2, ssid);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
 
        String contact = entity.getContact();
        if (contact != null) {
            stmt.bindString(4, contact);
        }
 
        String sex = entity.getSex();
        if (sex != null) {
            stmt.bindString(5, sex);
        }
 
        String account = entity.getAccount();
        if (account != null) {
            stmt.bindString(6, account);
        }
 
        String relateAccount = entity.getRelateAccount();
        if (relateAccount != null) {
            stmt.bindString(7, relateAccount);
        }
 
        String compname = entity.getCompname();
        if (compname != null) {
            stmt.bindString(8, compname);
        }
 
        String idNo = entity.getIdNo();
        if (idNo != null) {
            stmt.bindString(9, idNo);
        }

        String compid = entity.getCompid();
        if (idNo != null) {
            stmt.bindString(10, compid);
        }
    }

    @Override
    protected void attachEntity(PersonInfo entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public PersonInfo readEntity(Cursor cursor, int offset) {
        PersonInfo entity = new PersonInfo( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // userId
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // ssid
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // name
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // contact
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // sex
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // account
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // relateAccount
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // compname
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // idNo
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9) // compid
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, PersonInfo entity, int offset) {
        entity.setUserId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setSsid(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setContact(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setSex(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setAccount(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setRelateAccount(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setCompname(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setIdNo(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setIdNo(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
     }
    
    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(PersonInfo entity, long rowId) {
        return entity.getUserId();
    }
    
    /** @inheritdoc */
    @Override
    public String getKey(PersonInfo entity) {
        if(entity != null) {
            return entity.getUserId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
