import java.util.Scanner;

public class Player {
    private Plansa.Symbol playerTurn;
    private Plansa t;
    byte score;

    public Player(String turn, Plansa t) {

        if (turn.compareToIgnoreCase("X") == 0) {
            this.playerTurn = Plansa.Symbol.SX;
        }else if (turn.compareToIgnoreCase("0") == 0) {
            this.playerTurn = Plansa.Symbol.SO;
        }
        this.t = t;
        this.score = 0;
    }

    public boolean nextMove() {
        boolean flag = true;
        int a,b;
        while (flag) {
            System.out.print(Plansa.RESET + "Player " + this.playerTurn + " enter row coordinate: ");
            a = readValidIndex();
            System.out.print(Plansa.RESET + "Player " + this.playerTurn + " enter column coordinate: ");
            b = readValidIndex();
            if (!t.insertNewValue(a,b,this.playerTurn)) {
                System.out.println(Plansa.RESET + "Cell already filled! Try again: ");
            } else flag = false;

        }
        return true;
    }

    private int readValidIndex(){
        Scanner sc=new Scanner(System.in);
        int a;
        while(true){
            a=sc.nextInt();
            if (a>=0 && a<=2)
                break;
            else
                System.out.println(Plansa.RESET + "Wrong coordinate! Try again: ");
        }
        return a;
    }
   
}
