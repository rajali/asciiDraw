package au.com.live.rajali.model;

public class Canvas {

    private char[][] realState;

    //default constructor
    public Canvas() {}

    //initialise Canvas through constructor
    public void initialise(int height, int width) {
        int i=0;

        setRealState(new char[height + 2][width + 2]);
        for(; i < (width+2); i++){
            getRealState()[0][i] = '-';
            getRealState()[(height + 2) - 1][i] = '-';
        }
        i=1;
        for(; i < (height + 2) - 1; i++){
            getRealState()[i][0] = '|';
            for(int j=1; j < width + 1; j++) {
                getRealState()[i][j] = ' ';
            }
            getRealState()[i][(width + 2) - 1] = '|';
        }
    }

    public void print(){
        for(int i = 0; i< getRealState().length; i++){
            System.out.println(getRealState()[i]);
        }
        System.out.println();
    }

    //package-private scope
    char[][] getRealState() {
        return realState;
    }

    private void setRealState(char[][] realState) {
        this.realState = realState;
    }
}
