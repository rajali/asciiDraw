package au.com.live.rajali.service;

import au.com.live.rajali.model.OperationEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OperationService {

    private OperationEnum operationEnum;
    private List<String> coordinates;

    public OperationService() {}

    public OperationService(String input) {
        String[] indices = input.split(" ");
        this.operationEnum = OperationEnum.get(indices[0].toUpperCase());
        this.coordinates = new ArrayList<>();
        this.coordinates.addAll(Arrays.asList(indices).subList(1, indices.length));
    }

    public OperationEnum getOperationEnum() {
        return operationEnum;
    }

    public List<String> getCoordinates() {
        return coordinates;
    }
}
