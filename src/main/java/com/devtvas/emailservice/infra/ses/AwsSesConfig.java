package com.devtvas.emailservice.infra.ses;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.auth.BasicAWSCredentials;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

@Configuration
public class AwsSesConfig {

    @Bean
    public AmazonSimpleEmailService amazonSimpleEmailService() {
        return AwsSesConfig.getClient();
        // return AmazonSimpleEmailServiceClientBuilder.standard().build();
    }

    public static AmazonSimpleEmailService getClient() {
        AmazonSimpleEmailService sesClient = null;
        try {
            Properties properties = new Properties();

            // Carregando o arquivo application.properties usando FileInputStream
            FileInputStream fis = new FileInputStream("src/main/resources/application.properties");
            properties.load(fis);
            fis.close();

            // Acessando propriedades específicas
            String accessKey = properties.getProperty("aws.accessKeyId");
            String secretKey = properties.getProperty("aws.secretKey");
            String region = properties.getProperty("aws.region");

            // Crie uma instância de BasicAWSCredentials com suas credenciais
            BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);

            // Construa o cliente do Amazon SES
            sesClient = AmazonSimpleEmailServiceClientBuilder.standard()
                    .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                    .withRegion(Regions.US_EAST_1) // Substitua pela região desejada
                    .build();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sesClient;
    }
}
