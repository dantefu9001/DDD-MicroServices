package application.gateway;


import application.concepts.Gateway;

public interface DemoGateway extends Gateway {
    String retrieveData();
    void sendData();
}
