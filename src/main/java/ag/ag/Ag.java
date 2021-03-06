package ag.ag;

import ag.ag.blocks.screenHandlers.*;
import ag.ag.items.*;
import ag.ag.items.materials.*;
import ag.ag.blocks.*;
import ag.ag.blocks.entities.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;

/**
 * The main mod class
 */
public class Ag implements ModInitializer {
    // Blocks
    public static Generator GENERATOR = new Generator(FabricBlockSettings.of(Material.STONE));
    public static ElectricFurnace ELECTRIC_FURNACE = new ElectricFurnace(FabricBlockSettings.of(Material.METAL));
    public static AlloyFurnace ALLOY_FURNACE = new AlloyFurnace(FabricBlockSettings.of(Material.METAL));
    public static IndustrialFurnace INDUSTRIAL_FURNACE = new IndustrialFurnace(FabricBlockSettings.of(Material.METAL));
    public static ArcFurnace ARC_FURNACE = new ArcFurnace(FabricBlockSettings.of(Material.METAL));

    public static Block STEEL_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(5f).resistance(6f).requiresTool().sounds(BlockSoundGroup.METAL));

    public static Block TITANIUM_ORE = new Block(FabricBlockSettings.of(Material.STONE).hardness(3.5f).requiresTool().sounds(BlockSoundGroup.STONE));
    public static Block TITANIUM_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(6f).resistance(7f).requiresTool().sounds(BlockSoundGroup.METAL));

    public static Block RAINBOWFIRE_OBSIDIAN = new Block(FabricBlockSettings.of(Material.STONE).hardness(75f).resistance(1500f).requiresTool());

    public static Block BLOCK_OF_CARBON = new Block(FabricBlockSettings.of(Material.METAL));
    public static Block FIBERGLASS = new Block(FabricBlockSettings.of(Material.GLASS));
    public static Block BLOCK_OF_SILICON = new Block(FabricBlockSettings.of(Material.METAL));
    public static PinkLotus PINK_LOTUS = new PinkLotus(FabricBlockSettings.of(Material.UNDERWATER_PLANT));
    public static Block SOLAR_PANEL = new Block(FabricBlockSettings.of(Material.STONE));

    public static ConfiguredFeature<?, ?> END_TITANIUM_ORE_CONFIGURED_FEATURE = Feature.ORE.configure(new OreFeatureConfig(new BlockMatchRuleTest(Blocks.END_STONE), TITANIUM_ORE.getDefaultState(), 9));
    public static PlacedFeature END_TITANIUM_ORE_PLACED_FEATURE = END_TITANIUM_ORE_CONFIGURED_FEATURE.withPlacement(CountPlacementModifier.of(10), SquarePlacementModifier.of(), HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64)));

    // Items
