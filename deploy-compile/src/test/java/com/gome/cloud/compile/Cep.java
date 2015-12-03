package com.gome.cloud.compile;

import java.io.File;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class Cep {

	public static void main(String[] args) {
		String accessKey = "6EXC5VOGU56PGC0JEZM9";
		String secretKey = "ShUbCZdApMhGJ9Cpr1wBGBzpIBFhbTJ81kmRu7Dz";
		AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

//		ClientConfiguration clientConfig = new ClientConfiguration();
//		clientConfig.setProtocol(Protocol.HTTP);

		AmazonS3 conn = new AmazonS3Client(credentials);
//		conn.setEndpoint("endpoint.com");
//		conn.setEndpoint("iaas_os_10-126-72-34");
		conn.setEndpoint("http://10.126.72.34");
//		列出buckets：
		
		
//		List<Bucket> buckets = conn.listBuckets();
//		for (Bucket bucket : buckets) {
//		        System.out.println(bucket.getName() + "\t" +
//		        		StringUtils.fromDate(bucket.getCreationDate()));
//		}
		Bucket bucket = conn.createBucket("deploy.gome.com.cn");
		File file = new File("D:\\zookeeper-3.4.6.tar.gz");          
		conn.putObject(new PutObjectRequest(bucket.getName(), file.getName(), file).withCannedAcl(CannedAccessControlList.PublicRead));
//		conn.setObjectAcl(bucket.getName(), file.getName(), CannedAccessControlList.Private);
		GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(bucket.getName(), file.getName());
		System.out.println(conn.generatePresignedUrl(request));
		System.out.println(file.getName());
		conn.getObject(new GetObjectRequest(bucket.getName(), file.getName()), new File("D:\\app\\"+file.getName()));

	}
	
	
	
}
