package sample;

import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Square extends Obstacles{

    private Path path1;
    private Path path2;
    private Path path3;
    private Path path4;
    private boolean check=false;
    public Square(int side, int x, int y,int width,boolean check) throws Exception{
        super(x,y,side/2,width,check);
        int d = side/2;
        path1 = new Path();
        path1.setStrokeWidth(width);
        path1.setStroke(Color.BLUE);
        MoveTo moveTo1 = new MoveTo(x-d, y-d);
        LineTo line1 = new LineTo(x+d, y-d);

        path2 = new Path();
        path2.setStrokeWidth(width);
        path2.setStroke(Color.HOTPINK);
        MoveTo moveTo2 = new MoveTo(x+d,y-d);
        LineTo line2 =new LineTo(x+d,y+d);

        path3 = new Path();
        path3.setStrokeWidth(width);
        path3.setStroke(Color.YELLOW);
        MoveTo moveTo3 = new MoveTo(x+d,y+d);
        LineTo line3 =new LineTo(x-d,y+d);

        path4 = new Path();
        path4.setStrokeWidth(width);
        path4.setStroke(Color.RED);
        MoveTo moveTo4 = new MoveTo(x-d,y+d);
        LineTo line4 =new LineTo(x-d,y-d);

        Rotate r1 = new Rotate();
        Rotate r2 = new Rotate();
        Rotate r3 = new Rotate();
        Rotate r4 = new Rotate();

        path1.getTransforms().add(r1);
        r1.setPivotX(x);
        r1.setPivotY(y);
        Timeline t = new Timeline();
        t.setCycleCount(Animation.INDEFINITE);
        t.getKeyFrames().add(new KeyFrame(Duration.millis(4000),new KeyValue(r1.angleProperty(),360)));
        t.play();



        path2.getTransforms().add(r2);
        r2.setPivotX(x);
        r2.setPivotY(y);
        Timeline t1 = new Timeline();
        t1.setCycleCount(Animation.INDEFINITE);
        t1.getKeyFrames().add(new KeyFrame(Duration.millis(4000),new KeyValue(r2.angleProperty(),360)));
        t1.play();


        path3.getTransforms().add(r3);
        r3.setPivotX(x);
        r3.setPivotY(y);
        Timeline t2 = new Timeline();
        t2.setCycleCount(Animation.INDEFINITE);
        t2.getKeyFrames().add(new KeyFrame(Duration.millis(4000),new KeyValue(r3.angleProperty(),360)));
        t2.play();


        path4.getTransforms().add(r4);
        r4.setPivotX(x);
        r4.setPivotY(y);
        Timeline t3 = new Timeline();
        t3.setCycleCount(Animation.INDEFINITE);
        t3.getKeyFrames().add(new KeyFrame(Duration.millis(4000),new KeyValue(r4.angleProperty(),360)));
        t3.play();

        path1.getElements().add(moveTo1);
        path1.getElements().addAll(line1);

        path2.getElements().add(moveTo2);
        path2.getElements().addAll(line2);

        path3.getElements().add(moveTo3);
        path3.getElements().addAll(line3);

        path4.getElements().add(moveTo4);
        path4.getElements().addAll(line4);
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
