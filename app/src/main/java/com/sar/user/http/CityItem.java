package com.sar.user.http;

import android.os.Parcel;
import android.os.Parcelable;

public class CityItem implements Parcelable {
    private Integer userId;
    private Integer id;
    private String title;
    private String body;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.userId);
        dest.writeValue(this.id);
        dest.writeString(this.title);
        dest.writeString(this.body);
    }

    public CityItem() {
    }

    protected CityItem(Parcel in) {
        this.userId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.title = in.readString();
        this.body = in.readString();
    }

    public static final Parcelable.Creator<CityItem> CREATOR = new Parcelable.Creator<CityItem>() {
        @Override
        public CityItem createFromParcel(Parcel source) {
            return new CityItem(source);
        }

        @Override
        public CityItem[] newArray(int size) {
            return new CityItem[size];
        }
    };
}
