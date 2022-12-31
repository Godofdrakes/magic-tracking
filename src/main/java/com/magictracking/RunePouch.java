package com.magictracking;

import lombok.RequiredArgsConstructor;
import net.runelite.api.Client;
import net.runelite.api.Varbits;

@RequiredArgsConstructor
public enum RunePouch
{
	Slot1(Varbits.RUNE_POUCH_RUNE1, Varbits.RUNE_POUCH_AMOUNT1),
	Slot2(Varbits.RUNE_POUCH_RUNE2, Varbits.RUNE_POUCH_AMOUNT2),
	Slot3(Varbits.RUNE_POUCH_RUNE3, Varbits.RUNE_POUCH_AMOUNT3),
	Slot4(Varbits.RUNE_POUCH_RUNE4, Varbits.RUNE_POUCH_AMOUNT4);

    private final int runeVarbit;
    private final int amountVarbit;

    public final int GetRune(Client client)
    {
        return client.getVarbitValue(this.runeVarbit);
    }

    public final int GetAmount(Client client)
    {
        return client.getVarbitValue(this.amountVarbit);
    }
}
