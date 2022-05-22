package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user: users) {
            if (login.equals(user.getUsername())) {
                return user;
            }
        }
        throw new UserNotFoundException();
    }

    public static boolean validate(User user) throws UserInvalidException {
        return user.isValid() && user.getUsername().length() >= 3;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        User user = null;
        try {
            user = findUser(users, "Petr Arsentev");
        } catch (UserNotFoundException | NullPointerException e) {
            System.out.println("Пользователь не найден");
        }
        try {
            assert user != null;
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException | NullPointerException e) {
            System.out.println("Пользователь не валидный");
        }
    }
}