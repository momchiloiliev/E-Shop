package mk.ukim.finki.emt.eshop.repository;

import mk.ukim.finki.emt.eshop.model.Role;
import mk.ukim.finki.emt.eshop.model.User;
import mk.ukim.finki.emt.eshop.model.exceptions.UserNotFoundException;
import mk.ukim.finki.emt.eshop.model.projections.UserProjection;
import org.checkerframework.common.value.qual.StaticallyExecutable;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindAll(){
        List<User> userList = this.userRepository.findAll();
        Assert.assertEquals(1L, userList.size());
    }

    @Test
    public void testFetch(){
        List<User> userList = this.userRepository.fetchAll();
        Assert.assertEquals(1L, userList.size());
    }

    @Test
    public void testLoadAll(){
        List<User> userList = this.userRepository.loadAll();
        Assert.assertEquals(1L, userList.size());
    }

    @Test
    public void takeUsernameAndNameAndSurnameByProjection(){
        UserProjection userProjection = this.userRepository.findByRole(Role.ROLE_ADMIN);
        Assert.assertEquals("mi", userProjection.getUsername());
        Assert.assertEquals("momchilo", userProjection.getName());
        Assert.assertEquals("iliev", userProjection.getSurname());
    }

    @Test
    public void testOptimisticLock(){
        User user1 = this.userRepository.findByUsername("mi").orElseThrow(()-> new UserNotFoundException("mi"));
        User user2 = this.userRepository.findByUsername("mi").orElseThrow(()-> new UserNotFoundException("mi"));

        user1.setName("user1");
        user2.setName("user2");

        this.userRepository.save(user1);
        this.userRepository.save(user2);



    }
}
