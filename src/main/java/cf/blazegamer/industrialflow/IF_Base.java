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
	public static Block oreCopper, oreTin, oreLead, oreIron, oreZinc, oreCobalt, oreNickel, oreTopaz, oreDiamond, oreCadmium;
	public static Block oreSilver, oreGold, orePlatinum, oreGermanium, oreGallium, oreTungsten, oreUranium, oreTitanium;
	public static Block oreRenium, orePalladium, oreRuthenium, oreRadium, oreThorium;
	
	public static Item gemTopaz, gemDiamond, dustGallium, dustGermanium, ingotZinc, ingotCopper, ingotTin;
	public static Item ingotIron, ingotLead, ingotSilver, ingotGold, ingotCobalt, ingotNickel, ingotCadmium;
	public static Item ingotPlatinum, ingotUranium, ingotTungsten, ingotTitanium, ingotPalladium, ingotRenium;
	public static Item ingotRuthenium, ingotRadium, ingotThorium, ingotBronze, ingotWSteel, rodFire, rodFlint;
	public static Item rodWooden, rodCadmium, nuggetPalladium, nuggetRuthenium, forgeHammer;
	public static Item plateCadmium, plateTungsten;
	
	public static ItemAxe axeFlint, axeCopper, axeBronze, axeIron, axeCobalt, axeNickel;
	public static ItemAxe axeTopaz, axeDiamond, axeWSteel, axeTitanium, axeUltimate;
	public static ItemPickaxe pickFlint, pickCopper, pickBronze, pickIron, pickCobalt, pickNickel;
	public static ItemPickaxe pickTopaz, pickDiamond, pickWSteel, pickTitanium, pickUltimate;
	public static ItemSword broadswordFlint, broadswordCopper, broadswordBronze, broadswordIron;
	public static ItemSword broadswordCobalt, broadswordNickel, broadswordTopaz, broadswordDiamond;
	public static ItemSword broadswordWSteel, broadswordTitanium, broadswordUltimate;
	public static ItemSpade spadeFlint, spadeCopper, spadeBronze, spadeIron, spadeCobalt, spadeNickel;
	public static ItemSpade spadeTopaz, spadeDiamond, spadeWSteel, spadeTitanium, spadeUltimate;
	public static ItemHoe hoeFlint, hoeCopper, hoeBronze, hoeIron, hoeCobalt, hoeNickel;
	public static ItemHoe hoeTopaz, hoeDiamond, hoeWSteel, hoeTitanium, hoeUltimate;
	public static ItemMelee battleaxeFlint, battleaxeCopper, battleaxeBronze, battleaxeIron;
	public static ItemMelee battleaxeCobalt, battleaxeNickel, battleaxeTopaz, battleaxeDiamond;
	public static ItemMelee battleaxeWSteel, battleaxeTitanium, battleaxeUltimate;

	public static final ToolMaterial FlintToolmat = EnumHelper.addToolMaterial("FLINT", 1, 125, 4F, 1.5F, 7);
	public static final ToolMaterial CopperToolmat = EnumHelper.addToolMaterial("COPPER", 1, 190, 5F, 1.5F, 12);
	public static final ToolMaterial BronzeToolmat = EnumHelper.addToolMaterial("BRONZE", 2, 265, 6F, 2F, 15);
	public static final ToolMaterial IronToolmat = EnumHelper.addToolMaterial("IRON", 2, 310, 7F, 2F, 14);
	public static final ToolMaterial CobaltToolmat = EnumHelper.addToolMaterial("COBALT", 2, 660, 9F, 2.5F, 17);
	public static final ToolMaterial NickelToolmat = EnumHelper.addToolMaterial("NICKEL", 2, 580, 10F, 2.5F, 17);
	public static final ToolMaterial TopazToolmat = EnumHelper.addToolMaterial("TOPAZ", 3, 1150, 6.5F, 3F, 9);
	public static final ToolMaterial DiamondToolmat = EnumHelper.addToolMaterial("DIAMOND", 3, 1550, 7F, 3F, 10);
	public static final ToolMaterial WSteelToolmat = EnumHelper.addToolMaterial("WSTEEL", 4, 2000, 11F, 4F, 36);
	public static final ToolMaterial TitaniumToolmat = EnumHelper.addToolMaterial("TITANIUM", 5, 2700, 13F, 6F, 22);
	public static final ToolMaterial UltimateToolmat = EnumHelper.addToolMaterial("ULTIMATE", 15, 3500, 15F, 36F, 0);

	public static CreativeTabs tabIF = new IFCreativeTab("IndustrialFlow", gemTopaz);
	
	public static IFGenerator copperGen, tinGen, zincGen, leadGen, uraniumGen;
	public static IFGenerator titaniumGen, radiumGen, thoriumGen, cobaltGen, nickelGen;
	public static IFGenerator tungstenGen, topazGen, galliumGen, germaniumGen, platinumGen;
	public static IFGenerator silverGen, palladiumGen, rutheniumGen, cadmiumGen, reniumGen;
	@EventHandler
	public void preLoad(FMLPreInitializationEvent event)
	{
		// Crafting Materials
		ingotZinc = new IFItem("industrialflow:ingotZinc", this.tabIF);
		ingotCopper = new IFItem("industrialflow:ingotCopper", this.tabIF);
		ingotTin = new IFItem("industrialflow:ingotTin", this.tabIF);
		ingotIron = new IFItem("industrialflow:ingotIron", this.tabIF);
		ingotLead = new IFItem("industrialflow:ingotLead", this.tabIF);
		ingotSilver = new IFItem("industrialflow:ingotSilver", this.tabIF);
		ingotGold = new IFItem("industrialflow:ingotGold", this.tabIF);
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
		ingotBronze = new IFItem("industrialflow:ingotBronze", this.tabIF);
		ingotWSteel = new IFItem("industrialflow:ingotWSteel", this.tabIF);
		gemTopaz = new IFItem("industrialflow:gemTopaz", this.tabIF);
		gemDiamond = new IFItem("industrialflow:gemDiamond", this.tabIF);
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
		
		// Axes
		axeFlint = new IFAxe("industrialflow:axeFlint", tabIF, FlintToolmat);
		axeCopper = new IFAxe("industrialflow:axeCopper", tabIF, CopperToolmat);
		axeBronze = new IFAxe("industrialflow:axeBronze", tabIF, BronzeToolmat);
		axeIron = new IFAxe("industrialflow:axeIron", tabIF, IronToolmat);
		axeCobalt = new IFAxe("industrialflow:axeCobalt", tabIF, CobaltToolmat);
		axeNickel = new IFAxe("industrialflow:axeNickel", tabIF, NickelToolmat);
		axeTopaz = new IFAxe("industrialflow:axeTopaz", tabIF, TopazToolmat);
		axeDiamond = new IFAxe("industrialflow:axeDiamond", tabIF, DiamondToolmat);
		axeWSteel = new IFAxe("industrialflow:axeWSteel", tabIF, WSteelToolmat);
		axeTitanium = new IFAxe("industrialflow:axeTitanium", tabIF, TitaniumToolmat);
		
		axeUltimate = new IFUltimateAxe();
		
		// Battleaxes
		battleaxeFlint = new ItemMelee("industrialflow:battleaxeFlint", tabIF, new IFBattleAxe(FlintToolmat));
		battleaxeCopper = new ItemMelee("industrialflow:battleaxeCopper", tabIF, new IFBattleAxe(CopperToolmat));
		battleaxeBronze = new ItemMelee("industrialflow:battleaxeBronze", tabIF, new IFBattleAxe(BronzeToolmat));
		battleaxeIron = new ItemMelee("industrialflow:battleaxeIron", tabIF, new IFBattleAxe(IronToolmat));
		battleaxeCobalt = new ItemMelee("industrialflow:battleaxeCobalt", tabIF, new IFBattleAxe(CobaltToolmat));
		battleaxeNickel = new ItemMelee("industrialflow:battleaxeNickel", tabIF, new IFBattleAxe(NickelToolmat));
		battleaxeTopaz = new ItemMelee("industrialflow:battleaxeTopaz", tabIF, new IFBattleAxe(TopazToolmat));
		battleaxeDiamond = new ItemMelee("industrialflow:battleaxeDiamond", tabIF, new IFBattleAxe(DiamondToolmat));
		battleaxeWSteel = new ItemMelee("industrialflow:battleaxeWSteel", tabIF, new IFBattleAxe(WSteelToolmat));
		battleaxeTitanium = new ItemMelee("industrialflow:battleaxeTitanium", tabIF, new IFBattleAxe(TitaniumToolmat));
		
		battleaxeUltimate = new IFUltimateBattleAxe();
		
		// Pickaxes
		pickFlint = new IFPickaxe("industrialflow:pickFlint", tabIF, FlintToolmat);
		pickCopper = new IFPickaxe("industrialflow:pickCopper", tabIF, CopperToolmat);
		pickBronze = new IFPickaxe("industrialflow:pickBronze", tabIF, BronzeToolmat);
		pickIron = new IFPickaxe("industrialflow:pickIron", tabIF, IronToolmat);
		pickCobalt = new IFPickaxe("industrialflow:pickCobalt", tabIF, CobaltToolmat);
		pickNickel = new IFPickaxe("industrialflow:pickNickel", tabIF, NickelToolmat);
		pickTopaz = new IFPickaxe("industrialflow:pickTopaz", tabIF, TopazToolmat);
		pickDiamond = new IFPickaxe("industrialflow:pickDiamond", tabIF, DiamondToolmat);
		pickWSteel = new IFPickaxe("industrialflow:pickWSteel", tabIF, WSteelToolmat);
		pickTitanium = new IFPickaxe("industrialflow:pickTitanium", tabIF, TitaniumToolmat);
		
		pickUltimate = new IFUltimatePick();
		
		// Broadswords
		broadswordFlint = new IFBroadsword("industrialflow:broadswordFlint", tabIF, FlintToolmat);
		broadswordCopper = new IFBroadsword("industrialflow:broadswordCopper", tabIF, CopperToolmat);
		broadswordBronze = new IFBroadsword("industrialflow:broadswordBronze", tabIF, BronzeToolmat);
		broadswordIron = new IFBroadsword("industrialflow:broadswordIron", tabIF, IronToolmat);
		broadswordCobalt = new IFBroadsword("industrialflow:broadswordCobalt", tabIF, CobaltToolmat);
		broadswordNickel = new IFBroadsword("industrialflow:broadswordNickel", tabIF, NickelToolmat);
		broadswordTopaz = new IFBroadsword("industrialflow:broadswordTopaz", tabIF, TopazToolmat);
		broadswordDiamond = new IFBroadsword("industrialflow:broadswordDiamond", tabIF, DiamondToolmat);
		broadswordWSteel = new IFBroadsword("industrialflow:broadswordWSteel", tabIF, WSteelToolmat);
		broadswordTitanium = new IFBroadsword("industrialflow:broadswordTitanium", tabIF, TitaniumToolmat);
		
		broadswordUltimate = new IFUltimateSword();
		
		// Spades
		spadeFlint = new IFSpade("industrialflow:spadeFlint", tabIF, FlintToolmat);
		spadeCopper = new IFSpade("industrialflow:spadeCopper", tabIF, CopperToolmat);
		spadeBronze = new IFSpade("industrialflow:spadeBronze", tabIF, BronzeToolmat);
		spadeIron = new IFSpade("industrialflow:spadeIron", tabIF, IronToolmat);
		spadeCobalt = new IFSpade("industrialflow:spadeCobalt", tabIF, CobaltToolmat);
		spadeNickel = new IFSpade("industrialflow:spadeNickel", tabIF, NickelToolmat);
		spadeTopaz = new IFSpade("industrialflow:spadeTopaz", tabIF, TopazToolmat);
		spadeDiamond = new IFSpade("industrialflow:spadeDiamond", tabIF, DiamondToolmat);
		spadeWSteel = new IFSpade("industrialflow:spadeWSteel", tabIF, WSteelToolmat);
		spadeTitanium = new IFSpade("industrialflow:spadeTitanium", tabIF, TitaniumToolmat);
		
		spadeUltimate = new IFUltimateSpade();
		
		// Hoes
		hoeFlint = new IFHoe("industrialflow:hoeFlint", tabIF, FlintToolmat);
		hoeCopper = new IFHoe("industrialflow:hoeCopper", tabIF, CopperToolmat);
		hoeBronze = new IFHoe("industrialflow:hoeBronze", tabIF, BronzeToolmat);
		hoeIron = new IFHoe("industrialflow:hoeIron", tabIF, IronToolmat);
		hoeCobalt = new IFHoe("industrialflow:hoeCobalt", tabIF, CobaltToolmat);
		hoeNickel = new IFHoe("industrialflow:hoeNickel", tabIF, NickelToolmat);
		hoeTopaz = new IFHoe("industrialflow:hoeTopaz", tabIF, TopazToolmat);
		hoeDiamond = new IFHoe("industrialflow:hoeDiamond", tabIF, DiamondToolmat);
		hoeWSteel = new IFHoe("industrialflow:hoeWSteel", tabIF, WSteelToolmat);
		hoeTitanium = new IFHoe("industrialflow:hoeTitanium", tabIF, TitaniumToolmat);
		
		hoeUltimate = new IFUltimateHoe();

		// Ores
		
		oreZinc = new IFOre("industrialflow:oreZinc", tabIF, 1.3F, "pickaxe", 1);
		oreCopper = new IFOre("industrialflow:oreCopper", tabIF, 2.2F, "pickaxe", 1);
		oreTin = new IFOre("industrialflow:oreTin", tabIF, 2.6F, "pickaxe", 1);
		oreIron = new IFOre("industrialflow:oreIron", tabIF, 2.9F, "pickaxe", 1);
		oreLead = new IFOre("industrialflow:oreLead", tabIF, 3.1F, "pickaxe", 1);
		
		oreSilver = new IFOre("industrialflow:oreSilver", tabIF, 3.8F, "pickaxe", 2);
		oreGold = new IFOre("industrialflow:oreGold", tabIF, 4.2F, "pickaxe", 2);
		oreCobalt = new IFOre("industrialflow:oreCobalt", tabIF, 4.4F, "pickaxe", 2);
		oreNickel = new IFOre("industrialflow:oreNickel", tabIF, 4.4F, "pickaxe", 2);
		oreCadmium = new IFOre("industrialflow:oreCadmium", tabIF, 4.7F, "pickaxe", 2);
		oreTopaz = new IFOre("industrialflow:oreTopaz", tabIF, 5.3F, "pickaxe", 2, this.gemTopaz);
		oreDiamond = new IFOre("industrialflow:oreDiamond", tabIF, 5.6F, "pickaxe", 2, this.gemDiamond);
		oreGallium = new IFOre("industrialflow:oreGallium", tabIF, 5.6F, "pickaxe", 2, this.dustGallium, 4);
		oreGermanium = new IFOre("industrialflow:oreGermanium", tabIF, 5.8F, "pickaxe", 2, this.dustGermanium, 6);
		
		oreUranium = new IFOre("industrialflow:oreUranium", tabIF, 6F, "pickaxe", 3);
		oreTungsten = new IFOre("industrialflow:oreTungsten", tabIF, 8.5F, "pickaxe", 3);

		orePlatinum = new IFOre("industrialflow:orePlatinum", tabIF, 10.3F, "pickaxe", 4);
		oreTitanium = new IFOre("industrialflow:oreTitanium", tabIF, 12.5F, "pickaxe", 4);
		
		orePalladium = new IFOre("industrialflow:orePalladium", tabIF, 15F, "pickaxe", 5);
		oreRenium = new IFOre("industrialflow:oreRenium", tabIF, 16F, "pickaxe", 5);
		oreRuthenium = new IFOre("industrialflow:oreRuthenium", tabIF, 20F, "pickaxe", 5);
		oreRadium = new IFOre("industrialflow:oreRadium", tabIF, 22F, "pickaxe", 5);
		oreThorium = new IFOre("industrialflow:oreThorium", tabIF, 24F, "pickaxe", 5);
		
		GameRegistry.registerBlock(oreCopper, "OreCopper");
		GameRegistry.registerBlock(oreTin, "OreTin");
		GameRegistry.registerBlock(oreIron, "OreIron");
		GameRegistry.registerBlock(oreLead, "OreLead");
		GameRegistry.registerBlock(oreUranium, "OreUranium");
		GameRegistry.registerBlock(oreTitanium, "OreTitanium");
		GameRegistry.registerBlock(oreCobalt, "OreCobalt");
		GameRegistry.registerBlock(oreNickel, "OreNickel");
		GameRegistry.registerBlock(oreTopaz, "OreTopaz");
		GameRegistry.registerBlock(oreDiamond, "OreDiamond");
		GameRegistry.registerBlock(oreCadmium, "OreCadmium");
		GameRegistry.registerBlock(oreSilver, "OreSilver");
		GameRegistry.registerBlock(oreGold, "OreGold");
		GameRegistry.registerBlock(oreZinc, "OreZinc");
		GameRegistry.registerBlock(orePlatinum, "OrePlatinum");
		GameRegistry.registerBlock(oreGermanium, "OreGermanium");
		GameRegistry.registerBlock(oreGallium, "OreGallium");
		GameRegistry.registerBlock(oreTungsten, "OreTungsten");
		GameRegistry.registerBlock(oreRenium, "OreRenium");
		GameRegistry.registerBlock(orePalladium, "OrePalladium");
		GameRegistry.registerBlock(oreRuthenium, "OreRuthenium");
		GameRegistry.registerBlock(oreRadium, "OreRadium");
		GameRegistry.registerBlock(oreThorium, "OreThorium");
		
		GameRegistry.registerItem(dustGallium, "DustGallium");
		GameRegistry.registerItem(dustGermanium, "DustGermanium");
		GameRegistry.registerItem(gemTopaz, "GemTopaz");
		GameRegistry.registerItem(rodFire, "RodFire");
		GameRegistry.registerItem(rodFlint, "RodFlint");
		GameRegistry.registerItem(rodWooden, "RodWooden");
		GameRegistry.registerItem(rodCadmium, "RodCadmium");
		GameRegistry.registerItem(nuggetPalladium, "NuggetPalladium");
		GameRegistry.registerItem(nuggetRuthenium, "NuggetRuthenium");
		GameRegistry.registerItem(ingotZinc, "IngotZinc");
		GameRegistry.registerItem(ingotCopper, "IngotCopper");
		GameRegistry.registerItem(ingotTin, "IngotTin");
		GameRegistry.registerItem(ingotIron, "IngotIron");
		GameRegistry.registerItem(ingotLead, "IngotLead");
		GameRegistry.registerItem(ingotSilver, "IngotSilver");
		GameRegistry.registerItem(ingotNickel, "IngotNickel");
		GameRegistry.registerItem(ingotCobalt, "IngotCobalt");
		GameRegistry.registerItem(ingotCadmium, "IngotCadmium");
		GameRegistry.registerItem(ingotBronze, "IngotBronze");
		GameRegistry.registerItem(ingotTungsten, "IngotTungsten");
		GameRegistry.registerItem(ingotUranium, "IngotUranium");
		GameRegistry.registerItem(ingotPlatinum, "IngotPlatinum");
		GameRegistry.registerItem(ingotTitanium, "IngotTitanium");
		GameRegistry.registerItem(ingotWSteel, "IngotWSteel");
		GameRegistry.registerItem(ingotPalladium, "IngotPalladium");
		GameRegistry.registerItem(ingotRenium, "IngotRenium");
		GameRegistry.registerItem(ingotRadium, "IngotRadium");
		GameRegistry.registerItem(ingotThorium, "IngotThorium");
		GameRegistry.registerItem(ingotRuthenium, "IngotRuthenium");
		GameRegistry.registerItem(forgeHammer, "ForgeHammer");
		GameRegistry.registerItem(plateCadmium, "PlateCadmium");
		GameRegistry.registerItem(plateTungsten, "PlateTungsten");
		
		GameRegistry.registerItem(axeFlint, "AxeFlint");
		GameRegistry.registerItem(axeCopper, "AxeCopper");
		GameRegistry.registerItem(axeBronze, "AxeBronze");
		GameRegistry.registerItem(axeIron, "AxeIron");
		GameRegistry.registerItem(axeCobalt, "AxeCobalt");
		GameRegistry.registerItem(axeNickel, "AxeNickel");
		GameRegistry.registerItem(axeTopaz, "AxeTopaz");
		GameRegistry.registerItem(axeDiamond, "AxeDiamond");
		GameRegistry.registerItem(axeWSteel, "AxeWSteel");
		GameRegistry.registerItem(axeTitanium, "AxeTitanium");
		
		GameRegistry.registerItem(battleaxeFlint, "BattleaxeFlint");
		GameRegistry.registerItem(battleaxeCopper, "BattleaxeCopper");
		GameRegistry.registerItem(battleaxeBronze, "BattleaxeBronze");
		GameRegistry.registerItem(battleaxeIron, "BattleaxeIron");
		GameRegistry.registerItem(battleaxeCobalt, "BattleaxeCobalt");
		GameRegistry.registerItem(battleaxeNickel, "BattleaxeNickel");
		GameRegistry.registerItem(battleaxeTopaz, "BattleaxeTopaz");
		GameRegistry.registerItem(battleaxeDiamond, "BattleaxeDiamond");
		GameRegistry.registerItem(battleaxeWSteel, "BattleaxeWSteel");
		GameRegistry.registerItem(battleaxeTitanium, "BattleaxeTitanium");
		
		GameRegistry.registerItem(pickFlint, "PickFlint");
		GameRegistry.registerItem(pickCopper, "PickCopper");
		GameRegistry.registerItem(pickBronze, "PickBronze");
		GameRegistry.registerItem(pickIron, "PickIron");
		GameRegistry.registerItem(pickCobalt, "PickCobalt");
		GameRegistry.registerItem(pickNickel, "PickNickel");
		GameRegistry.registerItem(pickTopaz, "PickTopaz");
		GameRegistry.registerItem(pickDiamond, "PickDiamond");
		GameRegistry.registerItem(pickWSteel, "PickWSteel");
		GameRegistry.registerItem(pickTitanium, "PickTitanium");
		
		GameRegistry.registerItem(broadswordFlint, "BroadswordFlint");
		GameRegistry.registerItem(broadswordCopper, "BroadswordCopper");
		GameRegistry.registerItem(broadswordBronze, "BroadswordBronze");
		GameRegistry.registerItem(broadswordIron, "BroadswordIron");
		GameRegistry.registerItem(broadswordCobalt, "BroadswordCobalt");
		GameRegistry.registerItem(broadswordNickel, "BroadswordNickel");
		GameRegistry.registerItem(broadswordTopaz, "BroadswordTopaz");
		GameRegistry.registerItem(broadswordDiamond, "BroadswordDiamond");
		GameRegistry.registerItem(broadswordWSteel, "BroadswordWSteel");
		GameRegistry.registerItem(broadswordTitanium, "BroadswordTitanium");
		
		GameRegistry.registerItem(spadeFlint, "SpadeFlint");
		GameRegistry.registerItem(spadeCopper, "SpadeCopper");
		GameRegistry.registerItem(spadeBronze, "SpadeBronze");
		GameRegistry.registerItem(spadeIron, "SpadeIron");
		GameRegistry.registerItem(spadeCobalt, "SpadeCobalt");
		GameRegistry.registerItem(spadeNickel, "SpadeNickel");
		GameRegistry.registerItem(spadeTopaz, "SpadeTopaz");
		GameRegistry.registerItem(spadeDiamond, "SpadeDiamond");
		GameRegistry.registerItem(spadeWSteel, "SpadeWSteel");
		GameRegistry.registerItem(spadeTitanium, "SpadeTitanium");
		
		GameRegistry.registerItem(hoeFlint, "HoeFlint");
		GameRegistry.registerItem(hoeCopper, "HoeCopper");
		GameRegistry.registerItem(hoeBronze, "HoeBronze");
		GameRegistry.registerItem(hoeIron, "HoeIron");
		GameRegistry.registerItem(hoeCobalt, "HoeCobalt");
		GameRegistry.registerItem(hoeNickel, "HoeNickel");
		GameRegistry.registerItem(hoeTopaz, "HoeTopaz");
		GameRegistry.registerItem(hoeDiamond, "HoeDiamond");
		GameRegistry.registerItem(hoeWSteel, "HoeWSteel");
		GameRegistry.registerItem(hoeTitanium, "HoeTitanium");
		
		GameRegistry.registerItem(axeUltimate, "AxeUltimate");
		GameRegistry.registerItem(battleaxeUltimate, "BattleaxeUltimate");
		GameRegistry.registerItem(pickUltimate, "PickUltimate");
		GameRegistry.registerItem(broadswordUltimate, "BroadswordUltimate");
		GameRegistry.registerItem(spadeUltimate, "SpadeUltimate");
		GameRegistry.registerItem(hoeUltimate, "HoeUltimate");

		GameRegistry.addRecipe(new ItemStack(axeFlint, 1), new Object[]{"MM","MR"," R",('M'), Items.flint, ('R'), rodFlint});
		GameRegistry.addRecipe(new ItemStack(axeCopper, 1), new Object[]{"MM","MR"," R",('M'), ingotCopper, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(axeBronze, 1), new Object[]{"MM","MR"," R",('M'), ingotBronze, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(axeIron, 1), new Object[]{"MM","MR"," R",('M'), ingotIron, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(axeCobalt, 1), new Object[]{"MM","MR"," R",('M'), ingotCobalt, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(axeNickel, 1), new Object[]{"MM","MR"," R",('M'), ingotNickel, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(axeTopaz, 1), new Object[]{"MM","MR"," R",('M'), gemTopaz, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(axeDiamond, 1), new Object[]{"MM","MR"," R",('M'), gemDiamond, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(axeWSteel, 1), new Object[]{"MM","MR"," R",('M'), ingotWSteel, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(axeTitanium, 1), new Object[]{"MM","MR"," R",('M'), ingotTitanium, ('R'), rodWooden});

		GameRegistry.addRecipe(new ItemStack(axeFlint, 1), new Object[]{"MM","RM","R ",('M'), Items.flint, ('R'), rodFlint});
		GameRegistry.addRecipe(new ItemStack(axeCopper, 1), new Object[]{"MM","RM","R ",('M'), ingotCopper, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(axeBronze, 1), new Object[]{"MM","RM","R ",('M'), ingotBronze, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(axeIron, 1), new Object[]{"MM","RM","R ",('M'), ingotIron, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(axeCobalt, 1), new Object[]{"MM","RM","R ",('M'), ingotCobalt, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(axeNickel, 1), new Object[]{"MM","RM","R ",('M'), ingotNickel, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(axeTopaz, 1), new Object[]{"MM","RM","R ",('M'), gemTopaz, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(axeDiamond, 1), new Object[]{"MM","RM","R ",('M'), gemDiamond, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(axeWSteel, 1), new Object[]{"MM","RM","R ",('M'), ingotWSteel, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(axeTitanium, 1), new Object[]{"MM","RM","R ",('M'), ingotTitanium, ('R'), rodWooden});

		GameRegistry.addRecipe(new ItemStack(pickFlint, 1), new Object[]{"MMM"," R "," R ",('M'), Items.flint, ('R'), rodFlint});
		GameRegistry.addRecipe(new ItemStack(pickCopper, 1), new Object[]{"MMM"," R "," R ",('M'), ingotCopper, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(pickBronze, 1), new Object[]{"MMM"," R "," R ",('M'), ingotBronze, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(pickIron, 1), new Object[]{"MMM"," R "," R ",('M'), ingotIron, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(pickCobalt, 1), new Object[]{"MMM"," R "," R ",('M'), ingotCobalt, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(pickNickel, 1), new Object[]{"MMM"," R "," R ",('M'), ingotNickel, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(pickTopaz, 1), new Object[]{"MMM"," R "," R ",('M'), gemTopaz, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(pickDiamond, 1), new Object[]{"MMM"," R "," R ",('M'), gemDiamond, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(pickWSteel, 1), new Object[]{"MMM"," R "," R ",('M'), ingotWSteel, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(pickTitanium, 1), new Object[]{"MMM"," R "," R ",('M'), ingotTitanium, ('R'), rodWooden});

		GameRegistry.addRecipe(new ItemStack(broadswordFlint, 1), new Object[]{"M","M","R",('M'), Items.flint, ('R'), rodFlint});
		GameRegistry.addRecipe(new ItemStack(broadswordCopper, 1), new Object[]{"M","M","R",('M'), ingotCopper, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(broadswordBronze, 1), new Object[]{"M","M","R",('M'), ingotBronze, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(broadswordIron, 1), new Object[]{"M","M","R",('M'), ingotIron, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(broadswordCobalt, 1), new Object[]{"M","M","R",('M'), ingotCobalt, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(broadswordNickel, 1), new Object[]{"M","M","R",('M'), ingotNickel, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(broadswordTopaz, 1), new Object[]{"M","M","R",('M'), gemTopaz, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(broadswordDiamond, 1), new Object[]{"M","M","R",('M'), gemDiamond, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(broadswordWSteel, 1), new Object[]{"M","M","R",('M'), ingotWSteel, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(broadswordTitanium, 1), new Object[]{"M","M","R",('M'), ingotTitanium, ('R'), rodWooden});

		GameRegistry.addRecipe(new ItemStack(spadeFlint, 1), new Object[]{"M","R","R",('M'), Items.flint, ('R'), rodFlint});
		GameRegistry.addRecipe(new ItemStack(spadeCopper, 1), new Object[]{"M","R","R",('M'), ingotCopper, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(spadeBronze, 1), new Object[]{"M","R","R",('M'), ingotBronze, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(spadeIron, 1), new Object[]{"M","R","R",('M'), ingotIron, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(spadeCobalt, 1), new Object[]{"M","R","R",('M'), ingotCobalt, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(spadeNickel, 1), new Object[]{"M","R","R",('M'), ingotNickel, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(spadeTopaz, 1), new Object[]{"M","R","R",('M'), gemTopaz, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(spadeDiamond, 1), new Object[]{"M","R","R",('M'), gemDiamond, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(spadeWSteel, 1), new Object[]{"M","R","R",('M'), ingotWSteel, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(spadeTitanium, 1), new Object[]{"M","R","R",('M'), ingotTitanium, ('R'), rodWooden});

		GameRegistry.addRecipe(new ItemStack(hoeFlint, 1), new Object[]{"MM"," R"," R",('M'), Items.flint, ('R'), rodFlint});
		GameRegistry.addRecipe(new ItemStack(hoeCopper, 1), new Object[]{"MM"," R"," R",('M'), ingotCopper, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(hoeBronze, 1), new Object[]{"MM"," R"," R",('M'), ingotBronze, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(hoeIron, 1), new Object[]{"MM"," R"," R",('M'), ingotIron, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(hoeCobalt, 1), new Object[]{"MM"," R"," R",('M'), ingotCobalt, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(hoeNickel, 1), new Object[]{"MM"," R"," R",('M'), ingotNickel, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(hoeTopaz, 1), new Object[]{"MM"," R"," R",('M'), gemTopaz, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(hoeDiamond, 1), new Object[]{"MM"," R"," R",('M'), gemDiamond, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(hoeWSteel, 1), new Object[]{"MM"," R"," R",('M'), ingotWSteel, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(hoeTitanium, 1), new Object[]{"MM"," R"," R",('M'), ingotTitanium, ('R'), rodWooden});

		GameRegistry.addRecipe(new ItemStack(hoeFlint, 1), new Object[]{"MM","R ","R ",('M'), Items.flint, ('R'), rodFlint});
		GameRegistry.addRecipe(new ItemStack(hoeCopper, 1), new Object[]{"MM","R ","R ",('M'), ingotCopper, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(hoeBronze, 1), new Object[]{"MM","R ","R ",('M'), ingotBronze, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(hoeIron, 1), new Object[]{"MM","R ","R ",('M'), ingotIron, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(hoeCobalt, 1), new Object[]{"MM","R ","R ",('M'), ingotCobalt, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(hoeNickel, 1), new Object[]{"MM","R ","R ",('M'), ingotNickel, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(hoeTopaz, 1), new Object[]{"MM","R ","R ",('M'), gemTopaz, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(hoeDiamond, 1), new Object[]{"MM","R ","R ",('M'), gemDiamond, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(hoeWSteel, 1), new Object[]{"MM","R ","R ",('M'), ingotWSteel, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(hoeTitanium, 1), new Object[]{"MM","R ","R ",('M'), ingotTitanium, ('R'), rodWooden});
		
		GameRegistry.addRecipe(new ItemStack(battleaxeCopper, 1), new Object[]{"MMM","MRM"," R ",('M'), ingotCopper, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(battleaxeFlint, 1), new Object[]{"MMM","MRM"," R ",('M'), Items.flint, ('R'), rodFlint});
		GameRegistry.addRecipe(new ItemStack(battleaxeBronze, 1), new Object[]{"MMM","MRM"," R ",('M'), ingotBronze, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(battleaxeIron, 1), new Object[]{"MMM","MRM"," R ",('M'), ingotIron, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(battleaxeCobalt, 1), new Object[]{"MMM","MRM"," R ",('M'), ingotCobalt, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(battleaxeNickel, 1), new Object[]{"MMM","MRM"," R ",('M'), ingotNickel, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(battleaxeTopaz, 1), new Object[]{"MMM","MRM"," R ",('M'), gemTopaz, ('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(battleaxeDiamond, 1), new Object[]{"MMM","MRM"," R ",('M'), gemDiamond, ('R'), rodWooden});
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
		
		GameRegistry.addSmelting(oreZinc, new ItemStack(ingotZinc), 0.15F);
		GameRegistry.addSmelting(oreCopper, new ItemStack(ingotCopper), 0.3F);
		GameRegistry.addSmelting(oreTin, new ItemStack(ingotTin), 0.3F);
		GameRegistry.addSmelting(oreIron, new ItemStack(ingotIron), 0.4F);
		GameRegistry.addSmelting(oreGold, new ItemStack(ingotGold), 0.45F);
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

		GameRegistry.addRecipe(new ItemStack(ingotPalladium, 1), new Object[]{"MMM","MMM","MMM",('M'), nuggetPalladium});
		GameRegistry.addRecipe(new ItemStack(ingotRuthenium, 1), new Object[]{"MMM","MMM","MMM",('M'), nuggetRuthenium});
		GameRegistry.addRecipe(new ItemStack(forgeHammer, 64), new Object[]{"MM ","MRR","MM ",('M'), ingotTin,('R'), rodWooden});
		GameRegistry.addRecipe(new ItemStack(rodCadmium, 8), new Object[]{"P","P",('P'), plateCadmium});
		GameRegistry.addRecipe(new ItemStack(Blocks.torch, 3), new Object[]{"F","R",('F'), Items.flint,('R'),rodWooden});
		GameRegistry.addShapelessRecipe(new ItemStack(rodWooden, 3), new Object[] {Items.stick});
		GameRegistry.addShapelessRecipe(new ItemStack(rodFire, 9), new Object[] {Items.stick, Items.stick, Items.stick, Items.blaze_powder});
		GameRegistry.addShapelessRecipe(new ItemStack(rodFlint, 3), new Object[] {Blocks.planks, Items.flint});
		GameRegistry.addShapelessRecipe(new ItemStack(nuggetPalladium, 9), new Object[] {ingotPalladium});
		GameRegistry.addShapelessRecipe(new ItemStack(nuggetRuthenium, 9), new Object[] {ingotRuthenium});
		GameRegistry.addShapelessRecipe(new ItemStack(plateCadmium, 1), new Object[] {forgeHammer, ingotCadmium});
		GameRegistry.addShapelessRecipe(new ItemStack(plateTungsten, 1), new Object[] {forgeHammer, ingotTungsten});
		
		cadmiumGen = new IFGenerator(oreCadmium, true, false, false, 1, 64, 6, 6);
		reniumGen = new IFGenerator(oreRenium, true, false, false, 1, 48, 4, 3);
		thoriumGen = new IFGenerator(oreThorium, false, false, true, 1, 52, 4, 4);
		radiumGen = new IFGenerator(oreRadium, false, false, true, 1, 70, 4, 5);
		
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
