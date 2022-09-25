package services;

import daos.BuildingDaoImpl;
import models.BuildingSearchInput;
import models.BuildingSearchOutput;
import utils.BuildingTypesUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utils.BuildingTypesUtils.ConvertBuildingTypes;

public class BuildingServiceImpl implements IBuildingService {
    BuildingDaoImpl buildingDao = new BuildingDaoImpl();
    @Override
    public List<BuildingSearchOutput> findBuilding(BuildingSearchInput buildingSearchInput) {
        List<BuildingSearchOutput> resultsData = new ArrayList<>();
        StringBuilder appendStringTypes = new StringBuilder();
        /*
         * @author: kythuat-laptrinhjavaweb
         * @since: 9/25/2022 7:37 PM
         * @description: Dùng BuildingSearchOutput là đủ, không cần Map, key trong output không có nghĩa
         * @update:
         *
        */
        HashMap<String, BuildingSearchOutput> buildingSearchOutput = buildingDao.findBuilding(buildingSearchInput.getQueryParams());

        /*
         * @author: kythuat-laptrinhjavaweb
         * @since: 9/25/2022 7:32 PM
         * @description: Nên tách logic xử lý buildingTypes ra 1 method con để dễ đọc code, áp dụng phương pháp chia nhỏ method
         * @update:
         *
        */
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

    /*
     * @author: kythuat-laptrinhjavaweb
     * @since: 9/25/2022 7:34 PM
     * @description: TODO
     * @update:
     *
    */
    private String convertBuildingType(String buildingTypes) {
        // gọi Utils ra đây để xử lý
        Map<String, String> buildingTypeMap = BuildingTypesUtils.getBuildingTypes();
        String[] buildingTypeArr = buildingTypes.split(", ");
        StringBuilder result = new StringBuilder();

        // TODO: handle logic

        return result.toString();
    }
}
