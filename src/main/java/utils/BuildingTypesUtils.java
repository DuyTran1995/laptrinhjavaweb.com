package utils;


import constants.BuildingTypes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class BuildingTypesUtils {
    static List<String> convertTypesResult = new ArrayList();

    static public List<String> ConvertBuildingTypes(String types) {
        if (Objects.equals(types, BuildingTypes.NGUYEN_CAN_KEY)) {
//            result = "Nguyên Căn";
            convertTypesResult.add(BuildingTypes.NGUYEN_CAN_VALUE);
        }
        if (Objects.equals(types, BuildingTypes.TANG_TRIET_KEY)) {
//            result = "Tầng Triệt";
            convertTypesResult.add(BuildingTypes.TANG_TRIET_VALUE);
        }
        if (Objects.equals(types, BuildingTypes.NOI_THAT_KEY)) {
//            result = "Nội Thất";
            convertTypesResult.add(BuildingTypes.NOI_THAT_VALUE);
        }
        return convertTypesResult;
    }

    static public HashMap<String, Object> getBuildingType(String constantCode, String constantName) {
        HashMap<String, Object> buildingTypes = new HashMap<>();
        buildingTypes.put(constantCode, constantName);
        return buildingTypes;
    }
}
