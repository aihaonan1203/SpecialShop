package debug;

import com.alibaba.android.arouter.launcher.ARouter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.jzhson.communal.base.BaseApplication;

/**
 * Created by dxx on 2017/11/15.
 * 组件化编译的时候才生效
 */

public class RangeApplication extends BaseApplication {



    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        ARouter.init(this);
    }

}
