package pt.timestamp.exercise;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import pt.min.saude.spms.hos.request.backend.api.UserService;
import static java.util.concurrent.CompletableFuture.completedFuture;

public class UserServiceImpl implements UserService {

    @Override
    public ServiceCall<NotUsed, String> createUser() {
        return toBeReturned -> completedFuture("User created");
    }

    @Override
    public ServiceCall<NotUsed, String> updateUser() {
        return toBeReturned -> completedFuture("User updated");
    }

    @Override
    public ServiceCall<NotUsed, String> getUserById() {
        return toBeReturned -> completedFuture("Some user returned");
    }
}
