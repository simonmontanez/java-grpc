package co.sam;

import co.sam.livecheck.LiveCheckService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.logging.Logger;

public class GrpcServer {

    private static final Logger logger = Logger.getLogger(GrpcServer.class.getName());

    private Server server;

    public void start() throws IOException {
        int port  = 50051;
        server = ServerBuilder.forPort(port)
                .addService(new LiveCheckService())
                .build()
                .start();
        logger.info("Server started, listening on " + port);

        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                System.err.println("** sutting down gRPC server since JVM is shutting down");
                stopGrpc();
            }
        });
    }

    private void stopGrpc () {
        if(server != null) server.shutdown();
    }

    public void blockUntilShutdown() throws InterruptedException {
        if(server != null) server.awaitTermination();
    }

}
