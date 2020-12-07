package com.example.network.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseData implements Parcelable {
    @SerializedName("logo-url")
    @Expose
    private String logoUrl;
    @SerializedName("heading-text")
    @Expose
    private String headingText;
    @SerializedName("uidata")
    @Expose
    private List<Uidatum> uidata = null;

    protected ResponseData(Parcel in) {
        logoUrl = in.readString();
        headingText = in.readString();
        uidata = in.createTypedArrayList(Uidatum.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(logoUrl);
        dest.writeString(headingText);
        dest.writeTypedList(uidata);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ResponseData> CREATOR = new Creator<ResponseData>() {
        @Override
        public ResponseData createFromParcel(Parcel in) {
            return new ResponseData(in);
        }

        @Override
        public ResponseData[] newArray(int size) {
            return new ResponseData[size];
        }
    };

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getHeadingText() {
        return headingText;
    }

    public void setHeadingText(String headingText) {
        this.headingText = headingText;
    }

    public List<Uidatum> getUidata() {
        return uidata;
    }

    public void setUidata(List<Uidatum> uidata) {
        this.uidata = uidata;
    }
}
