package com.gome.cloud.compile.ceph;

import java.util.List;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.util.StringUtils;

public class Cep {

	public static void main(String[] args) {
		String accessKey = "U3EM08XEUE40BMR7Y7AU";
		String secretKey = "Xmn0dGOileNbF7C8ahP5jpw9atUvDDfDrJHdz7T2";
		AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

//		ClientConfiguration clientConfig = new ClientConfiguration();
//		clientConfig.setProtocol(Protocol.HTTP);

		AmazonS3 conn = new AmazonS3Client(credentials);
//		conn.setEndpoint("endpoint.com");
//		conn.setEndpoint("iaas_os_10-126-72-34");
		conn.setEndpoint("http://10.126.72.34");
//		列出buckets：
		List<Bucket> buckets = conn.listBuckets();
		for (Bucket bucket : buckets) {
		        System.out.println(bucket.getName() + "\t" +
		        		StringUtils.fromDate(bucket.getCreationDate()));
		}
	}
	
}
