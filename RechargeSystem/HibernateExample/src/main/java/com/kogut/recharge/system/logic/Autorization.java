package com.kogut.recharge.system.logic;

import com.kogut.recharge.system.dao.UserDao;
import com.kogut.recharge.system.tables.User;

/**
 * Created by Slava on 25.03.2015.
 */
public class Autorization {

    public static void autorize(String email, String password){
        User userToSearch = new User(email, password);
        User client = UserDao.selectUser(userToSearch);
        if(client == null){
            System.out.println("Неправильно введены емэйл или пароль. Повторите попытку еще раз.");
            return;
        }
        if("A".equals(client.getStatus())) {
            System.out.println("Открыть страницу для администратора");
        }else{
            System.out.println("Открыть страницу для клиента");
        }

    }

    public static void registration(String email, String password){
        String id = IdGenerator.getAlertId();
        User userForRegister = new User(id, email, password, "C");
        UserDao.addUser(userForRegister);
        System.out.println("Открыть страницу для клиента");
    }

    public static void main(String[] args) {
//        autorize("slava_kogut@bk.ru", "Slavchik13");
        registration("olya_kogut@bk.ru", "ololo");
    }

}
