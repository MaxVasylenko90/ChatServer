package ua.kiev.prog;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UsersBase {
    private static Map<String, String> users = new HashMap<>();

    static {
        users.put("max", "123");
        users.put("max2", "123qwe");
    }

    public synchronized static boolean add(User user) {
        if (users.containsKey(user.getLogin()))
            return false;
        else {
            users.put(user.getLogin(), user.getPass());
            return true;
        }
    }

    public static Map<String, String> getUsers() {
        return users;
    }

    public static String getAllUsersName() {
        Set usersLogins = users.keySet();
        String users = usersLogins.toString();
        return users;

//        Gson gson = new GsonBuilder().create();
//        String json = gson.toJson(usersLogins);
//        return json;
    }


}
