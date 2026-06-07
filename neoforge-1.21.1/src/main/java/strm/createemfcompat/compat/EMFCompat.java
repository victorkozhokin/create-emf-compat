package strm.createemfcompat.compat;

import strm.createemfcompat.util.SavedPoses;
import traben.entity_model_features.EMFAnimationApi;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EMFCompat {
    public static final Map<UUID, SavedPoses> handleSavedPoses = new HashMap<>();
    public static long currentFrame = 0;

    public static void init() {
        try {
            EMFAnimationApi.registerPauseCondition(emfEntity -> {
                if (emfEntity.etf$isBlockEntity()) {
                    return false;
                }

                return SkyhookHelper.isSkyhooking(emfEntity.etf$getUuid());
            });
            EMFAnimationApi.registerVanillaModelCondition(emfEntity -> {
                if (emfEntity.etf$isBlockEntity()) {
                    return false;
                }

                return SkyhookHelper.isSkyhooking(emfEntity.etf$getUuid());
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
