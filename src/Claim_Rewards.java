package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;

public class Claim_Rewards {
    Text text;
    Button reward;
    ImageView img;
    Image imx;

    public Claim_Rewards() throws Exception
    {
        text = new Text(200, 150, "!!!CLAIM REWARD!!!");
        text.setFont(Font.font ("Verdana", FontWeight.BOLD,  20));
        text.setId("fancytext");
        text.setFill(Color.RED);

        reward=new Button("CLICK HERE TO CLAIM");
        reward.setPrefSize(150,50);
        reward.setTextFill(Color.RED);
        reward.setLayoutX(250);
        reward.setLayoutY(320);

        imx = new Image(new FileInputStream("C:\\Users\\91995\\IdeaProjects\\HelloWorldFX\\src\\sample\\Color_Img.png"));
        img = new ImageView(imx);
        img.setX(0);
        img.setY(400);
        img.setFitHeight(700);
        img.setFitWidth(600);
        img.setPreserveRatio(true);

    }

    public void AddScreen(Group root){
        root.getChildren().addAll(text,reward,img);
    }
}
