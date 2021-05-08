import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

public class Main {

    public static void main(String Args[]) throws InterruptedException {

        mainFrame frame = new mainFrame();

        int width = 1000;
        int height =1000;

        frame.setVisible(true);
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);

        //Earth: Updated 5,6,2021
        //earthVel is in AU/s
        //form {vx,vy,vz}
        BigDecimal[] earthVel = {new BigDecimal(-1.816657950941335*Math.pow(10,-4)/86400), new BigDecimal(-1.726932971123399*Math.pow(10,-2)/86400), new BigDecimal(2.257892116811386*Math.pow(10,-7)/86400)};

        //earthPos is in AU
        //form {x,y,z}s
        BigDecimal[] earthPos = {new BigDecimal(-9.960545887189293*Math.pow(10,-1)),new BigDecimal(-5.358185480168110*Math.pow(10,-3)), new BigDecimal(2.257892116811386*Math.pow(10,-7))};

        //mass of earth in BigDecimal form
        BigDecimal earthMass = new BigDecimal(5.972*Math.pow(10,24));

        planet earth = new planet("Earth",8.52699302*Math.pow(10,-5), earthMass,earthPos, earthVel);


        //Mars
        //marsVel is in AU/s
        //form {vx,vy,vz}
        BigDecimal[] marsVel = {new BigDecimal(1.330877090595533*Math.pow(10,-2)/86400), new BigDecimal(6.881718300222293*Math.pow(10,-3)/86400), new BigDecimal(-1.821940074064081*Math.pow(10,-4)/86400)};

        //marsPos is in AU
        //form {x,y,z}s
        BigDecimal[] marsPos = {new BigDecimal(5.684521981271590*Math.pow(10,-1)),new BigDecimal(-1.283224167889625*Math.pow(10,0)), new BigDecimal(-4.104746166973694*Math.pow(10,-2))};

        //mass of mars in BigDecimal form
        BigDecimal marsMass = new BigDecimal(6.4171*Math.pow(10,23));

        planet mars = new planet("Mars",2.27021279e-5*Math.pow(10,-5), marsMass,marsPos, marsVel);

        //Venus
        BigDecimal[] venusVel = {new BigDecimal(1.781107508517901*Math.pow(10,-2)/86400), new BigDecimal(-9.399799080315246*Math.pow(10,-3)/86400), new BigDecimal(-1.157000534644433*Math.pow(10,-3)/86400)};

        //marsPos is in AU
        //form {x,y,z}s
        BigDecimal[] venusPos = {new BigDecimal(-3.385770311369931*Math.pow(10,-1)),new BigDecimal(-6.366543345031342*Math.pow(10,-1)), new BigDecimal(1.047301061958822*Math.pow(10,-2))};

        //mass of mars in BigDecimal form
        BigDecimal venusMass = new BigDecimal(48.685*Math.pow(10,23));

        planet venus = new planet("Venus",4.045440601*Math.pow(10,-5), venusMass,venusPos, venusVel);

        //Mercury
        BigDecimal[] mercVel = {new BigDecimal(-8.662430105106178*Math.pow(10,-3)/86400), new BigDecimal(-2.678931643201406*Math.pow(10,-2)/86400), new BigDecimal(-1.394665242870491*Math.pow(10,-3)/86400)};

        //marsPos is in AU
        //form {x,y,z}s
        BigDecimal[] mercPos = {new BigDecimal(-3.809442126698300*Math.pow(10,-1)),new BigDecimal(4.472992983627792*Math.pow(10,-2)), new BigDecimal(3.762253173305017*Math.pow(10,-2))};

        //mass of mars in BigDecimal form
        BigDecimal mercMass = new BigDecimal(3.302*Math.pow(10,23));

        planet mercury = new planet("Mercury",1.63104*Math.pow(10,-5), mercMass,mercPos, mercVel);


        //Jupiter
        BigDecimal[] jupVel = {new BigDecimal(7.082623965979344*Math.pow(10,-3)/86400), new BigDecimal(2.696224262741128*Math.pow(10,-3)/86400), new BigDecimal(-1.696027617478520*Math.pow(10,-4)/86400)};

        //marsPos is in AU
        //form {x,y,z}s
        BigDecimal[] jupPos = {new BigDecimal(1.599500252145021*Math.pow(10,0)),new BigDecimal(-4.911114348272862*Math.pow(10,0)), new BigDecimal(-1.541438913375052*Math.pow(10,-2))};

