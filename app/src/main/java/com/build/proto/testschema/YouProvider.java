package com.build.proto.testschema;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.template.IProvider;


@Route(path = "/lulei/youprovider")
public class YouProvider implements IProvider {
    @Override
    public void init(Context context) {
        Log.e("Ruby", "YouInterceptor init");
    }
}
