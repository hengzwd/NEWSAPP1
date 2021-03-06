package newsemc.com.awit.news.newsemcappdftl.interfaceImpl;

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
import newsemc.com.awit.news.newsemcappdftl.dao.ProjectTtrendsInfo;
import newsemc.com.awit.news.newsemcappdftl.interfaces.HttpResultListener;
import newsemc.com.awit.news.newsemcappdftl.interfaces.ProjectTrendInter;
import newsemc.com.awit.news.newsemcappdftl.util.ValueConfig;


/**
 * 项目动态-施工标段，监理标段
 * Created by Administrator on 2015/6/29.
 */
public class ProjectTrendsImpl implements ProjectTrendInter {
    private String TAG="ProjectTrendsImpl";
    private List<ProjectTtrendsInfo> projectTtrendsInfoList;
    private FailRequest failRequestobj;
    private HttpResultListener httpResultListener;

    public ProjectTrendsImpl(HttpResultListener httpResultListener){
        this.httpResultListener=httpResultListener;
    }
    @Override
    public void getProjectTrendList(String ssid,String userId, String projectinfoid, String aptitude) {
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put("userId", userId);
        params.put("projectinfoid",projectinfoid);
        params.put("aptitude",aptitude);
        params.put("ssid",ssid);
//        client.setTimeout(ValueConfig.TIME_OUT);
        String url = ValueConfig.PCAPP_URL + "inter/inter!getItemtrends.action";
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
                        projectTtrendsInfoList=new ArrayList<ProjectTtrendsInfo>();
                        JSONArray jsonArr;
                        JSONObject jsonObject;
                        JSONObject failjsonobj;
                        String data = null;
                        try {
                            String str = new String(arg2, "UTF-8");
                            Log.i(TAG, str);
                            jsonObject= new JSONObject(str);
                            String s = jsonObject.getString("status");
                            Log.i(TAG,s);
                         if(Integer.parseInt(s) !=0){
                            failRequestobj = new FailRequest();
                            failRequestobj.setStatus(jsonObject.getString("status"));
                            failRequestobj.setMsg(jsonObject.getString("msg"));
                            httpResultListener.onResult(failRequestobj);
                        }else {
                            String dataobj=jsonObject.getString("data");
                            Log.i(TAG, dataobj);
                            JSONObject datao=new JSONObject(dataobj);
                            JSONArray dataarr=new JSONArray(datao.getString("list"));
                            Log.i(TAG, dataarr.toString());
                            for (int i = 0; i < dataarr.length(); i++) {
                                data = dataarr.get(i).toString();
                                jsonObject = new JSONObject(data);
                                ProjectTtrendsInfo projectTtrendsInfobj=new ProjectTtrendsInfo();
                                projectTtrendsInfobj.setId(jsonObject.getString("id"));
                                projectTtrendsInfobj.setName(jsonObject.getString("name"));
                                projectTtrendsInfobj.setCode(jsonObject.getString("code"));
                                projectTtrendsInfobj.setConxname(jsonObject.getString("conxname"));
                                projectTtrendsInfobj.setAptitude(jsonObject.getString("aptitude"));
                                projectTtrendsInfobj.setTenders(jsonObject.getString("tenders"));
                                projectTtrendsInfobj.setTotallength(jsonObject.getString("totallength"));
                                projectTtrendsInfobj.setConstractamount(jsonObject.getString("constractamount"));
                                projectTtrendsInfobj.setProjectinfoid(jsonObject.getString("projectinfoid"));
                                projectTtrendsInfoList.add(projectTtrendsInfobj);
                            }
                            httpResultListener.onResult(projectTtrendsInfoList);
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
