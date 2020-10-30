package model;

public class PrepaidMedicinePatient extends Patient{

	//Attribute

	private String category;
	private String numAffiliation;
	private String minPolicy;
	private String maxPolicy;
	private String nomOrganization;
	private String phone;

	//Methods

	public PrepaidMedicinePatient(String name, String lastName, int age, String id){

		super(name,lastName,age,id);
	}
}