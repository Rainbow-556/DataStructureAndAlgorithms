package com.datastructureandalgorithms.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.datastructureandalgorithms.app.link.LinkPracticeActivity;
import com.datastructureandalgorithms.app.tree.TreePracticeActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toLink(View view) {
        startActivity(new Intent(this, LinkPracticeActivity.class));
    }

    public void toCommon(View view) {
        startActivity(new Intent(this, CommonPracticeActivity.class));
    }

    public void toTree(View view) {
        startActivity(new Intent(this, TreePracticeActivity.class));
    }
}
