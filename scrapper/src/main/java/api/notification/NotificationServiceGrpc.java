package api.notification;

import common.BooleanResponse;
import common.IdRequest;
import notification.UpdateGroupRequest;
import notification.UpdateMailingRequest;
import notification.UpdateNotifyRequest;
import static io.grpc.MethodDescriptor.generateFullMethodName;

@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.59.0)",
    comments = "Source: api/notification_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class NotificationServiceGrpc {

  private NotificationServiceGrpc() {}

  public static final String SERVICE_NAME = "notification.NotificationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<UpdateMailingRequest,
      com.google.protobuf.Empty> getUpdateMailingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateMailing",
      requestType = UpdateMailingRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<UpdateMailingRequest,
      com.google.protobuf.Empty> getUpdateMailingMethod() {
    io.grpc.MethodDescriptor<UpdateMailingRequest, com.google.protobuf.Empty> getUpdateMailingMethod;
    if ((getUpdateMailingMethod = NotificationServiceGrpc.getUpdateMailingMethod) == null) {
      synchronized (NotificationServiceGrpc.class) {
        if ((getUpdateMailingMethod = NotificationServiceGrpc.getUpdateMailingMethod) == null) {
          NotificationServiceGrpc.getUpdateMailingMethod = getUpdateMailingMethod =
              io.grpc.MethodDescriptor.<UpdateMailingRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateMailing"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  UpdateMailingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new NotificationServiceMethodDescriptorSupplier("UpdateMailing"))
              .build();
        }
      }
    }
    return getUpdateMailingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<IdRequest,
      BooleanResponse> getGetMailingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMailing",
      requestType = IdRequest.class,
      responseType = BooleanResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<IdRequest,
      BooleanResponse> getGetMailingMethod() {
    io.grpc.MethodDescriptor<IdRequest, BooleanResponse> getGetMailingMethod;
    if ((getGetMailingMethod = NotificationServiceGrpc.getGetMailingMethod) == null) {
      synchronized (NotificationServiceGrpc.class) {
        if ((getGetMailingMethod = NotificationServiceGrpc.getGetMailingMethod) == null) {
          NotificationServiceGrpc.getGetMailingMethod = getGetMailingMethod =
              io.grpc.MethodDescriptor.<IdRequest, BooleanResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMailing"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  IdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  BooleanResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NotificationServiceMethodDescriptorSupplier("GetMailing"))
              .build();
        }
      }
    }
    return getGetMailingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<UpdateGroupRequest,
      com.google.protobuf.Empty> getUpdateGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateGroup",
      requestType = UpdateGroupRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<UpdateGroupRequest,
      com.google.protobuf.Empty> getUpdateGroupMethod() {
    io.grpc.MethodDescriptor<UpdateGroupRequest, com.google.protobuf.Empty> getUpdateGroupMethod;
    if ((getUpdateGroupMethod = NotificationServiceGrpc.getUpdateGroupMethod) == null) {
      synchronized (NotificationServiceGrpc.class) {
        if ((getUpdateGroupMethod = NotificationServiceGrpc.getUpdateGroupMethod) == null) {
          NotificationServiceGrpc.getUpdateGroupMethod = getUpdateGroupMethod =
              io.grpc.MethodDescriptor.<UpdateGroupRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateGroup"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  UpdateGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new NotificationServiceMethodDescriptorSupplier("UpdateGroup"))
              .build();
        }
      }
    }
    return getUpdateGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<IdRequest,
      BooleanResponse> getCheckGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckGroup",
      requestType = IdRequest.class,
      responseType = BooleanResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<IdRequest,
      BooleanResponse> getCheckGroupMethod() {
    io.grpc.MethodDescriptor<IdRequest, BooleanResponse> getCheckGroupMethod;
    if ((getCheckGroupMethod = NotificationServiceGrpc.getCheckGroupMethod) == null) {
      synchronized (NotificationServiceGrpc.class) {
        if ((getCheckGroupMethod = NotificationServiceGrpc.getCheckGroupMethod) == null) {
          NotificationServiceGrpc.getCheckGroupMethod = getCheckGroupMethod =
              io.grpc.MethodDescriptor.<IdRequest, BooleanResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CheckGroup"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  IdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  BooleanResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NotificationServiceMethodDescriptorSupplier("CheckGroup"))
              .build();
        }
      }
    }
    return getCheckGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<UpdateNotifyRequest,
      com.google.protobuf.Empty> getUpdateNotifyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateNotify",
      requestType = UpdateNotifyRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<UpdateNotifyRequest,
      com.google.protobuf.Empty> getUpdateNotifyMethod() {
    io.grpc.MethodDescriptor<UpdateNotifyRequest, com.google.protobuf.Empty> getUpdateNotifyMethod;
    if ((getUpdateNotifyMethod = NotificationServiceGrpc.getUpdateNotifyMethod) == null) {
      synchronized (NotificationServiceGrpc.class) {
        if ((getUpdateNotifyMethod = NotificationServiceGrpc.getUpdateNotifyMethod) == null) {
          NotificationServiceGrpc.getUpdateNotifyMethod = getUpdateNotifyMethod =
              io.grpc.MethodDescriptor.<UpdateNotifyRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateNotify"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  UpdateNotifyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new NotificationServiceMethodDescriptorSupplier("UpdateNotify"))
              .build();
        }
      }
    }
    return getUpdateNotifyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<IdRequest,
      BooleanResponse> getGetNotifyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNotify",
      requestType = IdRequest.class,
      responseType = BooleanResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<IdRequest,
      BooleanResponse> getGetNotifyMethod() {
    io.grpc.MethodDescriptor<IdRequest, BooleanResponse> getGetNotifyMethod;
    if ((getGetNotifyMethod = NotificationServiceGrpc.getGetNotifyMethod) == null) {
      synchronized (NotificationServiceGrpc.class) {
        if ((getGetNotifyMethod = NotificationServiceGrpc.getGetNotifyMethod) == null) {
          NotificationServiceGrpc.getGetNotifyMethod = getGetNotifyMethod =
              io.grpc.MethodDescriptor.<IdRequest, BooleanResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetNotify"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  IdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  BooleanResponse.getDefaultInstance()))
              .setSchemaDescriptor(new NotificationServiceMethodDescriptorSupplier("GetNotify"))
              .build();
        }
      }
    }
    return getGetNotifyMethod;
  }

    public static NotificationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NotificationServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NotificationServiceStub>() {
        @Override
        public NotificationServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NotificationServiceStub(channel, callOptions);
        }
      };
    return NotificationServiceStub.newStub(factory, channel);
  }

    public static NotificationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NotificationServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NotificationServiceBlockingStub>() {
        @Override
        public NotificationServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NotificationServiceBlockingStub(channel, callOptions);
        }
      };
    return NotificationServiceBlockingStub.newStub(factory, channel);
  }

    public static NotificationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NotificationServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<NotificationServiceFutureStub>() {
        @Override
        public NotificationServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new NotificationServiceFutureStub(channel, callOptions);
        }
      };
    return NotificationServiceFutureStub.newStub(factory, channel);
  }

    public interface AsyncService {

        default void updateMailing(UpdateMailingRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateMailingMethod(), responseObserver);
    }

        default void getMailing(
            IdRequest request,
        io.grpc.stub.StreamObserver<BooleanResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMailingMethod(), responseObserver);
    }

        default void updateGroup(UpdateGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateGroupMethod(), responseObserver);
    }

        default void checkGroup(
            IdRequest request,
        io.grpc.stub.StreamObserver<BooleanResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCheckGroupMethod(), responseObserver);
    }

        default void updateNotify(UpdateNotifyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateNotifyMethod(), responseObserver);
    }

        default void getNotify(
            IdRequest request,
        io.grpc.stub.StreamObserver<BooleanResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetNotifyMethod(), responseObserver);
    }
  }

    public static abstract class NotificationServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return NotificationServiceGrpc.bindService(this);
    }
  }

    public static final class NotificationServiceStub
      extends io.grpc.stub.AbstractAsyncStub<NotificationServiceStub> {
    private NotificationServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected NotificationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NotificationServiceStub(channel, callOptions);
    }

        public void updateMailing(UpdateMailingRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateMailingMethod(), getCallOptions()), request, responseObserver);
    }

        public void getMailing(
            IdRequest request,
        io.grpc.stub.StreamObserver<BooleanResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMailingMethod(), getCallOptions()), request, responseObserver);
    }

        public void updateGroup(UpdateGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateGroupMethod(), getCallOptions()), request, responseObserver);
    }

        public void checkGroup(
            IdRequest request,
        io.grpc.stub.StreamObserver<BooleanResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCheckGroupMethod(), getCallOptions()), request, responseObserver);
    }

        public void updateNotify(UpdateNotifyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateNotifyMethod(), getCallOptions()), request, responseObserver);
    }

        public void getNotify(
            IdRequest request,
        io.grpc.stub.StreamObserver<BooleanResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetNotifyMethod(), getCallOptions()), request, responseObserver);
    }
  }

    public static final class NotificationServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<NotificationServiceBlockingStub> {
    private NotificationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected NotificationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NotificationServiceBlockingStub(channel, callOptions);
    }

        public com.google.protobuf.Empty updateMailing(UpdateMailingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMailingMethod(), getCallOptions(), request);
    }

        public BooleanResponse getMailing(IdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMailingMethod(), getCallOptions(), request);
    }

        public com.google.protobuf.Empty updateGroup(UpdateGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateGroupMethod(), getCallOptions(), request);
    }

        public BooleanResponse checkGroup(IdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckGroupMethod(), getCallOptions(), request);
    }

        public com.google.protobuf.Empty updateNotify(UpdateNotifyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateNotifyMethod(), getCallOptions(), request);
    }

        public BooleanResponse getNotify(IdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetNotifyMethod(), getCallOptions(), request);
    }
  }

    public static final class NotificationServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<NotificationServiceFutureStub> {
    private NotificationServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected NotificationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NotificationServiceFutureStub(channel, callOptions);
    }

        public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> updateMailing(
        UpdateMailingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateMailingMethod(), getCallOptions()), request);
    }

        public com.google.common.util.concurrent.ListenableFuture<BooleanResponse> getMailing(
        IdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMailingMethod(), getCallOptions()), request);
    }

        public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> updateGroup(
        UpdateGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateGroupMethod(), getCallOptions()), request);
    }

        public com.google.common.util.concurrent.ListenableFuture<BooleanResponse> checkGroup(
        IdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCheckGroupMethod(), getCallOptions()), request);
    }

        public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> updateNotify(
        UpdateNotifyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateNotifyMethod(), getCallOptions()), request);
    }

        public com.google.common.util.concurrent.ListenableFuture<BooleanResponse> getNotify(
        IdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetNotifyMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_UPDATE_MAILING = 0;
  private static final int METHODID_GET_MAILING = 1;
  private static final int METHODID_UPDATE_GROUP = 2;
  private static final int METHODID_CHECK_GROUP = 3;
  private static final int METHODID_UPDATE_NOTIFY = 4;
  private static final int METHODID_GET_NOTIFY = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UPDATE_MAILING:
          serviceImpl.updateMailing((UpdateMailingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_MAILING:
          serviceImpl.getMailing((IdRequest) request,
              (io.grpc.stub.StreamObserver<BooleanResponse>) responseObserver);
          break;
        case METHODID_UPDATE_GROUP:
          serviceImpl.updateGroup((UpdateGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CHECK_GROUP:
          serviceImpl.checkGroup((IdRequest) request,
              (io.grpc.stub.StreamObserver<BooleanResponse>) responseObserver);
          break;
        case METHODID_UPDATE_NOTIFY:
          serviceImpl.updateNotify((UpdateNotifyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_NOTIFY:
          serviceImpl.getNotify((IdRequest) request,
              (io.grpc.stub.StreamObserver<BooleanResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getUpdateMailingMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              UpdateMailingRequest,
              com.google.protobuf.Empty>(
                service, METHODID_UPDATE_MAILING)))
        .addMethod(
          getGetMailingMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
                IdRequest,
                BooleanResponse>(
                service, METHODID_GET_MAILING)))
        .addMethod(
          getUpdateGroupMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              UpdateGroupRequest,
              com.google.protobuf.Empty>(
                service, METHODID_UPDATE_GROUP)))
        .addMethod(
          getCheckGroupMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
                IdRequest,
                BooleanResponse>(
                service, METHODID_CHECK_GROUP)))
        .addMethod(
          getUpdateNotifyMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              UpdateNotifyRequest,
              com.google.protobuf.Empty>(
                service, METHODID_UPDATE_NOTIFY)))
        .addMethod(
          getGetNotifyMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
                IdRequest,
                BooleanResponse>(
                service, METHODID_GET_NOTIFY)))
        .build();
  }

  private static abstract class NotificationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    NotificationServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return notification.NotificationServiceOuterClass.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("NotificationService");
    }
  }

  private static final class NotificationServiceFileDescriptorSupplier
      extends NotificationServiceBaseDescriptorSupplier {
    NotificationServiceFileDescriptorSupplier() {}
  }

  private static final class NotificationServiceMethodDescriptorSupplier
      extends NotificationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    NotificationServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (NotificationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new NotificationServiceFileDescriptorSupplier())
              .addMethod(getUpdateMailingMethod())
              .addMethod(getGetMailingMethod())
              .addMethod(getUpdateGroupMethod())
              .addMethod(getCheckGroupMethod())
              .addMethod(getUpdateNotifyMethod())
              .addMethod(getGetNotifyMethod())
              .build();
        }
      }
    }
    return result;
  }
}
