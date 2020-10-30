package model;

public class OtherPatient extends PrepaidMedicinePatient{

	//Attribute

	private String nomOrganization;
	private int phone;

	public OtherPatient(String name, String lastName, int age, String id, String numAffiliation, String nomOrganization, int phone){

		super(name,lastName,age,id,numAffiliation);
		this.nomOrganization = nomOrganization;
		this.phone = phone;
	}

	public String getNomOrganization(){
		return nomOrganization;
	}

	public void setNomOrganization(String nomOrganization){
		this.nomOrganization = nomOrganization;
	}

	public int getPhone(){
		return phone;
	}

	public void setPhone(int phone){
		this.phone = phone;
	}
}