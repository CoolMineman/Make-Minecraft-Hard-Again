package io.github.coolmineman.makeminecrafthardagain.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.github.coolmineman.makeminecrafthardagain.MMHA;
import net.minecraft.item.ToolMaterials;

@Mixin(ToolMaterials.class)
public class TweekStoneMiningSpeed {
    @Shadow
    private int miningLevel;

    @Inject(method = "getMiningSpeedMultiplier", at = @At("HEAD"), cancellable = true)
    public void getMiningSpeedMultiplier(CallbackInfoReturnable<Float> yes) {
        if (!MMHA.CONFIG.tweekStoneMiningSpeed) return;
        if (miningLevel <= 1) {
            yes.setReturnValue(1f);
        }
    }
}