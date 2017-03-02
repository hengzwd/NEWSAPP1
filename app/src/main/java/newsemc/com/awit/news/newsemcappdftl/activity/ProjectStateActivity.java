package newsemc.com.awit.news.newsemcappdftl.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import newsemc.com.awit.news.newsemcappdftl.R;
import newsemc.com.awit.news.newsemcappdftl.fragment.StateFragment;
import newsemc.com.awit.news.newsemcappdftl.interfaceImpl.CompanyImpl;

/**
 * Created by Administrator on 15-10-17.
 * 项目动态
 */
public class ProjectStateActivity extends FragmentActivity implements View.OnClickListener{
    private ListView worklistView;
    private Button btnback;
    private FragmentTransaction ft;
//    private TextView prp;
    private List<CompanyImpl> companyList;
    // private ArrayAdapter<ListView> adapter;
    private static String ssid,account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.stateactivity);
        worklistView=(ListView)findViewById(R.id.worklistview);
//        btnback=(Button)findViewById(R.id.back);
//        btnback.setOnClickListener(this);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.replace_fragment, new StateFragment());
        ft.commit();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                Log.i("back","gogogog");
                finish();
                break;
        }
    }
}
