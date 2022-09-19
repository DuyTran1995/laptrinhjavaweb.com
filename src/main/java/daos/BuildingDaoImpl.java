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
        Object getName = queryParams.get("name");
        Object getStreet = queryParams.get("street");
        Object getDistrict = queryParams.get("district");
        Object getWard = queryParams.get("ward");
        Object getTypes = queryParams.get("types");
        Object getFloorArea = queryParams.get("floorArea");
        try {
            StringBuilder sql = new StringBuilder("SELECT * FROM building WHERE 1 = 1");
            if (!StringUtils.isNullOrEmpty(getName)) {
                sql.append(" and name like '%" + getName +"%'");
            }
            if (!StringUtils.isNullOrEmpty(getStreet)) {
                sql.append(" and street like '%" + getStreet +"%'");
            }
            if (!StringUtils.isNullOrEmpty(getDistrict)) {
                sql.append(" and district like '%" + getDistrict +"%'");
            }
            if (!StringUtils.isNullOrEmpty(getWard)) {
                sql.append(" and ward like '%" + getWard +"%'");
            }
            if (!StringUtils.isNullOrEmpty(getTypes)) {
                sql.append(" and types like '%" + getTypes +"%'");
            }

            if (getFloorArea != null) {
                sql.append(" and floorArea = " + getFloorArea + "");
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
