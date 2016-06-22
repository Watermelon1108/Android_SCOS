package es.source.code.activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.source.code.es.source.code.adapter.LengcaiAdapter;
import es.source.code.es.source.code.adapter.RecaiAdapter;
import es.source.code.es.source.code.adapter.haixianAdapter;
import es.source.code.es.source.code.adapter.jiushuiAdapter;
import es.source.code.model.User;

public class FoodView extends AppCompatActivity {

    private ViewPager viewPager;//页卡内容
    private ImageView imageView1,imageView2,imageView3,imageView4;// 动画图片
    TextView textView1,textView2,textView3,textView4;
    List<View> views;// Tab页面列表
    View view1,view2,view3,view4;//各个页卡


    List<Map<String, Object>> mData;
    String title[]=new String[]{"菜名0","菜名1","菜名2","菜名3","菜名4","菜名5","菜名6","菜名7","菜名8","菜名9"};
    String info[]=new String[]{ "￥：28","￥：28","￥：28","￥：28","￥：28", "￥：28", "￥：28","￥：28","￥：28","￥：28",};
    User user = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.food_view);

        getUser();
        InitImageView();
        InitTextView();
        InitViewPager();
    }

    void getUser(){
        Intent intent = this.getIntent();
        user =  (User)intent.getSerializableExtra("user");
    }

    void InitImageView(){
        viewPager=(ViewPager) findViewById(R.id.vPager);
        views = new ArrayList<>();
        LayoutInflater inflater = LayoutInflater.from(this);
        view1=inflater.inflate(R.layout.lengcai, null);
        view2=inflater.inflate(R.layout.recai, null);
        view3=inflater.inflate(R.layout.haixian, null);
        view4=inflater.inflate(R.layout.jiushui, null);

        mData = getData();

        ListView lv1 = (ListView)view1.findViewById(R.id.listView);
        LengcaiAdapter adapter1 = new LengcaiAdapter(this,mData);
        lv1.setAdapter(adapter1);

        ListView lv2 = (ListView)view2.findViewById(R.id.listView);
        RecaiAdapter adapter2 = new RecaiAdapter(this,mData);
        lv2.setAdapter(adapter2);

        ListView lv3 = (ListView)view3.findViewById(R.id.listView);
        haixianAdapter adapter3 = new haixianAdapter(this,mData);
        lv3.setAdapter(adapter3);

        ListView lv4 = (ListView)view4.findViewById(R.id.listView);
        jiushuiAdapter adapter4 = new jiushuiAdapter(this,mData);
        lv4.setAdapter(adapter4);

        views.add(view1);
        views.add(view2);
        views.add(view3);
        views.add(view4);

        viewPager.setAdapter(new MyViewPagerAdapter(views));
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(new MyOnPageChangeListener());
    }

    /**
     *  初始化头标
     */
    void InitTextView(){
        textView1 = (TextView) findViewById(R.id.leng);
        textView2 = (TextView) findViewById(R.id.re);
        textView3 = (TextView) findViewById(R.id.haixian);
        textView4 = (TextView) findViewById(R.id.jiushui);

        textView1.setOnClickListener(new MyOnClickListener(0));
        textView2.setOnClickListener(new MyOnClickListener(1));
        textView3.setOnClickListener(new MyOnClickListener(2));
        textView4.setOnClickListener(new MyOnClickListener(3));
    }

    /**
     2      * 初始化动画，这个就是页卡滑动时，下面的横线也滑动的效果，在这里需要计算一些数据
     3 */
    void InitViewPager(){
        imageView1 = (ImageView) findViewById(R.id.cursor1);
        imageView2 = (ImageView) findViewById(R.id.cursor2);
        imageView3 = (ImageView) findViewById(R.id.cursor3);
        imageView4 = (ImageView) findViewById(R.id.cursor4);

        imageView1.setVisibility(View.VISIBLE);
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
            imageView3.setVisibility(View.INVISIBLE);
            imageView4.setVisibility(View.INVISIBLE);

            switch (viewPager.getCurrentItem()){
                case 0:
                    imageView1.setVisibility(View.VISIBLE);
                    break;
                case 1:
                    imageView2.setVisibility(View.VISIBLE);
                    break;
                case 2:
                    imageView3.setVisibility(View.VISIBLE);
                    break;
                case 3:
                    imageView4.setVisibility(View.VISIBLE);
                    break;
            }
        }

    }

    List<Map<String, Object>> getData(){

        List<Map<String, Object>> list = new ArrayList<>();
        for(int i=0;i<title.length;i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("title", title[i]);
            map.put("info", info[i]);
            list.add(map);
        }
        return list;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_food_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //
        if (id == R.id.haveOrdered) {
            Intent intent = new Intent(getApplicationContext(),FoodOrderView.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("user",user);
            bundle.putString("str", "order");
            intent.putExtras(bundle);
            startActivity(intent);
        }
        //
        else if (id == R.id.checkOrder){
            Intent intent = new Intent(getApplicationContext(),FoodOrderView.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("user",user);
            bundle.putString("str","check");
            intent.putExtras(bundle);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
