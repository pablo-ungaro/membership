package com.br.membership.consts;

import com.br.membership.model.Role;
import lombok.Getter;

@Getter
public enum DefaultRole {

    DEVELOPER("19686e94-7e18-11ed-a1eb-0242ac120002", "Developer", "DEVELOPER") {
        @Override
        public Role getRole() {
            return Role.builder().id(DefaultRole.DEVELOPER.getId())
                    .description(DefaultRole.DEVELOPER.getDescription())
                    .value(DefaultRole.DEVELOPER.getValue()).build();
        }
    },
    PRODUCT_OWNER("2470450a-7e18-11ed-a1eb-0242ac120002", "Product Owner", "PRODUCT_OWNER") {
        @Override
        public Role getRole() {
            return Role.builder().id(DefaultRole.PRODUCT_OWNER.getId())
                    .description(DefaultRole.PRODUCT_OWNER.getDescription())
                    .value(DefaultRole.PRODUCT_OWNER.getValue()).build();
        }
    },
    TESTER("2a77ba32-7e18-11ed-a1eb-0242ac120002", "Tester", "TESTER") {
        @Override
        public Role getRole() {
            return Role.builder().id(DefaultRole.TESTER.getId())
                    .description(DefaultRole.TESTER.getDescription())
                    .value(DefaultRole.TESTER.getValue()).build();
        }
    };

    private final String id;
    private final String description;
    private final String value;


    DefaultRole(String id, String description, String value) {
        this.id = id;
        this.description = description;
        this.value = value;
    }

    public abstract Role getRole();
}
