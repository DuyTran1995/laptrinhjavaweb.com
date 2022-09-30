package utils;


import constants.BuildingTypes;
import models.BuildingSearchOutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class BuildingTypesUtils {
    static public HashMap<String, String> getBuildingTypes() {
        HashMap<String, String> resultConvertTypes = new HashMap<>();
        resultConvertTypes.put(BuildingTypes.NGUYEN_CAN_KEY, BuildingTypes.NGUYEN_CAN_VALUE);
        resultConvertTypes.put(BuildingTypes.TANG_TRIET_KEY, BuildingTypes.TANG_TRIET_VALUE);
        resultConvertTypes.put(BuildingTypes.NOI_THAT_KEY, BuildingTypes.NOI_THAT_VALUE);
        return resultConvertTypes;
    }
}
