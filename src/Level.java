import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyAdapter;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class Level {

    Level level;

    public JPanel loadLevel(JPanel gamePanel) throws IOException {
        level = new Level();
        JButton[][] levelButtons = new JButton[20][20];
        Border emptyBorder = BorderFactory.createEmptyBorder();
        String[][] levelMapText = new Level().getLevelMapArray(1);
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                levelButtons[i][j] = new JButton();
                levelButtons[i][j].setBackground(null);
                levelButtons[i][j].setMargin(new Insets(0, 0, 0, 0));

                levelButtons[i][j].setBorder(emptyBorder);
                Icon tempIcon = getCorrespondingIcon(levelMapText[i][j]);
                int finalI = i;
                int finalJ = j;
                levelButtons[i][j].addKeyListener(
                        new KeyAdapter() {

                            @Override
                            public void keyPressed(KeyEvent e) {
                                int keyCode = e.getKeyCode();
                                switch (keyCode) {
                                    case KeyEvent.VK_UP:
                                        levelButtons[finalI -1][finalJ].setIcon(levelButtons[finalI][finalJ].getIcon());
                                        levelButtons[finalI -1][finalJ].requestFocus();
                                        levelButtons[finalI][finalJ].setIcon(GameIcons.emptyIcon);
                                        levelButtons[finalI][finalJ].setFocusPainted(false);
                                        // handle up
                                        break;

                                    case KeyEvent.VK_DOWN:
                                        levelButtons[finalI +1][finalJ].setIcon(levelButtons[finalI][finalJ].getIcon());
                                        levelButtons[finalI +1][finalJ].requestFocus();
                                        levelButtons[finalI][finalJ].setIcon(GameIcons.emptyIcon);
                                        levelButtons[finalI][finalJ].setFocusPainted(false);
                                        // handle down
                                        break;

                                    case KeyEvent.VK_LEFT:
                                        levelButtons[finalI][finalJ -1].setIcon(levelButtons[finalI][finalJ].getIcon());
                                        levelButtons[finalI][finalJ - 1].requestFocus();
                                        levelButtons[finalI][finalJ].setIcon(GameIcons.emptyIcon);
                                        levelButtons[finalI][finalJ].setFocusPainted(false);
                                        // handle left
                                        break;

                                    case KeyEvent.VK_RIGHT:
                                        levelButtons[finalI][finalJ + 1].setIcon(levelButtons[finalI][finalJ].getIcon());
                                        levelButtons[finalI][finalJ + 1].requestFocus();
                                        levelButtons[finalI][finalJ].setIcon(GameIcons.emptyIcon);
                                        levelButtons[finalI][finalJ].setFocusPainted(false);


                                        // handle right
                                        break;
                                }
                            }


                        });
                if (Objects.equals(tempIcon, GameIcons.playerIcon)) {


                }
                levelButtons[i][j].setIcon(tempIcon);
                gamePanel.add(levelButtons[i][j]);
            }
        }
        return gamePanel;
    }

    private Icon getCorrespondingIcon(String currentMapText) {

        switch (currentMapText) {

            case "0":
                return GameIcons.lightBoulderIcon;

            case "#":
                return GameIcons.grassIcon;

            case "$":
                return GameIcons.coinIcon;

            case "-":
                return GameIcons.emptyIcon;

            case "w":
                return GameIcons.wallIcon;

            case "p":
                return GameIcons.playerIcon;

            case "*":
                return GameIcons.doubleCoinIcon;

            case "@":
                return GameIcons.heavyBoulderIcon;

            default:
                return null;
        }
    }


    public String[][] getLevelMapArray(int level) throws IOException {

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(
                "maps/level-one.txt");

        assert inputStream != null;

        InputStreamReader isr = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(isr);

        String[][] map = new String[20][20];
        String[] tempArray = new String[20];
        String singleLineString = "";

        for (int r = 0; r < 20; r++) {
            tempArray[r] = bufferedReader.readLine();//this gives full line
            singleLineString = singleLineString.concat(tempArray[r]);//makes array to single line
        }
        bufferedReader.close();

        for (int x = 0; x < 20; x++) {
            for (int y = 0; y < 20; y++) {
                map[x][y] = String.valueOf(singleLineString.charAt(x * 20 + y));
            }
        }

        return map;

    }


}
