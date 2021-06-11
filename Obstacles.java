package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.stage.Stage;

public class Obstacles {
    private int x;
    private int y;
    private int size;
    private int width;
    private boolean check;
    public Obstacles(int x,int y,int size,int width,boolean check){
        this.x=x;
        this.y=y;
        this.size=size;
        this.width=width;
        this.check=check;
    }
    public void checkInteraction(Ball ball){

    }
    public void AddScreen(Group root){

    }
    public int getXval(){
        return x;
    }
    public int getYval(){
        return y;
    }
    public int getSize(){
        return size;
    }
    public int getWidth(){
        return width;
    }
    public boolean getCheck(){
        return check;
    }
}
