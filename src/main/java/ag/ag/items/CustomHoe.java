package ag.ag.items;

import ag.ag.CustomItemSettings;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;

/**
 * A custom HoeItem constructor with special parameters for CustomItemSettings
 */
public class CustomHoe extends HoeItem {
    public CustomItemSettings settings;

    /**
     * @param toolMaterial The base material of the hoe
     * @param attackDamage The hoe's attack damage (final damage is this + 1)
     * @param attackSpeed The hoe's attack speed
     * @param settings The hoe's custom item settings
     */
    public CustomHoe(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, CustomItemSettings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings.defaultSettings);
        this.settings = settings;
    }

    /**
     * @param toolMaterial The base material of the hoe
     * @param attackSpeed The hoe's attack speed
     * @param settings The hoe's custom item settings
     */
    public CustomHoe(ToolMaterial toolMaterial, float attackSpeed, CustomItemSettings settings) {
        this(toolMaterial, (int) -toolMaterial.getAttackDamage(), attackSpeed, settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return this.settings.hasGlint || stack.hasEnchantments();
    }
}
