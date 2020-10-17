import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    public GameFrame() {
        this.setSize(1100, 710);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
    }

    public JPanel getGamePanel() {
        JPanel gamePanel;
        gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(20, 20));
        gamePanel.setBackground(new Color(0, 0, 0));
        gamePanel.setBounds(0, 0, 800, 710);
        return gamePanel;
    }

/*
    public JPanel getGameInfoPanel() {
        JPanel gameInfoPanel;

        gameInfoPanel = new JPanel();
        gameInfoPanel.setLayout(new FlowLayout());
        gameInfoPanel.setBackground(new Color(207, 212, 209));
        gameInfoPanel.setBounds(805,0,300,680);

        Player player;

        JLabel currentScore = new JLabel("Score");
        player = new Player();
        player.setScore(5433);
        currentScore.setFont(new Font("Arial", Font.PLAIN,15));
        currentScore.setText(String.valueOf(player.getScore()));
        gameInfoPanel.add(currentScore);

        JLabel nameText = new JLabel("Name");
        gameInfoPanel.setName("Sujata");
        nameText.setFont(new Font("Arial", Font.PLAIN,15));
        nameText.setText(gameInfoPanel.getName());
        gameInfoPanel.add(nameText);

        JLabel highScore = new JLabel("Highest Score");
        player.setHighScore(22000);
        highScore.setFont(new Font("Arial", Font.PLAIN,15));
        highScore.setText(player.getHighScore());
        gameInfoPanel.add(highScore);

        return gameInfoPanel;
    }*/
}
