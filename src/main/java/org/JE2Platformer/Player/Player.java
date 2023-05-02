package org.JE2Platformer.Player;

import org.JE.JE2.Objects.GameObject;
import org.JE.JE2.Objects.Scripts.LambdaScript.ILambdaScript;
import org.JE.JE2.Objects.Scripts.LambdaScript.LambdaScript;
import org.JE.JE2.Objects.Scripts.Physics.PhysicsBody;
import org.JE.JE2.Rendering.Camera;
import org.JE.JE2.Rendering.Renderers.SpriteRenderer;
import org.JE.JE2.Rendering.Shaders.ShaderProgram;
import org.JE.JE2.Rendering.Texture;
import org.JE.JE2.UI.UIElements.Label;
import org.JE.JE2.UI.UIObjects.UIWindow;
import org.jbox2d.common.Vec2;
import org.joml.Vector2f;
import org.lwjgl.nuklear.Nuklear;

public class Player {
    public static Player instance;
    public GameObject playerObject;
    public Camera camera;
    private PlayerScript playerScript;
    private SpriteRenderer spriteRenderer;
    private PhysicsBody physicsBody;
    public UIWindow playerUI;

    public Player(){
        instance = this;
        playerObject = new GameObject();
        this.physicsBody = new PhysicsBody();
        playerUI = new UIWindow("Info", 0);
        playerUI.children.add(new Label("Jump Charge: 0", Nuklear.NK_TEXT_ALIGN_CENTERED));
        this.playerScript = new PlayerScript(physicsBody, playerUI);
        this.spriteRenderer = new SpriteRenderer(ShaderProgram.spriteShader());
        this.camera = new Camera();
        camera.zoomMultiplier = 0.5f;
        spriteRenderer.setTexture(Texture.checkExistElseCreate("player",-1,"player.png"));
        playerObject.addScript(playerScript);
        playerObject.addScript(spriteRenderer);
        playerObject.addScript(camera);
        playerObject.addScript(physicsBody);

        playerObject.addScript(new LambdaScript(new ILambdaScript() {
            @Override
            public void update(GameObject parent) {
                if(parent.getTransform().position().y()<=-20)
                {
                    physicsBody.body.setLinearVelocity(new Vec2(0,0));
                    playerObject.setPosition(0,0);
                }
            }
        }));

        playerUI.setSize(new Vector2f(200,50));
        playerUI.setPos(new Vector2f(0,0));
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
