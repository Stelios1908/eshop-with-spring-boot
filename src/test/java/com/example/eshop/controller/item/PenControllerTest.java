package com.example.eshop.controller.item;
import com.example.eshop.dto.item.PenDTO;
import com.example.eshop.enums.ItemTypeEnum;
import com.example.eshop.exceptions.item.itemalreadyexist.ItemAlreadyExistException;
import com.example.eshop.exceptions.item.itemnotfound.ItemNotFoundException;
import com.example.eshop.serviceImpl.item.PenServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PenControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PenServiceImpl penService;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Test the retrieval  of a Pen via /api/Pen GET endpoint
     *
     * @throws Exception if there is an error during of the execution of mock request
     *                   or if the mocking of the service layer fails
     */
    @Test
    void getPen() throws Exception {
        PenDTO penDTO = new PenDTO();
        penDTO.setName("Test Pen");

        List<PenDTO> penList = new ArrayList<>();
        penList.add(penDTO);

        given(penService.getAllPen()).willReturn(penList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/Pen")
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("stelios", "steliosPass"))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'name':'Test Pen'}]"));

    }


    /**
     * Test to retrieval of a Pen via /api/Pen/1"  GET endpoint using an id
     *
     * @throws Exception if there is an error during execution  of mock request
     *                   or if the mocking of the service layer fails
     */
    @Test
    void penById()  throws Exception{

        PenDTO PenDTO = new PenDTO();
        PenDTO.setId(1L);
        PenDTO.setName("Test Pen");

        given(penService.getPenById(1L)).willReturn(PenDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/Pen/1")
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("stelios", "steliosPass"))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{" +
                        "'name':'Test Pen'," +
                        "'id': 1 " +
                        "}"));
    }


    /**
     * Test to retrieval of a pen via /api/Pen/name  GET endpoint using a name.
     *
     * @throws Exception if there is an error during execution of mock request
     *                   *               or if the mocking of the service layer fails.
     */
    @Test
    void penName() throws Exception{
        PenDTO PenDTO = new PenDTO();
        PenDTO.setId(1L);
        PenDTO.setName("Test Pen");

        given(penService.getPenByName("Test Pen")).willReturn(PenDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/Pen/name/Test Pen")
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("stelios", "steliosPass"))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{" +
                        "'name':'Test Pen'," +
                        "'id': 1 " +
                        "}"));


    }


    /**
     * Test to retrieval of pen via /api/Pen POST endpoint
     *
     * @throws Exception if there is an error during execution of mock request
     *                   or if the mocking of service layer fails
     */
    @Test
    void savePen() throws  Exception {


        PenDTO PenDTO = new PenDTO();
        PenDTO.setName("New Pen");
        PenDTO.setCategory(ItemTypeEnum.Pen);
        PenDTO.setPrice(1.50);
        PenDTO.setDescription("A new Pen");
        PenDTO.setStock(100);
        PenDTO.setTipSize(7);

        //check if Pen is added correctly
        doNothing().when(penService).saveNewPen(PenDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/Pen")
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("stelios", "steliosPass"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(PenDTO))) // Μετατροπή του PenDTO σε JSON string
                .andExpect(status().isNoContent()); // Αναμένει status 204 No Content


        //check if the Pen already exists
        doThrow(new ItemAlreadyExistException("Item already exists")).when(penService).saveNewPen(PenDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/Pen")
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("stelios", "steliosPass"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(PenDTO)))
                .andExpect(status().isBadRequest()) // Αναμένει status 409 Conflict
                .andExpect(content().string(containsString("Item already exists")));
    }


    /**
     * Test to retrieval of Pen via /api/Pen/delete DELETE endpoint
     *
     * @throws Exception if there is an error during execution of mock request
     *                   *              or if the mocking of service layer fails
     */
    @Test
    void deletePen() throws Exception{

        Long Pen_id = 1L;

        //delete Pen correctly
        doNothing().when(penService).deletePen(Pen_id);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/Pen/delete/{id}", Pen_id)
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("stelios", "steliosPass"))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent()); // Αναμένει status 204 No Content


        //try to delete Pen but already exists
        doThrow(new ItemNotFoundException("Item not found ")).when(penService).deletePen(Pen_id);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/Pen/delete/{id}", Pen_id)
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("stelios", "steliosPass"))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound()) // Αναμένει status 409 Conflict
                .andExpect(content().string(containsString("Item not found")));

    }


    /**
     * Test to retrieval of pen via /api/Pen/update PATCH endpoint
     * @throws Exception if there is an error during execution of mock request
     *      *            or if the mocking of service layer fails
     */
    @Test
    void upDatePen() throws Exception{

        Long Pen_id = 1L;
        Double price = 2.4;
        Integer stock = 133;

        //the update  was done  correctly
        doNothing().when(penService).updatePen(Pen_id, price, stock);

        mockMvc.perform(MockMvcRequestBuilders.patch("/api/Pen/update/{id}", Pen_id)
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("stelios", "steliosPass"))
                        .param("price", price.toString())
                        .param("stock", stock.toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());


        //Pen not exist
        doThrow(new ItemNotFoundException("Pen not found ")).when(penService).updatePen(Pen_id,price,stock);

        mockMvc.perform(MockMvcRequestBuilders.patch("/api/Pen/update/{id}", Pen_id)
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("stelios", "steliosPass"))
                        .param("price", price.toString())
                        .param("stock", stock.toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString("Pen not found")));


        //Test with negative stock
        mockMvc.perform(MockMvcRequestBuilders.patch("/api/Pen/update/{id}", 1L)
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("stelios", "steliosPass"))
                        .param("price", "10.0")
                        .param("stock", "-5"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("Stock must be non-negative")));

        // Test with negative price
        mockMvc.perform(MockMvcRequestBuilders.patch("/api/Pen/update/{id}", 1L)
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("stelios", "steliosPass"))
                        .param("price", "-10.0")
                        .param("stock", "5"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("Price must be non-negative")));
    }


    //convert obj to string
    public static String asJsonString(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}