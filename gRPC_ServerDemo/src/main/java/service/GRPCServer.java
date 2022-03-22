package service;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class GRPCServer {
    private static final Logger logger = Logger.getLogger(GRPCServer.class.getName());

    public static void main(String[] args) throws Exception {

        Server server = ServerBuilder.forPort(5000).addService(new UserService()).build();
        server.start();
        logger.info("server has connected "+server.getPort());
        server.awaitTermination(120, TimeUnit.SECONDS);
    }
}
