package net.primal.enhancedend.block.entity;

import net.primal.enhancedend.mixin.SignTypeAccessor;
import net.minecraft.util.SignType;

public class EESignTypes {
    public static final SignType MIDNIGHT =
            SignTypeAccessor.registerNew(SignTypeAccessor.newSignType("midnight"));
    public static final SignType CORLITE =
            SignTypeAccessor.registerNew(SignTypeAccessor.newSignType("corlite"));
}