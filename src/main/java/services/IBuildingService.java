package services;

import models.BuildingSearchInput;
import models.BuildingSearchOutput;

import java.util.HashMap;
import java.util.List;

public interface IBuildingService {
    List<HashMap> findBuilding(BuildingSearchInput buildingSearchInput);
}
