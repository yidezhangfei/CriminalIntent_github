package com.example.lijun.criminalintent;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.Date;
import java.util.UUID;

/**
 * Created by lijun on 15/12/9.
 */
public class Crime {

    private static final String JSON_ID = "id";
    private static final String JSON_TITLE = "title";
    private static final String JSON_DATE = "date";
    private static final String JSON_SOLVED = "solved";

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private DateFormat mDateFormat;
    private boolean mSolved;

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }


    public String getDateString() {
        int field = DateFormat.DAY_OF_WEEK_FIELD;
        FieldPosition fieldPosition = new FieldPosition(field);
        StringBuffer dateString = new StringBuffer();
        String string = new String();
        return mDateFormat.format(mDate, dateString, fieldPosition).toString();
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject object = new JSONObject();
        object.put(JSON_ID, mId.toString());
        object.put(JSON_DATE, mDate.getTime());
        object.put(JSON_TITLE, mTitle);
        object.put(JSON_SOLVED, mSolved);
        return object;
    }

    public Crime() {
        // 生成唯一标识符
        mId = UUID.randomUUID();
        mDate = new Date();
        mDateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.SHORT);
    }

    @Override
    public String toString() {
        return mTitle;
    }
}
