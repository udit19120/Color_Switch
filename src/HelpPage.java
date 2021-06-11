package sample;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class HelpPage  {
    Image back;
    Image image;
    ImageView imageView;
    ImageView iv;
    public HelpPage() throws FileNotFoundException {
        back = new Image((new FileInputStream("C:\\Users\\91995\\IdeaProjects\\HelloWorldFX\\src\\sample\\Back.png")));
        iv = new ImageView(back);
        iv.setX(420);
        iv.setY(10);

        iv.setFitHeight(40);
        iv.setFitWidth(40);

        iv.setPreserveRatio(true);
        image = new Image(new FileInputStream("C:\\Users\\91995\\IdeaProjects\\HelloWorldFX\\src\\sample\\helpPage.png"));
        imageView = new ImageView(image);
        imageView.setX(0);
        imageView.setY(100);
        imageView.setFitHeight(1000);
        imageView.setFitWidth(500);
        imageView.setPreserveRatio(true);
    }
    public void AddScreen(Group root){
        root.getChildren().addAll(imageView,iv);
    }
}
