package animal;

import java.io.File;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.IOException;

// The frame that constitutes the GUI, inherits from JFrame and borrows the method ActionListener
public class MyFrame extends JFrame implements ActionListener {

    // Button is the file upload button
    private JButton button;

    // Results label displays the conclusion of the classification
    private JLabel resultsLabel;
    MyFrame(JLabel label, JLabel label2, JLabel label3) {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Arrange everything in a line
        this.setLayout(new FlowLayout());

        // Parameters for the upload button
        button = new JButton("Select File");
        button.addActionListener(this);
        button.setBounds(350, 525, 250, 100);

        // Parameters for the classification label
        resultsLabel = new JLabel();
        resultsLabel.setBounds(260, 625, 500, 100);

        // Parameters for the entire frame
        this.setSize(1000, 1000);
        this.setVisible(true);
        this.add(label);
        this.add(label2);
        this.add(label3);
        this.add(resultsLabel);
        this.add(button);
        this.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) { // If button is clicked
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("/Users/jonathanhui/Desktop")); // User will start navigating from desktop

            int response = fileChooser.showSaveDialog(null);

            // If the file chosen is valid
            if (response == JFileChooser.APPROVE_OPTION) {
                // Obtain the results of the image classification
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                UseTrainedAnimalClassifier results = new UseTrainedAnimalClassifier(file);

                // Set the results label to classification of the image
                try {
                    resultsLabel.setText(results.returnClassification());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }

        }
    }
}
