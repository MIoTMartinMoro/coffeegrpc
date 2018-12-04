package iotucm.coffeeservice;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * The cofee machine service definition
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.16.1)",
    comments = "Source: coffeeserver.proto")
public final class CoffeeServerGrpc {

  private CoffeeServerGrpc() {}

  public static final String SERVICE_NAME = "coffeeserver.CoffeeServer";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<iotucm.coffeeservice.CapsuleConsumedRequest,
      iotucm.coffeeservice.CapsuleConsumedReply> getConsumedCapsuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "consumedCapsule",
      requestType = iotucm.coffeeservice.CapsuleConsumedRequest.class,
      responseType = iotucm.coffeeservice.CapsuleConsumedReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<iotucm.coffeeservice.CapsuleConsumedRequest,
      iotucm.coffeeservice.CapsuleConsumedReply> getConsumedCapsuleMethod() {
    io.grpc.MethodDescriptor<iotucm.coffeeservice.CapsuleConsumedRequest, iotucm.coffeeservice.CapsuleConsumedReply> getConsumedCapsuleMethod;
    if ((getConsumedCapsuleMethod = CoffeeServerGrpc.getConsumedCapsuleMethod) == null) {
      synchronized (CoffeeServerGrpc.class) {
        if ((getConsumedCapsuleMethod = CoffeeServerGrpc.getConsumedCapsuleMethod) == null) {
          CoffeeServerGrpc.getConsumedCapsuleMethod = getConsumedCapsuleMethod = 
              io.grpc.MethodDescriptor.<iotucm.coffeeservice.CapsuleConsumedRequest, iotucm.coffeeservice.CapsuleConsumedReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "coffeeserver.CoffeeServer", "consumedCapsule"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  iotucm.coffeeservice.CapsuleConsumedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  iotucm.coffeeservice.CapsuleConsumedReply.getDefaultInstance()))
                  .setSchemaDescriptor(new CoffeeServerMethodDescriptorSupplier("consumedCapsule"))
                  .build();
          }
        }
     }
     return getConsumedCapsuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<iotucm.coffeeservice.MachineStatus,
      iotucm.coffeeservice.AnalysisResults> getCheckMachineStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "checkMachineStatus",
      requestType = iotucm.coffeeservice.MachineStatus.class,
      responseType = iotucm.coffeeservice.AnalysisResults.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<iotucm.coffeeservice.MachineStatus,
      iotucm.coffeeservice.AnalysisResults> getCheckMachineStatusMethod() {
    io.grpc.MethodDescriptor<iotucm.coffeeservice.MachineStatus, iotucm.coffeeservice.AnalysisResults> getCheckMachineStatusMethod;
    if ((getCheckMachineStatusMethod = CoffeeServerGrpc.getCheckMachineStatusMethod) == null) {
      synchronized (CoffeeServerGrpc.class) {
        if ((getCheckMachineStatusMethod = CoffeeServerGrpc.getCheckMachineStatusMethod) == null) {
          CoffeeServerGrpc.getCheckMachineStatusMethod = getCheckMachineStatusMethod = 
              io.grpc.MethodDescriptor.<iotucm.coffeeservice.MachineStatus, iotucm.coffeeservice.AnalysisResults>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "coffeeserver.CoffeeServer", "checkMachineStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  iotucm.coffeeservice.MachineStatus.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  iotucm.coffeeservice.AnalysisResults.getDefaultInstance()))
                  .setSchemaDescriptor(new CoffeeServerMethodDescriptorSupplier("checkMachineStatus"))
                  .build();
          }
        }
     }
     return getCheckMachineStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CoffeeServerStub newStub(io.grpc.Channel channel) {
    return new CoffeeServerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CoffeeServerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CoffeeServerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CoffeeServerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CoffeeServerFutureStub(channel);
  }

  /**
   * <pre>
   * The cofee machine service definition
   * </pre>
   */
  public static abstract class CoffeeServerImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Informs  a capsule was consumed
     * </pre>
     */
    public void consumedCapsule(iotucm.coffeeservice.CapsuleConsumedRequest request,
        io.grpc.stub.StreamObserver<iotucm.coffeeservice.CapsuleConsumedReply> responseObserver) {
      asyncUnimplementedUnaryCall(getConsumedCapsuleMethod(), responseObserver);
    }

    /**
     * <pre>
     * Check machine status
     * </pre>
     */
    public void checkMachineStatus(iotucm.coffeeservice.MachineStatus request,
        io.grpc.stub.StreamObserver<iotucm.coffeeservice.AnalysisResults> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckMachineStatusMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getConsumedCapsuleMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                iotucm.coffeeservice.CapsuleConsumedRequest,
                iotucm.coffeeservice.CapsuleConsumedReply>(
                  this, METHODID_CONSUMED_CAPSULE)))
          .addMethod(
            getCheckMachineStatusMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                iotucm.coffeeservice.MachineStatus,
                iotucm.coffeeservice.AnalysisResults>(
                  this, METHODID_CHECK_MACHINE_STATUS)))
          .build();
    }
  }

  /**
   * <pre>
   * The cofee machine service definition
   * </pre>
   */
  public static final class CoffeeServerStub extends io.grpc.stub.AbstractStub<CoffeeServerStub> {
    private CoffeeServerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CoffeeServerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CoffeeServerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CoffeeServerStub(channel, callOptions);
    }

    /**
     * <pre>
     * Informs  a capsule was consumed
     * </pre>
     */
    public void consumedCapsule(iotucm.coffeeservice.CapsuleConsumedRequest request,
        io.grpc.stub.StreamObserver<iotucm.coffeeservice.CapsuleConsumedReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getConsumedCapsuleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Check machine status
     * </pre>
     */
    public void checkMachineStatus(iotucm.coffeeservice.MachineStatus request,
        io.grpc.stub.StreamObserver<iotucm.coffeeservice.AnalysisResults> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCheckMachineStatusMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The cofee machine service definition
   * </pre>
   */
  public static final class CoffeeServerBlockingStub extends io.grpc.stub.AbstractStub<CoffeeServerBlockingStub> {
    private CoffeeServerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CoffeeServerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CoffeeServerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CoffeeServerBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Informs  a capsule was consumed
     * </pre>
     */
    public iotucm.coffeeservice.CapsuleConsumedReply consumedCapsule(iotucm.coffeeservice.CapsuleConsumedRequest request) {
      return blockingUnaryCall(
          getChannel(), getConsumedCapsuleMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Check machine status
     * </pre>
     */
    public iotucm.coffeeservice.AnalysisResults checkMachineStatus(iotucm.coffeeservice.MachineStatus request) {
      return blockingUnaryCall(
          getChannel(), getCheckMachineStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The cofee machine service definition
   * </pre>
   */
  public static final class CoffeeServerFutureStub extends io.grpc.stub.AbstractStub<CoffeeServerFutureStub> {
    private CoffeeServerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CoffeeServerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CoffeeServerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CoffeeServerFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Informs  a capsule was consumed
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<iotucm.coffeeservice.CapsuleConsumedReply> consumedCapsule(
        iotucm.coffeeservice.CapsuleConsumedRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getConsumedCapsuleMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Check machine status
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<iotucm.coffeeservice.AnalysisResults> checkMachineStatus(
        iotucm.coffeeservice.MachineStatus request) {
      return futureUnaryCall(
          getChannel().newCall(getCheckMachineStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CONSUMED_CAPSULE = 0;
  private static final int METHODID_CHECK_MACHINE_STATUS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CoffeeServerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CoffeeServerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CONSUMED_CAPSULE:
          serviceImpl.consumedCapsule((iotucm.coffeeservice.CapsuleConsumedRequest) request,
              (io.grpc.stub.StreamObserver<iotucm.coffeeservice.CapsuleConsumedReply>) responseObserver);
          break;
        case METHODID_CHECK_MACHINE_STATUS:
          serviceImpl.checkMachineStatus((iotucm.coffeeservice.MachineStatus) request,
              (io.grpc.stub.StreamObserver<iotucm.coffeeservice.AnalysisResults>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CoffeeServerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CoffeeServerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return iotucm.coffeeservice.CoffeeServerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CoffeeServer");
    }
  }

  private static final class CoffeeServerFileDescriptorSupplier
      extends CoffeeServerBaseDescriptorSupplier {
    CoffeeServerFileDescriptorSupplier() {}
  }

  private static final class CoffeeServerMethodDescriptorSupplier
      extends CoffeeServerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CoffeeServerMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CoffeeServerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CoffeeServerFileDescriptorSupplier())
              .addMethod(getConsumedCapsuleMethod())
              .addMethod(getCheckMachineStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
