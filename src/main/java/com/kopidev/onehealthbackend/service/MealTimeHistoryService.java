package com.kopidev.onehealthbackend.service;

import com.kopidev.onehealthbackend.dto.MealTimeHistoryDTO;
import com.kopidev.onehealthbackend.entity.MealTime;
import com.kopidev.onehealthbackend.entity.MealTimeHistory;
import com.kopidev.onehealthbackend.repository.MealTimeHistoryRepository;
import com.kopidev.onehealthbackend.repository.MealTimeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service @AllArgsConstructor
public class MealTimeHistoryService {

    MealTimeRepository mealTimeRepo;
    MealTimeHistoryRepository mealTimeHistoRepo;

    private List<MealTimeHistoryDTO> createMealTimeHistoryDTO (long nutritionalId) {

        // Se obtiene los mealtimes por nutritionalID
        List<MealTime> mealTimes = mealTimeRepo.findAllByNutritionalPlanId(nutritionalId);


        LocalDate currentDate = LocalDate.now();
        long currentMillis = currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();

        // Se obtienen los mealtimesHistory relacionados con ese nutritionalID y que sea del dia de hoy
        List<MealTimeHistory> mealTimesHistory = mealTimeHistoRepo.findByNutritionalPlanId(nutritionalId)
                .stream().filter(m -> m.getDate() >= currentMillis &&
                        m.getDate() < currentMillis + 86_400_000)
                .collect(Collectors.toList());

        List<MealTimeHistoryDTO> result = new ArrayList<>();

        // se mapea la info de las dos entidades en el MealTimeHistoryDTO
        for(MealTime m: mealTimes){
            MealTimeHistoryDTO mealDTO = new MealTimeHistoryDTO();
            mealDTO.mealTimeId = m.getMealId();
            mealDTO.mealType = m.getMealType();
            mealDTO.hour = m.getHour();
            mealDTO.idealcalories = m.getCalories();

            for(MealTimeHistory mh: mealTimesHistory){
                if(mh.getMealTime().getMealId() == m.getMealId()){
                    mealDTO.mealTimeHistoryId = mh.getId();
                    mealDTO.totalCalories = mh.getTotalCalories();
                    mealDTO.date = mh.getDate();
                    mealDTO.foods = mh.getFoods();
                }
            }
            result.add(mealDTO);
        }
        return result;
    }


    public List<MealTimeHistoryDTO> getMealTimeHistoryByNutritionalId(long nutritionalId){
        return createMealTimeHistoryDTO(nutritionalId);
    }

    public MealTimeHistory saveMealTimeHistory(MealTimeHistory mealTimeHistory){
        return this.mealTimeHistoRepo.save(mealTimeHistory);
    }

}
