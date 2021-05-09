package TankGame;
import javafx.scene.image.Image;
public class StuffsH extends Tank{

    public StuffsH(String SVGdata, double xLoc, double yLoc, Image... spriteCels){
        super(SVGdata, xLoc, yLoc, spriteCels);
        this.setFlipHorizontal(true);

        spriteFrame.setScaleX(-1);
        spriteFrame.setTranslateX(xLoc);
        spriteFrame.setTranslateY(yLoc);
    }
    @Override

    public void update(){

    }
}