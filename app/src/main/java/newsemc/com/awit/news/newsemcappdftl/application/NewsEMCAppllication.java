package newsemc.com.awit.news.newsemcappdftl.application;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;
import java.util.List;

import newsemc.com.awit.news.newsemcappdftl.dao.CompanyInfo;
import newsemc.com.awit.news.newsemcappdftl.dao.DaoMaster;
import newsemc.com.awit.news.newsemcappdftl.dao.DaoSession;
import newsemc.com.awit.news.newsemcappdftl.dao.SpecialAccountInfo;
import newsemc.com.awit.news.newsemcappdftl.util.ValueConfig;


/**
 * Created by Administrator on 15-6-2.
 */
public class NewsEMCAppllication extends Application {
    private final String TAG = "NewsEMCAppllication";
    public static Context context;

    public static NewsEMCAppllication application;
    private static DaoMaster daoMaster;
    private static DaoSession daoSession;
    private static int myTid;
    private static Handler handler;
    private static int mainThreadId;
    private static Thread mainThread;
    public List<SpecialAccountInfo> specialAccountInfoList;
    public List<CompanyInfo> companyList;
    @Override
    public void onCreate() {

        super.onCreate();

        File cacheDir = StorageUtils.getOwnCacheDirectory(this, "emc/Cache");
        Log.e(TAG, cacheDir.getPath());
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .memoryCache(new WeakMemoryCache())
                .threadPoolSize(1)
                .diskCache(new UnlimitedDiscCache(cacheDir))
                .diskCacheSize(100 * 1024 * 1024)
                .diskCacheFileCount(500)
                .build();
        ImageLoader.getInstance().init(config);
        application=this;
        myTid = android.os.Process.myTid();
        //Context
        context = getApplicationContext();
        //mainThreadId
        mainThreadId = android.os.Process.myTid();
        //Thread-->object
        mainThread = Thread.currentThread();
        handler=new Handler();
    }

    // ���判断
    public static DaoMaster getDaoMaster(Context context){
        if(daoMaster == null){
            DaoMaster.OpenHelper helper = new DaoMaster.DevOpenHelper(context, ValueConfig.DB_JING,null);
            daoMaster = new DaoMaster(helper.getWritableDatabase());
        }
        return daoMaster;
    }

    public static DaoSession getDaoSession(Context context){
        if(daoSession == null){
            if(daoMaster == null){
                getDaoMaster(context);
            }
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }


    public static NewsEMCAppllication getApplication() {
        return application;
    }
    public static int getMyTid() {
        return myTid;
    }
    public static Handler getHandler() {
        return handler;
    }
    public static Context getContext() {
        return context;
    }
    public static int getMainThreadId() {
        return mainThreadId;
    }
    public static Thread getMainThread() {
        return mainThread;
    }
}
