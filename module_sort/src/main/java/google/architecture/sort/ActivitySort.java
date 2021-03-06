package google.architecture.sort;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.jzhson.communal.base.ARouterPath;
import com.jzhson.communal.base.BaseActivity;
import com.jzhson.communal.http.ApiClient;

import google.architecture.sort.http.SortService;

@Route(path = ARouterPath.Classify)
public class ActivitySort extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girls);
        findViewById(R.id.framelayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(new FragmentSort(),R.id.framelayout);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
