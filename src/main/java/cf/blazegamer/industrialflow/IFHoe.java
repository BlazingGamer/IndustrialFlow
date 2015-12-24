package cf.blazegamer.industrialflow;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.Item.ToolMaterial;

public class IFHoe extends ItemHoe {
	public IFHoe(ToolMaterial p_i45347_1_) {
		this("industrialflow:testHoe", CreativeTabs.tabTools, p_i45347_1_);
	}

	public IFHoe(String name, CreativeTabs tab, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(name);
		this.setTextureName(name);
		this.setCreativeTab(tab);
	}
}
