package cf.blazegamer.industrialflow;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class IFUltimateBattleAxe extends ItemMelee {
	public IFUltimateBattleAxe(String id, CreativeTabs tab, IFMelee meleeweap) {
		super(id, tab, new IFBattleAxe(IF_Base.UltimateToolmat));
	}

	@Override
	public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		super.onCreated(par1ItemStack, par2World, par3EntityPlayer);
		par1ItemStack.addEnchantment(Enchantment.unbreaking, 3);
		par1ItemStack.addEnchantment(Enchantment.sharpness, 4);
		par1ItemStack.addEnchantment(Enchantment.smite, 3);
		par1ItemStack.addEnchantment(Enchantment.baneOfArthropods, 3);
		par1ItemStack.addEnchantment(Enchantment.knockback, 2);
		par1ItemStack.addEnchantment(Enchantment.looting, 2);
		par1ItemStack.addEnchantment(Enchantment.efficiency, 5);
    }
	
	public IFUltimateBattleAxe() {
		this("industrialflow:battleaxeUltimate", IF_Base.tabIF, new IFBattleAxe(IF_Base.UltimateToolmat));
	}
}
