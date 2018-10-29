package com.datastructureandalgorithms.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.datastructureandalgorithms.app.util.FLogger;

/**
 * Created by lixiang on 2018/6/5.<br/>
 */
public final class CommonActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);
        findViewById(R.id.btn_hanoi).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_hanoi:
                hanoi(3, 'A', 'B', 'C');
                break;
        }
    }

    /**
     * 汉诺塔问题递归实现
     */
    private void hanoi(int N, char A, char B, char C) {
        if (N == 1) {
            // 只剩下一个时，直接从A移动到C，完成
            move(A, C);
        } else {
            // 把A上N-1个盘子移动到B
            hanoi(N - 1, A, C, B);
            // 把A上最后一个盘子直接移动到C
            move(A, C);
            // 到这里问题就变成，把B上N-1个盘子移动到C
            hanoi(N - 1, B, A, C);
        }
    }

    private void move(char from, char to) {
        FLogger.msg(String.format("move from %s to %s", from, to));
    }
}
