package model;

public class VaccinationCenter{

	//Attribute

	public final static int PATIENT = 299;

	//Relation

	private Patient[] patient;

	public VaccinationCenter(){

		patient = new Patient[PATIENT];
	}

	public boolean createPatient(String name, String lastName, int age, String id, String numContactPatient, String nameDoc, String numDoc, String numLicence){

		boolean verific = false;

		for(int i = 0; i<patient.length && !verific; i++){
			if(patient[i] == null){
				patient[i] = new PrivatePatient(name,lastName,age,id,numContactPatient,nameDoc,numDoc,numLicence);
				verific = true;
			}
		}

		return verific;
	}

	public boolean createPatient(String name, String lastName, int age, String id, String eps, String numService){

		boolean verific = false;

		for(int i = 0; i<patient.length && !verific; i++){
			if(patient[i] == null){
				patient[i] = new EPSPatient(name,lastName,age,id,eps,numService);
				verific = true;
			}
		}

		return verific;
	}

	public boolean createPatient(String name, String lastName, int age, String id, int category){

		boolean verific = false;

		for(int i = 0; i<patient.length && !verific; i++){
			if(patient[i] == null){
				patient[i] = new Patient(name,lastName,age,id,organization,category);
				verific = true;
			}
		}

		return verific;
	}

	public boolean createPatient(String name, String lastName, int age, String id, String minPolicy, String maxPolicy){

		boolean verific = false;

		for(int i = 0; i<patient.length && !verific; i++){
			if(patient[i] == null){
				patient[i] = new Patient(name,lastName,age,id,minPolicy,maxPolicy);
				verific = true;
			}
		}

		return verific;
	}

	public boolean createPatient(String name, String lastName, int age, String id,String nomOrganization, String phone){

		boolean verific = false;

		for(int i = 0; i<patient.length && !verific; i++){
			if(patient[i] == null){
				patient[i] = new Patient(name,lastName,age,id,organization,category);
				verific = true;
			}
		}

		return verific;
	}

	public boolean findPatient(String name, String lastName){

		boolean verific = false;

		for(int i = 0; i<patient.length && !verific; i++){

			if(patient[i] != null && name.equalsIgnoreCase(patient[i].getName()) && lastName.equalsIgnoreCase(patient[i].getLasName())){
				verific = true;
			} 
		}

		return verific;
	}
}