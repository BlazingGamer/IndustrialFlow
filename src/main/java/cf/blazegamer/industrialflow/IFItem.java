package cf.blazegamer.industrialflow;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class IFItem extends Item {

	public IFItem(String string, CreativeTabs tab) {
		super();
		this.setUnlocalizedName(string);
		this.setTextureName(string);
		this.setCreativeTab(tab);
	}

}
