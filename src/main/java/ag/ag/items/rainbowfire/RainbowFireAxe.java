package ag.ag.items.rainbowfire;

import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;

public class RainbowFireAxe extends AxeItem {
    /**
     * @param toolMaterial The base material for the axe
     * @param attackDamage
     * @param attackSpeed
     * @param settings
     */
    public RainbowFireAxe(ToolMaterial toolMaterial, float attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
