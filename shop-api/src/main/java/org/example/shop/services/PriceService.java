package org.example.shop.services;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.shop.services.remote.PriceServiceApi;
import org.example.shop.store.entities.GoodEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class PriceService {

    PriceServiceApi priceServiceApi;

    public Long getPriceInRubles(GoodEntity good) {

        return priceServiceApi.getPriceInRublesByGoodId(good.getId());
    }

    public Map<Long, Long> getGoodIdToPriceInRublesMap(List<GoodEntity> goods) {

        return priceServiceApi.getGoodIdToPriceInRublesByGoodIds(
                goods.stream()
                        .map(GoodEntity::getId)
                        .toList()
        );
    }
}
