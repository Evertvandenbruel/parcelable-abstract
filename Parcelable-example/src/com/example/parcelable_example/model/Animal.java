package com.example.parcelable_example.model;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class Animal implements Parcelable{
	private String name;
	private String type;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Animal(String name, String type) {
		super();
		this.name = name;
		this.setType(type);
	}
	
	public static final Parcelable.Creator<Animal> CREATOR = new Parcelable.Creator<Animal>() {
		public Animal createFromParcel(Parcel in) {
			String animalType = in.readString();
			Animal animal = null;

			if(animalType.equals("Dog"))
				animal = (Animal)new Dog(in);
			
			if(animalType.equals("Cat"))
				animal = (Animal)new Cat(in);
			
			return animal;
		}

		public Animal[] newArray(int size) {
			return new Animal[size];
		}
	};
	
	public void writeToParcel(Parcel out, int flags) {
		out.writeString(getName());
    }

    protected Animal(Parcel in) {
    	super();
		this.name = in.readString();
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
