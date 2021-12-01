package ag.ag.items.materials;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

/**
 * A custom material for all Steel tools
 */
public class SteelMaterial implements ToolMaterial {
    public static final SteelMaterial INSTANCE = new SteelMaterial();

    @Override
    public int getDurability() {
        return 1950;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 8.0f;
    }

    @Override
    public float getAttackDamage() {
        return 4;
    }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 12;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}
