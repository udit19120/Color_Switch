package sample;
import javafx.animation.*;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.*;
import java.util.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;

public class Reverse implements Serializable
{
    transient Image pauseImage;
    boolean gameover=false;
    transient ImageView imageView;
    private transient int starsBeforeRev;
    transient ImageView img;
    transient Timeline timeline;
    transient Timeline timeline1;
    private double moveScreen = 0;
    private transient int counter = 0;
    private int colored = 0;
    private int save=0;
    private transient Timer timer;
    private int starsCollected = 0;
    private int starsCount=0;
    private transient ArrayList<Circle> Circles = new ArrayList<>(50);
    private transient ArrayList<Triangle> triangles = new ArrayList<>(50);
    private transient ArrayList<Cross_Circle> cross_circles = new ArrayList<>(50);
    private transient ArrayList<Tangent_Circles> tangent_circles = new ArrayList<>(50);
    private transient ArrayList<Cross2> cross2s = new ArrayList<>(50);
    private transient ArrayList<Concentric_Circle> concentric_circles = new ArrayList<>(50);
    private transient ArrayList<Square> squares = new ArrayList<>(50);
    private transient ArrayList<Cross> crosses = new ArrayList<>(50);
    private transient ArrayList<Star> stars = new ArrayList<>(400);
    private transient ArrayList<ColorChanger> colorChangers = new ArrayList<>(200);
    private transient ArrayList<ObstacleSaver> obstacleSavers  = new ArrayList<>(200);
    private transient Ball ball;
    private String colorBall;
    private int obstacleID;
    private double ballLayoutY;

    private transient ArrayList<Obstacles> obstacles = new ArrayList<>(400);
    private transient int down = 150;
    private transient Group rootx = new Group();
    private transient DieScreen2 die = new DieScreen2();
    private transient Scene dieScene;
    private transient Group root;
    private transient Scene scenex;
    private transient Stage stage;
    private transient Object BigStar=new BigStar();
    private transient int up =0;
    private int numObstacles;
    private int numStars;
    private int obstacle_y;
    private int numColor;
    private int obstSave;
    private int numObstaclesAdd=1;


