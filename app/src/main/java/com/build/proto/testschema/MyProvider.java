package com.build.proto.testschema;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.template.IProvider;

//测试下不加会怎样
@Route(path = "/lulei/myprovider")
public class MyProvider implements IProvider {
    @Override
    public void init(Context context) {
        Log.e("Ruby", "MyInterceptor init");
    }
}
