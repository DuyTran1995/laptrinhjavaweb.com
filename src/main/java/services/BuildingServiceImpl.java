package services;

import daos.BuildingDaoImpl;
import models.BuildingSearchInput;
import models.BuildingSearchOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BuildingServiceImpl implements IBuildingService {
    BuildingDaoImpl buildingDao = new BuildingDaoImpl();
    BuildingSearchOutput buildingSearchResponse = new BuildingSearchOutput();
    @Override
    public List<BuildingSearchOutput> findBuilding(BuildingSearchInput buildingSearchInput) {
        List replaceResult = new ArrayList<>();
        List<BuildingSearchOutput> buildingSearchOutput = buildingDao.findBuilding(
                buildingSearchInput.getName(),
                buildingSearchInput.getStreet(),
                buildingSearchInput.getDistrict(),
                buildingSearchInput.getWard(),
                buildingSearchInput.getFloorArea(),
                buildingSearchInput.getTypes()
                );
        for (int i = 0; i < buildingSearchOutput.size(); i++) {
            String[] getBuildingType = buildingSearchOutput.get(i).getTypes().split(", ");
            for(String n : getBuildingType) {
                if (Objects.equals(n, "tang-triet")) {
                    System.out.println("Tầng Triêt");;
                }
                if (Objects.equals(n, "nguyen-can")) {
                    System.out.println("Nguyên Căn");
                }
                if (Objects.equals(n, "noi-that")) {
                    System.out.println("Nội Thất");
                }
            }
        }
       return null;
    }
}
