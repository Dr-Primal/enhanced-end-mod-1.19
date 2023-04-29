package net.primal.enhancedend.world.gen;

public class EEWorldGen {
    public static void generateWorldGen() {
        EETreeGeneration.generateTrees();
        EEEndPlantGeneration.generateEndPlants();
        EEOreGeneration.generateOres();
        EEEntityGeneration.addEntityGen();
        EECustomFeatureGeneration.registerFeatures();
    }
}