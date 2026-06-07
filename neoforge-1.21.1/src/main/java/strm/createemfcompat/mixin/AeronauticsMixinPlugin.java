package strm.createemfcompat.mixin;

import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class AeronauticsMixinPlugin implements IMixinConfigPlugin {
    private boolean aeronauticsLoaded = false;

    @Override
    public void onLoad(String mixinPackage) {
        aeronauticsLoaded = Thread.currentThread().getContextClassLoader()
                .getResource("dev/simulated_team/simulated/content/blocks/handle/PlayerHoldingHandleRenderer.class") != null;
    }

    @Override
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if (mixinClassName.equals("strm.createemfcompat.mixin.PlayerHoldingHandleRendererAccessor")
                || mixinClassName.equals("strm.createemfcompat.mixin.PlayerHoldingHandleRendererMixin")) {
            return aeronauticsLoaded;
        }
        return true;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
    }
}
