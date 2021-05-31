import org.zju.vipa.aix.container.common.config.NetworkConfig;
import org.zju.vipa.aix.web.container.util.PropertyUtils;

/**
 * @Date: 2021/2/1 21:17
 * @Author: EricMa
 * @Description: todo:
 */
public class TestProp {
    public static void main(String[] args) {
        System.out.println(PropertyUtils.getProperty("application.properties","zk.server.url","zookeeper://120.79.221.129:2181"));
    }
}
