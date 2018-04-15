package au.com.live.rajali.model;

import java.util.HashMap;
import java.util.Map;

public enum OperationEnum {
    CANVAS("C"),
    LINE("L"),
    RECTANGLE("R"),
    FILL("F"),
    QUIT("Q");

    private static final Map<String, OperationEnum> lookup = new HashMap<>();
    private final String OperChar;

    static {
        for (OperationEnum operationEnum : OperationEnum.values()) {
            lookup.put(operationEnum.OperChar, operationEnum);
        }
    }

    @Override
    public String toString() {
        return OperChar;
    }

    OperationEnum(String operChar) {
        OperChar = operChar;
    }

    public static OperationEnum get(String operation) {
        return lookup.get(operation);
    }
}
