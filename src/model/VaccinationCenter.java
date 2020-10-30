package model;

public class VaccinationCenter{

	//Attribute

	public final static int PATIENT = 299;

	//Relation

	private Patient[] patient;

	public VaccinationCenter(){

		patient = new Patient[PATIENT];
	}

	public boolean createPatient(String name, String lastName, int age, String id, String numContactPatient, String nameDoc, String numDoc, String numLicense){

		boolean verific = false;

		for(int i = 0; i<patient.length && !verific; i++){
			if(patient[i] == null){
				patient[i] = new PrivatePatient(name,lastName,age,id,numContactPatient,nameDoc,numDoc,numLicense);
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

	public boolean createPatient(String name, String lastName, int age, String id, String numAffiliation,int category){

		boolean verific = false;

		for(int i = 0; i<patient.length && !verific; i++){
			if(patient[i] == null){
				patient[i] = new CoomevaPatient(name,lastName,age,id,numAffiliation,category);
				verific = true;
			}
		}

		return verific;
	}

	public boolean createPatient(String name, String lastName, int age, String id, String numAffiliation, String minPolicy, String maxPolicy){

		boolean verific = false;

		for(int i = 0; i<patient.length && !verific; i++){
			if(patient[i] == null){
				patient[i] = new SURAPatient(name,lastName,age,id,numAffiliation,minPolicy,maxPolicy);
				verific = true;
			}
		}

		return verific;
	}

	public boolean createPatient(String name, String lastName, int age, String id, String numAffiliation, String nomOrganization, String phone){

		boolean verific = false;

		for(int i = 0; i<patient.length && !verific; i++){
			if(patient[i] == null){
				patient[i] = new OtherPatient(name,lastName,age,id,numAffiliation,nomOrganization,phone);
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

	public boolean findPatient(String id){

		boolean verific = false;

		for(int i = 0; i<patient.length && !verific; i++){

			if(patient[i] != null && id.equalsIgnoreCase(patient[i].getId())){
				verific = true;
			} 
		}

		return verific;
	}

	public String showInformation(){

		String message = "";

		int privatePatient = 0;
		int epsPatient = 0;
		int coomevaPatient = 0;
		int suraPatient = 0;
		int otherPatient = 0;

		for(int i = 0; i<patient.length; i++){

			if(patient[i] != null && patient[i] instanceof PrivatePatient){
				privatePatient++;
			}
			if(patient[i] != null && patient[i] instanceof EPSPatient){
				epsPatient++;
			}
			if(patient[i] != null && patient[i] instanceof CoomevaPatient){
				coomevaPatient++;
			}
			if(patient[i] != null && patient[i] instanceof SURAPatient){
				suraPatient++;
			}
			if(patient[i] != null && patient[i] instanceof OtherPatient){
				otherPatient++;
			}
		}

		message += "\n********** Pacientes que el centro de vacunacion antiende **********\n"+
					"** Total: "+(privatePatient+epsPatient+coomevaPatient+suraPatient+otherPatient)+"\n"+
					"** Pacientes particulares: "+(privatePatient)+"\n"+
					"** Pacientes de EPS: "+(epsPatient)+"\n"+
					"** Pacientes de medicina prepagada: "+(coomevaPatient+suraPatient+otherPatient)+"\n"+
					"**      - Pacientes de Coomeva: "+(coomevaPatient)+"\n"+
					"**      - Pacientes de SURA: "+(suraPatient)+"\n"+
					"**      - Pacientes de otras entidades: "+(otherPatient)+"\n"+
		           "************************************************************************";

		return message;
	}

	public String showInformation(String id){

		String message = "";
		boolean verific = false;


		for(int i = 0; i<patient.length && !verific; i++){

			if(patient[i] != null && patient[i] instanceof PrivatePatient){
				message = "\n****************** informacion del paciente ******************\n"+
							"** Nombre: "+patient[i].getName()+"\n"+
							"** Apellido: "+patient[i].getLasName()+"\n"+
							"** Telefono de contacto: "+patient[i].getNumContactPatient()+"\n"+
							"** Edad: "+patient[i].getAge()+"\n"+
							"** Documento: "+patient[i].getId()+"\n"+
							"** Medico tratante: "+patient[i].getNameDoc()+"\n"+
							"**      - Telefono: "+patient[i].getNumDoc()+"\n"+
							"**      - Numero de licencia: "+patient[i].getNumLicense()+"\n"+
		           			"**************************************************************";
		        verific = true;
			}
			else if(patient[i] != null && patient[i] instanceof EPSPatient){
				message = "\n****************** informacion del paciente ******************\n"+
							"** Nombre: "+patient[i].getName()+"\n"+
							"** Apellido: "+patient[i].getLasName()+"\n"+
							"** Telefono de contacto: "+patient[i].getNumContactPatient()+"\n"+
							"** Edad: "+patient[i].getAge()+"\n"+
							"** Documento: "+patient[i].getId()+"\n"+
							"** Medico tratante: "+patient[i].getNameDoc()+"\n"+
							"**      - Telefono: "+patient[i].getNumDoc()+"\n"+
							"**      - Numero de licencia: "+patient[i].getNumLicense()+"\n"+
							"** Nombre de la EPS: "+patient[i].getEps()+"\n"+
							"** Numero de orden de servicio: "+patient[i].getNumService()+"\n"+
		           			"**************************************************************";
		        verific = true;
			}
			else if(patient[i] != null && patient[i] instanceof CoomevaPatient){

				message = "\n****************** informacion del paciente ******************\n"+
							"** Nombre: "+patient[i].getName()+"\n"+
							"** Apellido: "+patient[i].getNumAffiliation()+"\n"+
							"** Numero de afiliacion: "+patient[i].getNumAffiliation()+"\n"+
							"** Telefono de contacto: "+patient[i].getNumContactPatient()+"\n"+
							"** Edad: "+patient[i].getAge()+"\n"+
							"** Documento: "+patient[i].getId()+"\n"+
							"** Medico tratante: "+patient[i].getNameDoc()+"\n"+
							"**      - Telefono: "+patient[i].getNumDoc()+"\n"+
							"**      - Numero de licencia: "+patient[i].getNumLicense()+"\n"+
							"** Categoría: "+patient[i].getCategory()+"\n"+
		           			"**************************************************************";

				verific = true;
			}
			else if(patient[i] != null && patient[i] instanceof SURAPatient){
				message = "\n****************** informacion del paciente ******************\n"+
							"** Nombre: "+patient[i].getName()+"\n"+
							"** Apellido: "+patient[i].getNumAffiliation()+"\n"+
							"** Numero de afiliacion: "+patient[i].getNumAffiliation()+"\n"+
							"** Telefono de contacto: "+patient[i].getNumContactPatient()+"\n"+
							"** Edad: "+patient[i].getAge()+"\n"+
							"** Documento: "+patient[i].getId()+"\n"+
							"** Medico tratante: "+patient[i].getNameDoc()+"\n"+
							"**      - Telefono: "+patient[i].getNumDoc()+"\n"+
							"**      - Numero de licencia: "+patient[i].getNumLicense()+"\n"+
							"** Minimo que cubre la poliza: "+patient[i].getMinPolicy()+"\n"+
							"** Maximo que cubre la poliza: "+patient[i].getMaxPolicy()+"\n"+
		           			"**************************************************************";

				verific = true;
			}
			else if(patient[i] != null && patient[i] instanceof OtherPatient){
				message = "\n****************** informacion del paciente ******************\n"+
							"** Nombre: "+patient[i].getName()+"\n"+
							"** Apellido: "+patient[i].getNumAffiliation()+"\n"+
							"** Numero de afiliacion: "+patient[i].getNumAffiliation()+"\n"+
							"** Telefono de contacto: "+patient[i].getNumContactPatient()+"\n"+
							"** Edad: "+patient[i].getAge()+"\n"+
							"** Documento: "+patient[i].getId()+"\n"+
							"** Medico tratante: "+patient[i].getNameDoc()+"\n"+
							"**      - Telefono: "+patient[i].getNumDoc()+"\n"+
							"**      - Numero de licencia: "+patient[i].getNumLicense()+"\n"+
							"** Nombre de la organizacion: "+patient[i].getNomOrganization()+"\n"+
							"** Telefono de la organizacion: "+patient[i].getPhone()+"\n"+
		           			"**************************************************************";

				verific = true;
			}
		}
		return message;
	}

	public String showInformation(){

		String message = "";

		for(int i = 0; i<patient.length; i++){

			if(patient[i] != null && patient[i] instanceof PrivatePatient){
				message += "\n****************** informacion del paciente ******************\n"+
							"** Nombre: "+patient[i].getName()+"\n"+
							"** Apellido: "+patient[i].getLasName()+"\n"+
							"** Telefono de contacto: "+patient[i].getNumContactPatient()+"\n"+
							"** Edad: "+patient[i].getAge()+"\n"+
							"** Documento: "+patient[i].getId()+"\n"+
							"** Medico tratante: "+patient[i].getNameDoc()+"\n"+
							"**      - Telefono: "+patient[i].getNumDoc()+"\n"+
							"**      - Numero de licencia: "+patient[i].getNumLicense()+"\n"+
		           			"**************************************************************";
			}
			else if(patient[i] != null && patient[i] instanceof EPSPatient){
				message += "\n****************** informacion del paciente ******************\n"+
							"** Nombre: "+patient[i].getName()+"\n"+
							"** Apellido: "+patient[i].getLasName()+"\n"+
							"** Telefono de contacto: "+patient[i].getNumContactPatient()+"\n"+
							"** Edad: "+patient[i].getAge()+"\n"+
							"** Documento: "+patient[i].getId()+"\n"+
							"** Medico tratante: "+patient[i].getNameDoc()+"\n"+
							"**      - Telefono: "+patient[i].getNumDoc()+"\n"+
							"**      - Numero de licencia: "+patient[i].getNumLicense()+"\n"+
							"** Nombre de la EPS: "+patient[i].getEps()+"\n"+
							"** Numero de orden de servicio: "+patient[i].getNumService()+"\n"+
		           			"**************************************************************";;
			}
			else if(patient[i] != null && patient[i] instanceof CoomevaPatient){

				message += "\n****************** informacion del paciente ******************\n"+
							"** Nombre: "+patient[i].getName()+"\n"+
							"** Apellido: "+patient[i].getNumAffiliation()+"\n"+
							"** Numero de afiliacion: "+patient[i].getNumAffiliation()+"\n"+
							"** Telefono de contacto: "+patient[i].getNumContactPatient()+"\n"+
							"** Edad: "+patient[i].getAge()+"\n"+
							"** Documento: "+patient[i].getId()+"\n"+
							"** Medico tratante: "+patient[i].getNameDoc()+"\n"+
							"**      - Telefono: "+patient[i].getNumDoc()+"\n"+
							"**      - Numero de licencia: "+patient[i].getNumLicense()+"\n"+
							"** Categoría: "+patient[i].getCategory()+"\n"+
		           			"**************************************************************";
			}
			else if(patient[i] != null && patient[i] instanceof SURAPatient){
				message += "\n****************** informacion del paciente ******************\n"+
							"** Nombre: "+patient[i].getName()+"\n"+
							"** Apellido: "+patient[i].getNumAffiliation()+"\n"+
							"** Numero de afiliacion: "+patient[i].getNumAffiliation()+"\n"+
							"** Telefono de contacto: "+patient[i].getNumContactPatient()+"\n"+
							"** Edad: "+patient[i].getAge()+"\n"+
							"** Documento: "+patient[i].getId()+"\n"+
							"** Medico tratante: "+patient[i].getNameDoc()+"\n"+
							"**      - Telefono: "+patient[i].getNumDoc()+"\n"+
							"**      - Numero de licencia: "+patient[i].getNumLicense()+"\n"+
							"** Minimo que cubre la poliza: "+patient[i].getMinPolicy()+"\n"+
							"** Maximo que cubre la poliza: "+patient[i].getMaxPolicy()+"\n"+
		           			"**************************************************************";
			}
			else if(patient[i] != null && patient[i] instanceof OtherPatient){
				message += "\n****************** informacion del paciente ******************\n"+
							"** Nombre: "+patient[i].getName()+"\n"+
							"** Apellido: "+patient[i].getNumAffiliation()+"\n"+
							"** Numero de afiliacion: "+patient[i].getNumAffiliation()+"\n"+
							"** Telefono de contacto: "+patient[i].getNumContactPatient()+"\n"+
							"** Edad: "+patient[i].getAge()+"\n"+
							"** Documento: "+patient[i].getId()+"\n"+
							"** Medico tratante: "+patient[i].getNameDoc()+"\n"+
							"**      - Telefono: "+patient[i].getNumDoc()+"\n"+
							"**      - Numero de licencia: "+patient[i].getNumLicense()+"\n"+
							"** Nombre de la organizacion: "+patient[i].getNomOrganization()+"\n"+
							"** Telefono de la organizacion: "+patient[i].getPhone()+"\n"+
		           			"**************************************************************";
			}
		}
		return message;
	}
}