import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import queries.Countries;

public class CountriesQueryTest extends BaseTest{

    private Response response = null;

    @Test
    public void shouldReturnStatus200() {

        response = Countries.getCountryQuery("AR", requestSpec);
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void CheckReturnName(){
        response = Countries.getCountryQuery("AR", requestSpec);
        response.then().
                assertThat().
                body("data.country.name", is ("Argentina"));
    }

    @Test
    public void CheckReturnCapital(){
        response = Countries.getCountryQuery("AR", requestSpec);
        response.then().
                assertThat().
                body("data.country.capital", is ("Buenos Aires"));
    }

    @Test
    public void CheckReturnContinentCode(){
        response = Countries.getCountryQuery("AR", requestSpec);
        response.then().
                assertThat().
                body("data.country.continent.code", is ("SA"));
    }

    @Test
    public void CheckReturnFirstLanguage(){
        response = Countries.getCountryQuery("AR", requestSpec);
        response.then().
                assertThat().
                body("data.country.languages.code[0]", is ("es"));
    }

    @Test
    public void CheckReturnCountLanguage(){
        response = Countries.getCountryQuery("AR", requestSpec);
        response.then().
                assertThat().
                body("data.country.languages.size()", is (2));
    }
}
