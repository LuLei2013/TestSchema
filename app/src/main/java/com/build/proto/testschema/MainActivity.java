package com.build.proto.testschema;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;


public class MainActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.hello).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleOnClick();
            }
        });

    }

    void handleOnClick() {


//        ARouter.getInstance().build("/lulei/mainactivity2").navigation();

        ARouter.getInstance().build("/lulei/mainactivity2")
                .withInt("age", 27)
                .withString("name", "lulei")
                .withSerializable("test", new Test("Jack", "Rose"))
                .navigation();
    }
}
