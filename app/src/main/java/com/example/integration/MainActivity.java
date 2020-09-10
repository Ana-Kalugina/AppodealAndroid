package com.example.integration;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.multidex.MultiDex;

import com.appodeal.ads.Appodeal;
import com.appodeal.ads.BannerCallbacks;
import com.appodeal.ads.NativeAd;
import com.appodeal.ads.NativeAdView;
import com.appodeal.ads.RewardedVideoCallbacks;
import com.appodeal.ads.api.App;
import com.appodeal.ads.utils.Log;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button button2;
    private Button button3;
    private Button button4;
    private int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Appodeal.setLogLevel(Log.LogLevel.verbose);
        Appodeal.initialize(this, "590a524b2c1842b81da4fa868f8c229bee170199e8e95428", Appodeal.BANNER | Appodeal.INTERSTITIAL
                | Appodeal.REWARDED_VIDEO | Appodeal.NATIVE,true);
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
    Appodeal.setBannerCallbacks(new BannerCallbacks() {
        @Override
        public void onBannerLoaded(int i, boolean b) {

        }

        @Override
        public void onBannerFailedToLoad() {

        }

        @Override
        public void onBannerShown() {
            count ++;
        if (count >=5 ){
            Appodeal.hide(MainActivity.this,Appodeal.BANNER_TOP);
            }
        }

        @Override
        public void onBannerShowFailed() {

        }

        @Override
        public void onBannerClicked() {

        }

        @Override
        public void onBannerExpired() {

        }
    });
    }
    public void showInterstitial(){
        Appodeal.hide(this,Appodeal.BANNER_TOP);
        if(Appodeal.isLoaded(Appodeal.INTERSTITIAL)) {
            Appodeal.show(this, Appodeal.INTERSTITIAL);
            
        }
    }
    public void showRewardedVideo() {
        Appodeal.hide(this,Appodeal.BANNER_TOP);
        if(Appodeal.isLoaded(Appodeal.REWARDED_VIDEO)) {
            Appodeal.show(this,Appodeal.REWARDED_VIDEO);
        }
    }

    public void showNative() {
        Appodeal.hide(this,Appodeal.BANNER_TOP);
        setContentView(R.layout.activity_main2);
        if(Appodeal.isLoaded(Appodeal.NATIVE)){
            //Получаем список-контейнер из одного элемента нативной рекламы
            List<NativeAd> nativeAdsList = Appodeal.getNativeAds(1);
            // получаем сам объект нативной рекламы по 0 индексу из списка, т.е самый первый (в нашем случае и последний, т.к мы задали список из одного элемента)
            NativeAd nativeAd=nativeAdsList.get(0);
            //а далее нам нужно засетапить вью для нативки
        }

    }


}
