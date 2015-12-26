package cf.blazegamer.industrialflow;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class IFUltimateBoots extends IFBoots {
	public IFUltimateBoots() {
		super("industrialflow:bootsUltimate", IF_Base.tabIF, IF_Base.UltimateArmormat, "industrialflow:textures/armourmodels/ultimate_l1.png");
	}
	
	@Override
	public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		super.onCreated(par1ItemStack, par2World, par3EntityPlayer);
		par1ItemStack.addEnchantment(Enchantment.unbreaking, 3);
		par1ItemStack.addEnchantment(Enchantment.protection, 5);
		par1ItemStack.addEnchantment(Enchantment.fireProtection, 5);
		par1ItemStack.addEnchantment(Enchantment.blastProtection, 5);
		par1ItemStack.addEnchantment(Enchantment.projectileProtection, 5);
		par1ItemStack.addEnchantment(Enchantment.thorns, 3);
		par1ItemStack.addEnchantment(Enchantment.featherFalling, 4);
    }
}
