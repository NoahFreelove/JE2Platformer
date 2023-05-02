package org.JE2Platformer.Scenes;

import org.JE.JE2.Objects.GameObject;
import org.JE.JE2.Objects.Scripts.Physics.PhysicsBody;
import org.JE.JE2.Rendering.Renderers.SpriteRenderer;
import org.JE.JE2.Rendering.Shaders.ShaderProgram;
import org.JE.JE2.Rendering.Texture;
import org.jbox2d.dynamics.BodyType;

public class SolidTileCreator {

    public static GameObject createSolidTile(int x, int y, int sizeX, int sizeY, String image){
        GameObject tile = new GameObject();
        tile.getTransform().setPosition(x, y);
        tile.getTransform().setScale(sizeX, sizeY);
        SpriteRenderer sr = new SpriteRenderer(ShaderProgram.spriteShader());
        sr.setTexture(Texture.checkExistElseCreate(image,-1,image));
        tile.addScript(sr);
        PhysicsBody pb = new PhysicsBody();
        pb.setMode(BodyType.STATIC);
        tile.addScript(pb);
        return tile;
    }
}
