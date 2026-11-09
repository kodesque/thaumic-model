package thaumicmodel.network.proxy;

import com.google.common.collect.ImmutableSet;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.AbstractResourcePack;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import thaumicmodel.ThaumicModelMod;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class ResourceProxy extends AbstractResourcePack {

    public static final String[] DEFAULT_RESOURCE_PACKS = {
            "aD",
            "field_110449_ao",
            "defaultResourcePacks"
    };

    private static final Set<String> RESOURCE_DOMAINS = ImmutableSet.of(
            "thaumcraft",
            "thaumictinkerer",
            "thaumicbases",
            "thaumicconcilium"
    );

    private static final HashMap<String, Boolean> found = new HashMap<>();

    public static void init() {
        List<IResourcePack> resourcePacks =
                (List<IResourcePack>) ReflectionHelper.getPrivateValue(
                        Minecraft.class,
                        Minecraft.getMinecraft(),
                        DEFAULT_RESOURCE_PACKS
                );

        resourcePacks.add(new ResourceProxy());
    }

    private ResourceProxy() {
        super(Loader.instance().activeModContainer().getSource());
    }

    @Override
    public Set<String> getResourceDomains() {
        return RESOURCE_DOMAINS;
    }

    @Override
    public InputStream getInputStream(ResourceLocation location) throws IOException {
        return location == null ? null : stream(location.getPath());
    }

    @Override
    public boolean resourceExists(ResourceLocation location) {
        String name = location.getPath();

        if (name.startsWith("assets/minecraft") && !name.contains("creative_inventory")) {
            return false;
        }

        if (!found.containsKey(name)) {
            locate(name);
        }

        return found.get(name);
    }

    @Override
    protected InputStream getInputStreamByName(String name) throws IOException {
        return null;
    }

    @Override
    protected boolean hasResourceName(String name) {
        return false;
    }

    private void locate(String name) {
        InputStream stream = stream(name);

        try {
            found.put(name, stream != null);
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException ignored) {
                }
            }
        }
    }

    private InputStream stream(String name) {
        if (!name.startsWith("/")) {
            name = "/" + name;
        }

        return ThaumicModelMod.class.getResourceAsStream(name);
    }

    @Override
    protected void logNameNotLowercase(String name) {
    }

    @Override
    public String getPackName() {
        return "thaumicmodel-texture-proxy";
    }
}
