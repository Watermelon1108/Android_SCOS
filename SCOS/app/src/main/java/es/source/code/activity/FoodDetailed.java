package es.source.code.activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class FoodDetailed extends AppCompatActivity implements View.OnTouchListener,GestureDetector.OnGestureListener {


    GestureDetector mGestureDetector;
    private static final int FLING_DISTANCE=50;
    LinearLayout ll;
    ImageView imageView;
    int pic[] = {
            R.drawable.liangcai,
            R.drawable.recai,
            R.drawable.haixian,
            R.drawable.jiushui
    };
    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_detailed);

        mGestureDetector=new GestureDetector(this,this);
        ll=(LinearLayout)findViewById(R.id.image_ll);
        imageView=(ImageView)findViewById(R.id.image);

        assert ll!=null;
        ll.setOnTouchListener(this);
        ll.setLongClickable(true);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        //left slide
        if(e1.getX()-e2.getX()>FLING_DISTANCE){
            flag = (flag - 1 + pic.length) % pic.length;
            imageView.setBackgroundResource(pic[flag]);
        }
        //right slide
        else if(e2.getX()-e1.getX()>FLING_DISTANCE){
            flag = (flag + 1 + pic.length) % pic.length;
            imageView.setBackgroundResource(pic[flag]);
        }
        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_food_detailed, menu);
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
