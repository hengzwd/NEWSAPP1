package newsemc.com.awit.news.newsemcappdftl.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import newsemc.com.awit.news.newsemcappdftl.R;
import newsemc.com.awit.news.newsemcappdftl.activity.CompanyNewSingleActivity;
import newsemc.com.awit.news.newsemcappdftl.activity.SingleActivity;
import newsemc.com.awit.news.newsemcappdftl.bean.FailRequest;
import newsemc.com.awit.news.newsemcappdftl.dao.CompanyInfo;
import newsemc.com.awit.news.newsemcappdftl.interfaceImpl.CompanyImpl;
import newsemc.com.awit.news.newsemcappdftl.interfaces.HttpResultListener;
import newsemc.com.awit.news.newsemcappdftl.service.CompanyInfoService;
import zrc.widget.SimpleFooter;
import zrc.widget.SimpleHeader;
import zrc.widget.ZrcListView;

/**
 * Created by Administrator on 15-10-19.
 */
public class ImportSpeakFragment extends Fragment implements ZrcListView.OnItemClickListener{
    private ArrayList<View> dots;
    private ViewPager mViewPager;
    // private ViewPagerAdapter adapter;
    private View view1, view2, view3;//view4;
    private int oldPosition = 0;// 记录上一次点的位置
    private int currentItem; // 当前页面
    private List<View> viewList = new ArrayList<View>();// 把需要滑动的页卡添加到这个list中
    private ListView projectbaselist;
    private ListView sectsitelist;
    private ListView jianlisectlist;
    private ListView shejisectlist;
    Button button1,button2,button3,button4;
    Spinner spinner1,spinner2,spinner3,spinner4;
    private String ssid;
    private String account;
    private int pageNo = 0;
    private List<CompanyInfo> compwnylist;
    private Context ctx;
    //
    private ListView worklistview;
    ZrcListView zrcListView;
    private CompanyInfoService companyInfoService;
    List<CompanyInfo> read_cunzai = new ArrayList<CompanyInfo>();
    List<CompanyInfo> read_next = new ArrayList<CompanyInfo>();
    List<CompanyInfo> read_cun = new ArrayList<CompanyInfo>();
    List<CompanyInfo> list = new ArrayList<CompanyInfo>();
    List<CompanyInfo> read_up = new ArrayList<CompanyInfo>();
    private String Page;
    private Handler handler;
    private WorkAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = (View)inflater.inflate(R.layout.importfragment, null);
        //
        worklistview=(ListView)view.findViewById(R.id.worklistview);
        Log.i("重要讲话", "近来来来啦");
        //取得从specialactivity存储的Spec
        SharedPreferences spec=getActivity().getSharedPreferences("speciallogin", CompanyNewSingleActivity.MODE_PRIVATE);
        String specialName=spec.getString("special","");
        Log.i("specialName", "");
        if (specialName.equals("special")){
            Log.i("进入if","");
            //获取特殊登录存储的数据
            SharedPreferences SpecialsharedPreferences=getActivity().getSharedPreferences("SPEC", CompanyNewSingleActivity.MODE_PRIVATE);
            ssid=SpecialsharedPreferences.getString("KEY","");
            Log.i("Specialssid",ssid );
            account=SpecialsharedPreferences.getString("ACCOUNT","");
            Log.i("SPECIALACCOUNT",account);

        }else{
            //正常登录过来的
            SharedPreferences sharedPreferences=getActivity().getSharedPreferences("SP", CompanyNewSingleActivity.MODE_PRIVATE);
            ssid=sharedPreferences.getString("KEY","");
            Log.i("ssid", ssid + "");
            account=sharedPreferences.getString("ACCOUNT","");
            Log.i("ACCOUNT", account + "");
        }

        companyInfoService = CompanyInfoService.getInstance(getActivity());
        companyInfoService.deleteAllCompanyInfo();

        handler = new Handler();
        SimpleHeader header = new SimpleHeader(getActivity());
        header.setTextColor(0xff0066aa);
        header.setCircleColor(0xff33bbee);

        SimpleFooter footer = new SimpleFooter(getActivity());
        footer.setCircleColor(0xff33bbee);

        zrcListView = (ZrcListView)view.findViewById(R.id.work);
        zrcListView.setHeadable(header);
        zrcListView.setFootable(footer);
        zrcListView.setItemAnimForBottomIn(R.anim.bottomitem_in);

        zrcListView.setOnRefreshStartListener(new ZrcListView.OnStartListener() {
            @Override
            public void onStart() {
                refresh_importspeak();
            }
        });

