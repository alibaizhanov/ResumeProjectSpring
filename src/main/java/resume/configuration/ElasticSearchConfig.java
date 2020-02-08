package resume.configuration;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.client.Client;
import java.net.UnknownHostException;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.elasticsearch.common.transport.TransportAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import java.net.InetAddress;

@Configuration
@EnableElasticsearchRepositories("resume.repository.search")
public class ElasticSearchConfig {


    @Value("${elasticsearch.home}")
    private String elasticSearchHome;

    /**
     * http://docs.spring.io/autorepo/docs/spring/4.2.5.RELEASE/spring-framework-reference/html/beans.html
     *
     * By default, beans defined using Java config that have a public close or shutdown method are automatically enlisted with a destruction callback.
     */

    @Bean
    Client client() throws UnknownHostException{

        TransportClient client = null;
        Settings elasticsearchSettings = Settings.builder()
                //.put("client.transport.sniff", true)
               // .put("path.home", elasticSearchHome)
                .put("cluster.name", "new_master").build();
        client = new PreBuiltTransportClient(elasticsearchSettings);
        client.addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));

        return client;
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws UnknownHostException{
        return new ElasticsearchTemplate(client());
    }


}
