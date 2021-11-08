package formationJdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import formationJdbc.model.Module;
import formationJdbc.util.Context;

class DaoModuleJdbcImpl implements DaoModule {
//CreateReadUpdateDelete
	@Override
	public List<Module> findAll() {
		List<Module> modules = new ArrayList<Module>();
		Connection connection = Context.getInstance().getConnection();
		try (Statement statement = connection.createStatement();) {
			ResultSet rs = statement.executeQuery("select * from module");
			formationJdbc.model.Module module = null;
			while (rs.next()) {
				// @formatter:off
				module=new Module(rs.getInt("id"), rs.getString("nom"), rs.getString("details"), rs.getInt("duree"));
				modules.add(module);
				// @formatter:on
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Context.destroy();
		return modules;
	}

	@Override
	public Module findByKey(Integer key) {
		Connection connection = Context.getInstance().getConnection();
		Module module = null;
		try (PreparedStatement preparedStatement = connection.prepareStatement("select * from module where id=?")) {
			preparedStatement.setInt(1, key);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				module = new Module(rs.getInt("id"), rs.getString("nom"), rs.getString("details"), rs.getInt("duree"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Context.destroy();
		return module;
	}

	@Override
	public void insert(Module obj) {
		// @formatter:off
		try (PreparedStatement ps = Context.getInstance()
										   .getConnection().prepareStatement(
											"insert into module(id,nom,details,duree) values(nextval('seq_module'),?,?,?)",
											Statement.RETURN_GENERATED_KEYS)) {
		// @formatter:on
			ps.setString(1, obj.getNom());
			ps.setString(2, obj.getDetails());
			ps.setInt(3, obj.getDuree());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				obj.setId(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Context.destroy();

	}

	@Override
	public void update(Module obj) {
		try (PreparedStatement ps = Context.getInstance().getConnection()
				.prepareStatement("update module set nom=?,details=?,duree=? where id=?")) {
			ps.setString(1, obj.getNom());
			ps.setString(2, obj.getDetails());
			ps.setInt(3, obj.getDuree());
			ps.setInt(4, obj.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Context.destroy();
	}

	@Override
	public void delete(Module obj) {
		deleteByKey(obj.getId());
	}

	@Override
	public void deleteByKey(Integer key) {
		try (PreparedStatement ps = Context.getInstance().getConnection()
				.prepareStatement("delete from module where id=?")) {
			ps.setInt(1, key);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Context.destroy();
	}

}
