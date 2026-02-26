import com.ironhack.Person;
import com.ironhack.PersonRepository;
import com.ironhack.PersonsList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Tests {
    private Person person;


    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonsList personsList;

    @BeforeEach
    void setUp(){
        person = new Person(100, "Nihad Bagirzade", 20, "occupyed?");
    }

    @Test
    void setAge_zero_error(){
        assertThrows(IllegalArgumentException.class, () -> {
            person.setAge(-12);
        });
    }

    @Test
    void findByName_correctValue_correctObj(){
        when(personRepository.findByName("Nihad Bagirzade")).thenReturn(person);
        assertEquals(person ,personRepository.findByName("Nihad Bagirzade"));
    }

    @Test
    void findByName_illegalValue_error(){
        assertThrows(IllegalArgumentException.class, () -> {
            personsList.findByName("fEFWSEFS");
        });
    }

    @Test
    void clone_correctValues_sameObj(){
        Person clonedPerson = personsList.clone(person);
        assertEquals(person, clonedPerson);
    }

}
