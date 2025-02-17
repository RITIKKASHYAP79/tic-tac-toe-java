package game.tic_tac_toe;
import java.util.Scanner;


//If User Enter 0 Than this Exception Will Work
class InvalidInput extends Exception{
    @Override
    public String toString() {
        return "Zero not Allowed! only 1-9 is valid";
    }
}


class TwoPlayer extends Game {
    public static byte chance=1;
    public static byte endGame=0;
    TwoPlayer(){}
    TwoPlayer(String player1,String player2){
        super(player1,player2);
    }


    //Function for Set Chance Value
    private void setChance(byte num){
        chance=num;
    }

    //Function Update Endgame Variable

    private void setEndGame(){
        endGame++;
    }


    /*  ========================= Begins our Game =======================*/
    public void gameBegins(){
        /* 1->player1 chance (X)
        2->player2 chance (O) */
        displayBoard();
        byte player = chance;  //defines which player move
        byte position;
        Scanner sc = new Scanner(System.in);
        try {
            if (chance == 1) {
                System.out.print(this.player1 + " Enter position 'X' : ");
                //->error if enter 0
                position = sc.nextByte();
                if(position==0){
                    throw new InvalidInput();
                }
                chance++;
            }else{
                System.out.print(this.player2 + " Enter position 'O': ");
                position = sc.nextByte();
                if(position==0){
                    throw new InvalidInput();
                }
                chance--;
            }

        }
        catch(InvalidInput e){
            System.out.println(e);
            return;
        }
        catch(Exception e){
            System.out.println("only integer Allowed from 1-9");
            return;
        }
        BoardElementUpdate(position,player);
    }

    /* ============= Update Element on Board ========================= */
    public void BoardElementUpdate(int position,byte player){
        String symbol = switch (player) {
            case 1 -> "X";
            case 2 -> "O";
            default -> "-";
        };
        if(position<=3){
            position--;
            if(positionFilled(0, position)) {
                this.gameBoard[0][position] = symbol;
                setEndGame();
            }
            else{setChance(player);}
        }
        else if(position<=6){
            position=position-4;
            if(positionFilled(1, position)) {
                this.gameBoard[1][position] = symbol;
                setEndGame();
            }else{setChance(player);}

        }else if(position<=9){
            position=position-7;
            if(positionFilled(2, position)) {
                this.gameBoard[2][position] = symbol;
                setEndGame();
            }else{setChance(player);}

        }
        else{
            System.out.println("Error occurred");
        }

    }


    //============== This Method Check user Enter Position is Empty or Not
    public boolean positionFilled(int first, int second){
        if(gameBoard[first][second].equals("X") || gameBoard[first][second].equals("O")){
            System.out.println("Position Already Filled by : "+gameBoard[first][second]+"-Symbol");
            return false;
        }
        return true;
    }

    //=============== Function for Taking Match Decision ===============
    public boolean result(){
        if(gameBoard[0][0].equals("X") && gameBoard[0][1].equals("X") && gameBoard[0][2].equals("X") || gameBoard[1][0].equals("X") && gameBoard[1][1].equals("X") && gameBoard[1][2].equals("X") ||gameBoard[2][0].equals("X") && gameBoard[2][1].equals("X") && gameBoard[2][2].equals("X")){

            System.out.println("=========== Game Result ==========");
            displayBoard();
            System.out.println(getPlayer1()+" Wins the Match");
            return true;
        }
        else if(gameBoard[0][0].equals("X") && gameBoard[1][0].equals("X") && gameBoard[2][0].equals("X") || gameBoard[0][1].equals("X") && gameBoard[1][1].equals("X") && gameBoard[2][1].equals("X") ||gameBoard[0][2].equals("X") && gameBoard[1][2].equals("X") && gameBoard[2][2].equals("X")){

            System.out.println("=========== Game Result ==========");
            displayBoard();
            System.out.println(getPlayer1()+" Wins the Match");
            return true;
        }
        else if(gameBoard[0][2].equals("X") && gameBoard[1][1].equals("X") && gameBoard[2][0].equals("X") || gameBoard[0][0].equals("X") && gameBoard[1][1].equals("X") && gameBoard[2][2].equals("X")){

            System.out.println("=========== Game Result ==========");
            displayBoard();
            System.out.println(getPlayer1()+" Wins the Match");
            return true;
        }
        else if(gameBoard[0][0].equals("O") && gameBoard[0][1].equals("O") && gameBoard[0][2].equals("O") || gameBoard[1][0].equals("O") && gameBoard[1][1].equals("O") && gameBoard[1][2].equals("O") ||gameBoard[2][0].equals("O") && gameBoard[2][1].equals("O") && gameBoard[2][2].equals("O")){

            System.out.println("=========== Game Result ==========");
            displayBoard();
            System.out.println(getPlayer2()+" Wins the Match");
            return true;
        }
        else if(gameBoard[0][0].equals("O") && gameBoard[1][0].equals("O") && gameBoard[2][0].equals("O") || gameBoard[0][1].equals("O") && gameBoard[1][1].equals("O") && gameBoard[2][1].equals("O") ||gameBoard[0][2].equals("O") && gameBoard[1][2].equals("O") && gameBoard[2][2].equals("O")){

            System.out.println("=========== Game Result ==========");
            displayBoard();
            System.out.println(getPlayer2()+" Wins the Match");
            return true;
        }
        else if(gameBoard[0][2].equals("O") && gameBoard[1][1].equals("O") && gameBoard[2][0].equals("O") || gameBoard[0][0].equals("O") && gameBoard[1][1].equals("O") && gameBoard[2][2].equals("O")){
            System.out.println("=========== Game Result ==========");
            displayBoard();
            System.out.println(getPlayer2()+" Wins the Match");
            return true;
        }
        else{
            if(endGame>=9){
                displayBoard();
                System.out.println("--------- Match Draw ------------");
                return true;
            }
            else{
                gameBegins();
            }
        }
        return false;
    }



}

