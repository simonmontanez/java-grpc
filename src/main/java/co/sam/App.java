/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package co.sam;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException, InterruptedException {

        GrpcServer server = new GrpcServer();
        server.start();
        server.blockUntilShutdown();

    }
}
