package services;

import daos.BuildingDaoImpl;
import models.BuildingSearchInput;
import models.BuildingSearchOutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static utils.BuildingTypesUtils.ConvertBuildingTypes;

public class BuildingServiceImpl implements IBuildingService {
    BuildingDaoImpl buildingDao = new BuildingDaoImpl();
    @Override
    public List<BuildingSearchOutput> findBuilding(BuildingSearchInput buildingSearchInput) {
        List<BuildingSearchOutput> resultsData = new ArrayList<>();
        StringBuilder appendStringTypes = new StringBuilder();
        HashMap<String, BuildingSearchOutput> buildingSearchOutput = buildingDao.findBuilding(buildingSearchInput.getQueryParams());
        String[] splitTypes = buildingSearchOutput.get("types").getTypes().split(", ");
        for (String n: splitTypes) {
            appendStringTypes.append(" ").append(ConvertBuildingTypes().get(n));
        }
        buildingSearchOutput.get("types").setTypes(appendStringTypes.toString());

        resultsData.add(buildingSearchOutput.get("name"));
        resultsData.add(buildingSearchOutput.get("street"));
        resultsData.add(buildingSearchOutput.get("district"));
        resultsData.add(buildingSearchOutput.get("ward"));
        resultsData.add(buildingSearchOutput.get("floorArea"));
        return resultsData;
    }
}
