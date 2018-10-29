package com.datastructureandalgorithms.app.forofferbook;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.datastructureandalgorithms.app.R;
import com.datastructureandalgorithms.app.util.FLogger;

/**
 * Created by lixiang on 2018/10/29.<br/>
 */
public final class ForOfferActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_offer_test);
        findViewById(R.id.btn_run).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_run) {
            run();
        }
    }

    private void run() {
        int[][] arr = {{1, 2, 3}, {2, 3, 4}, {5, 6, 10}};
        boolean result = ForOffer_1.searchNumber(arr, 10);
        FLogger.msg(result);
    }
}
