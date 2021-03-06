package newsemc.com.awit.news.newsemcappdftl.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import newsemc.com.awit.news.newsemcappdftl.R;
import newsemc.com.awit.news.newsemcappdftl.activity.CompanyNewSingleActivity;
import newsemc.com.awit.news.newsemcappdftl.activity.MainActivity;
import newsemc.com.awit.news.newsemcappdftl.activity.SingleActivity;
import newsemc.com.awit.news.newsemcappdftl.adapter.MainNewsAdapter;
import newsemc.com.awit.news.newsemcappdftl.bean.FailRequest;
import newsemc.com.awit.news.newsemcappdftl.dao.ImageInfo;
import newsemc.com.awit.news.newsemcappdftl.interfaceImpl.ImgInfoListImpl;
import newsemc.com.awit.news.newsemcappdftl.interfaces.HttpResultListener;
import zrc.widget.SimpleHeader;
import zrc.widget.ZrcListView;

/**
 * Created by Administrator on 15-6-15.
 */
public class MainFragment extends Fragment implements ZrcListView.OnItemClickListener,HttpResultListener {
//    private List<Map<String,ImgInfoList>> main_list_view;
private List<ImageInfo> main_list_view;
    ZrcListView zrcListView;
    private int pageNo = 1;
    private String ssid;
    private String account;
    public static MainFragment newInstance(){
        MainFragment f = new MainFragment();
        return f;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = (View)inflater.inflate(R.layout.mainfragment, null);
        //DDDD
        SharedPreferences testspec=getActivity().getSharedPreferences("testlogin", MainActivity.MODE_PRIVATE);
        String special=testspec.getString("test",null);
        Log.i("special：：：：：：",special+"");

        if ("test".equals(special)){
            Log.i("进入if","");
            //获取特殊登录存储的数据
            SharedPreferences SpecialsharedPreferences=getActivity().getSharedPreferences("SPEC", CompanyNewSingleActivity.MODE_PRIVATE);
            ssid=SpecialsharedPreferences.getString("KEY","");
            Log.i("Specialssid", ssid);
            account=SpecialsharedPreferences.getString("ACCOUNT","");
            Log.i("SPECIALACCOUNT", account);
            // finish();

        }else{
            //清空特殊登录所保存的数据
            SharedPreferences.Editor editor=testspec.edit();
            editor.clear();
            editor.commit();
            Log.i("清空特殊登录的数据","进入else。。。。");
            //正常登录过来的
            SharedPreferences sharedPreferences=getActivity().getSharedPreferences("SP", MainActivity.MODE_PRIVATE);
            ssid=sharedPreferences.getString("KEY","");
            Log.i("ssid", ssid + "");
            account=sharedPreferences.getString("ACCOUNT","");
            Log.i("ACCOUNT", account + "");
            //finish();


        }

        SimpleHeader header = new SimpleHeader(getActivity());
        header.setTextColor(0xff0066aa);
        header.setCircleColor(0xff33bbee);

        zrcListView = (ZrcListView) view.findViewById(R.id.mainlistview);
        zrcListView.setHeadable(header);
        zrcListView.setOnRefreshStartListener(new ZrcListView.OnStartListener() {
            @Override
            public void onStart() {
                pageNo = pageNo+1;
                String page = String.valueOf(pageNo);
                ImgInfoListImpl imgInfoListImpl = new ImgInfoListImpl(MainFragment.this);
                imgInfoListImpl.getImgInfoList(ssid,account, "10", page, "10", "1");
                zrcListView.setRefreshSuccess("加载成功"); // 通知加载成功
                zrcListView.startLoadMore();
            }
        });

        return  view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ImgInfoListImpl imgInfoListImpl = new ImgInfoListImpl(this);
        imgInfoListImpl.getImgInfoList(ssid,account, "10", "1", "10", "1");
        //initMainListView();
    }

        /*private  void initMainListView(){
        mlistview=(ListView)getView().findViewById(R.id.mainlistview);
        main_list_view= ValueConfig.getMainListViewData();
        mlistview.setAdapter(new MainNewsAdapter(getActivity(), main_list_view));
        mlistview.setOnItemClickListener(this);
    }*/

//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Intent intent=new Intent();
//        intent.setClass(getActivity(), SingleActivity.class);
//        intent.putExtra("itemimg", main_list_view.get(position).get("drawer_list_itme_img") + "");
//        intent.putExtra("itemtitle",main_list_view.get(position).get("drawer_list_itme_title")+"");
//        intent.putExtra("itemtext",main_list_view.get(position).get("drawer_list_itme_text")+"");
//        intent.putExtra("itemdate", main_list_view.get(position).get("drawer_list_itme_date")+"");
//        intent.putExtra("itemread", main_list_view.get(position).get("drawer_list_itme_read") + "");
//        startActivity(intent);
//    }

   /* @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser) {
            //fragment可见时加载数据
            ImgInfoListImpl imgInfoListImpl = new ImgInfoListImpl(this);
            imgInfoListImpl.getImgInfoList("jinzhiyi", "10", "1", "10", "1");
        } else {
            Log.i("jinlailejinlaile","hahahahahahhah");
            //不可见时不执行操作
        }
        super.setUserVisibleHint(isVisibleToUser);
    }*/

    @Override
    public void onStartRequest() {

    }

    @Override
    public void onResult(Object obj) {
        if(obj instanceof FailRequest){
            FailRequest fail= (FailRequest)obj;
            if(!(fail==null)){
                System.out.println("异常信息："+fail.getMsg());
                System.out.println("状态："+fail.getStatus());
            }
        }else{
            main_list_view = (List<ImageInfo>) obj;
            Log.i("projectinfo", main_list_view + "");
            if(main_list_view.size()>0){
                MainNewsAdapter adapter = new MainNewsAdapter(getActivity(),main_list_view);
                zrcListView.setAdapter(adapter);
                zrcListView.setOnItemClickListener(this);
            }else{
                ImgInfoListImpl imgInfoListImpl = new ImgInfoListImpl(this);
                imgInfoListImpl.getImgInfoList(ssid,account, "10",
                        pageNo>1?String.valueOf(pageNo-1):String.valueOf(pageNo), "10", "1");
            }

        }
    }

    @Override
    public void onFinish() {

    }

    @Override
    public void onItemClick(ZrcListView parent, View view, int position, long id) {
        Intent intent=new Intent();
        intent.setClass(getActivity(), SingleActivity.class);
        intent.putExtra("infoid", main_list_view.get(position).getInfoid() + "");
        Log.i("infoid", main_list_view.get(position).getInfoid());
        intent.putExtra("infotype", main_list_view.get(position).getInfotype());
        startActivity(intent);
    }
}
