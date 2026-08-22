package org.xzmetro.mod.main;

import org.xzmetro.mod.BugUnfixedException;
import org.xzmetro.mod.block.ModBlocks;
import org.xzmetro.mod.sound.ModSounds;
import org.xzmetro.mod.tab.ModCreativeTabs;
import net.fabricmc.api.ModInitializer;

import static com.mojang.text2speech.Narrator.LOGGER;

public class XiaozhongMetro implements ModInitializer {
	@Override
	public void onInitialize() {
		ModSounds.initialize();
		ModBlocks.initialize();
		ModCreativeTabs.initialize();
		LOGGER.warn("[Xiaozhong's Metro] 版本存在已知错误！", new BugUnfixedException("方块\"xzmetro:fire_extinguisher_cabinet#opened=true\"模型异常，目前未修复！"));
		LOGGER.info("[Xiaozhong's Metro] Mod Loaded!");
	}
}
