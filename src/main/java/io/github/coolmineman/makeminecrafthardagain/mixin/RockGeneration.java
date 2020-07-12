package io.github.coolmineman.makeminecrafthardagain.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.github.coolmineman.makeminecrafthardagain.MMHA;
import io.github.coolmineman.makeminecrafthardagain.rock.RockGenerationImpl;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;



@Mixin(DefaultBiomeFeatures.class)
public class RockGeneration {
    @Inject(method = "addDefaultVegetation", at = @At("HEAD"))
    private static void addDefaultVegetation(Biome biome, CallbackInfo yes) {
        if (!MMHA.CONFIG.rockGeneration) return;
        RockGenerationImpl.addRockVegetation(biome);
    }
}