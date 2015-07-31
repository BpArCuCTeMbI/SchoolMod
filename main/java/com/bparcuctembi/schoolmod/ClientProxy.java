package com.bparcuctembi.schoolmod;

import net.minecraft.client.model.ModelBiped;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenderers() 
	{
		RenderingRegistry.registerEntityRenderingHandler(KarimEntity.class, new RenderKarimEntity(new KarimMobModel(), 0.5F));  
	}

}
