package ag.ag.items.materials;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

/**
 * A custom material for all Obsidian tools
 */
public class ObsidianMaterial implements ToolMaterial {
    public static final ObsidianMaterial INSTANCE = new ObsidianMaterial();

    @Override
    public int getDurability() {
        return 1700;
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
        return 25;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}
