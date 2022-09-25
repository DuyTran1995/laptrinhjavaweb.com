package controllers;

import models.BuildingSearchInput;

import models.BuildingSearchOutput;
import services.BuildingServiceImpl;
import services.IBuildingService;

import java.util.HashMap;
import java.util.List;

public class BuildingController {
    private final IBuildingService buildingService = new BuildingServiceImpl();
    public List<BuildingSearchOutput> findBuilding(BuildingSearchInput buildingSearchInput) {
        return buildingService.findBuilding(buildingSearchInput);
    }
}
