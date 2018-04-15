package au.com.live.rajali;

import au.com.live.rajali.model.Canvas;
import au.com.live.rajali.model.Line;
import au.com.live.rajali.model.OperationEnum;
import au.com.live.rajali.model.Rectangle;
import au.com.live.rajali.service.OperationService;
import au.com.live.rajali.validation.OperationValidation;

import java.util.Scanner;

/**
 * ASCII Drawing on Console!
 *
 */
public class App 
{
    private static Canvas canvas;

    public static void main( String[] args ) {
        printInstructions();
        App app = new App();
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                try {
                    System.out.print("Please Provide Draw Operation: ");
                    app.executeDrawSteps(scanner.nextLine());
                } catch (Exception inputException) {
                    System.err.println(inputException.getMessage());
                }
            } while (true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    private static void printInstructions() {
        final String instuctions = "|Command \t\t|Description|\n" +
                "|----|----|\n" +
                "|C w h          | Create a new canvas of width w and height h.|\n" +
                "|L x1 y1 x2 y2  | Draw a new line from (x1,y1) to (x2,y2). Currently, only|\n" +
                "|               | horizontal or vertical lines are supported. Horizontal and vertical lines|\n" +
                "|               | will be drawn using the 'x' character.|\n" +
                "|R x1 y1 x2 y2  | Draw a rectangle whose upper left corner is (x1,y1) and|\n" +
                "|               | lower right corner is (x2,y2). Horizontal and vertical lines will be drawn|\n" +
                "|               | using the 'x' character.|\n" +
                "|B x y c        | Fill the entire area connected to (x,y) with \"colour\" c. The|\n" +
                "|               | behaviour of this is the same as that of the \"bucket fill\" tool in paint|\n" +
                "|               | programs.|\n" +
                "|Q              | Quit|\n";

        System.out.println(instuctions);
    }

    private void executeDrawSteps(final String input) throws Exception {
        OperationValidation operationValidation = new OperationValidation();
        operationValidation.validateCommand(input);

        OperationService operationService = new OperationService(input);

        if (canvas == null) {
            if (!(operationService.getOperationEnum().equals(OperationEnum.CANVAS)
                    || operationService.getOperationEnum().equals(OperationEnum.QUIT))) {
                throw new Exception(
                        "There is no Canvas yet to draw. Please first create one! using C <width> <height>");
            } else {
                if (operationValidation.checkCanvasParams(operationService.getCoordinates())) {
                    canvas = new Canvas();
                    canvas.initialise(Integer.parseInt(operationService.getCoordinates().get(0)),
                            Integer.parseInt(operationService.getCoordinates().get(1)));
                    canvas.print();
                } else {
                    throw new Exception("Parameters provided are not valid for the Canvas");
                }
            }
        } else {
            if (operationService.getOperationEnum().equals(OperationEnum.LINE)) {
                if (operationValidation.checkLineAndRectangleParams(operationService.getCoordinates())) {
                    Line line = new Line();
                    line.draw(Integer.parseInt(operationService.getCoordinates().get(0)),
                            Integer.parseInt(operationService.getCoordinates().get(1)),
                            Integer.parseInt(operationService.getCoordinates().get(2)),
                            Integer.parseInt(operationService.getCoordinates().get(3)),
                            canvas);
                    canvas.print();
                } else {
                    throw new Exception("Parameters provided are not valid for Line Drawing.");
                }

            } else if (operationService.getOperationEnum().equals(OperationEnum.RECTANGLE)) {
                if (operationValidation.checkLineAndRectangleParams(operationService.getCoordinates())) {
                    Rectangle rectangle = new Rectangle();
                    rectangle.draw(Integer.parseInt(operationService.getCoordinates().get(0)),
                            Integer.parseInt(operationService.getCoordinates().get(1)),
                            Integer.parseInt(operationService.getCoordinates().get(2)),
                            Integer.parseInt(operationService.getCoordinates().get(3)),
                            canvas);
                    canvas.print();
                } else {
                    throw new Exception("Parameters provided are not valid for Rectangle Drawing.");
                }
            } else if (operationService.getOperationEnum().equals(OperationEnum.QUIT)) {
                System.exit(0);
            } else {
                throw new Exception("Operation no yet supported!.");
            }
        }
    }
            
}
