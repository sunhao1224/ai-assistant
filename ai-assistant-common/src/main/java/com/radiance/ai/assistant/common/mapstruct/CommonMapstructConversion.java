package com.radiance.ai.assistant.common.mapstruct;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 处理类转换
 *
 * @author smq
 * @date 2023/6/6 14:31
 * @since 1.0.0
 */
@Component
public class CommonMapstructConversion {

	@Named("getShards")
	public Integer getShards(Object settings) {
		if (settings == null) {
			return null;
		}
		JSONObject jsonObject = JSONObject.parseObject(settings.toString());
		String shards = getValueByKey(jsonObject, "number_of_shards");
		return StringUtils.isEmpty(shards) ? null : Integer.parseInt(shards);
	}

	/**
	 * 获取json中的key
	 *
	 * @author smq
	 * @date 2023/6/6 14:31
	 * @since 1.0.0
	 */
	public String getValueByKey(JSONObject jsonObject, String key) {
		for (Map.Entry<String, Object> stringObjectEntry : jsonObject.entrySet()) {
			if (stringObjectEntry.getValue() == null || StringUtils.isEmpty(stringObjectEntry.getValue().toString())) {
				continue;
			}
			if (key.equals(stringObjectEntry.getKey())) {
				return stringObjectEntry.getValue().toString();
			} else {
				if (stringObjectEntry.getValue() instanceof JSONObject){
					return getValueByKey(JSONObject.parseObject(stringObjectEntry.getValue().toString()), key);
				}
			}
		}
		return null;
	}

	@Named("getReplicas")
	public Integer getReplicas(Object settings) {
		if (settings == null) {
			return null;
		}
		JSONObject jsonObject = JSONObject.parseObject(settings.toString());
		String replicas = getValueByKey(jsonObject, "number_of_replicas");
		return StringUtils.isEmpty(replicas) ? null : Integer.parseInt(replicas);
	}

    @Named("convertObject")
    public Object convertObject(Object object) {
        if (object == null) {
            return null;
        }
        return JSONObject.parse(object.toString());
    }

    @Named("parseJsonToObject")
    public Object parseJsonToObject(String json) {
        if (json == null) {
            return null;
        }
        return JSONObject.parse(json);
    }
    @Named("getHost")
    public String getHost(String json) {
        if (json == null) {
            return null;
        }
        String ip = JSONObject.parseObject(json).getString("ip");
        String post = JSONObject.parseObject(json).getString("post");
        return ip + ":" + post;
    }
}