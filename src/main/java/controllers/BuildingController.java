package controllers;

import models.BuildingSearchInput;

import models.BuildingSearchOutput;
import services.BuildingServiceImpl;

import java.util.HashMap;
import java.util.List;

public class BuildingController {
    private final BuildingServiceImpl buildingService = new BuildingServiceImpl();
    public List<BuildingSearchOutput> findBuilding(BuildingSearchInput buildingSearchInput) {
        return buildingService.findBuilding(buildingSearchInput);
    }
}
