package io.github.coolmineman.makeminecrafthardagain.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.github.coolmineman.makeminecrafthardagain.MMHA;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Items;

@Mixin(PlayerEntity.class)
public class ShieldBalance {
    @Inject(method = "takeShieldHit", at = @At("TAIL"))
    protected void takeShieldHit(LivingEntity attacker, CallbackInfo no) {
        if (!MMHA.CONFIG.shieldBalance) return;
        if (!(attacker.getMainHandStack().getItem() instanceof AxeItem)) {
            ((PlayerEntity)(Object)this).getItemCooldownManager().set(Items.SHIELD, 20);
            ((PlayerEntity)(Object)this).clearActiveItem();
            ((PlayerEntity)(Object)this).world.sendEntityStatus(((PlayerEntity)(Object)this), (byte)30);
        }
    }
}