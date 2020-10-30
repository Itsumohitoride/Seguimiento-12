package ui;

import model.*;
import java.util.*;

public class Main{

	//Attribute

	private VaccinationCenter center;
	public final static String YES = "si";
	public final static String NO = "no";

	//Global variable;

	public Scanner lector;

	public Main(){

		lector = new Scanner(System.in);
		createCenter();
	}

	public static void main(String[] args){

		Main objMain = new Main();
		int option = 0;

		do{
			option = objMain.menu();
		}while(option != 0);
	}

	public int menu(){

		int option;

		System.out.println("**********************************************");
		System.out.println("*                    MENU                    *");
		System.out.println("**********************************************");
		System.out.println("* Que desea hacer?:                          *");
		System.out.println("* (1) Registrar un paciente                  *");
		System.out.println("* (2) Mostrar los pacientes que se atienden  *");
		System.out.println("* (3) buscar informacion de un paciente      *");
		System.out.println("* (4) Mostrar toda la informacion del centro *");
		System.out.println("* (0) Salir                                  *");
		System.out.println("**********************************************");
		option = lector.nextInt();lector.nextLine();

		switch(option){
			case 0:
			System.out.println("***********************************************************************");
			System.out.println("*                Gracias por utilizar nuestro software                *");
			System.out.println("***********************************************************************");
			break;
			case 1:
			if(mcs.getUsers()[VaccinationCenter.PATIENT-1] != null){
				System.out.println("***********************************************************************");
				System.out.println("*             Ya se registro el numero maximo de pacientes            *");
				System.out.println("***********************************************************************");
			}
			else{
				createPatient();
			}
			break;
			case 2:
			showInformation();
			break;
			case 3:
			searchPatient();
			break;
			case 4:
			fullInformation();
			break;
			default:
			System.out.println("**********************************************************************");
			System.out.println("*                  Opcion invalida, digite de nuevo                  *");
			System.out.println("**********************************************************************");
			break;
		}
		return option;
	}

	public void createCenter(){

		System.out.println("**********************************************************************");
		System.out.println("*                             BIENVENIDO                             *");
		System.out.println("**********************************************************************");

		center = new VaccinationCenter();
	}

