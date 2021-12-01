package ag.ag.items.materials;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

/**
 * A custom material for all RainbowFire Obsidian tools
 */
public class RainbowFireMaterial implements ToolMaterial {
    public static final RainbowFireMaterial INSTANCE = new RainbowFireMaterial();

    @Override
    public int getDurability() {
        return 4096;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 10.0f;
    }

    @Override
    public float getAttackDamage() {
        return 6;
    }

    @Override
    public int getMiningLevel() {
        return 6;
    }

    @Override
    public int getEnchantability() {
        return 50;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}
