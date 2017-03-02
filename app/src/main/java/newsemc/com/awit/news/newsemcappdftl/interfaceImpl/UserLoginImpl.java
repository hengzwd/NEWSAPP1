package newsemc.com.awit.news.newsemcappdftl.interfaceImpl;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import newsemc.com.awit.news.newsemcappdftl.bean.FailRequest;
import newsemc.com.awit.news.newsemcappdftl.bean.UserLogin;
import newsemc.com.awit.news.newsemcappdftl.dao.DepartmentInfo;
import newsemc.com.awit.news.newsemcappdftl.dao.PersonInfo;
import newsemc.com.awit.news.newsemcappdftl.interfaces.HttpResultListener;
import newsemc.com.awit.news.newsemcappdftl.interfaces.UserLoginInter;
import newsemc.com.awit.news.newsemcappdftl.util.ValueConfig;


/**
 * 用户登录接口实现
 * Created by Administrator on 2015/7/3.
 */
public class UserLoginImpl  implements UserLoginInter {
    private String TAG="UserLoginImpl";
    private UserLogin userLoginobj;
    private FailRequest failRequestobj;
    private HttpResultListener httpResultListener;
    public UserLoginImpl(HttpResultListener httpResultListener){
        this.httpResultListener=httpResultListener;
    }
    private Handler handler = new Handler();
    private Message msg = handler.obtainMessage();
    @Override
    public void login(String account,String mobile, String imei) {
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put("account", account);
        params.put("mobile", mobile);
        params.put("imei", imei);
        Log.i(TAG, "imei = " + imei);
        client.setTimeout(ValueConfig.TIME_OUT);
        String url = ValueConfig.PCAPP_URL + "user/login!executex.action";
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
                        Log.i(TAG, "succ");
                        userLoginobj=new UserLogin();
                        JSONArray jsonArr;
                        JSONObject jsonObject;
                        JSONObject failjsonobj;
                        String data = null;
                        try {
                            String str = new String(arg2, "UTF-8");
                            Log.i(TAG, str);
                            jsonObject= new JSONObject(str);
                            String s = jsonObject.getString("status");
                            Log.i(TAG, s);
                            if(Integer.parseInt(s) <0){
                                failRequestobj = new FailRequest();
                                failRequestobj.setStatus(jsonObject.getString("status"));
                                failRequestobj.setMsg(jsonObject.getString("msg"));
                                httpResultListener.onResult(failRequestobj);
                            }else{
                                String dataobj=jsonObject.getString("data");
                                Log.i(TAG, dataobj);
                                JSONObject datao=new JSONObject(dataobj);
                                JSONArray dataarr=new JSONArray(datao.getString("list"));
                                Log.i(TAG, dataarr.toString());
                                for (int i = 0; i < dataarr.length(); i++) {
                                    data = dataarr.get(i).toString();
                                    jsonObject = new JSONObject(data);
                                    PersonInfo personInfobj=new PersonInfo();
                                    personInfobj.setUserId(jsonObject.getString("userId"));
                                    personInfobj.setSex(jsonObject.getString("sex"));
                                    personInfobj.setSsid(jsonObject.getString("ssid"));
                                    personInfobj.setAccount(jsonObject.getString("account"));
                                    personInfobj.setRelateAccount(jsonObject.getString("relateAccount"));
                                    personInfobj.setName(jsonObject.getString("name"));
                                    personInfobj.setContact(jsonObject.getString("contact"));
                                    personInfobj.setCompname(jsonObject.getString("compname"));
                                    personInfobj.setIdNo(jsonObject.getString("idNo"));
                                    personInfobj.setCompid(jsonObject.getString("compid"));
                                    userLoginobj.setPersonInfobj(personInfobj);
                                    JSONArray departarr=new JSONArray(jsonObject.getString("departments"));
                                    List<DepartmentInfo> departmentInfoList=new ArrayList<DepartmentInfo>();
                                    for(int j=0;j<departarr.length();j++){
                                        String deptdata=departarr.get(j).toString();
                                        JSONObject deptjson=new JSONObject(deptdata);
                                        DepartmentInfo departmentInfobj=new DepartmentInfo();
                                        departmentInfobj.setId(deptjson.getString("id"));
                                        departmentInfobj.setName(deptjson.getString("name"));
                                        departmentInfobj.setDuty(deptjson.getString("duty"));
                                        departmentInfoList.add(departmentInfobj);
                                    }
                                    userLoginobj.setDepartmentInfoList(departmentInfoList);
                                }
                                httpResultListener.onResult(userLoginobj);
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
}
