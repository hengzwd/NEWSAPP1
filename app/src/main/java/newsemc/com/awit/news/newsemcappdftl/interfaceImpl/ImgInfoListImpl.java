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
import newsemc.com.awit.news.newsemcappdftl.bean.ImgInfoObject;
import newsemc.com.awit.news.newsemcappdftl.dao.ImageInfo;
import newsemc.com.awit.news.newsemcappdftl.interfaces.HttpResultListener;
import newsemc.com.awit.news.newsemcappdftl.interfaces.ImgInfoListInter;
import newsemc.com.awit.news.newsemcappdftl.util.ValueConfig;


/**
 * 获取图片新闻列表
 * Created by Administrator on 2015/6/26.
 */
public class ImgInfoListImpl implements ImgInfoListInter {
    private String TAG="ImgInfoListImpl";
    private HttpResultListener httpResultListener;
    private ImgInfoObject imgInfoObject;
    private FailRequest failRequestobj;

    public ImgInfoListImpl(HttpResultListener httpResultListener){
        this.httpResultListener=httpResultListener;
    }

    @Override
    public void getImgInfoList(String ssid,String userId,String infotype, String pageno,String pagesize,String ifhead) {
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put("userId", userId);
        params.put("infotype", infotype);
        params.put("pageno", pageno);
        params.put("pagesize", pagesize);
        params.put("ifhead", ifhead);
        params.put("ssid",ssid);
        System.out.println("++++++++进入getImgInfoList+++++++");
//        client.setTimeout(ValueConfig.TIME_OUT);
        //京沈独立url
//        String url = ValueConfig.PCAPP_URL + "inter/inter!jsInfoList.action";
        String url = ValueConfig.PCAPP_URL + "inter/inter!jsInfoList.action";
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
                        imgInfoObject = new ImgInfoObject();
                        List<ImageInfo> imgInfoListList = new ArrayList<ImageInfo>();
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
                            if(Integer.parseInt(s) >0){
                                failRequestobj = new FailRequest();
                                failRequestobj.setStatus(jsonObject.getString("status"));
                                failRequestobj.setMsg(jsonObject.getString("msg"));
                                httpResultListener.onResult(failRequestobj);
                            }else {
                                String dataobj=jsonObject.getString("data");
                                Log.i(TAG, dataobj);
                                JSONObject datao=new JSONObject(dataobj);
                                imgInfoObject.setTotal(datao.getString("total"));
                                JSONArray dataarr=new JSONArray(datao.getString("list"));
                                Log.i(TAG,dataarr.toString());
                                for (int i = 0; i < dataarr.length(); i++) {
                                    data = dataarr.get(i).toString();
                                    jsonObject = new JSONObject(data);
                                    ImageInfo imgInfo = new ImageInfo();
                                    imgInfo.setInfoid(jsonObject.getString("infoid"));
                                    imgInfo.setInfourl(jsonObject.getString("infourl"));
                                    imgInfo.setInfoname(jsonObject.getString("infoname"));
                                    imgInfo.setInfoimg(jsonObject.getString("infoimg"));
                                    imgInfo.setInfotype(jsonObject.getString("infotype"));
                                    imgInfo.setInfodate(jsonObject.getString("infodate"));
                                    imgInfo.setPageno(jsonObject.getString("pageno"));
                                    imgInfo.setNum(jsonObject.getString("num"));
                                    imgInfo.setSource(jsonObject.getString("source"));
                                    imgInfo.setPublisher(jsonObject.getString("publisher"));
                                    imgInfo.setIsnew(jsonObject.getString("isnew"));
                                    imgInfoListList.add(imgInfo);
                                }
                                imgInfoObject.setImgInfoListList(imgInfoListList);
                                httpResultListener.onResult(imgInfoListList);
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
