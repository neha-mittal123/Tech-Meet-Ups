package com.atmecs.techMeetUp.Handler;

import java.io.IOException;
import java.sql.Timestamp;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;


public class jsonTimeDeserializer extends  JsonDeserializer<Timestamp>  {

	@Override
	public Timestamp deserialize(JsonParser arg0, DeserializationContext arg1)
			throws IOException, JsonProcessingException {
				
		return null;
	}

}
