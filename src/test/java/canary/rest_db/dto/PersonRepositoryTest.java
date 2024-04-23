package canary.rest_db.dto;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PersonRepositoryTest {
  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private PersonRepository personRepository;

  static String insertJson;
  static String updateJson;
  static JSONObject iO;
  static JSONObject uO;

  @BeforeAll
  static void setting() throws JSONException {
    insertJson = """
      {
        "firstName": "Frodo",
        "lastName": "Baggins"
      }""";

    updateJson = """
      {
        "firstName": "Bilbo",
        "lastName": "Baggins"
      }""";

    iO = new JSONObject(insertJson);
    uO = new JSONObject(updateJson);
  }

  @BeforeEach
  public void deleteAllBeforeTests() throws Exception {
    personRepository.deleteAll();
  }

  @Test
  public void shouldReturnRepositoryIndex() throws Exception {

    mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(
      jsonPath("$._links.people").exists());
  }

  @Test
  public void shouldCreateEntity() throws Exception {

    mockMvc.perform(post("/people").content(insertJson))
      .andExpect(status().isCreated())
      .andExpect(header().string("Location", containsString("people/")));
  }

  @Test
  public void shouldRetrieveEntity() throws Exception {

    MvcResult mvcResult = mockMvc.perform(
      post("/people").content(insertJson))
      .andExpect(status().isCreated())
      .andReturn();

    String location = mvcResult.getResponse().getHeader("Location");

    mockMvc.perform(get(location))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.firstName").value(iO.getString("firstName")))
      .andExpect(jsonPath("$.lastName").value(iO.getString("lastName")));
  }

  @Test
  public void shouldQueryEntity() throws Exception {

    mockMvc.perform(
      post("/people").content(insertJson))
      .andExpect(status().isCreated());

    mockMvc.perform(
      get("/people/search/findByLastName?name={name}", iO.getString("lastName")))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$._embedded.people[0].firstName").value(iO.getString("firstName")));
  }

  @Test
  public void shouldUpdateEntity() throws Exception {
    MvcResult mvcResult = mockMvc.perform(post("/people").content(
      insertJson)).andExpect(
      status().isCreated()).andReturn();

    String location = mvcResult.getResponse().getHeader("Location");

    mockMvc.perform(put(location).content(updateJson))
      .andExpect(status().isNoContent());

    mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
      jsonPath("$.firstName").value(uO.getString("firstName"))).andExpect(
      jsonPath("$.lastName").value(uO.getString("lastName")));
  }

  @Test
  public void shouldPartiallyUpdateEntity() throws Exception {

    MvcResult mvcResult = mockMvc.perform(
      post("/people").content(insertJson))
      .andExpect(status().isCreated()).andReturn();

    String location = mvcResult.getResponse().getHeader("Location");

    mockMvc.perform(
      patch(location).content("{\"firstName\": \"Bilbo Jr.\"}"))
      .andExpect(status().isNoContent());

    mockMvc.perform(get(location)).andExpect(status().isOk())
      .andExpect(jsonPath("$.firstName").value("Bilbo Jr."))
      .andExpect(jsonPath("$.lastName").value(iO.getString("lastName")));
  }

  @Test
  public void shouldDeleteEntity() throws Exception {

    MvcResult mvcResult = mockMvc.perform(post("/people").content(
      "{ \"firstName\": \"Bilbo\", \"lastName\":\"Baggins\"}")).andExpect(
      status().isCreated()).andReturn();

    String location = mvcResult.getResponse().getHeader("Location");
    mockMvc.perform(delete(location)).andExpect(status().isNoContent());

    mockMvc.perform(get(location)).andExpect(status().isNotFound());
  }
}