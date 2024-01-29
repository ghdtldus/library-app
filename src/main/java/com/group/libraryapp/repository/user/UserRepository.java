package com.group.libraryapp.repository.user;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

//SQL을 사용해 실제 DB(유저 저장소.)와의 통신을 담당
@Repository
public class UserRepository {

    private  final  JdbcTemplate jdbcTemplate;
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    //create
    public void saveUser(String name, Integer age){
        String sql = "INSERT INTO user (name, age) VALUES (?,?)";
        jdbcTemplate.update(sql, name,age);
    }


    //Read
    public List <UserResponse> getUsers(){
        String sql="SELECT * FROM  user";
        return jdbcTemplate.query(sql, (rs,rowNum) -> {
            long id = rs.getLong("id");
            String name=rs.getString("name");
            int age=rs.getInt("age");
            return new UserResponse(id,name,age);
        });
    }


    //U
    //주어진 유저 id를 받고, jdbcTemplete를 사용해서
    //그 유저가 있는지 확인 -> true, 없으면 -> false
    public boolean isUserNotExist(long id){
        String realSql = "SELECT * FROM user WHERE id=?";
        return jdbcTemplate.query(realSql, (rs, rowNum) -> 0, id).isEmpty();
    }
    //jdbc템플릿을 사용해 유저 이름을 변경한다. 업데이트된 이름, 어떤 id의 유저를 변경할지.
    public void updateUserName(String name, long id){
        String sql = "UPDATE user SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, name, id);
    }


    //D
    public boolean isUserNotExist(String name){
        String realSql = "SELECT * FROM user WHERE name=?";
        return jdbcTemplate.query(realSql, (rs, rowNum) -> 0,name).isEmpty();
    }
    public void deleteUser(String name){
        String sql = "DELETE FROM user WHERE name = ?";
        jdbcTemplate.update(sql, name);
    }

}
