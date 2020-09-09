package com.example.integration;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.multidex.MultiDex;

import com.appodeal.ads.Appodeal;
import com.appodeal.ads.RewardedVideoCallbacks;
import com.appodeal.ads.api.App;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button button2;
    private Button button3;
    private Button button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Appodeal.initialize(this, "590a524b2c1842b81da4fa868f8c229bee170199e8e95428", Appodeal.BANNER,true);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBanner();
            }
        });
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInterstitial();
            }
        });
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRewardedVideo();
            }
        });
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNative();
            }
        });

    }
    public void showBanner() {
        Appodeal.show(this, Appodeal.BANNER_TOP);
//        Intent intent = new Intent(this, MainActivity2.class);
//        startActivity(intent);
    }
    public void showInterstitial() {
        Appodeal.show(this,Appodeal.INTERSTITIAL);
        Appodeal.isLoaded(Appodeal.INTERSTITIAL);
        Appodeal.setAutoCache(Appodeal.INTERSTITIAL, false);
        Appodeal.cache(this, Appodeal.INTERSTITIAL);
    }
    public void showRewardedVideo() {
        Appodeal.show(this,Appodeal.REWARDED_VIDEO);
        Appodeal.isLoaded(Appodeal.REWARDED_VIDEO);
        Appodeal.setRewardedVideoCallbacks(new RewardedVideoCallbacks() {
            @Override
            public void onRewardedVideoLoaded(boolean isPrecache) {
                // Called when rewarded video is loaded
            }
            @Override
            public void onRewardedVideoFailedToLoad() {
                // Called when rewarded video failed to load
            }
            @Override
            public void onRewardedVideoShown() {
                // Called when rewarded video is shown
            }
            @Override
            public void onRewardedVideoShowFailed() {
                // Called when rewarded video show failed
            }
            @Override
            public void onRewardedVideoClicked() {
                // Called when rewarded video is clicked
            }
            @Override
            public void onRewardedVideoFinished(double amount, String name) {
                // Called when rewarded video is viewed until the end
            }
            @Override
            public void onRewardedVideoClosed(boolean finished) {
                // Called when rewarded video is closed
            }
            @Override
            public void onRewardedVideoExpired() {
                // Called when rewarded video is expired
            }

        });
        Appodeal.setAutoCache(Appodeal.REWARDED_VIDEO, false);
        Appodeal.cache(this, Appodeal.REWARDED_VIDEO);
    }

    public void showNative() {

    }
}