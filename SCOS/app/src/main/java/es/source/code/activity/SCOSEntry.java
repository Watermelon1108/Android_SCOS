package es.source.code.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;

<<<<<<< HEAD
import es.source.code.model.User;

=======
>>>>>>> 091363891075d850ed6d10f33087363dee5edab7
public class SCOSEntry extends AppCompatActivity implements OnTouchListener,OnGestureListener {

    GestureDetector mGestureDetector;
    private static final int FLING_DISTANCE=50;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry);
        mGestureDetector=new GestureDetector(this,(OnGestureListener)this);
        RelativeLayout ll=(RelativeLayout)findViewById(R.id.scoslogo);
        assert ll!=null;
        ll.setOnTouchListener(this);
        ll.setLongClickable(true);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if(e1.getX()-e2.getX()>FLING_DISTANCE){
<<<<<<< HEAD
            /*
=======
>>>>>>> 091363891075d850ed6d10f33087363dee5edab7
            Intent intent=new Intent();
            intent.setAction("scos.intent.action.SCOSMAIN");
            intent.addCategory("scos.intent.category.SCOSLAUNCHER");
            intent.putExtra("data", "FromEntry");
            intent.addFlags(1);
            startActivity(intent);
<<<<<<< HEAD
            */
            Intent intent1=new Intent();
            intent1.setClass(SCOSEntry.this, MainScreen.class);
            User loginUser = new User("root","root",false);
            Bundle bundle = new Bundle();
            bundle.putString("data","test");
            bundle.putSerializable("user", loginUser);
            intent1.putExtras(bundle);
            startActivity(intent1);
            finish();
=======
>>>>>>> 091363891075d850ed6d10f33087363dee5edab7
        }
        return false;
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
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
