package fr.doranco.flash.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import fr.doranco.flash.entity.User;
/**
 * Operatios en BD sur le entity User
 * */

@Dao
public interface UserDao {

    @Insert
    void create (User user);

    @Query("SELECT * FROM users")
    List<User> findAll();

    @Update
    void update(User user);
     @Delete
    void  delete(User user);

     @Query("SELECT *FROM users WHERE id=:id")
     User findById(int id );
}
