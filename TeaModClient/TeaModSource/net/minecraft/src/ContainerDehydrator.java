package net.minecraft.src;

public class ContainerDehydrator extends Container {

	private TileEntityDehydrator dehydrator;

	public ContainerDehydrator(InventoryPlayer par1InventoryPlayer,
			TileEntityDehydrator par2TileEntityDehydrator) {
		dehydrator = par2TileEntityDehydrator;
		addSlot(new Slot(par2TileEntityDehydrator, 0, 56, 17));
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return dehydrator.isUseableByPlayer(entityplayer);
	}

}
