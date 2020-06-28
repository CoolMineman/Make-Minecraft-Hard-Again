package io.github.coolmineman.makeminecrafthardagain.rock;

import io.github.cottonmc.cotton.gui.client.CottonClientScreen;

public class RockCottonClientScreen extends CottonClientScreen {
    public boolean mouseDown = false;

    public RockCottonClientScreen() {
        super(new RockGUI());
        ((RockGUI)this.description).yes = this;
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
    @Override
	public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {
        if (mouseButton == 0)
            mouseDown = true;
        return super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
	public boolean mouseReleased(double mouseX, double mouseY, int mouseButton) {
        if (mouseButton == 0)
            mouseDown =  false;
        return super.mouseReleased(mouseX, mouseY, mouseButton);
    }
    
}