package model;

public class SURAPatient extends PrepaidMedicinePatient{

	//Attribute

	private int minPolicy;
	private int maxPolicy;

	//Methods

	public SURAPatient(String name, String lastName, int age, String id, String numAffiliation, int minPolicy, int maxPolicy){

		super(name,lastName,age,id,numAffiliation);
		this.minPolicy = minPolicy;
		this.maxPolicy = maxPolicy;
	}

	public int getMinPolicy(){
		return minPolicy;
	}

	public void setMinPolicy(int minPolicy){
		this.minPolicy = minPolicy;
	}

	public int getMaxPolicy(){
		return maxPolicy;
	}

	public void setMaxPolicy(int maxPolicy){
		this.maxPolicy = maxPolicy;
	}
}