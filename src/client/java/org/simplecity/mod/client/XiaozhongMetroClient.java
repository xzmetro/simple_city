package org.simplecity.mod.client;

import net.fabricmc.api.ClientModInitializer;

import static org.simplecity.mod.util.Constants.LOGGER;

public class XiaozhongMetroClient implements ClientModInitializer {

    @Override
	public void onInitializeClient() {
		LOGGER.info("[Xiaozhong's Metro] Mod Client Loaded!");
	}
}