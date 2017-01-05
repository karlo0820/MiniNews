package com.jiale.mininews.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Karlo on 2016/12/13.
 */

public class ChannelBean implements Parcelable {
    private String ChannelId;
    private int index;
    private String name;
    private Boolean select;

    public ChannelBean() {
    }

    public ChannelBean(String channelId, int index, String name, Boolean select) {
        ChannelId = channelId;
        this.index = index;
        this.name = name;
        this.select = select;
    }

    protected ChannelBean(Parcel in) {
        ChannelId = in.readString();
        index = in.readInt();
        name = in.readString();
        select = in.readByte() != 0;
    }

    public static final Creator<ChannelBean> CREATOR = new Creator<ChannelBean>() {
        @Override
        public ChannelBean createFromParcel(Parcel in) {
            return new ChannelBean(in);
        }

        @Override
        public ChannelBean[] newArray(int size) {
            return new ChannelBean[size];
        }
    };

    public String getChannelId() {
        return ChannelId;
    }

    public void setChannelId(String channelId) {
        ChannelId = channelId;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSelect() {
        return select;
    }

    public void setSelect(Boolean select) {
        this.select = select;
    }

    @Override
    public String toString() {
        return "ChannelBean{" +
                "ChannelId='" + ChannelId + '\'' +
                ", index='" + index + '\'' +
                ", name='" + name + '\'' +
                ", select=" + select +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ChannelId);
        dest.writeInt(index);
        dest.writeString(name);
        dest.writeByte((byte) (select ? 1 : 0));
    }
}
