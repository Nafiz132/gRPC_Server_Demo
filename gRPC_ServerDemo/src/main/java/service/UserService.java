package service;

import com.demo.grpc.User;
import com.demo.grpc.userGrpc;
import io.grpc.stub.StreamObserver;

import java.util.logging.Logger;

public class UserService extends userGrpc.userImplBase {
    private static final Logger logger= Logger.getLogger(UserService.class.getName());
    @Override
    public void login(User.LogParams request, StreamObserver<User.LogRes> responseObserver) {
        //super.login(request, responseObserver);
        String userName= request.getUsername();
        String password= request.getPassword();

        User.LogRes.Builder response = User.LogRes.newBuilder();

        if(userName.equals("sizan132")&& password.equals("laberVarsity")){
            response.setResCode(200).setMessage("SUCCESS");
        }else{
            response.setResCode(400).setMessage("BAD REQUEST");
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
