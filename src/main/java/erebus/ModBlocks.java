package erebus;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCompressed;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import erebus.block.BlockAltar;
import erebus.block.BlockAmber;
import erebus.block.BlockBambooBridge;
import erebus.block.BlockBambooCrate;
import erebus.block.BlockBambooCrop;
import erebus.block.BlockBambooLadder;
import erebus.block.BlockBambooPole;
import erebus.block.BlockBambooShoot;
import erebus.block.BlockBambooTorch;
import erebus.block.BlockBones;
import erebus.block.BlockButtonUmberstone;
import erebus.block.BlockDoorAmber;
import erebus.block.BlockDoubleHeightPlant;
import erebus.block.BlockErebusAltar;
import erebus.block.BlockErebusAltarHealing;
import erebus.block.BlockErebusAltarLightning;
import erebus.block.BlockErebusAltarRepair;
import erebus.block.BlockErebusAltarXP;
import erebus.block.BlockErebusFlower;
import erebus.block.BlockErebusGrass;
import erebus.block.BlockErebusHoney;
import erebus.block.BlockErebusMushroomCap;
import erebus.block.BlockErebusOre;
import erebus.block.BlockErebusOreExtras;
import erebus.block.BlockErebusStigma;
import erebus.block.BlockExtenderThingy;
import erebus.block.BlockFern;
import erebus.block.BlockFiddlehead;
import erebus.block.BlockGhostSand;
import erebus.block.BlockGlowGem;
import erebus.block.BlockGlowingJar;
import erebus.block.BlockGneiss;
import erebus.block.BlockHollowLog;
import erebus.block.BlockHoneyComb;
import erebus.block.BlockHoneyTreat;
import erebus.block.BlockInsectRepellent;
import erebus.block.BlockLeavesErebus;
import erebus.block.BlockMucusBomb;
import erebus.block.BlockMud;
import erebus.block.BlockOreFossil;
import erebus.block.BlockPetrifiedChest;
import erebus.block.BlockPetrifiedCraftingTable;
import erebus.block.BlockPlanksErebus;
import erebus.block.BlockPlantedGiantFlower;
import erebus.block.BlockPortalErebus;
import erebus.block.BlockQuickSand;
import erebus.block.BlockRedGem;
import erebus.block.BlockSimple;
import erebus.block.BlockSlabPetrifiedWood;
import erebus.block.BlockSlabPlanksErebus;
import erebus.block.BlockSlabStoneErebus;
import erebus.block.BlockSmallPlants;
import erebus.block.BlockSpiderSpawner;
import erebus.block.BlockStairsBase;
import erebus.block.BlockThorns;
import erebus.block.BlockTurnip;
import erebus.block.BlockUmberFurnace;
import erebus.block.BlockUmberGolemStatue;
import erebus.block.BlockUmberPaver;
import erebus.block.BlockUmberstone;
import erebus.block.BlockUmberstonePillar;
import erebus.block.BlockVelocity;
import erebus.block.BlockWallErebus;
import erebus.block.BlockWaspNest;
import erebus.block.BlockWaspSpawner;
import erebus.block.BlockWitherWeb;
import erebus.block.JarOHoney;
import erebus.item.block.ItemBlockAmber;
import erebus.item.block.ItemBlockColoredSingle;
import erebus.item.block.ItemBlockDoubleHeightPlant;
import erebus.item.block.ItemBlockErebusFlower;
import erebus.item.block.ItemBlockErebusPlantSmall;
import erebus.item.block.ItemBlockErebusStigma;
import erebus.item.block.ItemBlockFlowerPlanted;
import erebus.item.block.ItemBlockGeneric;
import erebus.item.block.ItemBlockPlanks;
import erebus.item.block.ItemBlockSlabPetrifiedWood;
import erebus.item.block.ItemBlockSlabPlanks0Erebus;
import erebus.item.block.ItemBlockSlabPlanks1Erebus;
import erebus.item.block.ItemBlockSlabStoneErebus;
import erebus.item.block.ItemBlockWitherWeb;
import erebus.lib.EnumWood;
import erebus.lib.Reference;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks {

	// FLUIDS
	public static Fluid erebusHoney;

	// PORTAL
	public static BlockPortalErebus portalErebus;

	// TERRAIN AND ORES
	public static Block umberstone, umberOreBlock, oreFossil, redGem, blockAmber, quickSand, ghostSand, erebusOreExtra, umberstoneButton;

	// WOOD
	public static Block planksErebus, hollowLogAcacia, erebusFlower, erebusStigma;
	public static BlockLeavesErebus leavesErebus;

	// UNDERGROWTH
	public static Block erebusGrass, thorns, blockTurnip, fiddlehead, erebusPlantSmall;
	public static BlockFern fern;
	public static Block doubleHeightPlant, erebusMushroomCap0, erebusMushroomCap1, erebusMushroomCap2, erebusMushroomCap3, erebusMushroomCap4;

	// DECORATIONS AND UTILITIES
	public static Block blockSilk, mirBrick, petrifiedWoodPlanks, petrifiedCraftingTable, bambooCrate, umberFurnace, umberFurnace_on;
	public static Block umberPaver, insectRepellent, bambooShoot, bambooCrop, bambooTorch, erebusAltar, erebusAltarLightning;
	public static Block erebusAltarHealing, erebusAltarXP, erebusAltarRepair, glowingJar, reinExo, bambooLadder, bambooBridge;
	public static Block umberGolemStatue, petrifiedWoodChest, blockBones, blockWitherWeb, extenderThingy, bambooPole, umberstonePillar;
	public static Block velocityBlock, honeyCombBlock, doorAmber, erebusHoneyBlock, honeyTreat, mud, mudBricks, flowerPlanted, jarOHoney;
	public static Block jadeBlock, altar, glowGemBlock, mucusBomb;

	// STAIRS, SLABS, WALLS
	public static Block[] umbercobbleStairs, stoneSlabs, plankSlabs, petrifiedWoodSlab, gneissStairs;
	public static Block wallErebus, petrifiedWoodStairs, amberBrickStairs, waspNestStairs;

	// DUNGEONS
	public static Block spiderSpawner, jumpingSpiderSpawner, waspSpawner, waspNestBlock, gneiss;

	public static void init() {
		registerFluids();
		initBlocks();
		initCreativeTabs();
		registerBlocks();
		registerProperties();
	}

	private static void initBlocks() {
		portalErebus = (BlockPortalErebus) new BlockPortalErebus().setHardness(-1F).setLightLevel(1.0F).setStepSound(Block.soundTypeGlass).setBlockName("portalErebus");

		umberstone = new BlockUmberstone().setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypeStone).setBlockName("umberstone");
		umberOreBlock = new BlockErebusOre().setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone).setBlockName("oreBlockU");
		oreFossil = new BlockOreFossil().setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypeStone).setBlockName("oreFossilU").setBlockTextureName("erebus:oreFossilU");
		redGem = new BlockRedGem().setHardness(0.3F).setLightLevel(1F).setStepSound(Block.soundTypeGlass).setBlockName("redGem");
		blockAmber = new BlockAmber().setHardness(1.5F).setResistance(10.0F).setLightOpacity(3).setStepSound(Block.soundTypeGlass).setBlockName("blockAmber");
		quickSand = new BlockQuickSand().setHardness(28F).setStepSound(Block.soundTypeSand).setBlockName("quickSand").setBlockTextureName("erebus:quickSand");
		ghostSand = new BlockGhostSand().setHardness(0.42F).setStepSound(Block.soundTypeSand).setBlockName("ghostSand").setBlockTextureName("erebus:ghostSand");
		erebusOreExtra = new BlockErebusOreExtras().setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypeStone).setBlockName("erebusOreExtras");
		umberstoneButton = new BlockButtonUmberstone().setHardness(0.5F).setStepSound(Block.soundTypeStone).setBlockName("umberstoneButton");
		gneiss = new BlockGneiss().setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypeStone).setBlockName("gneiss");

		planksErebus = new BlockPlanksErebus().setHardness(2.0F).setStepSound(Block.soundTypeWood);
		EnumWood.initBlocks();
		leavesErebus = (BlockLeavesErebus) new BlockLeavesErebus().setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundTypeGrass).setBlockName("leavesErebus");
		hollowLogAcacia = new BlockHollowLog().setHardness(0.7F).setStepSound(Block.soundTypeWood).setBlockName("hollowLogAcacia");
		erebusFlower = new BlockErebusFlower().setHardness(1.0F).setStepSound(Block.soundTypeGrass).setBlockName("erebusFlower");
		flowerPlanted = new BlockPlantedGiantFlower().setHardness(0.0F).setStepSound(Block.soundTypeGrass).setBlockName("flowerPlanted");
		erebusStigma = new BlockErebusStigma().setHardness(1.0F).setStepSound(Block.soundTypeGrass).setBlockName("erebusStigma");
		erebusPlantSmall = new BlockSmallPlants().setHardness(0.0F).setStepSound(Block.soundTypeGrass).setBlockName("erebusPlantSmall");
		erebusMushroomCap0 = new BlockErebusMushroomCap(0).setHardness(0.2F).setStepSound(Block.soundTypeWood).setBlockName("mushroomBulbCap");
		erebusMushroomCap1 = new BlockErebusMushroomCap(1).setHardness(0.2F).setStepSound(Block.soundTypeWood).setBlockName("mushroom1Cap");
		erebusMushroomCap2 = new BlockErebusMushroomCap(2).setHardness(0.2F).setStepSound(Block.soundTypeWood).setBlockName("mushroom2Cap");
		erebusMushroomCap3 = new BlockErebusMushroomCap(3).setHardness(0.2F).setStepSound(Block.soundTypeWood).setBlockName("mushroom3Cap");
		erebusMushroomCap4 = new BlockErebusMushroomCap(4).setHardness(0.2F).setStepSound(Block.soundTypeWood).setBlockName("mushroom4Cap");
		doubleHeightPlant = new BlockDoubleHeightPlant().setHardness(0.0F).setStepSound(Block.soundTypeGrass).setBlockName("doubleHeightPlant");
		erebusGrass = new BlockErebusGrass().setHardness(0.0F).setStepSound(Block.soundTypeGrass).setBlockName("erebusTallGrass").setBlockTextureName("erebus:tallgrass");
		thorns = new BlockThorns().setHardness(0.2F).setStepSound(Block.soundTypeGrass).setBlockName("thorns").setBlockTextureName("erebus:thorns");
		fern = (BlockFern) new BlockFern().setHardness(0.0F).setStepSound(Block.soundTypeGrass).setBlockName("erebusFern");
		blockTurnip = new BlockTurnip().setBlockName("turnips");
		fiddlehead = new BlockFiddlehead().setHardness(0.0F).setStepSound(Block.soundTypeGrass).setBlockName("erebusFiddlehead");

		blockSilk = new BlockSimple(Material.cloth).setHardness(0.2F).setStepSound(Block.soundTypeCloth).setBlockName("blockSilk").setBlockTextureName("erebus:blockSilk");
		mirBrick = new BlockSimple(Material.rock).setHardness(1.5F).setResistance(100.0F).setStepSound(Block.soundTypeStone).setBlockName("mirbrick").setBlockTextureName("erebus:mirbrick");
		petrifiedWoodPlanks = new BlockSimple(Material.rock).setHardness(2.0F).setStepSound(Block.soundTypeWood).setBlockName("petrifiedWoodPlanks").setBlockTextureName("erebus:petrifiedWoodPlanks");
		petrifiedCraftingTable = new BlockPetrifiedCraftingTable().setHardness(2.5F).setStepSound(Block.soundTypeStone).setBlockName("petrifiedCraftingTable");
		bambooCrate = new BlockBambooCrate().setHardness(2.0F).setStepSound(Block.soundTypeWood).setBlockName("bambooCrate");
		umberFurnace = new BlockUmberFurnace(false).setHardness(3.5F).setStepSound(Block.soundTypeStone).setBlockName("umberFurnaceOFF");
		umberFurnace_on = new BlockUmberFurnace(true).setHardness(3.5F).setStepSound(Block.soundTypeStone).setBlockName("umberFurnaceON");
		umberPaver = new BlockUmberPaver().setHardness(3.5F).setStepSound(Block.soundTypeStone).setBlockName("umberPaver");
		insectRepellent = new BlockInsectRepellent().setBlockName("insectRepellent");
		bambooShoot = new BlockBambooShoot().setCreativeTab(null).setBlockName("bambooShoot").setBlockTextureName("erebus:bambooShoot");
		bambooCrop = new BlockBambooCrop().setHardness(1.0F).setStepSound(Block.soundTypeWood).setBlockName("bambooCrop").setBlockTextureName("erebus:bambooCropBase");
		bambooTorch = new BlockBambooTorch().setHardness(0.0F).setBlockName("bambooTorch");
		erebusAltar = new BlockErebusAltar().setHardness(20.0F).setBlockName("erebusAltar");
		erebusAltarLightning = new BlockErebusAltarLightning().setHardness(20.0F).setBlockName("erebusAltarLightning");
		erebusAltarHealing = new BlockErebusAltarHealing().setHardness(20.0F).setBlockName("erebusAltarHealing");
		erebusAltarXP = new BlockErebusAltarXP().setHardness(20.0F).setBlockName("erebusAltarXP");
		erebusAltarRepair = new BlockErebusAltarRepair().setHardness(20.0F).setBlockName("erebusAltarRepair");
		glowingJar = new BlockGlowingJar().setBlockName("glowingJar").setBlockTextureName("erebus:glassAmber");
		reinExo = new BlockSimple(Material.rock).setHardness(1.5F).setResistance(2000.0F).setStepSound(Block.soundTypeStone).setBlockName("reinExo").setBlockTextureName("erebus:blockReinExo");
		bambooLadder = new BlockBambooLadder().setHardness(0.4F).setStepSound(Block.soundTypeLadder).setBlockName("bambooLadder").setBlockTextureName("erebus:bambooLadder");
		umberGolemStatue = new BlockUmberGolemStatue().setBlockName("umberGolemStatue");
		waspNestBlock = new BlockWaspNest().setHardness(50.0F).setResistance(2000.0F).setStepSound(Block.soundTypeStone).setBlockName("waspNestBlock").setBlockTextureName("erebus:waspNestBlock");
		petrifiedWoodChest = new BlockPetrifiedChest().setHardness(2.0F).setBlockName("petrifiedWoodChest").setBlockTextureName("erebus:petrifiedWoodPlanks");
		blockBones = new BlockBones().setBlockName("blockBones");
		blockWitherWeb = new BlockWitherWeb().setHardness(4.0F).setBlockName("witherWeb").setBlockTextureName("web");
		bambooBridge = new BlockBambooBridge().setHardness(0.4F).setStepSound(Block.soundTypeLadder).setBlockName("bambooBridge").setBlockTextureName("erebus:bambooBridge");
		extenderThingy = new BlockExtenderThingy().setHardness(0.4F).setStepSound(Block.soundTypeLadder).setBlockName("extenderThingy").setBlockTextureName("erebus:extenderThingy");
		bambooPole = new BlockBambooPole().setHardness(0.4F).setBlockName("bambooPole").setBlockTextureName("erebus:blockBambooPole");
		umberstonePillar = new BlockUmberstonePillar().setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypeStone).setBlockName("umberstonePillar").setBlockTextureName("erebus:umberstonePillarSides");
		velocityBlock = new BlockVelocity().setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypeStone).setBlockName("velocityBlock").setBlockTextureName("erebus:blockSpeed0");
		honeyCombBlock = new BlockHoneyComb().setHardness(0.5F).setResistance(10.0F).setStepSound(Block.soundTypeCloth).setBlockName("honeyCombBlock").setBlockTextureName("erebus:honeyCombTop");
		doorAmber = new BlockDoorAmber(Material.glass).setBlockName("doorAmber").setBlockTextureName("erebus:doorAmber");
		erebusHoneyBlock = new BlockErebusHoney(erebusHoney).setBlockName("erebusHoney");
		mud = new BlockMud().setBlockName("erebusMud").setBlockTextureName("erebus:mud");
		mudBricks = new BlockSimple(Material.rock).setBlockName("erebus.mudBricks").setBlockTextureName("erebus:mudBricks").setHardness(0.8F).setResistance(1.0F);
		honeyTreat = new BlockHoneyTreat().setHardness(0.5F).setStepSound(Block.soundTypeCloth).setBlockName("honeyTreat").setBlockTextureName("erebus:honeyTreat");
		jarOHoney = new JarOHoney().setHardness(0.5F).setBlockName("erebus.jarOHoney").setBlockTextureName("erebus:glassAmber");
		jadeBlock = new BlockCompressed(MapColor.greenColor).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setBlockName("erebus.blockJade").setBlockTextureName("erebus:blockJade");
		altar = new BlockAltar().setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeStone).setBlockName("erebus.altar").setBlockTextureName("stone");
		glowGemBlock = new BlockGlowGem().setBlockName("erebus.glowGemBlock").setBlockTextureName("erebus:glowGem");
		mucusBomb = new BlockMucusBomb().setBlockName("erebus.mucusBomb");

		umbercobbleStairs = new Block[BlockUmberstone.iconPaths.length];
		for (int i = 0; i < umbercobbleStairs.length; i++)
			umbercobbleStairs[i] = new BlockStairsBase(umberstone, i).setStepSound(Block.soundTypeStone).setBlockName("umbercobbleStairs" + i);
		petrifiedWoodStairs = new BlockStairsBase(petrifiedWoodPlanks, 0).setStepSound(Block.soundTypeWood).setBlockName("petrifiedWoodStairs");
		stoneSlabs = new Block[2];
		for (int i = 0; i < 2; i++)
			stoneSlabs[i] = new BlockSlabStoneErebus(i == 1).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypeStone).setBlockName("slabStoneErebus");
		plankSlabs = new Block[4];
		for (int i = 0; i < 4; i++)
			plankSlabs[i] = new BlockSlabPlanksErebus((int) Math.floor(i / 2f), i % 2 == 1).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setBlockName("slabPlanksErebus");
		wallErebus = new BlockWallErebus().setBlockName("wallErebus");
		petrifiedWoodSlab = new Block[2];
		for (int i = 0; i < petrifiedWoodSlab.length; i++)
			petrifiedWoodSlab[i] = new BlockSlabPetrifiedWood(i == 1).setBlockName("petrifiedWoodSlab");
		amberBrickStairs = new BlockStairsBase(blockAmber, 2).setStepSound(Block.soundTypeStone).setBlockName("amberBrickStairs");
		waspNestStairs = new BlockStairsBase(waspNestBlock, 2).setHardness(50.0F).setStepSound(Block.soundTypeStone).setBlockName("waspNestStairs");
		gneissStairs = new Block[BlockGneiss.iconPaths.length];
		for (int i = 0; i < gneissStairs.length; i++)
			gneissStairs[i] = new BlockStairsBase(gneiss, i).setStepSound(Block.soundTypeStone).setBlockName("gneissStairs" + i);

		spiderSpawner = new BlockSpiderSpawner("Scytodes - Erebus").setBlockName("spiderSpawner").setBlockTextureName("erebus:spiderSpawner");
		jumpingSpiderSpawner = new BlockSpiderSpawner("JumpingSpider - Erebus").setBlockName("jumpingSpiderSpawner").setBlockTextureName("erebus:spiderSpawner");
		waspSpawner = new BlockWaspSpawner("Wasp - Erebus").setBlockName("waspSpawner").setBlockTextureName("erebus:waspNestSpawner");
	}

	private static void initCreativeTabs() {
		ModTabs.blocks.setTab(umberstone, umberOreBlock, oreFossil, erebusOreExtra, redGem, blockAmber, quickSand, ghostSand);
		ModTabs.blocks.setTab(hollowLogAcacia, planksErebus, leavesErebus);
		ModTabs.blocks.setTab(erebusGrass, fern, fiddlehead, thorns, erebusFlower, erebusStigma, doubleHeightPlant, erebusPlantSmall);
		ModTabs.blocks.setTab(erebusMushroomCap0, erebusMushroomCap1, erebusMushroomCap2); //,erebusMushroomCap3, erebusMushroomCap4
		ModTabs.blocks.setTab(blockSilk, mirBrick, petrifiedWoodPlanks, petrifiedCraftingTable, bambooCrop, bambooCrate, bambooLadder);
		ModTabs.blocks.setTab(bambooBridge, bambooPole, bambooTorch, glowingJar, umberstoneButton, umberFurnace, umberPaver, erebusAltar);
		ModTabs.blocks.setTab(reinExo, waspNestBlock, petrifiedWoodChest, blockBones, blockWitherWeb, extenderThingy);
		ModTabs.blocks.setTab(umberstonePillar, velocityBlock, honeyCombBlock, honeyTreat, gneiss, mud, mudBricks, jarOHoney);// erebusHoneyBlock,
		ModTabs.blocks.setTab(jadeBlock, glowGemBlock, mucusBomb); // altar,
		ModTabs.blocks.setTab(umbercobbleStairs);
		ModTabs.blocks.setTab(gneissStairs);
		ModTabs.blocks.setTab(petrifiedWoodStairs, amberBrickStairs, waspNestStairs, stoneSlabs[0], plankSlabs[0]);
		ModTabs.blocks.setTab(plankSlabs[2], petrifiedWoodSlab[0], wallErebus);
	}

	private static void registerBlocks() {
		GameRegistry.registerBlock(portalErebus, "portal");

		GameRegistry.registerBlock(umberstone, ItemBlockGeneric.class, "umberstone");
		GameRegistry.registerBlock(umberOreBlock, ItemBlockGeneric.class, "oreBlockU");
		GameRegistry.registerBlock(oreFossil, "oreFossil");
		GameRegistry.registerBlock(redGem, ItemBlockGeneric.class, "redGem");
		GameRegistry.registerBlock(blockAmber, ItemBlockAmber.class, "blockAmber");
		GameRegistry.registerBlock(quickSand, "quickSand");
		GameRegistry.registerBlock(ghostSand, "ghostSand");
		GameRegistry.registerBlock(erebusOreExtra, ItemBlockGeneric.class, "erebusOreExtras");
		GameRegistry.registerBlock(umberstoneButton, "umberstoneButton");

		GameRegistry.registerBlock(planksErebus, ItemBlockPlanks.class, "planksErebus");
		GameRegistry.registerBlock(leavesErebus, ItemBlockGeneric.class, "leavesErebus");
		GameRegistry.registerBlock(hollowLogAcacia, "hollowLogAcacia");
		GameRegistry.registerBlock(erebusFlower, ItemBlockErebusFlower.class, "erebusFlower");
		GameRegistry.registerBlock(erebusStigma, ItemBlockErebusStigma.class, "erebusStigma");

		GameRegistry.registerBlock(erebusGrass, "erebusGrass");
		GameRegistry.registerBlock(thorns, "thorns");
		GameRegistry.registerBlock(fern, ItemBlockColoredSingle.class, "fern");
		GameRegistry.registerBlock(blockTurnip, "blockTurnip");
		GameRegistry.registerBlock(fiddlehead, "fiddlehead");
		GameRegistry.registerBlock(flowerPlanted, ItemBlockFlowerPlanted.class, "flowerPlanted");
		GameRegistry.registerBlock(doubleHeightPlant, ItemBlockDoubleHeightPlant.class, "doubleHeightPlant");

		GameRegistry.registerBlock(blockSilk, "blockSilk");
		GameRegistry.registerBlock(mirBrick, "mirBrick");
		GameRegistry.registerBlock(petrifiedWoodPlanks, "petrifiedWoodPlanks");
		GameRegistry.registerBlock(petrifiedCraftingTable, "petrifiedCraftingTable");
		GameRegistry.registerBlock(bambooCrate, "bambooCrate");
		GameRegistry.registerBlock(umberFurnace, "umberFurnaceOff");
		GameRegistry.registerBlock(umberFurnace_on, "umberFurnaceOn");
		GameRegistry.registerBlock(umberPaver, ItemBlockGeneric.class, "umberpaver");
		GameRegistry.registerBlock(bambooShoot, "bambooShoot");
		GameRegistry.registerBlock(bambooCrop, "bambooCrop");
		GameRegistry.registerBlock(bambooTorch, "bambooTorch");
		GameRegistry.registerBlock(erebusAltar, "erebusAltar");
		GameRegistry.registerBlock(erebusAltarLightning, "erebusAltarLightning");
		GameRegistry.registerBlock(erebusAltarHealing, "erebusAltarHealing");
		GameRegistry.registerBlock(erebusAltarXP, "erebusAltarXP");
		GameRegistry.registerBlock(erebusAltarRepair, "erebusAltarRepair");
		GameRegistry.registerBlock(glowingJar, "glowingJar");
		GameRegistry.registerBlock(reinExo, "reinExo");
		GameRegistry.registerBlock(bambooLadder, "bambooLadder");
		GameRegistry.registerBlock(umberGolemStatue, "umberGolemStatue");
		GameRegistry.registerBlock(waspNestBlock, "waspNestBlock");
		GameRegistry.registerBlock(petrifiedWoodChest, "petrifiedWoodChest");
		GameRegistry.registerBlock(blockBones, "blockBones");
		GameRegistry.registerBlock(blockWitherWeb, ItemBlockWitherWeb.class, "witherWeb");
		GameRegistry.registerBlock(bambooBridge, "bambooBridge");
		GameRegistry.registerBlock(extenderThingy, "extenderThingy");
		GameRegistry.registerBlock(bambooPole, "bambooPole");
		GameRegistry.registerBlock(umberstonePillar, "umberstonePillar");
		GameRegistry.registerBlock(velocityBlock, "velocityBlock");
		GameRegistry.registerBlock(honeyCombBlock, "honeyCombBlock");
		GameRegistry.registerBlock(doorAmber, "doorAmber");
		GameRegistry.registerBlock(gneiss, ItemBlockGeneric.class, "gneiss");
		GameRegistry.registerBlock(mud, "mud");
		GameRegistry.registerBlock(mudBricks, "mudBricks");
		GameRegistry.registerBlock(erebusMushroomCap0, "mushroomBulbCap");
		GameRegistry.registerBlock(erebusMushroomCap1, "mushroom1Cap");
		GameRegistry.registerBlock(erebusMushroomCap2, "mushroom2Cap");
		GameRegistry.registerBlock(erebusMushroomCap3, "mushroom3Cap");
		GameRegistry.registerBlock(erebusMushroomCap4, "mushroom4Cap");
		GameRegistry.registerBlock(erebusPlantSmall, ItemBlockErebusPlantSmall.class, "erebusPlantSmall");
		GameRegistry.registerBlock(honeyTreat, "honeyTreat");
		GameRegistry.registerBlock(jarOHoney, "jarOHoney");
		GameRegistry.registerBlock(jadeBlock, "jadeBlock");
		GameRegistry.registerBlock(altar, "altar");
		GameRegistry.registerBlock(glowGemBlock, "glowgemBlock");
		GameRegistry.registerBlock(mucusBomb, "mucusBomb");

		for (int i = 0; i < umbercobbleStairs.length; i++)
			GameRegistry.registerBlock(umbercobbleStairs[i], "umbercobbleStairs" + i);
		for (int i = 0; i < stoneSlabs.length; i++)
			GameRegistry.registerBlock(stoneSlabs[i], ItemBlockSlabStoneErebus.class, "slabStone" + i);
		for (int i = 0; i < plankSlabs.length; i++)
			GameRegistry.registerBlock(plankSlabs[i], i <= 1 ? ItemBlockSlabPlanks0Erebus.class : ItemBlockSlabPlanks1Erebus.class, "slabPlanks" + i);
		GameRegistry.registerBlock(petrifiedWoodStairs, "petrifiedWoodStairs");
		for (int i = 0; i < petrifiedWoodSlab.length; i++)
			GameRegistry.registerBlock(petrifiedWoodSlab[i], ItemBlockSlabPetrifiedWood.class, "petrifiedWoodSlab" + i);
		GameRegistry.registerBlock(amberBrickStairs, "amberBrickStairs");
		GameRegistry.registerBlock(waspNestStairs, "waspNestStairs");
		for (int i = 0; i < gneissStairs.length; i++)
			GameRegistry.registerBlock(gneissStairs[i], "gneissStairs" + i);

		GameRegistry.registerBlock(wallErebus, ItemBlockGeneric.class, "wallErebus");
		GameRegistry.registerBlock(insectRepellent, "blockInsectRepellent");

		GameRegistry.registerBlock(spiderSpawner, "spiderSpawner");
		GameRegistry.registerBlock(jumpingSpiderSpawner, "jumpingSpiderSpawner");
		GameRegistry.registerBlock(waspSpawner, "waspSpawner");

		GameRegistry.registerBlock(erebusHoneyBlock, "erebusHoney");
	}

	private static void registerProperties() {
		oreFossil.setHarvestLevel("pickaxe", 1);
		oreFossil.setHarvestLevel("pickaxe", 1);
		mirBrick.setHarvestLevel("pickaxe", 1);
		spiderSpawner.setHarvestLevel("pickaxe", 0, 0);
		jumpingSpiderSpawner.setHarvestLevel("pickaxe", 0, 0);
		waspSpawner.setHarvestLevel("pickaxe", 0, 0);
		umberstone.setHarvestLevel("pickaxe", 0);
		umberPaver.setHarvestLevel("pickaxe", 0);
		for (int i = 0; i < stoneSlabs.length; i++)
			stoneSlabs[i].setHarvestLevel("pickaxe", 0);
		for (int i = 0; i < plankSlabs.length; i++)
			plankSlabs[i].setHarvestLevel("axe", 0);
		wallErebus.setHarvestLevel("pickaxe", 0);
		umberOreBlock.setHarvestLevel("pickaxe", 0, 0);
		umberOreBlock.setHarvestLevel("pickaxe", 1, 1);
		umberOreBlock.setHarvestLevel("pickaxe", 2, 2);
		umberOreBlock.setHarvestLevel("pickaxe", 1, 3);
		umberOreBlock.setHarvestLevel("pickaxe", 2, 4);
		umberOreBlock.setHarvestLevel("pickaxe", 2, 5);
		umberOreBlock.setHarvestLevel("pickaxe", 2, 6);
		umberOreBlock.setHarvestLevel("pickaxe", 2, 8);
		quickSand.setHarvestLevel("shovel", 2);
		ghostSand.setHarvestLevel("shovel", 0);
		reinExo.setHarvestLevel("pickaxe", 2);
		petrifiedWoodChest.setHarvestLevel("pickaxe", 0);
		jadeBlock.setHarvestLevel("pickaxe", 2);
		erebusOreExtra.setHarvestLevel("pickaxe", 1, 0);
		erebusOreExtra.setHarvestLevel("pickaxe", 1, 1);
		erebusOreExtra.setHarvestLevel("pickaxe", 2, 2);
		erebusOreExtra.setHarvestLevel("pickaxe", 2, 3);
		erebusOreExtra.setHarvestLevel("pickaxe", 1, 4);

		Blocks.fire.setFireInfo(planksErebus, 5, 20);
		Blocks.fire.setFireInfo(leavesErebus, 30, 60);
		Blocks.fire.setFireInfo(blockWitherWeb, 20, 50);
		Blocks.fire.setFireInfo(erebusGrass, 60, 100);
		Blocks.fire.setFireInfo(fern, 60, 100);
		Blocks.fire.setFireInfo(fiddlehead, 60, 100);
		Blocks.fire.setFireInfo(thorns, 15, 100);
	}

	private static void registerFluids() {
		erebusHoney = new Fluid("honey").setBlock(erebusHoneyBlock).setDensity(6000).setViscosity(6000).setUnlocalizedName("erebus.honey");
		FluidRegistry.registerFluid(erebusHoney);
	}
}