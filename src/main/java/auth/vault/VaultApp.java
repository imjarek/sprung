package auth.vault;

import org.springframework.context.annotation.Import;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponseSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class VaultApp {
    @PostMapping("/secret")
    public @ResponseBody String setSecret(String[] args) {

        VaultEndpoint endpoint = new VaultEndpoint();

        endpoint.setScheme("http");
        VaultTemplate vaultTemplate = new VaultTemplate(endpoint,
                new TokenAuthentication("s.D0ccpMEOGw4FP3TGwia9UnGt"));

        Secrets secrets = new Secrets();
        secrets.username = "hello";
        secrets.password = "world";

        vaultTemplate.write("vault/sigma", secrets);

        VaultResponseSupport<Secrets> response = vaultTemplate.read("vault/sigma", Secrets.class);
        System.out.println(response.getData().getUsername());

        //vaultTemplate.delete("vault/sigma");

        return response.getData().getUsername();
    }
    @GetMapping("/secret")
    public @ResponseBody String getSecret(String[] args) {

        VaultEndpoint endpoint = new VaultEndpoint();

        endpoint.setScheme("http");
        VaultTemplate vaultTemplate = new VaultTemplate(endpoint,
                new TokenAuthentication("s.D0ccpMEOGw4FP3TGwia9UnGt"));

        Secrets secrets = new Secrets();

        VaultResponseSupport<Secrets> response = vaultTemplate.read("vault/sigma", Secrets.class);
        System.out.println(response.getData().getUsername());

        return response.getData().getUsername();
    }
}