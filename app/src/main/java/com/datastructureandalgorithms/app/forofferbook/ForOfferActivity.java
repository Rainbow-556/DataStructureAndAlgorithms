package com.datastructureandalgorithms.app.forofferbook;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.datastructureandalgorithms.app.R;

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
        ForOffer_5.twoStackImplQueue();
    }
}