        //mass of mars in BigDecimal form
        BigDecimal jupMass = new BigDecimal(1898.13*Math.pow(10,24));

        planet jupiter = new planet("Jupiter",0.0004778945, jupMass,jupPos, jupVel);

        //Saturn
        BigDecimal[] satVel = {new BigDecimal(4.672855556641447*Math.pow(10,-3)/86400), new BigDecimal(2.492254622600291*Math.pow(10,-3)/86400), new BigDecimal(-2.293596972896772*Math.pow(10,-4)/86400)};

        //marsPos is in AU
        //form {x,y,z}s
        BigDecimal[] satPos = {new BigDecimal(4.498956325151465*Math.pow(10,0)),new BigDecimal(-8.941076384330639*Math.pow(10,0)), new BigDecimal(-2.364033752480332*Math.pow(10,-4))};

        //mass of mars in BigDecimal form
        BigDecimal satMass = new BigDecimal(5.6834*Math.pow(10,26));

        planet saturn = new planet("Saturn",0.0004028667, satMass,satPos, satVel);

        //psyche
        BigDecimal[] psyVel = {new BigDecimal(-5.156805886265395*Math.pow(10,-3)/86400), new BigDecimal(1.026870012836251*Math.pow(10,-2)/86400), new BigDecimal(-3.421253732588835*Math.pow(10,-4)/86400)};

        //marsPos is in AU
        //form {x,y,z}s
        BigDecimal[] psyPos = {new BigDecimal(2.240989798569138*Math.pow(10,0)),new BigDecimal(1.178496943566039*Math.pow(10,0)), new BigDecimal(-1.155256768284712*Math.pow(10,-1))};

        //mass of mars in BigDecimal form
        BigDecimal psyMass = new BigDecimal(2.72*Math.pow(10,19));

        planet psyche = new planet("Psyche",7.520161*Math.pow(10,-7), psyMass,psyPos, psyVel);

        //Tempel 1
        BigDecimal[] temVel = {new BigDecimal(-5.844158652134035*Math.pow(10,-3)/86400), new BigDecimal(-3.117255434317874*Math.pow(10,-3)/86400), new BigDecimal(7.968007923161865*Math.pow(10,-4)/86400)};

        //marsPos is in AU
        //form {x,y,z}s
        BigDecimal[] temPos = {new BigDecimal(-3.328610336751404*Math.pow(10,-1)),new BigDecimal(4.256656491132880*Math.pow(10,0)), new BigDecimal(3.414208815635374*Math.pow(10,-1))};

        //mass of mars in BigDecimal form
        BigDecimal temMass = new BigDecimal(1.25*Math.pow(10,14));

        planet tempel1 = new planet("Tempel 1",4.01266*Math.pow(10,-8), temMass, temPos, temVel);

        //Ceres: updated 5,6,2021
        BigDecimal[] ceresVel = {new BigDecimal(9.201724467227128*Math.pow(10,-3)/86400), new BigDecimal(3.370381135398406*Math.pow(10,-3)/86400), new BigDecimal(-2.850337057661093*Math.pow(10,-4)/86400)};

        //ceresPos is in AU
        //form {x,y,z}s
        BigDecimal[] ceresPos = {new BigDecimal(1.007608869613381*Math.pow(10,0)),new BigDecimal(-2.390064275223502*Math.pow(10,0)), new BigDecimal(-1.332124522752402*Math.pow(10,0))};

        //mass of mars in BigDecimal form
        BigDecimal ceresMass = new BigDecimal(9.1*Math.pow(10,20));

        planet ceres = new planet("Ceres",4.01266*Math.pow(10,-8), ceresMass, ceresPos, ceresVel);

        //Uranus: updated May 6,2021
        BigDecimal[] uranVel = {new BigDecimal(-2.576232837356949*Math.pow(10,-3)/86400), new BigDecimal(2.815391359440297*Math.pow(10,-3)/86400), new BigDecimal(4.363934384475927*Math.pow(10,-5)/86400)};

        //uranPos is in AU
        //form {x,y,z}s
        BigDecimal[] uranPos = {new BigDecimal(1.503261363072133*Math.pow(10,1)),new BigDecimal(1.281727050610649*Math.pow(10,1)), new BigDecimal(-1.471621423038862*Math.pow(10,-1))};

        //mass of uranus in BigDecimal form
        BigDecimal uranMass = new BigDecimal(86.813*Math.pow(10,24));

        planet uranus = new planet("Uranus",4.01266*Math.pow(10,-8), uranMass, uranPos, uranVel);

