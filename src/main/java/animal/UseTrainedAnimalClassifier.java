package animal;

import deepnetts.net.ConvolutionalNetwork;
import deepnetts.util.FileIO;

import javax.imageio.ImageIO;
import javax.visrec.ml.classification.ImageClassifier;
import javax.visrec.ri.ml.classification.ImageClassifierNetwork;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class UseTrainedAnimalClassifier {
    private File file;

    // Constructor takes in the user-chosen file
    public UseTrainedAnimalClassifier(File file) {
        this.file = file;
    }

    // Returns the classification to be used in the MyFrame.java file
    public String returnClassification() throws IOException, ClassNotFoundException {

        // Load the neural network
        ConvolutionalNetwork convNet =  FileIO.createFromFile("animals.dnet", ConvolutionalNetwork.class);

        // Create an image classifier using the trained model
        ImageClassifier<BufferedImage> classifier = new ImageClassifierNetwork(convNet);

        // Load the image
        BufferedImage image = ImageIO.read(file);

        // Feed image into the classifier (reads into a map)
        Map<String, Float> results = classifier.classify(image);

        // Interpret the classification result / class probability
        double catProbability = results.get("cat");

        return "According to the model, the probability of your image being a cat is " + Math.round(catProbability * 100.0) / 100.0 * 100 + "%";
    }
}
