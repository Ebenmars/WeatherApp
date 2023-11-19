import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
       JTextField searchfield = new JTextField();

       searchfield.setBounds(15,15,400,40);

        searchfield.setFont(new Font("SERIF",Font.ITALIC,16));

        searchfield.setHorizontalAlignment(JTextField.CENTER);

        searchfield.setBorder(new LineBorder(Color.BLACK,1,true));
       this.add(searchfield);


       JButton searchButton = new JButton(loadImage("/Users/ignite/WeatherApp/src/assets/search.png"));

        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchButton.setBounds(425,15,47,40);
        searchButton.setBorder(new LineBorder(Color.BLACK,1,true));
        this.add(searchButton);


        JLabel weatherConditionImage = new JLabel();
    }

    private ImageIcon loadImage(String path) {
       try {
           //reading path
           BufferedImage image = ImageIO.read(new File(path));

           //return image
           return new ImageIcon(image);
       }
       catch(IOException e){
           e.printStackTrace();
       }

        System.out.println("asset not found");

       return null;
    }
}