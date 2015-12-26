package cf.blazegamer.industrialflow;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public class IFPants extends ItemArmor {
	private String texture;
	
	public IFPants(String name, CreativeTabs tab, ArmorMaterial armormat, String layer2) {
		super(armormat, 0, 2);
		this.setCreativeTab(tab);
		this.setTextureName(name);
		this.setUnlocalizedName(name);
		this.texture = layer2;
		this.setMaxStackSize(1);
	}
	
	@Override
	public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type) {
		return texture;
	}
}
