package au.com.live.rajali.model;

public abstract class Shape {

    public abstract void draw(int x1, int y1, int x2, int y2, Canvas canvas);

    void drawHorizontalLine(int x1, int y1, int x2, int y2, Canvas canvas) {
        int aux;
        if(x2 < x1){
            aux = x1;
            x1 = x2;
            x2 = aux;
        }
        for(int i=x1; i <= x2; i++){
            canvas.getRealState()[y1][i] = 'x';
        }
    }

    void drawVerticalLine(int x1, int y1, int x2, int y2, Canvas canvas) {
        int aux;
        if(y2 < y1){
            aux = y1;
            y1 = y2;
            y2 = aux;
        }
        for(int i=y1; i <= y2; i++){
            canvas.getRealState()[i][x1] = 'x';
        }
    }

}
