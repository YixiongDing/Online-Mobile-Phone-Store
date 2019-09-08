package DataMapper;
import domain.MobilePhone;
import domain.DomainObject;
import java.util.ArrayList;
import java.util.List;

import database.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MobileMapper {

	private final static String findStatementString =
			"SELECT * " +
					"  from mobilephones " +
					"  WHERE id = ?";

	private static final String findAvaliableMobilesStatement =
			"SELECT * from mobilephones WHERE qty > 0";

	private static final String findAllMobilesStatement =
			"SELECT * from mobilephones";


	public static List<MobilePhone> findMobilePhone(MobilePhone mobile) {

		List<MobilePhone> result = new ArrayList<MobilePhone>();
		try {
			PreparedStatement findStatement = DBConnection.prepare(findStatementString);
			findStatement.setInt(1, mobile.getMobileId());
			ResultSet rs = findStatement.executeQuery();

			while(rs.next()) {
				MobilePhone m = new MobilePhone();
				IdentityMap<MobilePhone> identityMap = IdentityMap.getInstance(m);
				int mobilePhoneId = rs.getInt(1);
				m.setId(mobilePhoneId);
				m.setModel(rs.getString(2));
				m.setBrand(rs.getString(3));
				m.setPrice(rs.getFloat(4));
				m.setQty(rs.getInt(5));
				identityMap.put(m.getMobileId(),m);
				result.add(m);
			}

		} catch (SQLException e) {
		}
		return result;
	}

	public List<MobilePhone> findAllMobilePhone(){
		List<MobilePhone> result = new ArrayList<MobilePhone>();
		try {
			PreparedStatement findStatement = DBConnection.prepare(findAllMobilesStatement);
			ResultSet rs = findStatement.executeQuery();

			while(rs.next()) {
				MobilePhone m = new MobilePhone();
				IdentityMap<MobilePhone> identityMap = IdentityMap.getInstance(m);
				int mobilePhoneId = rs.getInt(1);
				m.setId(mobilePhoneId);
				m.setModel(rs.getString(2));
				m.setBrand(rs.getString(3));
				m.setPrice(rs.getFloat(4));
				m.setQty(rs.getInt(5));
				identityMap.put(m.getMobileId(),m);
				result.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<MobilePhone> findAvailableMobiles() {
		List<MobilePhone> result = new ArrayList<>();
		try {

			PreparedStatement stmt = DBConnection.prepare(findAvaliableMobilesStatement);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1));
				int id =  rs.getInt(1);
				String modelArg = rs.getString(2);
				String brandArg = rs.getString(3);
				int priceArg = rs.getInt(4);
				int qtyArg = rs.getInt(5);
				result.add( new MobilePhone(id, modelArg, brandArg, priceArg,qtyArg));
			}

		} catch (SQLException e) {

		}
		return result;
	}


	//	public static void update(Person person) {
	//		String sql =
	//				"UPDATE people " +
	//						" set lastname = {0}, firstname = {1}, number_of_dependents = {2}" +
	//						" where id = {3}";
	//		String sqlPrepared =
	//				DB.prepare(sql, person.getLastName(), person.getFirstName(),
	//						person.getNumberOfDependenents(), person.getID());
	//		IDbCommand comm = new OleDbCommand(sqlPrepared, DB.Connection);
	//		comm.executeNonQuery();
	//	}

}
