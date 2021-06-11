package sample;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball  {
    private int x;
    private double y;
    private int r;
    private String color;
    private Circle ball;

    public Ball(int x, double y, int r) {
        this.x=x;
        this.y=y;
        this.r=r;
        ball = new Circle(x,y,r);
        this.color="b";
        ball.setFill(Color.BLUE);
    }
    public void AddScreen(Group root){
        root.getChildren().addAll(ball);
    }
    public Circle getBall(){
        return ball;
    }
    public void setColor(Ball ball,int i){
        if(i%8==1)
        {
            int random1=1+(int)(Math.random()*3);
            if(random1==1)
            {
                if(!ball.getColor().equals("b")) {
                    ball.getBall().setFill(Color.BLUE);
                    ball.color="b";
                }
                else
                {
                    ball.getBall().setFill(Color.YELLOW);
                    ball.color="y";
                }
            }

            else if(random1==2)
            {
                if(!ball.getColor().equals("r")) {
                    ball.getBall().setFill(Color.RED);
                    ball.color="r";
                }
                else
                {
                    ball.getBall().setFill(Color.BLUE);
                    ball.color="b";
                }
            }
            else if(random1==3)
            {
                if(!ball.getColor().equals("y")) {
                    ball.getBall().setFill(Color.YELLOW);
                    ball.color="y";
                }
                else
                {
                    ball.getBall().setFill(Color.RED);
                    ball.color="r";
                }
            }
        }
        else {
            int random1=1+(int)(Math.random()*4);
            if(random1==1)
            {
                if(!ball.getColor().equals("b")) {
                    ball.getBall().setFill(Color.BLUE);
                    ball.color="b";
                }
                else
                {
                    ball.getBall().setFill(Color.HOTPINK);
                    ball.color="p";
                }
            }

            else if(random1==2)
            {
                if(!this.getColor().equals("r")) {
                    ball.getBall().setFill(Color.RED);
                    ball.color="r";
                }
                else
                {
                    ball.getBall().setFill(Color.BLUE);
                    ball.color="b";
                }
            }
            else if(random1==3)
            {
                if(!ball.getColor().equals("y")) {
                    ball.getBall().setFill(Color.YELLOW);
                    ball.color="y";
                }
                else
                {
                    ball.getBall().setFill(Color.RED);
                    ball.color="r";
                }
            }

            else
            {
                if(!ball.getColor().equals("p")) {
                    ball.getBall().setFill(Color.HOTPINK);
                    ball.color="p";
                }
                else
                {
                    ball.getBall().setFill(Color.YELLOW);
                    ball.color="y";
                }
            }
        }
    }
    public void setY(int y){
        this.y=this.y-y;
    }
    public double getY(){
        return this.y;
    }

    public String getColor()
    {
        return this.color;
    }
}