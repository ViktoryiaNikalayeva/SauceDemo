package tests;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {
    String make;
    String model;
    int speed;
    int fuelAmount;



}
