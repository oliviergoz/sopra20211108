package formationJdbc.dao;

public class DaoFormateurFactory {
	private static DaoFormateur daoFormateur = null;

	public static DaoFormateur getInstance() {
		if (daoFormateur == null) {
			daoFormateur = new DaoFormateurJdbcImpl();
		}
		return daoFormateur;
	}
}
