package com.magictracking;

import java.util.HashMap;
import java.util.HashSet;

public final class RuneStorage
{
	private final HashMap<Rune, Integer> _quantityMap = new HashMap<>();

	private final HashSet<Rune> _infiniteMap = new HashSet<>();

	public RuneStorage()
	{
		clear();
	}

	public void clear()
	{
		_infiniteMap.clear();

		for (Rune rune : Rune.values())
		{
			_quantityMap.put(rune, 0);
		}
	}

	public void add(Rune rune, int count)
	{
		final Rune[] children = rune.getChildren();

		assert children != null;

		if (children.length > 0)
		{
			for (Rune child : children)
			{
				add(child, count);
			}

			return;
		}

		assert _quantityMap.containsKey(rune);
		_quantityMap.put(rune, _quantityMap.get(rune) + count);
	}

	public void addInfinite(Rune rune)
	{
		final Rune[] children = rune.getChildren();

		assert children != null;

		if (children.length > 0)
		{
			for (Rune child : children)
			{
				addInfinite(child);
			}

			return;
		}

		_infiniteMap.add(rune);
	}

	public boolean has(Rune rune, int count)
	{
		if (_infiniteMap.contains(rune)) { return true; }
		assert _quantityMap.containsKey(rune);
		return _quantityMap.get(rune) >= count;
	}

	public int get(Rune rune)
	{
		assert _quantityMap.containsKey(rune);
		return _quantityMap.get(rune);
	}
}
