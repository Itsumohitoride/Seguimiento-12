package model;

public class VaccinationCenter{

	//Attribute

	public final static int PATIENT = 300;

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

	public boolean createPatient(String name, String lastName, int age, String id, String numAffiliation, int minPolicy, int maxPolicy){

		boolean verific = false;

		for(int i = 0; i<patient.length && !verific; i++){
			if(patient[i] == null){
				patient[i] = new SURAPatient(name,lastName,age,id,numAffiliation,minPolicy,maxPolicy);
				verific = true;
			}
		}

		return verific;
	}

	public boolean createPatient(String name, String lastName, int age, String id, String numAffiliation, String nomOrganization, int phone){

		boolean verific = false;

		for(int i = 0; i<patient.length && !verific; i++){
			if(patient[i] == null){
				patient[i] = new OtherPatient(name,lastName,age,id,numAffiliation,nomOrganization,phone);
				verific = true;
			}
		}

		return verific;
	}

	public Patient[] getPatient(){
		return patient;
	}

	public void setPatient(Patient[] patient){
		this.patient = patient;
	}

	public boolean findPatient(String name, String lastName){

		boolean verific = false;

		for(int i = 0; i<patient.length && !verific; i++){

			if(patient[i] != null && name.equalsIgnoreCase(patient[i].getName()) && lastName.equalsIgnoreCase(patient[i].getLastName())){
				verific = true;
			} 
		}

		return verific;
	}

