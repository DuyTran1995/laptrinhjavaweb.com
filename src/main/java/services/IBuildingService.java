package services;

import models.BuildingSearchInput;
import models.BuildingSearchOutput;

import java.util.List;

public interface IBuildingService {
    List<BuildingSearchOutput> findBuilding(BuildingSearchInput buildingSearchInput);
}
