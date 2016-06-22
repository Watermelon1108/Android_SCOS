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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
<<<<<<< HEAD
import android.widget.Toast;
=======
>>>>>>> 091363891075d850ed6d10f33087363dee5edab7

import es.source.code.model.User;

public class LoginOrRegister extends AppCompatActivity {
<<<<<<< HEAD
    EditText editName;
    EditText editPassword;
    TextView tvSignIn;
    Button btnLogin,btnRet;
=======
    private EditText editName;
    private EditText editPassword;
>>>>>>> 091363891075d850ed6d10f33087363dee5edab7

    private boolean checkText(String str){
        if(str.length()<=0)
            return false;
        for(int i=0;i<str.length();++i){
            char j=str.charAt(i);
            if(!((j>='0'&&j<='9')||(j>='A'&&j<='Z')||(j>='a'&&j<='z')))
                return false;
        }
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_or_register);

<<<<<<< HEAD
        init();
        haveRecord();

=======
        final Button btnLogin=(Button)findViewById(R.id.login);
        final Button btnRet=(Button)findViewById(R.id.ret);
        final TextView tvSignIn = (TextView)findViewById(R.id.signIn);
        
>>>>>>> 091363891075d850ed6d10f33087363dee5edab7
        assert btnLogin != null;
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
<<<<<<< HEAD
=======
                editName=(EditText)findViewById(R.id.name);
                editPassword=(EditText)findViewById(R.id.password);
>>>>>>> 091363891075d850ed6d10f33087363dee5edab7
                String name=editName.getText().toString();
                String password=editPassword.getText().toString();
                User loginUser = new User(name,password,true);

                if(checkText(name)&&checkText(password)){
<<<<<<< HEAD

                    //login success
                    saveReocde(name);

=======
>>>>>>> 091363891075d850ed6d10f33087363dee5edab7
                    Intent intent1=new Intent();
                    intent1.setClass(LoginOrRegister.this, MainScreen.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("data","LoginSuccess");
                    bundle.putSerializable("user", loginUser);
                    intent1.putExtras(bundle);
                    startActivity(intent1);
                }
                else{
                    if(!checkText(name)){
                        editName.setError("输入内容不符合规则");
                    }
                    if(!checkText(password)){
                        editPassword.setError("输入内容不符合规则");
                    }
                }
            }
        });

        assert btnRet!=null;
        btnRet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
<<<<<<< HEAD
                judgeAndSave();
                Intent intent2=new Intent();
                intent2.setClass(LoginOrRegister.this,MainScreen.class);
                intent2.putExtra("returnData", "Return");
                startActivity(intent2);
                finish();
=======
                Intent intent2=new Intent();
                intent2.setClass(LoginOrRegister.this,MainScreen.class);
                intent2.putExtra("returnData","Return");
                startActivity(intent2);
>>>>>>> 091363891075d850ed6d10f33087363dee5edab7
            }
        });

        assert tvSignIn!=null;
        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editName=(EditText)findViewById(R.id.name);
                editPassword=(EditText)findViewById(R.id.password);
                String name=editName.getText().toString();
                String password=editPassword.getText().toString();
                User loginUser = new User(name,password,false);

                if(checkText(name)&&checkText(password)){
<<<<<<< HEAD
                    //register success
                    saveReocde(name);

=======
>>>>>>> 091363891075d850ed6d10f33087363dee5edab7
                    Intent intent1=new Intent();
                    intent1.setClass(LoginOrRegister.this, MainScreen.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("data","RegisterSuccess");
                    bundle.putSerializable("user", loginUser);
                    intent1.putExtras(bundle);
                    startActivity(intent1);
<<<<<<< HEAD
                    finish();
=======
>>>>>>> 091363891075d850ed6d10f33087363dee5edab7
                }
                else{
                    if(!checkText(name)){
                        editName.setError("输入内容不符合规则");
                    }
                    if(!checkText(password)){
                        editPassword.setError("输入内容不符合规则");
                    }
                }

            }
        });
    }
<<<<<<< HEAD


    void judgeAndSave(){
        SharedPreferences sp = getSharedPreferences("user_reocrd", Activity.MODE_PRIVATE);
        String name = sp.getString("name", "");
        if(!name.equalsIgnoreCase("")){
            SharedPreferences.Editor editor = sp.edit();
            editor.putInt("loginState",0);
            editor.apply();
        }
    }

    void init(){
        btnLogin=(Button)findViewById(R.id.login);
        btnRet=(Button)findViewById(R.id.ret);
        tvSignIn = (TextView)findViewById(R.id.signIn);
        editName=(EditText)findViewById(R.id.name);
        editPassword=(EditText)findViewById(R.id.password);
    }

    //judge if the SharedPreferences has a login record
    void haveRecord(){
        SharedPreferences sp = getSharedPreferences("user_reocrd", Activity.MODE_PRIVATE);
        String name = sp.getString("name", "");
//        String pass = sp.getString("password","");
        if(checkText(name)){
            tvSignIn.setVisibility(View.INVISIBLE);
            editName.setText(name);
        }
        else {
            btnLogin.setVisibility(View.INVISIBLE);
        }
    }
    //save the login record
    void saveReocde(String name){
        SharedPreferences sp = getSharedPreferences("user_reocrd", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("name",name);
//        editor.putString("password",pass);
        editor.putInt("loginState",1);
        editor.apply();
        Toast.makeText(this,"write success",Toast.LENGTH_SHORT).show();
    }
}





















=======
}
>>>>>>> 091363891075d850ed6d10f33087363dee5edab7
