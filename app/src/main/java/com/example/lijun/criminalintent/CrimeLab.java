package com.example.lijun.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by lijun on 16/1/15.
 */
public class CrimeLab {
    private ArrayList<Crime> mCrimes;

    private static CrimeLab ourInstance;
    private Context mAppContext;

    public ArrayList<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID id) {
        for (Crime c : mCrimes) {
            if (c.getId().equals(id))
                return c;
        }
        return null;
    }

    public static CrimeLab getInstance(Context context) {
        if (ourInstance == null) {
            ourInstance = new CrimeLab(context);
        }
        return ourInstance;
    }

    private CrimeLab(Context context) {
        mAppContext = context;
        mCrimes = new ArrayList<Crime>();
        for (int i = 0; i < 100; i++) {
            Crime c = new Crime();
            c.setTitle("Crime #" + i);
            c.setSolved(i % 2 == 0);  // Every other one , fortest
            mCrimes.add(c);
        }
    }
}
