package com.example.lijun.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by lijun on 16/1/28.
 */
public class CrimeCameraActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeCameraFragment();
    }
}
