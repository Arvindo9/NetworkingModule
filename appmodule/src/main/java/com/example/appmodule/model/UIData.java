package com.example.appmodule.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Author       : Arvindo Mondal
 * Created date : 01-12-2020
 * Email        : arvindo@aiprog.ai
 * Company      : AIPROG
 * Designation  : Programmer
 * About        : I am a human can only think, I can't be a person like machine which have lots of memory and knowledge.
 * Quote        : No one can measure limit of stupidity but stupid things bring revolutions
 * Strength     : Never give up
 * Motto        : To be known as great Mathematician
 * Skills       : Algorithms and logic
 * Website      : www.aiprog.ai
 */
public class UIData {
    @SerializedName("logo-url")
    @Expose
    private String logoUrl;
    @SerializedName("heading-text")
    @Expose
    private String headingText;
    @SerializedName("uidata")
    @Expose
    private List<DataModel> uidata = null;

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

    public List<DataModel> getUidata() {
        return uidata;
    }

    public void setUidata(List<DataModel> uidata) {
        this.uidata = uidata;
    }
}
