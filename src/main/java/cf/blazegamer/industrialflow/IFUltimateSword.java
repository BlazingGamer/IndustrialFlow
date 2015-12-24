package cf.blazegamer.industrialflow;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.world.World;

public class IFUltimateSword extends IFBroadsword {
	public IFUltimateSword(String name, CreativeTabs tab, ToolMaterial material) {
		super(name, tab, IF_Base.UltimateToolmat);
	}
	
	@Override
	public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		par1ItemStack.addEnchantment(Enchantment.unbreaking, 3);
		par1ItemStack.addEnchantment(Enchantment.sharpness, 5);
		par1ItemStack.addEnchantment(Enchantment.smite, 5);
		par1ItemStack.addEnchantment(Enchantment.baneOfArthropods, 5);
		par1ItemStack.addEnchantment(Enchantment.knockback, 3);
		par1ItemStack.addEnchantment(Enchantment.looting, 3);
		par1ItemStack.addEnchantment(Enchantment.fireAspect, 2);
    }
	
	public IFUltimateSword() {
		this("industrialflow:broadswordUltimate", IF_Base.tabIF, IF_Base.UltimateToolmat);
	}
}
