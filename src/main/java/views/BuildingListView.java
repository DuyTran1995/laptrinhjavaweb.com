package views;

import controllers.BuildingController;
import models.BuildingSearchInput;
import models.BuildingSearchOutput;

import java.util.HashMap;
import java.util.List;

public class BuildingListView {
    public static void main(String[] args) {
        Integer floorArea = 100;
        String name = "n";
        String ward = null;
        String street = null;
        String district = null;
        HashMap<String, Object> queryParams = new HashMap<>();

        queryParams.put("floorArea", 100);
        queryParams.put("name", "n");
        queryParams.put("ward", null);
        queryParams.put("street", null);
        queryParams.put("district", null);

        BuildingSearchInput buildingSearchInput = new BuildingSearchInput();
//        buildingSearchInput.setName(name);
//        buildingSearchInput.setWard(ward);
//        buildingSearchInput.setStreet(street);
//        buildingSearchInput.setDistrict(district);
//        buildingSearchInput.setQueryParams(floorArea);

        buildingSearchInput.setQueryParams(queryParams);

        BuildingController buildingController = new BuildingController();
        List<BuildingSearchOutput> buildingSearchOutputs = buildingController.findBuilding(buildingSearchInput);
        System.out.println("buildingSearchOutputs:" + buildingSearchOutputs);
    }
}
