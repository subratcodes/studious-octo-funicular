package subrat.learning.pim;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ConfigAutoRefresher2 {

    private  ContextRefresher refresher;

    public ConfigAutoRefresher2(
            @Qualifier("configDataContextRefresher") ContextRefresher refresher) {
        this.refresher = refresher;
    }

    @Scheduled(fixedRate = 12000)
    public void refreshConfig() {
        var keys = refresher.refresh();
        if (!keys.isEmpty()) {
            System.out.println("Config refreshed. Changed keys: " + keys);
        }
    }
}