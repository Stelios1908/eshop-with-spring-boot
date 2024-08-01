package com.example.eshop.controller.item;

import com.example.eshop.dto.item.PencilDTO;
import com.example.eshop.enums.ItemTypeEnum;
import com.example.eshop.exceptions.item.itemalreadyexist.ItemAlreadyExistException;
import com.example.eshop.exceptions.item.itemnotfound.ItemNotFoundException;
import com.example.eshop.serviceImpl.item.PencilServiceImpl;
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

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PencilControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PencilServiceImpl pencilService;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Test the retrieval  of a Pencil via /api/Pencil GET endpoint
     *
     * @throws Exception if there is an error during of the execution of mock request
     *                   or if the mocking of the service layer fails
     */
    @Test
    void getPencil() throws Exception {
        PencilDTO pencilDTO = new PencilDTO();
        pencilDTO.setName("Test Pencil");

        List<PencilDTO> pencilList = new ArrayList<>();
        pencilList.add(pencilDTO);

        given(pencilService.getAllPencil()).willReturn(pencilList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/Pencil")
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("stelios", "steliosPass"))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'name':'Test Pencil'}]"));

    }

    /**
     * Test to retrieval of a Pencil via /api/Pencil/1"  GET endpoint using an id
     *
     * @throws Exception if there is an error during execution  of mock request
     *                   or if the mocking of the service layer fails
     */
    @Test
    void penById() throws Exception {

        PencilDTO pencilDTO = new PencilDTO();
        pencilDTO.setId(1L);
        pencilDTO.setName("Test Pencil");

        given(pencilService.getPencilById(1L)).willReturn(pencilDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/Pencil/1")
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("stelios", "steliosPass"))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{" +
                        "'name':'Test Pencil'," +
                        "'id': 1 " +
                        "}"));
    }


    /**
     * Test to retrieval of a pencil via /api/Pencil/name  GET endpoint using a name.
     *
     * @throws Exception if there is an error during execution of mock request
     *                   *               or if the mocking of the service layer fails.
     */
    @Test
    void pencilName() throws Exception {

        PencilDTO pencilDTO = new PencilDTO();
        pencilDTO.setId(1L);
        pencilDTO.setName("Test Pencil");

        given(pencilService.getPencilByName("Test Pencil")).willReturn(pencilDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/Pencil/name/Test Pencil")
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("stelios", "steliosPass"))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{" +
                        "'name':'Test Pencil'," +
                        "'id': 1 " +
                        "}"));

    }


    /**
     * Test to retrieval of pencil via /api/Pencil POST endpoint
     *
     * @throws Exception if there is an error during execution of mock request
     *                   or if the mocking of service layer fails
     */
    @Test
    void savePencil() throws Exception {

        PencilDTO pencilDTO = new PencilDTO();
        pencilDTO.setName("New Pencil");
        pencilDTO.setCategory(ItemTypeEnum.Pencil);
        pencilDTO.setPrice(1.50);
        pencilDTO.setDescription("A new pencil");
        pencilDTO.setStock(100);
        pencilDTO.setTipSize(7);
        pencilDTO.setType(1);

        //check if pencil is added correctly
        doNothing().when(pencilService).saveNewPencil(pencilDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/Pencil")
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("stelios", "steliosPass"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(pencilDTO))) // Μετατροπή του pencilDTO σε JSON string
                .andExpect(status().isNoContent()); // Αναμένει status 204 No Content


        //check if the pencil already exists
        doThrow(new ItemAlreadyExistException("Item already exists")).when(pencilService).saveNewPencil(pencilDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/Pencil")
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("stelios", "steliosPass"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(pencilDTO)))
                .andExpect(status().isBadRequest()) // Αναμένει status 409 Conflict
                .andExpect(content().string(containsString("Item already exists")));

    }

    /**
     * Test to retrieval of pencil via /api/Pencil/delete DELETE endpoint
     *
     * @throws Exception if there is an error during execution of mock request
     *                   *              or if the mocking of service layer fails
     */
    @Test
    void deletePencil() throws Exception {

        Long pencil_id = 1L;

        //delete pencil correctly
        doNothing().when(pencilService).deletePencil(pencil_id);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/Pencil/delete/{id}", pencil_id)
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("stelios", "steliosPass"))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent()); // Αναμένει status 204 No Content


        //try to delete pencil but already exists
        doThrow(new ItemNotFoundException("Item not found ")).when(pencilService).deletePencil(pencil_id);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/Pencil/delete/{id}", pencil_id)
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("stelios", "steliosPass"))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound()) // Αναμένει status 409 Conflict
                .andExpect(content().string(containsString("Item not found")));

    }


    /**
     * Test to retrieval of pencil via /api/Pencil/update PATCH endpoint
     * @throws Exception if there is an error during execution of mock request
     *      *            or if the mocking of service layer fails
     */
    @Test
    void upDatePencil() throws Exception {

        Long pencil_id = 1L;
        Double price = 2.4;
        Integer stock = 133;

        //the update  was done  correctly
        doNothing().when(pencilService).updatePencil(pencil_id, price, stock);

        mockMvc.perform(MockMvcRequestBuilders.patch("/api/Pencil/update/{id}", pencil_id)
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("stelios", "steliosPass"))
                        .param("price", price.toString())
                        .param("stock", stock.toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());


        //Pencil not exist
        doThrow(new ItemNotFoundException("Pencil not found ")).when(pencilService).updatePencil(pencil_id,price,stock);

        mockMvc.perform(MockMvcRequestBuilders.patch("/api/Pencil/update/{id}", pencil_id)
                        .with(SecurityMockMvcRequestPostProcessors.httpBasic("stelios", "steliosPass"))
                        .param("price", price.toString())
                        .param("stock", stock.toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString("Pencil not found")));
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