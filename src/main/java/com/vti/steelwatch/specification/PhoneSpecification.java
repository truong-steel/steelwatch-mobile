package com.vti.steelwatch.specification;

import com.vti.steelwatch.entity.Phone;
import com.vti.steelwatch.form.PhoneFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class PhoneSpecification {
    public static Specification<Phone> buildSpec(PhoneFilterForm form) {
        return form == null ? null : new Specification<Phone>() {
            @Override
            public Predicate toPredicate(Root<Phone> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                List<Predicate> predicates = new ArrayList<>();
                String search = form.getSearch();
                if (StringUtils.hasText(search)) {
                    String pattern = "%" + search.trim() + "%";
                    Predicate hasTypeLike = builder.like(root.get("type"), pattern);
                    predicates.add(hasTypeLike);
                    Predicate hasImeiLike = builder.like(root.get("imei"), pattern);
                    predicates.add(hasImeiLike);
                }
                var minCreatedDate = form.getMinCreateDate();
                if (minCreatedDate != null) {
                    var minCreatedAt = LocalDateTime.of(minCreatedDate, LocalTime.MIN);
                    var predicate = builder.greaterThanOrEqualTo(root.get("repair_date").as(LocalDateTime.class),
                            minCreatedAt);
                    predicates.add(predicate);
                }
                var maxCreatedDate = form.getMaxCreateDate();
                if (maxCreatedDate != null) {
                    var maxCreatedAt = LocalDateTime.of(maxCreatedDate, LocalTime.MAX);
                    var predicate = builder.lessThanOrEqualTo(root.get("repair_date").as(LocalDateTime.class),
                            maxCreatedAt);
                    predicates.add(predicate);
                }
                return builder.and(predicates.toArray(new Predicate[0]));
            }
        };
    }
}
