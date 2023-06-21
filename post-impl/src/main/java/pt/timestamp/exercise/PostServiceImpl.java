package pt.timestamp.exercise;


import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import pt.min.saude.spms.hos.request.backend.api.PostService;
import static java.util.concurrent.CompletableFuture.completedFuture;

public class PostServiceImpl implements PostService {

    @Override
    public ServiceCall<NotUsed, String> createPost() {
        return toBeReturned -> completedFuture("Post created");
    }

    @Override
    public ServiceCall<NotUsed, String> updatePost() {
        return toBeReturned -> completedFuture("Post updated");
    }

    @Override
    public ServiceCall<NotUsed, String> getPostById() {
        return toBeReturned -> completedFuture("Some post returned");
    }
}
