package sample;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StarsNotEnough {
    Text t;
    Image back,sad_img;
    ImageView Enough;
    ImageView sad;
    public StarsNotEnough() throws FileNotFoundException{

        t = new Text(50, 150, "CANNOT REVIVE GAME: INSUFFICIENT STARS");
        t.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        t.setId("fancytext");
        t.setFill(Color.RED);

        back = new Image((new FileInputStream("C:\\Users\\91995\\IdeaProjects\\HelloWorldFX\\src\\sample\\Back.png")));
        sad_img=new Image(new FileInputStream("C:\\Users\\91995\\IdeaProjects\\HelloWorldFX\\src\\sample\\not_enough.jpeg"));
        Enough = new ImageView(back);
        sad = new ImageView(sad_img);
        Enough.setX(420);
        Enough.setY(10);

        Enough.setFitHeight(40);
        Enough.setFitWidth(40);

        sad.setX(200);
        sad.setY(200);

        sad.setFitWidth(200);
        sad.setFitHeight(200);

        Enough.setPreserveRatio(true);
    }

    public void AddScreen(Group root){
        root.getChildren().addAll(t,Enough,sad);
    }
}
