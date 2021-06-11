package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Scanner;

public class Common2 extends Application {
    Scene scene1, scene2;
    @Override
    public void start(Stage stage) throws Exception
    {
        stage.setTitle("Transition");
        Group root1 = new Group();
        Group root2 =new Group();

        DieScreen dieScreen=new DieScreen();
        MainPage mainPage=new MainPage();

        dieScreen.AddScreen(root1);
        dieScreen.getButton().setOnAction(e->stage.setScene(scene2));

        mainPage.AddScreen(root2);
        //scene1=new Scene(root1, 400,400);
        scene2=new Scene(root2, 600,700);
        scene1=new Scene(root1, 500,700);
        scene2.setFill(Color.BLACK);

        stage.setScene(scene1);
        stage.show();

    }
    public static void main(String[] args){
        launch(args);
    }
}