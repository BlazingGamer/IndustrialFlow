package cf.blazegamer.industrialflow;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class AirGenerator implements IWorldGenerator {
	public static Block block;
	public static int blocksPerVein, veinsPerChunk;
	public static int maxY, minY;
	
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		for (int i = 0; i < this.veinsPerChunk; i++) {
			int X = chunkX * 16 + random.nextInt(16);
			int Y = this.minY + random.nextInt(this.maxY - this.minY);
			int Z = chunkZ * 16 + random.nextInt(16);
			(new WorldGenMinable(this.block, 1, this.blocksPerVein, Blocks.gravel)).generate(world, random, X, Y, Z);
		}
	}
	/**
	 * 
	 * @param blockToGen - ÃÅÍÅÐÈÐÓÞÙÈÉÑß ÁËÎÊ
	 * @param blocksPerVein - ÊÎË-ÂÎ ÁËÎÊÎÂ Â ÆÈËÅ
	 * @param veinsPerChunk - ÊÎË-ÂÎ ÆÈË Â ×ÀÍÊÅ
	 * @param maxY - ÌÀÊÑÈÌÀËÜÍÀß ÂÛÑÎÒÀ
	 * @param minY - ÌÈÍÈÌÀËÜÍÀß ÂÛÑÎÒÀ
	 */
	public AirGenerator(Block blockToGen, int blocksPerVein, int veinsPerChunk, int maxY, int minY) {
		this.block = blockToGen;
		this.blocksPerVein = blocksPerVein;
		this.veinsPerChunk = veinsPerChunk;
		this.maxY = maxY;
		this.minY = minY;
	}
}
