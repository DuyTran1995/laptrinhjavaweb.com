package utils;


import constants.BuildingTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConvertBuildingTypes {
    static List<String> convertTypesResult = new ArrayList();

    static public List<String> ConvertBuildingTypes(String types) {
        if (Objects.equals(types, BuildingTypes.NGUYEN_CAN)) {
//            result = "Nguyên Căn";
            convertTypesResult.add("Nguyên Căn");
        }
        if (Objects.equals(types, BuildingTypes.TANG_TRIET)) {
//            result = "Tầng Triệt";
            convertTypesResult.add("Tầng Triệt");
        }
        if (Objects.equals(types, BuildingTypes.NOI_THAT)) {
//            result = "Nội Thất";
            convertTypesResult.add("Nội Thất");
        }
        return convertTypesResult;
    }
}
