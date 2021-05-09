package TankGame;

import javafx.scene.image.Image;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Shape;

import static TankGame.TankGM.HEIGHT;
import static TankGame.TankGM.WIDTH;


public class TankHero extends PlayerOne{
    protected TankGM TankGame;
//X is the number of pixels away from the left edge of the Canvas
// Y is the number of pixels away from the top edge of the Canvas

    protected static final double SPRITEPIXELX= 90;
    protected static final double SPRITEPIXELY= 90;

    protected static final double rightBOUND = WIDTH/2 - SPRITEPIXELX/2;
    protected static final double leftBOUND = -(WIDTH/2 -SPRITEPIXELX/2);

    protected static final double bottomBOUND = HEIGHT/2 - SPRITEPIXELY/2;
    protected static final double topBOUND = -(HEIGHT/2 - SPRITEPIXELY/2);

    boolean animator = false;

    int framecounter =0;
    int movespeed = 10;




    public TankHero(TankGM iTank, String SVGdata, double xLoc, double yLoc, Image... spriteCels){
        super(SVGdata, xLoc,yLoc,spriteCels);
        TankGame=iTank;
    }
    @Override
    public void update() {
        setXYLocation();
        setBounds();
        setImageState();
        moveTankGM(iX,iY);
        //playAudioClop();
        checkCollisons();


    }

        private void setXYLocation(){
        if (TankGame.isRight()) {
            iX += vX;
        }
        if (TankGame.isLeft()) {
            iX -= vX;
        }
        if (TankGame.isDown()) {
            iY += vY;
        }
        if (TankGame.isUp()) {
            iY -= vY;
        }

    }



    private void setBounds(){
        if (iX >= rightBOUND){
            iX = rightBOUND;
        }
        if (iX <= leftBOUND){
            iX = leftBOUND;
        }
        if (iY >= bottomBOUND){
            iY = bottomBOUND;
        }
        if (iY <= topBOUND){
            iY = topBOUND;
        }
    }

    private void setImageState() {

        if (TankGame.isRight() && !TankGame.isLeft() && !TankGame.isDown() && !TankGame.isUp()) {
            spriteFrame.setImage(imageState.get(0));
            animator=false;
            framecounter = 0;
        }


            if (TankGame.isRight()){
                spriteFrame.setScaleX(1);
                setFlipHorizontal(false);
            if (!animator && (!TankGame.isDown() && !TankGame.isUp())) {
            spriteFrame.setImage(imageState.get(1));
            if (framecounter >= movespeed){
                animator = false;
                framecounter = 0;
                } else {framecounter += 1;}
            }else if (animator){
                spriteFrame.setImage(imageState.get(2));
                if (framecounter >= movespeed){
                    animator=false;
                    framecounter=0;
                }else{framecounter+=1;}
            }
        }






        if (TankGame.isLeft()){
            spriteFrame.setScaleX(-1);
            setFlipHorizontal(true);
           if (!animator && (!TankGame.isDown() && !TankGame.isUp())){
               spriteFrame.setImage(imageState.get(1));

               if (framecounter >= movespeed){
               animator=true;
               framecounter=0;
               }else{framecounter+=1;}


           }else if (animator){
               spriteFrame.setImage(imageState.get(2));

               if (framecounter >= movespeed){
               animator=false;
               framecounter=0;
               }else{framecounter +=1;}
           }

        }


        if (TankGame.isDown()){
            spriteFrame.setImage(imageState.get(6));
        }
        if (TankGame.isUp()){
            spriteFrame.setImage(imageState.get(4));
        }
        if (TankGame.iswKey()){
            spriteFrame.setImage(imageState.get(5));
        }
        if (TankGame.issKey()){
            spriteFrame.setImage(imageState.get(8));
        }
    }

    private void moveTankGM(double x, double y){
        spriteFrame.setTranslateX(x);
        spriteFrame.setTranslateY(y);
    }

    private void playAudioClop(){

    }
    public void checkCollisons(){
        for(int i=0; i<TankGame.castStage.getCURRENTPLAYERS().size(); i++){
            Tank object = TankGame.castStage.getCURRENTPLAYERS().get(i);
           if(collide(object)){
               TankGame.castStage.addToREMOVEDPLAYERS(object);
               TankGame.root.getChildren().remove(object.getSpriteFrame());
               TankGame.castStage.resetREMOVEDPLAYERS();

           }
        }
    }


    private void scoringEnginge(Tank object){
        if (object instanceof Stuffs){
            TankGame.gameScore+=5;
        }
        else if (object instanceof StuffsV){
            TankGame.gameScore+=4;
        }
        else if (object instanceof StuffsH){
            TankGame.gameScore+=3;

        }
        else if (object instanceof StuffCombined){
            TankGame.gameScore+=2;
        }
        else if (object instanceof Treasure){
            TankGame.gameScore-=5;
        }
        TankGame.scoreText.setText(String.valueOf(TankGame.gameScore));

    }

    @Override
    public boolean collide(Tank object){
        boolean collsionDetect = false;
        if (TankGame.iTank.spriteFrame.getBoundsInParent().intersects(object.getSpriteFrame().getBoundsInParent())){
            Shape intersection = SVGPath.intersect(TankGame.iTank.getSpriteBound(), object.getSpriteBound());
            if (intersection.getBoundsInLocal().getWidth() != -1){
                collsionDetect = true;
            }
        }

        if (collsionDetect){
            TankGame.castStage.addToREMOVEDPLAYERS(object);
            TankGame.root.getChildren().remove(object.getSpriteFrame());
            TankGame.castStage.resetREMOVEDPLAYERS();
            return true;
        }

        return false;
    }
}
