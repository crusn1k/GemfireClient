import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.client.ClientRegionFactory;
import com.gemstone.gemfire.cache.client.ClientRegionShortcut;

public class Test {

    public static void main(String[] args) {
        ClientCacheFactory cf = new ClientCacheFactory().addPoolLocator("localhost", 1337);
        ClientCache cache = cf.setPdxReadSerialized(true).create();
        ClientRegionFactory rf = cache.createClientRegionFactory(ClientRegionShortcut.PROXY);

        Region region = rf.create("kachra");
        setValueInCache(region);
        getValueFromCache(region);
    }

    private static void setValueInCache(Region region) {
        region.put("test", "test");
    }

    private static void getValueFromCache(Region region) {
        System.out.println(region.get("test"));
    }
}
