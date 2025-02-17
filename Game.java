package game.tic_tac_toe;

/**
 * This Class Contain All necessary Method used for playing the Game
 * @author Ritik kumar
 * @version 1.0
 * @since 2023
 * */
abstract class Game{
    protected String[][] gameBoard = new String[3][3];
    protected String player1;
    protected String player2;

    /**
     * Default Constructor
     */
    public Game(){
        initializeBoardValue();
    }

    //abstract Methods

    /**
     * Method use to check result of Match this is an abstract method
     */
    abstract public boolean result();
    /**
     * Method use to Taking User Choice
     */
    abstract public void gameBegins();
    /**
     * Method use to Update 'x' , 'o' on Board
     */
    abstract public void BoardElementUpdate(int position,byte player);



    /**
     * Contructor for set players Name and initialize gameBoard Value with '-' symbol
     * @param player1
     * @param player2
     */

    public Game(String player1,String player2){
        initializeBoardValue();
        this.player1=player1;
        this.player2=player2;
        System.out.println(this.player1+" Symbol 'X'");
        System.out.println(this.player2+" Symbol 'O'");
    }

    /**
     * Method use to initialize game board Value
     */
    public void initializeBoardValue(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                gameBoard[i][j]="-";
            }
        }
    }

    /**
     * Method for Set Name Of both Player
     * @param player1 Name
     * @param player2 Name
     * these argument are supplied by user
     */
    public void setName(String player1,String player2){
        this.player1=player1;
        this.player2=player2;
    }

    /**
     *Use for get PLayer1 Name
     */
    public String getPlayer1() {
        return this.player1;
    }
    /**
     *Use for get PLayer2 Name
     */
    public String getPlayer2() {
        return this.player2;
    }

    /**
     * This Method is Used to Display TIC TAC TOE Board
     */
    public void displayBoard(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(this.gameBoard[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * Method use to Start Game
     */
    public void start(){
        boolean b=false;
        while(!b){
            b= result();
        }
    }

}

