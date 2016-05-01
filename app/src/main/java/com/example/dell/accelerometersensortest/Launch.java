package com.example.dell.accelerometersensortest;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

/**
 * Created by dell on 2016/4/12.
 */
public class Launch extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.launch);
        Handler handler=new Handler();
        handler.postDelayed(new launchhandler(),3000);
    }
    class launchhandler implements Runnable{
        public void run(){
            Intent intent=new Intent(getApplication(),MainActivity.class);
            startActivity(intent);
            Launch.this.finish();
        }
    }
}
