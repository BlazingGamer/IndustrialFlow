package cf.blazegamer.industrialflow;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public abstract class PhysHelper {
	private static double kbMotionX = 0D;
	private static double kbMotionY = 0D;
	private static double kbMotionZ = 0D;
	private static int knockBackModifier = 0;

	
	public static void knockBack(EntityLivingBase entityliving, EntityLivingBase attacker, float knockback) {
		entityliving.motionX = kbMotionX;
		entityliving.motionY = kbMotionY;
		entityliving.motionZ = kbMotionZ;
		double dx = attacker.posX - entityliving.posX;
		double dz;
		for (dz = attacker.posZ - entityliving.posZ; dx * dx + dz * dz < 1E-4D; dz = (Math.random() - Math.random()) * 0.01D) dx = (Math.random() - Math.random()) * 0.01D;
		entityliving.attackedAtYaw = (float) ((Math.atan2(dz, dx) * 180D) / Math.PI) - entityliving.rotationYaw;
		float f = MathHelper.sqrt_double(dx * dx + dz * dz);
		entityliving.motionX -= (dx / f) * knockback;
		entityliving.motionY += knockback;
		entityliving.motionZ -= (dz / f) * knockback;
		if (entityliving.motionY > 0.4D) entityliving.motionY = 0.4D;
		if (knockBackModifier > 0) {
			dx = -Math.sin(Math.toRadians(attacker.rotationYaw)) * knockBackModifier * 0.5F;
			dz = Math.cos(Math.toRadians(attacker.rotationYaw)) * knockBackModifier * 0.5F;
			entityliving.addVelocity(dx, 0.1D, dz);
		}
		knockBackModifier = 0;
		kbMotionX = kbMotionY = kbMotionZ = 0D;
	}
	
	public static void prepareKnockbackOnEntity(EntityLivingBase attacker, EntityLivingBase entity)
	{
		knockBackModifier = EnchantmentHelper.getKnockbackModifier(attacker, entity);
		if (attacker.isSprinting())
		{
			knockBackModifier++;
		}
		kbMotionX = entity.motionX;
		kbMotionY = entity.motionY;
		kbMotionZ = entity.motionZ;
	}
}
