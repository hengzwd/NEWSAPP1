package newsemc.com.awit.news.newsemcappdftl.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table SCIENCE_INFO.
*/
public class ScienceInfoDao extends AbstractDao<ScienceInfo, String> {

    public static final String TABLENAME = "SCIENCE_INFO";

    /**
     * Properties of entity ScienceInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, String.class, "id", true, "ID");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Content = new Property(2, String.class, "content", false, "CONTENT");
        public final static Property Ctime = new Property(3, String.class, "ctime", false, "CTIME");
        public final static Property Shedanwei = new Property(4, String.class, "shedanwei", false, "SHEDANWEI");
        public final static Property Shidanwei = new Property(5, String.class, "shidanwei", false, "SHIDANWEI");
    };


    public ScienceInfoDao(DaoConfig config) {
        super(config);
    }
    
    public ScienceInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'SCIENCE_INFO' (" + //
                "'ID' TEXT PRIMARY KEY NOT NULL ," + // 0: id
                "'NAME' TEXT," + // 1: name
                "'CONTENT' TEXT," + // 2: content
                "'CTIME' TEXT," + // 3: ctime
                "'SHEDANWEI' TEXT," + // 4: shedanwei
                "'SHIDANWEI' TEXT);"); // 5: shidanwei
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'SCIENCE_INFO'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, ScienceInfo entity) {
        stmt.clearBindings();
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(3, content);
        }
 
        String ctime = entity.getCtime();
        if (ctime != null) {
            stmt.bindString(4, ctime);
        }
 
        String shedanwei = entity.getShedanwei();
        if (shedanwei != null) {
            stmt.bindString(5, shedanwei);
        }
 
        String shidanwei = entity.getShidanwei();
        if (shidanwei != null) {
            stmt.bindString(6, shidanwei);
        }
    }

    /** @inheritdoc */
    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public ScienceInfo readEntity(Cursor cursor, int offset) {
        ScienceInfo entity = new ScienceInfo( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // content
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // ctime
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // shedanwei
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5) // shidanwei
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, ScienceInfo entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setContent(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setCtime(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setShedanwei(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setShidanwei(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
     }
    
    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(ScienceInfo entity, long rowId) {
        return entity.getId();
    }
    
    /** @inheritdoc */
    @Override
    public String getKey(ScienceInfo entity) {
        if(entity != null) {
            return entity.getId();
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
