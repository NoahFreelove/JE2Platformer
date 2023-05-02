package org.JE2Platformer.Player;

import org.JE.JE2.IO.UserInput.Keyboard.Keyboard;
import org.JE.JE2.IO.UserInput.Mouse.Mouse;
import org.JE.JE2.IO.UserInput.Mouse.MouseButton;
import org.JE.JE2.IO.UserInput.Mouse.MousePressedEvent;
import org.JE.JE2.Manager;
import org.JE.JE2.Objects.Scripts.Physics.PhysicsBody;
import org.JE.JE2.Objects.Scripts.Script;
import org.jbox2d.common.Vec2;
import org.joml.Math;

public class PlayerScript extends Script {
    private float jumpCharge = 0;
    private PhysicsBody physicsRef;
    public int direction = 1;
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

    public PlayerScript(PhysicsBody physicsRef){
        this.physicsRef = physicsRef;
        playerScript = this;
    }

    @Override
    public void update() {
        if(!physicsRef.onGround)
            jumpCharge = 0;
        if(Keyboard.isKeyPressed(Keyboard.nameToCode("SPACE"))){
            jumpCharge+=4* Manager.deltaTime();
            jumpCharge = Math.clamp(0,2,jumpCharge);
        }
        else {
            if(jumpCharge>0){
                System.out.println("Jumping with charge: "+jumpCharge);
                physicsRef.body.applyForceToCenter(new Vec2(jumpCharge*125*direction, jumpCharge*250));
            }
            jumpCharge = 0;
        }
    }

    @Override
    public void start() {
        super.start();
    }

}
