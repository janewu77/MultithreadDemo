package Demo3;

import java.util.ArrayList;

/**
 *
 * Demo : Volatile demo : independent observations
 * @author  JaneW.
 *
 */

public class VolatileDemoIndependentObservations {

    class UserManager {

        public ArrayList<User> activeUsers = new ArrayList<User>();

        public volatile String lastUser;

        public boolean login(String user, String password) {
            boolean valid = passwordIsValid(user, password);
            if (valid) {
                User u = new User();
                activeUsers.add(u);
                lastUser = user;
            }
            return valid;
        }

        private boolean passwordIsValid(String user, String pwd){
            return true;
        }
    }

    class User {
    }

}
