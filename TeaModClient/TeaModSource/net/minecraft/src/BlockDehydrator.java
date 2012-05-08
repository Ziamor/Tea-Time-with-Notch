package net.minecraft.src;

import net.minecraft.src.*;
import net.minecraft.src.forge.*;

public class BlockDehydrator extends Block implements ITextureProvider {

	protected BlockDehydrator(int i, int j) {
		super(i, j, Material.rock);
	}

	public String getTextureFile() {
		return "/TeaMod/terrain.png";
	}

	/**
	 * Returns the block texture based on the side being looked at. Args: side
	 * 
	 * 0 = bottom, 1 = top, 2 = back, 3 = front, 4 = left, 5 = right
	 */
	public int getBlockTextureFromSide(int par1) {
		if (par1 == 1) {
			return blockIndexInTexture + 2;
		}

		if (par1 == 0) {
			return blockIndexInTexture + 3;
		}

		if (par1 == 2 || par1 == 4 || par1 == 5) {
			return blockIndexInTexture + 1;
		}

		else {
			return blockIndexInTexture;
		}
	}
}
