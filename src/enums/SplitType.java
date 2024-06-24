package enums;

import java.util.HashMap;
import java.util.Map;

public enum SplitType {
    EQUAL,
    EXACT,
    PERCENT;

    private static Map<String,SplitType> valueMap;

    public static SplitType getValue(String type) {
        if(valueMap == null) {
            valueMap = new HashMap<>();
            for(SplitType splitType: values()) {
                valueMap.put(splitType.toString(),splitType);
            }
        }
        return valueMap.get(type);
    }
}
