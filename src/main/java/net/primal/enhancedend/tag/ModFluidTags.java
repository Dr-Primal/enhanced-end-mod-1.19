package net.primal.enhancedend.tag;

import net.minecraft.fluid.Fluid;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class ModFluidTags {
    public static final TagKey<Fluid> ENDER_MATTER = net.primal.enhancedend.tag.ModFluidTags.of("ender_matter");

    private ModFluidTags() {
    }

    private static TagKey<Fluid> of(String id) {
        return TagKey.of(Registry.FLUID_KEY, new Identifier(id));
    }
}
