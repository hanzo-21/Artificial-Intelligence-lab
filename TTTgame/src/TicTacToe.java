import java.util.Scanner;

public class TicTacToe {
    char[][] board;
    char PLAYER_1 = 'X';
    char PLAYER_2 = 'O';
    int size;
    char turn;
    boolean isStandard;

    public  TicTacToe(){
        /*
        this initializes the board by declaring at first X is
         the first player and board is filled with " " initially
         */
        this.isStandard = true;
        this.size =3;
        turn = PLAYER_2;
        board = new char[size][size];
        for (int i = 0; i<size ;i++) {
            for (int j = 0; j<size ;j++){
                board[i][j]=' ';
            }
        }
    }

    public void domainExpansion(){
        this.isStandard = false;
        Scanner sc = new Scanner(System.in);
        int size ;
        //to make sure the size of board is more than 3

        do {
            System.out.println("enter size greater than 3");
            size = sc.nextInt();
        } while (size <= 3);

        this.size = size;
        //this is ok since redefining will update board clear
        board = new char[size][size];
        for (int i = 0; i<size ;i++) {
            for (int j = 0; j<size ;j++){
                board[i][j]=' ';
            }
        }
    }

    public  void displayBoard() { // this displays the board in console
        int row = size;
        int coulmn = size;

        System.out.println(turn+"s turn to put the mark");

        for (int j = 0; j < coulmn; j++) {
            System.out.print("--------");
        }
        System.out.println();
        /*
                with each box we check if there exists X or O in box.
                if yes we print it and if no we print it's respective number to give it's input
         */
        int index = 0;
        String numOrXO;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < coulmn; j++) {
                if(board[i][j]!= ' '){
                     numOrXO = String.valueOf(board[i][j]);
                }else {
                     numOrXO = String.valueOf(index);
                }
                System.out.print("|\t"+numOrXO+"\t|");
                index++;
            }
            System.out.println();
            for (int j = 0; j < coulmn; j++) {
                System.out.print("--------");
            }
            System.out.println();
        }
    }

    public char whoseTurn(){
        turn = turn == PLAYER_1 ? PLAYER_2 : PLAYER_1;
        return turn;
    }

    public  void putMark(int boxId){
        int row  = boxId / size;
        int col = boxId % size;
        board[row][col]= turn;
    }

    public  char getMark(int boxId){
        int row = boxId / size;
        int col = boxId % size;
        return board[row][col]; }

    public int maxNumberOfTurn(){
        return size*size;
    }

    public char getWinner(int moveNumber){

        /*
        here there are 2 types of winners
        1: standard game winner that can be called out before finishing all the moves
        2: variation  where all the boxes are
            filled and then winner is decided by counting the number of line made
         */
        if(isStandard){
            //since it is impossible to wun before move 5
            if (moveNumber <5){ return ' ';}
            //for horizontal lines
            for(int x=0; x< size ; x++){
                if(board[x][0] == board[x][1] && board[x][1] == board[x][2] && board[x][0] != ' ' ){
                    return board[x][0];
                }
            }
            //for vertical lines
            for(int x=0; x< size ; x++){
                if(board[0][x] == board[1][x] && board[1][x] == board[2][x] && board[0][x] != ' ' ){
                    return board[0][x];
                }
            }

            //for diagonal line
            if(board[0][0] == board[2][2] && board[2][2] == board[1][1] && board[1][1] != ' '){
                return board[0][0];
            }

            //for anti-diagonal line
            if(board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[1][1] != ' '){
                return board[1][1];
            }
            return ' ';
        }
        else {
            /*
                for this variation we don't need to calculate winnings for
                move number less than max moves. So we just return ' ' for efficiency purposes
             */
            if (moveNumber < maxNumberOfTurn()){return ' ';}
        /*
            for grid of n*m
            we can make this efficient by selecting (x,y)box and concatenation 3 consecutive chars
            horizontal((x,y),(x,y+1),(x,y+2) ) where 0<=x<n-2 and 0<=y<m,
            vertical((x,y),(x+1,y),(x+2,y) ) where 0<=x<n and 0<=y<m-2,
             diagonal((x,y),(x+1,y+1),(x+2,y+2)) where 0<=x<n-2 and 0<=y<m-2 and
             anti diagonal((n-x,m-y),(n-(x+1),m-(y+1)),(n-(x+2),m-(y+2)) where 0<=x<n-2 and 2<=y<m

             for multiple grid grater than 3 it counts the number of lines made and one mark CAN be
             used in marking another line.
             eg: if there are X's  (1,1)(2,2) and (3,3) creating line 1 and another set of
             X's in (3,1) (2,2) and (1,3) creating line 2.
             then both line 1 or line 2 exists even if there is overlapping element (2,2)
         */

            int row=size;
            int coulmn= size;
            int countXWins= 0;
            int countOWins = 0;


            // checking horizontal lines are drawn if any
            for(int x= 0 ; x< row ; x++){
                for(int y =0 ; y < coulmn-2;y++){
                    if(board[x][y] == board[x][y+1] && board[x][y+1] == board[x][y+2] && board[x][y+2] != ' ' ){
                        //someone has made a line
                        if(board[x][y] == PLAYER_1){
                            countXWins++;
                        }else {
                            countOWins++;
                        }
                    }
                }
            }


            // checking vertical lines are made or not
            for(int x= 0 ; x< row-2 ; x++){
                for(int y =0 ; y < coulmn;y++){
                    if(board[x][y] == board[x+1][y] && board[x+1][y] == board[x+2][y] && board[x+2][y] != ' '  ){
                        //someone has made a line
                        if(board[x][y] == PLAYER_1){
                            countXWins++;
                        }else {
                            countOWins++;
                        }
                    }

                }
            }

            // checking diagonal lines are made or not
            for(int x= 0 ; x< row-2 ; x++){
                for(int y =0 ; y < coulmn -2;y++){
                    if(board[x][y] == board[x+1][y+1] && board[x+1][y+1] == board[x+2][y+2] && board[x+2][y+2] != ' ' ){
                        //someone has made a line
                        if(board[x][y] == PLAYER_1){
                            countXWins++;
                        }else {
                            countOWins++;
                        }
                    }

                }
            }

            // checking anti-diagonal lines are made or not
            for(int x=0  ; x<row-2 ; x++){
                for(int y =2 ; y <coulmn  ;y++){
                    if(board[x][y] == board[x+1][y-1] && board[x+1][y-1] == board[x+2][y-2] && board[x+2][y-2] != ' ' ){
                        //someone has made a line
                        if(board[x][y] == PLAYER_1){
                            countXWins++;
                        }else {
                            countOWins++;
                        }
                    }

                }
            }

            System.out.println("wins of X = "+countXWins+ " \n" +
                    "wins of O = " +countOWins);

            if(countXWins>countOWins){
                return PLAYER_1;
            } else if (countOWins>countXWins) {
                return PLAYER_2;
            }else {
                return ' ';
            }
        }

    }
}
