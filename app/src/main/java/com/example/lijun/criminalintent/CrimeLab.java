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

    public void addCrime(Crime crime) {
        mCrimes.add(crime);
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
        mCrimes = new ArrayList<>();
    }
}