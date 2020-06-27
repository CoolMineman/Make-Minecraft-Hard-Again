package io.github.coolmineman.makeminecrafthardagain.rock;

import java.util.ArrayList;

import io.github.coolmineman.makeminecrafthardagain.MMHA;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RockKnappingRecipies {
    private RockKnappingRecipies() {}

    public static ArrayList<Recipe> recipies = new ArrayList<>();

    static {
        addRecipe(
            new String[]{
                "   x ",
                " xxxx",
                "xxxxx",
                " xxxx",
                "   x "
            },
            MMHA.STONE_AXE_HEAD
        );
        addRecipe(
            new String[]{
                " x   ",
                "xxxx ",
                "xxxxx",
                "xxxx ",
                " x   "
            },
            MMHA.STONE_AXE_HEAD
        );
        addRecipe(
            new String[]{
                " xxx ",
                " xxx ",
                " xxx ",
                " xxx ",
                "  x  "
            },
            MMHA.STONE_SHOVEL_HEAD
        );
        addRecipe(
            new String[]{
                "xxx  ",
                "xxx  ",
                "xxx  ",
                "xxx  ",
                " x   "
            },
            MMHA.STONE_SHOVEL_HEAD
        );
        addRecipe(
            new String[]{
                "  xxx",
                "  xxx",
                "  xxx",
                "  xxx",
                "   x "
            },
            MMHA.STONE_SHOVEL_HEAD
        );
        addRecipe(
            new String[]{
                "xxxxx",
                "   xx",
                "     ",
                "     ",
                "     "
            },
            MMHA.STONE_HOE_HEAD
        );
        addRecipe(
            new String[]{
                "xxxxx",
                "xx   ",
                "     ",
                "     ",
                "     "
            },
            MMHA.STONE_HOE_HEAD
        );
        addRecipe(
            new String[]{
                "     ",
                "xxxxx",
                "   xx",
                "     ",
                "     "
            },
            MMHA.STONE_HOE_HEAD
        );
        addRecipe(
            new String[]{
                "     ",
                "xxxxx",
                "xx   ",
                "     ",
                "     "
            },
            MMHA.STONE_HOE_HEAD
        );
        addRecipe(
            new String[]{
                "     ",
                "     ",
                "xxxxx",
                "   xx",
                "     "
            },
            MMHA.STONE_HOE_HEAD
        );
        addRecipe(
            new String[]{
                "     ",
                "     ",
                "xxxxx",
                "xx   ",
                "     "
            },
            MMHA.STONE_HOE_HEAD
        );
        addRecipe(
            new String[]{
                "     ",
                "     ",
                "     ",
                "xxxxx",
                "   xx"
            },
            MMHA.STONE_HOE_HEAD
        );
        addRecipe(
            new String[]{
                "     ",
                "     ",
                "     ",
                "xxxxx",
                "xx   "
            },
            MMHA.STONE_HOE_HEAD
        );
        addRecipe(
            new String[]{
                "xxxxx",
                "xx   ",
                "     ",
                "xxxxx",
                "xx   "
            },
            new ItemStack(MMHA.STONE_HOE_HEAD, 2)
        );
        addRecipe(
            new String[]{
                "xxxxx",
                "   xx",
                "     ",
                "xxxxx",
                "   xx"
            },
            new ItemStack(MMHA.STONE_HOE_HEAD, 2)
        );
        addRecipe(
            new String[]{
                "     ",
                "     ",
                "     ",
                " xxx ",
                "x   x"
            },
            MMHA.STONE_PICKAXE_HEAD
        );
        addRecipe(
            new String[]{
                "     ",
                "     ",
                " xxx ",
                "x   x",
                "     "
            },
            MMHA.STONE_PICKAXE_HEAD
        );
        addRecipe(
            new String[]{
                "     ",
                " xxx ",
                "x   x",
                "     ",
                "     "
            },
            MMHA.STONE_PICKAXE_HEAD
        );
        addRecipe(
            new String[]{
                " xxx ",
                "x   x",
                "     ",
                "     ",
                "     "
            },
            MMHA.STONE_PICKAXE_HEAD
        );
        addRecipe(
            new String[]{
                " xxx ",
                "x   x",
                "     ",
                " xxx ",
                "x   x"
            },
            new ItemStack(MMHA.STONE_PICKAXE_HEAD, 2)
        );
        addRecipe(
            new String[]{
                "x    ",
                "xx   ",
                "xx   ",
                "xx   ",
                "xx   "
            },
            MMHA.STONE_SWORD_HEAD
        );
        addRecipe(
            new String[]{
                " x   ",
                " xx  ",
                " xx  ",
                " xx  ",
                " xx  "
            },
            MMHA.STONE_SWORD_HEAD
        );
        addRecipe(
            new String[]{
                "  x  ",
                "  xx ",
                "  xx ",
                "  xx ",
                "  xx "
            },
            MMHA.STONE_SWORD_HEAD
        );
        addRecipe(
            new String[]{
                "   x ",
                "   xx",
                "   xx",
                "   xx",
                "   xx"
            },
            MMHA.STONE_SWORD_HEAD
        );
        addRecipe(
            new String[]{
                "    x",
                "   xx",
                "   xx",
                "   xx",
                "   xx"
            },
            MMHA.STONE_SWORD_HEAD
        );
        addRecipe(
            new String[]{
                "   x ",
                "  xx ",
                "  xx ",
                "  xx ",
                "  xx "
            },
            MMHA.STONE_SWORD_HEAD
        );
        addRecipe(
            new String[]{
                "  x  ",
                " xx  ",
                " xx  ",
                " xx  ",
                " xx  "
            },
            MMHA.STONE_SWORD_HEAD
        );
        addRecipe(
            new String[]{
                " x   ",
                "xx   ",
                "xx   ",
                "xx   ",
                "xx   "
            },
            MMHA.STONE_SWORD_HEAD
        );
        addRecipe(
            new String[]{
                " x  x",
                "xx xx",
                "xx xx",
                "xx xx",
                "xx xx"
            },
            new ItemStack(MMHA.STONE_SWORD_HEAD, 2)
        );
        addRecipe(
            new String[]{
                "x  x ",
                "xx xx",
                "xx xx",
                "xx xx",
                "xx xx"
            },
            new ItemStack(MMHA.STONE_SWORD_HEAD, 2)
        );
    }

    public static void addRecipe(String[] a, Item b) {
        addRecipe(a, new ItemStack(b));
    }

    public static void addRecipe(String[] a, ItemStack b) {
        boolean[][] recipe = new boolean[5][5];
        for (int i = 0; i < a.length; i++) {
            char[] c = a[i].toCharArray();
            for (int j = 0; j < c.length; j++) {
                if (c[j] == ' ') {
                    recipe[i][j] = true;
                } else {
                    recipe[i][j] = false;
                }
            }
        }
        recipies.add(new Recipe(recipe, b));
    }

    public static ItemStack getRecipe(boolean[][] knapping) {
        for (int i = 0; i <= recipies.size() - 1; i++) {
            Recipe recipe = recipies.get(i);
            if (checkRecipe(recipe.recipe, knapping)) {
                return recipe.output;
            }
        }
        return ItemStack.EMPTY;
    }

    public static boolean checkRecipe(boolean[][] a, boolean[][] b) {
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static class Recipe {
        public boolean[][] recipe;
        public ItemStack output;
        public Recipe(boolean[][] recipe, ItemStack output) {
            this.recipe = recipe;
            this.output = output;
        }
    }
}