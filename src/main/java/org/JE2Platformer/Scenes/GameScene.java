package org.JE2Platformer.Scenes;

import org.JE.JE2.Scene.Scene;
import org.JE2Platformer.Player.Player;

public class GameScene extends Scene {
    public static GameScene instance;

    public GameScene(){
        instance = this;
        add(new Player().playerObject);
        add(SolidTileCreator.createSolidTile(-1,-2,3,1,"grass.png"));
        add(SolidTileCreator.createSolidTile(4,-2,2,1,"grass.png"));
        add(SolidTileCreator.createSolidTile(7,0,3,1,"grass.png"));
        addUI(Player.instance.playerUI);
        setCamera(Player.instance.camera);
    }
}
