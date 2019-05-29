package com.jzhson.specialshop;

import com.alibaba.android.arouter.launcher.ARouter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.jzhson.communal.base.BaseApplication;
import com.jzhson.communal.util.Utils;

/**
 * Created by dxx on 2017/11/13.
 */

public class App extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        if (Utils.isAppDebug()) {
            //开启InstantRun之后，一定要在ARouter.init之前调用openDebug
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);
    }
}
