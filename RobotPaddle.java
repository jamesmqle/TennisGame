import java.awt.*;

/**
 * Created by James Le on 12/10/2020.
 */
public class RobotPaddle implements Paddle {

    double y; // Position of paddle in applet
    double yVel;
    boolean upAccel, downAccel; // Move faster, move slower
    int player; // Player number
    int x; // Position of paddle in applet
    final double GRAVITY = 0.94;
    Ball b1;

    public RobotPaddle(int player, Ball b) {
        upAccel = false;
        downAccel = false;
        b1 = b;
        y = 210;
        yVel = 0;
        if (player == 1)
            x = 20;
        else
            x = 660;


    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, (int) y, 20, 80);
    }

    // This method will move the paddle by changing the y velocity
    public void move()
    {
        y = b1.getY() - 40;
    }

    public int getY() {
        return (int) y;
    }
}
