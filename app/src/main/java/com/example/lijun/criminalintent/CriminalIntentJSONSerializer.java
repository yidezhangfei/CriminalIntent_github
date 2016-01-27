package com.example.lijun.criminalintent;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

/**
 * Created by lijun on 16/1/27.
 */
public class CriminalIntentJSONSerializer {
    private Context mContext;
    private String mFileName;

    public CriminalIntentJSONSerializer(Context context, String filename) {
        mContext = context;
        mFileName = filename;
    }

    public void saveCrimes(ArrayList<Crime> crimes)
        throws JSONException,IOException {
        JSONArray jsonArray = new JSONArray();

        for (Crime crime : crimes) {
            jsonArray.put(crime.toJSON());
        }

        // Write the file to disk.
        Writer writer = null;
        try {
            OutputStream out =
                    mContext.openFileOutput(mFileName, Context.MODE_PRIVATE);
            writer = new OutputStreamWriter(out);
            writer.write(jsonArray.toString());
        } finally {
            if (writer != null)
                writer.close();
        }
    }

    public ArrayList<Crime> loadCrimes() throws IOException, JSONException {
        ArrayList<Crime> crimes = new ArrayList<>();
        BufferedReader reader = null;
        try {
            // Open and read the file into a StringBuilder.
            InputStream in = mContext.openFileInput(mFileName);
            reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder jsonString = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                // Line breaks are omitted and irrelevant.
                jsonString.append(line);
            }

            JSONArray jsonArray = (JSONArray) new JSONTokener(jsonString.toString()).nextValue();
            // Build the array from jsonobject.
            for (int i = 0; i < jsonArray.length(); i++) {
                crimes.add(new Crime(jsonArray.getJSONObject(i)));
            }

        } catch (FileNotFoundException e) {

        } finally {
            if (reader != null)
                reader.close();
        }

        return crimes;
    }
}
