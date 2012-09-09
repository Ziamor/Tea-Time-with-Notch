package net.minecraft.src;

import net.minecraft.src.forge.*;

public class Mint extends BlockFlower implements ITextureProvider {

	protected Mint(int par1, int par2, Material par3Material) {
		super(par1, par2, par3Material);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTextureFile() {
		// TODO Auto-generated method stub
		return "/TeaMod/terrain.png";
	}
}
