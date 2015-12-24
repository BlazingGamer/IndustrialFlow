package cf.blazegamer.mctoontown;

import cpw.mods.fml.common.Mod;

@Mod(modid = "ttmc", version = "0.1", name = "Minecraft: Toontown Warfare")

public class TTMCBase {
	TTMCPlayground ToonTorialSecretArea = new TTMCPlayground("ToonTorial", 0, null);
	TTMCPlayground ToonTorial = new TTMCPlayground("ToonTorial", 1, new TutorNPC());
	TTMCPlayground ToontownCentral = new TTMCPlayground("TTC", 2, new MickieNPC());
	TTMCPlayground DonaldDock = new TTMCPlayground("DonaldDock", 3, new DonaldShipNPC());
	TTMCPlayground DaisyGardens = new TTMCPlayground("DaisyGarden", 4, new DaisyNPC());
	TTMCPlayground MinnieMelodyland = new TTMCPlayground("MML", 5, new MinnieNPC());
	TTMCPlayground TheBrrrgh = new TTMCPlayground("Brrrgh", 6, new PlutoNPC());
	TTMCPlayground DonaldDreamland = new TTMCPlayground("DDL", 7, new DonaldSleepNPC());
	TTMCPlayground ChipNDaleAcornAcres = new TTMCPlayground("CDAA", 8, new ChipNPC());
	TTMCPlayground ChipNDaleMiniGolf = new TTMCPlayground("CDMG", 998, new DaleNPC());
	TTMCPlayground GoofySpeedway = new TTMCPlayground("GSW", 999, new GoofyNPC());
	
	TTMCCogNation SellbotHQ = new TTMCCogNation("SBHQ", 1000, 4, 6, "sellbot", false);
	TTMCCogNation CashbotHQ = new TTMCCogNation("CBHQ", 1001, 7, 9, "cashbot", false);
	TTMCCogNation LawbotHQ = new TTMCCogNation("LBHQ", 1002, 8, 10, "lawbot", true);
	TTMCCogNation BossbotHQ = new TTMCCogNation("BBHQ", 1003, 8, 11, "bossbot", true);
	
	TTMCStreet NewToonNook = new TTMCStreet(ToonTorialSecretArea, ToonTorial, 1, 1, 0, 0, 0, 100, "New Toon Nook", false);
	
	TTMCStreet StartStreet = new TTMCStreet(ToonTorial, ToontownCentral, 1, 3, 25, 25, 25, 25, "Start Street", true);
	TTMCStreet MinigolfMotorway = new TTMCStreet(ToonTorial, ChipNDaleMiniGolf, 1, 3, 40, 40, 10, 10, "Minigolf Motorway", true);
	TTMCStreet RacingRoad = new TTMCStreet(ToonTorial, GoofySpeedway, 1, 3, 10, 10, 40, 40, "Racing Road", true);
	
	TTMCStreet CoggySlope = new TTMCStreet(ChipNDaleMiniGolf, ToonTorial, 2, 3, 25, 25, 25, 25, "Coggy Slope", true);
	
	TTMCStreet BattleBackstreet = new TTMCStreet(GoofySpeedway, ToonTorial, 2, 3, 25, 25, 25, 25, "BattleBackstreet", true);
	
	TTMCStreet WavyWay = new TTMCStreet(ToontownCentral, ToonTorial, 2, 5, 5, 25, 25, 45, "Wavy Way", true);
	TTMCStreet PunchlinePlace = new TTMCStreet(ToontownCentral, DonaldDock, 2, 5, 40, 40, 10, 10, "Punchline Place", true);
	TTMCStreet LoopyLane = new TTMCStreet(ToontownCentral, MinnieMelodyland, 2, 5, 10, 10, 70, 10, "Loopy Lane", true);
	
	TTMCStreet BarnacleBoulevard = new TTMCStreet(DonaldDock, ToontownCentral, 3, 5, 0, 0, 10, 90, "Barnacle Boulevard", true);
	TTMCStreet SeaweedStreet = new TTMCStreet(DonaldDock, DaisyGardens, 4, 6, 10, 90, 0, 0, "Seaweed Street", true);
	TTMCStreet LighthouseLine = new TTMCStreet(DonaldDock, TheBrrrgh, 4, 7, 10, 10, 40, 40, "Lighthouse Lane", true);
	
	TTMCStreet ElmStreet = new TTMCStreet(DaisyGardens, ChipNDaleAcornAcres, 3, 5, 30, 20, 10, 40, "Elm Street", true);
	TTMCStreet MapleStreet = new TTMCStreet(DaisyGardens, DonaldDock, 4, 6, 20, 10, 70, 0, "Maple Street", true);
	TTMCStreet OakStreet = new TTMCStreet(DaisyGardens, SellbotHQ, 4, 7, 85, 5, 5, 5, "Oak Street", true);
	
	TTMCStreet AltoAvenue = new TTMCStreet(MinnieMelodyland, ToontownCentral, 3, 5, 50, 50, 0, 0, "Alto Avenue", true);
	TTMCStreet BaritoneBoulevard = new TTMCStreet(MinnieMelodyland, TheBrrrgh, 4, 6, 10, 90, 0, 0, "Baritone Boulevard", true);
	TTMCStreet TenorTrack = new TTMCStreet(MinnieMelodyland, DonaldDreamland, 3, 5, 0, 0, 50, 50, "Tenor Terrace", true);
	
	TTMCStreet WalrusWay = new TTMCStreet(TheBrrrgh, DonaldDock, 5, 7, 0, 0, 10, 90, "Walrus Way", true);
	TTMCStreet SleetStreet = new TTMCStreet(TheBrrrgh, MinnieMelodyland, 5, 8, 40, 30, 20, 10, "Sleet Street", true);
	TTMCStreet PolarPlace = new TTMCStreet(TheBrrrgh, LawbotHQ, 7, 9, 5, 5, 85, 5, "Polar Place", true);
	
	TTMCStreet LullabyLane = new TTMCStreet(DonaldDreamland, MinnieMelodyland, 6, 8, 25, 25, 25, 25, "Lullaby Lane", true);
	TTMCStreet PajamaPath = new TTMCStreet(DonaldDreamland, CashbotHQ, 6, 9, 5, 85, 5, 5, "Pajama Path", true);
	TTMCStreet ChipmunkCorner = new TTMCStreet(DonaldDreamland, ChipNDaleAcornAcres, 5, 9, 35, 15, 35, 15, "Chipmunk Corner", true);
	
	TTMCStreet FieldHighway = new TTMCStreet(ChipNDaleAcornAcres, BossbotHQ, 7, 10, 5, 5, 5, 85, "Field Highway", true);
	TTMCStreet SleepyDriveway = new TTMCStreet(ChipNDaleAcornAcres, DonaldDreamland, 7, 10, 15, 35, 15, 35, "Sleepy Driveway", true);
	TTMCStreet ForestRoute = new TTMCStreet(ChipNDaleAcornAcres, DaisyGardens, 7, 10, 20, 30, 40, 10, "Field Highway", true);
	
	void chooseRandomCog(TTMCStreet street, TTMCInvasion current_invasion) {
		int firstwo = street.getChanceSB() + street.getChanceCB();
		int firsthree = firstwo + street.getChanceLB();
		int all = firsthree + street.getChanceBB();
		double random = Math.floor(Math.random() * 100);
	}
}
