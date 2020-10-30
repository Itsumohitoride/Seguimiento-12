package modedl;

public class SURAPatient extends PrepaidMedicinePatient{

	//Attribute

	private String minPolicy;
	private String maxPolicy;

	//Methods

	public SURAPatient(String name, String lastName, int age, String id, String numAffiliation, String minPolicy, String maxPolicy){

		super(name,lastName,age,id);
		this.minPolicy = minPolicy;
		this.maxPolicy = maxPolicy;
	}

	public String getMinPolicy(){
		return minPolicy;
	}

	public void setMinPolicy(String minPolicy){
		this.minPolicy = minPolicy;
	}

	public String getMaxPolicy(){
		return maxPolicy;
	}

	public void setMaxPolicy(String maxPolicy){
		this.maxPolicy = maxPolicy;
	}
}