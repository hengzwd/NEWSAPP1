package newsemc.com.awit.news.newsemcappdftl.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table SPECIAL_ACCOUNT_INFO.
*/
public class SpecialAccountInfoDao extends AbstractDao<SpecialAccountInfo, String> {

    public static final String TABLENAME = "SPECIAL_ACCOUNT_INFO";

    /**
     * Properties of entity SpecialAccountInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Companyid = new Property(0, String.class, "companyid", true, "COMPANYID");
        public final static Property Companyname = new Property(1, String.class, "companyname", false, "COMPANYNAME");
        public final static Property Account = new Property(2, String.class, "account", false, "ACCOUNT");
        public final static Property Password = new Property(3, String.class, "password", false, "PASSWORD");
        public final static Property Imei = new Property(4, String.class, "imei", false, "IMEI");
    };


    public SpecialAccountInfoDao(DaoConfig config) {
        super(config);
    }
    
    public SpecialAccountInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'SPECIAL_ACCOUNT_INFO' (" + //
                "'COMPANYID' TEXT PRIMARY KEY NOT NULL ," + // 0: companyid
                "'COMPANYNAME' TEXT," + // 1: companyname
                "'ACCOUNT' TEXT," + // 2: account
                "'PASSWORD' TEXT," + // 3: password
                "'IMEI' TEXT);"); // 4: imei
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'SPECIAL_ACCOUNT_INFO'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, SpecialAccountInfo entity) {
        stmt.clearBindings();
 
        String companyid = entity.getCompanyid();
        if (companyid != null) {
            stmt.bindString(1, companyid);
        }
 
        String companyname = entity.getCompanyname();
        if (companyname != null) {
            stmt.bindString(2, companyname);
        }
 
        String account = entity.getAccount();
        if (account != null) {
            stmt.bindString(3, account);
        }
 
        String password = entity.getPassword();
        if (password != null) {
            stmt.bindString(4, password);
        }
 
        String imei = entity.getImei();
        if (imei != null) {
            stmt.bindString(5, imei);
        }
    }

    /** @inheritdoc */
    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public SpecialAccountInfo readEntity(Cursor cursor, int offset) {
        SpecialAccountInfo entity = new SpecialAccountInfo( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // companyid
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // companyname
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // account
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // password
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // imei
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, SpecialAccountInfo entity, int offset) {
        entity.setCompanyid(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setCompanyname(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setAccount(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setPassword(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setImei(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
     }
    
    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(SpecialAccountInfo entity, long rowId) {
        return entity.getCompanyid();
    }
    
    /** @inheritdoc */
    @Override
    public String getKey(SpecialAccountInfo entity) {
        if(entity != null) {
            return entity.getCompanyid();
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
