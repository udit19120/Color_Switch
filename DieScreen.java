package sample;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class DieScreen{

    private final Text t;
    private Text score;
    private final Button button;
    private final Button button1;
    private final Button button2;
    Image imx;
    ImageView img;

    public DieScreen() throws FileNotFoundException {
        t = new Text(225, 70, "!!!GAME OVER!!!");
        t.setFont(Font.font ("Verdana", FontWeight.BOLD,  20));
        t.setId("fancytext");
        t.setFill(Color.RED);

        score=new Text();
        score.setX(450);
        score.setY(30);
        score.setFont(new Font(18));
        score.setFill(Color.SNOW);

        button = new Button("RESTART GAME");
        button.setTextFill(Color.RED);
        button.setPrefSize(150,50);
        button.setLayoutX(250);
        button.setLayoutY(100);

        button1 = new Button("REVIVE GAME (5 STARS)");
        button1.setTextFill(Color.RED);
        button1.setPrefSize(150,50);
        button1.setLayoutX(250);
        button1.setLayoutY(170);

        button2 = new Button("GO TO MAIN");
        button2.setPrefSize(150,50);
        button2.setTextFill(Color.RED);
        button2.setLayoutX(250);
        button2.setLayoutY(240);

        imx=new Image(new FileInputStream("C:\\Users\\91995\\IdeaProjects\\HelloWorldFX\\src\\sample\\Color_Img.png"));
        img = new ImageView(imx);
        img.setX(0);
        img.setY(400);
        img.setFitHeight(700);
        img.setFitWidth(600);
        img.setPreserveRatio(true);
    }
    public void AddScreen(Group root){
        root.getChildren().addAll(t,button,button1,button2,img,score);
    }
    public Button getButtx(){
        return button;
    }
    public Button getButton(){
        return button2;
    }
    public Button getButton1(){
        return button1;
    }
    public void setScore(int score1)
    {
        score.setText(("Stars Collected: "+score1));
    }
}