import java.util.Scanner;

public class TTTGame {
    TicTacToe game = new TicTacToe(); // for all ttt related tasks
    char winner;

    TTTGame(){
        winner = ' ';
    }

    public void startGame(){
        Scanner sn = new Scanner(System.in);
        System.out.println("""
                Choose one:
                1: Play a Classical game (3 x 3)
                2: Play a n X n game
                """);
        //to make sure correct input in entered
        int choice;
        while (true){
            choice = sn.nextInt();
            if(choice == 1 || choice ==2 ){
                break;
            }
            else {
                System.out.println("Wrong choice: enter 1 or 2");
            }
        }

        if(choice == 2){
            game.domainExpansion();
        }

        game.displayBoard();
        playGame();
        printMessage();
    }

    public void playGame(){
        Scanner in = new Scanner(System.in);
        int moveNumber =1;
        int maxMoves = game.maxNumberOfTurn();
        char turn;
        int boxId;

        /*
        while no one has won or drawn a game yet
        and needs to mark all the boxes and then calculate winner
         */
        while ( winner == ' ' && moveNumber <= maxMoves){
            turn = game.whoseTurn();
            System.out.println(turn+"'s turn . enter the number you want to put your mark");
            do{
                boxId = in.nextInt();
            }while (game.getMark(boxId) != ' ');
            /*
            is the cell empty?
            if yes we choose another one;
             */

            game.putMark(boxId);
            game.displayBoard();
            winner = game.getWinner(moveNumber);

            moveNumber++;
        }
        in.close();
    }

    public void printMessage() {
        if (winner == 'X' || winner == 'O') {
            System.out.println(winner + " has WON the game");
        } else {
            System.out.println("It's a draw");
        }
    }
}
