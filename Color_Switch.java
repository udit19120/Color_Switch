package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.*;
import java.util.ArrayList;

public class Color_Switch extends Application implements Serializable {
    private Scene scene1, scene2,scene3,scene4,scene5,scene6,sceneRev,sceneRevDie, sceneAdd, sceneReward;
    private Game game;
    private Reverse reverse;
    private static int totalStarsInColorSwitch=0;
    private Integer starsSoFar;
    private boolean check=false;
    private Game gamex = new Game();
    private ArrayList<File> files= new ArrayList<>();
    private static File starsCollectedTxt=new File("starsCollected.txt");
    private static File serialisationDieTxt=new File("serializationDie.txt");
    private static File serializationDemo1Txt= new File("serializationDemo1.txt");
    private static File serializationDemo2Txt= new File("serializationDemo2.txt");
    private static File serializationDemo3Txt=new File("serializationDemo3.txt");
    private static File serializationDemo4Txt=new File("serializationDemo4.txt");
    private static File serializationScoresTxt=new File("serializationScores.txt");
    private ArrayList<Integer> scores = new ArrayList<>();
    private boolean game1=false, game2=false, game3=false, game4=false;// needs to be serialised
    Group root4;
    MainPage mainPage;
    transient Text t;

    public Color_Switch() throws Exception {
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        stage.initStyle(StageStyle.UNDECORATED);
        try
        {
            FileInputStream fis = new FileInputStream(serializationScoresTxt);
            ObjectInputStream ois = new ObjectInputStream(fis);
            scores = (ArrayList) ois.readObject();
            System.out.println(scores.size());
            ois.close();
            fis.close();
        }catch(IOException ioe){
            ioe.printStackTrace();
            return;
        }catch(ClassNotFoundException c){
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }

        Integer nx=null;
        try {
            nx = (Integer) Serializer.deserialize(starsCollectedTxt);
            t= new Text("TOTAL STARS: "+nx);
            t.setX(450);
            t.setY(30);
            t.setFont(new Font(18));
            t.setFill(Color.SNOW);
            totalStarsInColorSwitch=nx.intValue();
            starsSoFar=nx.intValue();
        } catch (ClassNotFoundException | IOException ex) {
            ex.printStackTrace();
        }
        System.out.println(totalStarsInColorSwitch+"  "+starsSoFar);
        stage.setTitle("COLOR SWITCH");
        Group root1 = new Group();
        Group root2 =new Group();
        root2.getChildren().add(t);
        Group root3 = new Group();
        Group rootDieRev = new Group();
        //root4 = new Group();
        Group root5 = new Group();
        Group root6 = new Group();
        Group rootAdd = new Group();
        Group root7 = new Group();
        Group root8 = new Group();
        Group rootReverse=new Group();
        Group rewardGroup= new Group();
        DieScreen dieScreen=new DieScreen();
        MediaFX mediaFX = new MediaFX();
        StarsNotEnough starsNotEnough=new StarsNotEnough();
        DieScreen2 dieScreen2 = new DieScreen2();
        mainPage=new MainPage();
        HelpPage helpPage = new HelpPage();
        HighScore highScore = new HighScore(scores);
        SelectGame selectGame = new SelectGame();
        ShopPage shopPage = new ShopPage();
        dieScreen.AddScreen(root1);
        starsNotEnough.AddScreen(root8);
        dieScreen2.AddScreen(rootDieRev);
        mediaFX.AddScreen(rootAdd);
        scene1=new Scene(root1, 600,700);
        sceneRevDie=new Scene(rootDieRev,600,700);
        sceneAdd=new Scene(rootAdd,1000,700);
        Pause pause = new Pause();
        Pause_Reverse pause_reverse = new Pause_Reverse();
        pause.AddScreen(root5);
        helpPage.AddScreen(root3);
        highScore.AddScreen(root7);
        selectGame.AddScreen(root6);
        Claim_Rewards claim_rewards=new Claim_Rewards();
        claim_rewards.AddScreen(rewardGroup);
        sceneReward=new Scene(rewardGroup,600,700);
        sceneReward.setFill(Color.BLACK);
        claim_rewards.reward.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setStarsOnScreen();
                stage.setScene(scene2);
            }
        });

        mainPage.imageView3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    mediaFX.mediaplayer.play();
                    stage.setScene(sceneAdd);
                    mediaFX.Stop(stage,sceneReward,starsSoFar);
                    setStarsOnScreen();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        dieScreen.getButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                scores.add(game.getStarsCollected());
                stage.setScene(scene2);
                setStarsOnScreen();
            }
        });
        dieScreen2.getButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                scores.add(reverse.getStarsCollected());
                stage.setScene(scene2);
                setStarsOnScreen();
            }
        });
        mainPage.imageView4.setOnMouseClicked(e->stage.setScene(scene3));
        mainPage.imageView2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                HighScore highScore= null;
                try {
                    highScore = new HighScore(scores);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                Group rootx = new Group();
                Scene scenex = new Scene(rootx,600,700);
                scenex.setFill(Color.BLACK);
                stage.setScene(scenex);
                highScore.AddScreen(rootx);
                highScore.ShowHighScore(scores);
                highScore.iv.setOnMouseClicked(e -> stage.setScene(scene2));
                setStarsOnScreen();
            }
        });

        mainPage.reversegame.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                root4=new Group();
                scene4 = new Scene(root4,600,700);
                scene4.setFill(Color.BLACK);
                SerialStars();
                stage.setScene(scene4);
                try {
                    reverse = new Reverse(root4,scene4,stage,sceneRevDie,starsSoFar,dieScreen2);
                    reverse.imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            reverse.timeline1.pause();
                            reverse.timeline.pause();
                            stage.setScene(sceneRev);
                            reverse.getTimer().cancel();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        mainPage.button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    root4=new Group();
                    scene4 = new Scene(root4,600,700);
                    scene4.setFill(Color.BLACK);
                    stage.setScene(scene4);
                    Integer nx=null;
                    SerialStars();
                    game = new Game(root4,scene4,stage,scene1,starsSoFar,dieScreen);
                    game.imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            game.timeline1.pause();
                            game.timeline.pause();
                            System.out.println(game.timeline1.getStatus());
                            System.out.println("KKKKKKKK");
                            stage.setScene(scene5);
                            game.getTimer().cancel();
                        }
                    });


                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        pause_reverse.exit_button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                SerialStars();
                scores.add(reverse.getStarsCollected());
                reverse.getTimer().cancel();
                try {
                    mainPage = new MainPage();
                    stage.setScene(scene2);
                    setStarsOnScreen();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        dieScreen.getButton1().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                game.setColorBall(game.getBallxx().getBall().getFill());
                game.setObstacleID();
                System.out.println("SAve: "+game.getSave());
                System.out.println(game.getBallLayoutY());
                try {
                    Serializer.serialize(game,serialisationDieTxt);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                if(starsSoFar<5){
                    Group rootx = new Group();
                    Scene scenex = new Scene(rootx,600,700);
                    scenex.setFill(Color.BLACK);
                    stage.setScene(scenex);
                    starsNotEnough.AddScreen(rootx);
                    starsNotEnough.Enough.setOnMouseClicked(e -> stage.setScene(scene2));
                }
                else{
                    Integer nx=null;
                    try {
                        nx = (Integer) Serializer.deserialize(starsCollectedTxt);
                        totalStarsInColorSwitch= nx;
                    } catch (ClassNotFoundException | IOException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        Serializer.serialize(starsSoFar-5,starsCollectedTxt);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    totalStarsInColorSwitch-=5;
                    starsSoFar=totalStarsInColorSwitch;
                    System.out.println("BYE BYE RISHI");
                    System.out.println(totalStarsInColorSwitch);
                    System.out.println(starsSoFar);
                    Game empNew = null;
                    try {
                        empNew = (Game) Serializer.deserialize(serialisationDieTxt);
                    } catch (ClassNotFoundException | IOException ex) {
                        ex.printStackTrace();
                    }

                    root4=new Group();
                    scene4 = new Scene(root4,600,700);
                    scene4.setFill(Color.BLACK);
                    stage.setScene(scene4);
                    try {
                        game = new Game(root4,scene4,stage,scene1,empNew.getStarsCollected(), empNew.getBallLayoutY()+175,empNew.getMoveScreen()-175,empNew.getColorBall(),starsSoFar,empNew.getColored(),empNew.getStarsCount(),empNew.getSave(),1,dieScreen);
                        game.setStarsCount(empNew.getStarsCount());

                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    game.imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            game.timeline1.pause();
                            game.timeline.pause();
                            System.out.println(game.timeline1.getStatus());
                            System.out.println("KKKKKKKK");
                            stage.setScene(scene5);
                            game.getTimer().cancel();
                        }
                    });


                }
            }
        });
        dieScreen2.getButton1().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                reverse.setColorBall(reverse.getBallxx().getBall().getFill());
                reverse.setObstacleID();
                try {
                    Serializer.serialize(reverse,serialisationDieTxt);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                if(starsSoFar<5){
                    Group rootx = new Group();
                    Scene scenex = new Scene(rootx,600,700);
                    scenex.setFill(Color.BLACK);
                    stage.setScene(scenex);
                    starsNotEnough.AddScreen(rootx);
                    starsNotEnough.Enough.setOnMouseClicked(e -> stage.setScene(scene2));
                }
                else{
                    Integer nx=null;
                    try {
                        nx = (Integer) Serializer.deserialize(starsCollectedTxt);
                        totalStarsInColorSwitch= nx;
                    } catch (ClassNotFoundException | IOException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        Serializer.serialize(starsSoFar-5,starsCollectedTxt);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    totalStarsInColorSwitch-=5;
                    starsSoFar=totalStarsInColorSwitch;
                    System.out.println("BYE BYE RISHI");
                    System.out.println(totalStarsInColorSwitch);
                    System.out.println(starsSoFar);
                    Reverse empNew = null;
                    try {
                        empNew = (Reverse) Serializer.deserialize(serialisationDieTxt);
                    } catch (ClassNotFoundException | IOException ex) {
                        ex.printStackTrace();
                    }

                    root4=new Group();
                    scene4 = new Scene(root4,600,700);
                    scene4.setFill(Color.BLACK);
                    stage.setScene(scene4);
                    try {
                        reverse = new Reverse(root4,scene4,stage,sceneRevDie,empNew.getStarsCollected(), empNew.getBallLayoutY()-175,empNew.getMoveScreen()+175,empNew.getColorBall(),starsSoFar,empNew.getColored(),empNew.getStarsCount(),empNew.getSave(),1,dieScreen2);
                        reverse.setStarsCount(empNew.getStarsCount());

                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    reverse.imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            reverse.timeline1.pause();
                            reverse.timeline.pause();
                            System.out.println("KKKKKKKK");
                            stage.setScene(sceneRev);
                            reverse.getTimer().cancel();
                        }
                    });


                }
            }
        });

        pause.button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    scores.add(game.getStarsCollected());
                    root4=new Group();
                    scene4 = new Scene(root4,600,700);
                    scene4.setFill(Color.BLACK);
                    stage.setScene(scene4);
                    game = new Game(root4,scene4,stage,scene1,starsSoFar,dieScreen);
                    game.imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            game.timeline1.pause();
                            game.timeline.pause();
                            System.out.println(game.timeline1.getStatus());
                            System.out.println("KKKKKKKK");
                            stage.setScene(scene5);
                            game.getTimer().cancel();
                        }
                    });


                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        pause_reverse.button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    scores.add(reverse.getStarsCollected());
                    root4=new Group();
                    scene4 = new Scene(root4,600,700);
                    scene4.setFill(Color.BLACK);
                    stage.setScene(scene4);
                    reverse = new Reverse(root4,scene4,stage,sceneRevDie,starsSoFar,dieScreen2);
                    reverse.imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            reverse.timeline1.pause();
                            reverse.timeline.pause();
                            System.out.println("KKKKKKKK");
                            stage.setScene(sceneRev);
                            reverse.getTimer().cancel();
                        }
                    });


                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        dieScreen.getButtx().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    root4=new Group();
                    scene4 = new Scene(root4,600,700);
                    scene4.setFill(Color.BLACK);
                    stage.setScene(scene4);
                    game = new Game(root4,scene4,stage,scene1,starsSoFar,dieScreen);
                    game.imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            game.timeline1.pause();
                            game.timeline.pause();
                            System.out.println(game.timeline1.getStatus());
                            System.out.println("KKKKKKKK");
                            stage.setScene(scene5);
                            game.getTimer().cancel();
                        }
                    });


                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        dieScreen2.getButtx().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    root4=new Group();
                    scene4 = new Scene(root4,600,700);
                    scene4.setFill(Color.BLACK);
                    stage.setScene(scene4);
                    reverse = new Reverse(root4,scene4,stage,sceneRevDie,starsSoFar,dieScreen2);
                    reverse.imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            reverse.timeline1.pause();
                            reverse.timeline.pause();
                            System.out.println("KKKKKKKK");
                            stage.setScene(sceneRev);
                            reverse.getTimer().cancel();
                        }
                    });


                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        selectGame.button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Game empNew = null;
                try {
                    empNew = (Game) Serializer.deserialize(serializationDemo1Txt);
                } catch (ClassNotFoundException | IOException ex) {
                    ex.printStackTrace();
                }

                System.out.println("MV: "+empNew.getMoveScreen());
                System.out.println("Color: "+empNew.getColorBall());
                System.out.println("empNew Object::"+empNew.getStarsCollected());
                System.out.println("empNew Object::"+empNew.getBallLayoutY());
                System.out.println("empNew Object::"+empNew.getColorBall());

                root4=new Group();
                scene4 = new Scene(root4,600,700);
                scene4.setFill(Color.BLACK);
                stage.setScene(scene4);
                try {
                    game = new Game(root4,scene4,stage,scene1,empNew.getStarsCollected(), empNew.getBallLayoutY(),empNew.getMoveScreen(),empNew.getColorBall(),starsSoFar,empNew.getColored(),empNew.getStarsCount(),empNew.getSave(),0,dieScreen);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                game.imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        game.timeline1.pause();
                        game.timeline.pause();
                        System.out.println(game.timeline1.getStatus());
                        System.out.println("KKKKKKKK");
                        stage.setScene(scene5);
                        game.getTimer().cancel();
                    }
                });
            }
        });

        selectGame.button1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Game empNew = null;
                try {
                    empNew = (Game) Serializer.deserialize(serializationDemo2Txt);
                } catch (ClassNotFoundException | IOException ex) {
                    ex.printStackTrace();
                }

                System.out.println("MV: "+empNew.getMoveScreen());
                System.out.println("Color: "+empNew.getColorBall());
                System.out.println("empNew Object::"+empNew.getStarsCollected());
                System.out.println("empNew Object::"+empNew.getBallLayoutY());
                System.out.println("empNew Object::"+empNew.getColorBall());

                root4=new Group();
                scene4 = new Scene(root4,600,700);
                scene4.setFill(Color.BLACK);
                stage.setScene(scene4);
                try {
                    game = new Game(root4,scene4,stage,scene1,empNew.getStarsCollected(), empNew.getBallLayoutY(),empNew.getMoveScreen(),empNew.getColorBall(),starsSoFar,empNew.getColored(),empNew.getStarsCount(),empNew.getSave(),0,dieScreen);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                game.imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        game.timeline1.pause();
                        game.timeline.pause();
                        System.out.println(game.timeline1.getStatus());
                        System.out.println("KKKKKKKK");
                        stage.setScene(scene5);
                        game.getTimer().cancel();
                    }
                });
            }
        });

        selectGame.button2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Game empNew = null;
                try {
                    empNew = (Game) Serializer.deserialize(serializationDemo3Txt);
                } catch (ClassNotFoundException | IOException ex) {
                    ex.printStackTrace();
                }

                System.out.println("MV: "+empNew.getMoveScreen());
                System.out.println("Color: "+empNew.getColorBall());
                System.out.println("empNew Object::"+empNew.getStarsCollected());
                System.out.println("empNew Object::"+empNew.getBallLayoutY());
                System.out.println("empNew Object::"+empNew.getColorBall());

                root4=new Group();
                scene4 = new Scene(root4,600,700);
                scene4.setFill(Color.BLACK);
                stage.setScene(scene4);
                try {
                    game = new Game(root4,scene4,stage,scene1,empNew.getStarsCollected(), empNew.getBallLayoutY(),empNew.getMoveScreen(),empNew.getColorBall(),starsSoFar,empNew.getColored(),empNew.getStarsCount(),empNew.getSave(),0,dieScreen);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                game.imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        game.timeline1.pause();
                        game.timeline.pause();
                        System.out.println(game.timeline1.getStatus());
                        System.out.println("KKKKKKKK");
                        stage.setScene(scene5);
                        game.getTimer().cancel();
                    }
                });
            }
        });

        selectGame.button3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Game empNew = null;
                try {
                    empNew = (Game) Serializer.deserialize(serializationDemo4Txt);
                } catch (ClassNotFoundException | IOException ex) {
                    ex.printStackTrace();
                }

                System.out.println("MV: "+empNew.getMoveScreen());
                System.out.println("Color: "+empNew.getColorBall());
                System.out.println("empNew Object::"+empNew.getStarsCollected());
                System.out.println("empNew Object::"+empNew.getBallLayoutY());
                System.out.println("empNew Object::"+empNew.getColorBall());

                root4=new Group();
                scene4 = new Scene(root4,600,700);
                scene4.setFill(Color.BLACK);
                stage.setScene(scene4);
                try {
                    game = new Game(root4,scene4,stage,scene1,empNew.getStarsCollected(), empNew.getBallLayoutY(),empNew.getMoveScreen(),empNew.getColorBall(),starsSoFar,empNew.getColored(),empNew.getStarsCount(),empNew.getSave(),0,dieScreen);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                game.imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        game.timeline1.pause();
                        game.timeline.pause();
                        System.out.println(game.timeline1.getStatus());
                        System.out.println("KKKKKKKK");
                        stage.setScene(scene5);
                        //stage.show();
                        game.getTimer().cancel();
                    }
                });
            }
        });

        helpPage.iv.setOnMouseClicked(e->stage.setScene(scene2));
        selectGame.iv.setOnMouseClicked(e->stage.setScene(scene2));
        mainPage.button1.setOnAction(e->stage.setScene(scene6));
        pause.button1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                stage.setScene(scene4);
                game.timeline.play();
                game.timeline1.play();
                game.StartPlaying(starsSoFar,dieScreen);
                stage.show();
            }
        });
        pause_reverse.button1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                stage.setScene(scene4);
                reverse.timeline.play();
                reverse.timeline1.play();
                reverse.StartPlaying(starsSoFar,dieScreen2);
                stage.show();
            }
        });

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                scores.add(game.getStarsCollected());
                game.setColorBall(game.getBallxx().getBall().getFill());
                game.setObstacleID();
                game.setballGetLayoutY();
                totalStarsInColorSwitch+=game.getStarsCollected();
                starsSoFar+=game.getStarsCollected();
                System.out.println(game.getBallLayoutY());
                System.out.println(game.getMoveScreen());
                if(game1==false) {
                    game1=true;
                    try {
                        Serializer.serialize(game, serializationDemo1Txt);
                        Serializer.serialize(starsSoFar, starsCollectedTxt);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    Game empNew = null;
                    Integer n = null;
                    try {
                        empNew = (Game) Serializer.deserialize(serializationDemo1Txt);
                        n = (Integer) Serializer.deserialize(starsCollectedTxt);
                    } catch (ClassNotFoundException | IOException ex) {
                        ex.printStackTrace();
                    }

                    System.out.println("emp Object::" + empNew.getColored());
                    //System.out.println("empNew Object::" + empNew.getObstacleID());
                    System.out.println("empNew Object::" + empNew.getStarsCollected());
                    System.out.println("empNew Object::" + empNew.getBallLayoutY());
                    System.out.println("empNew Object::" + empNew.getColorBall());
                    System.out.println("Stars: " + n.intValue());
                    game.getTimer().cancel();
                    try {
                        mainPage = new MainPage();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    stage.setScene(scene2);
                    setStarsOnScreen();
                }
                else if(game2==false)
                {
                    game2=true;
                    try {
                        Serializer.serialize(game, serializationDemo2Txt);
                        Serializer.serialize(starsSoFar, starsCollectedTxt);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    Game empNew = null;
                    Integer n = null;
                    try {
                        empNew = (Game) Serializer.deserialize(serializationDemo2Txt);
                        n = (Integer) Serializer.deserialize(starsCollectedTxt);
                    } catch (ClassNotFoundException | IOException ex) {
                        ex.printStackTrace();
                    }

                    System.out.println("emp Object::" + empNew.getColored());
                    //System.out.println("empNew Object::" + empNew.getObstacleID());
                    System.out.println("empNew Object::" + empNew.getStarsCollected());
                    System.out.println("empNew Object::" + empNew.getBallLayoutY());
                    System.out.println("empNew Object::" + empNew.getColorBall());
                    System.out.println("Stars: " + n.intValue());
                    game.getTimer().cancel();
                    try {
                        mainPage = new MainPage();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    stage.setScene(scene2);
                    setStarsOnScreen();
                }

                else if(game3==false)
                {
                    game3=true;
                    try {
                        Serializer.serialize(game, serializationDemo3Txt);
                        Serializer.serialize(starsSoFar, starsCollectedTxt);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    Game empNew = null;
                    Integer n = null;
                    try {
                        empNew = (Game) Serializer.deserialize(serializationDemo3Txt);
                        n = (Integer) Serializer.deserialize(starsCollectedTxt);
                    } catch (ClassNotFoundException | IOException ex) {
                        ex.printStackTrace();
                    }

                    System.out.println("emp Object::" + empNew.getColored());
                    //System.out.println("empNew Object::" + empNew.getObstacleID());
                    System.out.println("empNew Object::" + empNew.getStarsCollected());
                    System.out.println("empNew Object::" + empNew.getBallLayoutY());
                    System.out.println("empNew Object::" + empNew.getColorBall());
                    System.out.println("Stars: " + n.intValue());
                    game.getTimer().cancel();
                    try {
                        mainPage = new MainPage();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    stage.setScene(scene2);
                    setStarsOnScreen();
                }

                else if(game4==false)
                {
                    game4=true;
                    try {
                        Serializer.serialize(game, serializationDemo4Txt);
                        Serializer.serialize(starsSoFar, starsCollectedTxt);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    Game empNew = null;
                    Integer n = null;
                    try {
                        empNew = (Game) Serializer.deserialize(serializationDemo4Txt);
                        n = (Integer) Serializer.deserialize(starsCollectedTxt);
                    } catch (ClassNotFoundException | IOException ex) {
                        ex.printStackTrace();
                    }

                    System.out.println("emp Object::" + empNew.getColored());
                    System.out.println("empNew Object::" + empNew.getStarsCollected());
                    System.out.println("empNew Object::" + empNew.getBallLayoutY());
                    System.out.println("empNew Object::" + empNew.getColorBall());
                    System.out.println("Stars: " + n.intValue());
                    game.getTimer().cancel();
                    try {
                        mainPage = new MainPage();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    stage.setScene(scene2);
                    setStarsOnScreen();
                }

                else
                {
                    game1=true;
                    try {
                        Serializer.serialize(game, serializationDemo1Txt);
                        Serializer.serialize(starsSoFar, starsCollectedTxt);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    Game empNew = null;
                    Integer n = null;
                    try {
                        empNew = (Game) Serializer.deserialize(serializationDemo1Txt);
                        n = (Integer) Serializer.deserialize(starsCollectedTxt);
                    } catch (ClassNotFoundException | IOException ex) {
                        ex.printStackTrace();
                    }

                    System.out.println("emp Object::" + empNew.getColored());
                    //System.out.println("empNew Object::" + empNew.getObstacleID());
                    System.out.println("empNew Object::" + empNew.getStarsCollected());
                    System.out.println("empNew Object::" + empNew.getBallLayoutY());
                    System.out.println("empNew Object::" + empNew.getColorBall());
                    System.out.println("Stars: " + n.intValue());
                    game.getTimer().cancel();
                    try {
                        mainPage = new MainPage();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    stage.setScene(scene2);
                    setStarsOnScreen();
                }
            }
        };

        EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                if(game!=null){
                    game.getTimer().cancel();
                }
                try{
                    FileOutputStream fos= new FileOutputStream(serializationScoresTxt);
                    ObjectOutputStream oos= new ObjectOutputStream(fos);
                    oos.writeObject(scores);
                    oos.close();
                    fos.close();
                }catch(IOException ioe){
                    ioe.printStackTrace();
                }
                stage.close();
            }
        };
        pause.button2.setOnAction(event);
        mainPage.button2.setOnAction(event1);
        mainPage.AddScreen(root2);
        pause_reverse.AddScreen(rootReverse);
        scene2=new Scene(root2, 600,700);
        scene3 = new Scene(root3,600,700);
        scene5=new Scene(root5,600,700);
        sceneRev=new Scene(rootReverse,600,700);
        scene6=new Scene(root6,600,700);
        scene2.setFill(Color.BLACK);
        scene1.setFill(Color.BLACK);
        scene5.setFill(Color.BLACK);
        scene6.setFill(Color.BLACK);
        sceneRev.setFill(Color.BLACK);
        sceneRevDie.setFill(Color.BLACK);
        stage.setScene(scene2);
        stage.show();

        String path = "C:\\Users\\91995\\IdeaProjects\\HelloWorldFX\\src\\sample\\Color_Switch.mp3";
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(0.6);
        mediaPlayer.setAutoPlay(true);
    }

    public Game getGame() {
        return game;
    }
    public void setGame(Game g){
        game=g;
        System.out.println(game);
    }

    public static void main(String[] args){
        launch(args);
    }

    public static File getStarsCollectedTxt()
    {
        return starsCollectedTxt;
    }
    public static File getSerialisationDieTxt()
    {
        return serialisationDieTxt;
    }

    public static File getSerializationDemo1Txt()
    {
        return serializationDemo1Txt;
    }

    public void setStarsOnScreen(){
        Integer nx=null;
        try {
            nx = (Integer) Serializer.deserialize(starsCollectedTxt);
            starsSoFar=nx;
            t.setText("TOTAL STARS: "+nx);
        } catch (ClassNotFoundException | IOException ex) {
            ex.printStackTrace();
        }
    }


    public void SerialStars(){
        Integer nx=null;
        try {
            nx = (Integer) Serializer.deserialize(Color_Switch.getStarsCollectedTxt());
            starsSoFar=nx;
        } catch (ClassNotFoundException | IOException ex) {
            ex.printStackTrace();
        }
    }
}