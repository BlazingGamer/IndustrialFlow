package cf.blazegamer.industrialflow;

import com.google.common.collect.Multimap;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;

public class IFBattleAxe extends IFMelee {
	public int ignoreArmourAmount;
	public static final int[] ignore = {1,1,1,1,1};
	public IFBattleAxe(ToolMaterial toolmatFunc) {
		super(MeleeSpecs.BATTLEAXE, toolmatFunc);
		if (toolmatFunc.ordinal() < ignore.length) ignoreArmourAmount = ignore[toolmatFunc.ordinal()];
	}

	@Override
	public boolean onLMB(ItemStack stack, EntityPlayer player, Entity target) {
		if (target instanceof EntityLivingBase) {
			EntityLivingBase target2 = (EntityLivingBase)target;
			double X = target.motionX;
			double Y = target.motionY;
			double Z = target.motionZ;
			int resistant = target2.hurtResistantTime;
			int hurt = target2.hurtTime;
			target2.attackEntityFrom(new DamageSourceAxe(), ignoreArmourAmount);
			target.motionX = X;
			target.motionY = Y;
			target.motionZ = Z;
			target2.hurtResistantTime = resistant;
			target2.hurtTime = hurt;			
		}
		return super.onLMB(stack, player, target);
	}
	
	@Override
	public float getBlockDamage(ItemStack itemstack, Block block) {
		if (block.getMaterial() == Material.wood) return (toolmat.getEfficiencyOnProperMaterial() * 0.75F);
		else return super.getBlockDamage(itemstack, block);
	}
	
	@Override
	public boolean canHarvestBlock(Block block) {
		return block.getMaterial() == Material.wood;
	}
	
	@Override
	public void addModifiers(Multimap<String, AttributeModifier> modifMap) {
		super.addModifiers(modifMap);
		modifMap.put(new RangedAttribute("weaponmod.ignoreArmour", 0D, 0D, Double.MAX_VALUE).getAttributeUnlocalizedName(), new AttributeModifier(weapon.getUUID(), "Weapon ignore armour modifier", ignoreArmourAmount, 0));
	}
}
