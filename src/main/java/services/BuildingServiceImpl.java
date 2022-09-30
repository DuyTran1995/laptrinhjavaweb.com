package services;

import daos.BuildingDaoImpl;
import daos.model.BuildingEntity;
import models.BuildingSearchOutput;
import utils.BuildingTypesUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BuildingServiceImpl implements IBuildingService {
    BuildingDaoImpl buildingDao = new BuildingDaoImpl();
    @Override
    public List<BuildingSearchOutput> findBuilding(Map<String, Object> buildingSearchInput) {
        List<BuildingSearchOutput> results = new ArrayList<>();
        List<BuildingEntity> buildingEntity = buildingDao.findBuilding(buildingSearchInput);
        BuildingSearchOutput dtoBuilding = null;
        for (BuildingEntity building : buildingEntity) {
            dtoBuilding = convertEntityToDto(building);
        }

        if (dtoBuilding != null) {
            String buildingType = convertBuildingType(dtoBuilding.getTypes());
            dtoBuilding.setTypes(buildingType);
            results.add(dtoBuilding);
            return results;
        }
        return null;
    }

    private String convertBuildingType(String buildingTypes) {
        Map<String, String> buildingTypeMap = BuildingTypesUtils.getBuildingTypes();
        String[] buildingTypeArr = buildingTypes.split(", ");
        StringBuilder result = new StringBuilder();
        for (String n: buildingTypeArr) {
            result.append(" ").append(buildingTypeMap.get(n));
        }
        return result.toString();
    }

    private BuildingSearchOutput convertEntityToDto(BuildingEntity building) {
        BuildingSearchOutput buildingSearchOutput = new BuildingSearchOutput();
        buildingSearchOutput.setName(building.getName());
        buildingSearchOutput.setStreet(building.getStreet());
        buildingSearchOutput.setDistrict(building.getDistrict());
        buildingSearchOutput.setWard(building.getWard());
        buildingSearchOutput.setFloorArea(building.getFloorArea());
        buildingSearchOutput.setTypes(building.getTypes());
        return buildingSearchOutput;
    }
}
