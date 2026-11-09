package thaumicmodel.util;

import net.minecraft.client.resources.AbstractResourcePack;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Set;

public class ResourcePack extends AbstractResourcePack {
    public ResourcePack(File resourcePackFileIn) {
        super(resourcePackFileIn);
    }

    @Override
    protected InputStream getInputStreamByName(String name) throws IOException {
        return null;
    }

    @Override
    protected boolean hasResourceName(String name) {
        return false;
    }

    @Override
    public Set<String> getResourceDomains() {
        return Collections.emptySet();
    }
}