        //Churyumov-Gerasimenko: updated May 7,2021
        BigDecimal[] churyumovVel = {new BigDecimal(1.703882833223679*Math.pow(10,-3)/86400), new BigDecimal(1.289821146832932*Math.pow(10,-2)/86400), new BigDecimal(6.346737512769741*Math.pow(10,-4)/86400)};

        //uranPos is in AU
        //form {x,y,z}s
        BigDecimal[] churyumovPos = {new BigDecimal(1.668908750610179*Math.pow(10,0)),new BigDecimal(-1.602270060920179*Math.pow(10,0)), new BigDecimal(-1.542652112856749*Math.pow(10,-1))};

        //mass of uranus in BigDecimal form
        BigDecimal churyumovMass = new BigDecimal(9.982*Math.pow(10,12));

        planet churyumov = new planet("Churyumov-Gerasimenko",4.01266*Math.pow(10,-8), churyumovMass, churyumovPos, churyumovVel);

        //Vesta: Updated May 7, 2021
        BigDecimal[] vestaVel = {new BigDecimal(1.438754322734410*Math.pow(10,-3)/86400), new BigDecimal(-1.148546926358715*Math.pow(10,-2)/86400), new BigDecimal(1.683692789839975*Math.pow(10,-4)/86400)};

        //uranPos is in AU
        //form {x,y,z}s
        BigDecimal[] vestaPos = {new BigDecimal(-2.263478874404683*Math.pow(10,0)),new BigDecimal(-9.135703176204282*Math.pow(10,-2)), new BigDecimal(2.781355534383398*Math.pow(10,-1))};

        //mass of uranus in BigDecimal form
        BigDecimal vestaMass = new BigDecimal(2.589*Math.pow(10,20));

        planet vesta = new planet("Vesta",4.01266*Math.pow(10,-8), vestaMass, vestaPos, vestaVel);

        //Hygiea: Updated May 7, 2021
        BigDecimal[] hygieaVel = {new BigDecimal(-4.522511344559952*Math.pow(10,-3)/86400), new BigDecimal(-8.723930259145581*Math.pow(10,-3)/86400), new BigDecimal(-4.282220475804789*Math.pow(10,-4)/86400)};

        //hygieaPos is in AU
        //form {x,y,z}s
        BigDecimal[] hygieaPos = {new BigDecimal(-2.570275680114862*Math.pow(10,0)),new BigDecimal(1.727481667425696*Math.pow(10,0)), new BigDecimal(-1.411707668195178*Math.pow(10,-1))};

        //mass of hygiea in BigDecimal form
        BigDecimal hygieaMass = new BigDecimal(8.67*Math.pow(10,19));

        planet hygiea = new planet("Hygiea",4.01266*Math.pow(10,-8), hygieaMass, hygieaPos, hygieaVel);

        //Bennu: Updated May 7, 2021
        BigDecimal[] bennuVel = {new BigDecimal(-1.323152661619388*Math.pow(10,-2)/86400), new BigDecimal(1.428335023133081*Math.pow(10,-2)/86400), new BigDecimal(1.557832396694937*Math.pow(10,-3)/86400)};

        //bennuPos is in AU
        //form {x,y,z}s
        BigDecimal[] bennuPos = {new BigDecimal(7.279236566986149*Math.pow(10,-1)),new BigDecimal(5.573341589817506*Math.pow(10,-1)), new BigDecimal(5.619134844824320*Math.pow(10,-2))};

        //mass of hygiea in BigDecimal form
        BigDecimal bennuMass = new BigDecimal(7.329*Math.pow(10,10));

        planet bennu = new planet("Bennu",4.01266*Math.pow(10,-8), bennuMass, bennuPos, bennuVel);

        planet[] allBodies = {mars, earth, venus, mercury,jupiter, saturn, psyche, tempel1, ceres, uranus, churyumov, vesta, hygiea, bennu};

        //make each planet a thread

        for(int i = 0; i<allBodies.length; i++){
            allBodies[i].start();
        }

        //Begin the visual component
        visualComponent comp;
        comp = new visualComponent(width, height, allBodies,allBodies.length);

        frame.add(comp);

        while(earth.isAlive()){
            //wait for the thread to end
            Thread.sleep(200);

            comp.setBodies(allBodies);
            comp.resize(frame);


            comp.revalidate();
            comp.repaint();

        }

        comp.setBodies(allBodies);

        comp.revalidate();
        comp.repaint();

        System.out.println("End all");



    }

}
