const fs = require("fs");
const lang_file = require("../src/main/resources/assets/ag/lang/en_us.json");

const { argv } = require("process");
const { valid_item_groups, valid_block_materials } = require("./data.json");

// create item
// create texture
// create model
// create recipe

// Grabbing input args
const type = argv[2];
const id = argv[3];
const name = argv[4];

// Check if they gave a valid type
if (!["block", "b", "item", "i"].includes(type)) {
    throw new TypeError("TYPE must be either \"block\" or \"item\"");
}

// Check if they gave a name
if ([undefined, ""].includes(id)) {
    throw new ReferenceError("An ID must be given");
}

// Check if they gave a proper name
if ([undefined, ""].includes(name)) {
    throw new ReferenceError("A name must be given");
}


// If were generating an item
if (["item", "i"].includes(type)) {
    const item_group = argv[5];

    if (!valid_item_groups.includes(item_group)) {
        throw new TypeError(`ITEM_GROUP must be one of the following:\n- ${valid_item_groups.join("\n- ").toUpperCase()}`)
    }

    const outputCode = `public static Item ${id.toUpperCase()} = new Item(new Item.Settings().group(ItemGroup.${item_group.toUpperCase()}));`;
    const outputRegistrationCode = `Registry.register(Registry.ITEM, new Identifier("ag", "${id}"), ${id.toUpperCase()});`;
    const outputModel = {
        parent: "item/generated",
        textures: {
            layer0: `ag:item/${id}`
        }
    }

    lang_file[`item.ag.${id}`] = name;

    fs.writeFileSync(`../src/main/resources/assets/ag/models/item/${id}.json`, JSON.stringify(outputModel, null, 2));
    fs.writeFileSync(`../src/main/resources/assets/ag/lang/en_us.json`, JSON.stringify(lang_file, null, 2));
    console.log("\n==========<ITEM GENERATED>==========");
    console.log(`NAME: ${name}`);
    console.log(`ID: ${id}`);
    console.log(`GROUP: ${item_group}`);
    console.log(outputCode);
    console.log(outputRegistrationCode);
    return;
}

// If were generating a block
else {
    const block_material = argv[5];
    const item_group = argv[6];
    const arguments_string = argv[7];

    let args_strings = [];
    
    if (!valid_block_materials.includes(block_material)) {
        throw new TypeError(`BLOCK_MATERIAL must be one of the following:\n- ${valid_block_materials.join("\n- ").toUpperCase()}`);
    }

    if (!valid_item_groups.includes(item_group)) {
        throw new TypeError(`ITEM_GROUP must be one of the following:\n- ${valid_item_groups.join("\n- ").toUpperCase()}`)
    }

    if (![undefined, ""].includes(arguments_string)) {
        let args = {}
        let split_arguments = arguments_string.split(" ");
        split_arguments.forEach((argument) => {
            argument = argument.split("=");
            args[argument[0]] = (argument[1] == "yes") ? "" : argument[1];
        });
        Object.keys(args).forEach((key) => {
            args_strings.push(`.${key}(${args[key]})`);
        });
    }

    const outputBlockCode = `public static Block ${id.toUpperCase()} = new Block(FabricBlockSettings.of(Material.${block_material.toUpperCase()})${args_strings.join("")});`;

    const outputRegistrationCode = `Registry.register(Registry.BLOCK, new Identifier("ag", "${id}"), ${id.toUpperCase()});`;
    const outputItemRegistrationCode = `Registry.register(Registry.ITEM, new Identifier("ag", "${id}"), new BlockItem(${id.toUpperCase()}, new Item.Settings().group(ItemGroup.${item_group.toUpperCase()})));`;

    const outputItemModel = { parent: `ag:block/${id}` }
    const outputBlockModel = {
        parent: "block/cube_all",
        textures: {
            all: `ag:block/${id}`
        }
    }

    const outputBlockStates = {
        variants: {
            "": {
                model: `ag:block/${id}`
            }
        }
    }

    const outputLootTable = {
        type: "minecraft:block",
        pools: [
            {
                rolls: 1,
                entries: [
                    {
                        type: "minecraft:item",
                        name: `ag:${id}`
                    }
                ],
                conditions: [
                    {}
                ]
            }
        ]
    }

    lang_file[`block.ag.${id}`] = name;

    fs.writeFileSync(`../src/main/resources/assets/ag/models/item/${id}.json`, JSON.stringify(outputItemModel, null, 2));
    fs.writeFileSync(`../src/main/resources/assets/ag/models/block/${id}.json`, JSON.stringify(outputBlockModel, null, 2));
    fs.writeFileSync(`../src/main/resources/assets/ag/blockstates/${id}.json`, JSON.stringify(outputBlockStates, null, 2));
    fs.writeFileSync(`../src/main/resources/data/ag/loot_tables/blocks/${id}.json`, JSON.stringify(outputLootTable, null, 2));
    fs.writeFileSync(`../src/main/resources/assets/ag/lang/en_us.json`, JSON.stringify(lang_file, null, 2));
    console.log("\n==========<ITEM GENERATED>==========");
    console.log(`NAME: ${name}`);
    console.log(`ID: ${id}`);
    console.log(`GROUP: ${item_group}`);
    console.log(`MATERIAL: ${block_material}`);
    console.log(outputBlockCode);
    console.log(outputRegistrationCode);
    console.log(outputItemRegistrationCode);
}