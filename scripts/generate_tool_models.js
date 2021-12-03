const { tiers, tools } = require("./data.json");
const fs = require("fs");

tiers.forEach((tier) => {
    tools.forEach((tool) => {
        let tool_data = {
            parent: "item/generated",
            textures: {
                layer0: `ag:item/${tier}_${tool}`
            }
        }
        fs.writeFileSync(`../src/main/resources/assets/ag/models/item/${tier}_${tool}.json`, JSON.stringify(tool_data, null, 2));
    });
});