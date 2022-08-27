/**  Chicken class
 *    inherits from abstract Racer class
 */

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class Chicken extends Racer
{
    private int speed;
    private Random rand;

    /** Default Constructor: calls Racer default constructor
     */
    public Chicken( )
    {
        super( );
    }

    /** Constructor
     *    @param rID  racer Id, passed to Racer constructor
     *    @param rX    x position, passed to Racer constructor
     *    @param rY    y position, passed to Racer constructor
     */
    public Chicken( String rID, int rX, int rY )
    {
        super( rID, rX, rY );
    }

    /** move:  calculates the new x position for the racer
     *   Chicken move characteristics: crazy
     *      accelerate speed 40% of the time
     *      decelerate 60% of the time
     */
    public void move( )
    {
        setRandAndSpeed();

        if ((rand.nextInt(100) + 1 > 40) && (speed < 5)) {
            speed += 6;
        } else {
            speed -= 6;
        }

        setX(getX() + speed);
        speed = 1;
    }

    /** draw: draws the Chicken at current (x, y) coordinate
     *       @param g   Graphics context
     */
    public void draw( Graphics g ) {
        if (isWinner) {
            morph(g);
        } else {
            int startX = getX();
            int startY = getY();
//legs
            g.setColor(new Color(0, 0, 0)); //black
            g.fillRect(startX - 30 + 5, startY + 20, 3, 7);
            g.fillRect(startX - 30 + 10, startY + 20, 3, 7);


//body
            g.setColor(new Color(153, 102, 0)); // brownish
            g.fillOval(startX - 30, startY + 7, 20, 15);

//head
            g.setColor(new Color(255, 0, 0)); // red
            g.fillRect(startX- 20, startY + 3, 8, 2);

            g.setColor(new Color(153, 102, 0));  // black
            g.fillOval(startX - 25, startY + 1, 10, 10);
        }
    }

    private void setRandAndSpeed() {
        rand = new Random();
        speed = 1;
    }

    // turn the chicken into a smiley face
    public void morph(Graphics g) {
        int startY = getY( );
        int startX = getX( );
        g.setColor(Color.yellow);
        g.fillOval(startX-20, startY-20, 25, 25);
        g.setColor(Color.black);
        g.fillOval(startX-5-9, startY - 13, 5, 5);
        g.fillOval(startX+5-9, startY - 13, 5, 5);
        g.drawArc(startX-17, startY-20,20,20,220,100);
    }
}