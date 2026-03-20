package syric.dragonseeker.registry;

import com.iafenvoy.iceandfire.registry.IafItemGroups;
import com.iafenvoy.iceandfire.registry.IafItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import syric.dragonseeker.Dragonseeker;
import syric.dragonseeker.item.tool.dragonseekerItem;
import syric.dragonseeker.item.tool.epicDragonseekerItem;
import syric.dragonseeker.item.tool.godlyDragonseekerItem;
import syric.dragonseeker.item.tool.legendaryDragonseekerItem;

@Mod.EventBusSubscriber(
        modid = "dragonseeker",
        bus = Mod.EventBusSubscriber.Bus.MOD
)
public class DSItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Dragonseeker.MODID);

    public static final RegistryObject<Item> DRAGONSEEKER = ITEMS.register("dragonseeker", dragonseekerItem::new);
    public static final RegistryObject<Item> EPICDRAGONSEEKER = ITEMS.register("epic_dragonseeker", epicDragonseekerItem::new);
    public static final RegistryObject<Item> LEGENDARYDRAGONSEEKER = ITEMS.register("legendary_dragonseeker", legendaryDragonseekerItem::new);
    public static final RegistryObject<Item> GODLYDRAGONSEEKER = ITEMS.register("godly_dragonseeker", godlyDragonseekerItem::new);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    @SubscribeEvent
    public static void buildCreativeModeTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == IafItemGroups.ITEMS.getKey()) {
            event.getEntries().putAfter(
                new ItemStack(IafItems.DRAGON_STAFF.get()),
                new ItemStack(DRAGONSEEKER.get()),
                CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
            event.getEntries().putAfter(
                new ItemStack(DRAGONSEEKER.get()),
                new ItemStack(EPICDRAGONSEEKER.get()),
                CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
            event.getEntries().putAfter(
                new ItemStack(EPICDRAGONSEEKER.get()),
                new ItemStack(LEGENDARYDRAGONSEEKER.get()),
                CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
            event.getEntries().putAfter(
                new ItemStack(LEGENDARYDRAGONSEEKER.get()),
                new ItemStack(GODLYDRAGONSEEKER.get()),
                CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
        }
    }
}
