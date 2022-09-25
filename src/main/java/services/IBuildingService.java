package services;

import models.BuildingSearchOutput;

import java.util.HashMap;
import java.util.List;

public interface IBuildingService {
    List<BuildingSearchOutput> findBuilding(HashMap<String, Object> buildingSearchInput);
}
