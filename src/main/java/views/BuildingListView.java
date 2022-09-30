package views;

import controllers.BuildingController;
import models.BuildingSearchInput;
import models.BuildingSearchOutput;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildingListView {
    public static void main(String[] args) {
        Integer floorArea = 100;
        String name = "n";
        String ward = null;
        String street = null;
        String district = null;
        Map<String, Object> queryParams = new HashMap<>();

        queryParams.put("floorArea", 100);
        queryParams.put("name", "n");
        queryParams.put("ward", null);
        queryParams.put("street", null);
        queryParams.put("district", null);

        BuildingController buildingController = new BuildingController();
        List<BuildingSearchOutput> buildingSearchOutputs = buildingController.findBuilding(queryParams);
        System.out.println("buildingSearchOutputs: " + buildingSearchOutputs);
    }
}
