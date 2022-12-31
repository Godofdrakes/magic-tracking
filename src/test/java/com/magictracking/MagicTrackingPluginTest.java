package com.magictracking;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class MagicTrackingPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(MagicTrackingPlugin.class);
		RuneLite.main(args);
	}
}