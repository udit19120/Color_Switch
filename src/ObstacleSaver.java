package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class ObstacleSaver {
    private Circle ObstacleSaver;
    private boolean check;
    private int x;
    private  int y;
    private int r;
    public ObstacleSaver(int x, int y, int r, boolean check){
        this.x=x;
        this.y=y;
        this.r=r;
        this.check=check;
        ObstacleSaver = new Circle(x,y,r);
        ObstacleSaver.setFill(Color.GOLD);
    }
    public void AddScreen(Group root){
        root.getChildren().addAll(ObstacleSaver);

    }
    public boolean Action(Ball ball){
        Shape intersect = Shape.intersect(ball.getBall(),ObstacleSaver);
        if(intersect.getBoundsInParent().getHeight()!=-1){
            ObstacleSaver.setVisible(false);
            ball.getBall().setFill(Color.SNOW);
            return true;
        }
        else {
            return false;
        }
    }
    public void Invisible(){
        ObstacleSaver.setVisible(false);
    }
    public double getPos(){
        return y+r;
    }

    public boolean getCheck()
    {
        return check;
    }

    public void setCheck()
    {
        check=true;
    }
}
