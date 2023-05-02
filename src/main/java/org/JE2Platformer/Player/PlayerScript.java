package org.JE2Platformer.Player;

import org.JE.JE2.IO.UserInput.Keyboard.Keyboard;
import org.JE.JE2.IO.UserInput.Mouse.Mouse;
import org.JE.JE2.IO.UserInput.Mouse.MouseButton;
import org.JE.JE2.IO.UserInput.Mouse.MousePressedEvent;
import org.JE.JE2.Manager;
import org.JE.JE2.Objects.Scripts.Physics.PhysicsBody;
import org.JE.JE2.Objects.Scripts.Script;
import org.JE.JE2.UI.UIElements.Label;
import org.JE.JE2.UI.UIObjects.UIWindow;
import org.jbox2d.common.Vec2;
import org.joml.Math;

import java.text.DecimalFormat;

public class PlayerScript extends Script {
    private float jumpCharge = 0;
    private int chargeDirection = 1;
    private PhysicsBody physicsRef;
    public int direction = 1;
    UIWindow playerUI;
    public static PlayerScript playerScript;
    static {
        Mouse.addMousePressedEvent(new MousePressedEvent() {
            @Override
            public void invoke(MouseButton mouseButton, int i) {
                if(mouseButton == MouseButton.LEFT){
                    playerScript.direction = -playerScript.direction;
                    Player.instance.setPlayerTexture((playerScript.direction==1));
                }
            }
        });
    }

    public PlayerScript(PhysicsBody physicsRef, UIWindow playerUI){
        this.physicsRef = physicsRef;
        playerScript = this;
        this.playerUI = playerUI;
    }

    DecimalFormat df = new DecimalFormat("##");
    @Override
    public void update() {
        if(!physicsRef.onGround)
            jumpCharge = 0;
        if(Keyboard.isKeyPressed(Keyboard.nameToCode("SPACE"))){
            jumpCharge+=100*chargeDirection* Manager.deltaTime();
            jumpCharge = Math.clamp(0,99,jumpCharge);
            if(jumpCharge>=99)
                chargeDirection = -1;
            else if(jumpCharge<=0)
                chargeDirection = 1;
        }
        else {
            if(jumpCharge>0){
                System.out.println("Jumping with charge: "+jumpCharge);
                physicsRef.body.applyForceToCenter(new Vec2(jumpCharge*4f*direction, jumpCharge*7));
            }
            jumpCharge = 0;
        }

        ((Label)playerUI.children.get(0)).text = "Jump Charge: "+df.format(jumpCharge);

    }

    @Override
    public void start() {
        super.start();
    }

}
