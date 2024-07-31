package com.dksapp.policysyncup.Controller;

import com.dksapp.policysyncup.Controller.DTOs.IncEnvPol;
import com.dksapp.policysyncup.Services.PolicySyncUpStatus;
import com.dksapp.policysyncup.Services.UpdatePolicies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/PolicySyncUp")
@RestController
public class PolicySyncUpController {

    @Autowired
    private final PolicySyncUpStatus policySyncUpStatus;

    @Autowired
    private final UpdatePolicies updatePolicies;

    public PolicySyncUpController(PolicySyncUpStatus policySyncUpStatus, UpdatePolicies updatePolicies) {
        this.policySyncUpStatus = policySyncUpStatus;
        this.updatePolicies = new UpdatePolicies();
    }


    @GetMapping("/{incidentNumber}")
    public boolean PolicySyncUpStatus(@PathVariable String incidentNumber) {

        return policySyncUpStatus.policySyncUpStatusFromDB(incidentNumber);
    }

    @PutMapping
    public boolean PolicySyncUp(@RequestBody IncEnvPol incEnvPolDetails) {
        System.out.println(incEnvPolDetails);
        return updatePolicies.updatePolicies(incEnvPolDetails);
    }
}
