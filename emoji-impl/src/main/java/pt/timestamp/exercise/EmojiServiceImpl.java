package pt.timestamp.exercise;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import pt.min.saude.spms.hos.request.backend.api.EmojiService;

public class EmojiServiceImpl implements EmojiService {

    @Override
    public ServiceCall<NotUsed, NotUsed> createEmoji() {
        return null;
    }

    @Override
    public ServiceCall<NotUsed, NotUsed> updateEmoji() {
        return null;
    }

    @Override
    public ServiceCall<NotUsed, NotUsed> getEmojiById() {
        return null;
    }

}
