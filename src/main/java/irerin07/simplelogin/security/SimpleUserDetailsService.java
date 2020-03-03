package irerin07.simplelogin.security;

import irerin07.simplelogin.domain.User;
import irerin07.simplelogin.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SimpleUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        User user = userRepository.findById()
        User user = userRepository.getUserByEmail(s);
        if(user == null){
            throw new UsernameNotFoundException("유저를 찾을 수 없습니다.");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        SimpleUser simpleUser = new SimpleUser(user.getUsername(), user.getPasswd(), authorities);
        simpleUser.setId(user.getId());
        simpleUser.setEmail(user.getEmail());
        return simpleUser;
    }
}
