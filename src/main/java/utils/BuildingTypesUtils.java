package utils;


import constants.BuildingTypes;
import models.BuildingSearchOutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BuildingTypesUtils {
    public static Map<String, String> getBuildingTypes() {
        Map<String, String> result = new HashMap<>();
        result.put(BuildingTypes.NGUYEN_CAN_KEY, BuildingTypes.NGUYEN_CAN_VALUE);
        result.put(BuildingTypes.TANG_TRIET_KEY, BuildingTypes.TANG_TRIET_VALUE);
        result.put(BuildingTypes.NOI_THAT_KEY, BuildingTypes.NOI_THAT_VALUE);
        return result;
    }

    /*
     * @author: kythuat-laptrinhjavaweb
     * @since: 9/25/2022 7:33 PM
     * @description: Không cần method này
     * @update:
     *
    */
//    static public HashMap<String, Object> getBuildingType(String constantCode, String constantName) {
//        HashMap<String, Object> buildingTypes = new HashMap<>();
//        buildingTypes.put(constantCode, constantName);
//        return buildingTypes;
//    }
}
