package formationJdbc.dao;

public class DaoFormationFactory {

	private static DaoFormation daoFormation = null;

	public static DaoFormation getInstance() {
		if (daoFormation == null) {
			daoFormation = new DaoFormationJdbcImpl();
		}
		return daoFormation;
	}
}
