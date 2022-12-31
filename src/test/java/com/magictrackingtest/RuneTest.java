package com.magictrackingtest;

import com.magictracking.Rune;
import junit.framework.TestCase;

public class RuneTest
		extends TestCase
{
	public void testComboRunes()
	{
		for (Rune parent : Rune.values())
		{
			final Rune[] children = parent.getChildren();

			assertNotNull(children);

			for (Rune child : children)
			{
				// check for circular reference
				assertNotSame(parent.name(), parent, child);
				// do not allow more than one level of recursion
				assertEquals(child.name(), 0, child.getChildren().length);
			}
		}
	}
}
