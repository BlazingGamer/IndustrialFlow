package cf.blazegamer.industrialflow;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class IFGenerator implements IWorldGenerator {
	public Block block;
	public Block genInside;
	public boolean nether;
	public boolean end;
	public boolean overworld;
	public int minY;
	public int maxY;
	public int blocksPerVein;
	public int veinsPerChunk;
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId) {
			case -1: if (this.nether == true) generateNether(world, random, chunkX * 16, chunkZ * 16);break;
			case 0: if (this.overworld == true) generateOverworld(world, random, chunkX * 16, chunkZ * 16);break;
			case 1: if (this.end == true) generateEnd(world, random, chunkX * 16, chunkZ * 16);break;
			//case 61: generateUtopia(world, random, chunkX * 16, chunkZ * 16);
			//case 62: generateDanger(world, random, chunkX * 16, chunkZ * 16);
			//case 63: generateVillageDim(world, random, chunkX * 16, chunkZ * 16);
			//case 64: generateCrystal(world, random, chunkX * 16, chunkZ * 16);
		}
	}
	
	/**
	 * @param block - ÃÅÍÅĞÈĞÓŞÙÈÉÑß ÁËÎÊ
	 * @param inNether - ÍÀËÈ×ÈÅ ÃÅÍÅĞÀÖÈÈ Â ÀÄÓ
	 * @param inWorld - ÍÀËÈ×ÈÅ ÃÅÍÅĞÀÖÈÈ Â ÂÅĞÕÍÅÌ ÌÈĞÅ
	 * @param inEnd - ÍÀËÈ×ÈÅ ÃÅÍÅĞÀÖÈÈ Â ÊĞÀŞ
	 * @param heightMin - ÌÈÍÈÌÀËÜÍÀß ÂÛÑÎÒÀ
	 * @param heightMax - ÌÀÊÑÈÌÀËÜÍÀß ÂÛÑÎÒÀ
	 * @param BlocksPerVein - ÊÎË-ÂÎ ÁËÎÊÎÂ Â ÆÈËÅ
	 * @param VeinsPerChunk - ÊÎË-ÂÎ ÆÈË Â ×ÀÍÊÅ
	 */
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
	
	/**
	 * @param block - ÃÅÍÅĞÈĞÓŞÙÈÉÑß ÁËÎÊ
	 * @param inNether - ÍÀËÈ×ÈÅ ÃÅÍÅĞÀÖÈÈ Â ÀÄÓ
	 * @param inWorld - ÍÀËÈ×ÈÅ ÃÅÍÅĞÀÖÈÈ Â ÂÅĞÕÍÅÌ ÌÈĞÅ
	 * @param inEnd - ÍÀËÈ×ÈÅ ÃÅÍÅĞÀÖÈÈ Â ÊĞÀŞ
	 * @param heightMin - ÌÈÍÈÌÀËÜÍÀß ÂÛÑÎÒÀ
	 * @param heightMax - ÌÀÊÑÈÌÀËÜÍÀß ÂÛÑÎÒÀ
	 * @param BlocksPerVein - ÊÎË-ÂÎ ÁËÎÊÎÂ Â ÆÈËÅ
	 * @param VeinsPerChunk - ÊÎË-ÂÎ ÆÈË Â ×ÀÍÊÅ
	 */
	public IFGenerator(Block block, boolean inNether, boolean inWorld, boolean inEnd, int heightMin, int heightMax, int BlocksPerVein, int VeinsPerChunk, Block genInside) {
		this.block = block;
		this.nether = inNether;
		this.end = inEnd;
		this.overworld = inWorld;
		this.minY = heightMin;
		this.maxY = heightMax;
		this.blocksPerVein = BlocksPerVein;
		this.veinsPerChunk = VeinsPerChunk;
		this.genInside = genInside;
	}
	
	private void generateEnd(World world, Random random, int x, int z) {
		for (int i = 0; i < this.veinsPerChunk; i++) {
			int X = x + random.nextInt(16);
			int Y = this.minY + random.nextInt(this.maxY - this.minY);
			int Z = z + random.nextInt(16);
			(new WorldGenMinable(this.block, 1, this.blocksPerVein, (this.genInside == null ? Blocks.end_stone : this.genInside))).generate(world, random, X, Y, Z);
		}
	}
	
	private void generateNether(World world, Random random, int x, int z) {
		for (int i = 0; i < this.veinsPerChunk; i++) {
			int X = x + random.nextInt(16);
			int Y = this.minY + random.nextInt(this.maxY - this.minY);
			int Z = z + random.nextInt(16);
			(new WorldGenMinable(this.block, 1, this.blocksPerVein, (this.genInside == null ? Blocks.netherrack : this.genInside))).generate(world, random, X, Y, Z);
		}
	}
	
	private void generateOverworld(World world, Random random, int X, int Z) {
		assert maxY < minY : "Ìàêñèìàëüíàÿ Y äîëæíà áûòü áîëüøå ìèíèìàëüíîé";
        assert minY < 0 : "Ìèíèìàëüíàÿ Y äîëæíà áûòü áîëüøå 0";
        assert maxY > 256 && maxY < 0 : "Ìàêñèìàëüíàÿ Y äîëæíà áûòü ìåíüøå 256 è áîëüøå 0";
        for (int i = 0; i < this.veinsPerChunk; i++) {
        	int x = X + random.nextInt(16);
			int y = this.minY + random.nextInt(this.maxY - this.minY);
        	int z = Z + random.nextInt(16);
			(new WorldGenMinable(this.block, this.blocksPerVein, (this.genInside == null ? Blocks.stone : this.genInside))).generate(world, random, x, y, z);
        }
	}
}
