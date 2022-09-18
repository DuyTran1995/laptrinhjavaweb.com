package controllers;

import models.BuildingSearchInput;

import services.BuildingServiceImpl;

import java.util.HashMap;
import java.util.List;

public class BuildingController {
    private final BuildingServiceImpl buildingService = new BuildingServiceImpl();
    public List<HashMap> findBuilding(BuildingSearchInput buildingSearchInput) {
        return buildingService.findBuilding(buildingSearchInput);
    }
}
