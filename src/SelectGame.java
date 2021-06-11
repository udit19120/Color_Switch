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

public class SelectGame {
    Text t;
    Image back;
    ImageView iv;
    Button button;
    Button button1;
    Button button2;
    Button button3;
    Image imx;
    ImageView img;
    public SelectGame() throws Exception {
        back = new Image((new FileInputStream("C:\\Users\\91995\\IdeaProjects\\HelloWorldFX\\src\\sample\\Back.png")));
        iv = new ImageView(back);
        iv.setX(420);
        iv.setY(25);

        iv.setFitHeight(40);
        iv.setFitWidth(40);

        imx = new Image(new FileInputStream("C:\\Users\\91995\\IdeaProjects\\HelloWorldFX\\src\\sample\\Color_Img.png"));
        img = new ImageView(imx);
        img.setX(0);
        img.setY(400);
        img.setFitHeight(700);
        img.setFitWidth(600);
        img.setPreserveRatio(true);
        iv.setPreserveRatio(true);
        t = new Text(200, 200, "SELECT GAME");
        t.setFont(Font.font ("Verdana", FontWeight.BOLD,  20));
        t.setId("fancytext");
        t.setFill(Color.RED);

        button = new Button("GAME 1");
        button.setTextFill(Color.RED);
        button.setPrefSize(100,50);
        button.setLayoutX(140);
        button.setLayoutY(280);

        button1 = new Button("GAME 2");
        button1.setTextFill(Color.RED);
        button1.setPrefSize(100,50);
        button1.setLayoutX(310);
        button1.setLayoutY(280);

        button2 = new Button("GAME 3");
        button2.setPrefSize(100,50);
        button2.setTextFill(Color.RED);
        button2.setLayoutX(310);
        button2.setLayoutY(350);

        button3 = new Button("GAME 4");
        button3.setPrefSize(100,50);
        button3.setTextFill(Color.RED);
        button3.setLayoutX(140);
        button3.setLayoutY(350);
    }
    public void AddScreen(Group root){
        root.getChildren().addAll(t,iv,button,button1,button2,button3,img);
    }
}
