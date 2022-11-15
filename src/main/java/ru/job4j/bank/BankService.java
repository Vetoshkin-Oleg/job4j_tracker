package ru.job4j.bank;

import java.util.*;

/**
 * Класс для создания банковского сервиса
 *  @author Vetoshkin Oleg
 *  @version 1.0
 */
public class BankService {
    /**
     * Переменная users хранит пользователей банковской системы со списком счетов каждого пользователя
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     *
     * @param user
     * В перечень пользователей банковской системы добавляем нового, но только в случае его отсутствия.
     * Вновь добавленному пользователю назначаем пустой список счетов.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     *
     * @param passport ФИО пользователя банковской системы.
     * @param account счет, который будет принадлежать пользователю.
     * Если пользователь найден по ФИО и у него нет счета account,
     *                то включим данный счет в перечень всех счетов пользователя users.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = users.get(user);
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            destAccount.setBalance(destAccount.getBalance() + amount);
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }
}