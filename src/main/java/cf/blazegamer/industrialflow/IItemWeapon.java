package cf.blazegamer.industrialflow;

import java.util.Random;
import java.util.UUID;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public interface IItemWeapon {
	public boolean onLMBEntity(ItemStack stack, EntityPlayer player, Entity entity);
	public UUID getUUID();
	public Random getRandom();
	public IFMelee getMelee();
}
