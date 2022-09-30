package services;

import models.BuildingSearchOutput;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IBuildingService {
    List<BuildingSearchOutput> findBuilding(Map<String, Object> buildingSearchInput);
}
