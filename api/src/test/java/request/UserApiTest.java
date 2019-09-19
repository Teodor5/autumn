package request;

import com.example.ProjectConfig;
import com.example.assertions.AssertableResponse;
import com.example.responses.TodoListResponse;
import com.example.services.UserApiService;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Stream;

import static com.example.conditions.Conditions.bodyField;
import static com.example.conditions.Conditions.statusCode;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.shouldHaveThrown;
import static org.assertj.core.api.InstanceOfAssertFactories.ARRAY;
import static org.hamcrest.Matchers.not;

/**
 * task#1
 * ---------------
 * 1. get json data from https://jsonplaceholder.typicode.com/todos
 * 2. parse it in your class
 * 3. Find all uncompleted "TODO" records for userID='9' and print it's titles into console
 * 4. verify that user with Id=1 has no more than 5 uncompleted tasks
 */


public class UserApiTest {

    private final UserApiService userApiService = new UserApiService();

    @BeforeClass
    static void setUp() {
        RestAssured.baseURI = ConfigFactory.create(ProjectConfig.class).apiPath();
    }

    @Test
    void toDosTest() {
        TodoListResponse[] responses = userApiService.getAllToDos().asPojo(TodoListResponse[].class);
        Stream.of(responses)
                .filter(response -> response.getUserId() == 9 && !response.isCompleted())
                .map(response -> "\nTitle:\n----------------------\n" + response.getTitle())
                .forEach(System.out::println);

        assertThat(Stream.of(responses)
                .filter(response -> response.getUserId() == 1 && !response.isCompleted())
                .count())
                .isLessThanOrEqualTo(5);
    }
}
