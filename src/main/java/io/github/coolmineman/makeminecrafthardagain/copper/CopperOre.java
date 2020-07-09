package io.github.coolmineman.makeminecrafthardagain.copper;

import java.util.Random;

import net.minecraft.block.OreBlock;
import net.minecraft.util.math.MathHelper;

public class CopperOre extends OreBlock {

    public CopperOre(Settings settings) {
        super(settings);
    }

    @Override
    protected int getExperienceWhenMined(Random random) {
        return MathHelper.nextInt(random, 0, 2);
    }
}