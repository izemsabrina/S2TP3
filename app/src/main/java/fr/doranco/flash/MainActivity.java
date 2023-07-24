package fr.doranco.flash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import fr.doranco.flash.dao.DaoFactory;
import fr.doranco.flash.entity.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       User user1 = new User("Johen", "Doe");
        User user2 = new User("Jane", "Doe");
        User user3 = new User("Mary", "Doe");
        DaoFactory daoFactory = DaoFactory.getInstance(this);
        // creationn en bd
        Log.i("Log-bd","<--------Test creation ------->");
        daoFactory.getUserDao().create(user1);
        daoFactory.getUserDao().create(user2);
        daoFactory.getUserDao().create(user3);
        // lister les users
        Log.i("Log-bd",daoFactory.getUserDao().findAll().toString());
        user1=daoFactory.getUserDao().findById(1);
        user1.setName("John updated");
        daoFactory.getUserDao().update(user1);
        //delete
        user3=daoFactory.getUserDao().findById(3);
        daoFactory.getUserDao().delete(user3);
        //lister les users
        Log.i("Log-bd",daoFactory.getUserDao().findAll().toString());
    }
}