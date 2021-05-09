package TankGame;
import javafx.scene.image.Image;
public class StuffCombined extends Tank{

    public StuffCombined(String SVGdata, double xLoc, double yLoc, Image... spriteCels){
        super(SVGdata, xLoc, yLoc, spriteCels);

        this.setFlipHorizontal(true);
        spriteFrame.setScaleX(-1);
        this.setFlipVertical(true);
        spriteFrame.setScaleY(-1);
        spriteFrame.setTranslateX(xLoc);
        spriteFrame.setTranslateY(yLoc);
    }
    @Override

    public void update(){

    }
}