package net.minecraft.src;

public class ContainerDehydrator extends Container {

	private TileEntityDehydrator dehydrator;

	public ContainerDehydrator(InventoryPlayer par1InventoryPlayer,
			TileEntityDehydrator par2TileEntityDehydrator) {
		this.dehydrator = par2TileEntityDehydrator;
		this.addSlot(new Slot(par2TileEntityDehydrator, 0, 56, 17));
		this.addSlot(new Slot(par2TileEntityDehydrator, 1, 56, 53));
        this.addSlot(new SlotFurnace(par1InventoryPlayer.player, par2TileEntityDehydrator, 2, 116, 35));
        int var3;

        for (var3 = 0; var3 < 3; ++var3)
        {
            for (int var4 = 0; var4 < 9; ++var4)
            {
                this.addSlot(new Slot(par1InventoryPlayer, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
            }
        }

        for (var3 = 0; var3 < 9; ++var3)
        {
            this.addSlot(new Slot(par1InventoryPlayer, var3, 8 + var3 * 18, 142));
        }
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return dehydrator.isUseableByPlayer(entityplayer);
	}

}
