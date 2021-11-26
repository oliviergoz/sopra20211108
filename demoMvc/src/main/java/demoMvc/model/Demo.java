package demoMvc.model;

public class Demo {
	private String nom;
	private AutreClass autreClass;

	public Demo() {

	}

	public Demo(String nom) {
		this.nom = nom;
	}

	public Demo(String nom, AutreClass autreClass) {
		this.nom = nom;
		this.autreClass = autreClass;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public AutreClass getAutreClass() {
		return autreClass;
	}

	public void setAutreClass(AutreClass autreClass) {
		this.autreClass = autreClass;
	}

}
