package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RectangleBall extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Rectangle rect = new Rectangle(200,200,20,20);
        rect.setFill(Color.BLUE);
        Rotate r1 = new Rotate();
        rect.getTransforms().add(r1);
        r1.setPivotX(210);
        r1.setPivotY(210);
        Timeline t = new Timeline();
        //r1.setAxis(se);
        t.setCycleCount(Animation.INDEFINITE);
        t.getKeyFrames().add(new KeyFrame(Duration.millis(4000),new KeyValue(r1.angleProperty(),360)));
        t.play();
        Group root = new Group(rect);
        Scene scene = new Scene(root,600,700);
        stage.setScene(scene);
        stage.show();

    }
}

