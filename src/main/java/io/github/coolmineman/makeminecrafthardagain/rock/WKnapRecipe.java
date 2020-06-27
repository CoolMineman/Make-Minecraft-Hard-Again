package io.github.coolmineman.makeminecrafthardagain.rock;

import java.util.Collections;

import com.mojang.blaze3d.systems.RenderSystem;

import io.github.coolmineman.makeminecrafthardagain.MMHA;
import io.github.cottonmc.cotton.gui.client.BackgroundPainter;
import io.github.cottonmc.cotton.gui.widget.WItem;
import io.netty.buffer.Unpooled;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;

public class WKnapRecipe extends WItem {
    RockGUI yes;

    public WKnapRecipe(RockGUI yes) {
        super(RockKnappingRecipies.getRecipe(yes.knapped));
        this.yes = yes;
    }

    @Environment(EnvType.CLIENT)
    @Override
	public void onClick(int x, int y, int button) {
        PacketByteBuf passedData = new PacketByteBuf(Unpooled.buffer());
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                passedData.writeBoolean(yes.knapped[i][j]);
            }
        }
        if (!RockKnappingRecipies.getRecipe(yes.knapped).isEmpty()) {
            ClientSidePacketRegistry.INSTANCE.sendToServer(MMHA.KNAPPING_PACKET_ID, passedData);
            MinecraftClient.getInstance().openScreen(new RockCottonClientScreen());
        }
	}

    @Override
    public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY) {
        boolean hovered = (mouseX>=0 && mouseY>=0 && mouseX<getWidth() && mouseY<getHeight());
        RenderSystem.enableDepthTest();

		MinecraftClient mc = MinecraftClient.getInstance();
		ItemRenderer renderer = mc.getItemRenderer();
        renderer.zOffset = 100f;
        ItemStack item = this.getItems().get(0);
		renderer.renderInGui(item, x + getWidth() / 2 - 9 + 1, y + getHeight() / 2 - 9 + 1); // Had to dupe a bunch of code for this
        renderer.zOffset = 0f;
        if (!hovered)
            BackgroundPainter.SLOT.paintBackground(x, y, this);
        else if (!RockKnappingRecipies.getRecipe(yes.knapped).isEmpty()) {
            BackgroundPainter.createColorful(0xff0000).paintBackground(x, y, this);
        } else {
            BackgroundPainter.SLOT.paintBackground(x, y, this);
        }
        if (item.getCount() > 1)
            mc.textRenderer.draw(matrices, "x" + Integer.toString(item.getCount()), x, y + 20, 0x000000);
    }
    
    @Override
    public void tick() {
        super.tick();
        this.setItems(Collections.singletonList(RockKnappingRecipies.getRecipe(yes.knapped)));
    }
}