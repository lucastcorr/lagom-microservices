package pt.timestamp.exercise;


import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import pt.min.saude.spms.hos.request.backend.api.PostService;

public class PostServiceImpl implements PostService {

    @Override
    public ServiceCall<NotUsed, NotUsed> createPost() {
        return null;
    }

    @Override
    public ServiceCall<NotUsed, NotUsed> updatePost() {
        return null;
    }

    @Override
    public ServiceCall<NotUsed, NotUsed> getPostById() {
        return null;
    }
}
