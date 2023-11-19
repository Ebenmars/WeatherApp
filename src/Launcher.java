import javax.swing.*;

public class Launcher {

    public static void main(String[] args) {
        //thread safe
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                AppGui app = new AppGui();
                app.setVisible(true);

            }
        });


    }
}
