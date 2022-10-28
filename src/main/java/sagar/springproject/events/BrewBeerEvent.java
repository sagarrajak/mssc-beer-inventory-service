package sagar.springproject.events;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BrewBeerEvent extends BeerEvents {
    public BrewBeerEvent(BeerRequestDto beerDto) {
        super(beerDto);
    }
}
