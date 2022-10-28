package sagar.springproject.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BeerEvents implements Serializable {
    public final Long serialVersionUID = -234893948L;
    private BeerRequestDto beerDto;
}
