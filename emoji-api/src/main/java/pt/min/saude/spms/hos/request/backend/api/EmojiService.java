package pt.min.saude.spms.hos.request.backend.api;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.restCall;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.transport.Method;


public interface EmojiService extends Service {

    String SERVICE_NAME = "emoji-backend";

    ServiceCall<NotUsed, String> createEmoji();
    ServiceCall<NotUsed, String> updateEmoji();
    ServiceCall<NotUsed, String> getEmojiById();

    @Override
    default Descriptor descriptor() {
        return named(SERVICE_NAME)
            .withCalls(
                    restCall(Method.POST, "/emoji", this::createEmoji),
                    restCall(Method.PATCH, "/emoji/:emojiId", this::updateEmoji),
                    restCall(Method.GET, "/emoji/:emojiId", this::getEmojiById)
            )
                .withAutoAcl(true);
    }
}
