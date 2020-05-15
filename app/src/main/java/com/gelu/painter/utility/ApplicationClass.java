package com.gelu.painter.utility;

import android.os.StrictMode;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

public class ApplicationClass extends MultiDexApplication {

    private static ApplicationClass mInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        MultiDex.install(this);
        mInstance = this;
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }
}
