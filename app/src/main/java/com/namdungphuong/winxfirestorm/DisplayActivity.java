package com.namdungphuong.winxfirestorm;

import android.support.v7.app.ActionBarActivity;

import android.os.Bundle;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.startapp.android.publish.StartAppAd;
import com.startapp.android.publish.StartAppSDK;

public class DisplayActivity extends ActionBarActivity {

    /** StartAppAd object declaration */
    private StartAppAd startAppAd = new StartAppAd(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //StartAppSDK.init(this, "202819519", true);

        setContentView(R.layout.activity_display);



        SubsamplingScaleImageView imageView = (SubsamplingScaleImageView)findViewById(R.id.imageView);
        imageView.setImage(ImageSource.resource(R.drawable.winx));



    }

    @Override
    public void onBackPressed() {
        startAppAd.onBackPressed();
        super.onBackPressed();
        finish();

    }
}
