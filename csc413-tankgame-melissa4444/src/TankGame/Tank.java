package TankGame;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageView;
import javafx.scene.shape.SVGPath;
public abstract class Tank {

    protected List<Image> imageState = new ArrayList<>();
    protected ImageView spriteFrame;
    protected SVGPath spriteBound;
    protected double iX;
    protected double iY;

    protected double pX;
    protected double pY;

    protected boolean isAlive;
    protected boolean isFixed;
    protected boolean isBonus;
    protected boolean hasValue;
    protected boolean isFlipVertical;
    protected boolean isFlipHorizontal;

    public Tank(String SVGdata, double xLoc, double yLoc, Image... spriteCels){
        spriteBound = new SVGPath();
        spriteBound.setContent(SVGdata);
        spriteFrame = new ImageView(spriteCels[0]);
        imageState.addAll(Arrays.asList(spriteCels));
        iX=xLoc;
        iY=yLoc;

        pX=pY=0;
        isFixed = true;
        isAlive = isBonus=hasValue=isFlipVertical=isFlipHorizontal=false;
    }
    public boolean isFlipHorizontal() {
        return isFlipHorizontal;
    }

    public void setFlipHorizontal(boolean flipHorizontal) {
        isFlipHorizontal = flipHorizontal;
    }

    public boolean isFlipVertical() {
        return isFlipVertical;
    }

    public void setFlipVertical(boolean flipVertical) {
        isFlipVertical = flipVertical;
    }

    public boolean isHasValue() {
        return hasValue;
    }

    public void setHasValue(boolean hasValue) {
        this.hasValue = hasValue;
    }

    public boolean isBonus() {
        return isBonus;
    }

    public void setBonus(boolean bonus) {
        isBonus = bonus;
    }

    public boolean isFixed() {
        return isFixed;
    }

    public void setFixed(boolean fixed) {
        isFixed = fixed;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public double getpY() {
        return pY;
    }

    public void setpY(double pY) {
        this.pY = pY;
    }

    public double getpX() {
        return pX;
    }

    public void setpX(double pX) {
        this.pX = pX;
    }

    public double getiY() {
        return iY;
    }

    public void setiY(double iY) {
        this.iY = iY;
    }

    public double getiX() {
        return iX;
    }

    public void setiX(double iX) {
        this.iX = iX;
    }

    public SVGPath getSpriteBound() {
        return spriteBound;
    }

    public void setSpriteBound(SVGPath spriteBound) {
        this.spriteBound = spriteBound;
    }

    public ImageView getSpriteFrame() {
        return spriteFrame;
    }

    public void setSpriteFrame(ImageView spriteFrame) {
        this.spriteFrame = spriteFrame;
    }

    public List<Image> getImageState() {
        return imageState;
    }

    public void setImageState(List<Image> imageState) {
        this.imageState = imageState;
    }


    public abstract void update();
}
