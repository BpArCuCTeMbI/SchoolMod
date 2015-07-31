package com.bparcuctembi.schoolmod;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod (modid = "schoolmod", name = "School Mod", version = "1.0a")

public class BaseSchoolMod
{
	public static KarimGenerator karimgenerator = new KarimGenerator();
	public static Block karim;
	public static Item karim_essence;
	public static CreativeTabs tabKarim = new TabKarim(0, "schoolmod");
	
	/*public static CreativeTabs tabCustom = new CreativeTabs("tabName") {
	    @Override
	    @SideOnly(Side.CLIENT)
	    public Item getTabIconItem() {	
	        return Items.ender_eye;
	    }
	};

	*/
	
	//proxy for mobs and renderer
	@Instance("schoolmod")
	public static BaseSchoolMod instance;
	
	@SidedProxy(clientSide = "com.bparcuctembi.schoolmod.ClientProxy", serverSide = "com.bparcuctembi.schoolmod.CommonProxy")
	public static CommonProxy proxy;
	
	//karim Mob method
	
	public static void registerEntity(Class entityClass, String name, int primaryColor, int secondaryColor) 
	{
	    int entityID = EntityRegistry.findGlobalUniqueEntityId();
	    long seed = name.hashCode();

	    EntityRegistry.registerGlobalEntityID(entityClass, name, entityID);
	    EntityRegistry.registerModEntity(entityClass, name, entityID, instance, 64, 1, true);
	    EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityList.EntityEggInfo(entityID,         primaryColor, secondaryColor)); 
	}
	
	
	@EventHandler
	public void preLoad(FMLPreInitializationEvent event)
	{
		//karim block
		karim = new karimMethod().setBlockName("Karim").setHardness(15F).setResistance(10F).setLightLevel(100F).setBlockTextureName("schoolmod:karimblock");
		karim.setCreativeTab(this.tabKarim);
		GameRegistry.registerBlock(karim, "karim");
		
		//karim essence
		karim_essence = new KarimEssence().setUnlocalizedName("karim_essence");
		GameRegistry.registerItem(karim_essence, "karim_essence");
		karim_essence.setCreativeTab(this.tabKarim);
		
		//recipe for karim block
		GameRegistry.addRecipe(new ItemStack(BaseSchoolMod.karim, 1), 
                new Object[]{ "###", "###", "###",
                ('#'), this.karim_essence});
		
		//block generation (karim)
		GameRegistry.registerWorldGenerator(karimgenerator, 0);
		
		//entity test
		registerEntity(KarimEntity.class, "karimEntity", 0x00FFFF, 0x00008B);
		
		proxy.registerRenderers();
	}
}
