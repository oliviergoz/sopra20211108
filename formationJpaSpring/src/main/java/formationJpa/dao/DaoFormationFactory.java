package formationJpa.dao;

public class DaoFormationFactory {
	private static DaoFormation daoFormation = null;

	public static DaoFormation getInstance() {
		if (daoFormation == null) {
			daoFormation = new DaoFormationJpaImpl();
		}
		return daoFormation;
	}
}
