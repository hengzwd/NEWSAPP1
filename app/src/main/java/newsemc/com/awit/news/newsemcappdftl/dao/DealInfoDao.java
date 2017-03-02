package newsemc.com.awit.news.newsemcappdftl.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table DEAL_INFO.
*/
public class DealInfoDao extends AbstractDao<DealInfo, String> {

    public static final String TABLENAME = "DEAL_INFO";

    /**
     * Properties of entity DealInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Handledesc = new Property(0, String.class, "handledesc", true, "HANDLEDESC");
        public final static Property Status = new Property(1, String.class, "status", false, "STATUS");
        public final static Property Dealuser = new Property(2, String.class, "dealuser", false, "DEALUSER");
        public final static Property Warndealtime = new Property(3, String.class, "warndealtime", false, "WARNDEALTIME");
    };


    public DealInfoDao(DaoConfig config) {
        super(config);
    }
    
    public DealInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'DEAL_INFO' (" + //
                "'HANDLEDESC' TEXT PRIMARY KEY NOT NULL ," + // 0: handledesc
                "'STATUS' TEXT," + // 1: status
                "'DEALUSER' TEXT," + // 2: dealuser
                "'WARNDEALTIME' TEXT);"); // 3: warndealtime
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'DEAL_INFO'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, DealInfo entity) {
        stmt.clearBindings();
 
        String handledesc = entity.getHandledesc();
        if (handledesc != null) {
            stmt.bindString(1, handledesc);
        }
 
        String status = entity.getStatus();
        if (status != null) {
            stmt.bindString(2, status);
        }
 
        String dealuser = entity.getDealuser();
        if (dealuser != null) {
            stmt.bindString(3, dealuser);
        }
 
        String warndealtime = entity.getWarndealtime();
        if (warndealtime != null) {
            stmt.bindString(4, warndealtime);
        }
    }

    /** @inheritdoc */
    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public DealInfo readEntity(Cursor cursor, int offset) {
        DealInfo entity = new DealInfo( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // handledesc
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // status
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // dealuser
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // warndealtime
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, DealInfo entity, int offset) {
        entity.setHandledesc(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setStatus(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setDealuser(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setWarndealtime(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(DealInfo entity, long rowId) {
        return entity.getHandledesc();
    }
    
    /** @inheritdoc */
    @Override
    public String getKey(DealInfo entity) {
        if(entity != null) {
            return entity.getHandledesc();
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
