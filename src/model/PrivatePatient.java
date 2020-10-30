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
}