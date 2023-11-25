import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CountriesQueryTest {

    @Test
    public void shouldReturnStatus200() {
        given().header("Content-Type", "application/json")
                .body("{\"query\":\"query consultarPais {\\n  country(code: \\\"AR\\\"){\\n    name\\n    capital\\n    continent{\\n      code\\n    }\\n    languages{\\n      code\\n      name\\n      native\\n    }\\n    subdivisions{\\n      code\\n      emoji\\n      name\\n    }\\n  }\\n}\",\"variables\":{}}")

        .when().post("https://countries.trevorblades.com/")
        .then().assertThat().statusCode(200).log().body();
    }
}
