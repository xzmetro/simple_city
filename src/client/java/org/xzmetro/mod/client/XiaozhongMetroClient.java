package org.xzmetro.mod.client;

import net.fabricmc.api.ClientModInitializer;

import static org.xzmetro.mod.util.Constants.LOGGER;

public class XiaozhongMetroClient implements ClientModInitializer {

    @Override
	public void onInitializeClient() {
		LOGGER.info("[Xiaozhong's Metro] Mod Client Loaded!");
	}
}