package ie.atu.labrecapweek4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    private RegistrationServiceClient registrationServiceClient;
    private final AcknowledgeService acknowledgeService;

    @Autowired
    public UserController(AcknowledgeService acknowledgeService, RegistrationServiceClient registrationServiceClient){
        this.acknowledgeService = acknowledgeService;
        this.registrationServiceClient = registrationServiceClient;
    }

    @PostMapping("/confirm-and-register")
    public String confirmAndRegister(@RequestBody UserDetails userDetails)
    {
        String confirm = registrationServiceClient.someDetails(userDetails);
        String response = confirm +" " + acknowledgeService.ackMessage(userDetails);
       Map<String, String> responseMessage = new HashMap<>();
       responseMessage.put("message",confirm);
        return response;
    }

}
