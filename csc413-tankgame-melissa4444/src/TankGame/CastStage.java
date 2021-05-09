package TankGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CastStage {

    private final List<Tank> CURRENTPLAYERS;
    private final List<Tank> COLLIDECHECK;
    private final Set<Tank> REMOVEDPLAYERS;

    public CastStage() {
        this.CURRENTPLAYERS = new ArrayList<>();
        this.COLLIDECHECK = new ArrayList<>();
        this.REMOVEDPLAYERS = new HashSet<>();
    }

    public final List<Tank> getCURRENTPLAYERS() {
        return CURRENTPLAYERS;
    }

    public void addCURRENTPLAYERS(Tank... tanks){
        CURRENTPLAYERS.addAll(Arrays.asList(tanks));
    }
    public void removeCURRENTPLAYERS(Tank... tanks){
        CURRENTPLAYERS.removeAll(Arrays.asList(tanks));

    }
    public void resetCURRENTPLAYERS(){
        CURRENTPLAYERS.clear();
    }
    public List getCOLLIDECHECK(){
        return COLLIDECHECK;
    }
    public void resetCOLLIDECHECK(){
        COLLIDECHECK.clear();
        COLLIDECHECK.addAll(CURRENTPLAYERS);
    }
    public Set getREMOVEDPLAYERS(){
        return REMOVEDPLAYERS;
    }
    public void addToREMOVEDPLAYERS(Tank... tanks){
        if (tanks.length>1){
            REMOVEDPLAYERS.addAll(Arrays.asList((Tank[]) tanks));

        }else {
            REMOVEDPLAYERS.add(tanks[0]);
        }
    }
    public void resetREMOVEDPLAYERS(){
        CURRENTPLAYERS.removeAll(REMOVEDPLAYERS);
        REMOVEDPLAYERS.clear();
    }
}

