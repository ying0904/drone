/**
 * 
 */
package com.gome.cloud.compile.ceph;

import java.io.File;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;

/**
 * @author blaiu
 *
 */
public class CephImpl implements ICeph {
	
	private String accessKey;
	private String secretKey;
	private String host;
	private AmazonS3 conn;
	private String bucketName;

	private AmazonS3 getAmazonS3() {
		if (null == conn) {
			AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
			AmazonS3 conn = new AmazonS3Client(credentials);
			conn.setEndpoint(host);
			conn.createBucket(bucketName);
		}
		return conn;
	}
	
	@Override
	public String upLoad(File file) {
		return upLoad(file, null);
	}

	
	@Override
	public String upLoad(String filePath) {
		File file = new File(filePath);
		return upLoad(file);
	}
	
	@Override
	public String upLoad(File file, String rename) {
		String fileName = file.getName();
		if (null != rename && !"".equals(rename.trim())) {
			fileName = rename;
		}
		getAmazonS3();
		conn.putObject(new PutObjectRequest(bucketName, fileName, file).withCannedAcl(CannedAccessControlList.PublicRead));
		GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(bucketName, file.getName());
		return conn.generatePresignedUrl(request).getPath();
	}

	@Override
	public String upLoad(String filePath, String rename) {
		File file = new File(filePath);
		return upLoad(file, rename);
	}

	@Override
	public void downLoad(String fileName, String descPath) {
		File dir = new File(descPath);
		downLoad(fileName, dir);
		
	}

	@Override
	public void downLoad(String fileName, File descDir) {
		if (!descDir.exists()) {
			descDir.mkdirs();
		}
		getAmazonS3();
		conn.getObject(new GetObjectRequest(bucketName, fileName), new File(descDir, fileName));
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}
	
	

}
