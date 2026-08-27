package org.simplecity.mod.main;

import org.simplecity.mod.BugUnfixedException;
import org.simplecity.mod.block.ModBlocks;
import org.simplecity.mod.sound.ModSounds;
import org.simplecity.mod.creativetab.ModCreativeTabs;
import org.simplecity.mod.util.Constants;
import net.fabricmc.api.ModInitializer;

public class SimpleCity implements ModInitializer {
	@Override
	public void onInitialize() {
		ModSounds.initialize();
		ModBlocks.initialize();
		ModCreativeTabs.initialize();
		Constants.LOGGER.warn("[Xiaozhong's Metro] 版本存在已知错误！", new BugUnfixedException("方块\"xzmetro:fire_extinguisher_cabinet#opened=true\"模型异常，目前未修复！"));
		Constants.LOGGER.info("[Xiaozhong's Metro] Mod Loaded!");
	}
}
