package resume.configuration;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import java.net.InetAddress;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import java.net.UnknownHostException;

public class TestConfig {



    public void getRes() throws UnknownHostException {
        IndexRequest request = new IndexRequest("spring-data", "elasticsearch");

        System.out.println(request.getContentType());
        System.out.println(client().getRemoteClusterClient("docker-cluster2"));
    }


    @Value("${elasticsearch.home}")
    public String portName;


    Client client() throws UnknownHostException {

        TransportClient client = null;
        Settings elasticsearchSettings = Settings.builder()
                //.put("client.transport.sniff", true)
                //.put("path.home", portName)
                .put("cluster.name", "docker-cluster2").build();
        client = new PreBuiltTransportClient(elasticsearchSettings);
        client.addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9200));

        return client;

    }

}
