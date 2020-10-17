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

class Level {

    static JButton[][] levelButtons = new JButton[20][20];

    JPanel loadLevel(JPanel gamePanel) throws IOException {
        String[][] levelMapText = new Level().getLevelMapArray(1);
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                Icon tempIcon = getCorrespondingIcon(levelMapText[i][j]);
                levelButtons[i][j] = new PlayingButton(tempIcon,i,j);
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

    private String[][] getLevelMapArray(int level) throws IOException {

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
