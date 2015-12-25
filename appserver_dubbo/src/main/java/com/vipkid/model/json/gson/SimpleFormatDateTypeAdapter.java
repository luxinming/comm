package com.vipkid.model.json.gson;

import java.lang.reflect.Type;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.vipkid.util.DateTimeUtils;

public class SimpleFormatDateTypeAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {

	@Override
	public JsonElement serialize(Date date, Type type, JsonSerializationContext context) {
		return new JsonPrimitive(DateTimeUtils.format(date, DateTimeUtils.DATETIME_FORMAT));
	}
	
	@Override
	public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
		return DateTimeUtils.parse(jsonElement.getAsString(), DateTimeUtils.DATETIME_FORMAT);
	}

}