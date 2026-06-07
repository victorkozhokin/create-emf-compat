package strm.createemfcompat.mixin;

import net.minecraft.client.Minecraft;
import net.neoforged.fml.ModList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import traben.entity_model_features.models.animation.EMFAnimationEntityContext;
import traben.entity_model_features.models.parts.EMFModelPartRoot;
import traben.entity_model_features.models.parts.EMFModelPartVanilla;
import strm.createemfcompat.compat.EMFCompat;
import strm.createemfcompat.util.SavedPoses;

import java.util.Set;
import java.util.UUID;

@Mixin(EMFModelPartRoot.class)
public class EMFModelPartRootMixin {

    @Unique
    private long createemfcompat$lastRestoreFrame = -1;

    @Inject(method = "animate", at = @At("RETURN"))
    private void createemfcompat$restorePosesAfterAnimate(CallbackInfo ci) {
        if (createemfcompat$lastRestoreFrame == EMFCompat.currentFrame) return;
        createemfcompat$lastRestoreFrame = EMFCompat.currentFrame;

        var state = EMFAnimationEntityContext.getEmfState();
        if (state == null || state.emfEntity() == null) return;

        UUID uuid = state.emfEntity().etf$getUuid();

        var mc = Minecraft.getInstance();
        if (mc.player != null && mc.player.getUUID().equals(uuid) && mc.options.getCameraType().isFirstPerson()) {
            return;
        }

        SavedPoses savedPoses = null;

        if (ModList.get().isLoaded("simulated")) {
            Set<UUID> holdingPlayers = PlayerHoldingHandleRendererAccessor.createEmfCompat$getHoldingPlayers();
            if (holdingPlayers != null && holdingPlayers.contains(uuid)) {
                savedPoses = EMFCompat.handleSavedPoses.get(uuid);
            }
        }

        if (savedPoses == null) return;

        EMFModelPartRoot root = (EMFModelPartRoot) (Object) this;
        EMFModelPartVanilla leftArmPart = null;
        EMFModelPartVanilla rightArmPart = null;
        EMFModelPartVanilla leftSleeve = null;
        EMFModelPartVanilla rightSleeve = null;

        for (EMFModelPartVanilla part : root.getAllVanillaPartsEMF()) {
            String shortName = part.toStringShort();
            if ("[vanilla part left_arm]".equals(shortName)) {
                if (savedPoses.leftArm() != null) {
                    savedPoses.leftArm().applyRotation(part);
                    leftArmPart = part;
                }
            } else if ("[vanilla part right_arm]".equals(shortName)) {
                if (savedPoses.rightArm() != null) {
                    savedPoses.rightArm().applyRotation(part);
                    rightArmPart = part;
                }
            } else if ("[vanilla part left_sleeve]".equals(shortName)) {
                leftSleeve = part;
            } else if ("[vanilla part right_sleeve]".equals(shortName)) {
                rightSleeve = part;
            }
        }

        if (leftArmPart != null && leftSleeve != null) leftSleeve.copyFrom(leftArmPart);
        if (rightArmPart != null && rightSleeve != null) rightSleeve.copyFrom(rightArmPart);
    }
}
