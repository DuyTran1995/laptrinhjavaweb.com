package controllers;

import models.BuildingSearchOutput;
import services.BuildingServiceImpl;
import services.IBuildingService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildingController {
    private final IBuildingService buildingService = new BuildingServiceImpl();
    public List<BuildingSearchOutput> findBuilding(Map<String, Object> buildingSearchInput) {
        return buildingService.findBuilding(buildingSearchInput);
    }
}
