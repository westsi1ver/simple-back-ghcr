package org.example.simpleback.app;

import org.example.simpleback.domain.model.User;
import org.example.simpleback.domain.port.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @Test
    void createsDefaultUserWhenRepositoryIsEmpty() {
        given(userRepository.count()).willReturn(0L);
        given(userRepository.findAll()).willReturn(List.of());
        UserService userService = new UserService(userRepository);

        userService.getUsers();

        ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
        verify(userRepository).save(userCaptor.capture());
        assertThat(userCaptor.getValue().email()).isEqualTo("admin@example.com");
    }
}
