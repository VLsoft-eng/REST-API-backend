package ru.cft.template.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cft.template.api.dto.WalletDto;
import ru.cft.template.core.entity.User;
import ru.cft.template.core.entity.Wallet;
import ru.cft.template.core.exception.ServiceException;
import ru.cft.template.core.mapper.WalletMapper;
import ru.cft.template.core.repository.WalletRepository;

import static ru.cft.template.core.exception.ErrorCode.OBJECT_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class WalletService {
    private final WalletRepository walletRepository;
    private final WalletMapper walletMapper;
    private final UserService userService;

    public void create(User user) {
        Wallet wallet = new Wallet();
        wallet.setBalance(100L);
        wallet.setUser(user);
        walletRepository.save(wallet);
    }

    public WalletDto getByUserId(Long id) {

        return walletMapper.map(getByUserIdOrThrow(id));
    }

    private Wallet getByUserIdOrThrow(Long id) {
        return walletRepository.findByUserId(id)
                .orElseThrow(() -> new ServiceException(OBJECT_NOT_FOUND));
    }

}
