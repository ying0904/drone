package com.gome.cloud.utils.jackson;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * 注解方式序列化/反序列化日期类型
 * 使用时在date属性的get方法上 加上@JsonSerialize(using = JsonDateFormat.class)
 * 
 * @author yanglei-ds3
 *
 */
public class JsonDateFormat extends JsonSerializer<Date> {

	/**
	 * Jackson支持日期字符串格式
	 * "yyyy-MM-dd'T'HH:mm:ss.SSSZ" "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
	 * "EEE, dd MMM yyyy HH:mm:ss zzz" "yyyy-MM-dd"
	 */
	@Override
	public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formattedDate = formatter.format(value);
		jgen.writeString(formattedDate);
	}

}
