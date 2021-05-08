import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;

public class planet extends Thread{

    final BigDecimal sunMass = new BigDecimal(1.98847*Math.pow(10,30));

    //the traditional Big G value of 6.674 * Math.pow(10,-11) has the wrong units
    final BigDecimal preG = new BigDecimal(6.674 * Math.pow(10,-11));

    final BigDecimal metersInAU = new BigDecimal(149597870700.0);
    final BigDecimal bigG = preG.divide(metersInAU.pow(3),MathContext.DECIMAL128);


    //how many seconds the program will run
    final int LengthOfSim = (int) (31536000*40);
    //time step
    final BigDecimal dt = new BigDecimal(200);

    //Array list that stores the location of the planet over the course of the Simulation
    private ArrayList<BigDecimal[]> path = new ArrayList<BigDecimal[]>();

    //Array list that stores the location of the planet over the course of the Simulation at the end of each day
    private ArrayList<BigDecimal[]> pathDaily = new ArrayList<BigDecimal[]>();


    String name;
    double size;
    BigDecimal mass;
    BigDecimal[] vel;
    BigDecimal[] pos;
    BigDecimal[] acc = new BigDecimal[3];
    BigDecimal gravForce;

    planet(String name, double size, BigDecimal mass, BigDecimal[] pos, BigDecimal[] vel){

        this.name = name;
        this.size = size;
        this.mass = mass;
        this.vel = vel;
        this.pos = pos;

    }

    public void run(){

        for(int time = 0; time<LengthOfSim; time+=dt.intValue()) {

            //determine the next position from the current velocity
            pos[0] = pos[0].add(vel[0].multiply(dt));
            pos[1] = pos[1].add(vel[1].multiply(dt));
            pos[2] = pos[2].add(vel[2].multiply(dt));

            //path.add(pos);

            if(time%86400==0){

                pathDaily.add(new BigDecimal[]{pos[0], pos[1], pos[2]});

                //System.out.println("path vals: "+ path.get(time)[0]+", "+path.get(time)[1]);

            }

            //negate is for the attractive nature of gravity
            gravForce = bigG.multiply(sunMass).multiply(mass).divide(currentRadiusSquared(), MathContext.DECIMAL64).negate();

            //transforming the gravitational force into instantaneous acceleration

            BigDecimal[] unitPosVec = unitPosVector();

            acc[0] = gravForce.divide(mass,MathContext.DECIMAL64).multiply(unitPosVec[0]);
            acc[1] = gravForce.divide(mass,MathContext.DECIMAL64).multiply(unitPosVec[1]);
            acc[2] = gravForce.divide(mass,MathContext.DECIMAL64).multiply(unitPosVec[2]);

            //using euler's method, we adjust the velocity vectors
            //step size of one second
            //POSSIBLE SOURCE OF ERROR: LARGE STEP OF TIME
            vel[0] = vel[0].add(acc[0].multiply(dt));
            vel[1] = vel[1].add(acc[1].multiply(dt));
            vel[2] = vel[2].add(acc[2].multiply(dt));


        }

        System.out.println("end "+ name);
    }


    //returns the current radius from sun to planet squared
    //helpful in gravitational force calculation
    BigDecimal currentRadiusSquared(){

        return pos[0].pow(2).add(pos[1].pow(2)).add(pos[2].pow(2));

    }

    //returns the current radius from sun to planet
    //helpful for determining the unit position vector
    BigDecimal currentRadius(){

        BigDecimal square = pos[0].pow(2).add(pos[1].pow(2)).add(pos[2].pow(2));

        return new BigDecimal(Math.sqrt(square.doubleValue()));

    }


    //returns the unit position vector of the planet
    BigDecimal[] unitPosVector(){

        BigDecimal[] unit = {pos[0].divide(currentRadius(),MathContext.DECIMAL64),pos[1].divide(currentRadius(),MathContext.DECIMAL64),pos[2].divide(currentRadius(),MathContext.DECIMAL64)};

        return unit;

    }

    ArrayList<BigDecimal[]> getPathDaily(){
        return pathDaily;
    }

}
