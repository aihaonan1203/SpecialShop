package debug;
import com.alibaba.android.arouter.launcher.ARouter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.jzhson.communal.base.BaseApplication;


/**
 * Created by dxx on 2017/11/15.
 * 组件化编译的时候才生效
 */

public class SortApplication extends BaseApplication {

    private static String token="eyJ1aWQiOjEsInRpbWVzdGFtcCI6MTU1ODg1NjM3MCwic2lnbiI6ImY2MDYzYjU0YWI5YTNjMjRlMzE2NGQxNmE3ZDQwOTI1In0";

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        ARouter.init(this);
    }

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        SortApplication.token = token;
    }
}
