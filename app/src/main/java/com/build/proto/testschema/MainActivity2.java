package com.build.proto.testschema;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;


@Route(path = "/lulei/mainactivity2")
public class MainActivity2 extends AppCompatActivity {

    @Autowired(name = "age")
    public int age;

    @Autowired(name = "name")
    public String name;

    @Autowired(name = "test")
    public Test test;


    MyProvider myProvider = ARouter.getInstance().navigation(MyProvider.class);

    YouProvider youProvider = (YouProvider) ARouter.getInstance().build("/lulei/youprovider").navigation();

    public void onCreate(Bundle savedInstanceState) {
        // 主动调用这个
        ARouter.getInstance().inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Log.e("Ruby", "name = " + name + " , age =  " + age + " , test = " + test);

        Log.e("Ruby", "myProvider = " + myProvider.getClass().getName() + " , youProvider =  " + youProvider.getClass().getName());
        ((TextView) findViewById(R.id.name)).setText(name);

        ((TextView) findViewById(R.id.age)).setText("" + age);
    }

}