        zrcListView.setOnLoadMoreStartListener(new ZrcListView.OnStartListener() {
            @Override
            public void onStart() {
                load_Importspeak();
            }
        });

        adapter = new WorkAdapter(getActivity(),read_up);
        zrcListView.setAdapter(adapter);
        zrcListView.refresh();

        return  view;
    }

    private void refresh_importspeak(){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(pageNo == 0){
                    pageNo = 1;
                    String page =  String.valueOf(pageNo);
                    if(companyInfoService.queryCompanyInfotype_pageno(9+"",page).size() == 0){
                        CompanyImpl companyImpl = new CompanyImpl(new MyHTTPResultListener(1));
                        companyImpl.getCompanyInfoList(ssid, account, "0","9", "1", "13", "2");
                        zrcListView.setRefreshSuccess("加载成功"); // 通知加载成功
                        zrcListView.startLoadMore();
                    }else {
                        read_cunzai = companyInfoService.queryCompanyInfotype_pageno(9+"",page);
                        read_up.addAll(read_cunzai);
                        adapter.notifyDataSetChanged();
                        zrcListView.setRefreshSuccess("加载成功");
                        Item_click(read_up);
                    }
                }else {
                    if(read_up.size() <= 13){
                        pageNo = pageNo + 1;
                        String page = String.valueOf(pageNo);
                        CompanyImpl company = new CompanyImpl(new MyHTTPResultListener_next());
                        company.getCompanyInfoList(ssid, account, "0","9", page, "13", "2");
                        zrcListView.setRefreshSuccess("加载成功"); // 通知加载成功
                        zrcListView.startLoadMore();
                    }
                    zrcListView.setRefreshFail("加载失败");
                }
            }
        },2*1000);
    }

   private void load_Importspeak(){
       handler.postDelayed(new Runnable() {
           @Override
           public void run() {
               pageNo = pageNo + 1;
               String page = String.valueOf(pageNo);
               List<String> Num = new ArrayList<String>();
               for (int i = 0; i < read_up.size(); i++) {
                   if(read_up.get(i).getPageno().equals(page)){
                       Num.add(read_up.get(i).getPageno());
                       break;
                   }
               }
               if(companyInfoService.queryCompanyInfotype_pageno(9+"",page).size() > 0){
                   for(int i = 0 ; i < read_up.size() ; i++){
                       if(read_up.get(i).getPageno().equals(page) && Num.size() > 0  ){
                           break;
                       }else {
                           list = companyInfoService.queryCompanyInfotype_pageno(9+"",page);
                           read_up.addAll(list);
                           break;
                       }
                   }
                   adapter.notifyDataSetChanged();
                   zrcListView.setLoadMoreSuccess();
                   Item_click(read_up);
               }else {
                   CompanyImpl company = new CompanyImpl(new MyHTTPResultListener_next1());
                   company.getCompanyInfoList(ssid, account,"0", "9", page, "13", "2");
                   zrcListView.setRefreshSuccess("加载成功"); // 通知加载成功
                   zrcListView.startLoadMore();
               }
           }
       },2*1000);
   }

    private void Item_click(final List<CompanyInfo> item_click){
        zrcListView.setOnItemClickListener(new ZrcListView.OnItemClickListener() {
            @Override
            public void onItemClick(ZrcListView parent, View view, int position, long id) {
                Intent intent=new Intent();
                intent.setClass(getActivity(), SingleActivity.class);
                intent.putExtra("infoid",item_click.get(position).getInfoid());
                Log.i("infoid", item_click.get(position).getInfoid());
                intent.putExtra("infotype", item_click.get(position).getInfotype());
                Page = item_click.get(position).getPageno();
                startActivityForResult(intent, 0);
            }
        });
    }

    private class WorkAdapter extends BaseAdapter {
        private LayoutInflater mInflater;
        //private String[] data = {"总","关于开展2015年5月份月度专项检查的通知","05-06","50人已读"};
        private List<CompanyInfo> data;

        class ViewHolder{
            TextView title;
            TextView time;
            TextView read;
        }

        public WorkAdapter(Context context,List<CompanyInfo> data){
            mInflater = LayoutInflater.from(context);
            this.data=data;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            CompanyInfo m = (CompanyInfo)this.getItem(position);
            if(convertView == null){
                holder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.work_list_item,null);
                holder.title = (TextView)convertView.findViewById(R.id.title);
                holder.time= (TextView)convertView.findViewById(R.id.time);
                holder.read = (TextView)convertView.findViewById(R.id.read);
                convertView.setTag(holder);
            }else{
                holder = (ViewHolder)convertView.getTag();
            }
            holder.title.setText(m.getInfoname());
            holder.time.setText(m.getInfodate());
            holder.read.setText(m.getNum());
            return convertView;
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    class MyHTTPResultListener_next1 implements HttpResultListener {
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
            }else {
                compwnylist = (List<CompanyInfo>)obj;
                if(compwnylist.size()>0){
                    companyInfoService.saveCompanyInfoLists(compwnylist);
                    read_up.addAll(compwnylist);
                    adapter.notifyDataSetChanged();
                    zrcListView.setLoadMoreSuccess();
                    Item_click(read_up);
                }else{
                    read_cun = companyInfoService.queryCompanyInfotype_pageno(9+"",1+"");
                    WorkAdapter adapter = new WorkAdapter(getActivity(), read_cun);
                    zrcListView.setAdapter(adapter);
                    Item_click(read_cun);
                    zrcListView.stopLoadMore();
                }
            }
        }

        @Override
        public void onFinish() {

        }
    }

   class MyHTTPResultListener_next implements HttpResultListener {


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
           }else {
               compwnylist = (List<CompanyInfo>)obj;
               if(compwnylist.size()>0){
                   companyInfoService.saveCompanyInfoLists(compwnylist);
                   read_up.addAll(compwnylist);
                   Collections.sort(read_up, new Comparator<CompanyInfo>() {
                       @Override
                       public int compare(CompanyInfo lhs, CompanyInfo rhs) {
                           return lhs.getPageno().compareTo(rhs.getPageno());
                       }
                   });
                   adapter.notifyDataSetChanged();
                   zrcListView.setRefreshSuccess();
                   Item_click(read_up);
               }else{
                   read_cun = companyInfoService.queryCompanyInfotype_pageno(9+"",1+"");
                   WorkAdapter adapter = new WorkAdapter(getActivity(), read_cun);
                   zrcListView.setAdapter(adapter);
                   Item_click(read_cun);
               }
           }
       }

       @Override
       public void onFinish() {

       }
   }

    class MyHTTPResultListener implements HttpResultListener {
        private int type;

        public MyHTTPResultListener(int type){
            this.type = type;
        }
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
                switch (type){
                    case 1:
                        compwnylist = (List<CompanyInfo>)obj;
                        if(compwnylist.size()>0){
                            companyInfoService.saveCompanyInfoLists(compwnylist);
                            read_up.addAll(compwnylist);
                            Collections.sort(read_up, new Comparator<CompanyInfo>() {
                                @Override
                                public int compare(CompanyInfo lhs, CompanyInfo rhs) {
                                    return lhs.getPageno().compareTo(rhs.getPageno());
                                }
                            });
                            adapter.notifyDataSetChanged();
                            zrcListView.setRefreshSuccess();
                            Item_click(read_up);
                        }else{
                            CompanyImpl company = new CompanyImpl(new MyHTTPResultListener(1));
                            company.getCompanyInfoList(ssid, account, "0","9",
                                    pageNo > 1 ? String.valueOf(pageNo - 1) : String.valueOf(pageNo), "13", "2");
                        }
                        break;
                    default:
                        break;
                }
            }

        }

        @Override
        public void onFinish() {

        }
    }
//


    @Override
    public void onItemClick(ZrcListView parent, View view, int position, long id) {
        Intent intent=new Intent();
        intent.setClass(getActivity(), SingleActivity.class);
        intent.putExtra("infoid", compwnylist.get(position).getInfoid());
        Log.i("infoid", compwnylist.get(position).getInfoid());
        intent.putExtra("infotype", compwnylist.get(position).getInfotype());
        Page = compwnylist.get(position).getPageno();
        startActivityForResult(intent, 0);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
         List<CompanyInfo> one = new ArrayList<CompanyInfo>();
         for(int i = 0 ; i < read_up.size() ; i++){
             if(read_up.get(i).getPageno().equals(Page)){
                  one.add(read_up.get(i));
             }
         }
        for(CompanyInfo tt : one){
            if(read_up.contains(tt)){
               read_up.remove(tt);
            }
        }
        if(Page.equals("1")){
            CompanyImpl company = new CompanyImpl(new MyHTTPResultListener(1));
            company.getCompanyInfoList(ssid, account, "0","9", Page, "13", "2");
        }else{
            CompanyImpl company = new CompanyImpl(new MyHTTPResultListener(1));
            company.getCompanyInfoList(ssid, account, "0","9",Page, "13", "2");
        }
    }
}
