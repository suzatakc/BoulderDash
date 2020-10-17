package utils;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Helper {


    public void fileReader() throws FileNotFoundException {

        String filePath = new File("maps/level-two.txt").getAbsolutePath();
        Scanner scan = new Scanner(filePath);

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            System.out.println("line " + line);
        }
        scan.close();

    }


    public String[][] fileReaderStream(int level) throws IOException {

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(
                "maps/level-two.txt");

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
