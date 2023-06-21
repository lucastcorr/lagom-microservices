package pt.min.saude.spms.hos.request.backend.api;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.restCall;

import akka.Done;
import akka.NotUsed;
import akka.stream.javadsl.Source;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceAcl;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.broker.Topic;
import com.lightbend.lagom.javadsl.api.broker.kafka.KafkaProperties;
import com.lightbend.lagom.javadsl.api.transport.Method;
import java.util.Optional;


public interface PostService extends Service {

    String SERVICE_NAME = "post-backend";

    ServiceCall<NotUsed, String> createPost();
    ServiceCall<NotUsed, String> updatePost();
    ServiceCall<NotUsed, String> getPostById();

    @Override
    default Descriptor descriptor() {
        return named(SERVICE_NAME)
            .withCalls(
                    restCall(Method.POST, "/post", this::createPost),
                    restCall(Method.PATCH, "/post/:postId", this::updatePost),
                    restCall(Method.GET, "/post/:postId", this::getPostById)
            )
                .withAutoAcl(true);
    }
}
