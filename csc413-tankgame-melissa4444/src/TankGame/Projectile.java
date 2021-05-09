package TankGame;
import javafx.scene.image.Image;
public class Projectile extends PlayerOne {
    public Projectile(String SVGdata,double xLoc, double yLoc, Image... spriteCels){
        super(SVGdata, xLoc, yLoc,spriteCels);
        spriteFrame.setTranslateX(xLoc);
        spriteFrame.setTranslateY(yLoc);
        isFixed=false;
        isBonus = true;
        hasValue = true;

    }

    public void update() {

    }
}