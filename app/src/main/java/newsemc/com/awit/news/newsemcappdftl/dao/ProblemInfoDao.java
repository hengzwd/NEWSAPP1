package newsemc.com.awit.news.newsemcappdftl.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table PROBLEM_INFO.
*/
public class ProblemInfoDao extends AbstractDao<ProblemInfo, String> {

    public static final String TABLENAME = "PROBLEM_INFO";

    /**
     * Properties of entity ProblemInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Projectnam = new Property(0, String.class, "projectnam", true, "PROJECTNAM");
        public final static Property Detail = new Property(1, String.class, "detail", false, "DETAIL");
        public final static Property Advice = new Property(2, String.class, "advice", false, "ADVICE");
        public final static Property Createat = new Property(3, String.class, "createat", false, "CREATEAT");
    };


    public ProblemInfoDao(DaoConfig config) {
        super(config);
    }
    
    public ProblemInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'PROBLEM_INFO' (" + //
                "'PROJECTNAM' TEXT PRIMARY KEY NOT NULL ," + // 0: projectnam
                "'DETAIL' TEXT," + // 1: detail
                "'ADVICE' TEXT," + // 2: advice
                "'CREATEAT' TEXT);"); // 3: createat
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'PROBLEM_INFO'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, ProblemInfo entity) {
        stmt.clearBindings();
 
        String projectnam = entity.getProjectnam();
        if (projectnam != null) {
            stmt.bindString(1, projectnam);
        }
 
        String detail = entity.getDetail();
        if (detail != null) {
            stmt.bindString(2, detail);
        }
 
        String advice = entity.getAdvice();
        if (advice != null) {
            stmt.bindString(3, advice);
        }
 
        String createat = entity.getCreateat();
        if (createat != null) {
            stmt.bindString(4, createat);
        }
    }

    /** @inheritdoc */
    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public ProblemInfo readEntity(Cursor cursor, int offset) {
        ProblemInfo entity = new ProblemInfo( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // projectnam
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // detail
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // advice
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // createat
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, ProblemInfo entity, int offset) {
        entity.setProjectnam(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setDetail(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setAdvice(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setCreateat(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(ProblemInfo entity, long rowId) {
        return entity.getProjectnam();
    }
    
    /** @inheritdoc */
    @Override
    public String getKey(ProblemInfo entity) {
        if(entity != null) {
            return entity.getProjectnam();
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
