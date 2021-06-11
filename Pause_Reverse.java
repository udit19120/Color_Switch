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

public class Pause_Reverse {
    Text text;
    Button exit_button;
    Image imx;
    ImageView img;
    Button button1;
    Button button;
    public Pause_Reverse() throws Exception
    {
        text = new Text(200, 150, "!!!GAME PAUSED!!!");
        text.setFont(Font.font ("Verdana", FontWeight.BOLD,  20));
        text.setId("fancytext");
        text.setFill(Color.RED);

        exit_button=new Button("EXIT");
        exit_button.setPrefSize(100,50);
        exit_button.setTextFill(Color.RED);
        exit_button.setLayoutX(250);
        exit_button.setLayoutY(320);

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

        imx = new Image(new FileInputStream("C:\\Users\\91995\\IdeaProjects\\HelloWorldFX\\src\\sample\\Color_Img.png"));
        img = new ImageView(imx);
        img.setX(0);
        img.setY(400);
        img.setFitHeight(700);
        img.setFitWidth(600);
        img.setPreserveRatio(true);
    }

    public void AddScreen(Group root){
        root.getChildren().addAll(text,exit_button,img,button1,button);
    }
}