package net.minecraft.src;

class PlayerUsageSnooperThread extends Thread
{
    final PlayerUsageSnooper field_52012_a;

    PlayerUsageSnooperThread(PlayerUsageSnooper par1PlayerUsageSnooper, String par2Str)
    {
        super(par2Str);
        this.field_52012_a = par1PlayerUsageSnooper;
    }

    public void run()
    {
        PostHttp.sendPost(PlayerUsageSnooper.getServerURL(this.field_52012_a), PlayerUsageSnooper.getDataMap(this.field_52012_a), true);
    }
}
