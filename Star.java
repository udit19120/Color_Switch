package sample;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;

public class Star {

    private int side;
    private int x;
    private int y;
    private Path path1;
    private Path path2;
    private boolean check=true;
    public Star(int side, int x, int y) {
        this.check=true;
        this.side=side;
        this.x = x;
        this.y = y;
        path1 = new Path();
        path1.setStrokeWidth(1);
        path1.setStroke(Color.WHITE);
        MoveTo moveTo1 = new MoveTo(x, y + side / (Math.sqrt(3)));

        LineTo line1 = new LineTo(x + side / 2, y - side / (2 * Math.sqrt(3)));
        LineTo Line2 = new LineTo(x - side / 2, y - side / (2 * Math.sqrt(3)));
        LineTo Line3 = new LineTo(x, y + side / (Math.sqrt(3)));

        path1.getElements().add(moveTo1);
        path1.getElements().addAll(line1,Line2,Line3);
        path1.setFill(Color.WHITE);

        path2 = new Path();
        path2.setStrokeWidth(1);
        path2.setStroke(Color.WHITE);
        MoveTo moveTo21 = new MoveTo(x, y + side / (Math.sqrt(3)));
        LineTo line21 = new LineTo(x + side / 2, y - side / (2 * Math.sqrt(3)));
        LineTo Line22 = new LineTo(x - side / 2, y - side / (2 * Math.sqrt(3)));
        LineTo Line23 = new LineTo(x, y + side / (Math.sqrt(3)));

        path2.getElements().add(moveTo1);
        path2.getElements().addAll(line21,Line22,Line23);
        path2.setFill(Color.WHITE);
        Rotate R1=new Rotate();
        path1.getTransforms().add(R1);
        R1.setPivotX(x);
        R1.setPivotY(y);
        R1.setAngle(180);
    }
    public Star(){

    }

    public void AddScreen(Group root){
        root.getChildren().addAll(path1,path2);
    }
    public boolean CheckInteraction(Ball ball){
        Shape intersect1 = Shape.intersect(path1,ball.getBall());
        Shape interset2 = Shape.intersect(path2,ball.getBall());
        if(intersect1.getBoundsInParent().getHeight()!=-1 || interset2.getBoundsInParent().getHeight()!=-1){
            return true;
        }
        else{
            return false;
        }
    }
    public void Invsible(Group root){
        path1.setVisible(false);
        path2.setVisible(false);
    }

    public void setCheck()
    {
        this.check=false;
    }

    public boolean getCheck()
    {
        return this.check;
    }
}