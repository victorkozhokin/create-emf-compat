package strm.createemfcompat.mixin;

import dev.simulated_team.simulated.content.blocks.handle.PlayerHoldingHandleRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import strm.createemfcompat.compat.EMFCompat;
import strm.createemfcompat.util.PoseSnapshot;
import strm.createemfcompat.util.SavedPoses;

import java.util.Collection;
import java.util.Set;
import java.util.UUID;

@Mixin(value = PlayerHoldingHandleRenderer.class, remap = false)
public class PlayerHoldingHandleRendererMixin {

    @Inject(method = "afterSetupAnim", at = @At("RETURN"))
    private static void createemfcompat$onAfterSetupAnim(Player player, HumanoidModel<?> model, CallbackInfo ci) {
        if (player == null || model == null) return;
        if (Minecraft.getInstance().isPaused()) return;

        Set<UUID> holdingPlayers = PlayerHoldingHandleRendererAccessor.createEmfCompat$getHoldingPlayers();
        if (holdingPlayers == null || !holdingPlayers.contains(player.getUUID())) {
            return;
        }

        PoseSnapshot left = new PoseSnapshot(model.leftArm);
        PoseSnapshot right = new PoseSnapshot(model.rightArm);
        EMFCompat.handleSavedPoses.put(player.getUUID(), new SavedPoses(left, right));
        EMFCompat.currentFrame++;
    }

    @Inject(method = "updatePlayerList", at = @At("RETURN"))
    private static void createemfcompat$onUpdatePlayerList(Collection<UUID> uuids, CallbackInfo ci) {
        EMFCompat.handleSavedPoses.keySet().removeIf(uuid -> !uuids.contains(uuid));
    }
}
