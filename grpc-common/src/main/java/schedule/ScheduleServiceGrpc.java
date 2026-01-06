package schedule;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.59.0)",
    comments = "Source: api/schedule_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ScheduleServiceGrpc {

  private ScheduleServiceGrpc() {}

  public static final String SERVICE_NAME = "schedule.ScheduleService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<edu.java.grpc.schedule.GetScheduleRequest,
      edu.java.grpc.common.ScheduleResponse> getGetScheduleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSchedule",
      requestType = edu.java.grpc.schedule.GetScheduleRequest.class,
      responseType = edu.java.grpc.common.ScheduleResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.java.grpc.schedule.GetScheduleRequest,
      edu.java.grpc.common.ScheduleResponse> getGetScheduleMethod() {
    io.grpc.MethodDescriptor<edu.java.grpc.schedule.GetScheduleRequest, edu.java.grpc.common.ScheduleResponse> getGetScheduleMethod;
    if ((getGetScheduleMethod = ScheduleServiceGrpc.getGetScheduleMethod) == null) {
      synchronized (ScheduleServiceGrpc.class) {
        if ((getGetScheduleMethod = ScheduleServiceGrpc.getGetScheduleMethod) == null) {
          ScheduleServiceGrpc.getGetScheduleMethod = getGetScheduleMethod =
              io.grpc.MethodDescriptor.<edu.java.grpc.schedule.GetScheduleRequest, edu.java.grpc.common.ScheduleResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSchedule"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.java.grpc.schedule.GetScheduleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.java.grpc.common.ScheduleResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ScheduleServiceMethodDescriptorSupplier("GetSchedule"))
              .build();
        }
      }
    }
    return getGetScheduleMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ScheduleServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ScheduleServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ScheduleServiceStub>() {
        @Override
        public ScheduleServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ScheduleServiceStub(channel, callOptions);
        }
      };
    return ScheduleServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ScheduleServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ScheduleServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ScheduleServiceBlockingStub>() {
        @Override
        public ScheduleServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ScheduleServiceBlockingStub(channel, callOptions);
        }
      };
    return ScheduleServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ScheduleServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ScheduleServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ScheduleServiceFutureStub>() {
        @Override
        public ScheduleServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ScheduleServiceFutureStub(channel, callOptions);
        }
      };
    return ScheduleServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getSchedule(edu.java.grpc.schedule.GetScheduleRequest request,
        io.grpc.stub.StreamObserver<edu.java.grpc.common.ScheduleResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetScheduleMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ScheduleService.
   */
  public static abstract class ScheduleServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return ScheduleServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ScheduleService.
   */
  public static final class ScheduleServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ScheduleServiceStub> {
    private ScheduleServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ScheduleServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ScheduleServiceStub(channel, callOptions);
    }

    /**
     */
    public void getSchedule(edu.java.grpc.schedule.GetScheduleRequest request,
        io.grpc.stub.StreamObserver<edu.java.grpc.common.ScheduleResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetScheduleMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ScheduleService.
   */
  public static final class ScheduleServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ScheduleServiceBlockingStub> {
    private ScheduleServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ScheduleServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ScheduleServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public edu.java.grpc.common.ScheduleResponse getSchedule(edu.java.grpc.schedule.GetScheduleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetScheduleMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ScheduleService.
   */
  public static final class ScheduleServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ScheduleServiceFutureStub> {
    private ScheduleServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ScheduleServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ScheduleServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.java.grpc.common.ScheduleResponse> getSchedule(
        edu.java.grpc.schedule.GetScheduleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetScheduleMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_SCHEDULE = 0;

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
        case METHODID_GET_SCHEDULE:
          serviceImpl.getSchedule((edu.java.grpc.schedule.GetScheduleRequest) request,
              (io.grpc.stub.StreamObserver<edu.java.grpc.common.ScheduleResponse>) responseObserver);
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
          getGetScheduleMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              edu.java.grpc.schedule.GetScheduleRequest,
              edu.java.grpc.common.ScheduleResponse>(
                service, METHODID_GET_SCHEDULE)))
        .build();
  }

  private static abstract class ScheduleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ScheduleServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return edu.java.grpc.schedule.ScheduleServiceOuterClass.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ScheduleService");
    }
  }

  private static final class ScheduleServiceFileDescriptorSupplier
      extends ScheduleServiceBaseDescriptorSupplier {
    ScheduleServiceFileDescriptorSupplier() {}
  }

  private static final class ScheduleServiceMethodDescriptorSupplier
      extends ScheduleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ScheduleServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ScheduleServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ScheduleServiceFileDescriptorSupplier())
              .addMethod(getGetScheduleMethod())
              .build();
        }
      }
    }
    return result;
  }
}
