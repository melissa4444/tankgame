package TankGame;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.Font;



public class TankGM extends Application {
    static final double WIDTH =1280;
    static final double HEIGHT=960;

   // private AudioClip iSound0, iSound2, ISound3;
   // private URL iAudioFile0;
    int gameScore=0;
     Text scoreText, scoreLabel;
    private Font scoreFont;
    private boolean up, down, left, right, wKey,sKey,aKey,dKey;
    StackPane root;
    private static HBox buttonContainer;
    TankHero iTank;
    Stuffs iSTU, iST1;
    StuffsH iSTH;
    StuffsV iSTV, iSTV1;
    StuffCombined iSBO;
    Treasure iTR0, iTR1;
    Enemy iTTank;
    Projectile iBullet;
    private Scene scene;
    private Image startScreen, instructionScreen, legalScreen, scoreScreen, grass;
    private Image iT0, iT1, iT2, iT3, iT4, iT5, iT6, iT7, iT8, iS0, iS1, iTT0, iTT1;
    private ImageView startScreenBackG, startScreenTextArea;
    private Button gameButton, helpButton, scoreButton, legalButton;
    private Insets buttonContainerPadding;
    private TankGameLoop tankGameLoop;
    CastStage castStage;

    @Override

    public void start(Stage primaryStage){


        primaryStage.setTitle("TankGM");
        root = new StackPane();
        scene = new Scene(root, WIDTH,HEIGHT, Color.WHITE);
        primaryStage.setScene(scene);
        primaryStage.show();

        createScreenEventHandling();

        //loadAudio();

        loadImages();

        createGamePlayers();

        addGamePlayerNodes();

        createCastStage();

        createScreenNodes();

        addNodesToStackPane();

        createStartGameLoop();



    }
    public static void main(String[] args){
        launch(args);
    }

    private void createScreenEventHandling(){
        scene.setOnKeyPressed((KeyEvent event) ->{
            switch (event.getCode()){
                case UP: up = true;
                    break;
                case DOWN: down = true;
                    break;
                case LEFT: left = true;
                    break;
                case RIGHT: right = true;
                    break;
                case W: wKey = true;
                    break;
                case S: sKey = true;
                    break;
                case A: aKey = true;
                    break;
                case D: dKey = true;
                    break;
            }
        });
        scene.setOnKeyReleased((KeyEvent event)->{
            switch (event.getCode()){
                case UP: up = false;
                    break;
                case DOWN: down = false;
                    break;
                case LEFT: left = false;
                    break;
                case RIGHT: right = false;
                    break;
                case W: wKey = false;
                    break;
                case S: sKey = false;
                    break;
                case A: aKey = false;
                    break;
                case D: dKey = false;
                    break;

            }
        });
    }




    /*private void loadAudio(){
        iAudioFile0=getClass().getResource("Music.mp3");
        iSound0 = new AudioClip(iAudioFile0.toString());
    }*/



    private void loadImages(){
        startScreen = new Image("tankBG.jpeg",1280,960,true,false,true);
        instructionScreen=new Image("tankInstruct.jpeg",640,400,true,false,true);
        legalScreen=new Image("tankCreds.jpeg",640,400,true,false,true);
        scoreScreen=new Image("tankHscore.jpeg",640,400,true,false,true);
        grass = new Image("gras.jpg", 1280,960,true,false,true);
        iT0=new Image("tank0.png", 81,81,true,false,true);
        iT1=new Image("tank1.png", 81,81,true,false,true);
        iT2=new Image("tank2.png", 81,81,true,false,true);
        iT3=new Image("tank3.png", 81,81,true,false,true);
        iT4=new Image("tank4.png", 81,81,true,false,true);
        iT5=new Image("tank5.png", 81,81,true,false,true);
        iT6=new Image("tank6.png", 81,81,true,false,true);
        iT7=new Image("tank7.png", 81,81,true,false,true);
        iT8=new Image("tank8.png", 81,81,true,false,true);
        iS0=new Image("brick.png",100,50,true,false,true);
        iS1=new Image("wall.jpg",496,92,true,false,true);
        iTT0=new Image("chest2.png",64,64,true,false,true);
        iTT1=new Image("chest2.png",64,64,true,false,true);
    }
    private void createGamePlayers(){
        //polygon data
        iTank=new TankHero(this,"M -25.0000, 25.0000 L -25.0000, -25.0000 24.0000, -24.0000 24.0000,25.0000 Z"
                ,0,0,iT0,iT1,iT2,iT3,iT4,iT5,iT6,iT7,iT8);

        //iTTank = new Enemy("M0 6 L0 16 64 4 Z");



        //location of where i want my walls
        iSTU = new Stuffs("M150 0 L32 72,32 72,0 Z 200 Z",0,248, iS0);
        iST1 = new Stuffs("M150 0 L75 200 L225 200 Z",0,-250, iS1);

        iSTH = new StuffsH("M150 0 L75 200 L225 200 Z",100,248, iS0);
        iSTV = new StuffsV("M150 0 L75 200 L225 200 Z",0,200, iS0);
        iSTV1 = new StuffsV("M150 0 L75 200 L225 200 Z",0,-150, iS1);

        iSBO = new StuffCombined("M150 0 L75 200 L225 200 Z",100,200, iS0);
        iTR0 = new Treasure("M150 0 L75 200 L225 200 Z",500,200, iTT0);
        iTR1 = new Treasure("M150 0 L75 200 L225 200 Z",100,400, iTT1);

    }

