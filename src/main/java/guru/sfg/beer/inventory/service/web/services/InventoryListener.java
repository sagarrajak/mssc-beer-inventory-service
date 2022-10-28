package guru.sfg.beer.inventory.service.web.services;

import guru.sfg.beer.inventory.service.config.JmsConfig;
import guru.sfg.beer.inventory.service.domain.BeerInventory;
import guru.sfg.beer.inventory.service.repositories.BeerInventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import sagar.springproject.events.BeerRequestDto;
import sagar.springproject.events.NewInventoryEvent;

import javax.transaction.Transactional;

@Slf4j
@RequiredArgsConstructor
@Component
public class InventoryListener {

    private final BeerInventoryRepository beerInventoryRepository;
    @Transactional
    @JmsListener(destination = JmsConfig.JMS_INVENTORY_QUEUE)
    public void listen(NewInventoryEvent newInventoryEvent) {
        log.debug(newInventoryEvent.toString());
        BeerRequestDto beerDto = newInventoryEvent.getBeerDto();
        beerInventoryRepository.save(
                BeerInventory.builder()
                        .upc(beerDto.getUpc())
                        .beerId(beerDto.getId())
                        .quantityOnHand(beerDto.getQuantityOnHand())
                        .build());
    }
}
