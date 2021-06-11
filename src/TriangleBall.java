package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class TriangleBall extends Ball {
    Polygon polygon;
    private String color;
    private Polygon ball;
    public TriangleBall(int x, double y, int r) {
        super(x, y, r);
        polygon = new Polygon();
        this.color="b";
        polygon.getPoints().addAll(280.0, 350.0, 300.0, 350.0, 290.0, 330.0);
        polygon.setFill(Color.BLUE);
        Rotate r1 = new Rotate();
        polygon.getTransforms().add(r1);
        r1.setPivotX(290);
        r1.setPivotY(340);
        Timeline t = new Timeline();
        //r1.setAxis(se);
        t.setCycleCount(Animation.INDEFINITE);
        t.getKeyFrames().add(new KeyFrame(Duration.millis(4000),new KeyValue(r1.angleProperty(),360)));
        t.play();
    }
    public Polygon getPolygon(){
        return polygon;
    }
    public void AddScreen(Group root) {

        root.getChildren().add(polygon);
    }


    public String getColor()
    {
        return this.color;
    }
}
