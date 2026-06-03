package strm.createemfcompat.compat;

import strm.createemfcompat.mixin.PlayerSkyhookRendererAccessor;

import java.util.Set;
import java.util.UUID;

public class SkyhookHelper {

    public static boolean isSkyhooking(UUID playerUuid) {

        Set<UUID> hangingPlayers = PlayerSkyhookRendererAccessor.createEmfCompat$getHangingPlayers();
        return hangingPlayers != null && hangingPlayers.contains(playerUuid);

    }
}

