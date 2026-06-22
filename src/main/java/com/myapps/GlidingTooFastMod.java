package com.myapps;

import com.myapps.server.ServerTickAction;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GlidingTooFastMod implements ModInitializer {

    public static final String MOD_ID = "glidingtoofast";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Gliding Too Fast mod!");
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            ServerTickAction.execute(server);
        });
    }
}
