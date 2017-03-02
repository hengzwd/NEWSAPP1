package newsemc.com.awit.news.newsemcappdftl.interfaceImpl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.socks.library.KLog;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.util.ThrowableFailureEvent;
import newsemc.com.awit.news.newsemcappdftl.activity.MainActivity;
import newsemc.com.awit.news.newsemcappdftl.bean.FailRequest;
import newsemc.com.awit.news.newsemcappdftl.dao.ApkUpdateInfo;
import newsemc.com.awit.news.newsemcappdftl.interfaces.ApkDetailInter;
import newsemc.com.awit.news.newsemcappdftl.interfaces.HttpResultListener;
import newsemc.com.awit.news.newsemcappdftl.util.NetworkUtils;
import newsemc.com.awit.news.newsemcappdftl.util.SharedPreferencesUtils;
import newsemc.com.awit.news.newsemcappdftl.util.UIUtils;


/**
 * 获取apk详情信息接口
 * Created by sb on 2015/8/5.
 */
public class ApkDetailImpl implements ApkDetailInter {
    private AppCallBack callBack;
    private String TAG="ApkDetailImpl";
    private List<ApkUpdateInfo> apkUpdateInfoList;
    private FailRequest failRequestobj;
    private HttpResultListener httpResultListener;
    private Context mcontext;
    public ApkDetailImpl(HttpResultListener httpResultListener,Context context ,AppCallBack callBack){
        this.callBack = callBack;
        this.httpResultListener=httpResultListener;
        this.mcontext=context;
    }
    public ApkDetailImpl(HttpResultListener httpResultListener,AppCallBack callBack){
        this.callBack = callBack;
        this.httpResultListener=httpResultListener;
    }
    public ApkDetailImpl(HttpResultListener httpResultListener,Context context ){
        this.httpResultListener=httpResultListener;
        this.mcontext=context;
    }
    public ApkDetailImpl(HttpResultListener httpResultListener ){
        this.httpResultListener=httpResultListener;
    }


