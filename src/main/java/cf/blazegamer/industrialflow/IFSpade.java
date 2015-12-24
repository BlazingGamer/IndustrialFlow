package cf.blazegamer.industrialflow;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.Item.ToolMaterial;

public class IFSpade extends ItemSpade {
	public IFSpade(ToolMaterial p_i45347_1_) {
		this("industrialflow:testSpade", CreativeTabs.tabTools, p_i45347_1_);
	}

	public IFSpade(String name, CreativeTabs tab, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(name);
		this.setTextureName(name);
		this.setCreativeTab(tab);
	}
}
