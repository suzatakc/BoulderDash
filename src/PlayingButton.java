import javax.swing.*;
import java.awt.*;

public class PlayingButton extends JButton {


    private Icon icon;


    PlayingButton(Icon icon, int positionI, int positionJ) {
        this.icon = icon;
        this.setBackground(null);
        this.setMargin(new Insets(0, 0, 0, 0));
        this.setBorder(BorderFactory.createEmptyBorder());
        this.addKeyListener(new MovementListener(positionI,positionJ));
    }


    @Override
    public Icon getIcon() {
        return icon;
    }

    @Override
    public void setIcon(Icon icon) {
        this.icon = icon;
    }


}
