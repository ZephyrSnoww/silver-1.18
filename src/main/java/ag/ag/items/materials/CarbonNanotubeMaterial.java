package ag.ag.items.materials;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

/**
 * A custom material for all Carbon Nanotube tools
 */
public class CarbonNanotubeMaterial implements ToolMaterial {
    public static final CarbonNanotubeMaterial INSTANCE = new CarbonNanotubeMaterial();

    @Override
    public int getDurability() {
        return 8192;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 12.0f;
    }

    @Override
    public float getAttackDamage() {
        return 8;
    }

    @Override
    public int getMiningLevel() {
        return 7;
    }

    @Override
    public int getEnchantability() {
        return 10;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}
