package controllers;

import models.BuildingSearchInput;
import models.BuildingSearchOutput;

import services.BuildingServiceImpl;

import java.util.List;

public class BuildingController {
    private BuildingServiceImpl buildingService = new BuildingServiceImpl();
    public List<BuildingSearchOutput> findBuilding(BuildingSearchInput buildingSearchInput) {
        return buildingService.findBuilding(buildingSearchInput);
    }
}
