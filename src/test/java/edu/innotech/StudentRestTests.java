package edu.innotech;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class StudentRestTests {

    private static final String BASE_URL = "http://localhost:8080";

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = BASE_URL;
    }

    @Test
    @DisplayName("GET /student/{id} - возвращает 404 для несуществующего студента")
    public void getNonExistent() {
        given()
                .when()
                .get("/student/9999")
                .then()
                .statusCode(404);
    }

    @Test
    @DisplayName("POST /student - добавление нового студента")
    public void postStudent() {
        String studentJson = "{\"id\": 1, \"name\": \"Кирилл\", \"marks\": [5, 4, 5]}";

        given()
                .contentType(ContentType.JSON)
                .body(studentJson)
                .when()
                .post("/student")
                .then()
                .statusCode(201);

        given()
                .when()
                .get("/student/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("name", equalTo("Кирилл"))
                .body("marks", hasSize(3));

        given()
                .when()
                .delete("/student/1")
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("GET /student/{id} - возвращает студента по ID")
    public void getStudentById() {
        String studentJson = "{\"id\": 1, \"name\": \"Кирилл\", \"marks\": [5, 4, 5]}";
        given().contentType(ContentType.JSON).body(studentJson).post("/student");

        given()
                .when()
                .get("/student/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("name", not(emptyOrNullString()))
                .body("marks", notNullValue());

        given()
                .when()
                .delete("/student/1")
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("POST /student - обновление существующего студента")
    public void postStudentUpdates() {
        String studentJson = "{\"id\": 1, \"name\": \"Кирилл\", \"marks\": [5, 4, 5]}";
        given().contentType(ContentType.JSON).body(studentJson).post("/student");

        String updatedStudentJson = "{\"id\": 1, \"name\": \"Кирилл Губарев\", \"marks\": [5, 5, 5, 4]}";

        given()
                .contentType(ContentType.JSON)
                .body(updatedStudentJson)
                .when()
                .post("/student")
                .then()
                .statusCode(201);

        given()
                .when()
                .get("/student/1")
                .then()
                .statusCode(200)
                .body("name", equalTo("Кирилл Губарев"))
                .body("marks", hasSize(4));

        given()
                .when()
                .delete("/student/1")
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("POST /student - добавление с автоматическим ID")
    public void postStudentWithNullId() {
        String studentJson = "{\"id\": null, \"name\": \"Кирилл\", \"marks\": [3, 4, 5]}";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(studentJson)
                .when()
                .post("/student");

        response.then()
                .statusCode(201);

        String responseBody = response.getBody().asString();
        int studentId = Integer.parseInt(responseBody.trim());

        given()
                .pathParam("id", studentId)
                .when()
                .delete("/student/{id}")
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("POST /student - возвращает 400 при пустом имени")
    public void postStudentWithEmptyName() {
        String invalidStudentJson = "{\"id\": 2, \"name\": null\"\", \"marks\": [5, 4, 5]}";

        given()
                .contentType(ContentType.JSON)
                .body(invalidStudentJson)
                .when()
                .post("/student")
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("DELETE /student/{id} - удаление существующего студента")
    public void deleteStudent() {
        String studentJson = "{\"id\": 1, \"name\": \"Кирилл\", \"marks\": [5, 4, 5]}";
        given().contentType(ContentType.JSON).body(studentJson).post("/student");

        given()
                .when()
                .delete("/student/1")
                .then()
                .statusCode(200);

        given()
                .when()
                .get("/student/1")
                .then()
                .statusCode(404);
    }

    @Test
    @DisplayName("DELETE /student/{id} - возвращает 404 для несуществующего студента")
    public void deleteNonExistentStudent() {
        given()
                .pathParam("id", 9999)
                .when()
                .delete("/student/{id}")
                .then()
                .statusCode(404);
    }

    @Test
    @DisplayName("GET /topStudent - пустой ответ при отсутствии студентов")
    public void getTopStudentReturnsEmptyWhenNoStudent() {
        given()
                .when()
                .get("/topStudent")
                .then()
                .statusCode(200)
                .body(emptyOrNullString());
    }

    @Test
    @DisplayName("GET /topStudent - пустой ответ при отсутствии оценок")
    public void getTopStudentReturnsEmptyNoMarks() {
        String studentJson = "{\"id\": 1, \"name\": \"Без оценок\", \"marks\": []}";
        given().contentType(ContentType.JSON).body(studentJson).post("/student");

        given()
                .when()
                .get("/topStudent")
                .then()
                .statusCode(200)
                .body(emptyOrNullString());

        given()
                .when()
                .delete("/student/1")
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("GET /topStudent - возвращает одного лучшего студента")
    public void getTopStudentReturnsSingleBestStudent() {

        String student1Json = "{\"id\": 1, \"name\": \"Лучший\", \"marks\": [5, 5, 5]}";
        String student2Json = "{\"id\": 2, \"name\": \"Хороший\", \"marks\": [4, 4, 4]}";
        given().contentType(ContentType.JSON).body(student1Json).post("/student");
        given().contentType(ContentType.JSON).body(student2Json).post("/student");

        given()
                .when()
                .get("/topStudent")
                .then()
                .body("", hasSize(1))
                .body("[0].id", equalTo(1));

        given().delete("/student/1").then().statusCode(200);
        given().delete("/student/2").then().statusCode(200);
    }
    @Test
    @DisplayName("GET /topStudent - возвращает одного лучшего студента (одинаковые средние, разное количество оценок)")
    public void getTopStudentReturnsSingleBestStudentDifferentNumberOfMarks() {

        String student1Json = "{\"id\": 1, \"name\": \"Лучший\", \"marks\": [5, 5, 5, 5]}";
        String student2Json = "{\"id\": 2, \"name\": \"Хороший\", \"marks\": [5, 5, 5]}";
        given().contentType(ContentType.JSON).body(student1Json).post("/student");
        given().contentType(ContentType.JSON).body(student2Json).post("/student");

        given()
                .when()
                .get("/topStudent")
                .then()
                .body("", hasSize(1))
                .body("[0].id", equalTo(1));

        given().delete("/student/1").then().statusCode(200);
        given().delete("/student/2").then().statusCode(200);
    }

    @Test
    @DisplayName("GET /topStudent - возвращает нескольких студентов при равных условиях")
    public void getTopStudentReturnsMultiple() {
        String student1Json = "{\"id\": 1, \"name\": \"Первый\", \"marks\": [5, 5, 5]}";
        String student2Json = "{\"id\": 2, \"name\": \"Второй\", \"marks\": [5, 5, 5]}";
        given().contentType(ContentType.JSON).body(student1Json).post("/student");
        given().contentType(ContentType.JSON).body(student2Json).post("/student");

        given().when().get("/topStudent")
                .then()
                .statusCode(200)
                .body("", hasSize(2));

        given().delete("/student/1").then().statusCode(200);
        given().delete("/student/2").then().statusCode(200);
    }
}