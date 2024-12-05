package main;

//this is the launch class that the launch .json is set to
//not sure if it really works tho
// might need to add gampanel.run()
public class Main {
    public static void main(String[] args) {
        GamePanel gamePanel = new GamePanel();
        gamePanel.startGameThread();
    }
}
