package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Cross extends Obstacles{
    private Path path1;
    private Path path2;
    private Path path3;
    private Path path4;
    private boolean check=false;
    public Cross(int side, int x, int y,int width,boolean check) throws Exception
    {
        super(x,y,side,width,check);
        path1=new Path();
        path1.setStroke(Color.RED);
        path1.setStrokeWidth(width);
        MoveTo moveTo1=new MoveTo(x,y);
        LineTo lineTo1=new LineTo(x+side,y);

        path2=new Path();
        path2.setStrokeWidth(width);
        path2.setStroke(Color.YELLOW);
        MoveTo moveTo2=new MoveTo(x,y);
        LineTo LineTo2=new LineTo(x-side,y);

        path3=new Path();
        path3.setStrokeWidth(width);
        path3.setStroke(Color.BLUE);
        MoveTo moveTo3=new MoveTo(x,y);
        LineTo lineTo3=new LineTo(x,y-side);

        path4=new Path();
        path4.setStrokeWidth(width);
        path4.setStroke(Color.HOTPINK);
        MoveTo moveTo4=new MoveTo(x,y);
        LineTo lineTo4 =new LineTo(x,y+side);

        path1.getElements().add(moveTo1);
        path1.getElements().addAll(lineTo1);

        path2.getElements().add(moveTo2);
        path2.getElements().addAll(LineTo2);

        path3.getElements().add(moveTo3);
        path3.getElements().addAll(lineTo3);

        path4.getElements().add(moveTo4);
        path4.getElements().addAll(lineTo4);

        Rotate r1 = new Rotate();
        path1.getTransforms().add(r1);
        r1.setPivotX(x);
        r1.setPivotY(y);
        Timeline t1 = new Timeline();
        t1.setCycleCount(Animation.INDEFINITE);
        t1.getKeyFrames().add(new KeyFrame(Duration.millis(4000),new KeyValue(r1.angleProperty(),360)));
        t1.play();

        Rotate r2=new Rotate();
        path2.getTransforms().add(r2);
        r2.setPivotY(y);
        r2.setPivotX(x);
        Timeline t2=new Timeline();
        t2.setCycleCount(Animation.INDEFINITE);
        t2.getKeyFrames().add(new KeyFrame(Duration.millis(4000),new KeyValue(r2.angleProperty(),360)));
        t2.play();

        Rotate r3=new Rotate();
        path3.getTransforms().add(r3);
        r3.setPivotY(y);
        r3.setPivotX(x);
        Timeline t3=new Timeline();
        t3.setCycleCount(Animation.INDEFINITE);
        t3.getKeyFrames().add(new KeyFrame(Duration.millis(4000),new KeyValue(r3.angleProperty(),360)));
        t3.play();

        Rotate r4=new Rotate();
        path4.getTransforms().add(r4);
        r4.setPivotY(y);
        r4.setPivotX(x);
        Timeline t4=new Timeline();
        t4.setCycleCount(Animation.INDEFINITE);
        t4.getKeyFrames().add(new KeyFrame(Duration.millis(4000),new KeyValue(r4.angleProperty(),360)));
        t4.play();
    }
    public void AddScreen(Group root){
        root.getChildren().addAll(path1,path2,path3,path4);
    }
    public void checkInteraction(Ball ball){
        Shape intersect1 = Shape.intersect(ball.getBall(),path1);
        Shape intersect2 = Shape.intersect(ball.getBall(),path2);
        Shape intersect3 = Shape.intersect(ball.getBall(),path3);
        Shape intersect4 = Shape.intersect(ball.getBall(),path4);
        if(intersect1.getBoundsInParent().getHeight()!=-1){
            if(path1.getStroke()==ball.getBall().getFill()||ball.getBall().getFill()==Color.SNOW){
                System.out.println("YIP");
            }
            else{
                System.out.println("GAME OVER");
                check=true;
            }

        }
        else if(intersect2.getBoundsInParent().getHeight()!=-1){
            if(path2.getStroke()==ball.getBall().getFill()||ball.getBall().getFill()==Color.SNOW){
                System.out.println("YIP");
            }
            else{
                System.out.println("GAME OVER");
                check=true;
            }
        }
        else if(intersect3.getBoundsInParent().getHeight()!=-1){
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

