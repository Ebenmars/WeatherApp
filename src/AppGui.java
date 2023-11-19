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

       setSize(500,650);

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


        JLabel weatherConditionImage = new JLabel(loadImage("/Users/ignite/WeatherApp/src/assets/cloudy.png"));
        weatherConditionImage.setBounds(50,150,400,200);
        this.add(weatherConditionImage);


        JLabel temperatureInfo = new JLabel("70 F");
        temperatureInfo.setBounds(50,125,400,50);
        temperatureInfo.setFont(new Font("SANS_SERIF",Font.BOLD,46));
        this.add(temperatureInfo);

        JLabel weatherConditions = new JLabel("Cloudy");
        weatherConditions.setBounds(50,340,400,50);
        weatherConditions.setFont(new Font("SANS_SERIF",Font.BOLD,32));
        weatherConditions.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(weatherConditions);


        JLabel humidity = new JLabel(loadImage("/Users/ignite/WeatherApp/src/assets/humidity.png"));
        humidity.setBounds(20,500,78,64);
        this.add(humidity);

        JLabel humidityText = new JLabel("<html><b>Humidity</b> 100%</html>");
        humidityText.setBounds(90,485,125,75);
        humidityText.setFont(new Font("SANS",Font.PLAIN,17));
        this.add(humidityText);

        JLabel wind = new JLabel(loadImage("/Users/ignite/WeatherApp/src/assets/windy.png"));
        wind.setBounds(275,500,78,64);
        this.add(wind);

        JLabel windText = new JLabel("<html><b>Wind speed</b> 15m</html>");
        windText.setBounds(365,485,125,75);
        windText.setFont(new Font("SANS",Font.PLAIN,17));
        this.add(windText);
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