package cf.blazegamer.industrialflow;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class IFBlock extends Block {
	private ItemStack stackDrop;

	public IFBlock(Material p_i45394_1_) {
		super(p_i45394_1_);
	}
	
	public IFBlock setStackToDrop(ItemStack stack)
	{
		this.stackDrop = stack;
		return this;
	}
	
	@Override
	public Item getItemDropped(int i, Random random, int j)
	{
		if(stackDrop != null)
		{
			return stackDrop.getItem();
		}
		else return Item.getItemFromBlock(this);
	}
}
