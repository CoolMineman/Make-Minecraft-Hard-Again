package io.github.coolmineman.makeminecrafthardagain.rock;

import net.minecraft.world.biome.Biome;

import com.google.common.collect.ImmutableSet;

import io.github.coolmineman.makeminecrafthardagain.MMHA;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.Direction;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

public class RockGenerationImpl {
    private RockGenerationImpl() {
    }

    public static final RandomPatchFeatureConfig ROCK_CONFIG = (new RandomPatchFeatureConfig.Builder(
            new WeightedBlockStateProvider()
                    .addState(MMHA.ROCK_BLOCK.getDefaultState().with(RockBlock.FACING, Direction.NORTH), 1)
                    .addState(MMHA.ROCK_BLOCK.getDefaultState().with(RockBlock.FACING, Direction.SOUTH), 1)
                    .addState(MMHA.ROCK_BLOCK.getDefaultState().with(RockBlock.FACING, Direction.WEST), 1)
                    .addState(MMHA.ROCK_BLOCK.getDefaultState().with(RockBlock.FACING, Direction.EAST), 1),
            SimpleBlockPlacer.field_24871)).tries(64).whitelist(ImmutableSet.of(Blocks.GRASS_BLOCK)).cannotProject()
                    .build();

    public static void addRockVegetation(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(ROCK_CONFIG)
                .createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(5))));
    }
}