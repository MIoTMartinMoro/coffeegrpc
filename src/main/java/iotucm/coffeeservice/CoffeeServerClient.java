/*
 * Copyright 2015 The gRPC Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package iotucm.coffeeservice;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import iotucm.coffeeservice.CapsuleConsumedReply;
import iotucm.coffeeservice.CapsuleConsumedRequest;
import iotucm.coffeeservice.MachineStatus;
import iotucm.coffeeservice.AnalysisResults;
import iotucm.coffeeservice.CoffeeServerGrpc;
import iotucm.coffeeservice.*;
import iotucm.coffeeservice.CoffeeServiceServer;

/**
 * A simple client that requests a greeting from the {@link CoffeeServerServer}.
 */
public class CoffeeServerClient {
  private static final Logger logger = Logger.getLogger(CoffeeServerClient.class.getName());

  private final ManagedChannel channel;
  private final CoffeeServerGrpc.CoffeeServerBlockingStub blockingStub;

  /** Construct client connecting to HelloWorld server at {@code host:port}. */
  public CoffeeServerClient(String host, int port) {
    this(ManagedChannelBuilder.forAddress(host, port)
        // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
        // needing certificates.
        .usePlaintext()
        .build());
  }

  /** Construct client for accessing HelloWorld server using the existing channel. */
  CoffeeServerClient(ManagedChannel channel) {
    this.channel = channel;
    blockingStub = CoffeeServerGrpc.newBlockingStub(channel);
  }

  public void shutdown() throws InterruptedException {
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }

  /** A capsule is consumed */
  public void consumeCapsule(String clientid, String type) {
    logger.info("Sending out the consumption of capsule by " + clientid + " of type "+type);
    CapsuleConsumedRequest request = CapsuleConsumedRequest.newBuilder().setClientid(clientid).setType(type).build();
    CapsuleConsumedReply response;
    try {
      response = blockingStub.consumedCapsule(request);
    } catch (StatusRuntimeException e) {
      logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
      return;
    }
    if (response.getSupplyProvisioned()!=0)
      logger.info("Result: expect a new deliver by " + response.getExpectedProvisionDate());
    else 
      logger.info("There is still coffee. Expected remaining " + response.getExpectedRemaining());
  }

  /** Information is required */
  public void askMachineStatus(  float waterTemperature, long timeConnected, float pressure){
    logger.info("Sending out the request of machine status " + waterTemperature +", "+ timeConnected +", "+ pressure);
    MachineStatus request = MachineStatus.newBuilder().setWaterTemperature(waterTemperature).setTimeConnected(timeConnected).setPressure(pressure).build();
    AnalysisResults response;
    try {
      response = blockingStub.checkMachineStatus(request);
    } catch (StatusRuntimeException e) {
      logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
      return;
    }
    if (!response.getIsFine())
      logger.info("Está todo mal");
    else 
      logger.info("Está todo bien");
  }

  /**
   * Coffee server code. The first argument is the client id, the second, the capsule type, the fourth the server ip, the fifth the port.
   */
  public static void main(String[] args) throws Exception {
    String clientid = "myclientid";
    String capsuletype= "ristretto";
    float waterTemperature = 20;
    long connectedTime = 60;
    float pressure = 470;
    int port=50051;
    String host="localhost";
    if (args.length > 0) {
      clientid = args[0]; /* First argument is the clientid */
    }
    if (args.length > 1) {
      capsuletype = args[1]; /* second argument is the capsule type */
    }
    
    if (args.length > 2) {
      waterTemperature = Float.valueOf(args[2]); /* third argument is the water temperature */      
    }

    if (args.length > 3) {
      connectedTime = Long.parseLong(args[3]); /* fourth argument is the connected time */      
    }

    if (args.length > 4) {
      pressure = Float.valueOf(args[4]); /* fifth argument is the pressure */      
    }

    if (args.length > 5) {
      host = args[5]; /* sixth argument is the host */      
    }
    
    if (args.length > 6) {
      port = Integer.parseInt(args[6]); /* seventh argument is the listening port */
    }
      
    CoffeeServerClient client = new CoffeeServerClient(host, port);
    try {      
      client.consumeCapsule(clientid,capsuletype);
      client.askMachineStatus(waterTemperature, connectedTime, pressure);
    } finally {
      client.shutdown();
    }
  }
}
