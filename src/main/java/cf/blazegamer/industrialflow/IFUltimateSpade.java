package cf.blazegamer.industrialflow;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.world.World;

public class IFUltimateSpade extends IFSpade {
	public IFUltimateSpade(String name, CreativeTabs tab, ToolMaterial material) {
		super(name, tab, IF_Base.UltimateToolmat);
	}
	
	@Override
	public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		super.onCreated(par1ItemStack, par2World, par3EntityPlayer);
		par1ItemStack.addEnchantment(Enchantment.unbreaking, 3);
		par1ItemStack.addEnchantment(Enchantment.efficiency, 5);
    }
	
	public IFUltimateSpade() {
		this("industrialflow:spadeUltimate", IF_Base.tabIF, IF_Base.UltimateToolmat);
	}
}
