public class Plansa { //test <git diff>
    public enum Symbol {SX, SO, S_} 
    private Symbol[][] t;

    public static final String RED = "\033[0;91m"; //Red
    public static final String BLUE = "\033[0;94m"; //Blue
    public static final String RESET = "\033[0;0m";

public Plansa() {

    t = new Symbol[3][3];
    for(int i=0; i<3; ++i)
        for(int j=0; j<3; ++j)
            t[i][j] = Symbol.S_;
}

    public void showTable() {

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j)
                switch (t[i][j]) {
                    case SX:
                        System.out.print(BLUE + 'X' + " ");
                        break;
                    case SO:
                        System.out.print(RED + '0' + " ");
                        break;
                    case S_:
                        System.out.print(RESET + '_' + " ");
                        break;
                }
            System.out.println();
        }
    }

    public  boolean hasWonX(){
        boolean winner = true;
        for(int i=0; i<3; ++i) {
            if ((Symbol.SX == t[i][0]&&Symbol.SX == t[i][1]&&Symbol.SX == t[i][2]) || //verifica egalitate elemente pe rand
                (Symbol.SX == t[0][i]&&Symbol.SX == t[1][i]&&Symbol.SX == t[2][i]) || //verifica egalitate elemente pe coloana
                (Symbol.SX == t[0][0]&&Symbol.SX == t[1][1]&&Symbol.SX == t[2][2]) || //verifica egalitate elemente pe diagonala
                (Symbol.SX == t[0][2]&&Symbol.SX == t[1][1]&&Symbol.SX == t[2][0])) { //verifica egalitate elemente pe diagonala
                winner = true;
                break;
            } else {
                winner = false;
            }
        }
        return winner;
    }
    public boolean hasWon0(){
        boolean winner = true;
        for (int i=0; i<3; ++i) {
            if ((Symbol.SO == t[i][0] && Symbol.SO == t[i][1] && Symbol.SO == t[i][2]) ||
                (Symbol.SO == t[0][i] && Symbol.SO == t[1][i] && Symbol.SO == t[2][i]) ||
                (Symbol.SO == t[0][0] && Symbol.SO == t[1][1] && Symbol.SO == t[2][2]) ||
                (Symbol.SO == t[0][2] && Symbol.SO == t[1][1] && Symbol.SO == t[2][0])) {
                winner = true;
                break;
            } else {
                winner = false;
            }
        }
        return winner;
    }
    public boolean isADraw(){
        boolean draw = true;
        for (int i=0; i<3; ++i){
            for (int j=0; j<3; ++j){
                if (Symbol.S_ == t[i][j]){
                    draw = false;
                }
            }
        }
        return draw;
    }

    public boolean insertNewValue(int rowNum, int colNum, Symbol playerTurn) {
            boolean returnValue = false;
        if (t[rowNum][colNum] == Symbol.S_) {
            if (playerTurn == Symbol.SX) {
                t[rowNum][colNum] = Symbol.SX;
                returnValue = true;
            }
            else{
                t[rowNum][colNum] = Symbol.SO;
                returnValue = true;
            }
        }
        return returnValue;
    }
}

