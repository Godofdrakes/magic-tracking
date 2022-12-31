package com.magictrackingtest;

import com.magictracking.Rune;
import com.magictracking.RuneStorage;
import junit.framework.TestCase;

public final class RuneStorageTest
		extends TestCase
{
	public static Rune[] getChildrenOrSelf(Rune rune)
	{
		final Rune[] children = rune.getChildren();
		return children.length > 0 ? children : new Rune[] { rune };
	}

	public void testDefaultEmpty()
	{
		final RuneStorage storage = new RuneStorage();

		for (Rune rune : Rune.values())
		{
			for (Rune test : getChildrenOrSelf(rune))
			{
				assertFalse(test.name(), storage.has(test, 1));
				assertFalse(test.name(), storage.has(test, Integer.MAX_VALUE));
			}
		}
	}

	public void testAddThenHas()
	{
		final RuneStorage storage = new RuneStorage();

		for (Rune rune : Rune.values())
		{
			storage.add(rune, 1);

			for (Rune test : getChildrenOrSelf(rune))
			{
				assertTrue(test.name(), storage.has(test, 1));
				assertFalse(test.name(), storage.has(test, Integer.MAX_VALUE));
			}
		}
	}

	public void testInfiniteThenHas()
	{
		final RuneStorage storage = new RuneStorage();

		for (Rune rune : Rune.values())
		{
			storage.addInfinite(rune);

			for (Rune test : getChildrenOrSelf(rune))
			{
				assertTrue(test.name(), storage.has(test, 1));
				assertTrue(test.name(), storage.has(test, Integer.MAX_VALUE));
			}
		}
	}

	public void testAddThenClear()
	{
		final RuneStorage storage = new RuneStorage();

		for (Rune rune : Rune.values())
		{
			storage.add(rune, 1);

			for (Rune test : getChildrenOrSelf(rune))
			{
				assertTrue(test.name(), storage.has(test, 1));
				assertFalse(test.name(), storage.has(test, Integer.MAX_VALUE));
			}
		}

		storage.clear();

		for (Rune rune : Rune.values())
		{
			for (Rune test : getChildrenOrSelf(rune))
			{
				assertFalse(test.name(), storage.has(test, 1));
				assertFalse(test.name(), storage.has(test, Integer.MAX_VALUE));
			}
		}
	}

	public void testInfiniteThenClear()
	{
		final RuneStorage storage = new RuneStorage();

		for (Rune rune : Rune.values())
		{
			storage.addInfinite(rune);

			for (Rune test : getChildrenOrSelf(rune))
			{
				assertTrue(test.name(), storage.has(test, 1));
				assertTrue(test.name(), storage.has(test, Integer.MAX_VALUE));
			}
		}

		storage.clear();

		for (Rune rune : Rune.values())
		{
			for (Rune test : getChildrenOrSelf(rune))
			{
				assertFalse(test.name(), storage.has(test, 1));
				assertFalse(test.name(), storage.has(test, Integer.MAX_VALUE));
			}
		}
	}
}
