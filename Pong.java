// https://www.youtube.com/watch?v=xIqeK2hzx1I&ab_channel=Krohn-Education
import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Pong extends Applet implements Runnable, KeyListener {
    final int WIDTH = 700;
    final int HEIGHT = 500;
    Thread thread;
    HumanPaddle p1;
    RobotPaddle p2;
    Ball b1;
    boolean startGame;
    Graphics gfx;
    Image img;



    public void init() {
        this.resize(WIDTH, HEIGHT);
        startGame = false;
        this.addKeyListener(this);
        p1 = new HumanPaddle(1);
        b1 = new Ball();
        p2 = new RobotPaddle(2, b1);
        img = createImage(WIDTH,HEIGHT);
        gfx = img.getGraphics();
        thread = new Thread(this);
        thread.start();
    }

    public void paint(Graphics g) {
        gfx.setColor(Color.BLACK);
        gfx.fillRect(0, 0, WIDTH, HEIGHT);

        if(b1.getX() < -10 || b1.getX() > 710){
            gfx.setColor(Color.red);
            gfx.drawString("Game Over", 350, 250);
        }
        else {
            p1.draw(gfx);
            p2.draw(gfx);
            b1.draw(gfx);
        }

        if(!startGame){
            g.setColor(Color.white);
            g.drawString("PONG", 340,100);
            g.drawString("PRESS ENTER TO PLAY", 290, 130);
        }

        g.drawImage(img, 0, 0, this);
    }

    public void update(Graphics g) {
        paint(g);
    }

    public void run() {
        for (; ; ) {

            if(startGame) {
                p1.move();
                p2.move();
                b1.move();
                b1.checkPaddleCollision(p1, p2);
            }


            // Infinite Loop that Runs this Game
            repaint();
            try {
                // Every 10ms you will see the ball
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
            p1.setUpAccel(true);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
            p1.setDownAccel(true);
        }
        else if(e.getKeyCode() == KeyEvent.VK_ENTER){
            startGame = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
            p1.setUpAccel(false);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
            p1.setDownAccel(false);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
