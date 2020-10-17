import javax.swing.*;
import java.util.Objects;

public class GameIcons {

    static final Icon heavyBoulderIcon = new ImageIcon(Objects.requireNonNull(GameIcons.class.getClassLoader()
            .getResource("resources/coin.png")));
    static final Icon lightBoulderIcon = new ImageIcon(Objects.requireNonNull(GameIcons.class.getClassLoader()
            .getResource("resources/stone.png")));
    static final Icon playerIcon = new ImageIcon(Objects.requireNonNull(GameIcons.class.getClassLoader()
            .getResource("resources/player.png")));
    static final Icon emptyIcon = new ImageIcon(Objects.requireNonNull(GameIcons.class.getClassLoader()
            .getResource("resources/empty.png")));
    static final Icon wallIcon = new ImageIcon(Objects.requireNonNull(GameIcons.class.getClassLoader()
            .getResource("resources/wall.png")));
    static final Icon coinIcon = new ImageIcon(Objects.requireNonNull(GameIcons.class.getClassLoader()
            .getResource("resources/diamond.png")));
    static final Icon doubleCoinIcon = new ImageIcon(Objects.requireNonNull(GameIcons.class.getClassLoader()
            .getResource("resources/diamonds.png")));
    static final Icon grassIcon = new ImageIcon(Objects.requireNonNull(GameIcons.class.getClassLoader()
            .getResource("resources/grass.png")));

}
