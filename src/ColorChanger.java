package sample;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

public class ColorChanger  {
    private int x;
    private int y;
    private int r;
    private Arc arc1= new Arc();
    private Arc arc2= new Arc();
    private Arc arc3= new Arc();
    private Arc arc4= new Arc();
    private boolean check;
    public ColorChanger(int x,int y,int r,boolean check){
        this.x=x;
        this.y=y;
        this.r=r;
        this.check=check;
        arc1.setCenterX(x);
        arc1.setCenterY(y);
        arc1.setRadiusX(r);
        arc1.setRadiusY(r);
        arc1.setStartAngle(90.0f);
        arc1.setLength(90.0f);
        arc1.setType(ArcType.ROUND);
        arc1.setFill(Color.RED);

        arc2.setCenterX(x);
        arc2.setCenterY(y);
        arc2.setRadiusX(r);
        arc2.setRadiusY(r);
        arc2.setStartAngle(180);
        arc2.setLength(90.0f);
        arc2.setType(ArcType.ROUND);
        arc2.setFill(Color.BLUE);

        arc3.setCenterX(x);
        arc3.setCenterY(y);
        arc3.setRadiusX(r);
        arc3.setRadiusY(r);
        arc3.setStartAngle(-90.0f);
        arc3.setLength(90.0f);
        arc3.setType(ArcType.ROUND);
        arc3.setFill(Color.YELLOW);

        arc4.setCenterX(x);
        arc4.setCenterY(y);
        arc4.setRadiusX(r);
        arc4.setRadiusY(r);
        arc4.setStartAngle(0.0f);
        arc4.setLength(90.0f);
        arc4.setType(ArcType.ROUND);
        arc4.setFill(Color.HOTPINK);
    }
    public void AddScreen(Group root){
        root.getChildren().addAll(arc1,arc2,arc3,arc4);
    }

    public boolean Action(Ball ball, int i){
        Shape intersect1 = Shape.intersect(ball.getBall(),arc1);
        Shape intersect2 = Shape.intersect(ball.getBall(),arc2);
        Shape intersect3 = Shape.intersect(ball.getBall(),arc3);
        Shape intersect4 = Shape.intersect(ball.getBall(),arc4);
        if(intersect1.getBoundsInParent().getHeight()!=-1||intersect2.getBoundsInParent().getHeight()!=-1||intersect3.getBoundsInParent().getHeight()!=-1||intersect4.getBoundsInParent().getHeight()!=-1)
        {
            arc1.setVisible(false);
            arc2.setVisible(false);
            arc3.setVisible(false);
            arc4.setVisible(false);
            ball.setColor(ball,i);
            return true;
        }
        else{
            return false;
        }

    }
    public void Invisible(){
        arc1.setVisible(false);
        arc2.setVisible(false);
        arc3.setVisible(false);
        arc4.setVisible(false);
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
