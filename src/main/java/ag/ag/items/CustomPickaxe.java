package ag.ag.items;

import ag.ag.CustomItemSettings;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

/**
 * A custom PickaxeItem constructor with special parameters for CustomItemSettings
 */
public class CustomPickaxe extends PickaxeItem {
    public CustomItemSettings settings;

    /**
     * @param toolMaterial The base material of the pickaxe
     * @param attackDamage The pickaxe's attack damage (final damage is this + material damage + 1)
     * @param attackSpeed The pickaxe's attack speed
     * @param settings The pickaxe's custom item settings
     */
    public CustomPickaxe(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, CustomItemSettings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings.defaultSettings);
        this.settings = settings;
    }

    /**
     * @param toolMaterial The base material of the pickaxe
     * @param attackDamage The pickaxe's attack damage (final damage is this + material damage + 1)
     * @param settings The pickaxe's custom item settings
     */
    public CustomPickaxe(ToolMaterial toolMaterial, int attackDamage, CustomItemSettings settings) {
        this(toolMaterial, attackDamage, -2.8f, settings);
    }

    /**
     * @param toolMaterial The base material of the pickaxe
     * @param settings The pickaxe's custom item settings
     */
    public CustomPickaxe(ToolMaterial toolMaterial, CustomItemSettings settings) {
        this(toolMaterial, 1, -2.8f, settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return this.settings.hasGlint || stack.hasEnchantments();
    }
}
