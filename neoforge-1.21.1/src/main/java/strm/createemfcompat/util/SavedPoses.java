package strm.createemfcompat.util;

import org.jetbrains.annotations.Nullable;

public record SavedPoses
        (
        @Nullable PoseSnapshot leftArm,
        @Nullable PoseSnapshot rightArm
        )
        {}
