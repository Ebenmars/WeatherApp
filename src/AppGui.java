import javax.swing.*;

public class AppGui extends JFrame {
   public AppGui(){
       this.setTitle("Weather App");


       setDefaultCloseOperation(EXIT_ON_CLOSE);

       setSize(500,500);

       setLocationRelativeTo(null);

       setLayout(null);

       setResizable(false);

       addComponets();
   }

    private void addComponets() {
       JTextField seachfield = new JTextField();

       seachfield.setBounds(15,15,400,40);

       this.add(seachfield);
    }
}