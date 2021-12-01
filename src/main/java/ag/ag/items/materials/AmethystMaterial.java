package ag.ag.items.materials;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

/**
 * A custom material for all Amethyst tools
 */
public class AmethystMaterial implements ToolMaterial {
    public static final AmethystMaterial INSTANCE = new AmethystMaterial();

    @Override
    public int getDurability() {
        return 2250;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 10.0f;
    }

    @Override
    public float getAttackDamage() {
        return 5;
    }

    @Override
    public int getMiningLevel() {
        return 5;
    }

    @Override
    public int getEnchantability() {
        return 35;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}
