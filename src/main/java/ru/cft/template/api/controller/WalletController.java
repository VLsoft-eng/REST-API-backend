package ru.cft.template.api.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import ru.cft.template.api.dto.WalletDto;
import ru.cft.template.core.service.SessionService;
import ru.cft.template.core.service.WalletService;

import static ru.cft.template.api.Paths.WALLET;

@Tag(name = "Кошельки")
@Validated
@RestController
@RequiredArgsConstructor
public class WalletController {

    private final WalletService walletService;
    private final SessionService sessionService;

    @GetMapping(WALLET)
    public WalletDto get(@RequestHeader("X-Session-Token") String token) {
        return walletService.getByUserId(sessionService.getValidSession(token).getUser().getId());
    }
}
