package utils;


import constants.BuildingTypes;
import models.BuildingSearchOutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class BuildingTypesUtils {
    static public HashMap<String, String> ConvertBuildingTypes() {
        HashMap<String, String> resultConvertTypes = new HashMap();
        resultConvertTypes.put(BuildingTypes.NGUYEN_CAN_KEY, BuildingTypes.NGUYEN_CAN_VALUE);
        resultConvertTypes.put(BuildingTypes.TANG_TRIET_KEY, BuildingTypes.TANG_TRIET_VALUE);
        resultConvertTypes.put(BuildingTypes.TANG_TRIET_KEY, BuildingTypes.NOI_THAT_VALUE);

//        if (Objects.equals(types, BuildingTypes.NGUYEN_CAN_KEY)) {
////            result = "Nguyên Căn";
//            resultConvertTypes.put(BuildingTypes.NGUYEN_CAN_KEY, BuildingTypes.NGUYEN_CAN_VALUE);
//        }
//        if (Objects.equals(types, BuildingTypes.TANG_TRIET_KEY)) {
////            result = "Tầng Triệt";
//            resultConvertTypes.put(BuildingTypes.TANG_TRIET_KEY, BuildingTypes.TANG_TRIET_VALUE);
//        }
//        if (Objects.equals(types, BuildingTypes.NOI_THAT_KEY)) {
////            result = "Nội Thất";
//            resultConvertTypes.put(BuildingTypes.TANG_TRIET_KEY, BuildingTypes.NOI_THAT_VALUE);
//        }
        return resultConvertTypes;
    }

    static public HashMap<String, Object> getBuildingType(String constantCode, String constantName) {
        HashMap<String, Object> buildingTypes = new HashMap<>();
        buildingTypes.put(constantCode, constantName);
        return buildingTypes;
    }
}
