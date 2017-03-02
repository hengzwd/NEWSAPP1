package newsemc.com.awit.news.newsemcappdftl.interfaceImpl;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.json.JSONObject;

import newsemc.com.awit.news.newsemcappdftl.bean.FailRequest;
import newsemc.com.awit.news.newsemcappdftl.bean.Logout;
import newsemc.com.awit.news.newsemcappdftl.interfaces.HttpResultListener;
import newsemc.com.awit.news.newsemcappdftl.interfaces.LoginOutInter;
import newsemc.com.awit.news.newsemcappdftl.util.ValueConfig;


/**
 * 用户注销
 * Created by Administrator on 2015/7/3.
 */
public class UserLogOutImpl implements LoginOutInter {
    private String TAG="UserLogOutImpl";
    private Logout logoutobj;
    private FailRequest failRequestobj;
    private HttpResultListener httpResultListener;
    public UserLogOutImpl(HttpResultListener httpResultListener){
        this.httpResultListener=httpResultListener;
    }
    @Override
    public void loginOut(String ssid) {
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put("ssid", ssid);
//        client.setTimeout(ValueConfig.TIME_OUT);
        String url = ValueConfig.PCAPP_URL + "user/logout!execute.action";
        client.post(
                url,
                params,
                new AsyncHttpResponseHandler() {
                    @Override
                    public void onFailure(int arg0, Header[] arg1, byte[] arg2,
                                          Throwable arg3) {
                        System.out.println("fail");
                        try {
                            Log.i(TAG, "onFailure:" + arg2);
                            String str = new String(arg2, "UTF-8");
                            JSONObject jsonObject = new JSONObject(str);
                            Log.i("url", arg3.toString());
                            if (!(jsonObject.getString("status").equals("0"))) {
                                failRequestobj = new FailRequest();
                                failRequestobj.setStatus(jsonObject.getString("status"));
                                failRequestobj.setMsg(jsonObject.getString("msg"));
                                httpResultListener.onResult(failRequestobj);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
                        System.out.println("success");
                        Log.i(TAG, new String(arg2));
                        try {
                            JSONObject jsonObject=new JSONObject(new String(arg2));
                            logoutobj=new Logout();
                            logoutobj.setStatus(jsonObject.getInt("status"));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        httpResultListener.onResult(logoutobj);
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
}
