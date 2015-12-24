package cf.blazegamer.industrialflow;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class IFCreativeTab extends CreativeTabs {
	Item icon;
	public IFCreativeTab(String lable, Item icon) {
		super(lable);
		this.icon = icon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		if (icon != null) return icon;
		else return IF_Base.gemTopaz;
	}

}
