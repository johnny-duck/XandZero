public class Main {

    public static void main(String[] args) {
        boolean runGame = true;
        boolean runMenu = true;
        Plansa plansa = new Plansa();
        System.out.println("Choose the coordinates (row and column) in order to submit X or 0." +
                "\nAvailable values for both row and column are between 0,1,2.");
        Player player1 = new Player("X", plansa);
        Player player2 = new Player("0", plansa);
        plansa.showTable();
        while (runGame) {

            player1.nextMove();
            plansa.showTable();
            if (plansa.hasWonX()) {
                System.out.println(Plansa.BLUE + "X a castigat!");
                break;
            } else if (plansa.isADraw()) {
            System.out.println("Is draw!");
            break;
        }
            player2.nextMove();
            plansa.showTable();

             if (plansa.hasWon0()) {
                System.out.println(Plansa.RED + "0 a castigat!");
                break;
            } else if (plansa.isADraw()) {
                System.out.println(Plansa.RESET + "Is draw!");
                break;
            }
        }

    }

}
