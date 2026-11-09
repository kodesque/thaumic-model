package thaumicmodel.root;

import com.google.common.collect.ImmutableMap;
import fermiumbooter.FermiumRegistryAPI;
import net.minecraftforge.fml.common.Loader;
import zone.rong.mixinbooter.Context;
import zone.rong.mixinbooter.ILateMixinLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class ModMixinHandler implements ILateMixinLoader {
    private static final Map<String, Predicate<Context>> MIXIN_CONFIGS =
            ImmutableMap.copyOf(new HashMap<String, Predicate<Context>>() {{
                put("mixins.thaumicmodel.json", c -> true);

                put("mixins.thaumicmodel.thaumcraft.json", c -> c.isModPresent("thaumcraft"));
                put("mixins.thaumicmodel.tb.json", c -> c.isModPresent("thaumicbases"));
                put("mixins.thaumicmodel.tt.json", c -> c.isModPresent("thaumictinkerer"));
                put("mixins.thaumicmodel.tc.json", c -> c.isModPresent("thaumicconcilium"));
            }});

    public ModMixinHandler() {
    }

    public List<String> getMixinConfigs() {
        return new ArrayList(MIXIN_CONFIGS.keySet());
    }

    public boolean shouldMixinConfigQueue(Context context) {
        Predicate<Context> predicate = (Predicate)MIXIN_CONFIGS.get(context.mixinConfig());
        return predicate == null || predicate.test(context);
    }
}
