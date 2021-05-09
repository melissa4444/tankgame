package TankGame;
import javafx.scene.image.Image;


public abstract class PlayerOne extends Tank {
    protected double vX, vY, lifeSpan, damage, offsetX, offsetY;

    protected float boundScale, boundRotation, friction, gravity, bounce;



    public PlayerOne(String SVGdata, double xLoc, double yLoc, Image... spriteCels) {
        super(SVGdata, xLoc, yLoc, spriteCels);
        lifeSpan=1000;
        vX=vY=1;
    }
    @Override public abstract void update();

    public boolean collide(Tank object){
        return false;
    }
    public double getvX() {
        return vX;
    }

    public void setvX(double vX) {
        this.vX = vX;
    }

    public double getvY() {
        return vY;
    }

    public void setvY(double vY) {
        this.vY = vY;
    }

    public double getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(double lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getOffsetX() {
        return offsetX;
    }

    public void setOffsetX(double offsetX) {
        this.offsetX = offsetX;
    }

    public double getOffsetY() {
        return offsetY;
    }

    public void setOffsetY(double offsetY) {
        this.offsetY = offsetY;
    }

    public float getBoundScale() {
        return boundScale;
    }

    public void setBoundScale(float boundScale) {
        this.boundScale = boundScale;
    }

    public float getBoundRotation() {
        return boundRotation;
    }

    public void setBoundRotation(float boundRotation) {
        this.boundRotation = boundRotation;
    }

    public float getFriction() {
        return friction;
    }

    public void setFriction(float friction) {
        this.friction = friction;
    }

    public float getGravity() {
        return gravity;
    }

    public void setGravity(float gravity) {
        this.gravity = gravity;
    }

    public float getBounce() {
        return bounce;
    }

    public void setBounce(float bounce) {
        this.bounce = bounce;
    }


}