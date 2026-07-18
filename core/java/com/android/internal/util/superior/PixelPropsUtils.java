/*
 * Copyright (C) 2022 The Pixel Experience Project
 *               2021-2022 crDroid Android Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.internal.util.superior;

import android.app.Application;
import android.os.Build;
import android.os.SystemProperties;
import android.util.Log;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PixelPropsUtils {

    private static final String TAG = PixelPropsUtils.class.getSimpleName();
    private static final String DEVICE = "ro.product.device";
    private static final boolean DEBUG = false;

    private static final String SAMSUNG = "com.samsung.android.";
    private static final boolean PRODUCT_SUPPORT_HIGH_FPS =
            SystemProperties.getBoolean("ro.device.support_high_fps", false);
    private static final boolean PRODUCT_SUPPORT_CONTENT_REFRESH =
            SystemProperties.getBoolean("ro.surface_flinger.use_content_detection_for_refresh_rate", false);
    private static final Map<String, Object> propsToChangePUBG;
    private static final Map<String, Object> propsToChangeCOD;
    private static final Map<String, Object> propsToChange;
    private static final Map<String, Object> propsToChangePixel5;
    private static final Map<String, Object> propsToChangePixel7Pro;
    private static final Map<String, Object> propsToChangePixel6Pro;
    private static final Map<String, Object> propsToChangePixelXL;
    private static final Map<String, ArrayList<String>> propsToKeep;

    private static final String[] packagesToChangePixel7Pro = {
<<<<<<< HEAD
            "com.google.android.apps.privacy.wildlife",
            "com.google.android.apps.wallpaper.pixel",
            "com.google.android.apps.wallpaper"
    };
=======
            "com.google.android.gms",
            "com.google.android.apps.privacy.wildlife",
            "com.google.android.apps.wallpaper.pixel",
            "com.google.android.apps.wallpaper",
            "com.google.android.apps.subscriptions.red",
            "com.google.android.inputmethod.latin",
            "com.google.android.apps.wellbeing",
            "com.google.android.as",
            "com.google.android.gms.persistent",
            "com.google.android.googlequicksearchbox"
>>>>>>> parent of eee768a43c2c (PixelPropsUtils: Add toggle for Gaming and google photos spoofs)

   private static final String[] packagesToChangePixel5 = {
            "com.google.android.tts",
            "com.google.android.apps.tachyon",
            "com.google.android.apps.wellbeing"
    };

    private static final String[] packagesToChangeCOD = {
        "com.activision.callofduty.shooter"
    };

    private static final String[] packagesToChangePUBG = {
        "com.tencent.ig",
        "com.pubg.krmobile",
        "com.vng.pubgmobile",
        "com.rekoo.pubgm",
        "com.pubg.imobile",
        "com.pubg.newstate",
        "com.gameloft.android.ANMP.GloftA9HM" // Asphalt 9
    };

    private static final String[] extraPackagesToChange = {
            "com.android.chrome",
            "com.breel.wallpapers20",
            "com.nothing.smartcenter"
    };

    private static final String[] packagesToChangePixelXL = {
           "com.google.android.apps.photos",
    };

    private static final String[] packagesToKeep = {
            "com.google.android.GoogleCamera",
            "com.google.android.GoogleCamera.Cameight",
            "com.google.android.GoogleCamera.Go",
            "com.google.android.GoogleCamera.Urnyx",
            "com.google.android.GoogleCameraAsp",
            "com.google.android.GoogleCameraCVM",
            "com.google.android.GoogleCameraEng",
            "com.google.android.GoogleCameraEng2",
            "com.google.android.GoogleCameraGood",
            "com.google.android.MTCL83",
            "com.google.android.UltraCVM",
            "com.google.android.apps.cameralite",
            "com.google.android.dialer",
            "com.google.android.euicc",
            "com.google.ar.core",
            "com.google.android.youtube",
            "com.google.android.apps.youtube.kids",
            "com.google.android.apps.youtube.music",
            "com.google.android.apps.recorder",
            "com.google.android.apps.wearables.maestro.companion"
    };

    // Codenames for currently supported Pixels by Google
    private static final String[] pixelCodenames = {
            "cheetah",
            "panther",
            "bluejay",
            "oriole",
            "raven",
            "barbet",
            "redfin",
            "bramble",
            "sunfish"
    };

    private static volatile boolean sIsGms = false;
    private static volatile boolean sIsFinsky = false;

    static {
        propsToKeep = new HashMap<>();
        propsToChange = new HashMap<>();
        propsToKeep.put("com.google.android.settings.intelligence", new ArrayList<>(Collections.singletonList("FINGERPRINT")));
        propsToChangePixel7Pro = new HashMap<>();
        propsToChangePixel7Pro.put("BRAND", "google");
        propsToChangePixel7Pro.put("MANUFACTURER", "Google");
        propsToChangePixel7Pro.put("DEVICE", "cheetah");
        propsToChangePixel7Pro.put("PRODUCT", "cheetah");
        propsToChangePixel7Pro.put("MODEL", "Pixel 7 Pro");
<<<<<<< HEAD
<<<<<<< HEAD
        propsToChangePixel7Pro.put("FINGERPRINT", "google/cheetah/cheetah:13/TQ1A.230205.002/9471150:user/release-keys");
        propsToChangePixel6Pro = new HashMap<>();
        propsToChangePixel6Pro.put("BRAND", "google");
        propsToChangePixel6Pro.put("MANUFACTURER", "Google");
        propsToChangePixel6Pro.put("DEVICE", "raven");
        propsToChangePixel6Pro.put("PRODUCT", "raven");
        propsToChangePixel6Pro.put("MODEL", "Pixel 6 Pro");
        propsToChangePixel6Pro.put("FINGERPRINT", "google/raven/raven:13/TQ1A.230205.002/9471150:user/release-keys");
=======
        propsToChangePixel7Pro.put("FINGERPRINT", "google/cheetah/cheetah:13/TQ1A.230105.001.A2/9325679:user/release-keys");
>>>>>>> parent of eee768a43c2c (PixelPropsUtils: Add toggle for Gaming and google photos spoofs)
=======
        propsToChangePixel7Pro.put("FINGERPRINT", "google/cheetah/cheetah:13/TQ1A.221205.011/9244662:user/release-keys");
>>>>>>> parent of f80118ab786f (PixelpropUtils: Update fingerprints to January 2023 Release)
        propsToChangePixel5 = new HashMap<>();
        propsToChangePixel5.put("BRAND", "google");
        propsToChangePixel5.put("MANUFACTURER", "Google");
        propsToChangePixel5.put("DEVICE", "redfin");
        propsToChangePixel5.put("PRODUCT", "redfin");
        propsToChangePixel5.put("MODEL", "Pixel 5");
<<<<<<< HEAD
        propsToChangePixel5.put("FINGERPRINT", "google/redfin/redfin:13/TQ1A.230205.002/9471150:user/release-keys");
=======
        propsToChangePixel5.put("FINGERPRINT", "google/redfin/redfin:13/TQ1A.221205.011/9244662:user/release-keys");
>>>>>>> parent of f80118ab786f (PixelpropUtils: Update fingerprints to January 2023 Release)
        propsToChangePixelXL = new HashMap<>();
        propsToChangePixelXL.put("BRAND", "google");
        propsToChangePixelXL.put("MANUFACTURER", "Google");
        propsToChangePixelXL.put("DEVICE", "marlin");
        propsToChangePixelXL.put("PRODUCT", "marlin");
        propsToChangePixelXL.put("MODEL", "Pixel XL");
        propsToChangePixelXL.put("FINGERPRINT", "google/marlin/marlin:10/QP1A.191005.007.A3/5972272:user/release-keys");
        propsToChangePUBG = new HashMap<>();
        propsToChangePUBG.put("MODEL", "GM1917");
        propsToChangeCOD = new HashMap<>();
        propsToChangeCOD.put("MODEL", "SO-52A");
    }

    public static void setProps(String packageName) {
        if (packageName == null || packageName.isEmpty()) {
            return;
        }
        if (Arrays.asList(packagesToKeep).contains(packageName)) {
            return;
        }
        if (packageName.startsWith("com.google.")
                || packageName.startsWith(SAMSUNG)
                || Arrays.asList(extraPackagesToChange).contains(packageName)) {

            boolean isPixelDevice = Arrays.asList(pixelCodenames).contains(SystemProperties.get(DEVICE));

            if (packageName.equals("com.google.android.apps.photos")) {
<<<<<<< HEAD
                if (SystemProperties.getBoolean("persist.sys.pixelprops.gphotos", true)) {
                    propsToChange.putAll(propsToChangePixelXL);
                } else {
                    if (isPixelDevice) return;
                    propsToChange.putAll(propsToChangePixel5);
                }
            } else if (isPixelDevice) {
                return;
=======
                propsToChange.putAll(propsToChangePixelXL);
>>>>>>> parent of eee768a43c2c (PixelPropsUtils: Add toggle for Gaming and google photos spoofs)
            } else if (packageName.equals("com.android.vending")) {
                sIsFinsky = true;
                return;
            } else if (!isPixelDevice) {
                if ((Arrays.asList(packagesToChangePixel7Pro).contains(packageName))) {
                    propsToChange.putAll(propsToChangePixel7Pro);
                } else if (Arrays.asList(packagesToChangePixelXL).contains(packageName)) {
                    propsToChange.putAll(propsToChangePixelXL);
                } else if (Arrays.asList(packagesToChangePixel5).contains(packageName)) {
                    propsToChange.putAll(propsToChangePixel5);
                } else {
                    propsToChange.putAll(propsToChangePixel6Pro);
                }
            }

            if (DEBUG) Log.d(TAG, "Defining props for: " + packageName);
            for (Map.Entry<String, Object> prop : propsToChange.entrySet()) {
                String key = prop.getKey();
                Object value = prop.getValue();
                if (propsToKeep.containsKey(packageName) && propsToKeep.get(packageName).contains(key)) {
                    if (DEBUG) Log.d(TAG, "Not defining " + key + " prop for: " + packageName);
                    continue;
                }
                if (DEBUG) Log.d(TAG, "Defining " + key + " prop for: " + packageName);
                setPropValue(key, value);
            }
            if (packageName.equals("com.google.android.gms")) {
                final String processName = Application.getProcessName();
                if (processName.equals("com.google.android.gms.unstable")) {
                    sIsGms = true;
                    setPropValue("FINGERPRINT", "google/angler/angler:6.0/MDB08L/2343525:user/release-keys");
                    setPropValue("MODEL", "angler");
                }
                return;
            }

        if (PRODUCT_SUPPORT_HIGH_FPS || PRODUCT_SUPPORT_CONTENT_REFRESH) {
            if (Arrays.asList(packagesToChangePUBG).contains(packageName)){
                if (DEBUG){
                    Log.d(TAG, "Defining props for: " + packageName);
                }
                for (Map.Entry<String, Object> prop : propsToChangePUBG.entrySet()) {
                    String key = prop.getKey();
                    Object value = prop.getValue();
                    setPropValue(key, value);
                }
            }
            if (Arrays.asList(packagesToChangeCOD).contains(packageName)){
                if (DEBUG){
                    Log.d(TAG, "Defining props for: " + packageName);
                }
                for (Map.Entry<String, Object> prop : propsToChangeCOD.entrySet()) {
                    String key = prop.getKey();
                    Object value = prop.getValue();
                    setPropValue(key, value);
                }
            }
        }

           // Set proper indexing fingerprint
            if (packageName.equals("com.google.android.settings.intelligence")) {
                setPropValue("FINGERPRINT", Build.VERSION.INCREMENTAL);
            }
        }
    }

    static void setPropValue(String key, Object value) {
        try {
            if (DEBUG) Log.d(TAG, "Defining prop " + key + " to " + value.toString());
            Field field = Build.class.getDeclaredField(key);
            field.setAccessible(true);
            field.set(null, value);
            field.setAccessible(false);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            Log.e(TAG, "Failed to set prop " + key, e);
        }
    }

    private static boolean isCallerSafetyNet() {
        return Arrays.stream(Thread.currentThread().getStackTrace())
                .anyMatch(elem -> elem.getClassName().contains("DroidGuard"));
    }

    public static void onEngineGetCertificateChain() {
        // Check stack for SafetyNet
        if (sIsGms && isCallerSafetyNet()) {
            throw new UnsupportedOperationException();
        }

        // Check stack for PlayIntegrity
        if (sIsFinsky) {
            throw new UnsupportedOperationException();
        }
    }
    
     static void dlog(String msg) {
      if (DEBUG) Log.d(TAG, msg);
    }
}
