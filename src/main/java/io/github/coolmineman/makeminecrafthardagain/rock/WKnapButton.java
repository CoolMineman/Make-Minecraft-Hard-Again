package io.github.coolmineman.makeminecrafthardagain.rock;

import io.github.cottonmc.cotton.gui.widget.WSprite;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class WKnapButton extends WSprite {
    private static final Identifier imageid = new Identifier("mmha:textures/gui/knapped_overlay.png");
    private RockGUI yes;
    private int knapx;
    private int knapy;

    WKnapButton(RockGUI yes, int knapx, int knapy) {
        super(imageid);
        this.yes = yes;
        this.knapx = knapx;
        this.knapy = knapy;
    }

    @Override
	public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY) {
        if (yes.knapped[knapx][knapy]) super.paint(matrices, x, y, mouseX, mouseY);
    }

    @Environment(EnvType.CLIENT)
	@Override
	public void onMouseMove(int x, int y) {
        if (this.yes.yes.mouseDown && !yes.knapped[knapx][knapy]) {
            MinecraftClient.getInstance().getSoundManager().play(PositionedSoundInstance.master(SoundEvents.UI_BUTTON_CLICK, 1.0F));
            this.yes.knapped[knapx][knapy] = true;
        }
    }

    @Override
    public void onClick(int x, int y, int button) {
        if (!yes.knapped[knapx][knapy]) {
            MinecraftClient.getInstance().getSoundManager().play(PositionedSoundInstance.master(SoundEvents.UI_BUTTON_CLICK, 1.0F));
            this.yes.knapped[knapx][knapy] = true;
        }
    }
}