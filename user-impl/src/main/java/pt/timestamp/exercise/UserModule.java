package pt.timestamp.exercise;

import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;
import pt.min.saude.spms.hos.request.backend.api.UserService;

public class UserModule extends AbstractModule implements ServiceGuiceSupport {

    @Override
    protected void configure() {
        bindService(UserService.class, UserServiceImpl.class);
    }
}
