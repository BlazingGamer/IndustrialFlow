package cf.blazegamer.industrialflow;

import com.google.common.collect.Multimap;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class IFMelee extends IFWeapon {
	public final MeleeSpecs specs;
	public final Item.ToolMaterial toolmat;
	
	public IFMelee(MeleeSpecs specsFunc, Item.ToolMaterial toolmatFunc) {
		specs = specsFunc;
		toolmat = toolmatFunc;
	}
	
	@Override
	protected void onSetItem() {}

	@Override
	public void setProperties() {
		if (toolmat == null) item.setMaxDamage(specs.durabilityBase);
		else item.setMaxDamage((int) (specs.durabilityBase + specs.durabilityMultiplier * toolmat.getMaxUses()));
		item.setMaxStackSize(specs.stackSize);
	}

	@Override
	public float getEntityDamageMaterialPart() {
		if (toolmat == null) return 0F;
		else return toolmat.getDamageVsEntity() * specs.damageMultiplier;
	}

	@Override
	public float getEntityDamage() {
		return getEntityDamageMaterialPart() + specs.damageBase;
	}

	@Override
	public float getBlockDamage(ItemStack stack, Block block) {
		if (canHarvestBlock(block)) return specs.damageBlock * 10F;
		else {
			Material material = block.getMaterial();
			return material != Material.plants && material != Material.vine && material != Material.coral && material != Material.leaves && material != Material.gourd ? 1.0F : specs.damageBlock;
		}
	}

	@Override
	public boolean canHarvestBlock(Block block) {
		return block == Blocks.web;
	}

	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int j, int k, int l, EntityLivingBase entity) {
		if ((specs.damageBlock > 1F || canHarvestBlock(block)) && block.getBlockHardness(world, j, k, l) != 0F) stack.damageItem(specs.damageFBlock, entity);
		return true;
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		if (target.hurtResistantTime == target.maxHurtResistantTime) {
			float knockback = getKnockBack(stack, target, attacker);
			PhysHelper.knockBack(target, attacker, knockback);
			target.hurtResistantTime += getAttackDelay(stack, target, attacker);
		}
		stack.damageItem(specs.damageFEntity, attacker);
		return true;
	}

	@Override
	public int getAttackDelay(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		return specs.delay;
	}

	@Override
	public float getKnockBack(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		return specs.getKnockBack(toolmat);
	}

	@Override
	public int getEnchantability() {
		if (toolmat == null) return 1;
		else return toolmat.getEnchantability();
	}

	@Override
	public void addModifiers(Multimap<String, AttributeModifier> modifMap) {
		float damage = getEntityDamage();
		if (damage > 0F || specs.damageMultiplier > 0F) modifMap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(weapon.getUUID(), "Weapon modifier", damage, 0));
		modifMap.put(new RangedAttribute("industrialflow:knockback", 0.4D, 0D, Double.MAX_VALUE).getAttributeUnlocalizedName(), new AttributeModifier(weapon.getUUID(), "Weapon knockback modifier", specs.getKnockBack(toolmat) - 0.4F, 0));
		modifMap.put(new RangedAttribute("industrialflow:attackSpeed", 0D, -Double.MAX_VALUE, Double.MAX_VALUE).getAttributeUnlocalizedName(), new AttributeModifier(weapon.getUUID(), "Weapon attack speed modifier", -specs.delay, 0));
		if (this instanceof IExtendedReachItem) {
			try {
				modifMap.put(new RangedAttribute("weaponmod.reach", 0D, 0D, Double.MAX_VALUE).getAttributeUnlocalizedName(), new AttributeModifier(weapon.getUUID(), "Weapon reach modifier", ((IExtendedReachItem) this).getExtendedReach(null, null, null) - 3F, 0));
			} catch(NullPointerException e) {}
		}
	}

	@Override
	public EnumAction getAction(ItemStack stack) {
		return EnumAction.block;
	}

	@Override
	public int getUseDurab(ItemStack stack) {
		return 72000;
	}

	@Override
	public boolean onLMB(ItemStack stack, EntityPlayer player, Entity target) {
		if (target instanceof EntityLivingBase) PhysHelper.prepareKnockbackOnEntity(player, (EntityLivingBase) target);
		return false;
	}

	@Override
	public ItemStack onRMB(ItemStack stack, World world, EntityPlayer player) {
		player.setItemInUse(stack, getUseDurab(stack));
		return stack;
	}

	@Override
	public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {
		
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int i) {
		
	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int i, boolean flag) {
	}

	@Override
	public boolean renderRotator() {
		return false;
	}
	
	/**
	 * 
	 * Base Durability - int
	 * Durability Multiplier - float
	 * Base Damage - int
	 * Damage Multiplier - float
	 * Block Damage - float
	 * KnockBack - float
	 * Damage From Entity - int
	 * Damage From Block - int
	 * Stack Size - int
	 * Delay - int
	 *
	 */
	public static enum MeleeSpecs {
		SPEAR(0, 1F, 3, 1F, 1F, 0.2F, 1, 2, 1, 0),
		HALBERD(0, 1F, 4, 1F, 1.5F, 0.6F, 1, 1, 1, 8),
		BATTLEAXE(0, 1F, 3, 1F, 1.5F, 0.5F, 1, 1, 1, 5),
		WARHAMMER(0, 1F, 4, 1F, 1F, 0.7F, 1, 1, 1, 5),
		KNIFE(0, 0.5F, 3, 1F, 1.5F, 0.2F, 1, 2, 1, 0),
		KATANA(0, 1F, 1, 1F, 1F, 0F, 1, 2, 1, -6),
		FIREROD(1, 0F, 1, 0F, 1F, 0.4F, 2, 0, 24, 0),
		BOOMERANG(0, 0.5F, 2, 1F, 1F, 0.4F, 1, 1, 1, 0),
		NONE(0, 0F, 1, 0F, 1F, 0.4F, 0, 0, 1, 0);
		
		public final int durabilityBase, damageFEntity, damageFBlock, stackSize, delay;
		public final float durabilityMultiplier, damageMultiplier, damageBlock, knockback, damageBase;
		
		private MeleeSpecs(int durbase, float durmult, float dmgbase, float dmgmult, float blockdmg, float knockback, int dmgfromentity, int dmgfromblock, int stacksize, int attackdelay) {
			durabilityBase = durbase;
			durabilityMultiplier = durmult;
			damageBase = dmgbase;
			damageMultiplier = dmgmult;
			damageBlock = blockdmg;
			this.knockback = knockback;
			damageFEntity = dmgfromentity;
			damageFBlock = dmgfromblock;
			stackSize = stacksize;
			delay = attackdelay;
		}
		
		public float getKnockBack(Item.ToolMaterial material) {
			if ((material == IF_Base.NickelToolmat) || (material == IF_Base.CobaltToolmat)) return knockback * 1.5F;
			else return knockback;
		}
	}
}

interface IExtendedReachItem {
	public float getExtendedReach(World world, EntityLivingBase living, ItemStack itemstack);
}
