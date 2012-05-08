package net.minecraft.src;

public class EnchantmentArrowFire extends Enchantment
{
    public EnchantmentArrowFire(int par1, int par2)
    {
        super(par1, par2, EnumEnchantmentType.bow);
        this.setName("arrowFire");
    }

    /**
     * Returns the minimal value of enchantability nedded on the enchantment level passed.
     */
    public int getMinEnchantability(int par1)
    {
        return 20;
    }

    /**
     * Returns the maximum value of enchantability nedded on the enchantment level passed.
     */
    public int getMaxEnchantability(int par1)
    {
        return 50;
    }

    /**
     * Returns the maximum level that the enchantment can have.
     */
    public int getMaxLevel()
    {
        return 1;
    }
}
