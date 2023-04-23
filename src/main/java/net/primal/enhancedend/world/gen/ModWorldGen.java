package net.primal.enhancedend.world.gen;

public class ModWorldGen {
    public static void generateWorldGen() {
        ModTreeGeneration.generateTrees();
        ModEndPlantGeneration.generateEndPlants();
        ModOreGeneration.generateOres();
        ModEntitySpawn.addEntitySpawn();
        ModFeatureGeneration.registerFeatures();
    }
}