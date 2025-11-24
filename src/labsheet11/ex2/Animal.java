package labsheet11.ex2;

//Animal.java
/*A simple instantiable class definition for an animal which also demonstrates
the OO concept of composition*/

import java.util.Arrays;

public class Animal {

	//true encapsulation ensured as all 4 attributes are private

	private String type;
	private String[] continents; //a nested object within the Animal class
	private double weight;
	private int age;

	//the no-arg constructor indirectly accessing the 4 attributes via 4-arg constructor

	public Animal() {
		this("No type specified",null,0.0,0);
	}

	//the 4-arg constructor indirectly accessing the 4 attributes via mutators
	public Animal(String type, String[] continents, double weight, int age) {
		setType(type);
		setContinents(continents);
		setWeight(weight);
		setAge(age);
	}

	//the 4 accessor methods

	public String getType() {
		return type;
	}

	public String[] getContinents() {
		//return continents; //potential breaking of encapsulation
		return Arrays.copyOf(continents,continents.length);
	}

	public double getWeight() {
		return this.weight;
	}

	public int getAge() {
		return age;
	}


	//the 4 mutator methods

	public void setType (String type) {
		this.type = type;
	}

	public void setContinents (String[] continents) {
		//this.continents = continents; //potential breaking of encapsulation
		if(continents != null)
			this.continents = Arrays.copyOf(continents,continents.length);
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setAge(int age) {
		this.age = age;
	}

	//displaying the state of the objects attributes indirectly via the accessors

	public String toString() {
		String str = "Animal Type: " + getType() + "\nAnimal Weight: " + getWeight() +
				"\nAnimal Age: " + getAge() + "\nAnimal Continents: ";

		if(continents==null) { //i.e. no array object exists=>no continents either

			str += "No continents specified";
			return str;
		}

		/*if we get to here then there must have been an array object created
		so traverse it using a loop and "join" its contents to the existing
		  string object*/

		for(int i = 0;i < getContinents().length; i++)
			str += continents[i] + " ";

		return str;
	}
}