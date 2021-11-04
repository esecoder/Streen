package com.streen.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.streen.android.dialog.CommonDialogs;
import com.streen.android.dialog.dialogplus.DialogPlus;
import com.streen.android.dialog.dialogplus.OnClickListener;
import com.streen.android.dialog.dialogplus.OnDismissListener;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener, OnClickListener {

    private static final String TAG = HomeActivity.class.getSimpleName();
    private LinearLayout linearLayout;
    private TextView textView;

    @Override
    protected void onResume() {
        super.onResume();
        //TODO Check if streaming service is running
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //int scWidth = Util.getScreenWidthInPixels(this);
        /*if (scWidth <= 720) {
            //setContentView(R.layout.activity_home_720p);
        } else {
            setContentView(R.layout.activity_home);
        }*/

        setContentView(R.layout.activity_home);

        linearLayout = findViewById(R.id.stream_button);
        linearLayout.setOnClickListener(this);
        LinearLayout linearLayout1 = findViewById(R.id.settings_button);
        linearLayout1.setOnClickListener(this);

        ImageView imageView = findViewById(R.id.stream);
        imageView.setOnClickListener(this);

        textView = findViewById(R.id.start_streaming_text);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.stream_button:
            case R.id.stream:
                CommonDialogs.setupDialog(this, this, new OnDismissListener() {
                    @Override
                    public void onDismiss(DialogPlus dialog) {

                    }
                });
                break;

            case R.id.settings_button:
                startActivity(new Intent(HomeActivity.this, SettingsActivity.class));
                break;
        }
    }

    @Override
    public void onClick(DialogPlus dialog, View view) {
        if (view.getId() == R.id.dismiss) {
            dialog.dismiss();
            //TODO kill streaming service and setup process
        }
    }
}
