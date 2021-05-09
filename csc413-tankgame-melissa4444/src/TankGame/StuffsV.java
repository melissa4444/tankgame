package TankGame;
import javafx.scene.image.Image;
public class StuffsV extends Tank{

    public StuffsV(String SVGdata, double xLoc, double yLoc, Image... spriteCels){
        super(SVGdata, xLoc, yLoc, spriteCels);
        this.setFlipHorizontal(true);

        spriteFrame.setScaleY(-1);
        spriteFrame.setTranslateX(xLoc);
        spriteFrame.setTranslateY(yLoc);
    }
    @Override

    public void update(){

    }
}