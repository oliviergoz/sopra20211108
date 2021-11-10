package formationJpa.entity;

public enum Ram {
	RAM8("8Go"), RAM16("16Go");

	private String libelle;

	private Ram(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}
}
