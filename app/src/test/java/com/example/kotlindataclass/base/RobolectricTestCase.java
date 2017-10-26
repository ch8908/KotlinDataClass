package com.example.kotlindataclass.base;

import android.os.Build;
import com.example.kotlindataclass.BuildConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;

@Config(shadows = {ShadowLog.class}, manifest = "src/main/AndroidManifest.xml", constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP, packageName = "com.example.kotlindataclass")
@RunWith(RobolectricTestRunner.class)
public abstract class RobolectricTestCase {

    /*
    * If we want to using AndroidSchedulers in JVM, we need to override AndroidSchedulers.
    * https://medium.com/@peter.tackage/overriding-rxandroid-schedulers-in-rxjava-2-5561b3d14212#.u0uey4oig
    * */
    @BeforeClass
    public static void setupClass() {

    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {

    }
}
