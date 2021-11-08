package formationJdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import formationJdbc.model.Formateur;
import formationJdbc.model.Formation;
import formationJdbc.util.Context;

class DaoFormationJdbcImpl implements DaoFormation {
//CreateReadUpdateDelete
	@Override
	public List<Formation> findAll() {
		List<Formation> formations = new ArrayList<Formation>();
		Connection connection = Context.getInstance().getConnection();
		try (Statement statement = connection.createStatement();) {
			ResultSet rs = statement.executeQuery(
					"select formation.id ,formation.nom ,formation.date,formation.id_referent,formateur.prenom,formateur.nom  from formation left  join formateur on formation.id_referent=formateur.id");
			Formation formation = null;
			while (rs.next()) {
				// @formatter:off
				formation = new Formation(rs.getInt(1), rs.getString(2), rs.getDate(3).toLocalDate());
				if (rs.getInt(4) != 0) {
					formation.setReferent(new Formateur(rs.getInt(4), rs.getString(5), rs.getString(6)));
				}
				formations.add(formation);
				// @formatter:on
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Context.destroy();
		return formations;
	}

	@Override
	public Formation findByKey(Integer key) {
		Connection connection = Context.getInstance().getConnection();
		Formation formation = null;
		try (PreparedStatement preparedStatement = connection.prepareStatement(
				"select formation.id ,formation.nom ,formation.date,formation.id_referent,formateur.prenom,formateur.nom  from formation left  join formateur on formation.id_referent=formateur.id where formation.id=?")) {
			preparedStatement.setInt(1, key);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				formation = new Formation(rs.getInt(1), rs.getString(2), rs.getDate(3).toLocalDate());
				if (rs.getInt(4) != 0) {
					formation.setReferent(new Formateur(rs.getInt(4), rs.getString(5), rs.getString(6)));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Context.destroy();
		return formation;
	}

	@Override
	public void insert(Formation obj) {
		// @formatter:off
		try (PreparedStatement ps = Context.getInstance()
										   .getConnection().prepareStatement(
											"insert into formation(id,nom,date,id_referent) values(nextval('seq_formation'),?,?,?)",
											Statement.RETURN_GENERATED_KEYS)) {
		// @formatter:on
			ps.setString(1, obj.getNom());
			// new
			// java.sql.Date(Date.from(obj.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant()).getTime());
			ps.setDate(2, Date.valueOf(obj.getDate()));
			if (obj.getReferent() != null) {
				ps.setInt(3, obj.getReferent().getId());
			} else {
				ps.setNull(3, Types.INTEGER);
			}
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
	public void update(Formation obj) {
		try (PreparedStatement ps = Context.getInstance().getConnection()
				.prepareStatement("update formation set nom=?,date=?,id_referent=? where id=?")) {
			ps.setString(1, obj.getNom());
			ps.setDate(2, Date.valueOf(obj.getDate()));
			if (obj.getReferent() != null) {
				ps.setInt(3, obj.getReferent().getId());
			} else {
				ps.setNull(3, Types.INTEGER);
			}
			ps.setInt(4, obj.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Context.destroy();
	}

	@Override
	public void delete(Formation obj) {
		deleteByKey(obj.getId());
	}

	@Override
	public void deleteByKey(Integer key) {
		try (PreparedStatement ps = Context.getInstance().getConnection()
				.prepareStatement("delete from formation where id=?")) {
			ps.setInt(1, key);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Context.destroy();
	}

	@Override
	public List<Formation> findByReferent(Formateur formateur) {
		List<Formation> formations = new ArrayList<Formation>();
		// @formatter:off
		try (PreparedStatement ps = Context.getInstance().getConnection().prepareStatement(
				"select formation.id ,formation.nom ,formation.date,formation.id_referent,formateur.prenom,formateur.nom  "
				+ "from formation left  join formateur on formation.id_referent=formateur.id "
				+ "where formation.id_referent=?")) {
			ps.setInt(1, formateur.getId());
			ResultSet rs = ps.executeQuery();
			Formation formation = null;
			while (rs.next()) {
				
				formation = new Formation(rs.getInt(1), rs.getString(2), rs.getDate(3).toLocalDate());
				if (rs.getInt(4) != 0) {
					formation.setReferent(new Formateur(rs.getInt(4), rs.getString(5), rs.getString(6)));
				}
				formations.add(formation);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// @formatter:on
		Context.destroy();
		return formations;
	}

}
