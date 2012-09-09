package net.minecraft.src;

import net.minecraft.src.*;
 import net.minecraft.src.forge.*;
public class mod_Tea extends BaseMod {
	/**
     *Block.java 
     */
	public static final Block strBerryBush = new StrBerryBush(204, 16,Material.plants).setHardness(0.0F).setResistance(5F).setStepSound(Block.soundGrassFootstep).setBlockName("strawberry bush");
    public static final Block camellia = new Camellia(205, 17,Material.plants).setHardness(0.0F).setResistance(5F).setStepSound(Block.soundGrassFootstep).setBlockName("camellia sinensis");
    public static final Block mint = new Mint(206, 18,Material.plants).setHardness(0.0F).setResistance(5F).setStepSound(Block.soundGrassFootstep).setBlockName("mint");
    public static final Block chamomilla = new Chamomilla(207, 19,Material.plants).setHardness(0.0F).setResistance(5F).setStepSound(Block.soundGrassFootstep).setBlockName("mint");
	public static final Block dehydrator = new BlockDehydrator(180, 1).setHardness(2.0F).setResistance(5.0F).setBlockName("dehydrator"); 
	public static final TileEntityDehydrator tileentitydehydrator = new TileEntityDehydrator();
	public mod_Tea() {
		
	}

	@Override
	public void load() {
		/**
		 *Load textures 
		 */
		MinecraftForgeClient.preloadTexture("/TeaMod/terrain.png");
		
		/**
		 * Block register
		 */
		ModLoader.registerBlock(dehydrator);
		ModLoader.registerBlock(strBerryBush);
		ModLoader.registerBlock(camellia);
		ModLoader.registerBlock(mint);
		ModLoader.registerBlock(chamomilla);
		
		/**
		 * Tile Entity register
		 */
		ModLoader.registerTileEntity(tileentitydehydrator.getClass(), "dehydrator");
		
		/**
		 * Names
		 */
		ModLoader.addName(dehydrator, "Dehydrator");
		ModLoader.addName(strBerryBush, "Straw Berry Bush");
		ModLoader.addName(camellia, "Camellia Sinensis");
		ModLoader.addName(mint, "Mint");
		ModLoader.addName(chamomilla, "Matricaria Chamomilla");
		
		/**
		 * Crafting
		 */
		ModLoader.addRecipe(new ItemStack(dehydrator, 1), new Object[] { "#$#", "#$#", "$%$",
				'#', Block.glass, '$', Item.ingotIron, '%', Item.redstone  });
		ModLoader.addRecipe(new ItemStack(camellia, 1), new Object[] { "#", "#",
			'#', Block.dirt  });
		ModLoader.addRecipe(new ItemStack(strBerryBush, 1), new Object[] { "#",
			'#', Block.dirt  });
		ModLoader.addRecipe(new ItemStack(mint, 1), new Object[] { "##", "#",
			'#', Block.dirt  });
		ModLoader.addRecipe(new ItemStack(chamomilla, 1), new Object[] { "###", "#",
			'#', Block.dirt  });
	}
	
	@Override
	public String getVersion() {
		return "1.2.5";
	}
}
