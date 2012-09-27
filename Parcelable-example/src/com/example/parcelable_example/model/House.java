package com.example.parcelable_example.model;

import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;

public class House implements Parcelable{

	private String name;
	private ArrayList<Animal> animals;
	
	public House(String name) {
		super();
		this.animals = new ArrayList<Animal>();
		this.name = name;
	}

	public int describeContents() {
		return this.hashCode();
	}

	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(getName());
		dest.writeTypedList(getAnimals());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(ArrayList<Animal> animals) {
		this.animals = animals;
	}

	protected House(Parcel in) {
    	super();
		this.name = in.readString();

		this.setAnimals(new ArrayList<Animal>());
		in.readTypedList(getAnimals(), Animal.CREATOR);		
    }
	
	public static final Parcelable.Creator<House> CREATOR = new Parcelable.Creator<House>() {
		public House createFromParcel(Parcel in) {
			return new House(in);
		}

		public House[] newArray(int size) {
			return new House[size];
		}
	};
	
}
