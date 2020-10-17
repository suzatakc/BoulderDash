import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MovementListener extends ScoreListener implements PlayerMovement {


    public MovementListener(int positionI, int positionJ) {
        super(positionI, positionJ);
    }


    @Override
    public void keyPressed(KeyEvent keyEvent) {

        super.keyPressed(keyEvent);
        int keyCode = keyEvent.getKeyCode();
        if (isButtonMovable()) {

            switch (keyCode) {
                case KeyEvent.VK_UP:
                    handleUp();
                    // handle up
                    break;

                case KeyEvent.VK_DOWN:
                    handleDown();
                    // handle down
                    break;

                case KeyEvent.VK_LEFT:
                    handleLeft();
                    // handle left
                    break;

                case KeyEvent.VK_RIGHT:
                    handleRight();
                    // handle right
                    break;
            }

        }
    }


    private Boolean isButtonMovable() {
        return Level.levelButtons[positionI][positionJ].getIcon().equals(GameIcons.playerIcon);
    }


    private Boolean playerCanMoveInDirection(int keyCode) {
        String iconToCheck = null;
        switch (keyCode) {
            case KeyEvent.VK_UP:
                iconToCheck = Level.levelButtons[this.positionI - 1][this.positionJ].getIcon().toString();
                break;

            case KeyEvent.VK_DOWN:
                iconToCheck = Level.levelButtons[this.positionI + 1][this.positionJ].getIcon().toString();
                break;

            case KeyEvent.VK_LEFT:
                iconToCheck = Level.levelButtons[this.positionI][this.positionJ + -1].getIcon().toString();
                break;

            case KeyEvent.VK_RIGHT:
                iconToCheck = Level.levelButtons[this.positionI][this.positionJ + 1].getIcon().toString();
                break;
        }
        assert iconToCheck != null;
        return !iconToCheck.equals(GameIcons.wallIcon.toString()) &&
                !iconToCheck.equals(GameIcons.lightBoulderIcon.toString()) &&
                !iconToCheck.equals(GameIcons.heavyBoulderIcon.toString());

    }


    @Override
    public void handleLeft() {
        if (positionJ > 0 && playerCanMoveInDirection(KeyEvent.VK_LEFT)) {
            Level.levelButtons[positionI][positionJ - 1].setIcon(Level.levelButtons[positionI][positionJ].getIcon());
            Level.levelButtons[positionI][positionJ - 1].requestFocus();
            Level.levelButtons[positionI][positionJ].setIcon(GameIcons.emptyIcon);
            Level.levelButtons[positionI][positionJ].setFocusPainted(false);
        }

    }

    @Override
    public void handleRight() {

        if (playerCanMoveInDirection(KeyEvent.VK_RIGHT)) {
            Level.levelButtons[positionI][positionJ + 1].setIcon(Level.levelButtons[positionI][positionJ].getIcon());
            Level.levelButtons[positionI][positionJ + 1].requestFocus();
            Level.levelButtons[positionI][positionJ].setIcon(GameIcons.emptyIcon);
            Level.levelButtons[positionI][positionJ].setFocusPainted(false);
        }

    }

    @Override
    public void handleUp() {
        if (playerCanMoveInDirection(KeyEvent.VK_UP)) {
            Level.levelButtons[positionI - 1][positionJ].setIcon(Level.levelButtons[positionI][positionJ].getIcon());
            Level.levelButtons[positionI - 1][positionJ].requestFocus();
            Level.levelButtons[positionI][positionJ].setIcon(GameIcons.emptyIcon);
            Level.levelButtons[positionI][positionJ].setFocusPainted(false);
        }
    }

    @Override
    public void handleDown() {
        if (playerCanMoveInDirection(KeyEvent.VK_DOWN)) {
            Level.levelButtons[positionI + 1][positionJ].setIcon(Level.levelButtons[positionI][positionJ].getIcon());
            Level.levelButtons[positionI + 1][positionJ].requestFocus();
            Level.levelButtons[positionI][positionJ].setIcon(GameIcons.emptyIcon);
            Level.levelButtons[positionI][positionJ].setFocusPainted(false);
        }
    }
}
