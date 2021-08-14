package mins.cloud.study.discovery;

import com.netflix.discovery.shared.Applications;
import com.netflix.eureka.EurekaServerContextHolder;
import com.netflix.eureka.registry.PeerAwareInstanceRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaServer
@SpringBootApplication
public class DiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryApplication.class, args);


    }

    @RestController
    public static class SystemCheck {

        @GetMapping("/getInstancesInfo")
        public ResponseEntity<String> getInstancesInfo() {
            StringBuilder sb = new StringBuilder();

            PeerAwareInstanceRegistry registry = EurekaServerContextHolder.getInstance().getServerContext().getRegistry();
            Applications applications = registry.getApplications();

            applications.getRegisteredApplications().forEach((registeredApplication) -> {
                registeredApplication.getInstances().forEach((instance) -> {
                    sb.append(instance.getAppName())
                            .append(" (").append(instance.getInstanceId()).append(") : ")
                            .append(instance.getHostName()).append(":").append(instance.getPort())
                            .append("\n")
                    ;
                });
            });

            return ResponseEntity.ok(sb.toString());
        }
    }

}
