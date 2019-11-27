package auth.vault;

import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.support.VaultResponseSupport;
import org.springframework.stereotype.Service;

@Service
public class VaultService implements VaultServiceInterface {

    private VaultTemplate template;

    public VaultService() {
        VaultEndpoint endPoint = new VaultEndpoint();

        endPoint.setScheme("http");
        template = new VaultTemplate(endPoint,
                new TokenAuthentication("s.D0ccpMEOGw4FP3TGwia9UnGt"));
    }
    @Override
    public String setSecret() {

        Secrets secrets = new Secrets();
        secrets.username = "hello";
        secrets.password = "world";

        template.write("vault/sigma", secrets);

        VaultResponseSupport<Secrets> response = template.read("vault/sigma", Secrets.class);
        System.out.println(response.getData().getUsername());

        //vaultTemplate.delete("vault/sigma");

        return response.getData().getUsername();
    }

    @Override
    public String getSecret() {

        Secrets secrets = new Secrets();

        VaultResponseSupport<Secrets> response = template.read("vault/sigma", Secrets.class);
        System.out.println(response.getData().getUsername());

        return response.getData().getUsername();
    }
}
