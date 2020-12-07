package com.example.network.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Uidatum implements Parcelable {
    @SerializedName("uitype")
    @Expose
    private String uitype;
    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("hint")
    @Expose
    private String hint;

    protected Uidatum(Parcel in) {
        uitype = in.readString();
        value = in.readString();
        key = in.readString();
        hint = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(uitype);
        dest.writeString(value);
        dest.writeString(key);
        dest.writeString(hint);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Uidatum> CREATOR = new Creator<Uidatum>() {
        @Override
        public Uidatum createFromParcel(Parcel in) {
            return new Uidatum(in);
        }

        @Override
        public Uidatum[] newArray(int size) {
            return new Uidatum[size];
        }
    };

    public String getUitype() {
        return uitype;
    }

    public void setUitype(String uitype) {
        this.uitype = uitype;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }
}
