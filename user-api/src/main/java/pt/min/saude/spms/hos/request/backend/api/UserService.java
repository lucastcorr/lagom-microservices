package pt.min.saude.spms.hos.request.backend.api;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.restCall;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.transport.Method;


public interface UserService extends Service {

    String SERVICE_NAME = "user-backend";

    ServiceCall<NotUsed, String> createUser();
    ServiceCall<NotUsed, String> updateUser();
    ServiceCall<NotUsed, String> getUserById();

    @Override
    default Descriptor descriptor() {
        return named(SERVICE_NAME)
            .withCalls(
                    restCall(Method.POST, "/user", this::createUser),
                    restCall(Method.PATCH, "/user/:userId", this::updateUser),
                    restCall(Method.GET, "/user/:userId", this::getUserById)
            )
                .withAutoAcl(true);
    }
}
