package cf.blazegamer.industrialflow;

import java.util.Random;
import java.util.UUID;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class ItemMelee extends ItemSword implements IItemWeapon {
	public final IFMelee ifmelee;
	public ItemMelee(String id, CreativeTabs tab, IFMelee meleeweap) {
		super((meleeweap.toolmat == null ? ToolMaterial.WOOD : meleeweap.toolmat));
		this.setUnlocalizedName(id);
		this.setTextureName(id);
		this.setCreativeTab(tab);
		ifmelee = meleeweap;
		meleeweap.setItem(this);
		meleeweap.setProperties();
	}
	@Override
	public boolean onLMBEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		return ifmelee.onLMB(stack, player, entity);
	}
	@Override
	public UUID getUUID() {
		return field_111210_e;
	}
	@Override
	public Random getRandom() {
		return itemRand;
	}
	@Override
	public IFMelee getMelee() {
		return ifmelee;
	}
	
	@Override
	public float func_150931_i() {
		return ifmelee.getEntityDamageMaterialPart();
	}
	
	@Override
	public float func_150893_a(ItemStack stack, Block block) {
		return ifmelee.getBlockDamage(stack, block);
	}
	
	@Override
	public boolean func_150897_b(Block block) {
		return ifmelee.canHarvestBlock(block);
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		return ifmelee.hitEntity(stack, target, attacker);
	}
	
	@Override
	public int getItemEnchantability() {
		return ifmelee.getEnchantability();
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int j, int k, int l, EntityLivingBase entity) {
		return ifmelee.onBlockDestroyed(stack, world, block, j, k, l, entity);
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return ifmelee.getAction(stack);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public boolean shouldRotateAroundWhenRendering() {
		return ifmelee.renderRotator();
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return ifmelee.getUseDurab(stack);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		return ifmelee.onRMB(stack, world, player);
	}
	
	@Override
	public void onUsingTick(ItemStack itemstack, EntityPlayer entityplayer, int count) {
		ifmelee.onUsingTick(itemstack, entityplayer, count);
	}
	
	@Override
	public void onPlayerStoppedUsing(ItemStack itemstack, World world, EntityPlayer entityplayer, int i) {
		ifmelee.onPlayerStoppedUsing(itemstack, world, entityplayer, i);
	}
	
	@Override
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean flag) {
		ifmelee.onUpdate(itemstack, world, entity, i, flag);
	}
	
	@Override
	public Multimap<String, AttributeModifier> getItemAttributeModifiers() {
		Multimap<String, AttributeModifier> multimap = HashMultimap.create();
		ifmelee.addModifiers(multimap);
		return multimap;
	}
}
