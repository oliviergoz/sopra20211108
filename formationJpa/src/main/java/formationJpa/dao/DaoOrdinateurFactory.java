package formationJpa.dao;

public class DaoOrdinateurFactory {
	private static DaoOrdinateur daoOrdinateur = null;

	public static DaoOrdinateur getInstance() {
		if (daoOrdinateur == null) {
			daoOrdinateur = new DaoOrdinateurJpaImpl();
		}
		return daoOrdinateur;
	}
}
