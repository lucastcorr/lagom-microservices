package pt.timestamp.exercise.writeside.command;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.lightbend.lagom.serialization.Jsonable;
import lombok.Value;

import java.util.UUID;

public interface EmojiCommand extends Jsonable {

    @Value
    final class CreateEmoji implements EmojiCommand {
        UUID id;
        String name;

        @JsonCreator
        public CreateEmoji(UUID id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
