package sample;
import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;


public class Triangle extends Obstacles{
    private Path path1;
    private Path path2;
    private Path path3;
    Rotate R1=new Rotate();
    Rotate R2=new Rotate();
    Rotate R3=new Rotate();
    private boolean check=false;
    public Triangle(int side, int x, int y,int width,boolean check) throws Exception
    {
        super(x,y,side,width,check);

        path1 = new Path();
        path1.setStrokeWidth(width);
        path1.setStroke(Color.BLUE);
        MoveTo moveTo1 = new MoveTo(x, y+side/(Math.sqrt(3)));

        LineTo line1 = new LineTo(x+side/2, y-side/(2*Math.sqrt(3)));

        path2 =new Path();
        MoveTo moveTo2=new MoveTo(x+side/2, y-side/(2*Math.sqrt(3)));
        path2.setStrokeWidth(width);
        path2.setStroke(Color.YELLOW);
        LineTo Line2 =new LineTo(x-side/2, y-side/(2*Math.sqrt(3)));

        path3 =new Path();
        MoveTo moveTo3=new MoveTo(x-side/2, y-side/(2*Math.sqrt(3)));
        path3.setStrokeWidth(width);
        path3.setStroke(Color.RED);
        LineTo Line3 =new LineTo(x, y+side/(Math.sqrt(3)));

        path1.getElements().add(moveTo1);
        path1.getElements().addAll(line1);

        path2.getElements().add(moveTo2);
        path2.getElements().addAll(Line2);

        path3.getElements().add(moveTo3);
        path3.getElements().addAll(Line3);


        path1.getTransforms().add(R1);
        R1.setPivotX(x);
        R1.setPivotY(y);
        Timeline t1 = new Timeline();
        t1.setCycleCount(Animation.INDEFINITE);
        t1.getKeyFrames().add(new KeyFrame(Duration.millis(4000),new KeyValue(R1.angleProperty(),360)));
        t1.play();


        path2.getTransforms().add(R2);
        R2.setPivotX(x);
        R2.setPivotY(y);
        Timeline t2 = new Timeline();
        t2.setCycleCount(Animation.INDEFINITE);
        t2.getKeyFrames().add(new KeyFrame(Duration.millis(4000),new KeyValue(R2.angleProperty(),360)));
        t2.play();


        path3.getTransforms().add(R3);
        R3.setPivotX(x);
        R3.setPivotY(y);
        Timeline t3 = new Timeline();
        t3.setCycleCount(Animation.INDEFINITE);
        t3.getKeyFrames().add(new KeyFrame(Duration.millis(4000),new KeyValue(R3.angleProperty(),360)));
        t3.play();
    }
    public void AddScreen(Group root){
        root.getChildren().addAll(path1,path2,path3);
    }
    public void checkInteraction(Ball ball){
        System.out.println(ball.getBall().getFill()==path1.getStroke());
        Shape intersect1 = Shape.intersect(ball.getBall(),path1);
        Shape intersect2 = Shape.intersect(ball.getBall(),path2);
        Shape intersect3 = Shape.intersect(ball.getBall(),path3);
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
    }
    public boolean getCheck(){
        return check;
    }
}

