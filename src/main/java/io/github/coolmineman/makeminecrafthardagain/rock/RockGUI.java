package io.github.coolmineman.makeminecrafthardagain.rock;

import io.github.cottonmc.cotton.gui.client.BackgroundPainter;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.WSprite;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Identifier;

public class RockGUI extends LightweightGuiDescription {
    boolean[][] knapped = new boolean[5][5];

    public RockGUI() {
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(0, 0);
        
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                WSprite icon = new WSprite(new Identifier("minecraft:textures/block/stone.png"));
                root.add(icon, i, j + 1, 1, 1);
                WKnapButton icon2 = new WKnapButton(this, j, i);
                root.add(icon2, i, j + 1, 1, 1);
            }
        }

        WSprite arrow = new WSprite(new Identifier("mmha:textures/gui/arrow.png"));
        root.add(arrow, 6, 3, 1, 1);

        //todo output
        WKnapRecipe output = new WKnapRecipe(this);
        root.add(output, 8, 3, 1, 1);

        WLabel label = new WLabel(new LiteralText("Stone Knapping"), 0x000000);
        root.add(label, 0, 0, 2, 1);

        root.validate(this);
    }

    @Override
    public void addPainters() {
        getRootPanel().setBackgroundPainter(BackgroundPainter.VANILLA); // This is done automatically though
    }
}