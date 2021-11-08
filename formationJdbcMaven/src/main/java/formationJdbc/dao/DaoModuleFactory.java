package formationJdbc.dao;

public class DaoModuleFactory {

	private static DaoModule daoModule = null;

	public static DaoModule getInstance() {
		if (daoModule == null) {
			daoModule = new DaoModuleJdbcImpl();
		}
		return daoModule;
	}
}
