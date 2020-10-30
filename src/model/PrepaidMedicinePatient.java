package model;

public class abstract PrepaidMedicinePatient extends Patient{

	//Attribute

	private String numAffiliation;
	
	//Methods

	public PrepaidMedicinePatient(String name, String lastName, int age, String id, String numAffiliation){

		super(name,lastName,age,id);
		this.numAffiliation = numAffiliation;
	}

	public String getNumAffiliation(){
		return numAffiliation;
	}

	public void setNumAffiliation(String numAffiliation){
		this.numAffiliation = numAffiliation;
	}
}