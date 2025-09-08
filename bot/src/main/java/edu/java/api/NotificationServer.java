package edu.java.api;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;
import java.util.logging.Logger;

public class NotificationServer {
        private static final Logger logger = Logger.getLogger(NotificationServer.class.getName());

        private Server server;

        private void start() throws IOException {
            /* The port on which the server should run */
            int port = 8081;
            server = ServerBuilder.forPort(port)
                .build()
                .start();
            logger.info("Server started, listening on " + port);
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                logger.info("*** shutting down gRPC server since JVM is shutting down");
                this.stop();
                logger.info("*** server shut down");
            }));
        }

        private void stop() {
            if (server != null) {
                server.shutdown();
            }
        }


        public static void main(String[] args) throws IOException, InterruptedException {

        }
}
