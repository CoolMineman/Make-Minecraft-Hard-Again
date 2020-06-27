package io.github.coolmineman.makeminecrafthardagain.rock;

import io.github.cottonmc.cotton.gui.client.CottonClientScreen;

public class RockCottonClientScreen extends CottonClientScreen {

    public RockCottonClientScreen() {
        super(new RockGUI());
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
    
}