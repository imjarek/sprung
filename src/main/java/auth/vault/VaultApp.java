package auth.vault;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class VaultApp {

    @Autowired
    private VaultServiceInterface vaultService;

    public VaultApp (VaultServiceInterface vaultService) {
        this.vaultService = vaultService;
    }
    @PostMapping("/secret")
    public @ResponseBody String setSecret(String[] args) {

        return vaultService.setSecret();
    }
    @GetMapping("/secret")
    public @ResponseBody String getSecret(String[] args) {

        return vaultService.getSecret();
    }
}