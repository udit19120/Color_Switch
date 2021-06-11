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

public class Cross_Circle extends Obstacles{


    private Path pathC1;
    private Path pathC2;
    private Path pathC3;
    private Path pathC4;
    private Path path1;
    private Path path2;
    private Path path3;
    private Path path4;
    private boolean check=false;

    public Cross_Circle(int side, int x, int y,int width,boolean check) throws Exception
    {
        super(x,y,side,width,check);
        int xx=x+side-3;

        int radius=2*side;
        int center_x=x;
        int center_y=y;


        pathC1 = new Path();
        pathC1.setStrokeWidth(width);
        pathC1.setStroke(Color.RED);
        MoveTo moveToC1 = new MoveTo(center_x,center_y+radius);
        ArcTo arc1 = new ArcTo();
        arc1.setX(center_x+radius);
        arc1.setY(center_y);

        arc1.setRadiusX(radius);
        arc1.setRadiusY(radius);


        pathC2 = new Path();
        pathC2.setStrokeWidth(width);
        pathC2.setStroke(Color.BLUE);
        MoveTo moveToC2 = new MoveTo(center_x+radius,center_y);
        ArcTo arc2 = new ArcTo();
        arc2.setX(center_x);
        arc2.setY(center_y-radius);

        arc2.setRadiusX(radius);
        arc2.setRadiusY(radius);

        pathC3 = new Path();
        pathC3.setStrokeWidth(width);
        pathC3.setStroke(Color.YELLOW);
        MoveTo moveToC3 = new MoveTo(center_x,center_y-radius);
        ArcTo arc3 = new ArcTo();
        arc3.setX(center_x-radius);
        arc3.setY(center_y);

        arc3.setRadiusX(radius);
        arc3.setRadiusY(radius);

        pathC4 = new Path();
        pathC4.setStrokeWidth(width);
        pathC4.setStroke(Color.HOTPINK);
        MoveTo moveToC4= new MoveTo(center_x-radius,center_y);
        ArcTo arc4 = new ArcTo();
        arc4.setX(center_x);
        arc4.setY(center_y+radius);

        arc4.setRadiusX(radius);
        arc4.setRadiusY(radius);

        Rotate rc1 = new Rotate();
        Rotate rc2 = new Rotate();
        Rotate rc3 = new Rotate();
        Rotate rc4 = new Rotate();
        pathC1.getTransforms().add(rc1);
        rc1.setPivotX(center_x);
        rc1.setPivotY(center_y);
        Timeline tc1 = new Timeline();
        //r1.setAxis(se);
        tc1.setCycleCount(Animation.INDEFINITE);
        tc1.getKeyFrames().add(new KeyFrame(Duration.millis(4000),new KeyValue(rc1.angleProperty(),-360)));
        tc1.play();
        pathC2.getTransforms().add(rc2);
        rc2.setPivotX(center_x);
        rc2.setPivotY(center_y);
        Timeline tc2 = new Timeline();
        tc2.setCycleCount(Animation.INDEFINITE);
        tc2.getKeyFrames().add(new KeyFrame(Duration.millis(4000),new KeyValue(rc2.angleProperty(),-360)));
        tc2.play();

        pathC3.getTransforms().add(rc3);
        rc3.setPivotX(center_x);
        rc3.setPivotY(center_y);
        Timeline tc3 = new Timeline();
        tc3.setCycleCount(Animation.INDEFINITE);
        tc3.getKeyFrames().add(new KeyFrame(Duration.millis(4000),new KeyValue(rc3.angleProperty(),-360)));
        tc3.play();

        pathC4.getTransforms().add(rc4);
        rc4.setPivotX(center_x);
        rc4.setPivotY(center_y);
        Timeline tc4 = new Timeline();
        tc4.setCycleCount(Animation.INDEFINITE);
        tc4.getKeyFrames().add(new KeyFrame(Duration.millis(4000),new KeyValue(rc4.angleProperty(),-360)));
        tc4.play();

        pathC1.getElements().add(moveToC1);
        pathC1.getElements().add(arc1);
        pathC2.getElements().add(moveToC2);
        pathC2.getElements().add(arc2);
        pathC3.getElements().add(moveToC3);
        pathC3.getElements().add(arc3);
        pathC4.getElements().add(moveToC4);
        pathC4.getElements().add(arc4);



        path1=new Path();
        path1.setStroke(Color.YELLOW);
        path1.setStrokeWidth(width);
        MoveTo moveTo1=new MoveTo(xx,y);
        LineTo lineTo1=new LineTo(xx+side,y);

        path2=new Path();
        path2.setStrokeWidth(width);
        path2.setStroke(Color.RED);
        MoveTo moveTo2=new MoveTo(xx,y);
        LineTo LineTo2=new LineTo(xx-side,y);

        path3=new Path();
        path3.setStrokeWidth(width);
        path3.setStroke(Color.BLUE);
        MoveTo moveTo3=new MoveTo(xx,y);
        LineTo lineTo3=new LineTo(xx,y-side);

        path4=new Path();
        path4.setStrokeWidth(width);
        path4.setStroke(Color.HOTPINK);
        MoveTo moveTo4=new MoveTo(xx,y);
        LineTo lineTo4 =new LineTo(xx,y+side);

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
        r1.setPivotX(xx);
        r1.setPivotY(y);
        Timeline t1 = new Timeline();
        t1.setCycleCount(Animation.INDEFINITE);
        t1.getKeyFrames().add(new KeyFrame(Duration.millis(4020),new KeyValue(r1.angleProperty(),360)));
        t1.play();

        Rotate r2=new Rotate();
        path2.getTransforms().add(r2);
        r2.setPivotY(y);
        r2.setPivotX(xx);
        Timeline t2=new Timeline();
        t2.setCycleCount(Animation.INDEFINITE);
        t2.getKeyFrames().add(new KeyFrame(Duration.millis(4020),new KeyValue(r2.angleProperty(),360)));
        t2.play();

        Rotate r3=new Rotate();
        path3.getTransforms().add(r3);
        r3.setPivotY(y);
        r3.setPivotX(xx);
        Timeline t3=new Timeline();
        t3.setCycleCount(Animation.INDEFINITE);
        t3.getKeyFrames().add(new KeyFrame(Duration.millis(4020),new KeyValue(r3.angleProperty(),360)));
        t3.play();

        Rotate r4=new Rotate();
        path4.getTransforms().add(r4);
        r4.setPivotY(y);
        r4.setPivotX(xx);
        Timeline t4=new Timeline();
        t4.setCycleCount(Animation.INDEFINITE);
        t4.getKeyFrames().add(new KeyFrame(Duration.millis(4020),new KeyValue(r4.angleProperty(),360)));
        t4.play();
    }
    public void AddScreen(Group root){
        root.getChildren().addAll(path1,path2,path3,path4, pathC1,pathC2,pathC3,pathC4);
    }
    public void checkInteraction(Ball ball) {
        Shape intersect1 = Shape.intersect(ball.getBall(), pathC1);
        Shape intersect2 = Shape.intersect(ball.getBall(), pathC2);
        Shape intersect3 = Shape.intersect(ball.getBall(), pathC3);
        Shape intersect4 = Shape.intersect(ball.getBall(), pathC4);

        Shape intersect1x = Shape.intersect(ball.getBall(), path1);
        Shape intersect2x = Shape.intersect(ball.getBall(), path2);
        Shape intersect3x = Shape.intersect(ball.getBall(), path3);
        Shape intersect4x = Shape.intersect(ball.getBall(), path4);
        if (intersect1.getBoundsInParent().getHeight() != -1) {
            if (pathC1.getStroke() == ball.getBall().getFill()||ball.getBall().getFill()==Color.SNOW) {
                System.out.println("YIP");

            }
            else {
                System.out.println("GAME OVER");
                check=true;
            }
        }
        else if (intersect2.getBoundsInParent().getHeight() != -1) {
            if (pathC2.getStroke() == ball.getBall().getFill()||ball.getBall().getFill()==Color.SNOW) {
                System.out.println("YIP");
            } else {
                System.out.println("GAME OVER");
                check=true;
            }
        } else if (intersect3.getBoundsInParent().getHeight() != -1) {
            if (pathC3.getStroke() == ball.getBall().getFill()||ball.getBall().getFill()==Color.SNOW) {
                System.out.println("YIP");
            } else {
                System.out.println("GAME OVER");
                check=true;
            }
            System.out.println("PP");
        } else if (intersect4.getBoundsInParent().getHeight() != -1) {
            if (pathC4.getStroke() == ball.getBall().getFill()||ball.getBall().getFill()==Color.SNOW) {
                System.out.println("YIP");
            } else {
                System.out.println("GAME OVER");
                check=true;
            }
            System.out.println("PP");
        }

        if (intersect1x.getBoundsInParent().getHeight() != -1) {
            if (path1.getStroke() == ball.getBall().getFill()||ball.getBall().getFill()==Color.SNOW) {
                System.out.println("YIP");
            } else {
                System.out.println("GAME OVER");
                check=true;
            }
        } else if (intersect2x.getBoundsInParent().getHeight() != -1) {
            if (path2.getStroke() == ball.getBall().getFill()||ball.getBall().getFill()==Color.SNOW) {
                System.out.println("YIP");
            } else {
                System.out.println("GAME OVER");
                check=true;
            }
        } else if (intersect3x.getBoundsInParent().getHeight() != -1) {
            if (path3.getStroke() == ball.getBall().getFill()||ball.getBall().getFill()==Color.SNOW) {
                System.out.println("YIP");
            } else {
                System.out.println("GAME OVER");
                check=true;
            }
        } else if (intersect4x.getBoundsInParent().getHeight() != -1) {
            if (path4.getStroke() == ball.getBall().getFill()||ball.getBall().getFill()==Color.SNOW) {
                System.out.println("YIP");
            } else {
                System.out.println("GAME OVER");
                check=true;
            }
        }
    }
    public void Common(Ball ball,Shape intersect1x,Shape intersect2x,Shape intersect3x,Shape intersect4x){

    }
    public boolean getCheck(){
        return check;
    }
}