    @Override
    public void getApkDetail(String ssid, final String appId, final String appname ) {
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put("ssid", ssid);
        params.put("appId",appId);
        KLog.e("接口ssid",ssid);
//        client.setTimeout(ValueConfig.TIME_OUT);
//        String url = "http://www.r93535.com/gateway/inter/inter!getAppInfo.action";
        String url = "http://www.r93535.com/gateway/inter/inter!getAppInfox.action";
        client.post(
//                "http://192.168.0.157:8080/gateway/inter/inter!getAppInfo.action",
                url,
                params,
                new AsyncHttpResponseHandler() {
                    @Override
                    public void onFailure(int arg0, Header[] arg1, byte[] arg2,
                                          Throwable arg3) {
                        String actionname = MainActivity.appType1.get(appname);
                        startAppByAction(actionname, appname);
                        KLog.e("failure");
                        try {
                            Log.i(TAG, "onFailure:" + arg2);
                            String str = new String(arg2, "UTF-8");
                            JSONObject jsonObject = new JSONObject(str);
                            Log.i("url", arg3.toString());
                            if (!(jsonObject.getString("status").equals("0"))) {
                                failRequestobj = new FailRequest();
                                failRequestobj.setStatus(jsonObject.getString("status"));
                                failRequestobj.setMsg(jsonObject.getString("msg"));
                                if (callBack != null){
                                    callBack.myResultFailure(failRequestobj);
                                }
                                httpResultListener.onResult(failRequestobj);
//
//                                    KLog.e(NetworkUtils.isAvailable(mcontext));
//                                    KLog.e("无网络连接");

                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
                        KLog.e("success");
                        apkUpdateInfoList=new ArrayList<ApkUpdateInfo>();
                        JSONArray jsonArr;
                        JSONObject jsonObject;
                        JSONObject failjsonobj;
                        String data = null;
                        try {
                            String str = new String(arg2, "UTF-8");
                            Log.i(TAG, str);
                            jsonObject= new JSONObject(str);
                            KLog.e(jsonObject);
                            String s = jsonObject.getString("status");
                            Log.i(TAG, s);
                            if(Integer.parseInt(s) >0){
                                failRequestobj = new FailRequest();
                                failRequestobj.setStatus(jsonObject.getString("status"));
                                failRequestobj.setMsg(jsonObject.getString("msg"));
                                if (callBack != null){
                                    callBack.myResultFailure(failRequestobj);
                                }
                                httpResultListener.onResult(failRequestobj);


                            }else {
                                String dataobj = jsonObject.getString("data");
                                Log.i(TAG, dataobj);
                                JSONObject datao = new JSONObject(dataobj);
                                JSONArray dataarr = new JSONArray(datao.getString("list"));
                                Log.i(TAG, dataarr.toString());
                                for (int i = 0; i < dataarr.length(); i++) {
                                    data = dataarr.get(i).toString();
                                    jsonObject = new JSONObject(data);
                                    ApkUpdateInfo apkUpdateInfobj = new ApkUpdateInfo();
                                    apkUpdateInfobj.setId(jsonObject.getString("id"));
                                    apkUpdateInfobj.setName(jsonObject.getString("name"));
                                    apkUpdateInfobj.setApkName(jsonObject.getString("apkName"));
                                    apkUpdateInfobj.setAppId(jsonObject.getString("appId"));
                                    apkUpdateInfobj.setAppUrl(jsonObject.getString("appUrl"));
                                    apkUpdateInfobj.setDescription(jsonObject.getString("description"));
                                    apkUpdateInfobj.setPackName(jsonObject.getString("packName"));
                                    apkUpdateInfobj.setUploadTime(jsonObject.getString("uploadTime"));
                                    apkUpdateInfobj.setUseFlag(jsonObject.getString("useFlag"));
                                    apkUpdateInfobj.setVersionCode(jsonObject.getString("versionCode"));
                                    apkUpdateInfobj.setVersionName(jsonObject.getString("versionName"));
                                    apkUpdateInfobj.setApkSize(jsonObject.getString("apkSize"));
                                    apkUpdateInfoList.add(apkUpdateInfobj);
                                }
                                if (callBack != null) {
                                    callBack.myResult(apkUpdateInfoList);
                                }

                                if (appId == "18" || !(isAppInstalled(mcontext, jsonObject.getString("packName") == null ? "" : jsonObject.getString("packName").trim())))
                                {
                                    //访问下载链接appurl
                                    httpResultListener.onResult(apkUpdateInfoList);
                                   // SharedPreferencesUtils.put(mcontext,appname,jsonObject.getString("packName"));
                                } else {

                                  String   actionname = MainActivity.appType1.get(appname);
                                    startAppByAction(actionname,appname);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }


                    @Override
                    public void onStart() {
                        super.onStart();
                        httpResultListener.onStartRequest();
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                        httpResultListener.onFinish();
                    }
                });
    }

    /**
     * AppResult
     */
    public interface AppCallBack {
        public void myResult(List<ApkUpdateInfo> result);
        public void myResultFailure(FailRequest failRequestobj);
    }

    /**
     * 检查某个应用是否安装
     *
     * @param packageName
     * @return
     */
    public static boolean isAppInstalled(Context context, String packageName) {
        PackageManager packageManager = context.getPackageManager();
        if (packageName == null || "".equals(packageName)) {
            return false;
        }
        if (packageManager == null) {
            packageManager = UIUtils.getContext().getPackageManager();
        }
        try {
            packageManager.getApplicationInfo(packageName, PackageManager.GET_INSTRUMENTATION);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }



    //启动APP
    public void startAppByAction(String actionname, String name) {
        try {

            if (actionname.equals(MainActivity.appType1.get(name))) {
                Intent intent = new Intent();
                //判断是否为在线培训
                if (actionname.equals("elearning.a")) {
                    intent.putExtra("key_elearning_default_login", true);
                }
                intent.setAction(actionname);
                mcontext.startActivity(intent);
            } else {

                Toast.makeText(mcontext, "应用程序异常", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
