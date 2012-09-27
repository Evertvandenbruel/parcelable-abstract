package com.example.parcelable_example.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Cat extends Animal{
	
	public Cat(String name){
		super(name, "Cat");
	}
	
	public int describeContents() {
		return this.hashCode();
	}

	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(getType());
		super.writeToParcel(dest, flags);
	}

	public Cat(Parcel source) {
		super(source);		
	}
	
	public static final Parcelable.Creator<Cat> CREATOR = new Parcelable.Creator<Cat>() {
		public Cat createFromParcel(Parcel in) {
			return new Cat(in);
		}

		public Cat[] newArray(int size) {
			return new Cat[size];
		}
	};
	
}
