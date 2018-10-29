package com.datastructureandalgorithms.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.datastructureandalgorithms.app.forofferbook.ForOfferActivity;
import com.datastructureandalgorithms.app.link.LinkActivity;
import com.datastructureandalgorithms.app.tree.TreeActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toLink(View view) {
        startActivity(new Intent(this, LinkActivity.class));
    }

    public void toCommon(View view) {
        startActivity(new Intent(this, CommonActivity.class));
    }

    public void toTree(View view) {
        startActivity(new Intent(this, TreeActivity.class));
    }

    public void toSort(View view) {
        startActivity(new Intent(this, SortActivity.class));
    }

    public void toForOffer(View view) {
        startActivity(new Intent(this, ForOfferActivity.class));
    }
}
