package formation.sopra.formationSpringBoot.entities;

public enum Civilite {
	M("monsieur"), MME("madame"), MLLE("mademoiselle");

	private String texte;

	private Civilite(String texte) {
		this.texte = texte;
	}

	public String getTexte() {
		return texte;
	}
}
