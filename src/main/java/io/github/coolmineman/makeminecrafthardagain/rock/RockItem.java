package io.github.coolmineman.makeminecrafthardagain.rock;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class RockItem extends Item {

    public RockItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!((hand == Hand.MAIN_HAND && user.getMainHandStack().getCount() >= 2) || (hand == Hand.OFF_HAND && user.getOffHandStack().getCount() >= 2))) return TypedActionResult.pass((user.getStackInHand(hand)));
        MinecraftClient.getInstance().openScreen(new RockCottonClientScreen());
        return TypedActionResult.success((user.getStackInHand(hand)));
    }
    
}