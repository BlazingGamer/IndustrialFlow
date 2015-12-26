package cf.blazegamer.industrialflow;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable;

@Mod(modid = "industrialflow", version = "0.1", name = "IndustrialFlow")
public class IF_Base {
	public static Block oreCopper, oreTin, oreLead, oreZinc, oreCobalt, oreNickel, oreTopaz, oreCadmium;
	public static Block oreSilver, orePlatinum, oreGermanium, oreGallium, oreTungsten, oreUranium, oreTitanium;
	public static Block oreRenium, orePalladium, oreRuthenium, oreRadium, oreThorium, oreVanadium, oreVanadiumDense;
	
	public static Item gemTopaz, dustGallium, dustGermanium, ingotZinc, ingotCopper, ingotTin;
	public static Item ingotLead, ingotSilver, ingotCobalt, ingotNickel, ingotCadmium, ingotVanadium;
	public static Item ingotPlatinum, ingotUranium, ingotTungsten, ingotTitanium, ingotPalladium, ingotRenium;
	public static Item ingotRuthenium, ingotRadium, ingotThorium, ingotBronze, ingotWSteel, rodFire, rodFlint;
	public static Item rodWooden, rodCadmium, nuggetPalladium, nuggetRuthenium, forgeHammer;
	public static Item plateCadmium, plateTungsten, plateRuthenium, platePalladium, plateVanadium;
	
	public static ItemAxe axeFlint, axeCopper, axeBronze, axeCobalt, axeNickel;
	public static ItemAxe axeTopaz, axeWSteel, axeTitanium, axeUltimate;
	public static ItemPickaxe pickFlint, pickCopper, pickBronze, pickCobalt, pickNickel;
	public static ItemPickaxe pickTopaz, pickWSteel, pickTitanium, pickUltimate;
	public static ItemSword broadswordFlint, broadswordCopper, broadswordBronze;
	public static ItemSword broadswordCobalt, broadswordNickel, broadswordTopaz;
	public static ItemSword broadswordWSteel, broadswordTitanium, broadswordUltimate;
	public static ItemSpade spadeFlint, spadeCopper, spadeBronze, spadeCobalt, spadeNickel;
	public static ItemSpade spadeTopaz, spadeWSteel, spadeTitanium, spadeUltimate;
	public static ItemHoe hoeFlint, hoeCopper, hoeBronze, hoeCobalt, hoeNickel;
	public static ItemHoe hoeTopaz, hoeWSteel, hoeTitanium, hoeUltimate;
	public static ItemMelee battleaxeFlint, battleaxeCopper, battleaxeBronze;
	public static ItemMelee battleaxeCobalt, battleaxeNickel, battleaxeTopaz;
	public static ItemMelee battleaxeWSteel, battleaxeTitanium, battleaxeUltimate;
	
	public static ItemArmor helmetTin, helmetBronze, helmetTitanium, helmetUltimate, helmetTopaz;
	public static ItemArmor chestplateTin, chestplateBronze, chestplateTitanium, chestplateUltimate, chestplateTopaz;
	public static ItemArmor pantsTin, pantsBronze, pantsTitanium, pantsUltimate, pantsTopaz;
	public static ItemArmor bootsTin, bootsBronze, bootsTitanium, bootsUltimate, bootsTopaz;

	public static final ToolMaterial FlintToolmat = EnumHelper.addToolMaterial("FLINT", 1, 125, 4F, 1.5F, 7);
	public static final ToolMaterial CopperToolmat = EnumHelper.addToolMaterial("COPPER", 1, 190, 5F, 1.5F, 12);
	public static final ToolMaterial BronzeToolmat = EnumHelper.addToolMaterial("BRONZE", 2, 230, 6F, 2F, 15);
	public static final ToolMaterial CobaltToolmat = EnumHelper.addToolMaterial("COBALT", 2, 660, 9F, 2.5F, 17);
	public static final ToolMaterial NickelToolmat = EnumHelper.addToolMaterial("NICKEL", 2, 580, 10F, 2.5F, 17);
	public static final ToolMaterial TopazToolmat = EnumHelper.addToolMaterial("TOPAZ", 3, 1150, 6.5F, 3F, 9);
	public static final ToolMaterial WSteelToolmat = EnumHelper.addToolMaterial("WSTEEL", 4, 2000, 11F, 4F, 36);
	public static final ToolMaterial TitaniumToolmat = EnumHelper.addToolMaterial("TITANIUM", 5, 2700, 13F, 6F, 22);
	public static final ToolMaterial UltimateToolmat = EnumHelper.addToolMaterial("ULTIMATE", 15, 3500, 15F, 36F, 0);
	
	public static final ArmorMaterial TinArmormat = EnumHelper.addArmorMaterial("TIN", 9, new int[]{2,3,2,1}, 9);
	public static final ArmorMaterial BronzeArmormat = EnumHelper.addArmorMaterial("BRONZE", 13, new int[]{2,5,4,2}, 17);
	public static final ArmorMaterial TopazArmormat = EnumHelper.addArmorMaterial("BRONZE", 26, new int[]{3,6,5,3}, 14);
	public static final ArmorMaterial TitaniumArmormat = EnumHelper.addArmorMaterial("TITANIUM", 45, new int[]{6,9,8,5}, 26);
	public static final ArmorMaterial UltimateArmormat = EnumHelper.addArmorMaterial("ULTIMATE", 115, new int[]{7,11,9,6}, 0);

	public static CreativeTabs tabIF = new IFCreativeTab("IndustrialFlow", gemTopaz);
	
