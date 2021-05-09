package TankGame;
import javafx.scene.image.Image;

public class Treasure extends PlayerOne {
    public Treasure(String SVGdata, double xLoc, double yLoc, Image... spriteCels){
        super(SVGdata, xLoc, yLoc, spriteCels);
        spriteFrame.setTranslateX(xLoc);
        spriteFrame.setTranslateY(yLoc);
        hasValue=true;
        isBonus=true;
    }
    @Override
    public void update(){

    }
}
