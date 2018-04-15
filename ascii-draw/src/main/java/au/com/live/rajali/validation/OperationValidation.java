package au.com.live.rajali.validation;

import au.com.live.rajali.model.OperationEnum;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperationValidation {

    private static final Pattern pattern = Pattern
            .compile("[a-zA-Z](\\s\\d+)*(\\s[a-zA-z])?+");

    public void validateCommand(String input) throws Exception {
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new Exception("Invalid Operation.");
        }
        String operationPrefix = input.substring(0, 1);
        if (null == OperationEnum.get(operationPrefix)) {
            throw new Exception("Command " + operationPrefix
                    + " is not a valid command.");
        }
    }

    public boolean checkCanvasParams(final List<String> params) throws Exception {
        if (params.size() < 2
                && Integer.parseInt(params.get(0)) > 0
                && Integer.parseInt(params.get(1)) > 0) {
            throw new Exception(
                    "Canvas requires 2 integer parameters, " + params.size() + " params provided.");
        } else {
            return true;
        }
    }

    public boolean checkLineAndRectangleParams(final List<String> params) throws Exception {
        if (params.size() < 2
                && Integer.parseInt(params.get(0)) > 0
                && Integer.parseInt(params.get(1)) > 0
                && Integer.parseInt(params.get(3)) > 0
                && Integer.parseInt(params.get(4)) > 0) {
            throw new Exception(
                    "Line|Rectangle requires 4 integer parameters, " + params.size() + " params provided.");
        } else {
            return true;
        }

    }
}
