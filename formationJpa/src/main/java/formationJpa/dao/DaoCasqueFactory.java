package formationJpa.dao;

public class DaoCasqueFactory {
	private static DaoCasque daoCasque = null;

	public static DaoCasque getInstance() {
		if (daoCasque == null) {
			daoCasque = new DaoCasqueJpaImpl();
		}
		return daoCasque;
	}
}
