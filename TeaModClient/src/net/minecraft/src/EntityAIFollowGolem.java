package net.minecraft.src;

import java.util.Iterator;
import java.util.List;

public class EntityAIFollowGolem extends EntityAIBase
{
    private EntityVillager theVillager;
    private EntityIronGolem theGolem;
    private int field_48402_c;
    private boolean field_48400_d = false;

    public EntityAIFollowGolem(EntityVillager par1EntityVillager)
    {
        this.theVillager = par1EntityVillager;
        this.setMutexBits(3);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (this.theVillager.getGrowingAge() >= 0)
        {
            return false;
        }
        else if (!this.theVillager.worldObj.isDaytime())
        {
            return false;
        }
        else
        {
            List var1 = this.theVillager.worldObj.getEntitiesWithinAABB(EntityIronGolem.class, this.theVillager.boundingBox.expand(6.0D, 2.0D, 6.0D));

            if (var1.size() == 0)
            {
                return false;
            }
            else
            {
                Iterator var2 = var1.iterator();

                while (var2.hasNext())
                {
                    Entity var3 = (Entity)var2.next();
                    EntityIronGolem var4 = (EntityIronGolem)var3;

                    if (var4.func_48117_D_() > 0)
                    {
                        this.theGolem = var4;
                        break;
                    }
                }

                return this.theGolem != null;
            }
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
        return this.theGolem.func_48117_D_() > 0;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.field_48402_c = this.theVillager.getRNG().nextInt(320);
        this.field_48400_d = false;
        this.theGolem.getNavigator().clearPathEntity();
    }

    /**
     * Resets the task
     */
    public void resetTask()
    {
        this.theGolem = null;
        this.theVillager.getNavigator().clearPathEntity();
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
        this.theVillager.getLookHelper().setLookPositionWithEntity(this.theGolem, 30.0F, 30.0F);

        if (this.theGolem.func_48117_D_() == this.field_48402_c)
        {
            this.theVillager.getNavigator().func_48667_a(this.theGolem, 0.15F);
            this.field_48400_d = true;
        }

        if (this.field_48400_d && this.theVillager.getDistanceSqToEntity(this.theGolem) < 4.0D)
        {
            this.theGolem.func_48116_a(false);
            this.theVillager.getNavigator().clearPathEntity();
        }
    }
}