	public boolean findPatient(String id){

		boolean verific = false;

		for(int i = 0; i<patient.length && !verific; i++){

			if(patient[i] != null && patient[i].getId().equalsIgnoreCase(id)){
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

		PrivatePatient objPrivate;

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

		PrivatePatient objPrivate;
		EPSPatient objEPS;
		CoomevaPatient objCoomeva;
		SURAPatient objSURA;
		OtherPatient objOther;

		for(int i = 0; i<patient.length && !verific; i++){		

			if(patient[i] != null && patient[i] instanceof PrivatePatient && id.equalsIgnoreCase(patient[i].getId())){

				objPrivate = (PrivatePatient) patient[i];

				message = "\n****************** informacion del paciente ******************\n"+
							"** Nombre: "+patient[i].getName()+"\n"+
							"** Apellido: "+patient[i].getLastName()+"\n"+
							"** Telefono de contacto: "+objPrivate.getNumContactPatient()+"\n"+
							"** Edad: "+patient[i].getAge()+"\n"+
							"** Documento: "+patient[i].getId()+"\n"+
							"** Medico tratante: "+objPrivate.getNameDoc()+"\n"+
							"**      - Telefono: "+objPrivate.getNumDoc()+"\n"+
							"**      - Numero de licencia: "+objPrivate.getNumLicense()+"\n"+
		           			"**************************************************************\n";
		        verific = true;
			}
			else if(patient[i] != null && patient[i] instanceof EPSPatient && id.equalsIgnoreCase(patient[i].getId())){

				objEPS = (EPSPatient) patient[i];

				message = "\n****************** informacion del paciente ******************\n"+
							"** Nombre: "+patient[i].getName()+"\n"+
							"** Apellido: "+patient[i].getLastName()+"\n"+
							"** Edad: "+patient[i].getAge()+"\n"+
							"** Documento: "+patient[i].getId()+"\n"+
							"** Nombre de la EPS: "+objEPS.getEps()+"\n"+
							"** Numero de orden de servicio: "+objEPS.getNumService()+"\n"+
		           			"**************************************************************";
		        verific = true;
			}
			else if(patient[i] != null && patient[i] instanceof CoomevaPatient && id.equalsIgnoreCase(patient[i].getId())){

				objCoomeva = (CoomevaPatient) patient[i];

				message = "\n****************** informacion del paciente ******************\n"+
							"** Nombre: "+patient[i].getName()+"\n"+
							"** Apellido: "+patient[i].getLastName()+"\n"+
							"** Numero de afiliacion: "+objCoomeva.getNumAffiliation()+"\n"+
							"** Edad: "+patient[i].getAge()+"\n"+
							"** Documento: "+patient[i].getId()+"\n"+
							"** Categoria: "+objCoomeva.getCategory()+"\n"+
		           			"**************************************************************";

				verific = true;
			}
			else if(patient[i] != null && patient[i] instanceof SURAPatient && id.equalsIgnoreCase(patient[i].getId())){

				objSURA = (SURAPatient) patient[i];

				message = "\n****************** informacion del paciente ******************\n"+
							"** Nombre: "+patient[i].getName()+"\n"+
							"** Apellido: "+patient[i].getLastName()+"\n"+
							"** Numero de afiliacion: "+objSURA.getNumAffiliation()+"\n"+
							"** Edad: "+patient[i].getAge()+"\n"+
							"** Documento: "+patient[i].getId()+"\n"+
							"** Minimo que cubre la poliza: "+objSURA.getMinPolicy()+"\n"+
							"** Maximo que cubre la poliza: "+objSURA.getMaxPolicy()+"\n"+
		           			"**************************************************************";

				verific = true;
			}
			else if(patient[i] != null && patient[i] instanceof OtherPatient && id.equalsIgnoreCase(patient[i].getId())){

				objOther = (OtherPatient) patient[i];

				message = "\n****************** informacion del paciente ******************\n"+
							"** Nombre: "+patient[i].getName()+"\n"+
							"** Apellido: "+patient[i].getLastName()+"\n"+
							"** Numero de afiliacion: "+objOther.getNumAffiliation()+"\n"+
							"** Edad: "+patient[i].getAge()+"\n"+
							"** Documento: "+patient[i].getId()+"\n"+ 
							"** Nombre de la organizacion: "+objOther.getNomOrganization()+"\n"+
							"** Telefono de la organizacion: "+objOther.getPhone()+"\n"+
		           			"**************************************************************";

				verific = true;
			}
		}
		return message;
	}

	public String showAllPatient(){

		String message = "";

		PrivatePatient objPrivate;
		EPSPatient objEPS;
		CoomevaPatient objCoomeva;
		SURAPatient objSURA;
		OtherPatient objOther;

		for(int i = 0; i<patient.length; i++){

			if(patient[i] != null && patient[i] instanceof PrivatePatient){

				objPrivate = (PrivatePatient) patient[i];

				message += "\n****************** informacion del paciente ******************\n"+
							"** Nombre: "+patient[i].getName()+"\n"+
							"** Apellido: "+patient[i].getLastName()+"\n"+
							"** Telefono de contacto: "+objPrivate.getNumContactPatient()+"\n"+
							"** Edad: "+patient[i].getAge()+"\n"+
							"** Documento: "+patient[i].getId()+"\n"+
							"** Medico tratante: "+objPrivate.getNameDoc()+"\n"+
							"**      - Telefono: "+objPrivate.getNumDoc()+"\n"+
							"**      - Numero de licencia: "+objPrivate.getNumLicense()+"\n"+
		           			"**************************************************************\n";
			}
			else if(patient[i] != null && patient[i] instanceof EPSPatient){

				objEPS = (EPSPatient) patient[i];

				message += "\n****************** informacion del paciente ******************\n"+
							"** Nombre: "+patient[i].getName()+"\n"+
							"** Apellido: "+patient[i].getLastName()+"\n"+
							"** Edad: "+patient[i].getAge()+"\n"+
							"** Documento: "+patient[i].getId()+"\n"+
							"** Nombre de la EPS: "+objEPS.getEps()+"\n"+
							"** Numero de orden de servicio: "+objEPS.getNumService()+"\n"+
		           			"**************************************************************\n";
			}
			else if(patient[i] != null && patient[i] instanceof CoomevaPatient){

				objCoomeva = (CoomevaPatient) patient[i];

				message += "\n****************** informacion del paciente ******************\n"+
							"** Nombre: "+patient[i].getName()+"\n"+
							"** Apellido: "+patient[i].getLastName()+"\n"+
							"** Numero de afiliacion: "+objCoomeva.getNumAffiliation()+"\n"+
							"** Edad: "+patient[i].getAge()+"\n"+
							"** Documento: "+patient[i].getId()+"\n"+
							"** Categoría: "+objCoomeva.getCategory()+"\n"+
		           			"**************************************************************";
			}
			else if(patient[i] != null && patient[i] instanceof SURAPatient){

				objSURA = (SURAPatient) patient[i];

				message += "\n****************** informacion del paciente ******************\n"+
							"** Nombre: "+patient[i].getName()+"\n"+
							"** Apellido: "+patient[i].getLastName()+"\n"+
							"** Numero de afiliacion: "+objSURA.getNumAffiliation()+"\n"+
							"** Edad: "+patient[i].getAge()+"\n"+
							"** Documento: "+patient[i].getId()+"\n"+
							"** Minimo que cubre la poliza: "+objSURA.getMinPolicy()+"\n"+
							"** Maximo que cubre la poliza: "+objSURA.getMaxPolicy()+"\n"+
		           			"**************************************************************";
			}
			else if(patient[i] != null && patient[i] instanceof OtherPatient){

				objOther = (OtherPatient) patient[i];

				message += "\n****************** informacion del paciente ******************\n"+
							"** Nombre: "+patient[i].getName()+"\n"+
							"** Apellido: "+patient[i].getLastName()+"\n"+
							"** Numero de afiliacion: "+objOther.getNumAffiliation()+"\n"+
							"** Edad: "+patient[i].getAge()+"\n"+
							"** Documento: "+patient[i].getId()+"\n"+ 
							"** Nombre de la organizacion: "+objOther.getNomOrganization()+"\n"+
							"** Telefono de la organizacion: "+objOther.getPhone()+"\n"+
		           			"**************************************************************";
			}
		}
		return message;
	}
}