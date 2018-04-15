package au.com.live.rajali.model;

public class Rectangle extends Shape {

    @Override
    public void draw(int x1, int y1, int x2, int y2, Canvas canvas) {
        if(x1 < 1 || x2 < 1 || y1 < 1 || y2 < 1)
            return;
        if(x1 > canvas.getRealState()[0].length - 2
                || x2 > canvas.getRealState()[0].length - 2
                || y1 > canvas.getRealState()[0].length - 2
                || y2 > canvas.getRealState()[0].length - 2)
            return;
        drawHorizontalLine(x1, y1, x2, y1, canvas);
        drawHorizontalLine(x1, y2, x2, y2, canvas);
        drawVerticalLine(x1, y1, x1, y2, canvas);
        drawVerticalLine(x2, y1, x2, y2, canvas);
    }
}
