package com.bparcuctembi.schoolmod;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderKarimEntity extends RenderLiving {

	public RenderKarimEntity(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		
	}

	private static final ResourceLocation karimTextureLocation = new ResourceLocation("schoolmod:textures/mobs/Karim2.png");

	
	protected ResourceLocation getEntityTexture(KarimEntity entity)  
	{
	    return karimTextureLocation;
	}
	
	protected ResourceLocation getEntityTexture(Entity entity)  
	{
	    return this.getEntityTexture((KarimEntity)entity);     
	}
}