    public Reverse(Group root, Scene scene, Stage stage, Scene scenex,Integer starsSoFar, DieScreen2 dieScreen)throws Exception
    {
        this.scenex=scenex;
        this.root=root;
        this.stage=stage;
        pauseImage = new Image(new FileInputStream("..\\Users\\91995\\IdeaProjects\\HelloWorldFX\\src\\sample\\pause.png"));
        dieScene = new Scene(rootx, 600, 700);
        die.AddScreen(rootx);
        numObstacles = 0;
        numStars = 0;
        obstacle_y = 350;
        numColor = 0;
        obstSave=0;

        addObstacles();

        if(counter%400==0 && counter!=0)
        {
            addObstacles();
        }

        imageView = new ImageView(pauseImage);
        imageView.setX(500);
        imageView.setY(25);

        imageView.setFitHeight(25);
        imageView.setFitWidth(25);

        imageView.setPreserveRatio(true);

        Label text2 = new Label();
        text2.setAlignment(Pos.CENTER_RIGHT);
        text2.setTextFill(Color.WHITE);
        text2.setFont(new Font(16));
        text2.setPadding(new Insets(25, 30, 50, 25));

        root.getChildren().addAll(imageView, text2);
        ball = new Ball(300,150 , 10);
        ball.AddScreen(root);

        StartPlaying(starsSoFar, dieScreen);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode().equals(KeyCode.SPACE)) {
                    moveScreen -= 30;
                    text2.setText("Score: " + starsCollected);
                    System.out.println("Stars Collected" + starsCollected);
                    timeline = new Timeline(new KeyFrame(Duration.seconds(1500000), new KeyValue(ball.getBall().layoutYProperty(), 1000000000)));
                    timeline.setCycleCount(1);
                    timeline.play();
                    root.setLayoutY(moveScreen);
                    imageView.setLayoutY(-moveScreen);
                    text2.setLayoutY(-moveScreen);
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode().equals(KeyCode.SPACE)) {
                    moveScreen -= 100;
                    text2.setText("Score: " + starsCollected);
                    root.setLayoutY(moveScreen);
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode().equals(KeyCode.SPACE)) {
                    up += 10;
                    timeline1 = new Timeline(new KeyFrame(Duration.seconds(20), new KeyValue(ball.getBall().layoutYProperty(), up)));
                    timeline1.setCycleCount(1);
                    timeline1.play();
                }
            }
        });
    }
    public Reverse(Group root, Scene scene, Stage stage, Scene scenex, int intial_stars, double ballY,double mv,String color,Integer starsSoFar,int col,int strCt,int sv,int counterBall, DieScreen2 dieScreen) throws Exception {
        this.starsCollected = intial_stars;
        this.moveScreen = mv;
        this.scenex=scenex;
        this.stage=stage;
        this.root=root;
        this.colored=col;
        this.counter=strCt;
        this.starsCount=strCt;
        this.save=sv;
        starsBeforeRev=starsCollected;
        if(counter!=0){
            counter-=counterBall;
        }

        System.out.println(ballY);
        System.out.println("PPPPPPPPPPPP");
        pauseImage = new Image(new FileInputStream("C:\\Users\\91995\\IdeaProjects\\HelloWorldFX\\src\\sample\\pause.png"));
        dieScene = new Scene(rootx, 600, 700);
        die.AddScreen(rootx);
        numObstacles = 0;
        numStars = 0;
        obstacle_y = 350;
        numColor = 0;
        obstSave=0;

        while (numObstacles < 400 && numStars < 400 && numColor < 200) {
            obstacles.add(new Circle(300, obstacle_y, 70, 5, false));
            obstacles.get(numObstacles).AddScreen(root);
            stars.add(new Star(15, 300, obstacle_y));
            stars.get(numStars).AddScreen(root);
            numStars++;
            numObstacles++;
            obstacle_y += 400;

            obstacleSavers.add(new ObstacleSaver(300,obstacle_y+200,15,false));
            obstacleSavers.get(obstSave).AddScreen(root);
            obstSave++;

            obstacles.add(new Triangle(150, 300, obstacle_y, 5, false));
            obstacles.get(numObstacles).AddScreen(root);
            stars.add(new Star(15, 300, obstacle_y));
            stars.get(numStars).AddScreen(root);
            numObstacles++;
            numStars++;
            obstacle_y += 400;

            colorChangers.add(new ColorChanger(300, obstacle_y + 200, 15,false));
            colorChangers.get(numColor).AddScreen(root);
            numColor++;

            obstacles.add(new Cross2(60, 300 - 60, obstacle_y, 9, false));
            obstacles.get(numObstacles).AddScreen(root);
            stars.add(new BigStar(15, 300, obstacle_y));
            stars.get(numStars).AddScreen(root);
            numStars++;
            numObstacles++;
            obstacle_y += 400;

            obstacleSavers.add(new ObstacleSaver(300,obstacle_y+200,15,false));
            obstacleSavers.get(obstSave).AddScreen(root);
            obstSave++;

            obstacles.add(new Concentric_Circle(80, 300, obstacle_y, 5, false));
            obstacles.get(numObstacles).AddScreen(root);
            stars.add(new Star(15, 300, obstacle_y));
            stars.get(numStars).AddScreen(root);
            numStars++;
            numObstacles++;
            obstacle_y += 400;

            colorChangers.add(new ColorChanger(300, obstacle_y + 200, 15,false));
            colorChangers.get(numColor).AddScreen(root);
            numColor++;

            obstacles.add(new Tangent_Circles(60, 300, obstacle_y, 5, false));
            obstacles.get(numObstacles).AddScreen(root);
            stars.add(new Star(15, 300, obstacle_y));
            stars.get(numStars).AddScreen(root);
            numStars++;
            numObstacles++;
            obstacle_y += 400;

            obstacles.add(new Square(150, 300, obstacle_y, 5, false));
            obstacles.get(numObstacles).AddScreen(root);
            stars.add(new BigStar(15, 300, obstacle_y));
            stars.get(numStars).AddScreen(root);
            numStars++;
            numObstacles++;
            obstacle_y += 400;

            colorChangers.add(new ColorChanger(300, obstacle_y + 200, 15,false));
            colorChangers.get(numColor).AddScreen(root);
            numColor++;

            obstacles.add(new Cross(60, 330, obstacle_y, 9, false));
            obstacles.get(numObstacles).AddScreen(root);
            stars.add(new Star(15, 300, obstacle_y));
            stars.add(new Star(15, 300, obstacle_y));
            stars.get(numStars).AddScreen(root);
            numStars++;
            numObstacles++;
            obstacle_y += 400;

            obstacles.add(new Cross_Circle(40, 300, obstacle_y, 5, false));
            obstacles.get(numObstacles).AddScreen(root);
            stars.add(new Star(15, 300, obstacle_y));
            stars.get(numStars).AddScreen(root);
            numStars++;
            numObstacles++;
            obstacle_y += 400;

            colorChangers.add(new ColorChanger(300, obstacle_y - 200, 15,false));
            colorChangers.get(numColor).AddScreen(root);
            numColor++;
        }

        for(int i=0;i<strCt;i++)
        {
            stars.get(i).setCheck();
            stars.get(i).Invsible(root);
        }
        for(int i=0;i<col;i++)
        {
            colorChangers.get(i).setCheck();
            colorChangers.get(i).Invisible();
        }
        for(int i=0;i<sv;i++)
        {
            obstacleSavers.get(i).setCheck();
            obstacleSavers.get(i).Invisible();
        }

        imageView = new ImageView(pauseImage);
        imageView.setX(500);
        imageView.setY(25);

        imageView.setFitHeight(25);
        imageView.setFitWidth(25);

        imageView.setPreserveRatio(true);

        Label text2 = new Label();
        text2.setAlignment(Pos.CENTER_RIGHT);
        text2.setTextFill(Color.WHITE);
        text2.setFont(new Font(16));
        text2.setPadding(new Insets(25, 30, 50, 25));
        root.setLayoutY(moveScreen);

        root.getChildren().addAll(imageView, text2);
        ball=new Ball(300,150,10);
        ball.getBall().setLayoutY(ballY);

        if(color.equals(Color.BLUE.toString())){
            ball.getBall().setFill(Color.BLUE);
        }
        else if(color.equals(Color.YELLOW.toString())){
            ball.getBall().setFill(Color.YELLOW);
        }
        else if(color.equals(Color.RED.toString())){
            ball.getBall().setFill(Color.RED);
        }
        else if(color.equals(Color.HOTPINK.toString())){
            ball.getBall().setFill(Color.HOTPINK);
        }
        else if(color.equals(Color.SNOW.toString())){
            ball.getBall().setFill(Color.SNOW);
        }
        ball.AddScreen(root);

        StartPlaying(starsSoFar, dieScreen);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode().equals(KeyCode.SPACE)) {
                    moveScreen -= 30;
                    text2.setText("Score: " + starsCollected);
                    System.out.println("Stars Collected" + starsCollected);
                    timeline = new Timeline(new KeyFrame(Duration.seconds(1500000), new KeyValue(ball.getBall().layoutYProperty(), 1000000000)));
                    timeline.setCycleCount(1);
                    timeline.play();
                    root.setLayoutY(moveScreen);
                    imageView.setLayoutY(-moveScreen);
                    text2.setLayoutY(-moveScreen);
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode().equals(KeyCode.SPACE)) {
                    moveScreen -= 100;
                    text2.setText("Score: " + starsCollected);
                    root.setLayoutY(-moveScreen);
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode().equals(KeyCode.SPACE)) {
                    up += 10;
                    timeline1 = new Timeline(new KeyFrame(Duration.seconds(20), new KeyValue(ball.getBall().layoutYProperty(), up)));
                    timeline1.setCycleCount(1);
                    timeline1.play();
                }
            }
        });

    }

    public void StartPlaying(Integer starsSoFar, DieScreen2 dieScreen){

        timer=new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            int starnum = starsCount;
            double prev = 0;
            double curr = 0;

            @Override
            public void run() {
                prev = curr;
                curr = ball.getBall().getLayoutY();
                System.out.println("Ball: "+curr);
                System.out.println(starnum);
                System.out.println("HELLO UDIT");
                System.out.println(starsCount);
                System.out.println("HELOOOOOOOOOOOOO");
                System.out.println(counter);
                System.out.println(stars.get(starnum).CheckInteraction(ball));
                if (stars.get(starnum).CheckInteraction(ball) && stars.get(starnum).getCheck()) {
                    System.out.println(stars.get(starnum).getClass());
                    if(stars.get(starnum).getClass()==BigStar.getClass()){
                        System.out.println("INCREMENT");
                        starsCollected+=5;
                    }
                    else{
                        starsCollected++;
                    }
                    starsCount+=1;
                    stars.get(starnum).setCheck();
                    stars.get(starnum).Invsible(root);
                    starnum++;

                }
                System.out.println(colored);
                System.out.println(colorChangers.get(colored).getCheck());
                if ( colorChangers.get(colored).Action(ball, counter) ) {
                    System.out.println("No of color changers: "+colored);
                    System.out.println("Color changed");
                    System.out.println("Coloured: " + colored);
                    colorChangers.get(colored).setCheck();
                    colored++;
                }
                if (obstacleSavers.get(save).Action(ball) && !obstacleSavers.get(save).getCheck()) {
                    System.out.println("Coloured: " + save);
                    colorChangers.get(save).setCheck();
                    save++;
                    System.out.println("SAVE: "+save);
                }
                obstacles.get(counter).checkInteraction(ball);
                if (obstacles.get(counter).getCheck()) {
                    timer.cancel();
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                collisionSound();
                                gameover=true;
                                System.out.println(starsSoFar+starsCollected);
                                System.out.println(ball.getBall().getLayoutY());
                                System.out.println("SAve: "+save);
                                ballLayoutY=ball.getBall().getLayoutY();
                                Serializer.serialize(starsSoFar+starsCollected-starsBeforeRev,Color_Switch.getStarsCollectedTxt());
                            }
                            catch (IOException ex) {
                                ex.printStackTrace();
                            }
                            dieScreen.setScore(starsCollected);
                            stage.setScene(scenex);
                            stage.show();
                        }
                    });
                }
                obstacles.get(counter + 1).checkInteraction(ball);
                if (obstacles.get(counter + 1).getCheck()) {
                    timer.cancel();
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                collisionSound();
                                gameover=true;
                                System.out.println(ball.getBall().getLayoutY());
                                System.out.println("SAve: "+save);
                                ballLayoutY=ball.getBall().getLayoutY();
                                Serializer.serialize(starsSoFar+starsCollected-starsBeforeRev,Color_Switch.getStarsCollectedTxt());
                            }
                            catch (IOException ex) {
                                ex.printStackTrace();
                            }
                            dieScreen.setScore(starsCollected);
                            stage.setScene(scenex);
                            stage.show();
                        }
                    });
                }
                obstacles.get(counter + 2).checkInteraction(ball);
                if (obstacles.get(counter + 2).getCheck()) {
                    timer.cancel();
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                collisionSound();
                                gameover=true;
                                System.out.println(ball.getBall().getLayoutY());
                                System.out.println("SAve: "+save);
                                ballLayoutY=ball.getBall().getLayoutY();
                                Serializer.serialize(starsSoFar+starsCollected-starsBeforeRev,Color_Switch.getStarsCollectedTxt());
                            }
                            catch (IOException ex) {
                                ex.printStackTrace();
                            }
                            dieScreen.setScore(starsCollected);
                            stage.setScene(scenex);
                            stage.show();
                        }
                    });
                }

                if(counter>=2)
                {
                    obstacles.get(counter-2).checkInteraction(ball);
                    if (obstacles.get(counter-2).getCheck()) {
                        timer.cancel();
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    collisionSound();
                                    gameover = true;
                                    System.out.println(ball.getBall().getLayoutY());
                                    System.out.println("SAve: " + save);
                                    ballLayoutY = ball.getBall().getLayoutY();
                                    Serializer.serialize(starsSoFar + starsCollected - starsBeforeRev, Color_Switch.getStarsCollectedTxt());
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                                dieScreen.setScore(starsCollected);
                                stage.setScene(scenex);
                                stage.show();
                            }
                        });
                    }
                }

                if(counter>=1)
                {
                    obstacles.get(counter-1).checkInteraction(ball);
                    if (obstacles.get(counter -1).getCheck()) {
                        timer.cancel();
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    collisionSound();
                                    gameover = true;
                                    System.out.println(ball.getBall().getLayoutY());
                                    System.out.println("SAve: " + save);
                                    ballLayoutY = ball.getBall().getLayoutY();
                                    Serializer.serialize(starsSoFar + starsCollected - starsBeforeRev, Color_Switch.getStarsCollectedTxt());
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }

                                dieScreen.setScore(starsCollected);
                                stage.setScene(scenex);
                                stage.show();
                            }
                        });
                    }
                }

                if ((curr >= obstacles.get(counter).getYval() - ball.getY())) {
                    if (Math.abs(prev - curr) <= 400) {
                        counter++;
                    }
                }
            }
        }, 0, 80);
    }


    public void AddScreen(Group root) {
        root.getChildren().addAll(imageView, img);
    }


    public void updateStar(Label text, int starsCollected) {
        text.setText("Score: " + starsCollected);
    }

    public void setColorBall(Paint paint) {
        colorBall = paint.toString();
    }
    public String getColorBall(){
        return colorBall;
    }
    public int getSave(){
        return save;
    }

    public void setObstacleID() {
        obstacleID = colored;
    }
    public void setballGetLayoutY(){
        ballLayoutY=ball.getBall().getLayoutY();
    }

    public Ball getBallxx() {
        return ball;
    }

    public int getObstacleID() {
        return obstacleID;

    }
    public double getBallLayoutY(){
        return ballLayoutY;
    }

    public Timer getTimer() {
        return timer;
    }
    public int getColored(){
        return colored;
    }
    public int getStarsCollected(){
        return starsCollected;
    }
    public int getStarsCount(){
        return starsCount;
    }
    public void setStarsCount(int s){
        starsCount=s;
    }
    public double getMoveScreen(){
        return moveScreen;
    }
    private int starsCollected(){
        return starsCollected;
    }

    public void collisionSound()
    {
        String path = "C:\\Users\\91995\\IdeaProjects\\HelloWorldFX\\src\\sample\\25 Jump.mp3";
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
    }

    public void addObstacles() throws Exception
    {
        while (numObstacles < 400*numObstaclesAdd && numStars < 400*numObstaclesAdd && numColor < 200*numObstaclesAdd) {
            obstacles.add(new Circle(300, obstacle_y, 70, 5, false));
            obstacles.get(numObstacles).AddScreen(root);
            stars.add(new Star(15, 300, obstacle_y));
            stars.get(numStars).AddScreen(root);
            numStars++;
            numObstacles++;
            obstacle_y += 400;

            obstacleSavers.add(new ObstacleSaver(300,obstacle_y+200,15,false));
            obstacleSavers.get(obstSave).AddScreen(root);
            obstSave++;

            obstacles.add(new Triangle(150, 300, obstacle_y, 5, false));
            obstacles.get(numObstacles).AddScreen(root);
            stars.add(new Star(15, 300, obstacle_y));
            stars.get(numStars).AddScreen(root);
            numObstacles++;
            numStars++;
            obstacle_y += 400;

            colorChangers.add(new ColorChanger(300, obstacle_y + 200, 15,false));
            colorChangers.get(numColor).AddScreen(root);
            numColor++;

            obstacles.add(new Cross2(60, 300 - 60, obstacle_y, 9, false));
            obstacles.get(numObstacles).AddScreen(root);
            stars.add(new BigStar(15, 300, obstacle_y));
            stars.get(numStars).AddScreen(root);
            numStars++;
            numObstacles++;
            obstacle_y += 400;

            obstacleSavers.add(new ObstacleSaver(300,obstacle_y+200,15,false));
            obstacleSavers.get(obstSave).AddScreen(root);
            obstSave++;

            obstacles.add(new Concentric_Circle(80, 300, obstacle_y, 5, false));
            obstacles.get(numObstacles).AddScreen(root);
            stars.add(new Star(15, 300, obstacle_y));
            stars.get(numStars).AddScreen(root);
            numStars++;
            numObstacles++;
            obstacle_y += 400;

            colorChangers.add(new ColorChanger(300, obstacle_y + 200, 15,false));
            colorChangers.get(numColor).AddScreen(root);
            numColor++;

            obstacles.add(new Tangent_Circles(60, 300, obstacle_y, 5, false));
            obstacles.get(numObstacles).AddScreen(root);
            stars.add(new Star(15, 300, obstacle_y));
            stars.get(numStars).AddScreen(root);
            numStars++;
            numObstacles++;
            obstacle_y += 400;

            obstacles.add(new Square(150, 300, obstacle_y, 5, false));
            obstacles.get(numObstacles).AddScreen(root);
            stars.add(new BigStar(15, 300, obstacle_y));
            stars.get(numStars).AddScreen(root);
            numStars++;
            numObstacles++;
            obstacle_y += 400;

            colorChangers.add(new ColorChanger(300, obstacle_y + 200, 15,false));
            colorChangers.get(numColor).AddScreen(root);
            numColor++;

            obstacles.add(new Cross(60, 330, obstacle_y, 9, false));
            obstacles.get(numObstacles).AddScreen(root);
            stars.add(new Star(15, 300, obstacle_y));
            stars.get(numStars).AddScreen(root);
            numStars++;
            numObstacles++;
            obstacle_y += 400;

            obstacles.add(new Cross_Circle(40, 300, obstacle_y, 5, false));
            obstacles.get(numObstacles).AddScreen(root);
            stars.add(new Star(15, 300, obstacle_y));
            stars.get(numStars).AddScreen(root);
            numStars++;
            numObstacles++;
            obstacle_y += 400;

            colorChangers.add(new ColorChanger(300, obstacle_y - 200, 15,false));
            colorChangers.get(numColor).AddScreen(root);
            numColor++;
        }
        numObstaclesAdd++;
    }
}
