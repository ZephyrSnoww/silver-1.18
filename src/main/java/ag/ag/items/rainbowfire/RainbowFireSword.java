package ag.ag.items.rainbowfire;

import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class RainbowFireSword extends SwordItem {
    public RainbowFireSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

//    @Override
//    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
//        target.playSound(SoundEvents.BLOCK_GLASS_BREAK, 1, 1);
//        stack.damage(1, attacker, (e) -> {
//            e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
//        });
//        return true;
//    }
}
