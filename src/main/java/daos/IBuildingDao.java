package daos;

import models.BuildingSearchOutput;

import java.util.List;

public interface IBuildingDao {
    List<BuildingSearchOutput> findBuilding(
            String name,
            String street,
            String district,
            String ward,
            Integer floorArea,
            String types
    );
}
