package com.example.bankapp.BusinessLogic;

import android.content.Context;

import com.example.bankapp.DataAccess.Models.Account;
import com.example.bankapp.DataAccess.Models.User;
import com.example.bankapp.DataAccess.Repository.UserRepository;

public class LoginController {
    public boolean login(Context context, int id, int password){
        UserRepository userRepository=new UserRepository();
        User user= userRepository.getUserByID(context, id);

        return validateuser(user, id, password);

    }

    private boolean validateuser(User user, int id, int password) {
        if (user.getPassword()!=password){
            return false;
        }else {
            return true;
        }
    }
}
