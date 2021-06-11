package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//import javax.swing.text.html.ImageView;
import java.io.FileInputStream;

public class ShopPage extends Application {
    Image shop;
    ImageView imageView;

    @Override
    public void start(Stage stage) throws Exception {
        Text t = new Text(250,  250, "BALLS");
        t.setFont(Font.font ("Verdana", FontWeight.BOLD,  40));
        t.setId("fancytext");
        t.setFill(Color.SNOW);

        shop = new Image(new FileInputStream("C:\\Users\\91995\\IdeaProjects\\HelloWorldFX\\src\\sample\\shop.png"));
        imageView = new ImageView(shop);

        imageView.setX(200);
        imageView.setY(20);

        imageView.setFitHeight(150);
        imageView.setFitWidth(800);

        imageView.setPreserveRatio(true);
        Group root = new Group();
        root.getChildren().addAll(t,imageView);
        //Creating a scene object
        Scene scene = new Scene(root, 600, 700);
        scene.setFill(Color.BLACK);
        //Setting title to the Stage
        stage.setTitle("Die Page");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
    }
}
