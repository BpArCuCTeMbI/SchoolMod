package com.bparcuctembi.schoolmod;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class karimMethod extends Block {

	protected karimMethod() {
		super(Material.rock);
		this.setHarvestLevel("pickaxe", 2);
		
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public Item getItemDropped(int metadata, Random rand, int fortune)
	{
		return BaseSchoolMod.karim_essence;
	}
	
	@Override
    public int quantityDropped(Random par1Random)
    {
        return 3;
    }

}

///idk how these returns works

//test231