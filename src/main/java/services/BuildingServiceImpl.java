package services;

import daos.BuildingDaoImpl;
import models.BuildingSearchInput;
import models.BuildingSearchOutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static utils.ConvertBuildingTypes.ConvertBuildingTypes;

public class BuildingServiceImpl implements IBuildingService {
    BuildingDaoImpl buildingDao = new BuildingDaoImpl();
    @Override
    public List findBuilding(BuildingSearchInput buildingSearchInput) {
        List<String> ConvertBuildingTypesResult = new ArrayList<>();
        List<HashMap> listBuilding = new ArrayList<>();
        HashMap resultsData = new HashMap();
        List<BuildingSearchOutput> buildingSearchOutput = buildingDao.findBuilding(buildingSearchInput.getQueryParams());
        for (int i = 0; i < buildingSearchOutput.size(); i++) {
            String[] getBuildingType = buildingSearchOutput.get(i).getTypes().split(", ");
            for(String n : getBuildingType) {
                ConvertBuildingTypesResult = ConvertBuildingTypes(n);
            }

            resultsData.put("types", ConvertBuildingTypesResult);
            resultsData.put("name", buildingSearchOutput.get(i).getName());
            listBuilding.add(resultsData);
        }
       return listBuilding;
    }
}
