package game.tic_tac_toe;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


class PlayWithComputer extends TwoPlayer{
    static ArrayList<Byte> computerChoices = new ArrayList<>(9);

    PlayWithComputer(){
        arrayListInitialize();
    }
    PlayWithComputer(String playerName){
        super("COMPUTER",playerName);
        arrayListInitialize();
    }
    public void arrayListInitialize(){
        for(byte i=1;i<10;i++){
            computerChoices.add(i);
        }
    }



    public byte computerChoiceGenerator() {
        Random rand = new Random();
        int num = 0;
        try {
            int length = computerChoices.size();
            num = rand.nextInt(length);
            return computerChoices.get(num);
        } finally {
            computerChoices.remove(num);
        }
    }

    @Override
    public void gameBegins(){
        displayBoard();
        byte player = chance;  //defines which player move
        byte position;
        Scanner sc = new Scanner(System.in);
        try {
            if (chance == 1) {
                position=computerChoiceGenerator();
                System.out.println("Position Chosen By Computer 'X': "+position);
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
            System.out.println("only integer Allowed from 1-9"+e);
            return;
        }
        BoardElementUpdate(position,player);
    }

    int arr(int i){
        return computerChoices.get(i);
    }


}

