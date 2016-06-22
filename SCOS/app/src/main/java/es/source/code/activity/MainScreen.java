package es.source.code.activity;

<<<<<<< HEAD
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
=======
import android.content.Intent;
>>>>>>> 091363891075d850ed6d10f33087363dee5edab7
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;

import es.source.code.model.User;

public class MainScreen extends AppCompatActivity {

    GridView gridView;

    User user = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        initView();
        getUser();

    }

    void getUser(){
        Intent intent = this.getIntent();
        String strReceive = "";
        User receiveUser = (User)intent.getSerializableExtra("user");
        strReceive = intent.getStringExtra("data");
<<<<<<< HEAD

        SharedPreferences sp = getSharedPreferences("user_reocrd", Activity.MODE_PRIVATE);
        int loginstate = sp.getInt("loginState",1);
        if(loginstate==1){
            user.setUserName(receiveUser.getUserName());
            user.setPasswrod(receiveUser.getPasswrod());
            user.setOldUser(receiveUser.getOldUser());
        }
        else{
            user.setUserName("root");
            user.setPasswrod("root");
            user.setOldUser(false);
        }

        /*
=======
>>>>>>> 091363891075d850ed6d10f33087363dee5edab7
        if(strReceive.equalsIgnoreCase("LoginSuccess")){
            user.setUserName(receiveUser.getUserName());
            user.setPasswrod(receiveUser.getPasswrod());
            user.setOldUser(receiveUser.getOldUser());
        }
        else if(strReceive.equalsIgnoreCase("RegisterSuccess")){
            user.setUserName(receiveUser.getUserName());
            user.setPasswrod(receiveUser.getPasswrod());
            user.setOldUser(receiveUser.getOldUser());
            Toast.makeText(getApplication(),"欢迎您成为SOCOS新用户",Toast.LENGTH_SHORT).show();
        }
        else{
            user.setUserName("root");
            user.setPasswrod("root");
            user.setOldUser(false);
        }
<<<<<<< HEAD
        */
=======
>>>>>>> 091363891075d850ed6d10f33087363dee5edab7
    }

    void initView(){
        gridView = (GridView)findViewById(R.id.gridview);

        ArrayList<HashMap<String,Object>> lstImageItem = new ArrayList<>();
        HashMap<String,Object> map1 = new HashMap<>();
        map1.put("ItemImage", R.drawable.diancai);
        map1.put("ItemText", "点菜");
        lstImageItem.add(map1);

        HashMap<String,Object> map2 = new HashMap<>();
        map2.put("ItemImage", R.drawable.dingdan);
        map2.put("ItemText", "查看订单");
        lstImageItem.add(map2);

        HashMap<String,Object> map3 = new HashMap<>();
        map3.put("ItemImage", R.drawable.denglu);
        map3.put("ItemText", "登录");
        lstImageItem.add(map3);

        HashMap<String,Object> map4 = new HashMap<>();
        map4.put("ItemImage", R.drawable.bangzhu);
        map4.put("ItemText", "帮助");
        lstImageItem.add(map4);

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
                HashMap<String, Object> item = (HashMap<String, Object>) parent.getItemAtPosition(position);
                String titleStr = (String) item.get("ItemText");
                setTitle(titleStr);

                //点菜
                if (position == 0) {
                    Intent intent = new Intent(getApplicationContext(),FoodView.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("user", user);
                    intent.putExtras(bundle);
                    startActivity(intent);
<<<<<<< HEAD
=======
                    finish();
>>>>>>> 091363891075d850ed6d10f33087363dee5edab7
                }
                //查看订单
                else if (position == 1) {
                    Intent intent = new Intent(getApplicationContext(),FoodOrderView.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("user", user);
                    intent.putExtras(bundle);
                    startActivity(intent);
<<<<<<< HEAD
=======
                    finish();
>>>>>>> 091363891075d850ed6d10f33087363dee5edab7
                }
                //登录
                else if (position == 2) {
                    Intent intent = new Intent(getApplicationContext(),LoginOrRegister.class);
                    startActivity(intent);
<<<<<<< HEAD
                }
                //帮助
                else if (position == 3) {
                    Intent intent = new Intent(getApplicationContext(),SCOSHelper.class);
                    startActivity(intent);
=======
                    finish();
                }
                //帮助
                else if (position == 3) {

>>>>>>> 091363891075d850ed6d10f33087363dee5edab7
                }
            }
        });

    }
    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
