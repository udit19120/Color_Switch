package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Tangent_Circles extends Obstacles{
    private Path path1;
    private Path path2;
    private Path path3;
    private Path path4;

    private Path path1x;
    private Path path2x;
    private Path path3x;
    private Path path4x;

    Rotate r1 = new Rotate();
    Rotate r2 = new Rotate();
    Rotate r3 = new Rotate();
    Rotate r4 = new Rotate();

    Rotate r1x = new Rotate();
    Rotate r2x = new Rotate();
    Rotate r3x = new Rotate();
    Rotate r4x = new Rotate();

    private boolean check = false;
    public Tangent_Circles(int radius, int center_x, int center_y, int width,boolean check) throws Exception {
        super(center_x,center_y,radius,width,check);
        center_x-=radius;
        path1 = new Path();
        path1.setStrokeWidth(width);               //width =5
        path1.setStroke(Color.YELLOW);
        MoveTo moveTo1 = new MoveTo(center_x, center_y+radius);
        ArcTo arc1 = new ArcTo();
        arc1.setX(center_x+radius);
        arc1.setY(center_y);

        arc1.setRadiusX(radius);
        arc1.setRadiusY(radius);

        path2 = new Path();
        path2.setStrokeWidth(width);
        path2.setStroke(Color.BLUE);
        MoveTo moveTo2 = new MoveTo(center_x+radius, center_y);
        ArcTo arc2 = new ArcTo();
        arc2.setX(center_x);
        arc2.setY(center_y-radius);

        arc2.setRadiusX(radius);
        arc2.setRadiusY(radius);

        path3 = new Path();
        path3.setStrokeWidth(width);
        path3.setStroke(Color.RED);
        MoveTo moveTo3 = new MoveTo(center_x, center_y-radius);
        ArcTo arc3 = new ArcTo();
        arc3.setX(center_x-radius);
        arc3.setY(center_y);

        arc3.setRadiusX(radius);
        arc3.setRadiusY(radius);

        path4 = new Path();
        path4.setStrokeWidth(width);
        path4.setStroke(Color.HOTPINK);
        MoveTo moveTo4 = new MoveTo(center_x-radius, center_y);
        ArcTo arc4 = new ArcTo();
        arc4.setX(center_x);
        arc4.setY(center_y+radius);

        arc4.setRadiusX(radius);
        arc4.setRadiusY(radius);

        path1.getTransforms().add(r1);
        r1.setPivotX(center_x);
        r1.setPivotY(center_y);
        Timeline t1 = new Timeline();
        t1.setCycleCount(Animation.INDEFINITE);
        t1.getKeyFrames().add(new KeyFrame(Duration.millis(8000), new KeyValue(r1.angleProperty(), 360)));
        t1.play();
        path2.getTransforms().add(r2);
        r2.setPivotX(center_x);
        r2.setPivotY(center_y);
        Timeline t2 = new Timeline();
        t2.setCycleCount(Animation.INDEFINITE);
        t2.getKeyFrames().add(new KeyFrame(Duration.millis(8000), new KeyValue(r2.angleProperty(), 360)));
        t2.play();

        path3.getTransforms().add(r3);
        r3.setPivotX(center_x);
        r3.setPivotY(center_y);
        Timeline t3 = new Timeline();
        t3.setCycleCount(Animation.INDEFINITE);
        t3.getKeyFrames().add(new KeyFrame(Duration.millis(8000), new KeyValue(r3.angleProperty(), 360)));
        t3.play();

        path4.getTransforms().add(r4);
        r4.setPivotX(center_x);
        r4.setPivotY(center_y);
        Timeline t4 = new Timeline();
        t4.setCycleCount(Animation.INDEFINITE);
        t4.getKeyFrames().add(new KeyFrame(Duration.millis(8000), new KeyValue(r4.angleProperty(), 360)));
        t4.play();

        path1x = new Path();
        path1x.setStrokeWidth(5);
        path1x.setStroke(Color.BLUE);
        MoveTo moveTo1x = new MoveTo(center_x+2*radius, center_y-radius);
        ArcTo arc1x = new ArcTo();
        arc1x.setX(center_x+radius);
        arc1x.setY(center_y);

        arc1x.setRadiusX(radius);
        arc1x.setRadiusY(radius);

        path2x = new Path();
        path2x.setStrokeWidth(5);
        path2x.setStroke(Color.RED);
        MoveTo moveTo2x = new MoveTo(center_x+3*radius, center_y);
        ArcTo arc2x = new ArcTo();
        arc2x.setX(center_x+2*radius);
        arc2x.setY(center_y-radius);

        arc2x.setRadiusX(radius);
        arc2x.setRadiusY(radius);

        path3x = new Path();
        path3x.setStrokeWidth(5);
        path3x.setStroke(Color.HOTPINK);
        MoveTo moveTo3x = new MoveTo(center_x+2*radius, center_y+radius);
        ArcTo arc3x = new ArcTo();
        arc3x.setX(center_x+3*radius);
        arc3x.setY(center_y);

        arc3x.setRadiusX(radius);
        arc3x.setRadiusY(radius);

        path4x = new Path();
        path4x.setStrokeWidth(5);
        path4x.setStroke(Color.YELLOW);
        MoveTo moveTo4x = new MoveTo(center_x+radius, center_y);
        ArcTo arc4x = new ArcTo();
        arc4x.setX(center_x+2*radius);
        arc4x.setY(center_y+radius);

        arc4x.setRadiusX(radius);
        arc4x.setRadiusY(radius);

        path1x.getTransforms().add(r1x);
        r1x.setPivotX(center_x+2*radius);
        r1x.setPivotY(center_y);
        Timeline t1x = new Timeline();
        t1x.setCycleCount(Animation.INDEFINITE);
        t1x.getKeyFrames().add(new KeyFrame(Duration.millis(8000), new KeyValue(r1x.angleProperty(), -360)));
        t1x.play();
        path2x.getTransforms().add(r2x);
        r2x.setPivotX(center_x+2*radius);
        r2x.setPivotY(center_y);
        Timeline t2x = new Timeline();
        t2x.setCycleCount(Animation.INDEFINITE);
        t2x.getKeyFrames().add(new KeyFrame(Duration.millis(8000), new KeyValue(r2x.angleProperty(), -360)));
        t2x.play();

        path3x.getTransforms().add(r3x);
        r3x.setPivotX(center_x+2*radius);
        r3x.setPivotY(center_y);
        Timeline t3x = new Timeline();
        t3x.setCycleCount(Animation.INDEFINITE);
        t3x.getKeyFrames().add(new KeyFrame(Duration.millis(8000), new KeyValue(r3x.angleProperty(), -360)));
        t3x.play();

        path4x.getTransforms().add(r4x);
        r4x.setPivotX(center_x+2*radius);
        r4x.setPivotY(center_y);
        Timeline t4x = new Timeline();
        t4x.setCycleCount(Animation.INDEFINITE);
        t4x.getKeyFrames().add(new KeyFrame(Duration.millis(8000), new KeyValue(r4x.angleProperty(), -360)));
        t4x.play();

        path1.getElements().add(moveTo1);
        path1.getElements().add(arc1);
        path2.getElements().add(moveTo2);
        path2.getElements().add(arc2);
        path3.getElements().add(moveTo3);
        path3.getElements().add(arc3);
        path4.getElements().add(moveTo4);
        path4.getElements().add(arc4);

        path1x.getElements().add(moveTo1x);
        path1x.getElements().add(arc1x);
        path2x.getElements().add(moveTo2x);
        path2x.getElements().add(arc2x);
        path3x.getElements().add(moveTo3x);
        path3x.getElements().add(arc3x);
        path4x.getElements().add(moveTo4x);
        path4x.getElements().add(arc4x);
    }
    public void AddScreen(Group root)
    {
        root.getChildren().addAll(path4,path3,path2,path1,path4x,path3x,path2x,path1x);
    }
    public void checkInteraction(Ball ball) {
        Shape intersect1 = Shape.intersect(ball.getBall(), path1);
        Shape intersect2 = Shape.intersect(ball.getBall(), path2);
        Shape intersect3 = Shape.intersect(ball.getBall(), path3);
        Shape intersect4 = Shape.intersect(ball.getBall(), path4);

        Shape intersect1x = Shape.intersect(ball.getBall(), path1x);
        Shape intersect2x = Shape.intersect(ball.getBall(), path2x);
        Shape intersect3x = Shape.intersect(ball.getBall(), path3x);
        Shape intersect4x = Shape.intersect(ball.getBall(), path4x);
        if (intersect1.getBoundsInParent().getHeight() != -1) {
            if (path1.getStroke() == ball.getBall().getFill()||ball.getBall().getFill()==Color.SNOW) {
                Common(ball,intersect1x,intersect2x,intersect3x,intersect4x);

            }
            else {
                System.out.println("GAME OVER");
                check=true;
            }
        }
        else if (intersect2.getBoundsInParent().getHeight() != -1) {
            if (path2.getStroke() == ball.getBall().getFill()||ball.getBall().getFill()==Color.SNOW) {
                Common(ball,intersect1x,intersect2x,intersect3x,intersect4x);
            } else {
                System.out.println("GAME OVER");
                check=true;
            }
        } else if (intersect3.getBoundsInParent().getHeight() != -1) {
            if (path3.getStroke() == ball.getBall().getFill()||ball.getBall().getFill()==Color.SNOW) {
                Common(ball,intersect1x,intersect2x,intersect3x,intersect4x);
            } else {
                System.out.println("GAME OVER");
                check=true;
            }
            System.out.println("PP");
        } else if (intersect4.getBoundsInParent().getHeight() != -1) {
            if (path4.getStroke() == ball.getBall().getFill()||ball.getBall().getFill()==Color.SNOW) {
                Common(ball,intersect1x,intersect2x,intersect3x,intersect4x);
            } else {
                System.out.println("GAME OVER");
                check=true;
            }
            System.out.println("PP");
        }
    }
    public void Common(Ball ball,Shape intersect1x,Shape intersect2x,Shape intersect3x,Shape intersect4x){
        if (intersect1x.getBoundsInParent().getHeight() != -1) {
            if (path1x.getStroke() == ball.getBall().getFill()||ball.getBall().getFill()==Color.SNOW) {
                System.out.println("YIP");
            } else {
                System.out.println("GAME OVER");
                check=true;
            }
        } else if (intersect2x.getBoundsInParent().getHeight() != -1) {
            if (path2x.getStroke() == ball.getBall().getFill()||ball.getBall().getFill()==Color.SNOW) {
                System.out.println("YIP");
            } else {
                System.out.println("GAME OVER");
                check=true;
            }
        } else if (intersect3x.getBoundsInParent().getHeight() != -1) {
            if (path3x.getStroke() == ball.getBall().getFill()||ball.getBall().getFill()==Color.SNOW) {
                System.out.println("YIP");
            } else {
                System.out.println("GAME OVER");
                check=true;
            }
        } else if (intersect4x.getBoundsInParent().getHeight() != -1) {
            if (path4x.getStroke() == ball.getBall().getFill()||ball.getBall().getFill()==Color.SNOW) {
                System.out.println("YIP");
            } else {
                System.out.println("GAME OVER");
                check=true;
            }
        }
    }
    public boolean getCheck(){
        return check;
    }
}
