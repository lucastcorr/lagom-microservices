package pt.timestamp.exercise.writeside;

import com.lightbend.lagom.javadsl.persistence.PersistentEntity;
import java.util.Optional;
import pt.timestamp.exercise.schema.PostState;
import pt.timestamp.exercise.writeside.command.PostCommand;
import pt.timestamp.exercise.writeside.event.PostEvent;

public class PostEntity extends PersistentEntity<PostCommand, PostEvent, PostState> {

    @Override
    public Behavior initialBehavior(Optional<PostState> snapshotState) {
        if (snapshotState.isPresent()) {
            return existentPost(snapshotState.get());
        } else {
            return newPost();
        }
    }

    private Behavior newPost() {

        BehaviorBuilder builder = newBehaviorBuilder(new PostState());


        return builder.build();
    }

    private Behavior existentPost(PostState snapshot) {
        BehaviorBuilder builder = newBehaviorBuilder(snapshot);

        return builder.build();
    }


}
