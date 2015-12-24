package cf.blazegamer.industrialflow;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class IFOre extends IFBlock {

	private ItemStack drop;
	private int number = 1;

	public IFOre(Material p_i45394_1_) {
		super(p_i45394_1_);
		this.setBlockName("industrialflow:oreNaO");
		this.setBlockTextureName("industrialflow:oreNaO");
		this.setCreativeTab(IF_Base.tabIF);
		this.setHardness(1.0F);
		this.setResistance(7.0F);
		this.setHarvestLevel("pickaxe", 0);
	}
	
	public IFOre(String name, CreativeTabs tab, float hardness, String tooltype, int level) {
		super(Material.rock);
		this.setBlockName(name);
		this.setBlockTextureName(name);
		this.setCreativeTab(tab);
		this.setHardness(hardness);
		this.setResistance(7.0F);
		if ((tooltype != "") && (level != 0)) this.setHarvestLevel(tooltype, level);
	}
	
	public IFOre(String name, CreativeTabs tab, float hardness, String tooltype, int level, Material mat) {
		super(mat);
		this.setBlockName(name);
		this.setBlockTextureName(name);
		this.setCreativeTab(tab);
		this.setHardness(hardness);
		this.setResistance(7.0F);
		if ((tooltype != "") && (level != 0)) this.setHarvestLevel(tooltype, level);
	}
	
	public IFOre(String name, CreativeTabs tab, float hardness, String tooltype, int level, Item drop) {
		super(Material.rock);
		this.setBlockName(name);
		this.setBlockTextureName(name);
		this.setCreativeTab(tab);
		this.setHardness(hardness);
		this.setResistance(7.0F);
		if ((tooltype != "") && (level != 0)) this.setHarvestLevel(tooltype, level);
		this.drop = new ItemStack(drop);
	}
	
	public IFOre(String name, CreativeTabs tab, float hardness, String tooltype, int level, Item drop, int number) {
		super(Material.rock);
		this.setBlockName(name);
		this.setBlockTextureName(name);
		this.setCreativeTab(tab);
		this.setHardness(hardness);
		this.setResistance(7.0F);
		if ((tooltype != "") && (level != 0)) this.setHarvestLevel(tooltype, level);
		this.drop = new ItemStack(drop);
		this.number = number;
	}
	
	public IFOre(String name, CreativeTabs tab, float hardness, String tooltype, int level, Item drop, Material mat) {
		super(mat);
		this.setBlockName(name);
		this.setBlockTextureName(name);
		this.setCreativeTab(tab);
		this.setHardness(hardness);
		this.setResistance(7.0F);
		if ((tooltype != "") && (level != 0)) this.setHarvestLevel(tooltype, level);
		this.drop = new ItemStack(drop);
	}
	
	public IFOre(String name, CreativeTabs tab, float hardness, String tooltype, int level, Item drop, int number, Material mat) {
		super(mat);
		this.setBlockName(name);
		this.setBlockTextureName(name);
		this.setCreativeTab(tab);
		this.setHardness(hardness);
		this.setResistance(7.0F);
		if ((tooltype != "") && (level != 0)) this.setHarvestLevel(tooltype, level);
		this.drop = new ItemStack(drop);
		this.number = number;
	}

	@Override
	public Item getItemDropped(int i, Random random, int j) {
		if(drop != null) {
			return drop.getItem();
		}
		else return Item.getItemFromBlock(this);
	}
	
	@Override
    public int quantityDropped(Random par1Random) {
		if (number > 1) {
        	return number;
        }
        else return 1;
    }
	
	public int quantityDroppedWithBonus(int par1, Random par2Random) {
        if (par1 > 0 && Item.getItemFromBlock(this) != this.getItemDropped(0, par2Random, par1)) {
            int var3 = par2Random.nextInt(par1 + 2) - 1;
            if (var3 < 0) {
                var3 = 0;
            }
            return this.quantityDropped(par2Random) * (var3 + 1);
        }
        else {
            return this.quantityDropped(par2Random);
        }
    }
	
	@Override
    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7) {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);
        if (this.getItemDropped(par5, par1World.rand, par7) != Item.getItemFromBlock(this)) {
        	int var8 = MathHelper.getRandomIntegerInRange(par1World.rand, 16, 33);
            this.dropXpOnBlockBreak(par1World, par2, par3, par4, var8);
        }
    }
}