	public static IFGenerator copperGen, tinGen, zincGen, leadGen, uraniumGen, vanadiumDenseGen;
	public static IFGenerator titaniumGen, radiumGen, thoriumGen, cobaltGen, nickelGen, vanadiumGen;
	public static IFGenerator tungstenGen, topazGen, galliumGen, germaniumGen, platinumGen;
	public static IFGenerator silverGen, palladiumGen, rutheniumGen, cadmiumGen, reniumGen;
	@EventHandler
	public void preLoad(FMLPreInitializationEvent event)
	{
		// Crafting Materials
		ingotZinc = new IFItem("industrialflow:ingotZinc", this.tabIF);
		ingotCopper = new IFItem("industrialflow:ingotCopper", this.tabIF);
		ingotTin = new IFItem("industrialflow:ingotTin", this.tabIF);
		ingotLead = new IFItem("industrialflow:ingotLead", this.tabIF);
		ingotSilver = new IFItem("industrialflow:ingotSilver", this.tabIF);
		ingotCobalt = new IFItem("industrialflow:ingotCobalt", this.tabIF);
		ingotNickel = new IFItem("industrialflow:ingotNickel", this.tabIF);
		ingotCadmium = new IFItem("industrialflow:ingotCadmium", this.tabIF);
		ingotUranium = new IFItem("industrialflow:ingotUranium", this.tabIF);
		ingotTungsten = new IFItem("industrialflow:ingotTungsten", this.tabIF);
		ingotPlatinum = new IFItem("industrialflow:ingotPlatinum", this.tabIF);
		ingotTitanium = new IFItem("industrialflow:ingotTitanium", this.tabIF);
		ingotPalladium = new IFItem("industrialflow:ingotPalladium", this.tabIF);
		ingotRenium = new IFItem("industrialflow:ingotRenium", this.tabIF);
		ingotRuthenium = new IFItem("industrialflow:ingotRuthenium", this.tabIF);
		ingotRadium = new IFItem("industrialflow:ingotRadium", this.tabIF);
		ingotThorium = new IFItem("industrialflow:ingotThorium", this.tabIF);
		ingotVanadium = new IFItem("industrialflow:ingotVanadium", this.tabIF);
		ingotBronze = new IFItem("industrialflow:ingotBronze", this.tabIF);
		ingotWSteel = new IFItem("industrialflow:ingotWSteel", this.tabIF);
		gemTopaz = new IFItem("industrialflow:gemTopaz", this.tabIF);
		dustGallium = new IFItem("industrialflow:dustGallium", this.tabIF);
		dustGermanium = new IFItem("industrialflow:dustGermanium", this.tabIF);
		rodFire = new IFItem("industrialflow:rodFire", this.tabIF);
		rodFlint = new IFItem("industrialflow:rodFlint", this.tabIF);
		rodWooden = new IFItem("industrialflow:rodWooden", this.tabIF);
		rodCadmium = new IFItem("industrialflow:rodCadmium", this.tabIF);
		nuggetPalladium = new IFItem("industrialflow:nuggetPalladium", this.tabIF);
		nuggetRuthenium = new IFItem("industrialflow:nuggetRuthenium", this.tabIF);
		forgeHammer = new IFItem("industrialflow:forgeHammer", this.tabIF);
		plateCadmium = new IFItem("industrialflow:plateCadmium", this.tabIF);
		plateTungsten = new IFItem("industrialflow:plateTungsten", this.tabIF);
		platePalladium = new IFItem("industrialflow:platePalladium", this.tabIF);
		plateRuthenium = new IFItem("industrialflow:plateRuthenium", this.tabIF);
		plateVanadium = new IFItem("industrialflow:plateVanadium", this.tabIF);
		
		// Axes
		axeFlint = new IFAxe("industrialflow:axeFlint", tabIF, FlintToolmat);
		axeCopper = new IFAxe("industrialflow:axeCopper", tabIF, CopperToolmat);
		axeBronze = new IFAxe("industrialflow:axeBronze", tabIF, BronzeToolmat);
		axeCobalt = new IFAxe("industrialflow:axeCobalt", tabIF, CobaltToolmat);
		axeNickel = new IFAxe("industrialflow:axeNickel", tabIF, NickelToolmat);
		axeTopaz = new IFAxe("industrialflow:axeTopaz", tabIF, TopazToolmat);
		axeWSteel = new IFAxe("industrialflow:axeWSteel", tabIF, WSteelToolmat);
		axeTitanium = new IFAxe("industrialflow:axeTitanium", tabIF, TitaniumToolmat);
		
		axeUltimate = new IFUltimateAxe();
		
		// Battleaxes
		battleaxeFlint = new ItemMelee("industrialflow:battleaxeFlint", tabIF, new IFBattleAxe(FlintToolmat));
		battleaxeCopper = new ItemMelee("industrialflow:battleaxeCopper", tabIF, new IFBattleAxe(CopperToolmat));
		battleaxeBronze = new ItemMelee("industrialflow:battleaxeBronze", tabIF, new IFBattleAxe(BronzeToolmat));
		battleaxeCobalt = new ItemMelee("industrialflow:battleaxeCobalt", tabIF, new IFBattleAxe(CobaltToolmat));
		battleaxeNickel = new ItemMelee("industrialflow:battleaxeNickel", tabIF, new IFBattleAxe(NickelToolmat));
		battleaxeTopaz = new ItemMelee("industrialflow:battleaxeTopaz", tabIF, new IFBattleAxe(TopazToolmat));
		battleaxeWSteel = new ItemMelee("industrialflow:battleaxeWSteel", tabIF, new IFBattleAxe(WSteelToolmat));
		battleaxeTitanium = new ItemMelee("industrialflow:battleaxeTitanium", tabIF, new IFBattleAxe(TitaniumToolmat));
		
		battleaxeUltimate = new IFUltimateBattleAxe();
		
		// Pickaxes
		pickFlint = new IFPickaxe("industrialflow:pickFlint", tabIF, FlintToolmat);
		pickCopper = new IFPickaxe("industrialflow:pickCopper", tabIF, CopperToolmat);
		pickBronze = new IFPickaxe("industrialflow:pickBronze", tabIF, BronzeToolmat);
		pickCobalt = new IFPickaxe("industrialflow:pickCobalt", tabIF, CobaltToolmat);
		pickNickel = new IFPickaxe("industrialflow:pickNickel", tabIF, NickelToolmat);
		pickTopaz = new IFPickaxe("industrialflow:pickTopaz", tabIF, TopazToolmat);
		pickWSteel = new IFPickaxe("industrialflow:pickWSteel", tabIF, WSteelToolmat);
		pickTitanium = new IFPickaxe("industrialflow:pickTitanium", tabIF, TitaniumToolmat);
		
		pickUltimate = new IFUltimatePick();
		
		// Broadswords
		broadswordFlint = new IFBroadsword("industrialflow:broadswordFlint", tabIF, FlintToolmat);
		broadswordCopper = new IFBroadsword("industrialflow:broadswordCopper", tabIF, CopperToolmat);
		broadswordBronze = new IFBroadsword("industrialflow:broadswordBronze", tabIF, BronzeToolmat);
		broadswordCobalt = new IFBroadsword("industrialflow:broadswordCobalt", tabIF, CobaltToolmat);
		broadswordNickel = new IFBroadsword("industrialflow:broadswordNickel", tabIF, NickelToolmat);
		broadswordTopaz = new IFBroadsword("industrialflow:broadswordTopaz", tabIF, TopazToolmat);
		broadswordWSteel = new IFBroadsword("industrialflow:broadswordWSteel", tabIF, WSteelToolmat);
		broadswordTitanium = new IFBroadsword("industrialflow:broadswordTitanium", tabIF, TitaniumToolmat);
		
		broadswordUltimate = new IFUltimateSword();
		
		// Spades
		spadeFlint = new IFSpade("industrialflow:spadeFlint", tabIF, FlintToolmat);
		spadeCopper = new IFSpade("industrialflow:spadeCopper", tabIF, CopperToolmat);
		spadeBronze = new IFSpade("industrialflow:spadeBronze", tabIF, BronzeToolmat);
		spadeCobalt = new IFSpade("industrialflow:spadeCobalt", tabIF, CobaltToolmat);
		spadeNickel = new IFSpade("industrialflow:spadeNickel", tabIF, NickelToolmat);
		spadeTopaz = new IFSpade("industrialflow:spadeTopaz", tabIF, TopazToolmat);
		spadeWSteel = new IFSpade("industrialflow:spadeWSteel", tabIF, WSteelToolmat);
		spadeTitanium = new IFSpade("industrialflow:spadeTitanium", tabIF, TitaniumToolmat);
		
		spadeUltimate = new IFUltimateSpade();
		
		// Hoes
		hoeFlint = new IFHoe("industrialflow:hoeFlint", tabIF, FlintToolmat);
		hoeCopper = new IFHoe("industrialflow:hoeCopper", tabIF, CopperToolmat);
		hoeBronze = new IFHoe("industrialflow:hoeBronze", tabIF, BronzeToolmat);
		hoeCobalt = new IFHoe("industrialflow:hoeCobalt", tabIF, CobaltToolmat);
		hoeNickel = new IFHoe("industrialflow:hoeNickel", tabIF, NickelToolmat);
		hoeTopaz = new IFHoe("industrialflow:hoeTopaz", tabIF, TopazToolmat);
		hoeWSteel = new IFHoe("industrialflow:hoeWSteel", tabIF, WSteelToolmat);
		hoeTitanium = new IFHoe("industrialflow:hoeTitanium", tabIF, TitaniumToolmat);
		
		hoeUltimate = new IFUltimateHoe();
		
		// Armour
		helmetTin = new IFHelmet("industrialflow:helmetTin", tabIF, TinArmormat, "industrialflow:textures/armourmodels/tin_l1.png");
		helmetBronze = new IFHelmet("industrialflow:helmetBronze", tabIF, BronzeArmormat, "industrialflow:textures/armourmodels/bronze_l1.png");
		helmetTopaz = new IFHelmet("industrialflow:helmetTopaz", tabIF, TopazArmormat, "industrialflow:textures/armourmodels/topaz_l1.png");
		helmetTitanium = new IFHelmet("industrialflow:helmetTitanium", tabIF, TitaniumArmormat, "industrialflow:textures/armourmodels/titanium_l1.png");
		
		chestplateTin = new IFChestplate("industrialflow:chestplateTin", tabIF, TinArmormat, "industrialflow:textures/armourmodels/tin_l1.png");
		chestplateBronze = new IFChestplate("industrialflow:chestplateBronze", tabIF, BronzeArmormat, "industrialflow:textures/armourmodels/bronze_l1.png");
		chestplateTopaz = new IFChestplate("industrialflow:chestplateTopaz", tabIF, TopazArmormat, "industrialflow:textures/armourmodels/topaz_l1.png");
		chestplateTitanium = new IFChestplate("industrialflow:chestplateTitanium", tabIF, TitaniumArmormat, "industrialflow:textures/armourmodels/titanium_l1.png");
		
		pantsTin = new IFPants("industrialflow:pantsTin", tabIF, TinArmormat, "industrialflow:textures/armourmodels/tin_l2.png");
		pantsBronze = new IFPants("industrialflow:pantsBronze", tabIF, BronzeArmormat, "industrialflow:textures/armourmodels/bronze_l2.png");
		pantsTopaz = new IFPants("industrialflow:pantsTopaz", tabIF, TopazArmormat, "industrialflow:textures/armourmodels/topaz_l2.png");
		pantsTitanium = new IFPants("industrialflow:pantsTitanium", tabIF, TitaniumArmormat, "industrialflow:textures/armourmodels/titanium_l2.png");

		bootsTin = new IFBoots("industrialflow:bootsTin", tabIF, TinArmormat, "industrialflow:textures/armourmodels/tin_l1.png");
		bootsBronze = new IFBoots("industrialflow:bootsBronze", tabIF, BronzeArmormat, "industrialflow:textures/armourmodels/bronze_l1.png");
		bootsTopaz = new IFBoots("industrialflow:bootsTopaz", tabIF, TopazArmormat, "industrialflow:textures/armourmodels/topaz_l1.png");
		bootsTitanium = new IFBoots("industrialflow:bootsTitanium", tabIF, TitaniumArmormat, "industrialflow:textures/armourmodels/titanium_l1.png");

		helmetUltimate = new IFUltimateHelmet();
		chestplateUltimate = new IFUltimateChestplate();
		pantsUltimate = new IFUltimatePants();
		bootsUltimate = new IFUltimateBoots();
		// Ores
		
		oreZinc = new IFOre("industrialflow:oreZinc", tabIF, 1.3F, "pickaxe", 1);
		oreCopper = new IFOre("industrialflow:oreCopper", tabIF, 2.2F, "pickaxe", 1);
		oreTin = new IFOre("industrialflow:oreTin", tabIF, 2.6F, "pickaxe", 1);
		oreLead = new IFOre("industrialflow:oreLead", tabIF, 3.1F, "pickaxe", 1);
		
		oreSilver = new IFOre("industrialflow:oreSilver", tabIF, 3.8F, "pickaxe", 2);
		oreCobalt = new IFOre("industrialflow:oreCobalt", tabIF, 4.4F, "pickaxe", 2);
		oreNickel = new IFOre("industrialflow:oreNickel", tabIF, 4.4F, "pickaxe", 2);
		oreCadmium = new IFOre("industrialflow:oreCadmium", tabIF, 4.7F, "pickaxe", 2).setResistance(23.5F);
		oreTopaz = new IFOre("industrialflow:oreTopaz", tabIF, 5.3F, "pickaxe", 2, this.gemTopaz);
		oreGallium = new IFOre("industrialflow:oreGallium", tabIF, 5.6F, "pickaxe", 2, this.dustGallium, 4);
		oreGermanium = new IFOre("industrialflow:oreGermanium", tabIF, 5.8F, "pickaxe", 2, this.dustGermanium, 6);
		
		oreUranium = new IFOre("industrialflow:oreUranium", tabIF, 6F, "pickaxe", 3);
		oreTungsten = new IFOre("industrialflow:oreTungsten", tabIF, 8.5F, "pickaxe", 3);

		orePlatinum = new IFOre("industrialflow:orePlatinum", tabIF, 10.3F, "pickaxe", 4);
		oreTitanium = new IFOre("industrialflow:oreTitanium", tabIF, 12.5F, "pickaxe", 4);
		
		orePalladium = new IFOre("industrialflow:orePalladium", tabIF, 15F, "pickaxe", 5).setResistance(15F);
		oreRenium = new IFOre("industrialflow:oreRenium", tabIF, 16F, "pickaxe", 5).setResistance(80F);
		oreRuthenium = new IFOre("industrialflow:oreRuthenium", tabIF, 20F, "pickaxe", 5).setResistance(20F);
		oreRadium = new IFOre("industrialflow:oreRadium", tabIF, 22F, "pickaxe", 5).setResistance(1100F);
		oreThorium = new IFOre("industrialflow:oreThorium", tabIF, 24F, "pickaxe", 5).setResistance(1200F);
		oreVanadium = new IFOre("industrialflow:oreVanadium", tabIF, 26F, "pickaxe", 5).setResistance(1300F);
		
		oreVanadiumDense = new IFOre("industrialflow:oreVanadiumDense", tabIF, 33F, "pickaxe", 6).setResistance(3000F);
		Blocks.obsidian.setHardness(22F);
		
		GameRegistry.registerBlock(oreCopper, "oreCopper");
		GameRegistry.registerBlock(oreTin, "oreTin");
		GameRegistry.registerBlock(oreLead, "oreLead");
		GameRegistry.registerBlock(oreUranium, "oreUranium");
		GameRegistry.registerBlock(oreTitanium, "oreTitanium");
		GameRegistry.registerBlock(oreCobalt, "oreCobalt");
		GameRegistry.registerBlock(oreNickel, "oreNickel");
		GameRegistry.registerBlock(oreTopaz, "oreTopaz");
		GameRegistry.registerBlock(oreCadmium, "oreCadmium");
		GameRegistry.registerBlock(oreSilver, "oreSilver");
		GameRegistry.registerBlock(oreZinc, "oreZinc");
		GameRegistry.registerBlock(orePlatinum, "orePlatinum");
		GameRegistry.registerBlock(oreGermanium, "oreGermanium");
		GameRegistry.registerBlock(oreGallium, "oreGallium");
		GameRegistry.registerBlock(oreTungsten, "oreTungsten");
		GameRegistry.registerBlock(oreRenium, "oreRenium");
		GameRegistry.registerBlock(orePalladium, "orePalladium");
		GameRegistry.registerBlock(oreRuthenium, "oreRuthenium");
		GameRegistry.registerBlock(oreRadium, "oreRadium");
		GameRegistry.registerBlock(oreThorium, "oreThorium");
		GameRegistry.registerBlock(oreVanadium, "oreVanadium");
		GameRegistry.registerBlock(oreVanadiumDense, "oreVanadiumDense");
		
		GameRegistry.registerItem(dustGallium, "dustGallium");
		GameRegistry.registerItem(dustGermanium, "dustGermanium");
		GameRegistry.registerItem(gemTopaz, "gemTopaz");
		GameRegistry.registerItem(rodFire, "rodFire");
		GameRegistry.registerItem(rodFlint, "rodFlint");
		GameRegistry.registerItem(rodWooden, "rodWooden");
		GameRegistry.registerItem(rodCadmium, "rodCadmium");
		GameRegistry.registerItem(nuggetPalladium, "nuggetPalladium");
		GameRegistry.registerItem(nuggetRuthenium, "nuggetRuthenium");
		GameRegistry.registerItem(ingotZinc, "ingotZinc");
		GameRegistry.registerItem(ingotCopper, "ingotCopper");
		GameRegistry.registerItem(ingotTin, "ingotTin");
		GameRegistry.registerItem(ingotLead, "ingotLead");
		GameRegistry.registerItem(ingotSilver, "ingotSilver");
		GameRegistry.registerItem(ingotNickel, "ingotNickel");
		GameRegistry.registerItem(ingotCobalt, "ingotCobalt");
		GameRegistry.registerItem(ingotCadmium, "ingotCadmium");
		GameRegistry.registerItem(ingotBronze, "ingotBronze");
		GameRegistry.registerItem(ingotTungsten, "ingotTungsten");
		GameRegistry.registerItem(ingotUranium, "ingotUranium");
		GameRegistry.registerItem(ingotPlatinum, "ingotPlatinum");
		GameRegistry.registerItem(ingotTitanium, "ingotTitanium");
		GameRegistry.registerItem(ingotWSteel, "ingotWSteel");
		GameRegistry.registerItem(ingotPalladium, "ingotPalladium");
		GameRegistry.registerItem(ingotRenium, "ingotRenium");
		GameRegistry.registerItem(ingotRadium, "ingotRadium");
		GameRegistry.registerItem(ingotThorium, "ingotThorium");
		GameRegistry.registerItem(ingotVanadium, "ingotVanadium");
		GameRegistry.registerItem(ingotRuthenium, "ingotRuthenium");
		GameRegistry.registerItem(forgeHammer, "forgeHammer");
		GameRegistry.registerItem(plateCadmium, "plateCadmium");
		GameRegistry.registerItem(plateTungsten, "plateTungsten");
		GameRegistry.registerItem(platePalladium, "platePalladium");
		GameRegistry.registerItem(plateRuthenium, "plateRuthenium");
		GameRegistry.registerItem(plateVanadium, "plateVanadium");
		
		GameRegistry.registerItem(axeFlint, "axeFlint");
		GameRegistry.registerItem(axeCopper, "axeCopper");
		GameRegistry.registerItem(axeBronze, "axeBronze");
		GameRegistry.registerItem(axeCobalt, "axeCobalt");
		GameRegistry.registerItem(axeNickel, "axeNickel");
		GameRegistry.registerItem(axeTopaz, "axeTopaz");
		GameRegistry.registerItem(axeWSteel, "axeWSteel");
		GameRegistry.registerItem(axeTitanium, "axeTitanium");
		
		GameRegistry.registerItem(battleaxeFlint, "battleaxeFlint");
		GameRegistry.registerItem(battleaxeCopper, "battleaxeCopper");
		GameRegistry.registerItem(battleaxeBronze, "battleaxeBronze");
		GameRegistry.registerItem(battleaxeCobalt, "battleaxeCobalt");
		GameRegistry.registerItem(battleaxeNickel, "battleaxeNickel");
		GameRegistry.registerItem(battleaxeTopaz, "battleaxeTopaz");
		GameRegistry.registerItem(battleaxeWSteel, "battleaxeWSteel");
		GameRegistry.registerItem(battleaxeTitanium, "battleaxeTitanium");
		
		GameRegistry.registerItem(pickFlint, "pickaxeFlint");
		GameRegistry.registerItem(pickCopper, "pickaxeCopper");
		GameRegistry.registerItem(pickBronze, "pickaxeBronze");
		GameRegistry.registerItem(pickCobalt, "pickaxeCobalt");
		GameRegistry.registerItem(pickNickel, "pickaxeNickel");
		GameRegistry.registerItem(pickTopaz, "pickaxeTopaz");
		GameRegistry.registerItem(pickWSteel, "pickaxeWSteel");
		GameRegistry.registerItem(pickTitanium, "pickaxeTitanium");
		
		GameRegistry.registerItem(broadswordFlint, "broadswordFlint");
		GameRegistry.registerItem(broadswordCopper, "broadswordCopper");
		GameRegistry.registerItem(broadswordBronze, "broadswordBronze");
		GameRegistry.registerItem(broadswordCobalt, "broadswordCobalt");
		GameRegistry.registerItem(broadswordNickel, "broadswordNickel");
		GameRegistry.registerItem(broadswordTopaz, "broadswordTopaz");
		GameRegistry.registerItem(broadswordWSteel, "broadswordWSteel");
		GameRegistry.registerItem(broadswordTitanium, "broadswordTitanium");
		
		GameRegistry.registerItem(spadeFlint, "shovelFlint");
		GameRegistry.registerItem(spadeCopper, "shovelCopper");
		GameRegistry.registerItem(spadeBronze, "shovelBronze");
		GameRegistry.registerItem(spadeCobalt, "shovelCobalt");
		GameRegistry.registerItem(spadeNickel, "shovelNickel");
		GameRegistry.registerItem(spadeTopaz, "shovelTopaz");
		GameRegistry.registerItem(spadeWSteel, "shovelWSteel");
		GameRegistry.registerItem(spadeTitanium, "shovelTitanium");
		
		GameRegistry.registerItem(hoeFlint, "hoeFlint");
		GameRegistry.registerItem(hoeCopper, "hoeCopper");
		GameRegistry.registerItem(hoeBronze, "hoeBronze");
		GameRegistry.registerItem(hoeCobalt, "hoeCobalt");
		GameRegistry.registerItem(hoeNickel, "hoeNickel");
		GameRegistry.registerItem(hoeTopaz, "hoeTopaz");
		GameRegistry.registerItem(hoeWSteel, "hoeWSteel");
		GameRegistry.registerItem(hoeTitanium, "hoeTitanium");
		
		GameRegistry.registerItem(axeUltimate, "axeUltimate");
		GameRegistry.registerItem(battleaxeUltimate, "battleaxeUltimate");
		GameRegistry.registerItem(pickUltimate, "pickaxeUltimate");
		GameRegistry.registerItem(broadswordUltimate, "broadswordUltimate");
		GameRegistry.registerItem(spadeUltimate, "shovelUltimate");
		GameRegistry.registerItem(hoeUltimate, "hoeUltimate");
		
		GameRegistry.registerItem(helmetTin, "helmetTin");
		GameRegistry.registerItem(helmetBronze, "helmetBronze");
		GameRegistry.registerItem(helmetTopaz, "helmetTopaz");
		GameRegistry.registerItem(helmetTitanium, "helmetTitanium");
		GameRegistry.registerItem(helmetUltimate, "helmetUltimate");
		
		GameRegistry.registerItem(chestplateTin, "chestplateTin");
		GameRegistry.registerItem(chestplateBronze, "chestplateBronze");
		GameRegistry.registerItem(chestplateTopaz, "chestplateTopaz");
		GameRegistry.registerItem(chestplateTitanium, "chestplateTitanium");
		GameRegistry.registerItem(chestplateUltimate, "chestplateUltimate");
		
		GameRegistry.registerItem(pantsTin, "pantsTin");
		GameRegistry.registerItem(pantsBronze, "pantsBronze");
		GameRegistry.registerItem(pantsTopaz, "pantsTopaz");
		GameRegistry.registerItem(pantsTitanium, "pantsTitanium");
		GameRegistry.registerItem(pantsUltimate, "pantsUltimate");
		
		GameRegistry.registerItem(bootsTin, "bootsTin");
		GameRegistry.registerItem(bootsBronze, "bootsBronze");
		GameRegistry.registerItem(bootsTopaz, "bootsTopaz");
		GameRegistry.registerItem(bootsTitanium, "bootsTitanium");
		GameRegistry.registerItem(bootsUltimate, "bootsUltimate");

		GameRegistry.addRecipe(new ItemStack(axeFlint, 1), new Object[]{"MM","MR"," R",('M'), Items.flint, ('R'), rodFlint});
		GameRegistry.addRecipe(new ItemStack(axeCopper, 1), new Object[]{"MM","MR"," R",('M'), ingotCopper, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(axeBronze, 1), new Object[]{"MM","MR"," R",('M'), ingotBronze, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(axeCobalt, 1), new Object[]{"MM","MR"," R",('M'), ingotCobalt, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(axeNickel, 1), new Object[]{"MM","MR"," R",('M'), ingotNickel, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(axeTopaz, 1), new Object[]{"MM","MR"," R",('M'), gemTopaz, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(axeWSteel, 1), new Object[]{"MM","MR"," R",('M'), ingotWSteel, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(axeTitanium, 1), new Object[]{"MM","MR"," R",('M'), ingotTitanium, ('R'), rodWooden});

		GameRegistry.addRecipe(new ItemStack(axeFlint, 1), new Object[]{"MM","RM","R ",('M'), Items.flint, ('R'), rodFlint});
		GameRegistry.addRecipe(new ItemStack(axeCopper, 1), new Object[]{"MM","RM","R ",('M'), ingotCopper, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(axeBronze, 1), new Object[]{"MM","RM","R ",('M'), ingotBronze, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(axeCobalt, 1), new Object[]{"MM","RM","R ",('M'), ingotCobalt, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(axeNickel, 1), new Object[]{"MM","RM","R ",('M'), ingotNickel, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(axeTopaz, 1), new Object[]{"MM","RM","R ",('M'), gemTopaz, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(axeWSteel, 1), new Object[]{"MM","RM","R ",('M'), ingotWSteel, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(axeTitanium, 1), new Object[]{"MM","RM","R ",('M'), ingotTitanium, ('R'), rodWooden});

		GameRegistry.addRecipe(new ItemStack(pickFlint, 1), new Object[]{"MMM"," R "," R ",('M'), Items.flint, ('R'), rodFlint});
		GameRegistry.addRecipe(new ItemStack(pickCopper, 1), new Object[]{"MMM"," R "," R ",('M'), ingotCopper, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(pickBronze, 1), new Object[]{"MMM"," R "," R ",('M'), ingotBronze, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(pickCobalt, 1), new Object[]{"MMM"," R "," R ",('M'), ingotCobalt, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(pickNickel, 1), new Object[]{"MMM"," R "," R ",('M'), ingotNickel, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(pickTopaz, 1), new Object[]{"MMM"," R "," R ",('M'), gemTopaz, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(pickWSteel, 1), new Object[]{"MMM"," R "," R ",('M'), ingotWSteel, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(pickTitanium, 1), new Object[]{"MMM"," R "," R ",('M'), ingotTitanium, ('R'), rodWooden});

		GameRegistry.addRecipe(new ItemStack(broadswordFlint, 1), new Object[]{"M","M","R",('M'), Items.flint, ('R'), rodFlint});
		GameRegistry.addRecipe(new ItemStack(broadswordCopper, 1), new Object[]{"M","M","R",('M'), ingotCopper, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(broadswordBronze, 1), new Object[]{"M","M","R",('M'), ingotBronze, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(broadswordCobalt, 1), new Object[]{"M","M","R",('M'), ingotCobalt, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(broadswordNickel, 1), new Object[]{"M","M","R",('M'), ingotNickel, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(broadswordTopaz, 1), new Object[]{"M","M","R",('M'), gemTopaz, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(broadswordWSteel, 1), new Object[]{"M","M","R",('M'), ingotWSteel, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(broadswordTitanium, 1), new Object[]{"M","M","R",('M'), ingotTitanium, ('R'), rodWooden});

		GameRegistry.addRecipe(new ItemStack(spadeFlint, 1), new Object[]{"M","R","R",('M'), Items.flint, ('R'), rodFlint});
		GameRegistry.addRecipe(new ItemStack(spadeCopper, 1), new Object[]{"M","R","R",('M'), ingotCopper, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(spadeBronze, 1), new Object[]{"M","R","R",('M'), ingotBronze, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(spadeCobalt, 1), new Object[]{"M","R","R",('M'), ingotCobalt, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(spadeNickel, 1), new Object[]{"M","R","R",('M'), ingotNickel, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(spadeTopaz, 1), new Object[]{"M","R","R",('M'), gemTopaz, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(spadeWSteel, 1), new Object[]{"M","R","R",('M'), ingotWSteel, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(spadeTitanium, 1), new Object[]{"M","R","R",('M'), ingotTitanium, ('R'), rodWooden});

		GameRegistry.addRecipe(new ItemStack(hoeFlint, 1), new Object[]{"MM"," R"," R",('M'), Items.flint, ('R'), rodFlint});
		GameRegistry.addRecipe(new ItemStack(hoeCopper, 1), new Object[]{"MM"," R"," R",('M'), ingotCopper, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(hoeBronze, 1), new Object[]{"MM"," R"," R",('M'), ingotBronze, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(hoeCobalt, 1), new Object[]{"MM"," R"," R",('M'), ingotCobalt, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(hoeNickel, 1), new Object[]{"MM"," R"," R",('M'), ingotNickel, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(hoeTopaz, 1), new Object[]{"MM"," R"," R",('M'), gemTopaz, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(hoeWSteel, 1), new Object[]{"MM"," R"," R",('M'), ingotWSteel, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(hoeTitanium, 1), new Object[]{"MM"," R"," R",('M'), ingotTitanium, ('R'), rodWooden});

		GameRegistry.addRecipe(new ItemStack(hoeFlint, 1), new Object[]{"MM","R ","R ",('M'), Items.flint, ('R'), rodFlint});
		GameRegistry.addRecipe(new ItemStack(hoeCopper, 1), new Object[]{"MM","R ","R ",('M'), ingotCopper, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(hoeBronze, 1), new Object[]{"MM","R ","R ",('M'), ingotBronze, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(hoeCobalt, 1), new Object[]{"MM","R ","R ",('M'), ingotCobalt, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(hoeNickel, 1), new Object[]{"MM","R ","R ",('M'), ingotNickel, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(hoeTopaz, 1), new Object[]{"MM","R ","R ",('M'), gemTopaz, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(hoeWSteel, 1), new Object[]{"MM","R ","R ",('M'), ingotWSteel, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(hoeTitanium, 1), new Object[]{"MM","R ","R ",('M'), ingotTitanium, ('R'), rodWooden});
		
		GameRegistry.addRecipe(new ItemStack(battleaxeCopper, 1), new Object[]{"MMM","MRM"," R ",('M'), ingotCopper, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(battleaxeFlint, 1), new Object[]{"MMM","MRM"," R ",('M'), Items.flint, ('R'), rodFlint});
		GameRegistry.addRecipe(new ItemStack(battleaxeBronze, 1), new Object[]{"MMM","MRM"," R ",('M'), ingotBronze, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(battleaxeCobalt, 1), new Object[]{"MMM","MRM"," R ",('M'), ingotCobalt, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(battleaxeNickel, 1), new Object[]{"MMM","MRM"," R ",('M'), ingotNickel, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(battleaxeTopaz, 1), new Object[]{"MMM","MRM"," R ",('M'), gemTopaz, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(battleaxeWSteel, 1), new Object[]{"MMM","MRM"," R ",('M'), ingotWSteel, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(battleaxeTitanium, 1), new Object[]{"MMM","MRM"," R ",('M'), ingotTitanium, ('R'), rodWooden});
		
		GameRegistry.addRecipe(new ItemStack(pickUltimate, 1), new Object[]{"PRP"," R "," C ",('P'), ingotPalladium,('R'), ingotRuthenium,('C'),rodCadmium});
		GameRegistry.addRecipe(new ItemStack(axeUltimate, 1), new Object[]{"RP","RP"," C",('P'), ingotPalladium,('R'), ingotRuthenium,('C'),rodCadmium});
		GameRegistry.addRecipe(new ItemStack(axeUltimate, 1), new Object[]{"PR","PR","C ",('P'), ingotPalladium,('R'), ingotRuthenium,('C'),rodCadmium});
		GameRegistry.addRecipe(new ItemStack(broadswordUltimate, 1), new Object[]{" P"," R", "TC",('P'), ingotPalladium,('R'), ingotRuthenium,('C'),rodCadmium,('T'),plateTungsten});
		GameRegistry.addRecipe(new ItemStack(battleaxeUltimate, 1), new Object[]{"RTP","RCP"," C ",('P'), ingotPalladium,('R'), ingotRuthenium,('C'),rodCadmium,('T'),plateTungsten});
		GameRegistry.addRecipe(new ItemStack(battleaxeUltimate, 1), new Object[]{"PTR","PCR"," C ",('P'), ingotPalladium,('R'), ingotRuthenium,('C'),rodCadmium,('T'),plateTungsten});
		GameRegistry.addRecipe(new ItemStack(spadeUltimate, 1), new Object[]{"R","P","C",('P'), ingotPalladium,('R'), ingotRuthenium,('C'),rodCadmium});
		GameRegistry.addRecipe(new ItemStack(hoeUltimate, 1), new Object[]{"PR","C ","C ",('P'), ingotPalladium,('R'), ingotRuthenium,('C'),rodCadmium});
		GameRegistry.addRecipe(new ItemStack(hoeUltimate, 1), new Object[]{"PR"," C"," C",('P'), ingotPalladium,('R'), ingotRuthenium,('C'),rodCadmium});
		
		GameRegistry.addRecipe(new ItemStack(pickUltimate, 1), new Object[]{"P",('P'),pickUltimate});
		GameRegistry.addRecipe(new ItemStack(broadswordUltimate, 1), new Object[]{"P",('P'),broadswordUltimate});
		GameRegistry.addRecipe(new ItemStack(hoeUltimate, 1), new Object[]{"P",('P'),hoeUltimate});
		GameRegistry.addRecipe(new ItemStack(axeUltimate, 1), new Object[]{"P",('P'),axeUltimate});
		GameRegistry.addRecipe(new ItemStack(spadeUltimate, 1), new Object[]{"P",('P'),spadeUltimate});
		GameRegistry.addRecipe(new ItemStack(battleaxeUltimate, 1), new Object[]{"P",('P'),battleaxeUltimate});
		GameRegistry.addRecipe(new ItemStack(pantsUltimate, 1), new Object[]{"P",('P'),pantsUltimate});
		GameRegistry.addRecipe(new ItemStack(helmetUltimate, 1), new Object[]{"P",('P'),helmetUltimate});
		GameRegistry.addRecipe(new ItemStack(bootsUltimate, 1), new Object[]{"P",('P'),bootsUltimate});
		GameRegistry.addRecipe(new ItemStack(chestplateUltimate, 1), new Object[]{"P",('P'),chestplateUltimate});
		
		GameRegistry.addRecipe(new ItemStack(helmetTin), new Object[]{"MMM", "M M",('M'),ingotTin});
		GameRegistry.addRecipe(new ItemStack(helmetBronze), new Object[]{"MMM", "M M",('M'),ingotBronze});
		GameRegistry.addRecipe(new ItemStack(helmetTopaz), new Object[]{"MMM", "M M",('M'),gemTopaz});
		GameRegistry.addRecipe(new ItemStack(helmetTitanium), new Object[]{"MMM", "M M",('M'),ingotTitanium});
		
		GameRegistry.addRecipe(new ItemStack(chestplateTin), new Object[]{"M M","MMM","MMM",('M'),ingotTin});
		GameRegistry.addRecipe(new ItemStack(chestplateBronze), new Object[]{"M M","MMM","MMM",('M'),ingotBronze});
		GameRegistry.addRecipe(new ItemStack(chestplateTopaz), new Object[]{"M M","MMM","MMM",('M'),gemTopaz});
		GameRegistry.addRecipe(new ItemStack(chestplateTitanium), new Object[]{"M M","MMM","MMM",('M'),ingotTitanium});
		
		GameRegistry.addRecipe(new ItemStack(pantsTin), new Object[]{"MMM","M M","M M",('M'),ingotTin});
		GameRegistry.addRecipe(new ItemStack(pantsBronze), new Object[]{"MMM","M M","M M",('M'),ingotBronze});
		GameRegistry.addRecipe(new ItemStack(pantsTopaz), new Object[]{"MMM","M M","M M",('M'),gemTopaz});
		GameRegistry.addRecipe(new ItemStack(pantsTitanium), new Object[]{"MMM","M M","M M",('M'),ingotTitanium});
		
		GameRegistry.addRecipe(new ItemStack(bootsTin), new Object[]{"M M","M M",('M'),ingotTin});
		GameRegistry.addRecipe(new ItemStack(bootsBronze), new Object[]{"M M","M M",('M'),ingotBronze});
		GameRegistry.addRecipe(new ItemStack(bootsTopaz), new Object[]{"M M","M M",('M'),gemTopaz});
		GameRegistry.addRecipe(new ItemStack(bootsTitanium), new Object[]{"M M","M M",('M'),ingotTitanium});
		
		GameRegistry.addRecipe(new ItemStack(helmetUltimate), new Object[]{"PVP","RTR",('P'),platePalladium,('R'),plateRuthenium,('V'),plateVanadium,('T'),helmetTitanium});
		GameRegistry.addRecipe(new ItemStack(chestplateUltimate), new Object[]{"VTV","PPP","RRR",('P'),platePalladium,('R'),plateRuthenium,('V'),plateVanadium,('T'),chestplateTitanium});
		GameRegistry.addRecipe(new ItemStack(pantsUltimate), new Object[]{"VVV","PTP","R R",('P'),platePalladium,('R'),plateRuthenium,('V'),plateVanadium,('T'),pantsTitanium});
		GameRegistry.addRecipe(new ItemStack(bootsUltimate), new Object[]{"PTP","RVR",('P'),platePalladium,('R'),plateRuthenium,('V'),plateVanadium,('T'),bootsTitanium});
		
		GameRegistry.addSmelting(oreZinc, new ItemStack(ingotZinc), 0.15F);
		GameRegistry.addSmelting(oreCopper, new ItemStack(ingotCopper), 0.3F);
		GameRegistry.addSmelting(oreTin, new ItemStack(ingotTin), 0.3F);
		GameRegistry.addSmelting(oreCobalt, new ItemStack(ingotCobalt), 0.55F);
		GameRegistry.addSmelting(oreNickel, new ItemStack(ingotNickel), 0.55F);
		GameRegistry.addSmelting(oreTitanium, new ItemStack(ingotTitanium), 1F);
		GameRegistry.addSmelting(oreCadmium, new ItemStack(ingotCadmium), 0.5F);
		GameRegistry.addSmelting(oreUranium, new ItemStack(ingotUranium), 0.8F);
		GameRegistry.addSmelting(oreTungsten, new ItemStack(ingotTungsten), 0.9F);
		GameRegistry.addSmelting(oreLead, new ItemStack(ingotLead), 0.4F);
		GameRegistry.addSmelting(oreSilver, new ItemStack(ingotSilver), 0.4F);
		GameRegistry.addSmelting(orePlatinum, new ItemStack(ingotPlatinum), 0.6F);
		GameRegistry.addSmelting(orePalladium, new ItemStack(nuggetPalladium), 1.2F);
		GameRegistry.addSmelting(oreRenium, new ItemStack(ingotRenium), 1.3F);
		GameRegistry.addSmelting(oreRuthenium, new ItemStack(nuggetRuthenium), 1.45F);
		GameRegistry.addSmelting(oreRadium, new ItemStack(ingotRadium), 1.6F);
		GameRegistry.addSmelting(oreThorium, new ItemStack(ingotThorium), 1.8F);
		GameRegistry.addSmelting(oreVanadium, new ItemStack(ingotVanadium), 2.3F);
		GameRegistry.addSmelting(oreVanadiumDense, new ItemStack(ingotVanadium, 3), 4.4F);

		GameRegistry.addRecipe(new ItemStack(ingotPalladium, 1), new Object[]{"MMM","MMM","MMM",('M'), nuggetPalladium});
		GameRegistry.addRecipe(new ItemStack(ingotRuthenium, 1), new Object[]{"MMM","MMM","MMM",('M'), nuggetRuthenium});
		GameRegistry.addRecipe(new ItemStack(forgeHammer, 64), new Object[]{"MM ","MRR","MM ",('M'), ingotTin,('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(rodCadmium, 8), new Object[]{"P","P",('P'), plateCadmium});
		GameRegistry.addRecipe(new ItemStack(Blocks.torch, 3), new Object[]{"F","R",('F'), Items.flint,('R'),rodWooden});
		GameRegistry.addShapelessRecipe(new ItemStack(rodWooden, 3), new Object[] {Items.stick});
		GameRegistry.addShapelessRecipe(new ItemStack(rodFire, 9), new Object[] {Items.stick, Items.stick, Items.stick, Items.blaze_powder});
		GameRegistry.addShapelessRecipe(new ItemStack(rodFlint, 3), new Object[] {Items.stick, Items.flint});
		GameRegistry.addShapelessRecipe(new ItemStack(nuggetPalladium, 9), new Object[] {ingotPalladium});
		GameRegistry.addShapelessRecipe(new ItemStack(nuggetRuthenium, 9), new Object[] {ingotRuthenium});
		GameRegistry.addShapelessRecipe(new ItemStack(plateCadmium, 1), new Object[] {forgeHammer, ingotCadmium});
		GameRegistry.addShapelessRecipe(new ItemStack(plateTungsten, 1), new Object[] {forgeHammer, ingotTungsten});
		GameRegistry.addShapelessRecipe(new ItemStack(platePalladium, 1), new Object[] {forgeHammer, ingotPalladium});
		GameRegistry.addShapelessRecipe(new ItemStack(plateRuthenium, 1), new Object[] {forgeHammer, ingotRuthenium});
		GameRegistry.addShapelessRecipe(new ItemStack(plateVanadium, 1), new Object[] {forgeHammer, ingotVanadium, ingotTitanium});
		GameRegistry.addShapelessRecipe(new ItemStack(ingotWSteel, 3), new Object[] {ingotTungsten, ingotTungsten, Items.iron_ingot});
		GameRegistry.addShapelessRecipe(new ItemStack(ingotBronze, 4), new Object[] {ingotCopper, ingotCopper, ingotCopper, ingotTin});
		
		cadmiumGen = new IFGenerator(oreCadmium, true, false, false, 1, 64, 6, 6);
		reniumGen = new IFGenerator(oreRenium, true, false, false, 1, 48, 4, 3);
		thoriumGen = new IFGenerator(oreThorium, false, false, true, 1, 150, 8, 9);
		radiumGen = new IFGenerator(oreRadium, false, false, true, 1, 150, 9, 11);
		vanadiumGen = new IFGenerator(oreVanadium, false, false, true, 1, 150, 6, 6);
		vanadiumDenseGen = new IFGenerator(oreVanadiumDense, false, false, true, 1, 150, 6, 12, Blocks.obsidian);
		
		zincGen = new IFGenerator(oreZinc, false, true, false, 1, 80, 6, 6);
		copperGen = new IFGenerator(oreCopper, false, true, false, 1, 70, 6, 12);
		tinGen = new IFGenerator(oreTin, false, true, false, 1, 70, 6, 10);
		leadGen = new IFGenerator(oreLead, false, true, false, 1, 55, 5, 8);
		cobaltGen = new IFGenerator(oreCobalt, false, true, false, 1, 45, 7, 4);
		topazGen = new IFGenerator(oreTopaz, false, true, false, 1, 40, 7, 4);
		nickelGen = new IFGenerator(oreNickel, false, true, false, 1, 45, 9, 3);
		galliumGen = new IFGenerator(oreGallium, false, true, false, 1, 40, 9, 4);
		germaniumGen = new IFGenerator(oreGermanium, false, true, false, 1, 40, 9, 7);
		rutheniumGen = new IFGenerator(oreRuthenium, false, true, false, 1, 20, 4, 2);
		palladiumGen = new IFGenerator(orePalladium, false, true, false, 1, 20, 4, 2);
		uraniumGen = new IFGenerator(oreUranium, false, true, false, 1, 40, 6, 8);
		titaniumGen = new IFGenerator(oreTitanium, false, true, false, 1, 30, 3, 8);
		platinumGen = new IFGenerator(orePlatinum, false, true, false, 1, 40, 3, 5);
		silverGen = new IFGenerator(oreSilver, false, true, false, 1, 55, 5, 5);
		tungstenGen = new IFGenerator(oreTungsten, false, true, false, 1, 35, 5, 4);

		GameRegistry.registerWorldGenerator(tungstenGen, 0);
		GameRegistry.registerWorldGenerator(reniumGen, 0);
		GameRegistry.registerWorldGenerator(thoriumGen, 0);
		GameRegistry.registerWorldGenerator(radiumGen, 0);
		GameRegistry.registerWorldGenerator(vanadiumGen, 0);
		GameRegistry.registerWorldGenerator(vanadiumDenseGen, 0);
		GameRegistry.registerWorldGenerator(copperGen, 0);
		GameRegistry.registerWorldGenerator(tinGen, 0);
		GameRegistry.registerWorldGenerator(cadmiumGen, 0);
		GameRegistry.registerWorldGenerator(leadGen, 0);
		GameRegistry.registerWorldGenerator(titaniumGen, 0);
		GameRegistry.registerWorldGenerator(rutheniumGen, 0);
		GameRegistry.registerWorldGenerator(palladiumGen, 0);
		GameRegistry.registerWorldGenerator(silverGen, 0);
		GameRegistry.registerWorldGenerator(zincGen, 0);
		GameRegistry.registerWorldGenerator(galliumGen, 0);
		GameRegistry.registerWorldGenerator(uraniumGen, 0);
		GameRegistry.registerWorldGenerator(germaniumGen, 0);
		GameRegistry.registerWorldGenerator(cobaltGen, 0);
		GameRegistry.registerWorldGenerator(nickelGen, 0);
		GameRegistry.registerWorldGenerator(topazGen, 0);
		GameRegistry.registerWorldGenerator(platinumGen, 0);
	}
	
	@Mod.Instance("industrialflow")
	public static IF_Base instance;
	
	@SidedProxy(clientSide = "cf.blazegamer.industrialflow.ClientProxy", serverSide = "cf.blazegamer.industrialflow.ServerProxy")
	public static ServerProxy proxy;
}
