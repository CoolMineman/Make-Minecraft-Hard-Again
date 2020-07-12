package io.github.coolmineman.makeminecrafthardagain.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.github.coolmineman.makeminecrafthardagain.MMHA;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.GenerationStep;

@Mixin(DefaultBiomeFeatures.class)
public class GenerateCopperOres {
    @Inject(method = "addDefaultOres", at = @At("HEAD"))
    private static void addDefaultOres(Biome biome, CallbackInfo yes) {
        if (!MMHA.CONFIG.generateCopperOres) return;
        biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, MMHA.COPPER_ORE.getDefaultState(), 17)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(20, 0, 0, 128))));
    }
}