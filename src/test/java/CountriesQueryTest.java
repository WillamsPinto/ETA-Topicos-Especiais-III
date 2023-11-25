import io.restassured.response.Response;
import org.testng.annotations.Test;
import queries.Countries;

import static io.restassured.RestAssured.given;

public class CountriesQueryTest extends BaseTest{

    @Test
    public void shouldReturnStatus200() {

        Response response = Countries.getCountryQuery("AR", requestSpec);
        response.then().assertThat().statusCode(200).log().body();
    }
}
