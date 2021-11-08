package formationJdbc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import formationJdbc.model.Formateur;
import formationJdbc.model.Formation;
import formationJdbc.util.Context;

class DaoFormateurJdbcImpl implements DaoFormateur {

	@Override
	public List<Formateur> findAll() {
		List<Formateur> formateurs = new ArrayList<Formateur>();
		try (Statement st = Context.getInstance().getConnection().createStatement()) {
			ResultSet rs = st.executeQuery("select * from formateur");
			while (rs.next()) {
				formateurs.add(new Formateur(rs.getInt("id"), rs.getString("prenom"), rs.getString("nom")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Context.destroy();
		return formateurs;
	}

	@Override
	public Formateur findByKey(Integer key) {
		Formateur formateur = null;
		try (PreparedStatement ps = Context.getInstance().getConnection()
				.prepareStatement("select * from formateur where id=?")) {
			ps.setInt(1, key);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				formateur = new Formateur(rs.getInt("id"), rs.getString("prenom"), rs.getString("nom"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Context.destroy();
		return formateur;
	}

	@Override
	public void insert(Formateur obj) {
		try (PreparedStatement ps = Context.getInstance().getConnection().prepareStatement(
				"insert into formateur(id,prenom,nom) values(nextval('seq_formateur'),?,?)",
				Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, obj.getPrenom());
			ps.setString(2, obj.getNom());
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
	public void update(Formateur obj) {
		try (PreparedStatement ps = Context.getInstance().getConnection()
				.prepareStatement("update formateur set prenom=?,nom=? where id=?")) {
			ps.setString(1, obj.getPrenom());
			ps.setString(2, obj.getNom());
			ps.setInt(3, obj.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Context.destroy();
	}

	@Override
	public void delete(Formateur obj) {
		deleteByKey(obj.getId());
	}

	@Override
	public void deleteByKey(Integer key) {
		DaoFormation daoFormation = DaoFormationFactory.getInstance();
		List<Formation> formations = daoFormation.findByReferent(findByKey(key));
		for (Formation f : formations) {
			f.setReferent(null);
			daoFormation.update(f);
		}
		try (PreparedStatement ps = Context.getInstance().getConnection()
				.prepareStatement("delete from formateur where id=?")) {
			ps.setInt(1, key);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Context.destroy();
	}

}