//    public static Item BLOOD = new Item(new Item.Settings().group(ItemGroup.BREWING));

    public static Item TITANIUM_INGOT = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
    public static Item STEEL_INGOT = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
    public static Item STERLING_STEEL_INGOT = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
    public static Item CARBON = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
    public static Item SILICON = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
    public static Item SOLAR_CELL = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
    public static Item CIRCUT = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
    public static Item COMPUTER_CHIP = new Item(new Item.Settings().group(ItemGroup.MATERIALS));

    // Tools
    // Copper
    public static CustomShovel COPPER_SHOVEL = new CustomShovel(CopperMaterial.INSTANCE, new CustomItemSettings(new Item.Settings().group(ItemGroup.TOOLS)));
    public static CustomPickaxe COPPER_PICKAXE = new CustomPickaxe(CopperMaterial.INSTANCE, new CustomItemSettings(new Item.Settings().group(ItemGroup.TOOLS)));
    public static CustomAxe COPPER_AXE = new CustomAxe(CopperMaterial.INSTANCE, new CustomItemSettings(new Item.Settings().group(ItemGroup.TOOLS)));
    public static CustomHoe COPPER_HOE = new CustomHoe(CopperMaterial.INSTANCE, -1, new CustomItemSettings(new Item.Settings().group(ItemGroup.TOOLS)));
    public static CustomSword COPPER_SWORD = new CustomSword(CopperMaterial.INSTANCE, new CustomItemSettings(new Item.Settings().group(ItemGroup.COMBAT)));

    // Obsidian
    public static CustomShovel OBSIDIAN_SHOVEL = new CustomShovel(ObsidianMaterial.INSTANCE, new CustomItemSettings(new Item.Settings().group(ItemGroup.TOOLS)));
    public static CustomPickaxe OBSIDIAN_PICKAXE = new CustomPickaxe(ObsidianMaterial.INSTANCE, new CustomItemSettings(new Item.Settings().group(ItemGroup.TOOLS)));
    public static CustomAxe OBSIDIAN_AXE = new CustomAxe(ObsidianMaterial.INSTANCE, new CustomItemSettings(new Item.Settings().group(ItemGroup.TOOLS)));
    public static CustomHoe OBSIDIAN_HOE = new CustomHoe(ObsidianMaterial.INSTANCE, 0, new CustomItemSettings(new Item.Settings().group(ItemGroup.TOOLS)));
    public static CustomSword OBSIDIAN_SWORD = new CustomSword(ObsidianMaterial.INSTANCE, new CustomItemSettings(new Item.Settings().group(ItemGroup.COMBAT)));

    // Steel
    public static CustomShovel STEEL_SHOVEL = new CustomShovel(SteelMaterial.INSTANCE, new CustomItemSettings(new Item.Settings().group(ItemGroup.TOOLS)));
    public static CustomPickaxe STEEL_PICKAXE = new CustomPickaxe(SteelMaterial.INSTANCE, new CustomItemSettings(new Item.Settings().group(ItemGroup.TOOLS)));
    public static CustomAxe STEEL_AXE = new CustomAxe(SteelMaterial.INSTANCE, new CustomItemSettings(new Item.Settings().group(ItemGroup.TOOLS)));
    public static CustomHoe STEEL_HOE = new CustomHoe(SteelMaterial.INSTANCE, 0, new CustomItemSettings(new Item.Settings().group(ItemGroup.TOOLS)));
    public static CustomSword STEEL_SWORD = new CustomSword(SteelMaterial.INSTANCE, new CustomItemSettings(new Item.Settings().group(ItemGroup.COMBAT)));

    // Amethyst
    public static CustomShovel AMETHYST_SHOVEL = new CustomShovel(AmethystMaterial.INSTANCE, new CustomItemSettings(new Item.Settings().group(ItemGroup.TOOLS)));
    public static CustomPickaxe AMETHYST_PICKAXE = new CustomPickaxe(AmethystMaterial.INSTANCE, new CustomItemSettings(new Item.Settings().group(ItemGroup.TOOLS)));
    public static CustomAxe AMETHYST_AXE = new CustomAxe(AmethystMaterial.INSTANCE, new CustomItemSettings(new Item.Settings().group(ItemGroup.TOOLS)));
    public static CustomHoe AMETHYST_HOE = new CustomHoe(AmethystMaterial.INSTANCE, 0, new CustomItemSettings(new Item.Settings().group(ItemGroup.TOOLS)));
    public static CustomSword AMETHYST_SWORD = new CustomSword(AmethystMaterial.INSTANCE, new CustomItemSettings(new Item.Settings().group(ItemGroup.COMBAT)));

    // Titanium
    public static CustomShovel TITANIUM_SHOVEL = new CustomShovel(TitaniumMaterial.INSTANCE, new CustomItemSettings(new Item.Settings().group(ItemGroup.TOOLS)));
    public static CustomPickaxe TITANIUM_PICKAXE = new CustomPickaxe(TitaniumMaterial.INSTANCE, new CustomItemSettings(new Item.Settings().group(ItemGroup.TOOLS)));
    public static CustomAxe TITANIUM_AXE = new CustomAxe(TitaniumMaterial.INSTANCE, new CustomItemSettings(new Item.Settings().group(ItemGroup.TOOLS)));
    public static CustomHoe TITANIUM_HOE = new CustomHoe(TitaniumMaterial.INSTANCE, 0, new CustomItemSettings(new Item.Settings().group(ItemGroup.TOOLS)));
    public static CustomSword TITANIUM_SWORD = new CustomSword(TitaniumMaterial.INSTANCE, new CustomItemSettings(new Item.Settings().group(ItemGroup.COMBAT)));

    // RainbowFire
    public static CustomShovel RAINBOWFIRE_SHOVEL = new CustomShovel(RainbowFireMaterial.INSTANCE, new CustomItemSettings(new Item.Settings().group(ItemGroup.TOOLS)).hasGlint(true));
    public static CustomPickaxe RAINBOWFIRE_PICKAXE = new CustomPickaxe(RainbowFireMaterial.INSTANCE, new CustomItemSettings(new Item.Settings().group(ItemGroup.TOOLS)).hasGlint(true));
    public static CustomAxe RAINBOWFIRE_AXE = new CustomAxe(RainbowFireMaterial.INSTANCE, -2.9f, new CustomItemSettings(new Item.Settings().group(ItemGroup.TOOLS)).hasGlint(true));
    public static CustomHoe RAINBOWFIRE_HOE = new CustomHoe(RainbowFireMaterial.INSTANCE, 1, new CustomItemSettings(new Item.Settings().group(ItemGroup.TOOLS)).hasGlint(true));
    public static CustomSword RAINBOWFIRE_SWORD = new CustomSword(RainbowFireMaterial.INSTANCE, -2.3f, new CustomItemSettings(new Item.Settings().group(ItemGroup.COMBAT)).hasGlint(true));

    // Carbon Fiber
    public static CustomShovel CARBON_FIBER_SHOVEL = new CustomShovel(CarbonFiberMaterial.INSTANCE, new CustomItemSettings(new Item.Settings().group(ItemGroup.TOOLS)));
    public static CustomPickaxe CARBON_FIBER_PICKAXE = new CustomPickaxe(CarbonFiberMaterial.INSTANCE, new CustomItemSettings(new Item.Settings().group(ItemGroup.TOOLS)));
    public static CustomAxe CARBON_FIBER_AXE = new CustomAxe(CarbonFiberMaterial.INSTANCE, -2.9f, new CustomItemSettings(new Item.Settings().group(ItemGroup.TOOLS)));
    public static CustomHoe CARBON_FIBER_HOE = new CustomHoe(CarbonFiberMaterial.INSTANCE, 1, new CustomItemSettings(new Item.Settings().group(ItemGroup.TOOLS)));
    public static CustomSword CARBON_FIBER_SWORD = new CustomSword(CarbonFiberMaterial.INSTANCE, -2.3f, new CustomItemSettings(new Item.Settings().group(ItemGroup.COMBAT)));

    // Carbon Nanotube
    public static CustomShovel CARBON_NANOTUBE_SHOVEL = new CustomShovel(CarbonNanotubeMaterial.INSTANCE, new CustomItemSettings(new Item.Settings().group(ItemGroup.TOOLS)));
    public static CustomPickaxe CARBON_NANOTUBE_PICKAXE = new CustomPickaxe(CarbonNanotubeMaterial.INSTANCE, new CustomItemSettings(new Item.Settings().group(ItemGroup.TOOLS)));
    public static CustomAxe CARBON_NANOTUBE_AXE = new CustomAxe(CarbonNanotubeMaterial.INSTANCE, -2.8f, new CustomItemSettings(new Item.Settings().group(ItemGroup.TOOLS)));
    public static CustomHoe CARBON_NANOTUBE_HOE = new CustomHoe(CarbonNanotubeMaterial.INSTANCE, 2, new CustomItemSettings(new Item.Settings().group(ItemGroup.TOOLS)));
    public static CustomSword CARBON_NANOTUBE_SWORD = new CustomSword(CarbonNanotubeMaterial.INSTANCE, -2.2f, new CustomItemSettings(new Item.Settings().group(ItemGroup.COMBAT)));

    // Aerogel
