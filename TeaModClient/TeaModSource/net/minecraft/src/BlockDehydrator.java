package net.minecraft.src;


import java.nio.file.WatchEvent.Modifier;

import net.minecraft.src.forge.*;

public class BlockDehydrator extends BlockContainer implements ITextureProvider {

	protected BlockDehydrator(int i, int j) {
		super(i, j, Material.rock);
	}

	public String getTextureFile() {
		return "/TeaMod/terrain.png";
	}

	/**
     * Returns the block texture based on the side being looked at.  Args: side
     * 
     * 0 = bottom, 1 = top, 2 = back, 3 = front, 4 = left, 5 = right
     */
    public int getBlockTextureFromSide(int par1)
    {
        if (par1 == 1)	
        {
            return blockIndexInTexture + 2;
        }

        if (par1 == 0)	
        {
            return blockIndexInTexture + 3;
        }

        if (par1 == 2 || par1 == 4 || par1 == 5)
        {
            return blockIndexInTexture + 1;
        }        

        else
        {
            return blockIndexInTexture;
        }
    }
    
    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        super.onBlockAdded(par1World, par2, par3, par4);
        setDefaultDirection(par1World, par2, par3, par4);
    }
    
    /**
     * set a blocks direction
     */
    private void setDefaultDirection(World par1World, int par2, int par3, int par4)
    {
        if (par1World.isRemote)
        {
            return;
        }

        int i = par1World.getBlockId(par2, par3, par4 - 1);
        int j = par1World.getBlockId(par2, par3, par4 + 1);
        int k = par1World.getBlockId(par2 - 1, par3, par4);
        int l = par1World.getBlockId(par2 + 1, par3, par4);
        byte byte0 = 3;

        if (Block.opaqueCubeLookup[i] && !Block.opaqueCubeLookup[j])
        {
            byte0 = 3;
        }

        if (Block.opaqueCubeLookup[j] && !Block.opaqueCubeLookup[i])
        {
            byte0 = 2;
        }

        if (Block.opaqueCubeLookup[k] && !Block.opaqueCubeLookup[l])
        {
            byte0 = 5;
        }

        if (Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[k])
        {
            byte0 = 4;
        }

        par1World.setBlockMetadataWithNotify(par2, par3, par4, byte0);
    }
    /**
     * Returns the TileEntity used by this block.
     */
    public TileEntity getBlockEntity()
    {
        return new TileEntityDehydrator();
    }
    
    /**
     * Called upon block activation (left or right click on the block.). The three integers represent x,y,z of the
     * block.
     */
    public boolean blockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer)
    {
    	 if (par1World.isRemote)
         {
             return true;
         }

    	 TileEntityDehydrator tileentitydehydrator = (TileEntityDehydrator)par1World.getBlockTileEntity(par2, par3, par4);

         if (tileentitydehydrator != null)
         {
        	 ModLoader.openGUI(par5EntityPlayer,new GuiDehydrator(par5EntityPlayer.inventory,tileentitydehydrator));
         }


         return true;
    }    
    
    /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving)
    {
        int i = MathHelper.floor_double((double)((par5EntityLiving.rotationYaw * 4F) / 360F) + 0.5D) & 3;

        if (i == 0)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2);
        }

        if (i == 1)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 5);
        }

        if (i == 2)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3);
        }

        if (i == 3)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 4);
        }
	}
}
