package model;

public class EPSPatient extends Patient{

	//Attribute

	private String eps;
	private String numService;

	public EPSPatient(String name, String lastName, int age, String id, String eps, String numService){
		super(name,lastName,age,id);
		this.eps = eps;
		this.numService = numService;
	}

	public String getEps(){
		return eps;
	}

	public void setEps(String eps){
		this.eps = eps;
	}

	public String getNumService(){
		return numService;
	}

	public void setNumService(String numService){
		this.numService = numService;
	}
}