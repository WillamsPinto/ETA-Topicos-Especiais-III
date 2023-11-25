package queries;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Countries {

    public static Response getCountryQuery(String countryCode, RequestSpecification requestSpec){
        return given().spec(requestSpec)
                        .body("{\"query\":\"query consultarPais {\\n  country(code: \\\""+countryCode+"\\\"){\\n    name\\n    capital\\n    continent{\\n      code\\n    }\\n    languages{\\n      code\\n      name\\n      native\\n    }\\n    subdivisions{\\n      code\\n      emoji\\n      name\\n    }\\n  }\\n}\",\"variables\":{}}")
                        .when().post();
    }

}
