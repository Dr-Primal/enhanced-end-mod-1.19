package net.primal.enhancedend.block.custom;

import net.minecraft.block.MapColor;
import net.minecraft.block.Material;

public class EEFluidMaterial extends Material.Builder{
    public EEFluidMaterial(MapColor color) {
        super(color);
    }
    public static final Material ENDER_MATTER = new Material.Builder(MapColor.GRAY).allowsMovement().notSolid().destroyedByPiston().replaceable().liquid().build();

}
