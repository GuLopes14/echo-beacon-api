package br.com.challenge.ride_echo_beacon_api.specification;
import org.springframework.data.jpa.domain.Specification;
import br.com.challenge.ride_echo_beacon_api.controller.MotoController.MotoFilter;
import br.com.challenge.ride_echo_beacon_api.model.Moto;

import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;

public class MotoSpecification {
    public static Specification<Moto> withFilters(MotoFilter filters) {
        return (root, query, criteriaBuilder) -> {
            var predicates = new ArrayList<Predicate>();

            if (filters.modelo() != null) {
                predicates.add(criteriaBuilder.equal(root.get("modelo"), filters.modelo()));
            }
            if (filters.placa() != null) {
                predicates.add(criteriaBuilder.like(root.get("placa"), "%" + filters.placa() + "%"));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}