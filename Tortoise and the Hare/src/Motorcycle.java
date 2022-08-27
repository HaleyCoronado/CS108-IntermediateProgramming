/** Hare class
 *   inherits from abstract Racer class
 */

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class Motorcycle extends Racer
{
    private int speed;
    private Random rand;
    private int moves = 0;
    private int headStart;

    /** Default Constructor: calls Racer default constructor
     */
    public Motorcycle( )
    {
        super( );
    }

    /** Constructor
     *    @param rID   racer Id, passed to Racer constructor
     *    @param rX    x position, passed to Racer constructor
     *    @param rY    y position, passed to Racer constructor
     */
    public Motorcycle( String rID, int rX, int rY )
    {
        super( rID, rX, rY );
    }

    /** move:  calculates the new x position for the racer
     *   motorcycle waits then zooms to end
     */
    public void move( )
    {
        setRandAndSpeed();

        // give the others a head start
        if(moves++ < headStart)
            return;
        moves++;

        setX( getX( ) + speed );
    }
    private void setRandAndSpeed( ) {
        rand = new Random( );
        // the motorcycle is really fast
        speed = rand.nextInt( 20 ) + 5;
        // give the others a head start
        headStart = 65;
    }

    /** draw: draws the motorcycle at current (x, y) coordinate
     *   @param g   Graphics context
     */
    public void draw( Graphics g )
    {
        if (isWinner) {
            morph(g);
        } else {
            int startY = getY( );
            int startX = getX( );

            g.setColor(new Color(255, 0, 0)); // red

//body
            g.fillRect(startX - 30 + 10, startY + 7, 12, 4);
            g.drawLine(startX - 30 + 10, startY + 7, startX - 30 + 10 - 4, startY + 7 - 4);
            g.drawLine(startX - 30 + 10 + 12, startY + 7, startX - 30 + 10 + 12 + 4, startY + 7 - 4);

//wheels
            g.setColor(new Color(0, 0, 0));  // black
            g.fillOval(startX - 27, startY + 10, 10, 10);
            g.fillOval(startX - 13, startY + 10, 10, 10);

            g.setColor(new Color(255, 255, 255));  // white
            g.fillOval(startX - 25, startY + 12, 6, 6);
            g.fillOval(startX - 11, startY + 12, 6, 6);
        }
    }


    // changes colors of the motorcycle
    public void morph(Graphics g) {
        int startY = getY( );
        int startX = getX( );

        g.setColor(new Color(255, 100, 255)); // red

//body
        g.fillRect(startX - 30 + 10, startY + 7, 12, 4);
        g.drawLine(startX - 30 + 10, startY + 7, startX - 30 + 10 - 4, startY + 7 - 4);
        g.drawLine(startX - 30 + 10 + 12, startY + 7, startX - 30 + 10 + 12 + 4, startY + 7 - 4);

//wheels
        g.setColor(Color.yellow);  // yellow
        g.fillOval(startX - 27, startY + 10, 10, 10);
        g.fillOval(startX - 13, startY + 10, 10, 10);

        g.setColor(Color.pink);  // black
        g.fillOval(startX - 25, startY + 12, 6, 6);
        g.fillOval(startX - 11, startY + 12, 6, 6);
    }
}