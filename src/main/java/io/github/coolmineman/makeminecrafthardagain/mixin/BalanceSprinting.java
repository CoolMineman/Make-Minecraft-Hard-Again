package io.github.coolmineman.makeminecrafthardagain.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.Difficulty;

@Mixin(HungerManager.class)
public class BalanceSprinting {
    @Shadow
    private float foodSaturationLevel;

    @Shadow
    private int foodLevel;

    private int tickCounter = 0;

    @Inject(method = "update", at = @At("TAIL"))
    public void update(PlayerEntity player, CallbackInfo no) {
        if (player.isSprinting()) {
            if (tickCounter >= 100) {
                Difficulty difficulty = player.world.getDifficulty();
                if (this.foodSaturationLevel > 0.0F) {
                    this.foodSaturationLevel = Math.max(this.foodSaturationLevel - 1.0F, 0.0F);
                } else if (difficulty != Difficulty.PEACEFUL) {
                    this.foodLevel = Math.max(this.foodLevel - 1, 0);
                }
                tickCounter = 0;
            } else {
                tickCounter++;
            }
        }
    }
}