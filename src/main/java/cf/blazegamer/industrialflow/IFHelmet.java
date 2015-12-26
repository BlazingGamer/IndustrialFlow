package cf.blazegamer.industrialflow;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class IFHelmet extends ItemArmor {
	private String texture;
	
	public IFHelmet(String name, CreativeTabs tab, ArmorMaterial armormat, String layer1) {
		super(armormat, 0, 0);
		this.setCreativeTab(tab);
		this.setTextureName(name);
		this.setUnlocalizedName(name);
		this.texture = layer1;
		this.setMaxStackSize(1);
	}
	
	@Override
	public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type) {
		return texture;
	}
}
