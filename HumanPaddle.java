import java.awt.*;

/**
 * Created by James Le on 12/10/2020.
 */
public class HumanPaddle implements Paddle {

    double y; // Position of paddle in applet
    double yVel;
    boolean upAccel, downAccel; // Move faster, move slower
    int player; // Player number
    int x; // Position of paddle in applet
    final double GRAVITY = 0.94;

    public HumanPaddle(int player) {
        upAccel = false;
        downAccel = false;
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
        if (upAccel) {
            yVel -= 2;
        } else if (downAccel) {
            yVel += 2;
        } else if (!upAccel && !downAccel) {
            yVel *= GRAVITY;
        }

        if (yVel >=5){
            yVel = 5;
        }
        else if(yVel <= -5){
            yVel = -5;
        }
        y += yVel;

        if(y < 0){
            y = 0;
        }

        if(y > 420){
            y = 420;
        }

    }

    public void setUpAccel(boolean upAccel) {
        this.upAccel = upAccel;
    }

    public void setDownAccel(boolean downAccel) {
        this.downAccel = downAccel;
    }

    public int getY() {
        return (int) y;
    }
}
