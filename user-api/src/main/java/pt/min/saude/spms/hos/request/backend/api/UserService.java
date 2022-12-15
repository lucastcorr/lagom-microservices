package pt.min.saude.spms.hos.request.backend.api;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.restCall;

import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;


public interface UserService extends Service {

    String SERVICE_NAME = "user-backend";

    @Override
    default Descriptor descriptor() {
        return named(SERVICE_NAME)
            .withCalls();
    }
}
