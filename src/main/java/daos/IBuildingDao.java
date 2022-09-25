package daos;

import models.BuildingSearchOutput;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IBuildingDao {
    HashMap<String, BuildingSearchOutput> findBuilding(
            HashMap<String, Object> queryParams
    );
}
