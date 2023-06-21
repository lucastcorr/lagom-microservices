package pt.timestamp.exercise.writeside;


import com.lightbend.lagom.javadsl.persistence.PersistentEntity;

import java.util.Optional;

public class EmojiEntity extends PersistentEntity<EmojiCommand, EmojiEvent, EmojiState> {

    @Override
    public Behavior initialBehavior(Optional<EmojiState> snapshotState) {
        BehaviorBuilder b = newBehaviorBuilder(
                snapshotState.orElse(EmojiState.EMPTY)
        );

        // Creation command handler
        b.setCommandHandler(
                CreateEmoji.class,
                (CreateEmoji cmd, CommandContext<CreateEmojiDone> ctx) -> {
                    // Can create logic to validate the command
                    final EmojiCreated postAdded = new EmojiCreated(entityId(), cmd.getContent());
                    return ctx.thenPersist(
                            postAdded,
                            (EmojiCreated evt) ->
                                    // After persist is done additional side effects can be performed
                                    ctx.reply(new CreateEmojiDone(entityId())));
                    ;
                });


        // Update command handler
        b.setCommandHandler(
                UpdateEmoji.class,
                (UpdateEmoji cmd, CommandContext<UpdateEmojiDone> ctx) -> {
                    // Can create logic to validate the command
                    final EmojiUpdated postAdded = new EmojiUpdated(entityId(), cmd.getContent());
                    return ctx.thenPersist(
                            postAdded,
                            (EmojiUpdated evt) ->
                                    // After persist is done additional side effects can be performed
                                    ctx.reply(new UpdateEmojiDone(entityId())));
                    ;
                });

        // Get by id command handler
        b.setReadOnlyCommandHandler(
                GetEmojiById.class,
                (GetEmojiById cmd, CommandContext<EmojiState> ctx) ->
                        ctx.reply(state().getContent().get())
        );

        // Update the state with the creation event
        b.setEventHandler(
                EmojiCreated.class,
                (EmojiCreated evt) -> new EmojiState(Optional.of(evt.getContent(), false))
        );

        // Update the state with de update event
        b.setEventHandler(
                EmojiUpdated.class,
                (EmojiUpdated evt) -> new EmojiState(Optional.of(evt.getContent(), false))
        );

        return b.build();
    }
}