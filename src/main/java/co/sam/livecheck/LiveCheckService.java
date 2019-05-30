package co.sam.livecheck;

import io.grpc.stub.StreamObserver;
import co.sam.livecheck.LiveCheck.*;

public class LiveCheckService extends LiveCheckerGrpc.LiveCheckerImplBase{

    @Override
    public void live(LiveRequest request, StreamObserver<LiveReply> responseObserver) {
        responseObserver.onNext(LiveReply.newBuilder().setMessage("I'm alive... thanks").build());
        responseObserver.onCompleted();
    }

}


