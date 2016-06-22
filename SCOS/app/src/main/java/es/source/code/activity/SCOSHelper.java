package es.source.code.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.LogRecord;

public class SCOSHelper extends AppCompatActivity {

     public  GridView gridView;
     public  Handler mhandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scoshelper);

        initview();
        mhandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what){
                    case 1:
                        Toast.makeText(getApplicationContext(),"求助邮件发送成功",Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
                super.handleMessage(msg);
            }
        };
    }

    void initview(){
        gridView = (GridView)findViewById(R.id.gridview);

        ArrayList<HashMap<String,Object>> lstImageItem = new ArrayList<>();
        HashMap<String,Object> map1 = new HashMap<>();
        map1.put("ItemImage", R.drawable.xieyi_help);
        map1.put("ItemText", "用户使用协议");
        lstImageItem.add(map1);

        HashMap<String,Object> map2 = new HashMap<>();
        map2.put("ItemImage", R.drawable.about_help);
        map2.put("ItemText", "关于系统");
        lstImageItem.add(map2);

        HashMap<String,Object> map3 = new HashMap<>();
        map3.put("ItemImage", R.drawable.phone_help);
        map3.put("ItemText", "电话人工帮助");
        lstImageItem.add(map3);

        HashMap<String,Object> map4 = new HashMap<>();
        map4.put("ItemImage", R.drawable.message_help);
        map4.put("ItemText", "短信帮助");
        lstImageItem.add(map4);

        HashMap<String,Object> map5 = new HashMap<>();
        map5.put("ItemImage", R.drawable.email_help);
        map5.put("ItemText", "邮件帮助");
        lstImageItem.add(map5);

        SimpleAdapter saImageItems = new SimpleAdapter(this,
                lstImageItem,
                R.layout.menu_item,
                new String[] {"ItemImage","ItemText"},
                new int[] {R.id.ItemImage,R.id.ItemText}
        );
        gridView.setAdapter(saImageItems);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                HashMap<String, Object> item = (HashMap<String, Object>)parent.getItemAtPosition(position);
                String titleStr = (String) item.get("ItemText");
                setTitle(titleStr);

                if(position == 0){
                    Toast.makeText(getApplicationContext(),"使用协议",Toast.LENGTH_SHORT).show();

                }
                else if(position == 1){
                    Toast.makeText(getApplicationContext(),"关于系统",Toast.LENGTH_SHORT).show();

                }
                else if(position == 2){
//                    Toast.makeText(getApplicationContext(),"2",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.CALL");
                    intent.setData(Uri.parse("tel:" + "5554"));
                    startActivity(intent);
                }
                else if(position == 3){
                    String phone = "5554";
                    String context = "test scos helper";
                    SmsManager manager = SmsManager.getDefault();
                    ArrayList<String> list = manager.divideMessage(context);
                    for(String text:list)
                        manager.sendTextMessage(phone,null,text,null,null);
                    Toast.makeText(getApplicationContext(),"求助短信发送成功",Toast.LENGTH_SHORT).show();
                }
                else if(position == 4){
                    Thread MailSender = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Intent data=new Intent(Intent.ACTION_SENDTO);
                            data.setData(Uri.parse("mailto:huangzy099@163.com"));
                            data.putExtra(Intent.EXTRA_SUBJECT, "subject");
                            data.putExtra(Intent.EXTRA_TEXT, "text");
                            startActivity(data);
                            Message message = new Message();
                            message.what = 1;
                            mhandler.sendMessage(message);
                        }
                    });
                    MailSender.start();
//                    Toast.makeText(getApplicationContext(),"4",Toast.LENGTH_SHORT).show();

                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scoshelper, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
