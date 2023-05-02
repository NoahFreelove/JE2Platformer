package org.JE2Platformer.Player;

import org.JE.JE2.Objects.GameObject;
import org.JE.JE2.Objects.Scripts.Physics.PhysicsBody;
import org.JE.JE2.Rendering.Camera;
import org.JE.JE2.Rendering.Renderers.SpriteRenderer;
import org.JE.JE2.Rendering.Shaders.ShaderProgram;
import org.JE.JE2.Rendering.Texture;

public class Player {
    public static Player instance;
    public GameObject playerObject;
    public Camera camera;
    private PlayerScript playerScript;
    private SpriteRenderer spriteRenderer;
    private PhysicsBody physicsBody;
    public Player(){
        instance = this;
        playerObject = new GameObject();
        this.physicsBody = new PhysicsBody();
        this.playerScript = new PlayerScript(physicsBody);
        this.spriteRenderer = new SpriteRenderer(ShaderProgram.spriteShader());
        this.camera = new Camera();
        camera.zoomMultiplier = 0.5f;
        spriteRenderer.setTexture(Texture.checkExistElseCreate("player",-1,"player.png"));
        playerObject.addScript(playerScript);
        playerObject.addScript(spriteRenderer);
        playerObject.addScript(camera);
        playerObject.addScript(physicsBody);
    }

    public void setPlayerTexture(boolean right){
        if(right){
            spriteRenderer.setTexture(Texture.checkExistElseCreate("player",-1,"player.png"));
        }
        else{
            spriteRenderer.setTexture(Texture.checkExistElseCreate("playerAlt",-1,"playerAlt.png"));

        }
    }
}
