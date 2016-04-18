package com.shaojie.demo.simplebottomsheet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.bs_show_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestBottomSheet bottomSheet = new TestBottomSheet(MainActivity.this);
                bottomSheet.show();
            }
        });
    }

}
