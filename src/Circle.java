package sample;

import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Circle extends Obstacles{
    private Path path1 = new Path();
    private Path path2 = new Path();
    private Path path3 = new Path();
    private Path path4 = new Path();

    Rotate r1 = new Rotate();
    Rotate r2 = new Rotate();
    Rotate r3 = new Rotate();
    Rotate r4 = new Rotate();
    DieScreen die = new DieScreen();
    Group rootx = new Group();
    Scene dieScene;
    private boolean check=false;
    public Circle(int x,int y, int r, int width,boolean check) throws Exception {
        super(x,y,r,width,check);
        path1.setStrokeWidth(width);
        path1.setStroke(Color.RED);
        MoveTo moveTo1 = new MoveTo(x,y+r);
        ArcTo arc1 = new ArcTo();
        arc1.setX(x+r);
        arc1.setY(y);

        arc1.setRadiusX(r);
        arc1.setRadiusY(r);

        path2.setStrokeWidth(width);
        path2.setStroke(Color.BLUE);
        MoveTo moveTo2 = new MoveTo(x+r,y);
        ArcTo arc2 = new ArcTo();
        arc2.setX(x);
        arc2.setY(y-r);

        arc2.setRadiusX(r);
        arc2.setRadiusY(r);

        path3.setStrokeWidth(width);
        path3.setStroke(Color.YELLOW);
        MoveTo moveTo3 = new MoveTo(x,y-r);
        ArcTo arc3 = new ArcTo();
        arc3.setX(x-r);
        arc3.setY(y);

        arc3.setRadiusX(r);
        arc3.setRadiusY(r);

        path4.setStrokeWidth(width);
        path4.setStroke(Color.HOTPINK);
        MoveTo moveTo4= new MoveTo(x-r,y);
        ArcTo arc4 = new ArcTo();
        arc4.setX(x);
        arc4.setY(y+r);

        arc4.setRadiusX(r);
        arc4.setRadiusY(r);

        path1.getTransforms().add(r1);
        r1.setPivotX(x);
        r1.setPivotY(y);
        Timeline t1 = new Timeline();
        t1.setCycleCount(Animation.INDEFINITE);
        t1.getKeyFrames().add(new KeyFrame(Duration.millis(4000),new KeyValue(r1.angleProperty(),360)));
        t1.play();
        path2.getTransforms().add(r2);
        r2.setPivotX(x);
        r2.setPivotY(y);
        Timeline t2 = new Timeline();
        t2.setCycleCount(Animation.INDEFINITE);
        t2.getKeyFrames().add(new KeyFrame(Duration.millis(4000),new KeyValue(r2.angleProperty(),360)));
        t2.play();

        path3.getTransforms().add(r3);
        r3.setPivotX(x);
        r3.setPivotY(y);
        Timeline t3 = new Timeline();
        t3.setCycleCount(Animation.INDEFINITE);
        t3.getKeyFrames().add(new KeyFrame(Duration.millis(4000),new KeyValue(r3.angleProperty(),360)));
        t3.play();

        path4.getTransforms().add(r4);
        r4.setPivotX(x);
        r4.setPivotY(y);
        Timeline t4 = new Timeline();
        t4.setCycleCount(Animation.INDEFINITE);
        t4.getKeyFrames().add(new KeyFrame(Duration.millis(4000),new KeyValue(r4.angleProperty(),360)));
        t4.play();

        path1.getElements().add(moveTo1);
        path1.getElements().add(arc1);
        path2.getElements().add(moveTo2);
        path2.getElements().add(arc2);
        path3.getElements().add(moveTo3);
        path3.getElements().add(arc3);
        path4.getElements().add(moveTo4);
        path4.getElements().add(arc4);
        dieScene = new Scene(rootx,600,700);
        die.AddScreen(rootx);
    }
    @Override
    public void AddScreen(Group rootx){
        rootx.getChildren().addAll(path1,path2,path3,path4);
    }
    @Override
    public void checkInteraction(Ball ball){
        Shape intersect1 = Shape.intersect(ball.getBall(),path1);
        Shape intersect2 = Shape.intersect(ball.getBall(),path2);
        Shape intersect3 = Shape.intersect(ball.getBall(),path3);
        Shape intersect4 = Shape.intersect(ball.getBall(),path4);
        if(intersect1.getBoundsInParent().getHeight()!=-1){
            System.out.println(ball.getBall().getLayoutY());
            if(path1.getStroke()==ball.getBall().getFill()||ball.getBall().getFill()==Color.SNOW){
                System.out.println("YIP");
            }
            else{
                System.out.println("GAME OVER");
                check=true;
            }

        }
        else if(intersect2.getBoundsInParent().getHeight()!=-1){
            System.out.println(ball.getBall().getLayoutY());
            if(path2.getStroke()==ball.getBall().getFill()||ball.getBall().getFill()==Color.SNOW){
                System.out.println("YIP");
            }
            else{
                System.out.println("GAME OVER");
                check=true;
            }
        }
        else if(intersect3.getBoundsInParent().getHeight()!=-1){
            System.out.println(ball.getBall().getLayoutY());
            if(path3.getStroke()==ball.getBall().getFill()||ball.getBall().getFill()==Color.SNOW){
                System.out.println("YIP");
            }
            else{
                System.out.println("GAME OVER");
                check=true;
            }
            System.out.println("PP");
        }
        else if(intersect4.getBoundsInParent().getHeight()!=-1){
            System.out.println(ball.getBall().getLayoutY());
            if(path4.getStroke()==ball.getBall().getFill()||ball.getBall().getFill()==Color.SNOW){
                System.out.println("YIP");
            }
            else{
                System.out.println("GAME OVER");
                check=true;
            }
            System.out.println("PP");
        }
    }
    public boolean getCheck(){
        return check;
    }
}
