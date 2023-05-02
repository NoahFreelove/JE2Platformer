package org.JE2Platformer.Scenes;

import org.JE.JE2.Manager;
import org.JE.JE2.Scene.Scene;
import org.JE.JE2.UI.UIElements.Buttons.Button;
import org.JE.JE2.UI.UIElements.Label;
import org.JE.JE2.UI.UIElements.Style.Color;
import org.JE.JE2.UI.UIObjects.UIWindow;
import org.JE2Platformer.Main;
import org.joml.Vector2f;
import org.lwjgl.nuklear.Nuklear;

public class MainMenu extends Scene {
    public static MainMenu instance;

    public MainMenu(){
        MainMenu.instance = this;
        UIWindow window = new UIWindow("Main Menu", 0);
        window.setSize(new Vector2f(Main.resolution.x,Main.resolution.y));
        window.setPos(new Vector2f(0,0));
        window.setBackgroundColor(Color.createColor(0.5f,0.5f,0.5f,1f));
        window.children.add(new Label("JE2 Platformer", Nuklear.NK_TEXT_ALIGN_CENTERED));
        window.children.add(new Label("Press Space To Jump, Left Click To Switch Directions", Nuklear.NK_TEXT_ALIGN_CENTERED));
        window.children.add(new Label("Press R To Restart", Nuklear.NK_TEXT_ALIGN_CENTERED));
        window.children.add(new Button("Play", () -> Manager.setScene(new GameScene())));
        addUI(window);
    }
}
