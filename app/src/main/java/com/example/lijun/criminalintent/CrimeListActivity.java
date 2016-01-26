package com.example.lijun.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by lijun on 16/1/15.
 */
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
