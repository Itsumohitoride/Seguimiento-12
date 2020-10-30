package model;

public class CoomevaPatient extends PrepaidMedicinePatient{

	//Attribute

	private Category category;

	public CoomevaPatient(String name, String lastName, int age, String id, String numAffiliation, int category){

		super(name,lastName,age,id,numAffiliation);
		switch(category){
			case 1:
			this.category = Category.PLATINUM;
			break;
			case 2:
			this.category = Category.GOLD;
			break;
			case 3:
			this.category = Category.GOLD_PLUS;
			break;
		}
	}

	public String getCategory(){
		return category;
	}

	public void setCategory(){
		this.category = category;
	}
}