import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;


public class visualComponent extends JComponent{

    int[] center = new int[2];

    public void setBodies(planet[] input) {
        bodies = input;
    }

    planet[] bodies;

    //The radial dimension of the frame in Astronomical Units.
    BigDecimal Scaling = new BigDecimal(3);


    ArrayList<BigDecimal[]>[] bodyPathAU;
    ArrayList<Integer[]>[] onePathPix;


    visualComponent(int width, int height, planet[] planets, int bodyCount){

        center[0] = width/2;
        center[1] = height/2;
        this.bodies = planets;

        onePathPix = new ArrayList[bodyCount];
        bodyPathAU = new ArrayList[bodyCount];
    }

    public void paintComponent(Graphics g){

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.WHITE);

        Ellipse2D.Double sun = new Ellipse2D.Double(center[0]-5,center[1]-5,10,10);

        g2.fill(sun);

        //take in all planet data

        for(int i = 0; i<bodies.length; i++){
            bodyPathAU[i] = bodies[i].getPathDaily();
            onePathPix[i] = new ArrayList<>();
        }

        //holder for the current point converted to Pixels
        Integer[] currentPoint = new Integer[3];

        //holds the length of the bodyPathAU array
        int length;

        //convert AUs to Pixels and show dots
        //bindex : body index
        //ith point in array
        for(int bindex = 0; bindex<bodies.length; bindex++){

            if(bodies[bindex].name.equals("Mars")){
                g2.setColor(Color.RED);
            } else if(bodies[bindex].name.equals("Earth")){
                g2.setColor(Color.BLUE);
            } else if(bodies[bindex].name.equals("Venus")){
                g2.setColor(Color.ORANGE);
            } else if(bodies[bindex].name.equals("Mercury")){
                g2.setColor(Color.GRAY);
            }else if(bodies[bindex].name.equals("Jupiter")){
                g2.setColor(new Color(165, 69, 46));
            }else if(bodies[bindex].name.equals("Saturn")){
                g2.setColor(Color.YELLOW);
            }else if(bodies[bindex].name.equals("Psyche")) {
                g2.setColor(Color.WHITE);
            }else if(bodies[bindex].name.equals("Tempel 1")) {
                g2.setColor(Color.WHITE);
            }else if(bodies[bindex].name.equals("Ceres")){
                g2.setColor(Color.CYAN);
            }else if(bodies[bindex].name.equals("Uranus")){
                g2.setColor(Color.blue);
            }else if(bodies[bindex].name.equals("Churyumov-Gerasimenko")){
                g2.setColor(Color.LIGHT_GRAY);
            }else if(bodies[bindex].name.equals("Vesta")){
                g2.setColor(Color.green);
            }else if(bodies[bindex].name.equals("Hygiea")){
                g2.setColor(new Color(160,0,192));
            }else if(bodies[bindex].name.equals("Bennu")){
                g2.setColor(Color.pink);
            }

            length = bodyPathAU[bindex].size();

            for(int i = 0; i<length;i++){

                currentPoint[0] = AUtoPixel(bodyPathAU[bindex].get(i)[0]);
                currentPoint[1] = AUtoPixel(bodyPathAU[bindex].get(i)[1]);
                currentPoint[2] = AUtoPixel(bodyPathAU[bindex].get(i)[2]);

                onePathPix[bindex].add(currentPoint);

                g2.drawLine(onePathPix[bindex].get(i)[0]+center[0],onePathPix[bindex].get(i)[1]+center[1],onePathPix[bindex].get(i)[0]+center[0],onePathPix[bindex].get(i)[1]+center[1]);

                //Debugging prints
                //System.out.println("bodyPathAU vals: "+ bodyPathAU.get(i)[0]+", "+bodyPathAU.get(i)[1]);
                //System.out.println("current point: "+currentPoint[0]+", "+currentPoint[1]);
                //System.out.println(onePathPix.get(i));
                //System.out.println("Pixel loc: "+onePathPix.get(i)[0]+", "+ onePathPix.get(i)[1]);
                //System.out.println("Pixel array len: "+ onePathPix.size()+", "+bodyPathAU.size());
            }

            g2.drawString(bodies[bindex].name,onePathPix[bindex].get(length-1)[0]+center[0],onePathPix[bindex].get(length-1)[1]+center[1]);

        }


    }

    int AUtoPixel(BigDecimal AU){

        int boxSize=0;

        if(center[1]>center[0]){
            boxSize=center[0];
        }else{
            boxSize=center[1];
        }

        return AU.divide(Scaling, MathContext.DECIMAL64).multiply(new BigDecimal(boxSize)).intValue();

    }



    void resize(mainFrame Frame){
        center[0] = Frame.getWidth()/2;
        center[1] = Frame.getHeight()/2;
    }

}
