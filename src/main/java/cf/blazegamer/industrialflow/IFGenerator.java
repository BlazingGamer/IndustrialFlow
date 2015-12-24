package cf.blazegamer.industrialflow;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class IFGenerator implements IWorldGenerator {
	public static Block block;
	public static boolean nether;
	public static boolean end;
	public static boolean overworld;
	public static int minY;
	public static int maxY;
	public static int blocksPerVein;
	public static int veinsPerChunk;
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId) {
			case -1: if (this.nether == true) generateNether(world, random, chunkX * 16, chunkZ * 16);
			case 0: if (this.overworld == true) generateOverworld(world, random, chunkX * 16, chunkZ * 16);
			case 1: if (this.end == true) generateEnd(world, random, chunkX * 16, chunkZ * 16);
			//case 61: generateUtopia(world, random, chunkX * 16, chunkZ * 16);
			//case 62: generateDanger(world, random, chunkX * 16, chunkZ * 16);
			//case 63: generateVillageDim(world, random, chunkX * 16, chunkZ * 16);
			//case 64: generateCrystal(world, random, chunkX * 16, chunkZ * 16);
		}
	}
	
	public IFGenerator(Block block, boolean inNether, boolean inWorld, boolean inEnd, int heightMin, int heightMax, int BlocksPerVein, int VeinsPerChunk) {
		this.block = block;
		this.nether = inNether;
		this.end = inEnd;
		this.overworld = inWorld;
		this.minY = heightMin;
		this.maxY = heightMax;
		this.blocksPerVein = BlocksPerVein;
		this.veinsPerChunk = VeinsPerChunk;
	}
	
	private void generateEnd(World world, Random random, int x, int z) {
		for (int i = 0; i < this.veinsPerChunk; i++) {
			int X = x + random.nextInt(16);
			int Y = this.minY + random.nextInt(this.maxY - this.minY);
			int Z = z + random.nextInt(16);
			(new WorldGenMinable(this.block, 1, this.blocksPerVein, Blocks.end_stone)).generate(world, random, X, Y, Z);
		}
	}
	
	private void generateNether(World world, Random random, int x, int z) {
		for (int i = 0; i < this.veinsPerChunk; i++) {
			int X = x + random.nextInt(16);
			int Y = this.minY + random.nextInt(this.maxY - this.minY);
			int Z = z + random.nextInt(16);
			(new WorldGenMinable(this.block, 1, this.blocksPerVein, Blocks.netherrack)).generate(world, random, X, Y, Z);
		}
	}
	
	private void generateOverworld(World world, Random random, int X, int Z) {
		assert maxY > minY : "Max Y is lower than Min Y!";
        assert minY > 0 : "Too low Min Y!";
        assert maxY < 256 && maxY > 0 : "Incorrect Max Y!";
        for (int i = 0; i < this.veinsPerChunk; i++) {
        	int x = X + random.nextInt(16);
			int Y = this.minY + random.nextInt(this.maxY - this.minY);
        	int z = Z + random.nextInt(16);
			(new WorldGenMinable(this.block, this.blocksPerVein, Blocks.stone)).generate(world, random, X, Y, Z);
        }
	}
}
