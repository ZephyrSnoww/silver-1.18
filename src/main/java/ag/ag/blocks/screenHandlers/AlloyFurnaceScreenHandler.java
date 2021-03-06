package ag.ag.blocks.screenHandlers;

import ag.ag.Ag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class AlloyFurnaceScreenHandler extends ScreenHandler {
    private final Inventory inventory;

    public AlloyFurnaceScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(3));
    }

    public AlloyFurnaceScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(Ag.ALLOY_FURNACE_SCREEN_HANDLER, syncId);
        checkSize(inventory, 1);
        this.inventory = inventory;

        inventory.onOpen(playerInventory.player);

        for (int m = 0; m < 3; ++m) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + m * 9 + 9, 8 + l * 18, 84 + m * 18));
            }
        }

        for (int m = 0; m < 9; ++m) {
            this.addSlot(new Slot(playerInventory, m, 8 + m * 18, 142));
        }

//        this.addSlot(new Slot(inventory, 0, 80, 42));
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    @Override
    public ItemStack transferSlot(PlayerEntity player, int invSlot) {
        System.out.println("transferSlot called");

        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);

        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
                else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                    return ItemStack.EMPTY;
                }

                if (originalStack.isEmpty()) {
                    slot.setStack(ItemStack.EMPTY);
                }
                else {
                    slot.markDirty();
                }
            }
        }
        return newStack;
    }
}
