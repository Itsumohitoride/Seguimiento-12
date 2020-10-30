package model;

public class PrivatePatient extends Patient{

	//Attribute

	private String numContactPatient;
	private String nameDoc;
	private String numDoc;
	private String numLicense;

	//Methods

	public PrivatePatient(String name, String lastName, int age, String id, String numContactPatient, String nameDoc, String numDoc, String numLicense){

		super(name,lastName,age,id);
		this.numContactPatient = numContactPatient;
		this.nameDoc = nameDoc;
		this.numDoc = numDoc;
		this.numLicense = numLicense;
	}

	public String getNumContactPatient(){
		return numContactPatient;
	}

	public void setNumContactPatient(String numContactPatient){
		this.numContactPatient = numContactPatient;
	}

	public String getNameDoc(){
		return nameDoc;
	}

	public void setNameDoc(String nameDoc){
		this.nameDoc = nameDoc;
	}

	public String getNumDoc(){
		return numDoc;
	}

	public void setNumDoc(String numDoc){
		this.numDoc = numDoc;
	}

	public String getNumLicense(){
		return numLicense;
	}

	public void setNumLicense(String numLicense){
		this.numLicense = numLicense;
	}
}