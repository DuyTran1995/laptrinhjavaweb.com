package daos;

import models.BuildingSearchOutput;
import utils.ConnectionUtils;
import utils.StringUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class BuildingDaoImpl implements IBuildingDao {
    @Override
    public List<BuildingSearchOutput> findBuilding(HashMap<String, Object> queryParams) {
        List<BuildingSearchOutput> results = new ArrayList<>();
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        HashMap<String, String> map = new HashMap<>();
        try {
            StringBuilder sql = new StringBuilder("SELECT * FROM building WHERE 1 = 1");
            if (!StringUtils.isNullOrEmpty(queryParams.get("name"))) {
                sql.append(" and name like '%" + queryParams.get("name") +"%'");
            }
            if (!StringUtils.isNullOrEmpty(queryParams.get("street"))) {
                sql.append(" and street like '%" + queryParams.get("street") +"%'");
            }
            if (!StringUtils.isNullOrEmpty(queryParams.get("district"))) {
                sql.append(" and district like '%" + queryParams.get("district") +"%'");
            }
            if (!StringUtils.isNullOrEmpty(queryParams.get("ward"))) {
                sql.append(" and ward like '%" + queryParams.get("ward") +"%'");
            }
            if (!StringUtils.isNullOrEmpty(queryParams.get("types"))) {
                sql.append(" and types like '%" + queryParams.get("types") +"%'");
            }

            if (queryParams.get("floorArea") != null) {
                sql.append(" and floorArea = " + queryParams.get("floorArea") + "");
            }
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = ConnectionUtils.getConnection();
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql.toString());

            while (resultSet.next()) {
                BuildingSearchOutput buildingSearchOutput = new BuildingSearchOutput();
                buildingSearchOutput.setName(resultSet.getString("name"));
                buildingSearchOutput.setTypes(resultSet.getString("types"));
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
