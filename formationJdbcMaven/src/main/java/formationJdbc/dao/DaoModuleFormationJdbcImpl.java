package formationJdbc.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import formationJdbc.model.Module;
import formationJdbc.model.Formateur;
import formationJdbc.model.Formation;
import formationJdbc.model.ModuleFormation;
import formationJdbc.model.ModuleFormationKey;
import formationJdbc.util.Context;

class DaoModuleFormationJdbcImpl implements DaoModuleFormation {

	@Override
	public List<ModuleFormation> findAll() {
		List<ModuleFormation> list = new ArrayList<ModuleFormation>();
		// @formatter:off
		try (Statement st = Context.getInstance().getConnection().createStatement()) {
			ResultSet rs=st.executeQuery("select f.id,f.nom,f.date,"
					+ "f.id_referent,r.prenom,r.nom,"
					+ "m.id,m.nom,m.details,m.duree," 
					+ "fo.id,fo.prenom,fo.nom,mf.date" 
					+ " from module_formation mf"
					+ " join formation f on mf.id_formation=f.id" 
					+ " join formateur r on f.id_referent=r.id"
					+ " join module m on mf.id_module=m.id" 
					+ " join formateur fo on mf.id_formateur=fo.id");
			Formateur referent=null;
			Formation formation=null;
			Module module=null;
			Formateur formateur=null;
			ModuleFormation moduleFormation = null;
			while(rs.next()) {
				referent=new Formateur(rs.getInt(4), rs.getString(5), rs.getString(6));
				formation=new Formation(rs.getInt(1), rs.getString(2), rs.getDate(3).toLocalDate(),referent);
				module=new Module(rs.getInt(7), rs.getString(8), rs.getString(9), rs.getInt(10));
				formateur=new Formateur(rs.getInt(11), rs.getString(12), rs.getString(13));
				moduleFormation=new ModuleFormation(
						new ModuleFormationKey(module, formation),
						rs.getDate(14).toLocalDate(),
						formateur);
				list.add(moduleFormation);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// @formatter:on

		Context.destroy();
		return list;
	}

	@Override
	public ModuleFormation findByKey(ModuleFormationKey key) {
		ModuleFormation moduleFormation = null;
		// @formatter:off
		try (PreparedStatement ps = Context.getInstance().getConnection()
				.prepareStatement("select f.id,f.nom,f.date,f.id_referent,r.prenom,r.nom,"
						+ "m.id,m.nom,m.details,m.duree," 
						+ "fo.id,fo.prenom,fo.nom,mf.date" 
						+ " from module_formation mf"
						+ " join formation f on mf.id_formation=f.id" 
						+ " join formateur r on f.id_referent=r.id"
						+ " join module m on mf.id_module=m.id" 
						+ " join formateur fo on mf.id_formateur=fo.id"
						+ " and mf.id_formation=? " 
						+ " and mf.id_module=?")) {
			ps.setInt(1, key.getFormation().getId());
			ps.setInt(2, key.getModule().getId());
			ResultSet rs=ps.executeQuery();
			Formateur referent=null;
			Formation formation=null;
			Module module=null;
			Formateur formateur=null;
			if(rs.next()) {
				referent=new Formateur(rs.getInt(4), rs.getString(5), rs.getString(6));
				formation=new Formation(rs.getInt(1), rs.getString(2), rs.getDate(3).toLocalDate(),referent);
				module=new Module(rs.getInt(7), rs.getString(8), rs.getString(9), rs.getInt(10));
				formateur=new Formateur(rs.getInt(11), rs.getString(12), rs.getString(13));
				moduleFormation=new ModuleFormation(
						new ModuleFormationKey(module, formation),
						rs.getDate(14).toLocalDate(),
						formateur);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// @formatter:on
		Context.destroy();
		return moduleFormation;
	}

	@Override
	public void insert(ModuleFormation obj) {
		// @formatter:off
		try (PreparedStatement ps=Context.getInstance().getConnection()
						.prepareStatement("insert into module_formation(id_formation,id_module,date,id_formateur)"
								+ " values(?,?,?,?)")){
			ps.setInt(1,obj.getKey().getFormation().getId());
			ps.setInt(2, obj.getKey().getModule().getId());
			ps.setDate(3, Date.valueOf(obj.getDate()));
			ps.setInt(4, obj.getFormateur().getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// @formatter:on
		Context.destroy();

	}

	@Override
	public void update(ModuleFormation obj) {
		// @formatter:off
		try (PreparedStatement ps=Context.getInstance().getConnection()
								.prepareStatement("update module_formation set"
										+ "date=?, id_formateur=? where id_formation=? and id_module=?")){
			ps.setDate(1, Date.valueOf(obj.getDate()));
			ps.setInt(2, obj.getFormateur().getId());
			ps.setInt(3,obj.getKey().getFormation().getId());
			ps.setInt(4, obj.getKey().getModule().getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// @formatter:on
		Context.destroy();
	}

	@Override
	public void delete(ModuleFormation obj) {
		deleteByKey(obj.getKey());
	}

	@Override
	public void deleteByKey(ModuleFormationKey key) {
		// @formatter:off
		try (PreparedStatement ps=Context.getInstance().getConnection()
										.prepareStatement("delete from module_formation "
												+ "where id_formation=? and id_module=?")){
			ps.setInt(1,key.getFormation().getId());
			ps.setInt(2, key.getModule().getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// @formatter:on
		Context.destroy();
	}

}
