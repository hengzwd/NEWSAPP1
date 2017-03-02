package newsemc.com.awit.news.newsemcappdftl.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table MEASURE_DETAIL_INFO.
*/
public class MeasureDetailInfoDao extends AbstractDao<MeasureDetailInfo, String> {

    public static final String TABLENAME = "MEASURE_DETAIL_INFO";

    /**
     * Properties of entity MeasureDetailInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, String.class, "id", true, "ID");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Monitorobjectname = new Property(2, String.class, "monitorobjectname", false, "MONITOROBJECTNAME");
        public final static Property Peak = new Property(3, String.class, "peak", false, "PEAK");
        public final static Property Speed = new Property(4, String.class, "speed", false, "SPEED");
        public final static Property Warntime = new Property(5, String.class, "warntime", false, "WARNTIME");
        public final static Property Warnlevel = new Property(6, String.class, "warnlevel", false, "WARNLEVEL");
        public final static Property Dealflag = new Property(7, String.class, "dealflag", false, "DEALFLAG");
    };


    public MeasureDetailInfoDao(DaoConfig config) {
        super(config);
    }
    
    public MeasureDetailInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'MEASURE_DETAIL_INFO' (" + //
                "'ID' TEXT PRIMARY KEY NOT NULL ," + // 0: id
                "'NAME' TEXT," + // 1: name
                "'MONITOROBJECTNAME' TEXT," + // 2: monitorobjectname
                "'PEAK' TEXT," + // 3: peak
                "'SPEED' TEXT," + // 4: speed
                "'WARNTIME' TEXT," + // 5: warntime
                "'WARNLEVEL' TEXT," + // 6: warnlevel
                "'DEALFLAG' TEXT);"); // 7: dealflag
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'MEASURE_DETAIL_INFO'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, MeasureDetailInfo entity) {
        stmt.clearBindings();
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String monitorobjectname = entity.getMonitorobjectname();
        if (monitorobjectname != null) {
            stmt.bindString(3, monitorobjectname);
        }
 
        String peak = entity.getPeak();
        if (peak != null) {
            stmt.bindString(4, peak);
        }
 
        String speed = entity.getSpeed();
        if (speed != null) {
            stmt.bindString(5, speed);
        }
 
        String warntime = entity.getWarntime();
        if (warntime != null) {
            stmt.bindString(6, warntime);
        }
 
        String warnlevel = entity.getWarnlevel();
        if (warnlevel != null) {
            stmt.bindString(7, warnlevel);
        }
 
        String dealflag = entity.getDealflag();
        if (dealflag != null) {
            stmt.bindString(8, dealflag);
        }
    }

    /** @inheritdoc */
    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public MeasureDetailInfo readEntity(Cursor cursor, int offset) {
        MeasureDetailInfo entity = new MeasureDetailInfo( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // monitorobjectname
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // peak
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // speed
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // warntime
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // warnlevel
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7) // dealflag
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, MeasureDetailInfo entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setMonitorobjectname(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setPeak(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setSpeed(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setWarntime(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setWarnlevel(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setDealflag(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
     }
    
    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(MeasureDetailInfo entity, long rowId) {
        return entity.getId();
    }
    
    /** @inheritdoc */
    @Override
    public String getKey(MeasureDetailInfo entity) {
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