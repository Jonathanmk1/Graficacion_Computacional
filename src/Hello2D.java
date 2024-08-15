import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class Hello2D extends JApplet {
    public static void main(String s[]) {
        JFrame frame = new JFrame();
        frame.setTitle("Hello 2D");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JApplet applet = new Hello2D();
        applet.init();
        frame.getContentPane().add(applet);
        frame.pack();
        frame.setVisible(true);
    }

    public void init() {
        JPanel panel = new Hello2DPanel();
        getContentPane().add(panel);
    }
}

class Hello2DPanel extends JPanel {
    public Hello2DPanel() {
        setPreferredSize(new Dimension(640, 480));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Colores y textos para las elipses
        Color[] colors = {Color.blue, Color.red, Color.green, Color.orange, Color.magenta};
        String[] texts = {"Hello 2D", "Java Swing", "Graphics", "Ellipses", "Affine"};

        // Coordenadas iniciales para la transformación
        int[] xTranslates = {300, 250, 200, 150, 100};
        int[] yTranslates = {200, 250, 300, 350, 400};

        // Dibujar 5 elipses
        for (int i = 0; i < 5; i++) {
            g2.setColor(colors[i]);

            Ellipse2D e = new Ellipse2D.Double(-100, -50, 200, 100);
            AffineTransform tr = new AffineTransform();
            tr.rotate(Math.PI / (6.0 + i)); // Cambiar el ángulo de rotación para cada elipse
            Shape shape = tr.createTransformedShape(e);

            g2.translate(xTranslates[i], yTranslates[i]); // Cambiar la posición de cada elipse
            g2.scale(2 - 0.2 * i, 2 - 0.2 * i); // Cambiar la escala de cada elipse

            g2.draw(shape);
            g2.drawString(texts[i], 0, 0);

            g2.setTransform(new AffineTransform()); // Restablecer la transformación para la próxima elipse
        }
    }
}