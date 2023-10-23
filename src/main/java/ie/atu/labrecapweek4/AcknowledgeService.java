package ie.atu.labrecapweek4;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "acknowledgement-service", url = "http://localhost:8083")
public interface AcknowledgeService {
    @PostMapping("/acknowledge")
    String ackMessage(@RequestBody UserDetails userDetails);
}
