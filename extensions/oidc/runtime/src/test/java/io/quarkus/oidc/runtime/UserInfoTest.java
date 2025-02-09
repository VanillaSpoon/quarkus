package io.quarkus.oidc.runtime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import jakarta.json.JsonArray;
import jakarta.json.JsonObject;

import org.junit.jupiter.api.Test;

import io.quarkus.oidc.UserInfo;

public class UserInfoTest {
    UserInfo userInfo = new UserInfo(
            "{"
                    + "\"name\": \"alice\","
                    + "\"admin\": true,"
                    + "\"email\": null,"
                    + "\"id\": 1234,"
                    + "\"permissions\": [\"read\", \"write\"],"
                    + "\"scopes\": {\"scope\": \"see\"}"
                    + "}");

    @Test
    public void testGetString() {
        assertEquals("alice", userInfo.getString("name"));
        assertNull(userInfo.getString("names"));
    }

    @Test
    public void testGetBoolean() {
        assertTrue(userInfo.getBoolean("admin"));
        assertNull(userInfo.getBoolean("admins"));
    }

    @Test
    public void testGetLong() {
        assertEquals(1234, userInfo.getLong("id"));
        assertNull(userInfo.getLong("ids"));
    }

    @Test
    public void testGetArray() {
        JsonArray array = userInfo.getArray("permissions");
        assertNotNull(array);
        assertEquals(2, array.size());
        assertEquals("read", array.getString(0));
        assertEquals("write", array.getString(1));
        assertNull(userInfo.getArray("permit"));
    }

    @Test
    public void testGetObject() {
        JsonObject map = userInfo.getObject("scopes");
        assertNotNull(map);
        assertEquals(1, map.size());
        assertEquals("see", map.getString("scope"));
        assertNull(userInfo.getObject("scope"));
    }

    @Test
    public void testGetNullProperty() {
        assertNull(userInfo.getString("email"));
    }
}
