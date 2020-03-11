package pro.edu.security.scrt;

import com.google.common.collect.Sets;

import java.util.Set;

import static pro.edu.security.scrt.ApplicationUserPermission.*;

public enum  ApplicationUserRole {

    DOCTOR_ROLE(Sets.newHashSet()),
    ADMIN_ROLE(Sets.newHashSet(PERSON_WRITE, PERSON_WRITE));


    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }



}
