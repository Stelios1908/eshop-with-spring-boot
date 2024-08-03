package com.example.eshop.serviceImpl.item;


import com.example.eshop.entity.items.Pen;
import com.example.eshop.repository.items.PenRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PenServiceImplTest {

    @Mock
    private PenRepository penRepository;

    @InjectMocks
    private PenServiceImpl penService;


    @Test
    void getAllPen() {
        //when
        penRepository.findAll();
        // then
        verify(penRepository).findAll();
    }

    @Test
    void getPenById() {
        //when
        penRepository.findById(3L);
        //then
        verify(penRepository).findById(3L);
    }

    @Test
    void getPenByName() {
        //when
        penRepository.findByName("Tik");
        //then
        verify(penRepository).findByName("Tik");
    }

    @Test
    void saveNewPen() {

        //given
        Pen pen1 = new Pen(null, "Pen1", 1.0, "description1", 100, "color1", 1);

        //when
        penRepository.save(pen1);

        //then
        ArgumentCaptor<Pen> penArgumentCaptor  =
                ArgumentCaptor.forClass(Pen.class);

        verify(penRepository)
                .save(penArgumentCaptor.capture());

        Pen capturePen = penArgumentCaptor.getValue();

        assertThat(capturePen).isEqualTo(pen1);
        Optional<Pen> penOptional = penRepository.findByName(pen1.getName());

    }


    @Test
    void deletePen() {
        penRepository.deleteAll();

        verify(penRepository).deleteAll();
    }

    @Test
    @Disabled
    void updatePen() {
    }
}