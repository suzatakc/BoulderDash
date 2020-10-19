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
                iconToCheck = Level.levelButtons[this.positionI][this.positionJ - 1].getIcon().toString();
                break;

            case KeyEvent.VK_RIGHT:
                iconToCheck = Level.levelButtons[this.positionI][this.positionJ + 1].getIcon().toString();
                break;
        }
        assert iconToCheck != null;
        return !iconToCheck.equals(GameIcons.wallIcon.toString()) ;

    }


    @Override
    public void handleLeft() {
        if (positionJ != 0 && playerCanMoveInDirection(KeyEvent.VK_LEFT)) {
            if (Level.levelButtons[positionI][positionJ - 1].getIcon().equals(GameIcons.emptyIcon)
            ) {
                Level.levelButtons[positionI][positionJ - 1].setIcon(GameIcons.playerIcon);
                Level.levelButtons[positionI][positionJ - 1].requestFocus();
                Level.levelButtons[positionI][positionJ].setIcon(GameIcons.emptyIcon);
            }
            if  (
                    Level.levelButtons[positionI][positionJ - 1].getIcon().equals(GameIcons.lightBoulderIcon) &&
                    Level.levelButtons[positionI][positionJ - 2].getIcon().equals(GameIcons.emptyIcon)
            ) {
                Level.levelButtons[positionI][positionJ - 1].setIcon(GameIcons.playerIcon);
                Level.levelButtons[positionI][positionJ - 2].setIcon(GameIcons.lightBoulderIcon);
                Level.levelButtons[positionI][positionJ].setIcon(GameIcons.emptyIcon);
                Level.levelButtons[positionI][positionJ - 2].requestFocus();
                Level.levelButtons[positionI][positionJ - 1].requestFocus();
            }
            if (
                    Level.levelButtons[positionI][positionJ - 1].getIcon().equals(GameIcons.coinIcon) ||
                    Level.levelButtons[positionI][positionJ - 1].getIcon().equals(GameIcons.doubleCoinIcon)||
                    Level.levelButtons[positionI][positionJ - 1].getIcon().equals(GameIcons.grassIcon)
            ) {
                Level.levelButtons[positionI][positionJ - 1].setIcon(GameIcons.playerIcon);
                Level.levelButtons[positionI][positionJ].setIcon(GameIcons.emptyIcon);
                Level.levelButtons[positionI][positionJ - 1].requestFocus();
            }
        }
    }

    @Override
    public void handleRight() {

        if (positionJ != 19 && playerCanMoveInDirection(KeyEvent.VK_RIGHT)) {

            if (Level.levelButtons[positionI][positionJ + 1].getIcon().equals(GameIcons.emptyIcon)) {
                Level.levelButtons[positionI][positionJ + 1].setIcon(GameIcons.playerIcon);
                Level.levelButtons[positionI][positionJ].setIcon(GameIcons.emptyIcon);
                Level.levelButtons[positionI][positionJ + 1].requestFocus();
            }

            if (
                    Level.levelButtons[positionI][positionJ + 1].getIcon().equals(GameIcons.lightBoulderIcon) &&
                            Level.levelButtons[positionI][positionJ + 2].getIcon().equals(GameIcons.emptyIcon)
            ) {
                Level.levelButtons[positionI][positionJ + 1].setIcon(GameIcons.playerIcon);
                Level.levelButtons[positionI][positionJ + 2].setIcon(GameIcons.lightBoulderIcon);
                Level.levelButtons[positionI][positionJ].setIcon(GameIcons.emptyIcon);
                Level.levelButtons[positionI][positionJ + 2].requestFocus();
                Level.levelButtons[positionI][positionJ + 1].requestFocus();
            }
            if (
                    Level.levelButtons[positionI][positionJ + 1].getIcon().equals(GameIcons.coinIcon) ||
                            Level.levelButtons[positionI][positionJ + 1].getIcon().equals(GameIcons.doubleCoinIcon) ||
                            Level.levelButtons[positionI][positionJ + 1].getIcon().equals(GameIcons.grassIcon)
            ) {
                Level.levelButtons[positionI][positionJ + 1].setIcon(GameIcons.playerIcon);
                Level.levelButtons[positionI][positionJ].setIcon(GameIcons.emptyIcon);
                Level.levelButtons[positionI][positionJ + 1].requestFocus();
            }
        }
    }

    @Override
    public void handleUp() {
        if (positionI != 0 && playerCanMoveInDirection(KeyEvent.VK_UP)) {

            if (Level.levelButtons[positionI - 1][positionJ].getIcon().equals(GameIcons.emptyIcon)) {
                Level.levelButtons[positionI - 1][positionJ].setIcon(GameIcons.playerIcon);
                Level.levelButtons[positionI][positionJ].setIcon(GameIcons.emptyIcon);
                Level.levelButtons[positionI - 1][positionJ].requestFocus();
            }
            if (
                    Level.levelButtons[positionI - 1][positionJ].getIcon().equals(GameIcons.coinIcon) ||
                            Level.levelButtons[positionI - 1][positionJ].getIcon().equals(GameIcons.doubleCoinIcon) ||
                            Level.levelButtons[positionI - 1][positionJ].getIcon().equals(GameIcons.grassIcon)
            ) {
                Level.levelButtons[positionI - 1][positionJ].setIcon(GameIcons.playerIcon);
                Level.levelButtons[positionI][positionJ].setIcon(GameIcons.emptyIcon);
                Level.levelButtons[positionI -1][positionJ].requestFocus();
            }
        }
    }

    @Override
    public void handleDown() {

        if (positionI != 19 && playerCanMoveInDirection(KeyEvent.VK_DOWN)) {

            if (Level.levelButtons[positionI + 1][positionJ].getIcon().equals(GameIcons.emptyIcon)) {
                Level.levelButtons[positionI + 1][positionJ].setIcon(GameIcons.playerIcon);
                Level.levelButtons[positionI][positionJ].setIcon(GameIcons.emptyIcon);
                Level.levelButtons[positionI + 1][positionJ].requestFocus();
            }
            if (
                    Level.levelButtons[positionI + 1][positionJ].getIcon().equals(GameIcons.coinIcon) ||
                            Level.levelButtons[positionI + 1][positionJ].getIcon().equals(GameIcons.doubleCoinIcon) ||
                            Level.levelButtons[positionI + 1][positionJ].getIcon().equals(GameIcons.grassIcon)
            ) {
                Level.levelButtons[positionI + 1][positionJ].setIcon(GameIcons.playerIcon);
                Level.levelButtons[positionI][positionJ].setIcon(GameIcons.emptyIcon);
                Level.levelButtons[positionI + 1][positionJ].requestFocus();
            }
        }
    }
}