    private void addGamePlayerNodes(){

        root.getChildren().add(iSTU.spriteFrame);
        root.getChildren().add(iST1.spriteFrame);
        root.getChildren().add(iSTH.spriteFrame);
        root.getChildren().add(iSTV.spriteFrame);
        root.getChildren().add(iSBO.spriteFrame);
        root.getChildren().add(iSTV1.spriteFrame);

        root.getChildren().add(iTR0.spriteFrame);
        root.getChildren().add(iTR1.spriteFrame);
        root.getChildren().add(iTank.spriteFrame);
    }

    private void createCastStage(){
        castStage = new CastStage();
        castStage.addCURRENTPLAYERS(iSTU, iSTH, iSTV, iSBO, iTR0, iTR1);
        castStage.addCURRENTPLAYERS(iSTU);
        castStage.addCURRENTPLAYERS(iST1);
        castStage.addCURRENTPLAYERS(iSTH);
        castStage.addCURRENTPLAYERS(iSTV);
        castStage.addCURRENTPLAYERS(iSTV1);
        castStage.addCURRENTPLAYERS(iSBO);
    }

    private void createStartGameLoop(){
        tankGameLoop=new TankGameLoop(this);
        tankGameLoop.start();


    }


    public void createScreenNodes(){


        scoreText = new Text();
        scoreText.setText(String.valueOf(gameScore));
        scoreText.setLayoutY(385);
        scoreText.setLayoutX(525);
        scoreFont = new Font("Verdana", 20);
        scoreText.setFont(scoreFont);
        scoreText.setFill(Color.RED);
        scoreLabel = new Text();
        scoreLabel.setText("SCORE");
        scoreLabel.setLayoutY(385);
        scoreLabel.setLayoutX(445);
        scoreLabel.setFont(scoreFont);
        scoreLabel.setFill(Color.BLACK);






        buttonContainer=new HBox(12);
        buttonContainer.setLayoutY(365);
        buttonContainer.setAlignment(Pos.BOTTOM_CENTER);
        buttonContainerPadding=new Insets(0,0,10,16);
        buttonContainer.setPadding(buttonContainerPadding);
        gameButton = new Button();
        gameButton.setText("Play Game");
        gameButton.setOnAction((ActionEvent) -> {
            startScreenBackG.setImage(grass);
            startScreenBackG.setVisible(true);
            startScreenBackG.toBack();
            startScreenTextArea.setVisible(false);
        });


        helpButton=new Button();
        helpButton.setText("Instructions");
        helpButton.setOnAction((ActionEvent) -> {
           startScreenBackG.setImage(startScreen);
            startScreenBackG.toFront();
            startScreenBackG.setVisible(true);
            startScreenTextArea.setVisible(true);
            startScreenTextArea.setImage(instructionScreen);
            startScreenTextArea.toFront();
            buttonContainer.toFront();
        });

        scoreButton=new Button();
        scoreButton.setText("Scores");
        scoreButton.setOnAction((ActionEvent) -> {
            startScreenBackG.setImage(startScreen);
            startScreenBackG.toFront();
            startScreenBackG.setVisible(true);
            startScreenTextArea.setVisible(true);
            startScreenTextArea.setImage(scoreScreen);
            startScreenTextArea.toFront();
            buttonContainer.toFront();

        });

        legalButton=new Button();
        legalButton.setText("Credits");
        legalButton.setOnAction((ActionEvent) -> {
            startScreenBackG.setImage(startScreen);
            startScreenBackG.toFront();
            startScreenBackG.setVisible(true);
            startScreenTextArea.setVisible(true);
            startScreenTextArea.setImage(legalScreen);
            startScreenTextArea.toFront();
            buttonContainer.toFront();
        });


        buttonContainer.getChildren().addAll(gameButton,helpButton,scoreButton,legalButton);
        startScreenBackG=new ImageView();
        startScreenBackG.setImage(startScreen);
        startScreenTextArea=new ImageView();
        startScreenTextArea.setImage(instructionScreen);
    }

    private void addNodesToStackPane(){
        root.getChildren().add(startScreenBackG);
        root.getChildren().add(startScreenTextArea);
        root.getChildren().add(buttonContainer);
        root.getChildren().add(scoreText);
        root.getChildren().add(scoreLabel);
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean iswKey() {
        return wKey;
    }

    public void setwKey(boolean wKey) {
        this.wKey = wKey;
    }

    public boolean issKey() {
        return sKey;
    }

    public void setsKey(boolean sKey) {
        this.sKey = sKey;
    }

    public boolean isaKey() {
        return aKey;
    }

    public void setaKey(boolean aKey) {
        this.aKey = aKey;
    }

    public boolean isdKey() {
        return dKey;
    }

    public void setdKey(boolean dKey) {
        this.dKey = dKey;
    }




    /*public void playiSound0() {
        //this.iSound0 = play();
    }*/
}
