package newsemc.com.awit.news.newsemcappdftl.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table PROJECT_INFO_DETAIL.
*/
public class ProjectInfoDetailDao extends AbstractDao<ProjectInfoDetail, String> {

    public static final String TABLENAME = "PROJECT_INFO_DETAIL";

    /**
     * Properties of entity ProjectInfoDetail.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Project_id = new Property(0, String.class, "project_id", true, "PROJECT_ID");
        public final static Property ProjectName = new Property(1, String.class, "projectName", false, "PROJECT_NAME");
        public final static Property ProjectType = new Property(2, String.class, "projectType", false, "PROJECT_TYPE");
        public final static Property ConxName = new Property(3, String.class, "conxName", false, "CONX_NAME");
        public final static Property ProjectSource = new Property(4, String.class, "projectSource", false, "PROJECT_SOURCE");
        public final static Property ProjectCode = new Property(5, String.class, "projectCode", false, "PROJECT_CODE");
        public final static Property ProjectLength = new Property(6, String.class, "projectLength", false, "PROJECT_LENGTH");
        public final static Property StartStation = new Property(7, String.class, "startStation", false, "START_STATION");
        public final static Property StopStation = new Property(8, String.class, "stopStation", false, "STOP_STATION");
        public final static Property StartDate = new Property(9, String.class, "startDate", false, "START_DATE");
        public final static Property StopDate = new Property(10, String.class, "stopDate", false, "STOP_DATE");
        public final static Property StationNum = new Property(11, String.class, "stationNum", false, "STATION_NUM");
        public final static Property Invest = new Property(12, String.class, "invest", false, "INVEST");
        public final static Property StartMile = new Property(13, String.class, "startMile", false, "START_MILE");
        public final static Property StopMile = new Property(14, String.class, "stopMile", false, "STOP_MILE");
        public final static Property DesignCorpName = new Property(15, String.class, "designCorpName", false, "DESIGN_CORP_NAME");
        public final static Property ExamineCorpName = new Property(16, String.class, "examineCorpName", false, "EXAMINE_CORP_NAME");
        public final static Property ProCity = new Property(17, String.class, "proCity", false, "PRO_CITY");
        public final static Property ProStation = new Property(18, String.class, "proStation", false, "PRO_STATION");
        public final static Property Description = new Property(19, String.class, "description", false, "DESCRIPTION");
    };


    public ProjectInfoDetailDao(DaoConfig config) {
        super(config);
    }
    
    public ProjectInfoDetailDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'PROJECT_INFO_DETAIL' (" + //
                "'PROJECT_ID' TEXT PRIMARY KEY NOT NULL ," + // 0: project_id
                "'PROJECT_NAME' TEXT," + // 1: projectName
                "'PROJECT_TYPE' TEXT," + // 2: projectType
                "'CONX_NAME' TEXT," + // 3: conxName
                "'PROJECT_SOURCE' TEXT," + // 4: projectSource
                "'PROJECT_CODE' TEXT," + // 5: projectCode
                "'PROJECT_LENGTH' TEXT," + // 6: projectLength
                "'START_STATION' TEXT," + // 7: startStation
                "'STOP_STATION' TEXT," + // 8: stopStation
                "'START_DATE' TEXT," + // 9: startDate
                "'STOP_DATE' TEXT," + // 10: stopDate
                "'STATION_NUM' TEXT," + // 11: stationNum
                "'INVEST' TEXT," + // 12: invest
                "'START_MILE' TEXT," + // 13: startMile
                "'STOP_MILE' TEXT," + // 14: stopMile
                "'DESIGN_CORP_NAME' TEXT," + // 15: designCorpName
                "'EXAMINE_CORP_NAME' TEXT," + // 16: examineCorpName
                "'PRO_CITY' TEXT," + // 17: proCity
                "'PRO_STATION' TEXT," + // 18: proStation
                "'DESCRIPTION' TEXT);"); // 19: description
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'PROJECT_INFO_DETAIL'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, ProjectInfoDetail entity) {
        stmt.clearBindings();
 
        String project_id = entity.getProject_id();
        if (project_id != null) {
            stmt.bindString(1, project_id);
        }
 
        String projectName = entity.getProjectName();
        if (projectName != null) {
            stmt.bindString(2, projectName);
        }
 
        String projectType = entity.getProjectType();
        if (projectType != null) {
            stmt.bindString(3, projectType);
        }
 
        String conxName = entity.getConxName();
        if (conxName != null) {
            stmt.bindString(4, conxName);
        }
 
        String projectSource = entity.getProjectSource();
        if (projectSource != null) {
            stmt.bindString(5, projectSource);
        }
 
        String projectCode = entity.getProjectCode();
        if (projectCode != null) {
            stmt.bindString(6, projectCode);
        }
 
        String projectLength = entity.getProjectLength();
        if (projectLength != null) {
            stmt.bindString(7, projectLength);
        }
 
        String startStation = entity.getStartStation();
        if (startStation != null) {
            stmt.bindString(8, startStation);
        }
 
        String stopStation = entity.getStopStation();
        if (stopStation != null) {
            stmt.bindString(9, stopStation);
        }
 
        String startDate = entity.getStartDate();
        if (startDate != null) {
            stmt.bindString(10, startDate);
        }
 
        String stopDate = entity.getStopDate();
        if (stopDate != null) {
            stmt.bindString(11, stopDate);
        }
 
        String stationNum = entity.getStationNum();
        if (stationNum != null) {
            stmt.bindString(12, stationNum);
        }
 
        String invest = entity.getInvest();
        if (invest != null) {
            stmt.bindString(13, invest);
        }
 
        String startMile = entity.getStartMile();
        if (startMile != null) {
            stmt.bindString(14, startMile);
        }
 
        String stopMile = entity.getStopMile();
        if (stopMile != null) {
            stmt.bindString(15, stopMile);
        }
 
        String designCorpName = entity.getDesignCorpName();
        if (designCorpName != null) {
            stmt.bindString(16, designCorpName);
        }
 
        String examineCorpName = entity.getExamineCorpName();
        if (examineCorpName != null) {
            stmt.bindString(17, examineCorpName);
        }
 
        String proCity = entity.getProCity();
        if (proCity != null) {
            stmt.bindString(18, proCity);
        }
 
        String proStation = entity.getProStation();
        if (proStation != null) {
            stmt.bindString(19, proStation);
        }
 
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(20, description);
        }
    }

    /** @inheritdoc */
    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public ProjectInfoDetail readEntity(Cursor cursor, int offset) {
        ProjectInfoDetail entity = new ProjectInfoDetail( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // project_id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // projectName
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // projectType
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // conxName
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // projectSource
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // projectCode
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // projectLength
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // startStation
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // stopStation
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // startDate
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // stopDate
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // stationNum
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // invest
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // startMile
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // stopMile
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // designCorpName
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // examineCorpName
            cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), // proCity
            cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), // proStation
            cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19) // description
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, ProjectInfoDetail entity, int offset) {
        entity.setProject_id(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setProjectName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setProjectType(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setConxName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setProjectSource(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setProjectCode(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setProjectLength(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setStartStation(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setStopStation(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setStartDate(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setStopDate(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setStationNum(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setInvest(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setStartMile(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setStopMile(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setDesignCorpName(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setExamineCorpName(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setProCity(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setProStation(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        entity.setDescription(cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
     }
    
    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(ProjectInfoDetail entity, long rowId) {
        return entity.getProject_id();
    }
    
    /** @inheritdoc */
    @Override
    public String getKey(ProjectInfoDetail entity) {
        if(entity != null) {
            return entity.getProject_id();
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
