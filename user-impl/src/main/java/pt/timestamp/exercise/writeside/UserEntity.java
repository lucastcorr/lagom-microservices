package pt.timestamp.exercise.writeside;

import com.lightbend.lagom.javadsl.persistence.PersistentEntity;
import java.util.Optional;
import pt.timestamp.exercise.schema.UserState;
import pt.timestamp.exercise.writeside.command.UserCommand;
import pt.timestamp.exercise.writeside.event.UserEvent;

public class UserEntity extends PersistentEntity<UserCommand, UserEvent, UserState> {

    @Override
    public Behavior initialBehavior(Optional<UserState> snapshotState) {
        if (snapshotState.isPresent()) {
            return existentPost(snapshotState.get());
        } else {
            return newPost();
        }
    }

    private Behavior newPost() {

        BehaviorBuilder builder = newBehaviorBuilder(new UserState());


        return builder.build();
    }

    private Behavior existentPost(UserState snapshot) {
        BehaviorBuilder builder = newBehaviorBuilder(snapshot);

        return builder.build();
    }


}
