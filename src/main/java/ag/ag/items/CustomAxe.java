package ag.ag.items;

import ag.ag.CustomItemSettings;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;

/**
 * A custom AxeItem constructor with special parameters for CustomItemSettings
 */
public class CustomAxe extends AxeItem {
    public CustomItemSettings settings;

    /**
     * @param toolMaterial The base material of the axe
     * @param attackDamage The axe's attack damage (final damage is this + material damage + 1)
     * @param attackSpeed The axe's attack speed
     * @param settings The axe's custom item settings
     */
    public CustomAxe(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, CustomItemSettings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings.defaultSettings);
        this.settings = settings;
    }

    /**
     * @param toolMaterial The base material of the axe
     * @param attackDamage The axe's attack damage (final damage is this + material damage + 1)
     * @param settings The axe's custom item settings
     */
    public CustomAxe(ToolMaterial toolMaterial, int attackDamage, CustomItemSettings settings) {
        this(toolMaterial, attackDamage, -3f, settings);
    }

    /**
     * @param toolMaterial The base material of the axe
     * @param attackSpeed The axe's attack speed
     * @param settings The axe's custom item settings
     */
    public CustomAxe(ToolMaterial toolMaterial, float attackSpeed, CustomItemSettings settings) {
        this(toolMaterial, 6, attackSpeed, settings);
    }

    /**
     * @param toolMaterial The base material of the axe
     * @param settings The axe's custom item settings
     */
    public CustomAxe(ToolMaterial toolMaterial, CustomItemSettings settings) {
        this(toolMaterial, 6, -3f, settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return this.settings.hasGlint || stack.hasEnchantments();
    }
}
