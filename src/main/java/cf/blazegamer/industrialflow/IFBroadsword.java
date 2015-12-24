package cf.blazegamer.industrialflow;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;

public class IFBroadsword extends ItemSword {
	public IFBroadsword(ToolMaterial p_i45347_1_) {
		this("industrialflow:testBroadsword", CreativeTabs.tabTools, p_i45347_1_);
	}

	public IFBroadsword(String name, CreativeTabs tab, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(name);
		this.setTextureName(name);
		this.setCreativeTab(tab);
	}
}
