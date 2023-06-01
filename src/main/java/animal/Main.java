package animal;

import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Instructions label
        JLabel label = new JLabel();
        label.setText("Welcome to this simple cat/dog image classifier, made by Jonathan Hui, use the interface to select an image to get started!");
        label.setBounds(85, 10, 1000, 100);

        // Cat image label
        BufferedImage rawCatImage = ImageIO.read(new File("/Users/jonathanhui/Desktop/CatNotCat/src/main/resources/cat-551554_640.jpg"));
        Image catImage = rawCatImage.getScaledInstance(350, 350, Image.SCALE_DEFAULT);
        JLabel catLabel = new JLabel();
        ImageIcon catIcon = new ImageIcon(catImage);
        catLabel.setIcon(catIcon);
        catLabel.setBounds(100, 125, 350, 350);

        // Dog image label
        BufferedImage rawDogImage = ImageIO.read(new File("/Users/jonathanhui/Desktop/CatNotCat/src/main/resources/photo-1611003228941-98852ba62227.jpg"));
        Image dogImage = rawDogImage.getScaledInstance(370, 350, Image.SCALE_DEFAULT);
        JLabel dogLabel = new JLabel();
        ImageIcon dogIcon = new ImageIcon(dogImage);
        dogLabel.setIcon(dogIcon);
        dogLabel.setBounds(500, 125, 370, 350);

        // This runs the entire GUI with our predefined labels here
        new MyFrame(label, catLabel, dogLabel);
    }
}