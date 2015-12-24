package cf.blazegamer.industrialflow;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemPickaxe;

public class IFPickaxe extends ItemPickaxe {

	public IFPickaxe(ToolMaterial p_i45347_1_) {
		this("industrialflow:testPickaxe", CreativeTabs.tabTools, p_i45347_1_);
	}

	public IFPickaxe(String name, CreativeTabs tab, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(name);
		this.setTextureName(name);
		this.setCreativeTab(tab);
	}

}
