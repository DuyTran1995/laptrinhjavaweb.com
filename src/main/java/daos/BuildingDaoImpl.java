package daos;

import models.BuildingSearchOutput;
import utils.ConnectionUtils;
import utils.StringUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BuildingDaoImpl implements IBuildingDao {
    @Override
    public List<BuildingSearchOutput> findBuilding(String name, String street, String district, String ward, Integer floorArea, String types) {
        List<BuildingSearchOutput> results = new ArrayList<>();
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            StringBuilder sql = new StringBuilder("SELECT * FROM building WHERE 1 = 1");
            if (!StringUtils.isNullOrEmpty(name)) {
                sql.append(" and name like '%" + name +"%'");
            }
            if (!StringUtils.isNullOrEmpty(street)) {
                sql.append(" and street like '%" + street +"%'");
            }
            if (!StringUtils.isNullOrEmpty(district)) {
                sql.append(" and district like '%" + district +"%'");
            }
            if (!StringUtils.isNullOrEmpty(ward)) {
                sql.append(" and ward like '%" + ward +"%'");
            }
            if (!StringUtils.isNullOrEmpty(types)) {
                sql.append(" and types like '%" + types +"%'");
            }
            if (floorArea != null) {
                sql.append(" and floorArea = " + floorArea + "");
            }
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = ConnectionUtils.getConnection();
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql.toString());

            while (resultSet.next()) {
                BuildingSearchOutput buildingSearchOutput = new BuildingSearchOutput();
                buildingSearchOutput.setTypes(resultSet.getString("types"));
                buildingSearchOutput.setName(resultSet.getString("name"));
                results.add(buildingSearchOutput);
            }
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                conn.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return results;
    }
}
