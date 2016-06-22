package es.source.code.activity;
<<<<<<< HEAD
=======
import es.source.code.activity.FoodOrderView;
>>>>>>> 091363891075d850ed6d10f33087363dee5edab7
import es.source.code.es.source.code.adapter.TabOrderedAdapter;
import es.source.code.es.source.code.adapter.TabUnOrderAdapter;
import es.source.code.model.Food;
import es.source.code.model.User;

<<<<<<< HEAD
import android.app.ProgressDialog;
import android.content.DialogInterface;
=======
>>>>>>> 091363891075d850ed6d10f33087363dee5edab7
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
public class FoodOrderView extends AppCompatActivity {

    private ViewPager viewPager;//页卡内容
    private ImageView imageView1,imageView2;// 动画图片
    TextView textView1,textView2;
    List<View> views;// Tab页面列表
    View view1,view2;//各个页卡
    int flag = 0;

    User user = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_order_view);

        getUser();
        InitImageView();
        InitTextView();
        InitViewPager();

    }

    void getUser(){
        Intent intent = this.getIntent();
        user =  (User)intent.getSerializableExtra("user");
        String str = intent.getStringExtra("str");
        if(str.equalsIgnoreCase("order")){
            flag = 0;
        }
        else if(str.equalsIgnoreCase("check")){
            flag = 1;
        }
    }

    void InitImageView(){
        viewPager=(ViewPager) findViewById(R.id.vPager);
        views = new ArrayList<>();
        LayoutInflater inflater = LayoutInflater.from(this);
        view1=inflater.inflate(R.layout.unordermenu, null);
        view2=inflater.inflate(R.layout.orderedmenu, null);

        List<Food> listFood = new ArrayList<>();
        listFood.add(new Food("手撕包菜","￥8","1份","特色小吃"));
        listFood.add(new Food("手撕包菜","￥8","1份","特色小吃"));
        listFood.add(new Food("手撕包菜","￥8","1份","特色小吃"));
        listFood.add(new Food("手撕包菜","￥8","1份","特色小吃"));
        listFood.add(new Food("手撕包菜","￥8","1份","特色小吃"));
        listFood.add(new Food("手撕包菜","￥8","1份","特色小吃"));


        ListView lv1 = (ListView)view1.findViewById(R.id.listView);
        TabOrderedAdapter orderedAdapter = new TabOrderedAdapter(this,listFood);
        lv1.setAdapter(orderedAdapter);

        List<Food> Food = new ArrayList<>();
        Food.add(new Food("水煮牛肉","￥28","1份","好吃不贵"));
        Food.add(new Food("水煮牛肉","￥28","1份","好吃不贵"));
        Food.add(new Food("水煮牛肉","￥28","1份","好吃不贵"));
        Food.add(new Food("水煮牛肉","￥28","1份","好吃不贵"));
        Food.add(new Food("水煮牛肉","￥28","1份","好吃不贵"));
        Food.add(new Food("水煮牛肉","￥28","1份","好吃不贵"));

        ListView lv2 = (ListView)view2.findViewById(R.id.listView);
        TabUnOrderAdapter unOrderedAdapter = new TabUnOrderAdapter(this,Food);
        lv2.setAdapter(unOrderedAdapter);

        views.add(view1);
        views.add(view2);


        viewPager.setAdapter(new MyViewPagerAdapter(views));
        viewPager.setCurrentItem(flag);
        viewPager.setOnPageChangeListener(new MyOnPageChangeListener());


    }
    void InitTextView(){
        textView1 = (TextView) findViewById(R.id.unOrder);
        textView2 = (TextView) findViewById(R.id.Ordered);
        textView1.setOnClickListener(new MyOnClickListener(0));
        textView2.setOnClickListener(new MyOnClickListener(1));

<<<<<<< HEAD
        final  Button btnPay = (Button)view2.findViewById(R.id.pay);
        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(user != null && user.getOldUser()==true){
                    final ProgressDialog myDialog = ProgressDialog.show(FoodOrderView.this, "请稍候",
                            "付款中……", true);
                    new Thread() {
                        public void run() {
                            try {
                                sleep(6000);
                            } catch (Exception e) {
                                e.printStackTrace();
                            } finally {
                                // 卸载所创建的myDialog对象。
                                myDialog.dismiss();
                            }
                        }
                    }.start(); /* 开始运行运行线程 */
                btnPay.setClickable(false);
                Toast.makeText(getApplicationContext(),"您好，此次共消费998元，会员积分卡增加50点。",Toast.LENGTH_SHORT).show();
//                }
//                Toast.makeText(getApplicationContext(),"您好，老顾客，本次你可享受7折优惠。",Toast.LENGTH_SHORT).show();
=======
        Button btnPay = (Button)view2.findViewById(R.id.pay);
        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user != null && user.getOldUser()==true)
                    Toast.makeText(getApplicationContext(),"您好，老顾客，本次你可享受7折优惠。",Toast.LENGTH_SHORT).show();
>>>>>>> 091363891075d850ed6d10f33087363dee5edab7
            }
        });
}
    void InitViewPager(){

        imageView1 = (ImageView) findViewById(R.id.cursor1);
        imageView2 = (ImageView) findViewById(R.id.cursor2);
        if(flag==0)
            imageView1.setVisibility(View.VISIBLE);
        else
            imageView2.setVisibility(View.VISIBLE);

    }

    private class MyOnClickListener implements View.OnClickListener {
        private int index=0;
        public MyOnClickListener(int i){
            index=i;
        }
        public void onClick(View v) {
            viewPager.setCurrentItem(index);
        }
    }
    public class MyViewPagerAdapter extends PagerAdapter {
        private List<View> mListViews;

        public MyViewPagerAdapter(List<View> mListViews) {
            this.mListViews = mListViews;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object)     {
            container.removeView(mListViews.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mListViews.get(position), 0);
            return mListViews.get(position);
        }

        @Override
        public int getCount() {
            return  mListViews.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0==arg1;
        }
    }

    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        public void onPageScrollStateChanged(int arg0) {
        }
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }
        public void onPageSelected(int arg0) {

            imageView1.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.INVISIBLE);

            switch (viewPager.getCurrentItem()){
                case 0:
                    imageView1.setVisibility(View.VISIBLE);
                    break;
                case 1:
                    imageView2.setVisibility(View.VISIBLE);
                    break;
                default:
                    break;
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_food_order_view, menu);
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