	public void registerPatient(){

		String verific, name, lastName, id, numContactPatient, nameDoc, numLicense, eps, numService;
		int age, typePatient, category;
		boolean find = true;
		boolean cont; 

		do{
			System.out.println("**********************************************************************");
			System.out.println("                         REGISTRO DE PACIENTE                         ");
			System.out.println("**********************************************************************\n");

			do{
				cont = true;
				System.out.println("Ingrese el/los nombre del paciente");
				name = lector.nextLine();

				System.out.println("Ingrese el/los apellidos del paciente");
				lastName = lector.nextLine();

				find = mcs.findPatient(name,lastName);

				if(find){
					System.out.println("El paciente ya se encuentra registrado, ingrese otro");
				}
			}while(find);

			System.out.println("Ingrese la edad del usuario");
			age = lector.nextInt();lector.nextLine();

			System.out.println("Ingrese el numero del documento de identidad del paciente");
			id = lector.nextLine();	

			System.out.println("******************************");
			System.out.println("*  Que tipo de paciente es?  *");
			System.out.println("******************************");
			System.out.println("* (1) particular             *");
			System.out.println("* (2) Por EPS                *");
			System.out.println("* (3) Por medicina prepagada *");
			System.out.println("******************************");

			

			do{

				typePatient = lector.nextInt();lector.nextLine();

				switch(typePatient){
					case 1:

					System.out.println("Ingrese el telefono del paciente");
					numContactPatient = lector.nextLine();

					System.out.println("Ingrese el nombre del medico tratante del paciente");
					nameDoc = lector.nextLine();

					System.out.println("Ingrese el telefono del medico tratante del paciente");
					numDoc = lector.nextLine();

					System.out.println("Ingrese el numero de licencia del medico tratante del paciente");
					numLicense = lector.nextLine();

					center.createPatient(name,lastName,age,id,numContactPatient,nameDoc,numDoc,numLicense);

					break;
					case 2:

					System.out.println("Ingrese el nombre de la EPS del paciente");
					eps = lector.nextLine();

					System.out.println("Ingrese el numero de la orden de servicio del paciente");
					numService = lector.nextLine();

					center.createPatient(name,lastName,age,id,eps,numService);

					break;
					case 3:

					System.out.println("Ingrese el numero de afiliacion del paciente");
					numAffiliation = lector.nextLine();

					System.out.println("*********************************************");
					System.out.println("*  Cual es la entidad prestadora de salud?  *");
					System.out.println("*********************************************");
					System.out.println("* (1) Coomeva                               *");
					System.out.println("* (2) SURA                                  *");
					System.out.println("* (3) Otra                                  *");
					System.out.println("*********************************************");

					do{

						option = lector.nextInt();lector.nextLine();

						switch(option){
							case 1:
							System.out.println("****************************************");
							System.out.println("*  Cual es la categoria del paciente?  *");
							System.out.println("****************************************");
							System.out.println("* (1) Platino                          *");
							System.out.println("* (2) Oro                              *");
							System.out.println("* (3) Oro plus                         *");
							System.out.println("****************************************");

							do{
								category = lector.nextInt();

								if(category != 1 && category != 2 && category != 3){
									System.out.println("**********************************************************************");
									System.out.println("*                  Opcion invalida, digite de nuevo                  *");
									System.out.println("**********************************************************************");
								}
								else{
									center.createPatient(name,lastName,age,id,numAffiliation,category);
								}
							}while(category != 1 && category != 2 && category != 3);

							break;
							case 2:

							System.out.println("Ingrese el valor minimo que cubre la poliza del paciente");
							minPolicy = lector.nextLine();

							System.out.println("Ingrese el valor maximo que cubre la poliza del paciente");
							maxPolicy = lector.nextLine();

							center.createPatient(name,lastName,age,id,numAffiliation,minPolicy,maxPolicy);

							break;
							case 3:

							System.out.println("Ingrese el nombre de la entidad de salud del paciente");
							nomOrganization = lector.nextLine();

							System.out.println("Ingrese un telefono para confirmar el servicio que se le presta al paciente");
							phone = lector.nextLine();

							center.createPatient(name,lastName,age,id,numAffiliation,nomOrganization,phone);

							break;
							default:
							System.out.println("**********************************************************************");
							System.out.println("*                  Opcion invalida, digite de nuevo                  *");
							System.out.println("**********************************************************************");
							break;
						}
					}while(option != 1 && option != 2 && option != 3);

					break;
					default:
					System.out.println("**********************************************************************");
					System.out.println("*                  Opcion invalida, digite de nuevo                  *");
					System.out.println("**********************************************************************");
					break;
				}
			}while(typePatient != 1 && typePatient != 2 && typePatient != 3);


			if(mcs.getUsers()[VaccinationCenter.N_USERS-1] != null){
				System.out.println("**********************************************************************");
				System.out.println("           Este es el ultimo usuario que se puede registrar           ");
				System.out.println("**********************************************************************");
				verific = NO;
			}
			else{
				System.out.println("Desea ingresar otro paciente? (Si/No)");
				verific = lector.nextLine();
			}

			center.createPatient(name,lastName,age,id);
		}while(verific.equalsIgnoreCase(YES));
	}

	public void showInformation(){

		String message = "";

		System.out.println("**********************************************************************");
		System.out.println("*                  INFORMACION DE LOS PACIENTES                      *");
		System.out.println("**********************************************************************");
		
		message = center.showInformation();

		System.out.println(message);
	}

	public void searchPatient(){

		String id = "";
		String message = "";

		System.out.println("Ingrese el documento de identidad del paciente que desea buscar");
		id = lector.nextLine();

		verific = center.findPatient(id);

		if(!verific){
			System.out.println("Este paciente no existe en la base de datos");
		}
		else{
			message = center.showInformation(id);
		}
	}

	public void fullInformation(){

		String message = "";
		String messagePatient = "";

		System.out.println("**********************************************************************");
		System.out.println("*                 TODA LA INFORMACION DEL CENTRO                     *");
		System.out.println("**********************************************************************");
		
		message = center.showInformation();

		System.out.println(message);

		messagePatient = center.showAllPatient();
	}
}