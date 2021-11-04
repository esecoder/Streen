package com.streen.android.util.network;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.wifi.WifiManager;

import java.lang.reflect.Method;

public class HotspotManager {

    public HotspotManager() {

    }

    public static void startAccessPoint(HotspotListener listener) {
        mWifiManager = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);

    }

    /**
     * Returns the on/off state of the device WIFI
     * This method os for Android version <5.0
     * @param context application context
     * @return true or false
     */
    @TargetApi(21)
    public static boolean isAccessPointOn(Context context) {
        WifiManager wifimanager = (WifiManager) context.getApplicationContext().getSystemService(context.WIFI_SERVICE);
        try {
            Method method = wifimanager.getClass().getDeclaredMethod("isWifiApEnabled");
            method.setAccessible(true);
            return (Boolean) method.invoke(wifimanager);
        }
        catch (Throwable ignored) {}
        return false;
    }



}
