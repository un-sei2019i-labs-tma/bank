package com.example.bankapp.BusinessLogic;

<<<<<<< HEAD
public class LoginController {
=======
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
>>>>>>> dccdc4ceef6458ebc63b453a7a17e2e7d7566b24
}