//    public static CustomShovel AEROGEL_SHOVEL = new CustomShovel(AerogelMaterial.INSTANCE, new CustomItemSettings(new Item.Settings().group(ItemGroup.TOOLS)));
//    public static CustomPickaxe AEROGEL_PICKAXE = new CustomPickaxe(AerogelMaterial.INSTANCE, new CustomItemSettings(new Item.Settings().group(ItemGroup.TOOLS)));
//    public static CustomAxe AEROGEL_AXE = new CustomAxe(AerogelMaterial.INSTANCE, -2.7f, new CustomItemSettings(new Item.Settings().group(ItemGroup.TOOLS)));
//    public static CustomHoe AEROGEL_HOE = new CustomHoe(AerogelMaterial.INSTANCE, 3, new CustomItemSettings(new Item.Settings().group(ItemGroup.TOOLS)));
//    public static CustomSword AEROGEL_SWORD = new CustomSword(AerogelMaterial.INSTANCE, -2f, new CustomItemSettings(new Item.Settings().group(ItemGroup.COMBAT)));

    public static BlockEntityType<GeneratorEntity> GENERATOR_ENTITY;
    public static ScreenHandlerType<GeneratorScreenHandler> GENERATOR_SCREEN_HANDLER;

    public static BlockEntityType<ElectricFurnaceEntity> ELECTRIC_FURNACE_ENTITY;
    public static ScreenHandlerType<ElectricFurnaceScreenHandler> ELECTRIC_FURNACE_SCREEN_HANDLER;

    public static BlockEntityType<AlloyFurnaceEntity> ALLOY_FURNACE_ENTITY;
    public static ScreenHandlerType<AlloyFurnaceScreenHandler> ALLOY_FURNACE_SCREEN_HANDLER;

    public static BlockEntityType<IndustrialFurnaceEntity> INDUSTRIAL_FURNACE_ENTITY;
    public static ScreenHandlerType<IndustrialFurnaceScreenHandler> INDUSTRIAL_FURNACE_SCREEN_HANDLER;

    public static BlockEntityType<ArcFurnaceEntity> ARC_FURNACE_ENTITY;
    public static ScreenHandlerType<ArcFurnaceScreenHandler> ARC_FURNACE_SCREEN_HANDLER;

    @Override
    public void onInitialize() {
        GENERATOR_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier("ag", "generator"), GeneratorScreenHandler::new);
        GENERATOR_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("ag", "generator_block_entity"), FabricBlockEntityTypeBuilder.create(GeneratorEntity::new, GENERATOR).build(null));

        ELECTRIC_FURNACE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier("ag", "electric_furnace"), ElectricFurnaceScreenHandler::new);
        ELECTRIC_FURNACE_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("ag", "electric_furnace_block_entity"), FabricBlockEntityTypeBuilder.create(ElectricFurnaceEntity::new, ELECTRIC_FURNACE).build(null));

        ALLOY_FURNACE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier("ag", "alloy_furnace"), AlloyFurnaceScreenHandler::new);
        ALLOY_FURNACE_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("ag", "alloy_furnace_block_entity"), FabricBlockEntityTypeBuilder.create(AlloyFurnaceEntity::new, ALLOY_FURNACE).build(null));

        INDUSTRIAL_FURNACE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier("ag", "industrial_furnace"), IndustrialFurnaceScreenHandler::new);
        INDUSTRIAL_FURNACE_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("ag", "industrial_furnace_block_entity"), FabricBlockEntityTypeBuilder.create(IndustrialFurnaceEntity::new, INDUSTRIAL_FURNACE).build(null));

        ARC_FURNACE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier("ag", "arc_furnace"), ArcFurnaceScreenHandler::new);
        ARC_FURNACE_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("ag", "arc_furnace_block_entity"), FabricBlockEntityTypeBuilder.create(ArcFurnaceEntity::new, ARC_FURNACE).build(null));

        // Blocks
        Registry.register(Registry.BLOCK, new Identifier("ag", "generator"), GENERATOR);
        Registry.register(Registry.ITEM, new Identifier("ag", "generator"), new BlockItem(GENERATOR, new Item.Settings().group(ItemGroup.DECORATIONS)));

        Registry.register(Registry.BLOCK, new Identifier("ag", "electric_furnace"), ELECTRIC_FURNACE);
        Registry.register(Registry.ITEM, new Identifier("ag", "electric_furnace"), new BlockItem(ELECTRIC_FURNACE, new Item.Settings().group(ItemGroup.DECORATIONS)));

        Registry.register(Registry.BLOCK, new Identifier("ag", "alloy_furnace"), ALLOY_FURNACE);
        Registry.register(Registry.ITEM, new Identifier("ag", "alloy_furnace"), new BlockItem(ALLOY_FURNACE, new Item.Settings().group(ItemGroup.DECORATIONS)));

        Registry.register(Registry.BLOCK, new Identifier("ag", "industrial_furnace"), INDUSTRIAL_FURNACE);
        Registry.register(Registry.ITEM, new Identifier("ag", "industrial_furnace"), new BlockItem(INDUSTRIAL_FURNACE, new Item.Settings().group(ItemGroup.DECORATIONS)));

        Registry.register(Registry.BLOCK, new Identifier("ag", "arc_furnace"), ARC_FURNACE);
        Registry.register(Registry.ITEM, new Identifier("ag", "arc_furnace"), new BlockItem(ARC_FURNACE, new Item.Settings().group(ItemGroup.DECORATIONS)));


        Registry.register(Registry.BLOCK, new Identifier("ag", "block_of_carbon"), BLOCK_OF_CARBON);
        Registry.register(Registry.ITEM, new Identifier("ag", "block_of_carbon"), new BlockItem(BLOCK_OF_CARBON, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        Registry.register(Registry.BLOCK, new Identifier("ag", "pink_lotus"), PINK_LOTUS);
        Registry.register(Registry.ITEM, new Identifier("ag", "pink_lotus"), new BlockItem(PINK_LOTUS, new Item.Settings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.BLOCK, new Identifier("ag", "fiberglass"), FIBERGLASS);
        Registry.register(Registry.ITEM, new Identifier("ag", "fiberglass"), new BlockItem(FIBERGLASS, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        Registry.register(Registry.BLOCK, new Identifier("ag", "block_of_silicon"), BLOCK_OF_SILICON);
        Registry.register(Registry.ITEM, new Identifier("ag", "block_of_silicon"), new BlockItem(BLOCK_OF_SILICON, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.BLOCK, new Identifier("ag", "solar_panel"), SOLAR_PANEL);
        Registry.register(Registry.ITEM, new Identifier("ag", "solar_panel"), new BlockItem(SOLAR_PANEL, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        // Rainbowfire obsidian
        Registry.register(Registry.BLOCK, new Identifier("ag", "rainbowfire_obsidian"), RAINBOWFIRE_OBSIDIAN);

        // Titanium
        Registry.register(Registry.BLOCK, new Identifier("ag", "titanium_ore"), TITANIUM_ORE);
        Registry.register(Registry.BLOCK, new Identifier("ag", "titanium_block"), TITANIUM_BLOCK);

        // Steel
        Registry.register(Registry.BLOCK, new Identifier("ag", "steel_block"), STEEL_BLOCK);

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("ag", "titanium_ore"), END_TITANIUM_ORE_CONFIGURED_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("ag", "titanium_ore"), END_TITANIUM_ORE_PLACED_FEATURE);

        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("ag", "titanium_ore")));

        // Items
//        Registry.register(Registry.ITEM, new Identifier("ag", "blood"), BLOOD);
        Registry.register(Registry.ITEM, new Identifier("ag", "steel_ingot"), STEEL_INGOT);
        Registry.register(Registry.ITEM, new Identifier("ag", "titanium_ingot"), TITANIUM_INGOT);
        Registry.register(Registry.ITEM, new Identifier("ag", "sterling_steel_ingot"), STERLING_STEEL_INGOT);
        Registry.register(Registry.ITEM, new Identifier("ag", "carbon"), CARBON);
        Registry.register(Registry.ITEM, new Identifier("ag", "silicon"), SILICON);
        Registry.register(Registry.ITEM, new Identifier("ag", "solar_cell"), SOLAR_CELL);
        Registry.register(Registry.ITEM, new Identifier("ag", "circut"), CIRCUT);
        Registry.register(Registry.ITEM, new Identifier("ag", "computer_chip"), COMPUTER_CHIP);

        // Copper
        Registry.register(Registry.ITEM, new Identifier("ag", "copper_shovel"), COPPER_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("ag", "copper_pickaxe"), COPPER_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("ag", "copper_axe"), COPPER_AXE);
        Registry.register(Registry.ITEM, new Identifier("ag", "copper_hoe"), COPPER_HOE);
        Registry.register(Registry.ITEM, new Identifier("ag", "copper_sword"), COPPER_SWORD);

        // Obsidian
        Registry.register(Registry.ITEM, new Identifier("ag", "obsidian_shovel"), OBSIDIAN_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("ag", "obsidian_pickaxe"), OBSIDIAN_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("ag", "obsidian_axe"), OBSIDIAN_AXE);
        Registry.register(Registry.ITEM, new Identifier("ag", "obsidian_hoe"), OBSIDIAN_HOE);
        Registry.register(Registry.ITEM, new Identifier("ag", "obsidian_sword"), OBSIDIAN_SWORD);

        // Steel
        Registry.register(Registry.ITEM, new Identifier("ag", "steel_block"), new BlockItem(STEEL_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("ag", "steel_shovel"), STEEL_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("ag", "steel_pickaxe"), STEEL_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("ag", "steel_axe"), STEEL_AXE);
        Registry.register(Registry.ITEM, new Identifier("ag", "steel_hoe"), STEEL_HOE);
        Registry.register(Registry.ITEM, new Identifier("ag", "steel_sword"), STEEL_SWORD);

        // Amethyst
        Registry.register(Registry.ITEM, new Identifier("ag", "amethyst_shovel"), AMETHYST_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("ag", "amethyst_pickaxe"), AMETHYST_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("ag", "amethyst_axe"), AMETHYST_AXE);
        Registry.register(Registry.ITEM, new Identifier("ag", "amethyst_hoe"), AMETHYST_HOE);
        Registry.register(Registry.ITEM, new Identifier("ag", "amethyst_sword"), AMETHYST_SWORD);

        // Titanium
        Registry.register(Registry.ITEM, new Identifier("ag", "titanium_ore"), new BlockItem(TITANIUM_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("ag", "titanium_block"), new BlockItem(TITANIUM_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("ag", "titanium_shovel"), TITANIUM_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("ag", "titanium_pickaxe"), TITANIUM_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("ag", "titanium_axe"), TITANIUM_AXE);
        Registry.register(Registry.ITEM, new Identifier("ag", "titanium_hoe"), TITANIUM_HOE);
        Registry.register(Registry.ITEM, new Identifier("ag", "titanium_sword"), TITANIUM_SWORD);

        // RainbowFire
        Registry.register(Registry.ITEM, new Identifier("ag", "rainbowfire_obsidian"), new BlockItem(RAINBOWFIRE_OBSIDIAN, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier("ag", "rainbowfire_shovel"), RAINBOWFIRE_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("ag", "rainbowfire_pickaxe"), RAINBOWFIRE_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("ag", "rainbowfire_axe"), RAINBOWFIRE_AXE);
        Registry.register(Registry.ITEM, new Identifier("ag", "rainbowfire_hoe"), RAINBOWFIRE_HOE);
        Registry.register(Registry.ITEM, new Identifier("ag", "rainbowfire_sword"), RAINBOWFIRE_SWORD);

        // Carbon Fiber
        Registry.register(Registry.ITEM, new Identifier("ag", "carbon_fiber_shovel"), CARBON_FIBER_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("ag", "carbon_fiber_pickaxe"), CARBON_FIBER_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("ag", "carbon_fiber_axe"), CARBON_FIBER_AXE);
        Registry.register(Registry.ITEM, new Identifier("ag", "carbon_fiber_hoe"), CARBON_FIBER_HOE);
        Registry.register(Registry.ITEM, new Identifier("ag", "carbon_fiber_sword"), CARBON_FIBER_SWORD);

        // Carbon Nanotube
        Registry.register(Registry.ITEM, new Identifier("ag", "carbon_nanotube_shovel"), CARBON_NANOTUBE_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("ag", "carbon_nanotube_pickaxe"), CARBON_NANOTUBE_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("ag", "carbon_nanotube_axe"), CARBON_NANOTUBE_AXE);
        Registry.register(Registry.ITEM, new Identifier("ag", "carbon_nanotube_hoe"), CARBON_NANOTUBE_HOE);
        Registry.register(Registry.ITEM, new Identifier("ag", "carbon_nanotube_sword"), CARBON_NANOTUBE_SWORD);

//        // Aerogel
//        Registry.register(Registry.ITEM, new Identifier("ag", "aerogel_shovel"), AEROGEL_SHOVEL);
//        Registry.register(Registry.ITEM, new Identifier("ag", "aerogel_pickaxe"), AEROGEL_PICKAXE);
//        Registry.register(Registry.ITEM, new Identifier("ag", "aerogel_axe"), AEROGEL_AXE);
//        Registry.register(Registry.ITEM, new Identifier("ag", "aerogel_hoe"), AEROGEL_HOE);
//        Registry.register(Registry.ITEM, new Identifier("ag", "aerogel_sword"), AEROGEL_SWORD);
    }
}
