package quizzgame;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.util.Random;
import javax.swing.JOptionPane;

public class Quiz extends JFrame {
    JPanel p = new JPanel();
    CardLayout cards = new CardLayout();
    int numQs;
    int wrongs = 0;
    int totals = 0;
    String [][] answers = {
        {"mass of the object.","acceleration of the object.","change in momentum of the object.","rate of change in momentum of the object."},
        {"the universe is expanding.","the galaxies are moving closer towards Earth.","Earth is moving towards the distant galaxies.","the temperature of Earth's atmosphere is increasing."},
        {"Acceleration" ,"Kinetic energy\n","Momentum\n","Velocity"},
        {"P and Q have equal kinetic energies.","The speed of P is less than the speed of Q.","The sum of the final kinetic energies of P and Q is zero.","The sum of the final momentum of P and Q is zero."},
        {"½F","F","2F","4F"},
        {"Normal force","Frictional force","Gravitational force","Tension force"},
        {"Momentun: Not conserved kinetic enegry:  Conserved", "Momentun: Conserved KINETIC ENERGY: Not conserved", "MOMENTUM: Not conserved KINETIC ENERGY:Not conserved","MOMENTUM:Conserved KINETIC ENERGY: Conserved" },
        {"4.","6.","8.","16."},
        {"Emission of electrons from a metal surface","'Flow meters' used in hospitals","Red spectral lines from distant stars being shifted","Observed frequency of light from moving bodies being higher than expected"}
     };
        
        RadioQuestion questions []={
            new RadioQuestion(
                    "The net force acting on an object is directly proportional to the ...",
            answers[0],
            1,this),
            new RadioQuestion(
                  "An astronomer, viewing light from distant galaxies, observes a shift of spectral lines toward the red end of the visible spectrum. This shift provides evidence that …",
            answers[1],
            0,this),          
            new RadioQuestion(
                    "A ball is thrown vertically upwards. Which ONE of the following physical quantities has a non-zero value at the instant the ball changes direction?",
            answers[2],
            0,this),
            new RadioQuestion(
                    "Two trolleys, P and Q, of mass m and 2m respectively are at rest on a frictionless horizontal surface. The trolleys have a compressed spring between them.\n" +
"The spring is released and the trolleys move apart. Which ONE of the following statements is TRUE?",
            answers[3],
            3,this),
            new RadioQuestion(
                    "Two identical metal spheres, each of mass m and separated by a distance r, exert a gravitational force of magnitude F on each other. The distance between the spheres is now HALVED.\n" +
"The magnitude of the force the spheres now exerts on each other is:",
            answers[4],
            3,this),
            new RadioQuestion(
                    "Which ONE of the following forces always acts perpendicular to the surface on which a body is placed?",
            answers[5],
            0,this),
            
            new RadioQuestion("Two bodies undergo an INELASTIC collision in the absence of friction. Which ONE of the following combinations of momentum and kinetic energy of the system is CORRECT?",
            answers[6],
            1,this),
            new RadioQuestion("The speed of a bicycle increases from 2 m∙s-1 to 8 m∙s-1. Its kinetic energy increases by a factor of …",
            answers[7],
            3,this),
            new RadioQuestion(""
                  + "Which ONE of the following CANNOT be explained using the Doppler effect?",
            answers[8],
            0,this),
        };
            
        public static void main (String args[]){
            new Quiz();
         }
        public Quiz(){
          super("Quiz Game");
          setResizable(true);
          setSize(950,450);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          p.setLayout(cards);
          numQs = questions.length;
          for(int i = 0; i<numQs; i++){
              p.add(questions[i], "q"+i);
         }
          Random r = new Random();
          int i = r.nextInt(numQs);
          cards.show(p, "q"+i);
          add(p);
          setVisible(true);
        }
        
       public void next() {
       if((totals - wrongs)== numQs){
           showSummary(); 
       }else{
           Random r = new Random();
           boolean found = false;
           int i =0;
           while(!found){
               i = r.nextInt(numQs);
               if(!questions[i].used){
                   found = true;
               }
           }
           cards.show(p, "q"+i);
       }
    }

   public void showSummary() {
       JOptionPane.showMessageDialog(null, "You have finished your first test\n here are your results"
               + "\n Number of correct answers: \t"+ (totals-wrongs)+
               "\n Number of Wrong answers:\t "+wrongs+
               "\n Your Percentage is:\t\t " +(int)((float)((totals-wrongs)/totals))*100 );
       System.exit(0);
    }
    
}
