package cf.blazegamer.industrialflow;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.Item.ToolMaterial;

public class IFAxe extends ItemAxe {

	public IFAxe(ToolMaterial p_i45347_1_) {
		this("industrialflow:testAxe", CreativeTabs.tabTools, p_i45347_1_);
	}

	public IFAxe(String name, CreativeTabs tab, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(name);
		this.setTextureName(name);
		this.setCreativeTab(tab);
	}
}
