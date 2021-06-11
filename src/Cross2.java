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

public class Cross2 extends Obstacles{
    private Path path1;
    private Path path2;
    private Path path3;
    private Path path4;
    private Path path21;
    private Path path22;
    private Path path23;
    private Path path24;
    private boolean check=false;
    public Cross2(int side, int x, int y,int width,boolean check) throws Exception
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

        int x2=x+2*side;

        path21=new Path();
        path21.setStroke(Color.RED);
        path21.setStrokeWidth(width);
        MoveTo moveTo21=new MoveTo(x2,y);
        LineTo lineTo21=new LineTo(x2-side,y);

        path22=new Path();
        path22.setStrokeWidth(width);
        path22.setStroke(Color.YELLOW);
        MoveTo moveTo22=new MoveTo(x2,y);
        LineTo LineTo22=new LineTo(x2+side,y);

        path23=new Path();
        path23.setStrokeWidth(width);
        path23.setStroke(Color.BLUE);
        MoveTo moveTo23=new MoveTo(x2,y);
        LineTo lineTo23=new LineTo(x2,y-side);

        path24=new Path();
        path24.setStrokeWidth(width);
        path24.setStroke(Color.HOTPINK);
        MoveTo moveTo24=new MoveTo(x2,y);
        LineTo lineTo24 =new LineTo(x2,y+side);

        path21.getElements().add(moveTo21);
        path21.getElements().addAll(lineTo21);

        path22.getElements().add(moveTo22);
        path22.getElements().addAll(LineTo22);

        path23.getElements().add(moveTo23);
        path23.getElements().addAll(lineTo23);

        path24.getElements().add(moveTo24);
        path24.getElements().addAll(lineTo24);

        Rotate r21 = new Rotate();
        path21.getTransforms().add(r21);
        r21.setPivotX(x2);
        r21.setPivotY(y);
        Timeline t21 = new Timeline();
        t21.setCycleCount(Animation.INDEFINITE);
        t21.getKeyFrames().add(new KeyFrame(Duration.millis(4000),new KeyValue(r21.angleProperty(),-360)));
        t21.play();

        Rotate r22=new Rotate();
        path22.getTransforms().add(r22);
        r22.setPivotY(y);
        r22.setPivotX(x2);
        Timeline t22=new Timeline();
        t22.setCycleCount(Animation.INDEFINITE);
        t22.getKeyFrames().add(new KeyFrame(Duration.millis(4000),new KeyValue(r22.angleProperty(),-360)));
        t22.play();

        Rotate r23=new Rotate();
        path23.getTransforms().add(r23);
        r23.setPivotY(y);
        r23.setPivotX(x2);
        Timeline t23=new Timeline();
        t23.setCycleCount(Animation.INDEFINITE);
        t23.getKeyFrames().add(new KeyFrame(Duration.millis(4000),new KeyValue(r23.angleProperty(),-360)));
        t23.play();

        Rotate r24=new Rotate();
        path24.getTransforms().add(r24);
        r24.setPivotY(y);
        r24.setPivotX(x2);
        Timeline t24=new Timeline();
        t24.setCycleCount(Animation.INDEFINITE);
        t24.getKeyFrames().add(new KeyFrame(Duration.millis(4000),new KeyValue(r24.angleProperty(),-360)));
        t24.play();
    }
    public void AddScreen(Group root) {
        root.getChildren().addAll(path1, path2, path3, path4, path21, path22, path23, path24);
    }
    public void checkInteraction(Ball ball) {
        Shape intersect1 = Shape.intersect(ball.getBall(), path1);
        Shape intersect2 = Shape.intersect(ball.getBall(), path2);
        Shape intersect3 = Shape.intersect(ball.getBall(), path3);
        Shape intersect4 = Shape.intersect(ball.getBall(), path4);

        Shape intersect1x = Shape.intersect(ball.getBall(), path21);
        Shape intersect2x = Shape.intersect(ball.getBall(), path22);
        Shape intersect3x = Shape.intersect(ball.getBall(), path23);
        Shape intersect4x = Shape.intersect(ball.getBall(), path24);
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
            if (path21.getStroke() == ball.getBall().getFill()||ball.getBall().getFill()==Color.SNOW) {
                System.out.println("YIP");
            } else {
                System.out.println("GAME OVER");
                check=true;
            }
        } else if (intersect2x.getBoundsInParent().getHeight() != -1) {
            if (path22.getStroke() == ball.getBall().getFill()||ball.getBall().getFill()==Color.SNOW) {
                System.out.println("YIP");
            } else {
                System.out.println("GAME OVER");
                check=true;
            }
        } else if (intersect3x.getBoundsInParent().getHeight() != -1) {
            if (path23.getStroke() == ball.getBall().getFill()||ball.getBall().getFill()==Color.SNOW) {
                System.out.println("YIP");
            } else {
                System.out.println("GAME OVER");
                check=true;
            }
        } else if (intersect4x.getBoundsInParent().getHeight() != -1) {
            if (path24.getStroke() == ball.getBall().getFill()||ball.getBall().getFill()==Color.SNOW) {
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

