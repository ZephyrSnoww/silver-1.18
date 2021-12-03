const fs = require("fs");
const { argv } = require("process");
const { tools } = require("./data.json");

const tier = argv[2];
const material = argv[3] || `ag:${tier}_ingot`;
const rod = argv[4] || "minecraft:stick";

if (tier == undefined) {
    throw new ReferenceError("A tier must be given!");
}

tools.forEach((tool) => {
    let recipe_data = {
        type: "minecraft:crafting_shaped",
        pattern: [],
        key: {
            M: {
                item: material
            },
            S: {
                item: rod
            }
        },
        result: {
            item: `ag:${tier}_${tool}`,
            count: 1
        }
    }

    if (tool == "shovel") {
        recipe_data.pattern = [
            " M ",
            " S ",
            " S "
        ];
    } else if (tool == "pickaxe") {
        recipe_data.pattern = [
            "MMM",
            " S ",
            " S "
        ];
    } else if (tool == "axe") {
        recipe_data.pattern = [
            "MM ",
            "MS ",
            " S "
        ];
    } else if (tool == "hoe") {
        recipe_data.pattern = [
            "MM ",
            " S ",
            " S "
        ];
    } else if (tool == "sword") {
        recipe_data.pattern = [
            " M ",
            " M ",
            " S "
        ]
    }

    fs.writeFileSync(`../src/main/resources/data/ag/recipes/${tier}_${tool}.json`, JSON.stringify(recipe_data, null, 2));
});