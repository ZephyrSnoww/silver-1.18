package ag.ag.items.rainbowfire;

import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;

public class RainbowFireHoe extends HoeItem {
    /**
     * @param toolMaterial The base material for the hoe
     * @param attackDamage The hoe's attack damage (final value is this + 1)
     * @param attackSpeed The hoe's attack speed
     * @param settings Settings for the item - usually an item group, etc.
     */
    public RainbowFireHoe(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
