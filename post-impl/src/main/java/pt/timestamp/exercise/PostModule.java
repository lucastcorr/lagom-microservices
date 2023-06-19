package pt.timestamp.exercise;

import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;
import pt.min.saude.spms.hos.request.backend.api.PostService;

public class PostModule extends AbstractModule implements ServiceGuiceSupport {

    @Override
    protected void configure() {
        bindService(PostService.class, PostServiceImpl.class);
    }
}
