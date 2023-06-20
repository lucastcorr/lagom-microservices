package pt.timestamp.exercise;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import pt.min.saude.spms.hos.request.backend.api.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public ServiceCall<NotUsed, NotUsed> createUser() {
        return null;
    }

    @Override
    public ServiceCall<NotUsed, NotUsed> updateUser() {
        return null;
    }

    @Override
    public ServiceCall<NotUsed, NotUsed> getUserById() {
        
        return null;
    }
}
