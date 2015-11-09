package br.com.alerman.material.measure;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class App implements RequestHandler<Material, Material> {

    @Override
    public Material handleRequest(Material material, Context context) {
        context.getLogger().log(String.format("\n----------------------------------------------------------------\nMaterial code: %s \n----------------------------------------------------------------\n", material.getCode()));
        
        AmazonDynamoDBClient client = new AmazonDynamoDBClient(
        		/*new ProfileCredentialsProvider()*/
        		new BasicAWSCredentials("AKIAJSZ2ZGI6XDNIZTRA","f0mRuSxILTsxj4jMjlySI4pJR4xXBibd2K1gx0XS"));

        DynamoDBMapper mapper = new DynamoDBMapper(client);
        
        mapper.save(material);
        
        Material stored = mapper.load(Material.class, material.getCode());
        
        if (stored == null) {
        	context.getLogger().log(String.format("\nMaterial code: %s NOT STORED ! \n----------------------------------------------------------------\n", material.getCode()));
        } else {
        	context.getLogger().log(String.format("\nMaterial code: %s STORED SUCESSFULL ! \n----------------------------------------------------------------\n", material.getCode()));
        }
        
        return stored;
    }

}

