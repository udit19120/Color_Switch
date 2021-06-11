package sample;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import java.io.FileInputStream;

public class Pause {
    Text t;
    Button button;
    Button button1;
    Button button2;
    Image imx;
    ImageView img;
    public Pause() throws Exception {
        t = new Text(200, 150, "!!!GAME PAUSED!!!");
        t.setFont(Font.font ("Verdana", FontWeight.BOLD,  20));
        t.setId("fancytext");
        t.setFill(Color.RED);

        button = new Button("RESTART GAME");
        button.setTextFill(Color.RED);
        button.setPrefSize(100,50);
        button.setLayoutX(250);
        button.setLayoutY(180);

        button1 = new Button("RESUME GAME");
        button1.setTextFill(Color.RED);
        button1.setPrefSize(100,50);
        button1.setLayoutX(250);
        button1.setLayoutY(250);

        button2 = new Button("SAVE N EXIT");
        button2.setPrefSize(100,50);
        button2.setTextFill(Color.RED);
        button2.setLayoutX(250);
        button2.setLayoutY(320);

        imx = new Image(new FileInputStream("C:\\Users\\91995\\IdeaProjects\\HelloWorldFX\\src\\sample\\Color_Img.png"));
        img = new ImageView(imx);
        img.setX(0);
        img.setY(400);
        img.setFitHeight(700);
        img.setFitWidth(600);
        img.setPreserveRatio(true);
    }
    public void AddScreen(Group root){
        root.getChildren().addAll(t,button,button1,button2,img);
    }
}
