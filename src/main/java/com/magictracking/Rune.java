package com.magictracking;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.ItemID;

@RequiredArgsConstructor
@Getter
public enum Rune
{
	Air(ItemID.AIR_RUNE),
	Water(ItemID.WATER_RUNE),
	Earth(ItemID.EARTH_RUNE),
	Fire(ItemID.FIRE_RUNE),

	Mist(ItemID.MIST_RUNE, new Rune[]{Rune.Air, Rune.Water}),
	Dust(ItemID.DUST_RUNE, new Rune[]{Rune.Air, Rune.Earth}),
	Mud(ItemID.MUD_RUNE, new Rune[]{Rune.Water, Rune.Earth}),
	Smoke(ItemID.SMOKE_RUNE, new Rune[]{Rune.Air, Rune.Fire}),
	Steam(ItemID.STEAM_RUNE, new Rune[]{Rune.Water, Rune.Fire}),
	Lava(ItemID.LAVA_RUNE, new Rune[]{Rune.Earth, Rune.Fire}),

	Mind(ItemID.MIND_RUNE),
	Chaos(ItemID.CHAOS_RUNE),
	Death(ItemID.DEATH_RUNE),
	Blood(ItemID.BLOOD_RUNE),
	Wrath(ItemID.WRATH_RUNE),

	Body(ItemID.BODY_RUNE),
	Cosmic(ItemID.COSMIC_RUNE),
	Astral(ItemID.ASTRAL_RUNE),
	Nature(ItemID.NATURE_RUNE),
	Law(ItemID.LAW_RUNE),
	Soul(ItemID.SOUL_RUNE);

	Rune(int itemId)
	{
		this.itemId = itemId;
		this.children = new Rune[0];
	}

	private final int itemId;
	private final Rune[] children;
}
