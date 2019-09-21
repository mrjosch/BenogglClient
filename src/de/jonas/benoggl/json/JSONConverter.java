package de.jonas.benoggl.json;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import de.jonas.benoggl.json.out.Action;
import de.jonas.benoggl.json.out.JoinRequest;
import de.jonas.benoggl.json.out.PacketOut;
import de.jonas.benoggl.json.out.Ping;


public class JSONConverter {

    public static String toJSON(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

    public static Object toObject(String message, Class obj) {
        Gson gson = new Gson();
        return gson.fromJson(message, obj);
    }

    public static Object toObject(JsonElement message, Class obj) {
        Gson gson = new Gson();
        return gson.fromJson(message, obj);
    }

    public static JsonElement toJSONElement(Object obj) {
        Gson gson = new Gson();
        return gson.toJsonTree(obj);
    }

    public static boolean isJSONValid(String jsonInString) {
        Gson gson = new Gson();
        try {
            gson.fromJson(jsonInString, Object.class);
            return true;
        } catch(com.google.gson.JsonSyntaxException ex) {
            return false;
        }
    }

    public static String getPayloadType(PacketOut packet) {
        if(packet instanceof Action) {
            return "action";
        } else if(packet instanceof JoinRequest) {
            return "joinRequest";
        } else if(packet instanceof Ping) {
            return "ping";
        }
        return null;
    }
}

