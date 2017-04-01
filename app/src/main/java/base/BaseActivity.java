package base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/4/1.
 */

public class BaseActivity extends AutoLayoutActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }
}
