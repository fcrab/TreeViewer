package com.crabfibber.util.treeviewer.datastruct;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * 纯粹的控件结构表示，用于传递给其他activty使用
 * Created by chenkai on 2016/4/19.
 */
public class PureNodeInfo implements Parcelable {
	private String key;

	private String parentKey;

	private String type;

	private String name;

	private List<String> childKeyList=new ArrayList<>();

	public void setKey(String key) {
		this.key = key;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setParentKey(String parentKey) {
		this.parentKey = parentKey;
	}

	public void setChildKeyList(List<String> childKeyList) {
		this.childKeyList = childKeyList;
	}

	public String getKey() {
		return key;
	}

	public String getParentKey() {
		return parentKey;
	}

	public List<String> getChildKeyList() {
		return childKeyList;
	}

	public PureNodeInfo(){}

	protected PureNodeInfo(Parcel in) {
		key = in.readString();
		type=in.readString();
		name=in.readString();
		parentKey = in.readString();
		childKeyList = in.createStringArrayList();
	}

	public static final Creator<PureNodeInfo> CREATOR = new Creator<PureNodeInfo>() {
		@Override
		public PureNodeInfo createFromParcel(Parcel in) {
			return new PureNodeInfo(in);
		}

		@Override
		public PureNodeInfo[] newArray(int size) {
			return new PureNodeInfo[size];
		}
	};

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(key);
		dest.writeString(type);
		dest.writeString(name);
		dest.writeString(parentKey);
		dest.writeStringList(childKeyList);
	}
}
