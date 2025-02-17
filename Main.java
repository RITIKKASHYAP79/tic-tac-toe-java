package game.tic_tac_toe;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("Enter 1 : for play With Computer");
        System.out.println("Enter 2 : for play With Your Friend");
        System.out.print("Enter Your Choice : ");
        Scanner Sc=new Scanner(System.in);
        String player1;
        String player2;
        try{
            int userChoice = Sc.nextInt();
            switch (userChoice){
                case 1:
                    System.out.print("Enter Your Name : ");
                    player1=Sc.next();
                    PlayWithComputer cp = new PlayWithComputer(player1);
                    cp.start();
                    break;
                case 2:
                    System.out.println("2");
                    System.out.print("Enter Player-1 Name : ");
                    player1=Sc.next();

                    System.out.print("Enter Player-2 Name : ");
                    player2=Sc.next();
                    TwoPlayer tp = new TwoPlayer(player1,player2);
                    tp.start();
                    break;
                default:
                    System.out.println("Wrong Value Entered!! Enter Only 1 & 2");
            }
        }
        catch (Exception e){
            System.out.println("Error !!!!----- Enter Only Integers 1 & 2-----!!!!");
        }
    }
}
