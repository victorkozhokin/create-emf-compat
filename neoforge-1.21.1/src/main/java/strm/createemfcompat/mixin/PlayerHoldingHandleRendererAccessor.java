package strm.createemfcompat.mixin;

import dev.simulated_team.simulated.content.blocks.handle.PlayerHoldingHandleRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Set;
import java.util.UUID;

@Mixin(value = PlayerHoldingHandleRenderer.class, remap = false)
public interface PlayerHoldingHandleRendererAccessor {
    @Accessor("holdingPlayers")
    static Set<UUID> createEmfCompat$getHoldingPlayers() {
        throw new AssertionError();
    }
}
