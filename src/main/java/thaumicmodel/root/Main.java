package thaumicmodel.root;

import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import thaumicmodel.proxy.CommonProxy;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION,
        dependencies = "required-after:mixin-booter; " +
                "required-after:thaumcraft;" +
                "after:thaumicbases;" +
                "after:thaumictinkerer;" +
                "after:thaumicconcilium;" +
                "after:kami")
public class Main {
    public static final String MODID = "thaumicmodel";
    public static final String NAME = "Thaumic Model";
    public static final String VERSION = "1.2.0";

    public static final Logger LOGGER = LogManager.getLogger(Main.NAME);

    @SidedProxy(
            clientSide = "thaumicmodel.network.proxy.ClientProxy",
            serverSide = "thaumicmodel.network.proxy.CommonProxy"
    )

    public static CommonProxy PROXY;
    @Mod.Instance(Main.MODID)
    public static Main instance;

    public Main() {
        this.ensureResourceOrder();
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }

    private void ensureResourceOrder() {
        if (!FMLCommonHandler.instance().getSide().isServer()) {
            String classname = "thaumicmodel.network.proxy.ResourceProxy";

            try {
                Class<?> clazz = Class.forName(classname);
                clazz.getMethod("init").invoke((Object)null);
            } catch (Throwable e) {
                LOGGER.error("Could not hook Resource Proxy.", e);
            }

        }
    }

}
