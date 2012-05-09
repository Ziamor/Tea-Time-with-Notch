package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class GuiDehydrator extends GuiContainer {

	public GuiDehydrator(InventoryPlayer par1InventoryPlayer,
			TileEntityDehydrator par2TileEntityDehydrator) {
		super(new ContainerDehydrator(par1InventoryPlayer,
				par2TileEntityDehydrator));

	}

	protected void drawGuiContainerForegroundLayer()
    {
        fontRenderer.drawString(StatCollector.translateToLocal("container.crafting"), 28, 6, 0x404040);
        fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, (ySize - 96) + 2, 0x404040);
    }
	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2,
			int par3) {
		drawDefaultBackground();
		int i = mc.renderEngine.getTexture("/gui/furnace.png");
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.renderEngine.bindTexture(i);
		int j = (width - xSize) / 2;
		int k = (height - ySize) / 2;
		drawTexturedModalRect(j, k, 0, 0, xSize, ySize);
	}

}
