package org.JE2Platformer;
import org.JE.JE2.IO.Logging.Logger;
import org.JE.JE2.IO.UserInput.Keyboard.Keyboard;
import org.JE.JE2.Manager;
import org.JE.JE2.Window.WindowPreferences;
import org.JE2Platformer.Scenes.GameScene;
import org.JE2Platformer.Scenes.MainMenu;
import org.joml.Vector2i;

public class Main {
    public static Vector2i resolution = new Vector2i(1280,720);
    public static void main(String[] args) {
        WindowPreferences preferences = new WindowPreferences(resolution, "JE2 Platformer", false, true);
        Manager.start(preferences);
        Logger.logErrors = true;
        Logger.logPetty = true;
        Manager.setScene(new MainMenu());
        Keyboard.addKeyReleasedEvent((key, mods) -> {
            if(Keyboard.codeToName(key).equals("R")){
                Manager.setScene(new GameScene());
            }
        });
    }
}