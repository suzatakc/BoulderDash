import javax.swing.*;
import java.io.IOException;

public class Game {

    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();
        JPanel gamePanel = gameFrame.getGamePanel();

        Level level = new Level();
        try {
            gamePanel = (level.loadLevel(gamePanel));
        } catch (IOException e) {
            e.printStackTrace();
        }
        gameFrame.add(gamePanel);
        gameFrame.setVisible(true);


    }

    void test() {

    }

}

