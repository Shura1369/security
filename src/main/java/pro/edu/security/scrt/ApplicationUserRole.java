package pro.edu.security.scrt;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static pro.edu.security.scrt.ApplicationUserPermission.*;

public enum  ApplicationUserRole {

    PERSON(Sets.newHashSet()),
    DOCTOR(Sets.newHashSet(PERSON_READ)),
    ADMIN(Sets.newHashSet(PERSON_WRITE, PERSON_READ, DOCTOR_READ, DOCTOR_WRITE));


    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }


    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
        final Set<SimpleGrantedAuthority> permissions = this.getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
