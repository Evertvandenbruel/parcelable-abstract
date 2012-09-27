package com.example.parcelable_example.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Dog extends Animal{

	private int age;
	
	public Dog(String name, int age){
		super(name, "Dog");
		this.age = age;
	}
	
	public int describeContents() {
		return this.hashCode();
	}

	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(getType());
		super.writeToParcel(dest, flags);
		dest.writeInt(getAge());
	}

	public Dog(Parcel source) {
		super(source);		
		this.age = source.readInt();
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static final Parcelable.Creator<Dog> CREATOR = new Parcelable.Creator<Dog>() {
		public Dog createFromParcel(Parcel in) {
			return new Dog(in);
		}

		public Dog[] newArray(int size) {
			return new Dog[size];
		}
	};
	
}
