# SkyGrid v1.0.0

A recreation of the classic Sky Grid challenge, in which blocks are randomly generated at a set distance apart from each other in a grid. Built for Spigot-based servers and only supports 1.16.x.

## Installation

Add this plugin to the server's plugin folder. By default, the world will generate with AlphaFilter and AlphaWeight settings, which includes most solid blocks. This can be changed by providing different [generation settings](#generator-settings).
#### Bukkit Usage
Add these lines to the end of bukkit.yml for use in your world:
```yml
worlds:
  world:
    generator: SkyGrid
```
Replacing 'world' with the name of your default world if necessary.
#### Multiverse Support
Tested with Multiverse-4.1.1.\
Example commands:
>/mv create skygrid normal -g SkyGrid\
>/mv create skygrid normal -g SkyGrid:#Survival

## Generator Settings

You can use custom generator settings by providing a generator ID to load a file from the plugin data folder. To tell the generator that it is loading a file, prepend the ID with '#'. The file must have the extension '.json'.
#### Example Configuration (Survival.json)
```json
{
  "version": 1,
  "delta": 5,
  "filter": {
    "filterClass": "com.backwardsnode.skygrid.filter.SurvivalFilter",
    "exclusionList": [],
    "inclusionList": []
  },
  "weight": {
    "weightClass": "com.backwardsnode.skygrid.weight.SurvivalWeight"
  },
  "randomizeSpawners": true,
  "blockAttemptGenerators": [
    "com.backwardsnode.skygrid.generator.FarmlandGenerator",
    "com.backwardsnode.skygrid.generator.CactusGenerator;1",
    "com.backwardsnode.skygrid.generator.SugarCaneGenerator",
    "com.backwardsnode.skygrid.generator.BambooGenerator;0.1",
    "com.backwardsnode.skygrid.generator.BellGenerator",
    "com.backwardsnode.skygrid.generator.FloraGenerator",
    "com.backwardsnode.skygrid.generator.LanternGenerator"
  ]
}
```
#### Settings
- **delta**: Distance between blocks (minimum 3)
- **filterClass**: The name of the class to use for block filtering
- **exclusionList**: List of blocks not to generate in addition to the filter class
- **inclusionList**: List of blocks to generate even if they are excluded by the filter class
- **weightClass**: The name of the internal class to use for block weighing
- **randomizeSpawners**: If monster spawners should have random entity types
- **blockAttemptGenerators**: Further generation around blocks (see below)

#### Filters, Weights and BAGs
All built-in filters, weights and block attempt generators use class references to build the world correctly. Updates between versions of the game and this plugin may cause the world generation to change.
In order to select what blocks to generate, a filter is used to exclude certain blocks.

>**Current Filters:**\
>com.backwardsnode.skygrid.filter.EmptyFilter - Allows all blocks to generate\
>com.backwardsnode.skygrid.filter.AlphaFilter - Removes unbreakable and dangerous blocks like fences\
>com.backwardsnode.skygrid.filter.SurvivalFilter - Removes crafted blocks from the generation\
>com.backwardsnode.skygrid.filter.ColorfulSurvivalFilter - Similar to SurvivalFilter, but with colored blocks

The probability that a specific block is generated is given by a weight.
>**Current Weights:**\
>com.backwardsnode.skygrid.weight.UniformWeight - All blocks have the same chance to be generated\
>com.backwardsnode.skygrid.weight.AlphaWeight - Weight for initial testing (may be removed)\
>com.backwardsnode.skygrid.weight.SurvivalWeight - Used for survival generation

Block Attempt Generators (BAGs) are similar to block populators, but are applied immediately after a block is generated.
They allow for control over what block to generate on the top, bottom or sides of a block in the grid.
**To specify a weight for these generators, place a ';' at the end of the class name followed by the chance of the generator running.**
>**Current BAGs:**\
>com.backwardsnode.skygrid.generator.FarmlandGenerator - Plants crops on top of farmland\
>com.backwardsnode.skygrid.generator.CactusGenerator - Plants cactus on top of sand/red sand\
>com.backwardsnode.skygrid.generator.SugarCaneGenerator - Plants sugar cane\
>com.backwardsnode.skygrid.generator.BambooGenerator - Plants bamboo\
>com.backwardsnode.skygrid.generator.BellGenerator - Places bells on top of certain village tiles\
>com.backwardsnode.skygrid.generator.FloraGenerator - Plants flowers on grass/mushrooms on mycelium\
>com.backwardsnode.skygrid.generator.LanternGenerator - Places lanterns below certain blocks

## Known Issues/Missing Features
- Water blocks are instantly updated after the world is generated
  - This doesn't apply to lava
  - Flowing water updates gravity blocks
- Configuration files cannot yet specify block weights
- Spawners cannot have entity type weights
- Gravity blocks like sand and gravel fall when blocks like cactus and bamboo grow

## Building
SkyGrid uses Maven for building and dependency management. To build:
>$ mvn clean package

The JAR can be found in the /target folder.

## Developing
You can use this plugin to add your own filters/weights/generators and add them to a configuration file, as all of the classes are loaded by reflection. Important API interfaces are:
- com.backwardsnode.skygrid.BlockFilter
- com.backwardsnode.skygrid.BlockWeight
- com.backwardsnode.skygrid.BlockAttemptGenerator

## Contributing
This project is open to contributions in the form of features and bug fixes.
