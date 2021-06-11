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
import java.util.ArrayList;
import java.util.Collections;

public class HighScore {
    private Text t;
    private Text t1=new Text(150,150,"");
    private Text t2=new Text(150,200,"");
    private Text t3=new Text(150,250,"");
    private Text t4=new Text(150,300,"");
    private Text t5=new Text(150,350,"");
    private Image back;
    ImageView iv;
    private Image imx;
    private ImageView img;
    public HighScore(ArrayList<Integer> scores) throws FileNotFoundException {
        t = new Text(150, 50, "!!!TOP 5 SCORES!!!");
        t.setFont(Font.font ("Verdana", FontWeight.BOLD,  20));
        t.setId("fancytext");
        t.setFill(Color.RED);
        scores.sort(Collections.reverseOrder());

        back = new Image((new FileInputStream("C:\\Users\\91995\\IdeaProjects\\HelloWorldFX\\src\\sample\\Back.png")));
        iv = new ImageView(back);
        iv.setX(420);
        iv.setY(10);

        iv.setFitHeight(40);
        iv.setFitWidth(40);

        iv.setPreserveRatio(true);
        //ShowHighScore(scores);

        imx=new Image(new FileInputStream("C:\\Users\\91995\\IdeaProjects\\HelloWorldFX\\src\\sample\\Color_Img.png"));
        img = new ImageView(imx);
        img.setX(0);
        img.setY(500);
        img.setFitHeight(700);
        img.setFitWidth(600);
        img.setPreserveRatio(true);



    }
    public void AddScreen(Group root){
        root.getChildren().addAll(t,t1,t2,t3,t4,t5,iv,img);
    }
    public void ShowHighScore(ArrayList<Integer> scores){
        if(scores.size()==0){
            t1.setText("NO GAMES PLAYED");
            t1.setFont(Font.font ("Verdana", FontWeight.BOLD,  20));
            t1.setId("fancytext");
            t1.setFill(Color.RED);
        }
        else if (scores.size()==1){
            t1.setText("SCORE : "+scores.get(0));
            t1.setFont(Font.font ("Verdana", FontWeight.BOLD,  20));
            t1.setId("fancytext");
            t1.setFill(Color.RED);
        }
        else if (scores.size()==2){
            t1.setText("SCORE : "+scores.get(0));
            t1.setFont(Font.font ("Verdana", FontWeight.BOLD,  20));
            t1.setId("fancytext");
            t1.setFill(Color.RED);

            t2.setText("SCORE : "+scores.get(1));
            t2.setFont(Font.font ("Verdana", FontWeight.BOLD,  20));
            t2.setId("fancytext");
            t2.setFill(Color.RED);
        }
        else if (scores.size()==3){
            t1.setText("SCORE : "+scores.get(0));
            t1.setFont(Font.font ("Verdana", FontWeight.BOLD,  20));
            t1.setId("fancytext");
            t1.setFill(Color.RED);

            t2.setText("SCORE : "+scores.get(1));
            t2.setFont(Font.font ("Verdana", FontWeight.BOLD,  20));
            t2.setId("fancytext");
            t2.setFill(Color.RED);

            t3.setText("SCORE : "+scores.get(2));
            t3.setFont(Font.font ("Verdana", FontWeight.BOLD,  20));
            t3.setId("fancytext");
            t3.setFill(Color.RED);

        }
        else if (scores.size()==4){

            t1.setText("SCORE : "+scores.get(0));
            t1.setFont(Font.font ("Verdana", FontWeight.BOLD,  20));
            t1.setId("fancytext");
            t1.setFill(Color.RED);

            t2.setText("SCORE : "+scores.get(1));
            t2.setFont(Font.font ("Verdana", FontWeight.BOLD,  20));
            t2.setId("fancytext");
            t2.setFill(Color.RED);

            t3.setText("SCORE : "+scores.get(2));
            t3.setFont(Font.font ("Verdana", FontWeight.BOLD,  20));
            t3.setId("fancytext");
            t3.setFill(Color.RED);

            t4.setText("SCORE : "+scores.get(3));
            t4.setFont(Font.font ("Verdana", FontWeight.BOLD,  20));
            t4.setId("fancytext");
            t4.setFill(Color.RED);
        }
        else{

            t1.setText("SCORE : "+scores.get(0));
            t1.setFont(Font.font ("Verdana", FontWeight.BOLD,  20));
            t1.setId("fancytext");
            t1.setFill(Color.RED);

            t2.setText("SCORE : "+scores.get(1));
            t2.setFont(Font.font ("Verdana", FontWeight.BOLD,  20));
            t2.setId("fancytext");
            t2.setFill(Color.RED);

            t3.setText("SCORE : "+scores.get(2));
            t3.setFont(Font.font ("Verdana", FontWeight.BOLD,  20));
            t3.setId("fancytext");
            t3.setFill(Color.RED);

            t4.setText("SCORE : "+scores.get(3));
            t4.setFont(Font.font ("Verdana", FontWeight.BOLD,  20));
            t4.setId("fancytext");
            t4.setFill(Color.RED);

            t5.setText("SCORE : "+scores.get(4));
            t5.setFont(Font.font ("Verdana", FontWeight.BOLD,  20));
            t5.setId("fancytext");
            t5.setFill(Color.RED);
        }
    }

}

