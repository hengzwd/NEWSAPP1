package newsemc.com.awit.news.newsemcappdftl.http;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created by lianghl on 2015/12/24.
 */
public class DownLoadFile {

    private static final String TAG = "DownLoadFile";

    public static void downLoadComponyFile(String url, final String filePath, final String fileName){
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        Log.i(TAG, "下载的文件的url=" + url);
        Log.i(TAG, "下载的文件的filePath=" + filePath);
        Log.i(TAG, "下载的文件的fileName=" + fileName);
        client.post(url, params, new AsyncHttpResponseHandler() {

            @Override
            public void onStart() {
                super.onStart();
            }
            @Override
            public void onFinish() {
                super.onFinish();
                //停止进度条
            }
            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                Log.i(TAG, "下载文件失败！！！");
            }
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {

                Log.i(TAG, "文件下载成功！！！");
                Log.i(TAG, "文件大小(MB)：" + String.valueOf(bytes.length/1024.0f/1024.0f) + "MB");
                Log.i(TAG, "下载的文件的filePath=" + filePath);
                Log.i(TAG, "下载的文件的fileName=" + fileName);
                try {
                    File file = new File(filePath, fileName);
                    File parent = file.getParentFile();
                    if (parent != null && !parent.exists())
                        parent.mkdirs();
                    FileOutputStream fos = new FileOutputStream(file);
                    OutputStream output = new DataOutputStream(fos);
                    output.write(bytes);
                    output.flush();
                    output.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
