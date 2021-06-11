package sample;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;

public class MediaFX implements Serializable
{
    MediaPlayer mediaplayer;
    Button btn_stop;
    MediaView mediaView;
    Media videoFile;
    public MediaFX() throws Exception
    {
        videoFile = new Media("file:///C:/Users/91995/IdeaProjects/HelloWorldFX/src/sample/Christmas.mp4");
        mediaplayer = new MediaPlayer(videoFile);
        btn_stop = new Button("Stop");
        btn_stop.setPrefSize(100,50);
        btn_stop.setLayoutX(50);
        btn_stop.setLayoutY(70);
        //mediaplayer.play();
        mediaView= new MediaView(mediaplayer);
    }

    public void AddScreen(Group root){
        root.getChildren().addAll(mediaView);
    }
    public void Stop(Stage stage, Scene scene,Integer starsSoFar){
        mediaplayer.setOnEndOfMedia(new Runnable() {
            public void run() {
                //Code to run
                mediaplayer.stop();
                stage.setScene(scene);
                try {
                    Serializer.serialize(starsSoFar+30,Color_Switch.getStarsCollectedTxt());
                    System.out.println(starsSoFar);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }

}