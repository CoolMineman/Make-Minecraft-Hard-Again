package io.github.coolmineman.makeminecrafthardagain.rock;

import io.github.coolmineman.makeminecrafthardagain.MMHA;
import net.fabricmc.fabric.api.network.PacketConsumer;
import net.fabricmc.fabric.api.network.PacketContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;

public class KnappingConsumer implements PacketConsumer {
    boolean[][] knapped = new boolean[5][5];

    @Override
    public void accept(PacketContext context, PacketByteBuf buffer) {
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                knapped[i][j] = buffer.readBoolean();
            }
        }
        context.getTaskQueue().execute(() -> {
            PlayerEntity player = context.getPlayer();
            ItemStack a = player.inventory.getMainHandStack();
            if (!a.getItem().equals(MMHA.ROCK)) {
                a = player.inventory.offHand.get(0);
            }
            if (!a.getItem().equals(MMHA.ROCK)) {
                return;
            }
            if (a.getCount() > 1) {
                ItemStack output = RockKnappingRecipies.getRecipe(knapped).copy();
                if (!output.isEmpty()) {
                    a.decrement(1);
                    player.giveItemStack(output);
                }
            }
        });
    }
}