package ru.cft.template.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import ru.cft.template.api.dto.UserDto;
import ru.cft.template.api.dto.WalletDto;
import ru.cft.template.core.entity.User;
import ru.cft.template.core.entity.Wallet;

@Mapper(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.WARN
)
public interface WalletMapper {

    @Mapping(target = "walletNumber", source = "id")
    @Mapping(target = "balance", source = "balance")
    WalletDto map(Wallet wallet);
}
