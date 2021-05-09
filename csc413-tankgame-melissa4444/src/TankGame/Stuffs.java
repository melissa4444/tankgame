package TankGame;
import javafx.scene.image.Image;
public class Stuffs extends Tank{

    public Stuffs(String SVGdata, double xLoc, double yLoc, Image... spriteCels){
        super(SVGdata, xLoc, yLoc, spriteCels);
        spriteFrame.setTranslateX(xLoc);
        spriteFrame.setTranslateY(yLoc);
    }
    @Override

    public void update(){

    }
}
