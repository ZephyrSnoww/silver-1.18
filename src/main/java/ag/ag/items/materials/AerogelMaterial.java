package ag.ag.items.materials;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

/**
 * A custom material for all Carbon Nanotube tools
 */
public class AerogelMaterial implements ToolMaterial {
    public static final AerogelMaterial INSTANCE = new AerogelMaterial();

    @Override
    public int getDurability() {
        return 512;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 20.0f;
    }

    @Override
    public float getAttackDamage() {
        return 10;
    }

    @Override
    public int getMiningLevel() {
        return 10;
    }

    @Override
    public int getEnchantability() {
        return 5;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}
