package ag.ag.items;

import ag.ag.CustomItemSettings;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

/**
 * A custom SwordItem constructor with special parameters for CustomItemSettings
 */
public class CustomSword extends SwordItem {
    public CustomItemSettings settings;

    /**
     * @param toolMaterial The base material of the sword
     * @param attackDamage The sword's attack damage (final damage is this + material damage + 1)
     * @param attackSpeed The sword's attack speed
     * @param settings The sword's custom item settings
     */
    public CustomSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, CustomItemSettings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings.defaultSettings);
        this.settings = settings;
    }

    /**
     * @param toolMaterial The base material of the sword
     * @param attackDamage The sword's attack damage (final damage is this + material damage + 1)
     * @param settings The sword's custom item settings
     */
    public CustomSword(ToolMaterial toolMaterial, int attackDamage, CustomItemSettings settings) {
        this(toolMaterial, attackDamage, -2.4f, settings);
    }

    /**
     * @param toolMaterial The base material of the sword
     * @param attackSpeed The sword's attack speed
     * @param settings The sword's custom item settings
     */
    public CustomSword(ToolMaterial toolMaterial, float attackSpeed, CustomItemSettings settings) {
        this(toolMaterial, 3, attackSpeed, settings);
    }

    /**
     * @param toolMaterial The base material of the sword
     * @param settings The sword's custom item settings
     */
    public CustomSword(ToolMaterial toolMaterial, CustomItemSettings settings) {
        this(toolMaterial, 3, -2.4f, settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return this.settings.hasGlint || stack.hasEnchantments();
    }
}
