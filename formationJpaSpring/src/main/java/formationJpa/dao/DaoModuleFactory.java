package formationJpa.dao;

public class DaoModuleFactory {
	private static DaoModule daoModule = null;

	public static DaoModule getInstance() {
		if (daoModule == null) {
			daoModule = new DaoModuleJpaImpl();
		}
		return daoModule;
	}
}
