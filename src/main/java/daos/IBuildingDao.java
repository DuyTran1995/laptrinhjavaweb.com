package daos;

import daos.model.BuildingEntity;

import java.util.List;
import java.util.Map;

public interface IBuildingDao {
    List<BuildingEntity> findBuilding(
            Map<String, Object> queryParams
    );
}
