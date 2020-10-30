package model;

public class abstract Patient{

	//Attribute

	private String name;
	private String lastName;
	private int age;
	private String id;

	//Methods

	public Patient(String name, String lastName, int age, String id){

		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.id = id;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getLastName(){
		return lastName;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public int getAge(){
		return age;
	}

	public void setAge(int age){
		this.age = age;
	}

	public String getId(){
		return name;
	}

	public void setId(String id){
		this.id = id;
	}
}