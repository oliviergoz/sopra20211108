package formationJpa.dao;

public class DaoModuleFormationFactory {
	private static DaoModuleFormation daoModuleFormation = null;

	public static DaoModuleFormation getInstance() {
		if (daoModuleFormation == null) {
			daoModuleFormation = new DaoModuleFormationJpaImpl();
		}
		return daoModuleFormation;
	}
}
