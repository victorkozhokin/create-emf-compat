package strm.createemfcompat;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import strm.createemfcompat.compat.EMFCompat;

@Mod(CreateEMFCompat.MOD_ID)
public class CreateEMFCompat {

    public static final String MOD_ID = "create_emf_compat";

    public CreateEMFCompat(IEventBus modEventBus) {

        modEventBus.addListener(this::onClientSetup);

    }

    private void onClientSetup(FMLClientSetupEvent event) {

        if (ModList.get().isLoaded("entity_model_features")) {
            EMFCompat.init();
        }
    }
}