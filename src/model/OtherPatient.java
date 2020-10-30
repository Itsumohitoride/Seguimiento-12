package model;

public class OtherPatient extends PrepaidMedicinePatient{

	//Attribute

	private String nomOrganization;
	private String phone;

	public OtherPatient(String name, String lastName, int age, String id, String numAffiliation, String nomOrganization, String phone){

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

	public String getPhone(){
		return phone;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}
}