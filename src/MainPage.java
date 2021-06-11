package sample;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;


public class MainPage{
    Image image;
    Image image1;
    Image image2;
    Image image3;
    Image image4;
    Button button;
    Button button2;
    Button button3;
    Button button1;
    Button reversegame;

    ImageView imageView;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    private Concentric_Circle concentric_circle;
    private Circle circle;


    public MainPage() throws Exception {
        image = new Image(new FileInputStream("C:\\Users\\91995\\IdeaProjects\\HelloWorldFX\\src\\sample\\color_sw.png"));
        image1 = new Image(new FileInputStream("C:\\Users\\91995\\IdeaProjects\\HelloWorldFX\\src\\sample\\Conc_cs.png"));
        image2 = new Image(new FileInputStream("C:\\Users\\91995\\IdeaProjects\\HelloWorldFX\\src\\sample\\Trophy.png"));
        image3 = new Image(new FileInputStream("C:\\Users\\91995\\IdeaProjects\\HelloWorldFX\\src\\sample\\freeCoins.jpeg"));
        image4 = new Image(new FileInputStream("C:\\Users\\91995\\IdeaProjects\\HelloWorldFX\\src\\sample\\Help.png"));

        imageView = new ImageView(image);

        imageView.setX(150);
        imageView.setY(0);

        imageView.setFitHeight(300);
        imageView.setFitWidth(300);

        imageView.setPreserveRatio(true);

        imageView1 = new ImageView(image1);

        imageView1.setX(150);
        imageView1.setY(180);

        imageView1.setFitHeight(300);
        imageView1.setFitWidth(300);

        imageView1.setPreserveRatio(true);

        imageView2= new ImageView(image2);

        imageView2.setX(170);
        imageView2.setY(560);

        imageView2.setFitHeight(100);
        imageView2.setFitWidth(100);

        imageView2.setPreserveRatio(true);

        imageView3= new ImageView(image3);

        imageView3.setX(250);
        imageView3.setY(570);

        imageView3.setFitHeight(80);
        imageView3.setFitWidth(100);

        imageView3.setPreserveRatio(true);

        imageView4= new ImageView(image4);

        imageView4.setX(330);
        imageView4.setY(570);

        imageView4.setFitHeight(80);
        imageView4.setFitWidth(100);

        imageView4.setPreserveRatio(true);



        reversegame=new Button("REVERSE GAME");
        reversegame.setPrefSize(100,50);
        reversegame.setLayoutX(315);
        reversegame.setLayoutY(380);

        button = new Button("NEW GAME");
        button.setPrefSize(100,50);
        button.setLayoutX(195);
        button.setLayoutY(380);

        button1 = new Button("LOAD GAME");
        button1.setPrefSize(100,50);
        button1.setLayoutX(260);
        button1.setLayoutY(445);

        button2 = new Button("EXIT GAME");
        button2.setPrefSize(100,50);
        button2.setLayoutX(260);
        button2.setLayoutY(510);

        button3 = new Button("STORE");
        button3.setPrefSize(100,50);
        button3.setLayoutX(260);
        button3.setLayoutY(575);

        concentric_circle=new Concentric_Circle(70,313,280,15,false);
        circle=new Circle(313,280,85,15,false);
    }
    public void AddScreen(Group root){
        root.getChildren().addAll(imageView,imageView1,button,button1,button2,imageView2,imageView3,imageView4,reversegame);
        concentric_circle.AddScreen(root);
        circle.AddScreen(root);
    }
}
