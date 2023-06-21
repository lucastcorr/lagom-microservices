package pt.timestamp.exercise;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import pt.min.saude.spms.hos.request.backend.api.EmojiService;
import static java.util.concurrent.CompletableFuture.completedFuture;

public class EmojiServiceImpl implements EmojiService {

    @Override
    public ServiceCall<NotUsed, String> createEmoji() {
        return toBeReturned -> completedFuture("Emoji created");
    }

    @Override
    public ServiceCall<NotUsed, String> updateEmoji() {
        return toBeReturned -> completedFuture("Emoji created");
    }

    @Override
    public ServiceCall<NotUsed, String> getEmojiById() {
        return toBeReturned -> completedFuture("Some emoji returned");
    }

}
