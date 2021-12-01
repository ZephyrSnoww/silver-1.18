package ag.ag;

import net.minecraft.item.Item;

/**
 * Contains a series of settings otherwise inaccessible through item creation.
 */
public class CustomItemSettings {
    /**
     * Set the item's enchanement glint
     * @param hasGlint Whether the item should have an enchantment glint
     * @return this
     */
    public CustomItemSettings hasGlint(boolean hasGlint) {
        this.hasGlint = hasGlint;
        return this;
    }

    public boolean hasGlint;
    public Item.Settings defaultSettings;

    /**
     * @param settings The default settings to include alongside custom settings
     */
    public CustomItemSettings(Item.Settings settings) {
        this.hasGlint = false;
        this.defaultSettings = settings;
    }
}
