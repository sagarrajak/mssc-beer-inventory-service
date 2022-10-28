package sagar.springproject.events;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NewInventoryEvent extends BeerEvents {
    public NewInventoryEvent(BeerRequestDto beerDto) {
        super(beerDto);
    }
}
