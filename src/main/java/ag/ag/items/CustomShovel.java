package ag.ag.items;

import ag.ag.CustomItemSettings;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

import javax.tools.Tool;

/**
 * A custom ShovelItem constructor with special parameters for CustomItemSettings
 */
public class CustomShovel extends ShovelItem {
    public CustomItemSettings settings;

    /**
     * @param toolMaterial The base material of the shovel
     * @param attackDamage The shovel's attack damage (final damage is this + material damage + 1)
     * @param attackSpeed The shovel's attack speed
     * @param settings The shovel's custom item settings
     */
    public CustomShovel(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, CustomItemSettings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings.defaultSettings);
        this.settings = settings;
    }

    /**
     * @param toolMaterial The base material of the shovel
     * @param attackDamage The shovel's attack damage (final damage is this + material damage + 1)
     * @param settings The shovel's custom item settings
     */
    public CustomShovel(ToolMaterial toolMaterial, int attackDamage, CustomItemSettings settings) {
        this(toolMaterial, attackDamage, -3f, settings);
    }

    /**
     * @param toolMaterial The base material of the shovel
     * @param settings The shovel's custom item settings
     */
    public CustomShovel(ToolMaterial toolMaterial, CustomItemSettings settings) {
        this(toolMaterial, 2, -3f, settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return this.settings.hasGlint || stack.hasEnchantments();
    }
}
