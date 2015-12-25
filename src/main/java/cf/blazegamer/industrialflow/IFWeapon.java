package cf.blazegamer.industrialflow;

import java.util.Set;

import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;

public abstract class IFWeapon {
	public Item item;
	IItemWeapon weapon;
	final void setItem(IItemWeapon itemw) {
		item = (Item)itemw;
		weapon = itemw;
		onSetItem();
	}
	public IFWeapon() {
		item = null;
		weapon = null;
	}
	protected abstract void onSetItem();
	public abstract void setProperties();
	public abstract float getEntityDamageMaterialPart();
	public abstract float getEntityDamage();
	public abstract float getBlockDamage(ItemStack stack, Block block);
	public abstract boolean canHarvestBlock(Block block);
	public abstract boolean onBlockDestroyed(ItemStack stack, World world, Block block, int j, int k, int l, EntityLivingBase entity);
	public abstract boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker);
	public abstract int getAttackDelay(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker);
	public abstract float getKnockBack(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker);
	public abstract int getEnchantability();
	public abstract void addModifiers(Multimap<String, AttributeModifier> modifMap);
	public abstract EnumAction getAction(ItemStack stack);
	public abstract int getUseDurab(ItemStack stack);
	public abstract boolean onLMB(ItemStack stack, EntityPlayer player, Entity target);
	public abstract ItemStack onRMB(ItemStack stack, World world, EntityPlayer player);
	public abstract void onUsingTick(ItemStack stack, EntityPlayer player, int count);
	public abstract void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int i);
	public abstract void onUpdate(ItemStack stack, World world, Entity entity, int i, boolean flag);
	
	@SideOnly(Side.CLIENT)
	public abstract boolean renderRotator();
}
