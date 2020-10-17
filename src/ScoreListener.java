import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ScoreListener extends KeyAdapter implements ScoreCounter {


    int positionI;
    int positionJ;

    ScoreListener(int positionI, int positionJ) {
        this.positionI = positionI;
        this.positionJ = positionJ;
    }


    @Override
    public void keyPressed(KeyEvent keyEvent) {

        System.out.println("hello");

    }

    @Override
    public int getScore() {
        return 0;
    }

    @Override
    public void setScore() {

    }

    @Override
    public void setHighScore() {

    }

    @Override
    public void getHighScore() {

    }
}
