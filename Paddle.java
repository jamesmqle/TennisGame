import java.awt.*;

/**
 * Created by James Le on 12/10/2020.
 */
public interface Paddle {
    public void draw(Graphics g);
    public void move();
    public int getY();
}
