package TankGame;
import javafx.scene.image.Image;
public class Enemy extends PlayerOne{
    public Enemy(String SVGdata, double xLoc, double yLoc, Image... spriteCels){
        super(SVGdata, xLoc, yLoc, spriteCels);
        spriteFrame.setTranslateX(xLoc);
        spriteFrame.setTranslateY(yLoc);
        isAlive = true;
        isBonus=true;
        hasValue=true;
    }


@Override
    public void update(){

    }
}