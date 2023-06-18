package pt.min.saude.spms.hos.request.backend.api;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.restCall;

import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;


public interface UserService extends Service {

    String SERVICE_NAME = "user-backend";

    ServiceCall<Request, Response> createUser();
    ServiceCall<Request, Response> updateUser();
    ServiceCall<Request, Response> getUserById();

    @Override
    default Descriptor descriptor() {
        return named(SERVICE_NAME)
            .withCalls(
                    restCall(Method.POST, "/user", this::createUser),
                    restCall(Method.PATCH, "/user/:userId", this::updateUser),
                    restCall(Method.GET, "/user/:userId", this::getUserById),
            );
    }
}
