package services;

import daos.BuildingDaoImpl;
import models.BuildingSearchOutput;
import utils.BuildingTypesUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildingServiceImpl implements IBuildingService {
    BuildingDaoImpl buildingDao = new BuildingDaoImpl();
    @Override
    public List<BuildingSearchOutput> findBuilding(HashMap<String, Object> buildingSearchInput) {
        List<BuildingSearchOutput> resultsData = new ArrayList<>();
        HashMap<String, BuildingSearchOutput> buildingSearchOutput = buildingDao.findBuilding(buildingSearchInput);
        convertBuildingType(buildingSearchOutput.get("types").getTypes());

        resultsData.add(buildingSearchOutput.get("name"));
        resultsData.add(buildingSearchOutput.get("street"));
        resultsData.add(buildingSearchOutput.get("district"));
        resultsData.add(buildingSearchOutput.get("ward"));
        resultsData.add(buildingSearchOutput.get("floorArea"));
        return resultsData;
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
}
