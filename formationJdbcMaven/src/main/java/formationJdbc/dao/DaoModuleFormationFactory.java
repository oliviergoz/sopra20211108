package formationJdbc.dao;

public class DaoModuleFormationFactory {
	private static DaoModuleFormation daoModuleFormation = null;

	public static DaoModuleFormation getInstance() {
		if (daoModuleFormation == null) {
			daoModuleFormation = new DaoModuleFormationJdbcImpl();
		}
		return daoModuleFormation;
	}

}
